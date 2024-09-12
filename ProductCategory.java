package JdbcCrudOperation;

import java.sql.*;

public class ProductCategory {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "SELECT prod_category, COUNT(*) FROM product_info GROUP BY prod_category HAVING COUNT(*) >1 ORDER BY COUNT(*) DESC";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin@123");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            boolean found = false;
            System.out.println("Category        Total Itom ");
            System.out.println("===================================================================");
            while (rs.next()) {
                found = true;
                System.out.println(rs.getString("prod_category")+"\t\t\t"+rs.getInt("count(*)"));
            }
            if (!found) {
                System.out.println("Product Category Not Found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
