package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShopCommand extends CommandUnprotectedPage {

    public ShopCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

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


        int price = 0;

        request.setAttribute("bottom", bottom);
        request.setAttribute("topping", topping);
        request.setAttribute("amount", amount);
        request.setAttribute("price", price);


        return pageToShow;
    }
}
