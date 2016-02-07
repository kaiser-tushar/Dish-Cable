/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dish.cable;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author KAT
 */
public class db_connect 
{
    Connection con=null;
    public static Connection db()
    {
        try{
            Class.forName("org.sqlite.JDBC");
          //  Connection con=DriverManager.getConnection("jdbc:sqlite:E:\\Programming\\Project\\Dish cable\\dishcable.sqlite");
            Connection con=DriverManager.getConnection("jdbc:sqlite:dishcable.sqlite");
            
            //JOptionPane.showMessageDialog(null,"DB connected");
            return con;
        }
        catch (Exception e) {
          //  System.out.println(e);
            return null;
        }
        
    }
    
}
