package JDBCSteps;

import java.sql.*;
import java.util.Scanner;

public class DisplayRange {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Connection con=null;
        Statement stmt=null;
        ResultSet rs= null;
        System.out.println("Enter the Minimum Range");
        double min=sc.nextDouble();
        System.out.println("Enter the Maximum Range");
        double max=sc.nextDouble();
        String query="Select * from product_info where price between "+min+" and "+max;
        //String query1="SELECT * FROM product_info WHERE price BETWEEN 8000 AND ";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin@123");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            boolean found = false;
            System.out.println("Product ID      Product Name        Product Price       Category");
            System.out.println("===================================================================");
            while (rs.next()) {
                found = true;
                System.out.println(rs.getInt(1)+"\t\t\t\t"+rs.getString(2)+"\t\t\t\t"+rs.getDouble(3)+"\t\t\t\t"+rs.getString(4));
                //System.out.println(rs.getString("prod_name"));
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
