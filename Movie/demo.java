package JdbcCrudOperation.Movie;

import java.sql.*;

public class demo {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement p=null;
        ResultSet rs=null;
        String query="Select * from movie_info where movie_name=?";
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin123");
            p=con.prepareStatement(query);
            p.setString(1,"shole");
            rs=p.executeQuery();
            while(rs.next())
            {

                System.out.println(rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getDouble(4)+"\t\t\t"+rs.getInt(5));

                System.out.println("-----------------------------------------------------------------------------");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
