package JdbcCrudOperation;

import java.sql.*;


public class PreparedStament {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement stmt=null;
        String query="Insert into product_info values(?,?,?,?)";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin@123");
           stmt=con.prepareStatement(query);
           stmt.setInt(1,0);
           stmt.setString(2,"notebook");
           stmt.setDouble(3,150);
           stmt.setString(4,"Stationary");
           stmt.executeUpdate();stmt.setInt(1,0);
           stmt.setString(2,"Book");
           stmt.setDouble(3,200);
           stmt.setString(4,"Stationary");
           stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
