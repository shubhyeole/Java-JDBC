package JDBCSteps;
import java.sql.DriverManager;
import java.sql.SQLException;
// Second code
public class EstablishConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// loading the driver
            System.out.println("Diver loaded successfully");
            DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","admin123");
            System.out.println("Connection successfull");
        } catch (SQLException e) {
            System.out.println(e);
        }
        catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
