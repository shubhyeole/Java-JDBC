package JdbcCrudOperation;

import java.util.Scanner;

public class CrudOperation {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ProductInfo pi=new ProductInfo();

        boolean status=true;
        while(status)
        {
            System.out.println("select mode of Operation");
            System.out.println("1:Insert Product\n2:Delete Product\n3:Display Product\n 4:Exit");
            int choice=sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("Enter the Product Name");
                    String name=sc.next();
                    System.out.println("Enter the Product Price");
                    double price=sc.nextDouble();
                    System.out.println("Enter the Product category");
                    String category=sc.next();
                    pi.addProduct(name,price,category);
                    break;
                case 2:
                    System.out.println("Enter the Product Id");
                    int id=sc.nextInt();
                    pi.deleteProduct(id);
                    break;
                case 3:
                    pi.displayAllProduct();
                    break;
                default:
                    if(choice==4)
                    {
                        System.out.println("Programe exited");
                    }
                    else {

                        System.out.println("Invalid choice");
                    }
                    pi.closeResouces();
                    status=false;

            }
        }
    }
}
