
package dish.cable;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame 
{
Connection con;
ResultSet rs;PreparedStatement ps;
    String name,pass,type;
    public Login() 
    {
        initComponents();
        con=db_connect.db();
       expire();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Maria Cable Enterprise", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sign in", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("User Name:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Password :");

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPasswordField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Owner", "Employee" }));
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Account Type:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jMenu2.setText("About");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenu2MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-431)/2, (screenSize.height-350)/2, 431, 350);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
              System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed
   ///Function
    public void expire()
   {
         java.util.Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dat = formatter.format(today);
        String d=dat.substring(7);
        if(!d.equals("2016"))
        {
            JOptionPane.showMessageDialog(null,"License Expire.Contact with System Administrator.");
            System.exit(0);
        }
        //System.out.print(d);
   }
    public void cur(String ss)
    {
        try{
            
            ps = con.prepareStatement("update current set name='"+ss+"'");
           // ps.setString(1,jComboBox1.getSelectedItem().toString());ps.setString(2,jTextField1.getText());ps.setString(3,date);ps.setString(3,"Active");
            ps.execute();
           // JOptionPane.showMessageDialog(null,"Bill has been added","Operation Successfull",JOptionPane.INFORMATION_MESSAGE);
           
           // jTextField1.setText("");
       }
      catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
    }
    public void change_m(String d)
    {
         try{
            ps = con.prepareStatement("update month set mash='"+d+"'");
           // ps.setString(1,jComboBox1.getSelectedItem().toString());ps.setString(2,jTextField1.getText());ps.setString(3,date);ps.setString(3,"Active");
            ps.execute();
            //JOptionPane.showMessageDialog(null,"Bill has been added","Operation Successfull",JOptionPane.PLAIN_MESSAGE);
       }
      catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
        try{
            ps = con.prepareStatement("update pay_table set status='Inactive'");
           // ps.setString(1,jComboBox1.getSelectedItem().toString());ps.setString(2,jTextField1.getText());ps.setString(3,date);ps.setString(3,"Active");
            ps.execute();
            //JOptionPane.showMessageDialog(null,"Bill has been added","Operation Successfull",JOptionPane.PLAIN_MESSAGE);
       }
      catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
        try{
            ps = con.prepareStatement("insert into  total values (?,?)");
            ps.setString(1,d);ps.setString(2,"0");
            ps.execute();
       }
      catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
    }
    public void check_m()
    {
         java.util.Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dat = formatter.format(today);
        String d=dat.substring(3);
        boolean f=false;
        try{
            ps=con.prepareStatement("select * from day_tk");
            rs=ps.executeQuery();
            if(rs.next())
            {
               String din=rs.getString("din");
                if(!dat.equals(din))
                {
                   f=true;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Incorrect Information","Login Failed",JOptionPane.ERROR_MESSAGE);
            }
        }
       catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
        if(f==true)
        {
            try{
            ps = con.prepareStatement("update day_tk set din='"+dat+"'");
           // ps.setString(1,jComboBox1.getSelectedItem().toString());ps.setString(2,jTextField1.getText());ps.setString(3,date);ps.setString(3,"Active");
            ps.execute();
            //JOptionPane.showMessageDialog(null,"Bill has been added","Operation Successfull",JOptionPane.PLAIN_MESSAGE);
       }
       catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
            
                 try{
            ps = con.prepareStatement("insert into  daily values (?,?)");
            ps.setString(1,dat);ps.setString(2,"0");
            ps.execute();
       }
       catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
       f=false;
        try{
            ps=con.prepareStatement("select * from month");
            rs=ps.executeQuery();
            if(rs.next())
            {
                dat=rs.getString("mash");
                if(!dat.equals(d))
                {
                   f=true;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Incorrect Information","Login Failed",JOptionPane.ERROR_MESSAGE);
            }
        }
       catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
        if(f==true)
        {
             change_m(d);
        }
        }
    }
    public void logi()
    {
       boolean gu=false;
        name=jTextField1.getText();        pass=jPasswordField1.getText();  type=jComboBox1.getSelectedItem().toString();
        try{
            ps=con.prepareStatement("select * from login where user=? and pass=? and type=?");
            ps.setString(1, name);            ps.setString(2, pass);     ps.setString(3, type);
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(type=="Owner")
                {
                    
                    Menu_owner fr=new Menu_owner();
                    fr.setVisible(true);
                    dispose();
                }
                else
                {
                    menu_employee fr=new menu_employee();
                    fr.setVisible(true);
                    dispose();
                }
                 gu=true;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Incorrect Information","Login Failed",JOptionPane.ERROR_MESSAGE);
                 jTextField1.setText("");jPasswordField1.setText("");
            }
             
        }
       catch(Exception ex)
       {JOptionPane.showMessageDialog(null, ex);}
            finally{try{rs.close();ps.close();}catch(Exception e){}}
        if(gu==true && jComboBox1.getSelectedItem().toString().equals("Employee"))
        {
            cur(jTextField1.getText());check_m();
        }
        
    }
    ///function
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        logi();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER)
         {
             logi();
         }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
          if(evt.getKeyCode()==KeyEvent.VK_ENTER)
         {
             logi();
         }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
          if(evt.getKeyCode()==KeyEvent.VK_ENTER)
         {
             logi();
         }
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jMenu2MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenu2MenuKeyPressed
       // help fr=new help();fr.setVisible(true);
    }//GEN-LAST:event_jMenu2MenuKeyPressed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        help fr=new help();fr.setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
