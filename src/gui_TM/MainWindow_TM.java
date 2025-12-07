package gui_TM;
import javax.swing.JOptionPane;
public class MainWindow_TM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainWindow_TM.class.getName());

    public MainWindow_TM() {
        initComponents();
        setLocationRelativeTo(null);
         // 👇 سطر جديد
    String title = util_ES.ConfigUtil_ES.getOrDefault(
            "systemTitle", 
            "Wedding Hall Booking System");
    setTitle(title);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnManageHalls = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        btnNewBooking = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Main Window");

        btnManageHalls.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnManageHalls.setText("Manage Halls");
        btnManageHalls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageHallsActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSearch.setText("Search Booking");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnReports.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReports.setText("Reports");
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        btnNewBooking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNewBooking.setText("New Booking");
        btnNewBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBookingActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageHalls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(187, 187, 187))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(btnManageHalls)
                .addGap(28, 28, 28)
                .addComponent(btnNewBooking)
                .addGap(28, 28, 28)
                .addComponent(btnSearch)
                .addGap(18, 18, 18)
                .addComponent(btnReports)
                .addGap(27, 27, 27)
                .addComponent(btnLogout)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageHallsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageHallsActionPerformed
        HallManagementForm_TM hallForm = new HallManagementForm_TM(); //تكوين اوبجكت من شاشة ادارة القاعات
        hallForm.setLocationRelativeTo(null);  // في نص الشاشة
        hallForm.setVisible(true);
    }//GEN-LAST:event_btnManageHallsActionPerformed

    private void btnNewBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBookingActionPerformed
       BookingForm_TM bookingForm = new BookingForm_TM(); // تفتح شاشة الحجز الجديدة
       bookingForm.setLocationRelativeTo(null);
       bookingForm.setVisible(true);
    }//GEN-LAST:event_btnNewBookingActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       SearchForm_TM searchForm = new SearchForm_TM();
       searchForm.setLocationRelativeTo(null);
       searchForm.setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
      ReportsView_TM reportsForm = new ReportsView_TM();
      reportsForm.setLocationRelativeTo(null);
      reportsForm.setVisible(true);
    }//GEN-LAST:event_btnReportsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int result = JOptionPane.showConfirmDialog(this,"Are you sure you want to logout?", "Confirm Logout",JOptionPane.YES_NO_OPTION);//رسالة تاكيد
        if (result == JOptionPane.YES_OPTION) { //لو المستخدم اختار يس ترجع لشاشة لوق ان
        LoginForm_TM login = new LoginForm_TM(); 
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        this.dispose(); // تصكر المين منيو
    }
    }//GEN-LAST:event_btnLogoutActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> new MainWindow_TM().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageHalls;
    private javax.swing.JButton btnNewBooking;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
