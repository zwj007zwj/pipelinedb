import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

    static final String HOST = "192.168.200.28";
    static final String DATABASE = "postgres";
    static final String USER = "postgres";
    static final String PASSWORD = "postgres";

    static Connection getConnection () throws SQLException {
        String url = "jdbc:postgresql://" + HOST + ":5432/" + DATABASE;
        Properties props = new Properties();

        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);
        return DriverManager.getConnection(url, props);
    }


}
