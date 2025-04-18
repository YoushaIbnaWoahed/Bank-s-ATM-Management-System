package bank.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///atmmanagementsystem", "root", "sstt1692003@Yousha.com");
            s = c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
