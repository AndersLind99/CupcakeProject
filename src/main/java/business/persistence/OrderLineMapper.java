package business.persistence;

//TODO lav orderLine mapper


import business.entities.Orderline;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderLineMapper {

    private Database database;


    public OrderLineMapper(Database database) {
        this.database = database;

    }

    public List<Orderline> getAllOrderLines() throws UserException {

        List<Orderline> orderlineList = new ArrayList<>();

        String sql = "select * from orderline";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderLine_id = rs.getInt("orderLine_id");
                    int order_id = rs.getInt("order_id");
                    int toppings_id = rs.getInt("toppings_id");
                    int bases_id = rs.getInt("bases_id");
                    int sum = rs.getInt("sum");
                    int quantity = rs.getInt("quantity");

                    orderlineList.add(new Orderline(orderLine_id, order_id, toppings_id, bases_id, sum, quantity));

                }

            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }

        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }
        return orderlineList;

    }

    public Orderline getOrderLineById(int orderLineId) throws UserException {
        Orderline orderline = null;
        String sql = "select * from orderline where orderLine_id = ?";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderLineId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int orderLine_id = rs.getInt("orderLine_id");
                    int order_id = rs.getInt("order_id");
                    int toppings_id = rs.getInt("toppings_id");
                    int bases_id = rs.getInt("bases_id");
                    int sum = rs.getInt("sum");
                    int quantity = rs.getInt("quantity");

                    orderline = new Orderline(orderLine_id, order_id, toppings_id, bases_id, sum, quantity);

                }

            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }


        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }

        return orderline;
    }

    public Orderline insertOrderLine(Orderline orderline) throws UserException {
        boolean result = false;
        int newId = 0;
        String sql = "insert into orderline (orderLine_id,order_id,toppings_id,bases_id,sum,quantity) values (?,?,?,?,?,?)";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, orderline.getOrderLine_id());
                ps.setInt(2, orderline.getOrder_id());
                ps.setInt(3, orderline.getToppings_id());
                ps.setInt(4, orderline.getBases_id());
                ps.setInt(5, orderline.getSum());
                ps.setInt(6, orderline.getQuantity());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                }
                ResultSet idResultset = ps.getGeneratedKeys();
                if (idResultset.next()) {
                    newId = idResultset.getInt(1);
                    orderline.setOrderLine_id(newId);
                } else {
                    orderline = null;
                }
            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }


        return orderline;
    }


}
