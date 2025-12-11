package gui_TM;
import db_MA.DBConnection_MA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmployeeManagement_TM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EmployeeManagement_TM.class.getName());

    
    public EmployeeManagement_TM() {
    initComponents();
    setLocationRelativeTo(null);   // نخلي الفورم في النص
    populateRoleCombo();           // نعبي الكمبو رول
    setupUsersTable();             // نجهز الجدول
    loadUsers();                   // نحمّل المستخدمين من الداتا
}
    private void populateRoleCombo() {
    cmbRole.removeAllItems();     // نمسح أي عناصر قديمة
    cmbRole.addItem("admin");     // مدير
    cmbRole.addItem("employee");  // موظف
}
    private void setupUsersTable() {
    DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();
    model.setRowCount(0);  // نضمن ما فيش صفوف قديمة
    model.setColumnIdentifiers(new Object[]{"ID", "Username", "Role"}); // عناوين الأعمدة
}
    private void loadUsers() {
    DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();
    model.setRowCount(0);  // نفرّغ الجدول

    String sql = "SELECT id, username, role FROM users";

    try (Connection conn = DBConnection_MA.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String role = rs.getString("role");

            model.addRow(new Object[]{id, username, role});
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Error loading users: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
    private void clearFields() {
    txtUsername.setText("");
    txtPassword.setText("");
    cmbRole.setSelectedIndex(-1);
    tblUsers.clearSelection();   // نلغي اختيار أي صف في الجدول
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        cmbRole = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Password:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Role:");

        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Manage Employess");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                " ID", "Username", "Role"
            }
        ));
        tblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsers);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword)
                            .addComponent(txtUsername))
                        .addGap(80, 80, 80))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnClose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       int selectedRow = tblUsers.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this,
                "يرجى اختيار موظف من الجدول أولاً.",
                "تنبيه",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();
    int id = (int) model.getValueAt(selectedRow, 0);  // العمود الأول = ID

    int choice = JOptionPane.showConfirmDialog(this,
            "هل أنت متأكد من حذف هذا الموظف؟",
            "تأكيد الحذف",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

    if (choice != JOptionPane.YES_OPTION) {
        return;
    }

    String sql = "DELETE FROM users WHERE id = ?";

    try (Connection conn = DBConnection_MA.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            JOptionPane.showMessageDialog(this,
                    "تم حذف الموظف.",
                    "نجاح",
                    JOptionPane.INFORMATION_MESSAGE);
            loadUsers();
            clearFields();
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "حدث خطأ أثناء حذف الموظف: " + ex.getMessage(),
                "خطأ",
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
     String username = txtUsername.getText().trim();
    String password = new String(txtPassword.getPassword());
    String role = (String) cmbRole.getSelectedItem();

    if (username.isEmpty() || password.isEmpty()  ||role == null) {
        JOptionPane.showMessageDialog(this,"يرجى إدخال اسم مستخدم، كلمة مرور، واختيار دور.","تنبيه",JOptionPane.WARNING_MESSAGE);
        return;}
    String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
    try (Connection conn = DBConnection_MA.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, role);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(this,"تم إضافة الموظف بنجاح.","نجاح", JOptionPane.INFORMATION_MESSAGE);
            loadUsers();    // نرجع نحمّل الجدول
            clearFields(); } // نمسح الحقول
        } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "حدث خطأ أثناء إضافة الموظف: " + ex.getMessage(), "خطأ",JOptionPane.ERROR_MESSAGE);}
    
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
     int selectedRow = tblUsers.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this,
                "يرجى اختيار موظف من الجدول أولاً.",
                "تنبيه",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();
    int id = (int) model.getValueAt(selectedRow, 0);  // العمود 0 = ID

    String username = txtUsername.getText().trim();
    String password = new String(txtPassword.getPassword());
    String role = (String) cmbRole.getSelectedItem();

    if (username.isEmpty() || role == null) {
        JOptionPane.showMessageDialog(this,
                "يرجى إدخال اسم مستخدم واختيار دور.",
                "تنبيه",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    String sql;
    boolean hasPassword = !password.isEmpty();

    if (hasPassword) {
        // لو كتب باسورد جديد، نحدّث كله
        sql = "UPDATE users SET username = ?, password = ?, role = ? WHERE id = ?";
    } else {
        // لو خلى الباسورد فاضي، ما نغيروش
        sql = "UPDATE users SET username = ?, role = ? WHERE id = ?";
    }

    try (Connection conn = DBConnection_MA.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, username);

        if (hasPassword) {
            ps.setString(2, password);
            ps.setString(3, role);
            ps.setInt(4, id);
        } else {
            ps.setString(2, role);
            ps.setInt(3, id);
        }

        int rows = ps.executeUpdate();

        if (rows > 0) {
            JOptionPane.showMessageDialog(this,
                    "تم تعديل بيانات الموظف.",
                    "نجاح",
                    JOptionPane.INFORMATION_MESSAGE);
            loadUsers();
            clearFields();
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "حدث خطأ أثناء تعديل الموظف: " + ex.getMessage(),
                "خطأ",
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsersMouseClicked
                                   
    int selectedRow = tblUsers.getSelectedRow();
    if (selectedRow == -1) return;

    DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();

    int id = (int) model.getValueAt(selectedRow, 0);          // ID (ما نحتاجوهش في الحقول)
    String username = (String) model.getValueAt(selectedRow, 1);
    String role = (String) model.getValueAt(selectedRow, 2);

    txtUsername.setText(username);
    txtPassword.setText("");                                  // نخليه فاضي (ما نعرضوش الباسورد)
    cmbRole.setSelectedItem(role);
    }//GEN-LAST:event_tblUsersMouseClicked

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new EmployeeManagement_TM().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsers;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
