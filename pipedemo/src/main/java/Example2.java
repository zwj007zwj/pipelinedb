import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example2 {

    public static void main(String[] args) throws SQLException {
        Connection conn = DbConnection.getConnection();
        ResultSet rs;
        Statement stmt = conn.createStatement();
    }

}
