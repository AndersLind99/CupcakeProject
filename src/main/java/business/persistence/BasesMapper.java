package business.persistence;


import business.entities.Bases;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BasesMapper {

    private Database database;

    public BasesMapper(Database database) {
        this.database = database;

    }

    public List<Bases> getAllBases() throws UserException {

        List<Bases> basesList = new ArrayList<>();

        String sql = "select * from bases";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int bases_id = rs.getInt("bases_id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    basesList.add(new Bases(bases_id, name, price));

                }

            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }

        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }
        return basesList;

    }

    public Bases getBasesById(int basesId) throws UserException {
        Bases bases = null;
        String sql = "select * from bases where bases_id = ?";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, basesId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int bases_id = rs.getInt("bases_id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    bases = new Bases(bases_id, name, price);

                }

            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }


        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }

        return bases;
    }




}
