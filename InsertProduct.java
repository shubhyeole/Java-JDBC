package JDBCSteps;

import java.sql.*;

public class InsertProduct {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        String query="insert into product_info values(2,'Mobile',360)";

        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin123");
            stmt=conn.createStatement();
            stmt.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(conn!=null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt!=null)
            {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
