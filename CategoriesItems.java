package JDBCSteps;

import java.sql.*;

public class CategoriesItems {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        String query="SELECT prod_category,COUNT(*) FROM product_info GROUP BY prod_category;";
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin@123");
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            System.out.println("Category        Total number of Product");
            System.out.println("------------------------------------------");
            while (rs.next())
            {
                System.out.println(rs.getString(1)+"\t\t\t"+rs.getInt(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //closing the costly resources
            if(con!=null)
            {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null)
            {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs!=null)
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
