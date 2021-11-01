import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    Connection c;
    Statement s;
    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/PizzaManagementSystem?characterEncoding=latin1","root", "Ch@nchal20");
            s = c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
