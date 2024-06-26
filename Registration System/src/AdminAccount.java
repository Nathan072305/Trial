
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AdminAccount extends javax.swing.JFrame {
    
   
    public AdminAccount() {
        initComponents();
        try{
            Connection();
            Function();
            
        } catch(SQLException ex){
            
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    Connection Connection;
    
    Statement Statement;
    
    private static final String DbName = "accountdata";
    private static final String DbDriver = "com.mysql.cj.jdbc.Driver";
    private static final String DbUrl = "jdbc:mysql://localhost:3306/" + DbName;
    private static final String DbUsername = "root";
    private static final String DbPassword = "";
    
    
    
    public void Connection() throws SQLException{
        
        try {
            Class.forName(DbDriver);
            Connection = DriverManager.getConnection(DbUrl, DbUsername, DbPassword);
            Statement = Connection.createStatement();
            if (Connection != null) {
                JOptionPane.showMessageDialog(null, "Welcome to Admin Page");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    private int getIdForUpdate(String username, String name, String password) {
        int id = -1;
        
        try {
            String selectQuery = "SELECT id FROM admintable WHERE Username=? OR Name=? OR Password=?";
            PreparedStatement pstmt = Connection.prepareStatement(selectQuery);
            pstmt.setString(1, username);
            pstmt.setString(2, name);
            pstmt.setString(3, password);

            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    
    
    public void Function(){
        PreparedStatement pst;
        
        try {
            
            pst = Connection.prepareStatement("SELECT * FROM admintable");
            
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int columnCount = rsmd.getColumnCount();
            
            DefaultTableModel tableModel = (DefaultTableModel) DetailTable.getModel();
            tableModel.setRowCount(0);
            
            while (rs.next()) {
                Vector<Object> rowData = new Vector<>();
                for (int i = 2; i <= columnCount; i++) {
                    Object value = rs.getObject(i);
                    
                    if (value instanceof Number) {
                        rowData.add(value);
                    } else {
                        
                        rowData.add(value.toString());
                    }
                }
                tableModel.addRow(rowData);
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DetailTable = new javax.swing.JTable();
        UpdateButton = new javax.swing.JToggleButton();
        Delete = new javax.swing.JToggleButton();
        AddNewButton = new javax.swing.JToggleButton();
        BackButton = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        UsernameTextField = new javax.swing.JTextField();
        PasswordTextField = new javax.swing.JTextField();
        asa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Admin Account");

        DetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Username", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DetailTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DetailTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DetailTable);

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        AddNewButton.setText("Add New");
        AddNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewButtonActionPerformed(evt);
            }
        });

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Name");

        NameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Username");

        asa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        asa.setForeground(new java.awt.Color(0, 0, 0));
        asa.setText("Password");

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BackButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddNewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UpdateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(79, 79, 79))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(asa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(asa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddNewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void DetailTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetailTableMouseClicked
        DefaultTableModel Table = (DefaultTableModel)DetailTable.getModel();
        int selectedRows = DetailTable.getSelectedRow();
        
        NameTextField.setText(Table.getValueAt(selectedRows, 1).toString());
        UsernameTextField.setText(Table.getValueAt(selectedRows, 2).toString());
        PasswordTextField.setText(Table.getValueAt(selectedRows, 3).toString());
        DetailTable.isEditing();
        
    }//GEN-LAST:event_DetailTableMouseClicked
    
    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        
        PreparedStatement pst;
        
        String name = NameTextField.getText();
        String username = UsernameTextField.getText();
        String password = PasswordTextField.getText();
        String regex2 = "^[a-zA-Z\\s]+,\\s*[a-zA-Z\\s]+$";
        

        Pattern pattern2 = Pattern.compile(regex2);
        

        Matcher matcherName = pattern2.matcher(name);
        
        if (name.equals("") || username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Make sure to fill out the empty textfield");
        }else if(!matcherName.matches()){
            JOptionPane.showMessageDialog(null, "Invalid name. Name should contain only alphabet characters");
            
        } else {
            
            try{
                
                int Update = JOptionPane.showConfirmDialog(null, "Confirm to Update", "Warning", JOptionPane.YES_NO_OPTION);
                
                if (Update == JOptionPane.YES_OPTION) {
                    
                    int id = getIdForUpdate(username,name,password);
                    String updateQuery = "UPDATE admintable SET Username=?, Password=?, Name=? WHERE id=?";
                    pst = Connection.prepareStatement(updateQuery);
                    pst.setString(1, username);
                    pst.setString(2, password);
                    pst.setString(3, name);
                    pst.setInt(4, id);
                    
                    int rowsAffected = pst.executeUpdate();
                    Function();
                    
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Successfully Updated");
                    } else {
                        JOptionPane.showMessageDialog(null, "No details to update");
                    }
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error occurred while updating. Please try again later.");
            }
            
        }
    }//GEN-LAST:event_UpdateButtonActionPerformed
    
    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        DefaultTableModel table = (DefaultTableModel) DetailTable.getModel();
        int selectedRow = DetailTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
            return;
        }
        
        String name = NameTextField.getText();
        String username = UsernameTextField.getText();
        
        PreparedStatement pst;
        
        try {
            
            String rowName = table.getValueAt(selectedRow, 0).toString();
            String rowUsername = table.getValueAt(selectedRow, 2).toString();
            
            int deleteItem = JOptionPane.showConfirmDialog(null, "Confirm to delete", "Warning", JOptionPane.YES_NO_OPTION);
            
            if (deleteItem == JOptionPane.YES_OPTION) {
                
                pst = Connection.prepareStatement("DELETE FROM admintable WHERE Name = ? AND Username = ?");
                pst.setString(1, name);
                pst.setString(2, username);
                
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    
                    table.removeRow(selectedRow);
                    
                    for (int i = selectedRow; i < table.getRowCount(); i++) {
                        table.setValueAt(i + 1, i, 0);
                    }
                    
                    JOptionPane.showMessageDialog(null, "Record has been deleted");
                    Function();
                    
                    NameTextField.setText("");
                    NameTextField.requestFocus();
                    UsernameTextField.setText("");
                    PasswordTextField.setText("");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "No record found with the specified Name and Username.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input for row number.");
        }
    }//GEN-LAST:event_DeleteActionPerformed
    
    private void AddNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewButtonActionPerformed
        PreparedStatement pst;
        
        String name = NameTextField.getText();
        String username = UsernameTextField.getText();
        String password = PasswordTextField.getText();

        String regex2 = "^[a-zA-Z\\s]+,\\s*[a-zA-Z\\s]+$";

        Pattern pattern2 = Pattern.compile(regex2);

        Matcher matcherName = pattern2.matcher(name);
        
        if(name.equals("")||username.equals("")||password.equals("")){
            JOptionPane.showMessageDialog(null, "Make sure to fill out the empty textfield");
        }else if(!matcherName.matches()){
            JOptionPane.showMessageDialog(null, "Invalid name format. Please use Last Name, First Name format and make sure to avoid");
            
        } else {
            
            String selectNameQuery = "SELECT COUNT(*) AS count FROM admintable WHERE Name = ?";
            try {
                pst = Connection.prepareStatement(selectNameQuery);
                pst.setString(1, NameTextField.getText());
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    int count = rs.getInt("count");
                    if (count > 0) {
                        JOptionPane.showMessageDialog(null, "Name Taken");
                        return;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       
            try {
                int Add = JOptionPane.showConfirmDialog(null, "Confirm to Add Data", "Warning", JOptionPane.YES_NO_OPTION);
                
                if (Add == JOptionPane.YES_OPTION) {
                    
                    pst = Connection.prepareStatement("INSERT INTO admintable(Name, Username, Password) VALUES (?, ?, ?)");
                    
                    pst.setString(1, NameTextField.getText());
                    pst.setString(2, UsernameTextField.getText());
                    pst.setString(3, PasswordTextField.getText());
                    
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Added");
                    Function();
                    
                    NameTextField.setText("");
                    NameTextField.requestFocus();
                    UsernameTextField.setText("");
                    PasswordTextField.setText("");

                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_AddNewButtonActionPerformed
    
    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        int BackOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to go back?", "Warning", JOptionPane.YES_NO_OPTION);
        
        if (BackOption == JOptionPane.YES_OPTION) {
            
        MenuAdmin MenuAdmin = new MenuAdmin();
        MenuAdmin.setVisible(true);
        dispose();
        }
    }//GEN-LAST:event_BackButtonActionPerformed
    
    private void NameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTextFieldActionPerformed
    
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        
        int Option = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Warning", JOptionPane.YES_NO_OPTION);
        if (Option == JOptionPane.YES_OPTION){
            System.exit(0);
        }
        
    }//GEN-LAST:event_jLabel4MouseClicked
    
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
            java.util.logging.Logger.getLogger(AdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAccount().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton AddNewButton;
    private javax.swing.JToggleButton BackButton;
    private javax.swing.JToggleButton Delete;
    private javax.swing.JTable DetailTable;
    public static javax.swing.JTextField NameTextField;
    private javax.swing.JTextField PasswordTextField;
    private javax.swing.JToggleButton UpdateButton;
    private javax.swing.JTextField UsernameTextField;
    private javax.swing.JLabel asa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
