package business.persistence;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.fail;

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
}

@BeforeEach
public  void setUp(){

    //reset test database


}
