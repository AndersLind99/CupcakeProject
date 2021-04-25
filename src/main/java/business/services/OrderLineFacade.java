package business.services;

import business.entities.Orderline;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderLineMapper;

import java.util.List;

public class OrderLineFacade {

    private OrderLineMapper orderLineMapper;

    public OrderLineFacade(Database database){

        this.orderLineMapper = new OrderLineMapper(database);

    }

    public List<Orderline> getAllOrderLines() throws UserException {

        return orderLineMapper.getAllOrderLines();

    }

    public Orderline getOrderLineById(int id) throws UserException {

        return orderLineMapper.getOrderLineById(id);

    }

    public void insertOrderLine(Orderline orderline) throws UserException {

        orderLineMapper.insertOrderLine(orderline);

    }


}
