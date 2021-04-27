package web.commands;

import business.entities.Basket;
import business.entities.BasketItem;
import business.entities.Order;
import business.entities.Orderline;
import business.exceptions.UserException;
import business.persistence.UserMapper;
import business.services.OrderFacade;
import business.services.OrderLineFacade;
import business.services.ToppingsFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderConfirmationCommand extends CommandProtectedPage {

    public OrderConfirmationCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        OrderFacade orderFacade = new OrderFacade(database);
        OrderLineFacade orderLineFacade = new OrderLineFacade(database);
        UserFacade userFacade = new UserFacade(database);

        HttpSession session = request.getSession();

       String email = (String) session.getAttribute("email");


        int userId = userFacade.getUserId(email);

        Basket basket = (Basket) session.getAttribute("basket");
        List<BasketItem> basketItemList = basket.getBasketItemList();

        int totalPrice = basket.totalSum();

        Order order = new Order(userId, totalPrice);

        order = orderFacade.insertOrder(order);

        int orderId = order.getOrder_id();

        for (BasketItem basketItem : basketItemList) {

            orderLineFacade.insertOrderLine(new Orderline(orderId, basketItem.getTopping().getToppings_id(), basketItem.getBase().getBases_id(), basketItem.getAmount(), basketItem.getPrice()));

        }




        return pageToShow;
    }
}
