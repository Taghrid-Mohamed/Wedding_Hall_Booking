package gui_TM;
import service_MA.BookingService_MA;
import model_MA.Booking_MA;
import java.util.logging.Level;
import javax.swing.JOptionPane;

public class BookingForm_TM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BookingForm_TM.class.getName());
 private BookingService_MA bookingService = new BookingService_MA();

    public BookingForm_TM() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblHall = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        lblGuests = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        cmbHall = new javax.swing.JComboBox<>();
        txtPhone = new javax.swing.JTextField();
        txtCustomerName = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtGuests = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 450));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitle.setText("New Booking");

        lblPhone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPhone.setText("Phone:");

        lblHall.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblHall.setText("Hall:");

        lblCustomerName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCustomerName.setText("Customer Name:");

        lblGuests.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGuests.setText("Guests:");

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDate.setText("Date:");

        cmbHall.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Hall", "Four Seasons Hall", "Royal Hall", "Crystal Hall", "Movenpink Hall" }));

        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(110, 110, 110)
                                    .addComponent(lblHall))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(lblCustomerName)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(lblDate))
                                .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbHall, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(txtGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(btnSave)
                        .addGap(62, 62, 62)
                        .addComponent(btnClear)
                        .addGap(51, 51, 51)
                        .addComponent(btnCancel)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(lblHall))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbHall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerName)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGuests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGuests))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnClear)
                    .addComponent(btnCancel))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       cmbHall.setSelectedIndex(0);
       txtCustomerName.setText("");
       txtPhone.setText("");
       txtDate.setText("");
       txtGuests.setText("");
       txtCustomerName.requestFocus();
    }//GEN-LAST:event_btnClearActionPerformed
    // نجمع البيانات من الواجهه ونخزنها في متغيرات
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    String hall = (String) cmbHall.getSelectedItem();
    String customerName = txtCustomerName.getText().trim();
    String phone = txtPhone.getText().trim();
    String date = txtDate.getText().trim();
    String guestsText = txtGuests.getText().trim();
        
    // 1) التحقق من اختيار القاعة
    if (hall == null || hall.equals("Select Hall")) {
        JOptionPane.showMessageDialog(this,
                "Please select a hall!",
                "Validation Error",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
        
       // 2) التحقق من الحقول الفارغة
    if (customerName.isEmpty() || phone.isEmpty() || date.isEmpty() || guestsText.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Please fill all fields!",
                "Validation Error",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 3) التحقق من أن الهاتف أرقام فقط
    if (!phone.matches("\\d+")) {
        JOptionPane.showMessageDialog(this,
                "Phone must contain numbers only!",
                "Validation Error",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 4) التحقق من أن عدد الضيوف رقم صحيح > 0
    int guests;
    try {
        guests = Integer.parseInt(guestsText);
        if (guests <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Guests must be > 0",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "Invalid guests number!",
                "Validation Error",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 5) لو كل شيء تمام: نخزن الحجز في الداتا بيز
    try {
        Booking_MA booking = new Booking_MA(hall, customerName, phone, date, guests);

        bookingService.addBooking(booking); // 👈 هذه اللي تكتب في جدول bookings

        JOptionPane.showMessageDialog(this,
                "Booking saved successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);

        // نمسح الحقول باستعمال زر Clear
        btnClearActionPerformed(null);

    } catch (Exception ex) {
        logger.log(Level.SEVERE, "Error saving booking", ex);
        JOptionPane.showMessageDialog(this, "Error saving booking: " + ex.getMessage(),"Error",  JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    public static void main(String args[]) {

    java.awt.EventQueue.invokeLater(() -> new BookingForm_TM().setVisible(true));
}
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbHall;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblGuests;
    private javax.swing.JLabel lblHall;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtGuests;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
