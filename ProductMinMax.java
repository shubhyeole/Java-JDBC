package JdbcCrudOperation;

import java.sql.*;

public class ProductMinMax {
    static Connection con;
    Statement stmt=null;
    ResultSet rs=null;
    static {
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin@123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void maxPriceProduct() {
        String query="SELECT * FROM product_info WHERE price=(SELECT MAX(price) FROM product_info)";
        try {
            stmt=con.createStatement();
            rs= stmt.executeQuery(query);
            System.out.println("Product ID      Product Name        Product Price       Category");
            System.out.println("===================================================================");
            if (rs.next())
            {
                System.out.println(rs.getInt(1)+"\t\t\t\t"+rs.getString(2)+"\t\t\t\t"+rs.getDouble(3)+"\t\t\t\t"+rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void minPriceProduct() {
        String query="SELECT * FROM product_info WHERE price=(SELECT MIN(price) FROM product_info)";
        try {
            stmt=con.createStatement();
            rs= stmt.executeQuery(query);
            System.out.println("Product ID      Product Name        Product Price       Category");
            System.out.println("===================================================================");
            if (rs.next())
            {
                System.out.println(rs.getInt(1)+"\t\t\t\t"+rs.getString(2)+"\t\t\t\t"+rs.getDouble(3)+"\t\t\t\t"+rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
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
}
