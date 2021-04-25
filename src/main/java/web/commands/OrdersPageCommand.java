package web.commands;

import business.entities.Basket;
import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrderFacade;
import business.services.OrderLineFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OrdersPageCommand extends CommandProtectedPage{

    public OrdersPageCommand(String pageToShow, String role) {
        super(pageToShow, role);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        OrderFacade orderFacade = new OrderFacade(database);
        OrderLineFacade orderLineFacade = new OrderLineFacade(database);

        HttpSession session = request.getSession();

        List<Order> orderList = orderFacade.getAllOrders();

        session.setAttribute("orderList", orderList);

        return pageToShow;

    }
}
