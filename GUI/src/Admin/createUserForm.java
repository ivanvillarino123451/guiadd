package Admin;

import user.usersForm;
import config.dbConnector;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ivan
 */
public class createUserForm extends javax.swing.JFrame {

    /**
     * Creates new form createUserForm
     */
    public createUserForm() {
        initComponents();
    }
    
    public String destination ="";
    File selectedFile;
    public String oldpath;
    public String path;
    
    public int FileExistenceChecker(String path){
    File file = new File(path);
    String fileName = file.getName();
    
    Path filePath = Paths.get("src/userimages", fileName);
    boolean fileExists = Files.exists(filePath);    
    
    if(fileExists){
          return 1;
    }else{
          return 0;
    }
   
    }
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
    
    public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
    
    
    
    
     public static String email,stname;
       
        public boolean duplicateCheck(){
        
         dbConnector dbc = new dbConnector();
            
         try{
           String query = ("SELECT * FROM tbl_student WHERE s_username = '"+un.getText()+"'OR s_email ='" + ""+em.getText()+"'");
           ResultSet resultSet = dbc.getData(query);
         
           if(resultSet.next()){
                 email = resultSet.getString("s_email");
                 if(email.equals(em.getText())){
                  JOptionPane.showMessageDialog(null,"Email is Already Used!");
                  em.setText("");   
                 }
                 
                 stname = resultSet.getString("s_username");
                 if(stname.equals(un.getText())){
                  JOptionPane.showMessageDialog(null,"User is Already Used!");
                  un.setText(""); 
                 }
               
                 return true;
                 
           }else{
                 return false;
           }
           
         }catch(SQLException ex){
         System.out.println(""+ex);
         return false;
                 
        }
   }
        
          public boolean UpdateCheck(){
         dbConnector dbc = new dbConnector();
            
         try{
           String query = "SELECT * FROM tbl_student WHERE(s_username='"+un.getText()+"'OR s_email='"+em.getText()+"')AND s_id!='"+sid.getText()+"'";
           ResultSet resultSet = dbc.getData(query);
         
           if(resultSet.next()){
                 email = resultSet.getString("s_email");
                 if(email.equals(em.getText())){
                  JOptionPane.showMessageDialog(null,"Email is Already Used!");
                  em.setText("");   
                 }
                 
                 stname = resultSet.getString("s_username");
                 if(stname.equals(un.getText())){
                  JOptionPane.showMessageDialog(null,"User is Already Used!");
                  un.setText(""); 
                 }
               
                 return true;
                 
           }else{
                 return false;
           }
           
         }catch(SQLException ex){
         System.out.println(""+ex);
         return false;
                 
        }
   } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        ln = new javax.swing.JTextField();
        jlabel3 = new javax.swing.JLabel();
        gn = new javax.swing.JTextField();
        jlabl1 = new javax.swing.JLabel();
        stat = new javax.swing.JTextField();
        jlabel2 = new javax.swing.JLabel();
        jlabel4 = new javax.swing.JLabel();
        ps = new javax.swing.JPasswordField();
        jlabel5 = new javax.swing.JLabel();
        st = new javax.swing.JComboBox<>();
        jlabl2 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jlabel6 = new javax.swing.JLabel();
        jlabel7 = new javax.swing.JLabel();
        em = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        ss = new javax.swing.JComboBox<>();
        jlabel8 = new javax.swing.JLabel();
        jlabl3 = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();
        update = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 51, 102));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setEnabled(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ln.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        ln.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ln.setAutoscrolls(false);
        ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnActionPerformed(evt);
            }
        });
        jPanel5.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 270, 30));

        jlabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabel3.setForeground(new java.awt.Color(255, 255, 255));
        jlabel3.setText("User Name:");
        jPanel5.add(jlabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 110, 30));

        gn.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        gn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gn.setAutoscrolls(false);
        gn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gnActionPerformed(evt);
            }
        });
        jPanel5.add(gn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 270, 30));

        jlabl1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabl1.setForeground(new java.awt.Color(255, 255, 255));
        jlabl1.setText("Last Name:");
        jlabl1.setToolTipText("");
        jPanel5.add(jlabl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 110, 30));

        stat.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        stat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stat.setAutoscrolls(false);
        stat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statActionPerformed(evt);
            }
        });
        jPanel5.add(stat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 270, 30));

        jlabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabel2.setForeground(new java.awt.Color(255, 255, 255));
        jlabel2.setText("Email:");
        jPanel5.add(jlabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 70, 30));

        jlabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabel4.setForeground(new java.awt.Color(255, 255, 255));
        jlabel4.setText("Password :");
        jPanel5.add(jlabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 100, 30));

        ps.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel5.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 270, 30));

        jlabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabel5.setForeground(new java.awt.Color(255, 255, 255));
        jlabel5.setText("Account Type:");
        jlabel5.setToolTipText("");
        jPanel5.add(jlabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 130, 30));

        st.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        st.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stActionPerformed(evt);
            }
        });
        jPanel5.add(st, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 270, 40));

        jlabl2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabl2.setForeground(new java.awt.Color(255, 255, 255));
        jlabl2.setText("First Name :");
        jlabl2.setToolTipText("");
        jPanel5.add(jlabl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 110, 30));

        fn.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        fn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fn.setAutoscrolls(false);
        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel5.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 270, 30));

        add.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        add.setText("ADD");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel5.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 120, 40));

        jlabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabel6.setForeground(new java.awt.Color(255, 255, 255));
        jlabel6.setText("Status :");
        jPanel5.add(jlabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 80, 30));

        jlabel7.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabel7.setForeground(new java.awt.Color(255, 255, 255));
        jlabel7.setText("Gender :");
        jPanel5.add(jlabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 90, 30));

        em.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        em.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        em.setAutoscrolls(false);
        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        jPanel5.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 270, 30));

        un.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        un.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        un.setAutoscrolls(false);
        un.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unActionPerformed(evt);
            }
        });
        jPanel5.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 270, 30));

        ss.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        ss.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        ss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssActionPerformed(evt);
            }
        });
        jPanel5.add(ss, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 570, 270, 40));

        jlabel8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabel8.setForeground(new java.awt.Color(255, 255, 255));
        jlabel8.setText("User Status:");
        jlabel8.setToolTipText("");
        jPanel5.add(jlabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 110, 40));

        jlabl3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabl3.setForeground(new java.awt.Color(255, 255, 255));
        jlabl3.setText("User ID:");
        jlabl3.setToolTipText("");
        jPanel5.add(jlabl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 80, 30));

        sid.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        sid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sid.setAutoscrolls(false);
        sid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidActionPerformed(evt);
            }
        });
        jPanel5.add(sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 270, 30));

        refresh.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        refresh.setText("REFRESH");
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel5.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 130, 40));

        update.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        update.setText("UPDATE");
        update.setEnabled(false);
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel5.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 120, 40));

        cancel.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        cancel.setText("CANCEL");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel5.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 120, 40));

        clear.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        clear.setText("CLEAR");
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
        });
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel5.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 120, 40));

        delete.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        delete.setText("DELETE");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel5.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 130, 40));

        jPanel1.setLayout(null);
        jPanel1.add(image);
        image.setBounds(10, 10, 350, 370);

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 370, 390));

        select.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        select.setText("SELECT");
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectMouseClicked(evt);
            }
        });
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel5.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, 140, 40));

        remove.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        remove.setText("REMOVE");
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMouseClicked(evt);
            }
        });
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel5.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 520, 130, 40));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnActionPerformed

    private void gnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gnActionPerformed

    private void statActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statActionPerformed

    private void stActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        if(fn.getText().isEmpty()||ln.getText().isEmpty()||stat.getText().isEmpty()
            ||gn.getText().isEmpty()||ps.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"All Fields are required!");
        }else if(ps.getText().length()<8){
            JOptionPane.showMessageDialog(null,"Password character should be 8 above");
            ps.setText("");
        }else if(duplicateCheck()){
            System.out.println("duplicate Exist!");
        }else{
            dbConnector dbc = new dbConnector();
            String sql = "INSERT INTO tbl_student(s_fname, s_lname, s_email, s_username, s_password, s_gender, s_type, s_status, s_image) VALUES('" 
                    + fn.getText() + "','" + ln.getText() + "','" + em.getText() + "','" + un.getText() + "','" +ps.getText()+"','" 
                    + gn.getText() + "', '"+ st.getSelectedItem() +"','"+ss.getSelectedItem()+"','"+destination+"')";

            
            
            
            if (dbc.insertData(sql) == 1) {
                
                try{
                Files.copy(selectedFile.toPath(),new File(destination).toPath(),StandardCopyOption.REPLACE_EXISTING);
                }catch(IOException ex){
                  System.out.println("Insert Image Error: "+ex);
                }
                JOptionPane.showMessageDialog(null, "Registration Successfully!");
                   usersForm uf = new usersForm();
                   uf.setVisible(true);
                   this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Connection Error!");
            }
        }
    }//GEN-LAST:event_addActionPerformed

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unActionPerformed

    private void ssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ssActionPerformed

    private void sidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sidActionPerformed

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshMouseClicked

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshActionPerformed

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
     if(fn.getText().isEmpty()||ln.getText().isEmpty()||stat.getText().isEmpty()
            ||gn.getText().isEmpty()||ps.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"All Fields are required!");
        }else if(ps.getText().length()<8){
            JOptionPane.showMessageDialog(null,"Password character should be 8 above");
            ps.setText("");
        }else if(duplicateCheck()){
            System.out.println("Duplicate Exist!");
        }else{
          dbConnector dbc = new dbConnector();
            dbc.updateData("UPDATE tbl_student SET s_fname = '"+fn.getText()+"', s_lname = '"+ln.getText()
               +"',s_email = '"+em.getText()+"', s_username = '"+un.getText()+"', s_password = '"+ps.getText()
                  +"', s_type = '"+st.getSelectedItem()+"', s_status = '"+ss.getSelectedItem()
                    +"',s_image = '"+destination+"' WHERE s_id = '"+sid.getText()+"'");

            if(destination.isEmpty()){
             File existingFile = new File(oldpath);
             if(existingFile.exists()){
                existingFile.delete();
             }          
        }else{
              if(!(oldpath.equals(path))){
                  imageUpdater(oldpath,path);
              }
            }
            usersForm uf = new usersForm();
            uf.setVisible(true);
            this.dispose();
       
        }
    }//GEN-LAST:event_updateActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
    usersForm usf = new usersForm();
    usf.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_clearMouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_selectMouseClicked

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
           JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/images/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            select.setEnabled(false);
                            remove.setEnabled(true);
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    }
                }
    }//GEN-LAST:event_selectActionPerformed

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_removeMouseClicked

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
       remove.setEnabled(false);
       select.setEnabled(true);
       image.setIcon(null);
       destination = "";
       path = "";
    }//GEN-LAST:event_removeActionPerformed

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
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { 
                new createUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    public javax.swing.JTextField em;
    public javax.swing.JTextField fn;
    public javax.swing.JTextField gn;
    public javax.swing.JLabel image;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JLabel jlabel5;
    private javax.swing.JLabel jlabel6;
    private javax.swing.JLabel jlabel7;
    private javax.swing.JLabel jlabel8;
    private javax.swing.JLabel jlabl1;
    private javax.swing.JLabel jlabl2;
    private javax.swing.JLabel jlabl3;
    public javax.swing.JTextField ln;
    public javax.swing.JPasswordField ps;
    private javax.swing.JButton refresh;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JTextField sid;
    public javax.swing.JComboBox<String> ss;
    public javax.swing.JComboBox<String> st;
    public javax.swing.JTextField stat;
    public javax.swing.JTextField un;
    public javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
