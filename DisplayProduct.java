package JDBCSteps;

import java.sql.*;

public class DisplayProduct {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        String query="Select * from product_info";

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin@123");
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            System.out.println("Product ID      Product Name        Product Price");
            while (rs.next())
            {
                System.out.println(rs.getInt("prod_id")+"\t\t\t"+rs.getString("prod_name")+"\t\t\t"+rs.getDouble("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(con!=null)
            {
                try {
                    con.close();
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
            if (rs!=null)
            {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
