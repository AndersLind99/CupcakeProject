package web.commands;

import business.entities.Bases;
import business.entities.Basket;
import business.entities.BasketItem;
import business.entities.Toppings;
import business.exceptions.UserException;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BasketCommand extends CommandUnprotectedPage {

    public BasketCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int toppingsId;
        int basesId;
        int amount;

        if (request.getParameter("bases") != null) {

            try {
                toppingsId = Integer.parseInt(request.getParameter("toppings"));
                basesId = Integer.parseInt(request.getParameter("bases"));
                amount = Integer.parseInt(request.getParameter("amount"));
            } catch (NumberFormatException ex) {

                throw new UserException("fejl i indtasing på forsiden");
            }

            List<Toppings> toppingsList = (List<Toppings>) request.getServletContext().getAttribute("toppingsList");
            List<Bases> basesList = (List<Bases>) request.getServletContext().getAttribute("basesList");


            HttpSession session = request.getSession();

            Basket basket = (Basket) session.getAttribute("basket");

            if (basket == null) {

                basket = new Basket();

            }

            Toppings toppings = getToppingFromId(toppingsList, toppingsId);
            Bases bases = getBasesFromId(basesList, basesId);
            BasketItem basketItem = new BasketItem(bases, toppings, amount);

            basket.addToBasket(basketItem);

            session.setAttribute("basket", basket);
        }

        return pageToShow;
    }

    private Toppings getToppingFromId(List<Toppings> toppingsList, int toppingId) {

        for (Toppings toppings : toppingsList) {
            if (toppings.getToppings_id() == toppingId) {
                return toppings;

            }
        }
        return null;
    }

    private Bases getBasesFromId(List<Bases> basesList, int basesId) {

        for (Bases bases : basesList) {
            if (bases.getBases_id() == basesId) {
                return bases;

            }
        }
        return null;
    }

}
