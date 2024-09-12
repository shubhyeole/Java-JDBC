package JdbcCrudOperation.Movie;
import java.util.Scanner;
public class MainApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MovieSystem ms=new MovieSystem();
        System.out.println("Select User");
        System.out.println("1:Admin\n2:Customer");
        int choice=sc.nextInt();
        if (choice==1)
        {
            System.out.println("-------------------------------------------------------");
            System.out.println("Operations");
            System.out.println("1:Add Movies\n2:View Movies\n3:Delete Movies");
            int admin_choice=sc.nextInt();
            switch (admin_choice)
            {
                case 1:
                    System.out.println("--------------------------------------------------");
                    System.out.println("Enter the Movie Name");
                    String m_name=sc.next();
                    System.out.println("Enter the Theater Name");
                    String theater=sc.next();
                    System.out.println("Enter the Price of Ticket");
                    double ticket_cost=sc.nextDouble();
                    System.out.println("Enter the number of Available Tickets");
                    int no_Of_Tickets=sc.nextInt();
                    ms.addMovieDetails(m_name,theater,ticket_cost,no_Of_Tickets);
                    break;
                case 2:
                    ms.viewAllMovies();
                    break;
                case 3:
                    System.out.println("Enter the Movie Id");
                    int id=sc.nextInt();
                    ms.deleteMovie(id);
                    break;
                default:
                    System.out.println("Programe Exited");
            }
        } else if (choice==2) {
            System.out.println("------------------------------------------------------");
            System.out.println("Select Operation");
            System.out.println("1:Search Movie Info\n2:Book Tickets");
            int customer_choice=sc.nextInt();
            switch (customer_choice)
            {
                case 1:
                    System.out.println("Enter the Movie Name");
                    String m_name=sc.next();
                    ms.searchMovie(m_name);
                    break;
                case 2:
                    System.out.println("Enter the Movie Name");
                    String movie_name=sc.next();
                    System.out.println("Enter the Theater Name");
                    String theater_name=sc.next();
                    System.out.println("Enter the Numbwr Of Tickets");
                    int tickets=sc.nextInt();
                    ms.bookTickets(movie_name,theater_name,tickets);
                    break;
                default:
                    System.out.println("Program Exited");
            }
        }
        else
        {
            System.out.println("Invalid Choice");
        }
    }
}