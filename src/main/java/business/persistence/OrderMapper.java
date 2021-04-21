package business.persistence;

//TODO lav orderMapper så vi kan oprette og se vores ordre

import business.entities.Order;
import business.entities.Orderline;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    private Database database;

    public OrderMapper(Database database) {
        this.database = database;

    }

    public List<Order> getAllOrders() throws UserException {

        List<Order> orderList = new ArrayList<>();

        String sql = "select * from orders";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    int user_id = rs.getInt("user_id");
                    int price = rs.getInt("price");
                    String date = rs.getString("date");

                    orderList.add(new Order(order_id, user_id, price, date));

                }

            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }

        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }
        return orderList;

    }

    public Order getOrderById(int orderId) throws UserException {
        Order order = null;
        String sql = "select * from orders where order_id = ?";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    int user_id = rs.getInt("user_id");
                    int price = rs.getInt("price");
                    String date = rs.getString("date");

                    order = new Order(order_id, user_id, price, date);

                }

            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }


        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }

        return order;
    }

    public Order insertOrder(Order order) throws UserException {
        boolean result = false;
        int newId = 0;
        String sql = "insert into orders (order_id, user_id, price) values (?,?,?)";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, order.getOrder_id());
                ps.setInt(2, order.getUser_id());
                ps.setInt(3, order.getPrice());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                }
                ResultSet idResultset = ps.getGeneratedKeys();
                if (idResultset.next()) {
                    newId = idResultset.getInt(1);
                    order.setOrder_id(newId);
                } else {
                    order = null;
                }
            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }


        return order;
    }

    public boolean deleteOrder(int orderId) throws UserException {
        boolean result = false;
        String sql = "delete from orders where order_id = ?";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                }

            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }


        } catch (SQLException exception) {
            throw new UserException("connection to database could not be established");


        }
        return result;
    }

}
