package gui_TM;
import javax.swing.JButton;
import javax.swing.JTable;

import javax.swing.JOptionPane;

public class AdminWindow_TM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminWindow_TM.class.getName());

    
    
    public AdminWindow_TM() {
        initComponents();
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnNewBooking = new javax.swing.JButton();
        btnManageBooking = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnManageHalls = new javax.swing.JButton();
        btnManageEmployees = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Admin Window");

        btnNewBooking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNewBooking.setText("New Booking");
        btnNewBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBookingActionPerformed(evt);
            }
        });

        btnManageBooking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnManageBooking.setText("Manage Booking");
        btnManageBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageBookingActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnManageHalls.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnManageHalls.setText("Manage Halls");
        btnManageHalls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageHallsActionPerformed(evt);
            }
        });

        btnManageEmployees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnManageEmployees.setText("Manage Employees");
        btnManageEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEmployeesActionPerformed(evt);
            }
        });

        btnReports.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReports.setText("Reports");
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnManageBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManageEmployees)
                            .addComponent(btnManageHalls, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addComponent(btnNewBooking)
                .addGap(29, 29, 29)
                .addComponent(btnManageBooking)
                .addGap(27, 27, 27)
                .addComponent(btnManageEmployees)
                .addGap(33, 33, 33)
                .addComponent(btnManageHalls)
                .addGap(30, 30, 30)
                .addComponent(btnReports)
                .addGap(28, 28, 28)
                .addComponent(btnLogout)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBookingActionPerformed
    BookingForm_TM bookingForm = new BookingForm_TM();
    bookingForm.setLocationRelativeTo(this);  // نخليه يطلع في النص بالنسبة للفورم الحالي
    bookingForm.setVisible(true); // نعرض الفورم
    }//GEN-LAST:event_btnNewBookingActionPerformed

    private void btnManageHallsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageHallsActionPerformed
    HallManagementForm_TM hallsForm = new HallManagementForm_TM();
    hallsForm.setLocationRelativeTo(this);
    hallsForm.setVisible(true);
    }//GEN-LAST:event_btnManageHallsActionPerformed

    private void btnManageEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEmployeesActionPerformed
                                                   
    EmployeeManagement_TM empForm = new EmployeeManagement_TM();
    empForm.setLocationRelativeTo(this);
    empForm.setVisible(true);
    }//GEN-LAST:event_btnManageEmployeesActionPerformed

    private void btnManageBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageBookingActionPerformed
    SearchForm_TM manageBooking = new SearchForm_TM(); // ننشئ الفورم
    manageBooking.enableAdminMode();                   // 👈 نفعّل وضع الأدمن (يظهر Edit)
    manageBooking.setLocationRelativeTo(this);
    manageBooking.setVisible(true);
    }//GEN-LAST:event_btnManageBookingActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
    ReportsView_TM reports = new ReportsView_TM();
    reports.setLocationRelativeTo(this);
    reports.setVisible(true);
    }//GEN-LAST:event_btnReportsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
    // نسكر شاشة الأدمن ونرجع لشاشة الدخول
    this.dispose(); 
    new LoginForm_TM().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new AdminWindow_TM().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageBooking;
    private javax.swing.JButton btnManageEmployees;
    private javax.swing.JButton btnManageHalls;
    private javax.swing.JButton btnNewBooking;
    private javax.swing.JButton btnReports;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
