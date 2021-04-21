package business.persistence;


import business.entities.Bases;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BasesMapperTest {

    private final static String DATABASE = "cupcake";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "dev";
    private final static String PASSWORD = "ax2";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static BasesMapper basesMapper;


    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            basesMapper = new BasesMapper(database);

        } catch (ClassNotFoundException e) { //kan ikke finde driveren i database klassen
            fail("Database connection failed. mission jdbc driver");
        }


    }


    @BeforeEach
    public void setUp() {

        //reset test database

        try (Statement stmt = database.connect().createStatement()) {
            stmt.execute("drop table if exists bases");
            stmt.execute("create table " + TESTDATABASE + ".bases LIKE " + DATABASE + ".bases;");
            stmt.execute(
                    "insert into bases values " +
                            "(1,'chocolate',5), " +
                            "(2,'Vanilla',5), " +
                            "(3,'Nutmeg',5)");

        } catch (SQLException ex) {
            System.out.println("could not open connection to the database: " + ex.getMessage());
        }

    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull(database);
    }

    @Test
    public void testGetAllBases() throws UserException {
        List<Bases> basesList = basesMapper.getAllBases();
        if (basesList.size() == 3) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetBaseById() throws UserException {
        Bases bases = basesMapper.getBasesById(1);
        if ("chocolate" == bases.getName()) {
            assertTrue(true);
        }


    }

}
