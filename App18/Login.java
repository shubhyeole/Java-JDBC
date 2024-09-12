package JdbcCrudOperation.App18;

import java.sql.*;
import java.util.Scanner;


public class Login {
    Scanner sc =new Scanner(System.in);
    static Connection con;
    PreparedStatement pst=null;
    ResultSet rs=null;
    static {
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin123");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void login(String username, String password) {
        String query="Select * from login_details where username=? and password=?";
        try {
            pst=con.prepareStatement(query);
            pst.setString(1,username);
            pst.setString(2,password);
            rs=pst.executeQuery();
            if (rs.next())
            {
                System.out.println("Login Succefull");
                showMenu();
            }else
            {
                System.out.println("Invalid Creadential");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void signUp(String uname, String pass) {
        String query="Insert into login_details values(?,?,?) ";
        try {
            pst=con.prepareStatement(query);
            pst.setInt(1,0);
            pst.setString(2,uname);
            pst.setString(3,pass);
            int count =pst.executeUpdate();
            if (count!=0)
            {
                System.out.println("SignUp Succefull");
//                showMenu();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     void showMenu() {
        boolean status=true;
        while (status) {
            System.out.println("Select option");
            System.out.println("1:View Product\n2:Add Product\n3:Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    String showProd = "Select * from product_info";
                    try {
                        pst = con.prepareStatement(showProd);
                        rs = pst.executeQuery();
                        boolean found = false;
                        System.out.println("Prod Id\t\tProduct Name\t\tProduct Price\t\tProduct Category");
                        while (rs.next()) {
                            found = true;
                            System.out.println(rs.getInt(1) +"\t\t\t"+ rs.getString(2) + "\t\t\t" + rs.getDouble(3) + "\t\t\t\t" + rs.getString(4));
                        }
                        if (!found) {
                            System.out.println("There is no Product Available");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    break;
                case 2:
                    System.out.println("Enter Product Name");
                    String name=sc.next();
                    System.out.println("Enter the Product Price");
                    double price=sc.nextDouble();
                    System.out.println("Enter the Product Category");
                    String category=sc.next();
                    String addProduct="Insert into product_info values(?,?,?,?)";
                    try {
                        pst=con.prepareStatement(addProduct);
                        pst.setInt(1,0);
                        pst.setString(2,name);
                        pst.setDouble(3,price);
                        pst.setString(4,category);
                        int count=pst.executeUpdate();
                        System.out.println(count+"Record Added Sucessfully");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    closeConnection();
                    System.out.println("Programe exited");
                    status=false;
            }
        }

    }

     void closeConnection() {
        if (con!=null)
        {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } if (pst!=null)
        {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } if (rs!=null)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
