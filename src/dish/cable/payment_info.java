
package dish.cable;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class payment_info extends javax.swing.JFrame {

   Connection con;private ActionListener al;String past=null;
ResultSet rs;PreparedStatement ps; private Timer timer;
    String name,pass,type,dat,referrer;
    public payment_info() {
         
        initComponents();
        con=db_connect.db();
         dt();
        fill();
       
    }
    public void dt()
    {
         java.util.Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        dat = formatter.format(today);
        jTextField1.setText(dat);
        jTextField2.setText("0");
        
    }
public void fill()
{
     int itemCount = jComboBox2.getItemCount();  
    for(int i=0;i<itemCount;i++){
                jComboBox2.removeItemAt(0);
    }
    int cou=0;
    try{
            ps=con.prepareStatement("select distinct area from customer");
        //    ps.setString(1, name);            ps.setString(2, pass);     ps.setString(3, type);
            rs=ps.executeQuery();
            while(rs.next())
            {
                name=rs.getString("area");
                jComboBox2.addItem(name);
                cou++;
            }
        }
       catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
    
    if(cou==0)
    {
        JOptionPane.showMessageDialog(null,"No customer found.Please Add Customer");
        bill_menu fr=new bill_menu(); fr.setVisible(true);dispose();
        
    }
    //System.out.println(name);
    
}
public void fillup()
{
     int itemCount = jComboBox2.getItemCount();  
    for(int i=0;i<itemCount;i++){
                jComboBox2.removeItemAt(0);
    }
    int cou=0;
    try{
            ps=con.prepareStatement("select distinct area from customer where mobile='"+jTextField4.getText()+"'");
        //    ps.setString(1, name);            ps.setString(2, pass);     ps.setString(3, type);
            rs=ps.executeQuery();
            if(rs.next())
            {
                name=rs.getString("area");
                jComboBox2.addItem(name);
                cou++;
            }
        }
       catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
    
    if(cou==0)
    {
        JOptionPane.showMessageDialog(null,"No customer found.Please Add Customer");
        bill_menu fr=new bill_menu(); fr.setVisible(true);dispose();
        
    }
    //System.out.println(name);
    
}
public void fill_name()
{
   
    int cou=0;
    try{
            ps=con.prepareStatement("select name from customer where area='"+jComboBox2.getSelectedItem().toString()+"' and mobile='"+jTextField4.getText()+"'");
        //    ps.setString(1, name);            ps.setString(2, pass);     ps.setString(3, type);
            rs=ps.executeQuery();
            if(rs.next())
            {
                name=rs.getString("name");
                jTextField5.setText(name);
                cou++;
            }
        }
       catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
    
      if(cou!=0)
    {
       fill_date();
       image_user();
    }
}
    private Image fix_it(Image imeg,int w,int h)
    {
        BufferedImage resizedImage=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2=resizedImage.createGraphics();
        g2.drawImage(imeg,0, 0, w,h,null);
        g2.dispose();
        return resizedImage;
    }
    public void image_user()
    {
        try{
            String sql="select picture from customer where mobile='"+jTextField4.getText()+"'";
              ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
             if (rs.next()){
                 byte[] imagedata=rs.getBytes("picture");
                InputStream in = new ByteArrayInputStream(imagedata);
                BufferedImage bImageFromConvert = ImageIO.read(in);
                 format=new ImageIcon(fix_it(bImageFromConvert,jLabel9.getWidth(),jLabel9.getHeight()));
                 jLabel9.setIcon(format);
             }
             else
             {
                JOptionPane.showMessageDialog(null,"No User Image"); 
             }
        }
       catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
     
}
public void fill_date()
{
   
    try{
            ps=con.prepareStatement("select date from pay_table where mobile='"+jTextField4.getText()+"' and name='"+jTextField5.getText()+"'");
        //    ps.setString(1, name);            ps.setString(2, pass);     ps.setString(3, type);
            rs=ps.executeQuery();
            if(rs.next())
            {
                jTextField3.setText("");
                name=rs.getString("date");
                jTextField3.setText(name);
                
            }
        }
      catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
    
}
public void fill_ref()
{
   
    try{
            ps=con.prepareStatement("select name from current");
        //    ps.setString(1, name);            ps.setString(2, pass);     ps.setString(3, type);
            rs=ps.executeQuery();
            while(rs.next())
            {
                referrer=rs.getString("name");
            }
        }
       catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        jLabel4.setText("Paid:");

        jMenuItem1.setText("Paste");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pay Bill");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monthly Bill payment", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setText("Customer name:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Amount:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setText("Date:");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("TK");

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Cancel/Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("Pay");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("Mobile Number:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setText("Area:");

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });
        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton3.setText("Customer Information");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Last Payment Date:");

        jLabel9.setBounds(0, 0, 120, 150);
        jDesktopPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextField4MouseReleased(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });

        jButton4.setText("Paste");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(41, 41, 41)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-555)/2, (screenSize.height-435)/2, 555, 435);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        billprint();fill();
    }//GEN-LAST:event_jButton2ActionPerformed
    public void billprint(){
                int bill=Integer.parseInt(jTextField2.getText());fill_ref();
                if(!referrer.equals(jTextField1.getText()))
                {
                    referrer=referrer+" ("+dat+")";
                }
        try{
            
            ps = con.prepareStatement("update pay_table set referrer='"+referrer+"',pay='"+bill+"',date='"+jTextField1.getText() +"',status='Active' where name='"+jTextField5.getText()+"' and mobile='"+jTextField4.getText()+"'");
           // ps.setString(1,jComboBox1.getSelectedItem().toString());ps.setString(2,jTextField1.getText());ps.setString(3,date);ps.setString(3,"Active");
            ps.execute();
            JOptionPane.showMessageDialog(null,"Bill has been added","Operation Successfull",JOptionPane.INFORMATION_MESSAGE);
           
           // jTextField1.setText("");
       }
     catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
        
        try{
            
            String d=dat.substring(3);
            
            ps = con.prepareStatement("update total set tk=tk+"+bill+" where month='"+d+"'");
            ps.execute();
       }
         catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
        
          try{
            ps = con.prepareStatement("update daily set tk=tk+"+jTextField2.getText()+" where din='"+dat+"'");
            ps.execute();
       }
       catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
        
                
           jTextField2.setText("");
           jTextField3.setText("");
           jTextField4.setText("");
           jTextField5.setText("");
       }
            
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        bill_menu fr=new bill_menu();
        fr.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
       //System.out.println(jComboBox2.getSelectedItem().toString());
       //fill_name();
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       user_info fr=new user_info(); fr.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        //fill();
       // fill_name(); // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible
       // fill_name();
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER)
         {
            billprint();
         }
        
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER)
         {
            fill_name();
         }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
         {
            fill_date();
         }
    }//GEN-LAST:event_jTextField5KeyPressed
   public void anda_polo()
   {
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable t = c.getContents(this);
    if (t == null)
        return;
    try {
        jTextField4.setText((String) t.getTransferData(DataFlavor.stringFlavor));
    } catch (Exception e){
        e.printStackTrace();
    }//
   }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable t = c.getContents(this);
    if (t == null)
        return;
    try {
        jTextField4.setText((String) t.getTransferData(DataFlavor.stringFlavor));
    } catch (Exception e){
        e.printStackTrace();
    }//
    fillup();
    fill_name();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseReleased
        if(evt.isPopupTrigger())
        {
            
            Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable t = c.getContents(this);
            if (t == null)
                return;
            try {
                jTextField4.setText((String) t.getTransferData(DataFlavor.stringFlavor));
            } catch (Exception e){
                e.printStackTrace();
            }//
            fillup();
        }
    }//GEN-LAST:event_jTextField4MouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
         char c=evt.getKeyChar();
      if(!(c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || Character.isDigit(c)))
      {
          getToolkit().beep();          
          evt.consume();
      }
    }//GEN-LAST:event_jTextField2KeyTyped

  
    public static void main(String args[]) {
       
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(payment_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payment_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payment_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payment_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new payment_info().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
 private ImageIcon format=null;
}
