package JdbcCrudOperation.App18;

import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Login obj=new Login();
        System.out.println("Select operation");
        System.out.println("1:Login \n2:Sign Up");
        int choice=sc.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("Enter the Username");
                String username=sc.next();
                System.out.println("Enter thr Password");
                String password=sc.next();
                obj.login(username,password);
                break;
            case 2:
                System.out.println("Enter the Username");
                String uname=sc.next();
                System.out.println("Enter thr Password");
                String pass=sc.next();
                obj.signUp(uname,pass);
        }

    }
}
