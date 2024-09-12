package JdbcCrudOperation;
import java.sql.*;
public class Assignment13 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        String query="SELECT prod_category, AVG(price) FROM product_info GROUP BY prod_category HAVING AVG(price)<10000 AND prod_category != 'Furniture';";

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin123");
            stmt= con.createStatement();
            rs=stmt.executeQuery(query);
            boolean found=false;
            System.out.println("Category        Average Price ");
            System.out.println("===================================================================");

            while(rs.next())
            {
                found=true;
                System.out.println(rs.getString(1)+"\t\t\t"+rs.getInt(2));
            }
            if (!found)
            {
                System.out.println("records are not available");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
