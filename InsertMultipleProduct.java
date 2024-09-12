package JdbcCrudOperation;

import java.sql.*;

public class InsertMultipleProduct {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        String query="Insert into product_info values(0,'pen',100,'Stationary')";
        String query2="Insert into product_info values(0,'bag',500,'Stationary')";

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin@123");
            stmt=con.createStatement();
            stmt.executeUpdate(query);
            stmt.executeUpdate(query2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
