import java.sql.*;

public class Example {

    public static void main(String[] args) throws SQLException {

        Connection conn = DbConnection.getConnection();
        ResultSet rs;
        Statement stmt = conn.createStatement();

        /**
         * 创建流及流视图
         */
/*        stmt.executeUpdate(
                "CREATE FOREIGN TABLE stream (x integer) SERVER pipelinedb");
        stmt.executeUpdate(
                "CREATE VIEW v WITH (action=materialize) AS SELECT x::integer, COUNT(*) FROM stream  WHERE arrival_timestamp > clock_timestamp() - interval '1 minutes' GROUP BY x");*/

        /**
         * 向流中插入数据
         */
        for (int i=0; i<1000; i++)
        {
            // 10 unique groupings
            int x = i%4;
            // INSERT INTO stream (x) VALUES (x)
            stmt.addBatch("INSERT INTO stream (x) VALUES (" + Integer.toString(x) + ")");
        }
        stmt.executeBatch();

        /**
         * 查询流视图
         */
        rs = stmt.executeQuery("SELECT * FROM v");
        while (rs.next())
        {
            int id = rs.getInt("x");
            int count = rs.getInt("count");
            System.out.println(id + " = " + count);
        }

        /**
         * 删除流和流视图
         */
/*        stmt.executeUpdate("DROP VIEW v");
        stmt.executeUpdate("DROP FOREIGN TABLE stream");*/
        conn.close();
    }
}