package JDBCSteps;

import java.sql.*;
import java.util.Scanner;
public class DeleteRecord {
    public static void main(String[] args) {
            Connection conn=null;
            Statement stmt=null;
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter the Product id");
            int id=sc.nextInt();
            String query="delete from product_info where prod_id="+ id;

            try {
                conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin@123");
                stmt=conn.createStatement();
                int count =stmt.executeUpdate(query);
                if(count!=0)
                {
                    System.out.println("record deleted succesfully");
                }else
                {
                    System.out.println("Invalid id");
                }
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

