package business.persistence;

//TODO make toppingsMapper


import business.entities.Bases;
import business.entities.Toppings;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToppingsMapper {


    private Database database;

    public ToppingsMapper(Database database) {
        this.database = database;

    }

    public List<Toppings> getAllToppings() throws UserException {

        List<Toppings> toppingsList = new ArrayList<>();

        String sql = "select * from toppings";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int toppings_id = rs.getInt("toppings_id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    toppingsList.add(new Toppings(toppings_id, name, price));

                }

            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }

        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }
        return toppingsList;

    }

    public Toppings getToppingsById(int toppingsId) throws UserException {
        Toppings toppings = null;
        String sql = "select * from toppings where toppings_id = ?";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, toppingsId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int toppings_id = rs.getInt("toppings_id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    toppings = new Toppings(toppings_id, name, price);

                }

            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }


        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }

        return toppings;
    }


}
