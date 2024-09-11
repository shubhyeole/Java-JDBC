package JDBCSteps;
import java.sql.*;
import java.util.Scanner;

public class DisplayCategory {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Connection con=null;
        Statement stmt=null;
        ResultSet rs= null;
        System.out.println("Enter the Product Category");
        String category=sc.next();
        String query="Select prod_name from product_info where prod_category='"+category+"'";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin123");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            boolean found = false;
            System.out.println("Product Name");
            System.out.println("============");
            while (rs.next()) {
                found = true;
                System.out.println(rs.getString("prod_name"));
            }
            if (!found) {
                System.out.println("Product Category Not Found");
            }

        }
        catch (SQLException e) {
        e.printStackTrace();
        }
        finally {
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
