package JdbcCrudOperation.Movie;

import java.sql.*;

public class MovieSystem {
    static Connection con;
    PreparedStatement stmt=null;
    ResultSet rs=null;
    static {
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=admin123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMovieDetails(String mName, String theater, double ticketCost, int noOfTickets) {
      String query="insert into movie_info values(?,?,?,?,?)";
        try {
            stmt= con.prepareStatement(query);
            stmt.setInt(1,0);
            stmt.setString(2,mName);
            stmt.setString(3,theater);
            stmt.setDouble(4,ticketCost);
            stmt.setInt(5,noOfTickets);
           int count =stmt.executeUpdate();
            System.out.println(count+" Movies Inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllMovies() {
        String query="Select * from movie_info";
        try {
            stmt = con.prepareStatement(query);
            rs=stmt.executeQuery();
            boolean found=false;
            System.out.println("Movie Id\t\tMovie Name\t\tTheater Name\t\tTicket Cost\t\tAvailable Tickets ");
            System.out.println("-----------------------------------------------------------------------------");
            while (rs.next())
            {
                found=true;
                System.out.println(rs.getInt("movie_id")+"\t\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t\t"+rs.getDouble(4)+"\t\t\t"+rs.getInt(5));
                System.out.println("-----------------------------------------------------------------------------");

            }
            if (!found)
            {
                System.out.println("Movies are not Available!!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteMovie(int id) {
            String query="Delete from movie_info where movie_id = ?";
            try {
                stmt = con.prepareStatement(query);
                stmt.setInt(1,id);
                int count=stmt.executeUpdate();
                System.out.println(count+"Movies is deleted");
            }catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void searchMovie(String mName) {
        String query="Select * from movie_info where movie_name=?";
        try {
            stmt=con.prepareStatement(query);
            stmt.setString(1,mName);
            rs=stmt.executeQuery();
            System.out.println("Movie Id\t\tMovie Name\t\tTheater Name\t\tTicket Cost\t\tAvailable Tickets ");
            System.out.println("-----------------------------------------------------------------------------");
            if (rs.next())
            {
                System.out.println(rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getDouble(4)+"\t\t\t"+rs.getInt(5));
                System.out.println("-----------------------------------------------------------------------------");
            }else
            {
                System.out.println("Movie Not Found!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void bookTickets(String movieName, String theaterName, int tickets) {
       String query="SELECT avai_ticket,movie_name,ticket_cost FROM movie_info WHERE movie_name=? AND theater=?";
        int availbaleTicket=0;
        double ticket_cost=0;
        String mname="";
        try {
            stmt=con.prepareStatement(query);
            stmt.setString(1,movieName);
            stmt.setString(2,theaterName);
            rs=stmt.executeQuery();
            if (rs.next())
            {   availbaleTicket=rs.getInt(1);
                mname=rs.getString(2);
                ticket_cost=rs.getDouble(3);
            }
            else
            {
                System.out.println(movieName +" movie is not available at "+theaterName);
            }
            if(availbaleTicket>=tickets)
            {
                int updated_tickets=availbaleTicket-tickets;
                String bookquery="UPDATE movie_info SET avai_ticket=? where movie_name=?";
                stmt= con.prepareStatement(bookquery);
                stmt.setInt(1,updated_tickets);
                stmt.setString(2,mname);

                int count=stmt.executeUpdate();
                if(count!=0) {
                    System.out.println("Final payable amount: "+ticket_cost*tickets);
                    System.out.println(tickets + " Tickets Booked Successfully");
                }
            }
            else{
                System.out.println("Only "+availbaleTicket+" tickets are available");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    void closeResources()
    {
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt!=null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
