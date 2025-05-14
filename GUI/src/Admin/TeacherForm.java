package Admin;


import user.GradesPrinting;
import user.usersForm;
import Admin.AdminDashboardd;
import Admin.AdminDashboardd;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import static java.awt.Color.blue;
import static java.awt.Color.gray;
import static java.awt.Color.green;
import static java.awt.Color.red;
import static java.awt.Color.white;
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
import static javafx.scene.paint.Color.color;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import user.AccountDetails;
import user.GradesPage;
import user.usersForm;
import user.usersForm;
import user.usersForm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ivan
 */
public class TeacherForm extends javax.swing.JFrame {

    /**
     * Creates new form usersForm
     */
    public TeacherForm() {
        initComponents();
        displayData();
        
        
     boolean checkadd = true ;
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
    
    
    
    boolean checkadd = true; 
    
        Color navcolor = new Color(0,204,204);
        Color hovercolor = new Color(0,153,153);
    
    
    public void displayData(){
        try{
            
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT s_id, s_fname, s_lname FROM tbl_student");
            studentsTable.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
             }catch(SQLException ex){
            System.out.println("Errors:"+ex.getMessage());
        }
          try{
            dbConnector dbc = new dbConnector();
            ResultSet rs =  dbc.getData("SELECT g_id, t_id, student_name, year, Department, Course, Prelim, Midterm, Prefinal, Final, Status, image FROM tbl_grade");
            records.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors:"+ex.getMessage());
        }
            try{
            dbConnector dbc = new dbConnector();
            ResultSet rs =  dbc.getData("SELECT t_id, t_name FROM tbl_teacher");
            teacher.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors:"+ex.getMessage());
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

        jProgressBar1 = new javax.swing.JProgressBar();
        as = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        navbar = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        user = new javax.swing.JLabel();
        acc_lname = new javax.swing.JLabel();
        acc_lname1 = new javax.swing.JLabel();
        acc_id = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        addlabel = new javax.swing.JLabel();
        clear = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        update = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        print = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        delete = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        grades = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        jlabel8 = new javax.swing.JLabel();
        jlabl2 = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        s = new javax.swing.JComboBox<>();
        gid = new javax.swing.JTextField();
        jlabl4 = new javax.swing.JLabel();
        sname = new javax.swing.JTextField();
        jlabl8 = new javax.swing.JLabel();
        dep = new javax.swing.JTextField();
        jlabl9 = new javax.swing.JLabel();
        c = new javax.swing.JTextField();
        jlabl10 = new javax.swing.JLabel();
        pre = new javax.swing.JTextField();
        jlabl11 = new javax.swing.JLabel();
        mid = new javax.swing.JTextField();
        jlabl12 = new javax.swing.JLabel();
        prefi = new javax.swing.JTextField();
        jlabl13 = new javax.swing.JLabel();
        fi = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        records = new javax.swing.JTable();
        jlabl14 = new javax.swing.JLabel();
        yr = new javax.swing.JTextField();
        jlabl5 = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        teacher = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        as.setBackground(new java.awt.Color(0, 51, 102));
        as.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("TEACHER FORM");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 10, 230, 30);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BACK");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5);
        jLabel5.setBounds(1130, 0, 100, 50);

        as.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 50));

        navbar.setBackground(new java.awt.Color(0, 204, 204));
        navbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsfolder/icons8-user-group-skin-type-7-100.png"))); // NOI18N
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
        });
        jPanel3.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 70));

        navbar.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 70));

        acc_lname.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        acc_lname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_lname.setText("USER");
        navbar.add(acc_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 160, 20));

        acc_lname1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        acc_lname1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_lname1.setText("Current User:");
        navbar.add(acc_lname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 160, 30));

        acc_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        acc_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_id.setText("ID");
        navbar.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 160, 20));

        add.setBackground(new java.awt.Color(0, 204, 204));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addlabel.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        addlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addlabel.setText("ADD");
        addlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addlabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addlabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addlabelMouseExited(evt);
            }
        });
        add.add(addlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 160, 30));

        navbar.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 160, 50));

        clear.setBackground(new java.awt.Color(0, 204, 204));
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearMouseExited(evt);
            }
        });
        clear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CLEAR");
        clear.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 160, 30));

        navbar.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 160, 50));

        update.setBackground(new java.awt.Color(0, 204, 204));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
        });
        update.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("UPDATE");
        update.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 160, -1));

        navbar.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 160, 50));

        print.setBackground(new java.awt.Color(0, 204, 204));
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printMouseExited(evt);
            }
        });
        print.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PRINT");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        print.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 160, 30));

        navbar.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 160, 50));

        delete.setBackground(new java.awt.Color(0, 204, 204));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });
        delete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DELETE");
        delete.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 160, 30));

        navbar.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 160, 50));

        grades.setBackground(new java.awt.Color(0, 204, 204));
        grades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gradesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gradesMouseExited(evt);
            }
        });
        grades.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GRADES");
        grades.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 10, 160, -1));

        navbar.add(grades, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 160, 50));

        as.add(navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 680));

        studentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentsTable);

        as.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 310, 150));

        jlabel8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabel8.setForeground(new java.awt.Color(255, 255, 255));
        jlabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlabel8.setText("Status:");
        jlabel8.setToolTipText("");
        as.add(jlabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 650, 80, 40));

        jlabl2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabl2.setForeground(new java.awt.Color(255, 255, 255));
        jlabl2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlabl2.setText("Grade ID:");
        jlabl2.setToolTipText("");
        as.add(jlabl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 150, 30));

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
        as.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 360, 130, 40));

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
        as.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 360, 130, 40));

        s.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        s.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Passed", "Failed", " " }));
        as.add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 650, 230, 30));

        gid.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        gid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gid.setAutoscrolls(false);
        gid.setEnabled(false);
        gid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gidActionPerformed(evt);
            }
        });
        as.add(gid, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 230, 30));

        jlabl4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabl4.setForeground(new java.awt.Color(255, 255, 255));
        jlabl4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlabl4.setText("Student Name:");
        jlabl4.setToolTipText("");
        as.add(jlabl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, 170, 30));

        sname.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        sname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sname.setAutoscrolls(false);
        sname.setEnabled(false);
        sname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snameActionPerformed(evt);
            }
        });
        as.add(sname, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, 230, 30));

        jlabl8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabl8.setForeground(new java.awt.Color(255, 255, 255));
        jlabl8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlabl8.setText("Department:");
        jlabl8.setToolTipText("");
        as.add(jlabl8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 630, 150, 30));

        dep.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        dep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dep.setAutoscrolls(false);
        dep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depActionPerformed(evt);
            }
        });
        as.add(dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 630, 230, 30));

        jlabl9.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabl9.setForeground(new java.awt.Color(255, 255, 255));
        jlabl9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlabl9.setText("Course:");
        jlabl9.setToolTipText("");
        as.add(jlabl9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 680, 110, 30));

        c.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c.setAutoscrolls(false);
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });
        as.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 690, 230, 30));

        jlabl10.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabl10.setForeground(new java.awt.Color(255, 255, 255));
        jlabl10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlabl10.setText("Prelim:");
        jlabl10.setToolTipText("");
        as.add(jlabl10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 450, 70, 30));

        pre.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        pre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pre.setAutoscrolls(false);
        pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preActionPerformed(evt);
            }
        });
        as.add(pre, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 450, 230, 30));

        jlabl11.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabl11.setForeground(new java.awt.Color(255, 255, 255));
        jlabl11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlabl11.setText("MIdterm:");
        jlabl11.setToolTipText("");
        as.add(jlabl11, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 500, 90, 30));

        mid.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        mid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mid.setAutoscrolls(false);
        mid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midActionPerformed(evt);
            }
        });
        as.add(mid, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, 230, 30));

        jlabl12.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabl12.setForeground(new java.awt.Color(255, 255, 255));
        jlabl12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlabl12.setText("prefinal: ");
        jlabl12.setToolTipText("");
        as.add(jlabl12, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 550, 90, 30));

        prefi.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        prefi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prefi.setAutoscrolls(false);
        prefi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prefiActionPerformed(evt);
            }
        });
        as.add(prefi, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 550, 230, 30));

        jlabl13.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabl13.setForeground(new java.awt.Color(255, 255, 255));
        jlabl13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlabl13.setText("Final:");
        jlabl13.setToolTipText("");
        as.add(jlabl13, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 600, 70, 30));

        fi.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        fi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fi.setAutoscrolls(false);
        fi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiActionPerformed(evt);
            }
        });
        as.add(fi, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 600, 230, 30));

        records.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recordsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(records);

        as.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 640, 150));

        jlabl14.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabl14.setForeground(new java.awt.Color(255, 255, 255));
        jlabl14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlabl14.setText("Year:");
        jlabl14.setToolTipText("");
        as.add(jlabl14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 150, 30));

        yr.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        yr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        yr.setAutoscrolls(false);
        yr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yrActionPerformed(evt);
            }
        });
        as.add(yr, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 580, 230, 30));

        jlabl5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlabl5.setForeground(new java.awt.Color(255, 255, 255));
        jlabl5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlabl5.setText("Teacher ID:");
        jlabl5.setToolTipText("");
        as.add(jlabl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 170, 30));

        tid.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        tid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tid.setAutoscrolls(false);
        tid.setEnabled(false);
        tid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidActionPerformed(evt);
            }
        });
        as.add(tid, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, 230, 30));

        teacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(teacher);

        as.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 310, 150));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 320, 220));

        as.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 360, 260));

        getContentPane().add(as, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
     
    }//GEN-LAST:event_formWindowActivated

    private void snameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snameActionPerformed

    private void gidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gidActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
        select.setEnabled(true);
        image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_removeActionPerformed

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_removeMouseClicked

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

    private void selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_selectMouseClicked

    private void studentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsTableMouseClicked
        int rowindex = studentsTable.getSelectedRow();

        if(rowindex < 0){
            JOptionPane.showMessageDialog(null,"Please select an item");
        }else{
            try{
                dbConnector dbc = new dbConnector();
                TableModel tbl = studentsTable.getModel();

                 ResultSet rs = dbc.getData("SELECT * FROM tbl_student WHERE s_id = '"+tbl.getValueAt(rowindex,0)+"'");
            if(rs.next()){
                
                    sname.setText(rs.getString("s_fname"));
            
            
            add.setEnabled(false);
                    addlabel.setForeground(white);
                    checkadd = true;

                }
            }catch(SQLException ex){
                System.out.println(""+ex);
            }
        }

    }//GEN-LAST:event_studentsTableMouseClicked

    private void printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseExited
        print.setBackground(navcolor);
    }//GEN-LAST:event_printMouseExited

    private void printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseEntered
        print.setBackground(hovercolor);
    }//GEN-LAST:event_printMouseEntered

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        update.setBackground(navcolor);
    }//GEN-LAST:event_updateMouseExited

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        update.setBackground(hovercolor);
    }//GEN-LAST:event_updateMouseEntered

    private void clearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseExited
        clear.setBackground(navcolor);
    }//GEN-LAST:event_clearMouseExited

    private void clearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseEntered
        clear.setBackground(hovercolor);
    }//GEN-LAST:event_clearMouseEntered

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        checkadd = true;
        addlabel.setForeground(green);
        gid.setText("");
        tid.setText("");
        sname.setText("");
        yr.setText("");
        dep.setText("");
        c.setText("");
        pre.setText("");
        mid.setText("");    
        prefi.setText("");
        fi.setText("");
        s.setSelectedIndex(0);
    }//GEN-LAST:event_clearMouseClicked

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        add.setBackground(navcolor);
    }//GEN-LAST:event_addMouseExited

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        add.setBackground(hovercolor);
    }//GEN-LAST:event_addMouseEntered

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
       if(checkadd){
           if(sname.getText().isEmpty()||yr.getText().isEmpty()||dep.getText().isEmpty()||c.getText().isEmpty()||pre.getText().isEmpty()||mid.getText().isEmpty()||prefi.getText().isEmpty()||fi.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null,"All Fields are Required");
           }else{
                dbConnector dbc = new dbConnector();
                dbc.insertData("INSERT INTO tbl_grade(t_id, student_name, year, Department, Course, Prelim, Midterm, Prefinal, Final, Status, image)"
                   + "VALUES('"+tid.getText()+"','"+sname.getText()+"', '"+yr.getText()+"', '"+dep.getText()+"', '"+c.getText()+"', '"+pre.getText()+"', "
                       + "'"+mid.getText()+"',  '"+prefi.getText()+"',  '"+fi.getText()+"', '"+s.getSelectedItem()+"', '')");
                
                JOptionPane.showMessageDialog(null,"Successfully Added!");
                
                displayData();
                checkadd=true;
                addlabel.setForeground(white);
                
                gid.setText("");
                tid.setText("");
                sname.setText("");
                yr.setText("");
                dep.setText("");
                c.setText("");
                pre.setText("");
                mid.setText("");
                prefi.setText("");
                fi.setText("");
                s.setSelectedIndex(0);
           }
      }
    }//GEN-LAST:event_addMouseClicked

    private void addlabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addlabelMouseExited
        add.setBackground(navcolor);
    }//GEN-LAST:event_addlabelMouseExited

    private void addlabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addlabelMouseEntered
        add.setBackground(hovercolor);
    }//GEN-LAST:event_addlabelMouseEntered

    private void addlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addlabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addlabelMouseClicked

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked

    }//GEN-LAST:event_userMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        AdminDashboardd adb = new AdminDashboardd();
        adb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
    if(gid.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Select a user first!");
        }else{
    if(sname.getText().isEmpty()||dep.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"All fields are required!");
        }else{
            dbConnector dbc = new dbConnector();
                dbc.updateData("UPDATE tbl_grade SET g_id = '"+gid.getText()+"', t_id = '"+tid.getText()+"',student_name = '"+sname.getText()+"',"
                        + "year = '"+yr.getText()+"',Department = '"+dep.getText()+"',Course = '"+c.getText()+"'"
                                + ",Prelim = '"+pre.getText()+"',Midterm = '"+mid.getText()+"'"
                                        + ",Prefinal = '"+prefi.getText()+"',Final = '"+fi.getText()+"' = "
                                                + "'"+s.getSelectedItem()+"' WHERE g_id = '"+gid.getText()+"'");
                JOptionPane.showMessageDialog(null,"Updated Successfully!");
                displayData();
                 checkadd =(true);
                 addlabel.setForeground(green);
                 gid.setText("");
                 tid.setText("");
                 sname.setText("");
                 yr.setText("");
                 dep.setText("");
                 c.setText("");
                 pre.setText("");
                 mid.setText("");
                 prefi.setText("");
                 fi.setText("");
                 s.setSelectedIndex(0);

                
     }
        }
      
    }//GEN-LAST:event_updateMouseClicked

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
          delete.setBackground(hovercolor);
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
           delete.setBackground(navcolor);
    }//GEN-LAST:event_deleteMouseExited

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
             
    }//GEN-LAST:event_deleteMouseClicked

    private void gradesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradesMouseClicked
        GradesPage gtr = new GradesPage();
        gtr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_gradesMouseClicked

    private void gradesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradesMouseEntered
       grades.setBackground(hovercolor);
    }//GEN-LAST:event_gradesMouseEntered

    private void gradesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradesMouseExited
      grades.setBackground(navcolor);
    }//GEN-LAST:event_gradesMouseExited

    private void printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseClicked
      int rowindex = records.getSelectedRow();
       
       if(rowindex < 0){
         JOptionPane.showMessageDialog(null,"Please select an item");
       }else{
            try{
            dbConnector dbc = new dbConnector();
            TableModel tbl = records.getModel();
            
            ResultSet rs = dbc.getData("SELECT * FROM tbl_grade WHERE g_id= '"+tbl.getValueAt(rowindex,0)+"'");
            if(rs.next()){
                
            GradesPrinting gpg = new GradesPrinting();
            gpg.gid.setText(""+rs.getInt("g_id"));
            gpg.tid.setText(""+rs.getString("t_id"));
            gpg.sname.setText(""+rs.getString("Student_Name"));
            gpg.yr.setText(""+rs.getString("Year"));
            gpg.dep.setText(""+rs.getString("Department"));
            gpg.c.setText(""+rs.getString("Course"));
            gpg.pre.setText(""+rs.getString("Prelim"));
            gpg.mid.setText(""+rs.getString("Midterm"));
            gpg.fi.setText(""+rs.getString("Prefinal"));
            gpg.prefi.setText(""+rs.getString("Final"));   
            gpg.s.setText(""+rs.getString("Status"));
            gpg.image.setIcon(gpg.ResizeImage(rs.getString("image"),null,gpg.image));
            gpg.setVisible(true);
            this.dispose();
            }
        }catch(SQLException ex){
              System.out.println(""+ex);
            }
       }     
        
    }//GEN-LAST:event_printMouseClicked

    private void depActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depActionPerformed

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cActionPerformed

    private void preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preActionPerformed

    private void midActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_midActionPerformed

    private void prefiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prefiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prefiActionPerformed

    private void fiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fiActionPerformed

    private void recordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordsMouseClicked
             int rowindex = records.getSelectedRow();

        if(rowindex < 0){
            JOptionPane.showMessageDialog(null,"Please select an item");
        }else{
            try{
                dbConnector dbc = new dbConnector();
                TableModel tbl = records.getModel();

                 ResultSet rs = dbc.getData("SELECT * FROM tbl_grade WHERE g_id = '"+tbl.getValueAt(rowindex,0)+"'");
            if(rs.next()){
                
                gid.setText(rs.getString("g_id"));
                tid.setText(rs.getString("t_id"));
                sname.setText(rs.getString("student_name"));
                yr.setText(rs.getString("year"));
                dep.setText(rs.getString("Department"));
                c.setText(rs.getString("Course"));
                pre.setText(rs.getString("Prelim"));
                mid.setText(rs.getString("Midterm"));
                prefi.setText(rs.getString("Prefinal"));
                fi.setText(rs.getString("Final"));
                s.setSelectedIndex(0);
            
            
            add.setEnabled(false);
                    addlabel.setForeground(white);
                    checkadd = true;

                }
            }catch(SQLException ex){
                System.out.println(""+ex);
            }
        }   

    }//GEN-LAST:event_recordsMouseClicked

    private void yrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yrActionPerformed

    private void tidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidActionPerformed

    private void teacherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherMouseClicked
          int rowindex = teacher.getSelectedRow();

        if(rowindex < 0){
            JOptionPane.showMessageDialog(null,"Please select an item");
        }else{
            try{
                dbConnector dbc = new dbConnector();
                TableModel tbl = teacher.getModel();

                 ResultSet rs = dbc.getData("SELECT * FROM tbl_teacher WHERE t_id = '"+tbl.getValueAt(rowindex,0)+"'");
            if(rs.next()){
                
                tid.setText(rs.getString("t_id"));
               
            
            
            add.setEnabled(false);
                    addlabel.setForeground(white);
                    checkadd = true;

                }
            }catch(SQLException ex){
                System.out.println(""+ex);
            }
        }
    }//GEN-LAST:event_teacherMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       int rowindex = records.getSelectedRow();
       
       if(rowindex < 0){
         JOptionPane.showMessageDialog(null,"Please select an item");
       }else{
            try{
            dbConnector dbc = new dbConnector();
            TableModel tbl = records.getModel();
            
            ResultSet rs = dbc.getData("SELECT * FROM tbl_grade WHERE g_id= '"+tbl.getValueAt(rowindex,0)+"'");
            if(rs.next()){
                
            GradesPrinting gpg = new GradesPrinting();
            gpg.gid.setText(""+rs.getInt("g_id"));
            gpg.tid.setText(""+rs.getString("t_id"));
            gpg.sname.setText(""+rs.getString("Student_Name"));
            gpg.yr.setText(""+rs.getString("Year"));
            gpg.dep.setText(""+rs.getString("Department"));
            gpg.c.setText(""+rs.getString("Course"));
            gpg.pre.setText(""+rs.getString("Prelim"));
            gpg.mid.setText(""+rs.getString("Midterm"));
            gpg.fi.setText(""+rs.getString("Prefinal"));
            gpg.prefi.setText(""+rs.getString("Final"));   
            gpg.s.setText(""+rs.getString("Status"));
            gpg.image.setIcon(gpg.ResizeImage(rs.getString("image"),null,gpg.image));
            gpg.setVisible(true);
            this.dispose();
            }
        }catch(SQLException ex){
              System.out.println(""+ex);
            }
       }     
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
       print.setBackground(hovercolor);      
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        print.setBackground(navcolor);
    }//GEN-LAST:event_jLabel4MouseExited

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
            java.util.logging.Logger.getLogger(usersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_id;
    private javax.swing.JLabel acc_lname;
    private javax.swing.JLabel acc_lname1;
    private javax.swing.JPanel add;
    private javax.swing.JLabel addlabel;
    private javax.swing.JPanel as;
    public javax.swing.JTextField c;
    private javax.swing.JPanel clear;
    private javax.swing.JPanel delete;
    public javax.swing.JTextField dep;
    public javax.swing.JTextField fi;
    public javax.swing.JTextField gid;
    private javax.swing.JPanel grades;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlabel8;
    private javax.swing.JLabel jlabl10;
    private javax.swing.JLabel jlabl11;
    private javax.swing.JLabel jlabl12;
    private javax.swing.JLabel jlabl13;
    private javax.swing.JLabel jlabl14;
    private javax.swing.JLabel jlabl2;
    private javax.swing.JLabel jlabl4;
    private javax.swing.JLabel jlabl5;
    private javax.swing.JLabel jlabl8;
    private javax.swing.JLabel jlabl9;
    public javax.swing.JTextField mid;
    private javax.swing.JPanel navbar;
    public javax.swing.JTextField pre;
    public javax.swing.JTextField prefi;
    private javax.swing.JPanel print;
    private javax.swing.JTable records;
    public javax.swing.JButton remove;
    private javax.swing.JComboBox<String> s;
    public javax.swing.JButton select;
    public javax.swing.JTextField sname;
    private javax.swing.JTable studentsTable;
    private javax.swing.JTable teacher;
    public javax.swing.JTextField tid;
    private javax.swing.JPanel update;
    private javax.swing.JLabel user;
    public javax.swing.JTextField yr;
    // End of variables declaration//GEN-END:variables
}
