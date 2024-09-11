package JDBCSteps;

// first code
public class DriverLoading {
    public static void main(String[] args) {
        //to load the Driver forName() is used which declare inside 'Class' class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//fully qualified class name
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }


    }
}
