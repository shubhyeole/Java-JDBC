package JDBCSteps;
import java.sql.*;
import java.util.Scanner;
public class UpdateRecord {
    static  String query=null;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Connection conn=null;
        Statement stmt=null;
        System.out.println("Select operation");
        System.out.println("1:Update Product Name \n2:Update Product Price ");
        int choice=sc.nextInt();
        System.out.println("Enter Product Id");
        int id= sc.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("Enter New Product Name");
                String name = sc.next();
                query = "update product_info set prod_name= '"+ name +"' where prod_id="+ id+";";
                break;
            case 2:
                System.out.println("Enter New Product Price");
                double price = sc.nextDouble();
                query = "update product_info set price=" + price + "where prod_id=" + id+";";
                break;
            default:
                System.out.println("Invalid Choice");
        }
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin@123");
            stmt=conn.createStatement();
            int updt=stmt.executeUpdate(query);
            if (updt==0)
            {
                System.out.println("Updation is Not Done ");
            }
            else{
                System.out.println("Updation is Successfull!!!");
            }

        }catch (SQLException e) {
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
