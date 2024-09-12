package JdbcCrudOperation;

import java.sql.*;

public class ProductInfo {
    static Connection con;
    Statement stmt=null;
    ResultSet rs=null;
    static {
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin123");
            System.out.println("DB Conn established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addProduct(String name, double price, String category) {
        String query="insert into product_info (prod_name,price,prod_category) values('"+name+"',"+price+",'"+category+"')";
        try {
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            System.out.println(count+" Record inserted ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        String query="delete from product_info where prod_id="+id;
        try {
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            System.out.println(count+" Record Deleted ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
    }

    public void displayAllProduct() {
    String query="select * from product_info";
        try {
            boolean found=false;
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            System.out.println("Product ID      Product Name        Product Price       Category");
            System.out.println("===================================================================");
            while (rs.next())
            {
                found=true;
                System.out.println(rs.getInt(1)+"\t\t\t\t"+rs.getString(2)+"\t\t\t\t"+rs.getDouble(3)+"\t\t\t\t"+rs.getString(4));
            }
            if (!found)
            {
                System.out.println("No records are Available");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void closeResouces() {
        if (con!=null)
        {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (stmt!=null)
        {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }if (rs!=null)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
