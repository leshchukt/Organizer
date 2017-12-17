import org.junit.Test;
import ua.training.view.DBConnectionConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ConnectionTest implements DBConnectionConstants{
    @Test
    public void connect() {
        try {
            DriverManager.getConnection(
                    URLDBConnection,
                    UserDBConnection,
                    PasswordDBConnection);
        } catch (SQLException e) {
            fail("No connection with DB " + URLDBConnection + "for user " + UserDBConnection);
        }
    }

}