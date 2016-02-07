
package dish.cable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class DishCable 
{
    public static void main(String[] args) 
    {
         try{
             // UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
           
          
             
              UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
            
          
              
             // UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        Login fr=new Login();
        fr.setVisible(true);
    
        
    
    }
}
