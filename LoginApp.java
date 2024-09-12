package JdbcCrudOperation;

import java.sql.*;
import java.util.Scanner;

public class LoginApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Username");
        String uname=sc.next();
        System.out.println("Enter the Password");
        String password=sc.next();
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String query="select * from login_details where username=? and password=?";

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin@123");
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,uname);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                System.out.println("Login succeful");
            }else {
                System.out.println("Invalid login Creadentials");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
