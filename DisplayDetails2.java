package JDBCSteps;

import java.sql.*;
import java.util.Scanner;

public class DisplayDetails2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Connection con=null;
        Statement stmt=null;
        ResultSet rs= null;
        System.out.println("Enter the Product Id");
        int id=sc.nextInt();
        String query="Select * from product_info where prod_id="+id;

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin@123");
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            boolean found=false;
            System.out.println("Product ID      Product Name        Product Price");
            System.out.println("====================================================");
//           while(rs.next())
//            {
//                found=true;
//                System.out.println(rs.getInt("prod_id")+"\t\t\t\t"+rs.getString("prod_name")+"\t\t\t\t"+rs.getDouble("price"));
//            }
//            if(!found)
//            {
//                System.out.println("Product Not Found");
//            }
            if(rs.next())
            {
                //System.out.println(rs.getInt("prod_id")+"\t\t\t\t"+rs.getString("prod_name")+"\t\t\t\t"+rs.getDouble("price"));
                System.out.println(rs.getInt(1)+"\t\t\t\t"+rs.getString(2)+"\t\t\t\t"+rs.getDouble(3));
                //Instad of passing  collumn name we also can pass column number
                //if we pass the collumn index number then it is reffered for resultSet collumn not for database
            }
            else{
                System.out.println("Product Not Found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
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
