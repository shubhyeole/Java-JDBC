package JdbcCrudOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.sql.PreparedStatement;

public class Multimedia {
    public static void main(String[] args) {

        Connection con=null;
        PreparedStatement p=null;
        String query="insert into course_details values(?,?,?)";
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin@123");
            p= con.prepareStatement(query);
            p.setInt(1,0);
            p.setString(2,"java");
            FileInputStream fin1=new FileInputStream("C:\\Users\\SHUBHAM YEOLE\\Desktop\\mysig.jpg");
            p.setBinaryStream(3,fin1);
            int count=p.executeUpdate();
            System.out.println(count+" Record Inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
