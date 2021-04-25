package business.services;

import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.util.List;

public class OrderFacade {

    private OrderMapper orderMapper;

    private OrderFacade(Database database){

        this.orderMapper = new OrderMapper(database);

    }

    public List<Order> getAllOrders() throws UserException {

        return orderMapper.getAllOrders();

    }

    public Order getOrderById(int id) throws UserException {

        return orderMapper.getOrderById(id);


    }

    public Order insertOrder (Order order) throws UserException {

        return orderMapper.insertOrder(order);


    }

    public boolean deleteOrder(int id) throws UserException {

        return orderMapper.deleteOrder(id);

    }

}
