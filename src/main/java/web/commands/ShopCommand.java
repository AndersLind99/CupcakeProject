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
        int amount;

        bottom = request.getParameter("bottom");
        topping = request.getParameter("topping");

        if (request.getParameter("amount") == null) {
            amount = 0;

        } else {
            try {
                amount = Integer.parseInt(request.getParameter("Amount"));
            } catch (NumberFormatException ex) {

                throw new UserException("husk at du skal indtaste heltal");
            }
        }

        int price = 0;

        request.setAttribute("bottom", bottom);
        request.setAttribute("topping", topping);
        request.setAttribute("amount", amount);
        request.setAttribute("price", price);


        return pageToShow;
    }
}
