package JDBCSteps;

import java.sql.*;

import java.util.Scanner;

public class InsertRecord {
        public static void main(String[] args) {
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter the Product id");
            int id=sc.nextInt();
            System.out.println("Enter the Product Name");
            String pro_Name=sc.next();
            System.out.println("Enter the Product Price");
            double price=sc.nextDouble();
            Connection conn=null;
            Statement stmt=null;
            String query="insert into product_data values("+id + ",'" +pro_Name+ "',"+price+")";
            try {
                conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin@123");
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
