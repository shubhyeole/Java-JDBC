package JdbcCrudOperation;

import java.util.Scanner;

public class ProblemStatement2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ProductMinMax pro=new ProductMinMax();
        System.out.println("Find Product Details");
        System.out.println("1:Max Price Product\n2:Min Price Product");
        int choice=sc.nextInt();
        switch (choice)
        {
            case 1:
                pro.maxPriceProduct();
                break;
            case 2:
                pro.minPriceProduct();


        }

    }
}
