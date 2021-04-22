package web.commands;

import business.exceptions.UserException;
import business.services.BasesFacade;
import business.services.ShopCalc;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShopCommand extends CommandProtectedPage {
    ShopCalc shopCalc;



    public ShopCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.shopCalc = new ShopCalc(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {




        String bottom;
        String topping;
        String amountTemp;
        int amount;

        bottom = request.getParameter("bottom");
        topping = request.getParameter("topping");
        amountTemp = request.getParameter("amount");

        if (amountTemp == null || amountTemp == "") {
            amount = 0;
        } else amount = Integer.parseInt(amountTemp);

        //Calculate the total price.

        int price = 0;




        try {
            price = shopCalc.totalPrice(bottom, topping, amount);
        } catch (UserException ex) {
            new UserException(ex.getMessage());
        }


        request.setAttribute("bottom", bottom);
        request.setAttribute("topping", topping);
        request.setAttribute("amount", amount);
        request.setAttribute("price", price);



        return pageToShow;
    }
}
