package gui_TM;
import service_MA.BookingService_MA;
import model_MA.Booking_MA;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import db_MA.DBConnection_MA; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
 
public class SearchForm_TM extends javax.swing.JFrame {
    private boolean adminMode = false; // لو true نعرض Edit، لو false نخبيه
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SearchForm_TM.class.getName());
  private BookingService_MA bookingService = new BookingService_MA();
   public SearchForm_TM() {
    initComponents();
    setLocationRelativeTo(null);     // اختيارية: نخلي الفورم في النص
    btnEditBooking.setVisible(false); // 👈 نخبي زر التعديل افتراضياً
    setTitle("Search Bookings");      // عنوان للموظف
        javax.swing.table.DefaultTableModel model =(javax.swing.table.DefaultTableModel) tblResults.getModel();
        model.setColumnCount(0);  // تمسح الأعمدة القديمة
        model.addColumn("Booking ID");
        model.addColumn("Hall");
        model.addColumn("Customer");
        model.addColumn("Date");
        model.addColumn("Guests");
    }
   // نستدعوها من واجهة الأدمن باش نفعّل وضع الإدارة
public void enableAdminMode() {
    btnEditBooking.setVisible(true);    // نبيّن زر التعديل
    setTitle("Manage Bookings");        // نغيّر عنوان النافذة
}
    public SearchForm_TM(boolean adminMode) {
    initComponents();
    this.adminMode = adminMode;      // نخزن هل اللي فاتح النافذة أدمن أو لا
    setLocationRelativeTo(null);     // نخلي الفورم في النص
    configureMode();                 // نضبط الأزرار حسب الـ mode
}
    private void configureMode() {
    // زر الحذف يطلع للجميع (موظف و أدمن)
    btnDeleteBooking.setVisible(true);

    // زر التعديل Edit بس للأدمن
    if (adminMode) {
        btnEditBooking.setVisible(true);
        setTitle("Manage Bookings");   // عنوان خاص بالأدمن
    } else {
        btnEditBooking.setVisible(false);
        setTitle("Search Bookings");   // عنوان خاص بالموظف
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtHallSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDateSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResults = new javax.swing.JTable();
        btnDeleteBooking = new javax.swing.JButton();
        btnEditBooking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search Booking");
        setPreferredSize(new java.awt.Dimension(600, 400));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Hall:");

        txtHallSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtHallSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHallSearchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Date:");

        txtDateSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        tblResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblResults);

        btnDeleteBooking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeleteBooking.setText("Delete");
        btnDeleteBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBookingActionPerformed(evt);
            }
        });

        btnEditBooking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditBooking.setText("Edit");
        btnEditBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBookingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(9, 9, 9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDateSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHallSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnClear)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteBooking)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnClose))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHallSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDateSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnClear)
                    .addComponent(btnDeleteBooking)
                    .addComponent(btnEditBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
         this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtHallSearch.setText("");
        txtDateSearch.setText("");
        javax.swing.table.DefaultTableModel model =(javax.swing.table.DefaultTableModel) tblResults.getModel(); // نجيب المودل ليتحكم ف الجدول باش نتحكم ف البيانات داخله
        model.setRowCount(0); //نفضي كل الصفوف
 
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
    String customerName="" ;                                          
    String hall = txtHallSearch.getText().trim();
    String date = txtDateSearch.getText().trim();

    DefaultTableModel model = (DefaultTableModel) tblResults.getModel();
    model.setRowCount(0); // نمسح أي نتائج قديمة

    try {
        // نجيب النتائج من السيرفس
        List<Booking_MA> results = bookingService.searchBookings(customerName, hall, date);

        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No bookings found.",
                    "Search",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // نضيف النتائج للجدول
        for (Booking_MA b : results) {
            model.addRow(new Object[]{
                    b.getId(),
                    b.getHall(),
                    b.getCustomerName(),
                    b.getDate(),
                    b.getGuests()
            });
        }

    } catch (Exception ex) {
        logger.log(Level.SEVERE, "Error searching bookings", ex);
        JOptionPane.showMessageDialog(this,
                "Error searching bookings: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtHallSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHallSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHallSearchActionPerformed

    private void btnDeleteBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBookingActionPerformed
     int selectedRow = tblResults.getSelectedRow(); // تجيب الصف اللي اختاره 
    if (selectedRow == -1) { 
        JOptionPane.showMessageDialog(this, "يرجى اختيار حجز من الجدول أولاً.","تنبيه",JOptionPane.WARNING_MESSAGE);
        return; }
    DefaultTableModel model = (DefaultTableModel) tblResults.getModel(); // تاخذ موديل الجدول
    int bookingId = (int) model.getValueAt(selectedRow, 0); // تحصل رقم الحجز من العمود الأول
    int choice = JOptionPane.showConfirmDialog(this, "هل أنت متأكد أنك تريد حذف هذا الحجز؟", "تأكيد", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    if (choice != JOptionPane.YES_OPTION) {   // لو اختار NO
        return;}
    String deleteQuery = "DELETE FROM bookings WHERE id = ?"; // أمر الحذف من الداتا بيز
    try (Connection conn = DBConnection_MA.getConnection();           
           PreparedStatement ps = conn.prepareStatement(deleteQuery)) {
        ps.setInt(1, bookingId); // نعطي رقم الحجز
        int rowsAffected = ps.executeUpdate(); // ننفذ الحذف
        if (rowsAffected > 0) {
            model.removeRow(selectedRow);  // نحذف الصف من الواجهة
            JOptionPane.showMessageDialog(this, "تم حذف الحجز بنجاح.","نجاح", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,"تعذر حذف الحجز. ربما تم حذفه مسبقاً.","خطأ", JOptionPane.ERROR_MESSAGE);}
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "حدث خطأ أثناء حذف الحجز.","خطأ", JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_btnDeleteBookingActionPerformed

    private void btnEditBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBookingActionPerformed
                                                   
    // نجيب الصف المختار من الجدول
    int selectedRow = tblResults.getSelectedRow();   // tblResults هو جدول النتائج

    if (selectedRow == -1) {                         // لو ما اختارش ولا حجز
        JOptionPane.showMessageDialog(this,
                "يرجى اختيار حجز من الجدول أولاً.",
                "تنبيه",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    DefaultTableModel model = (DefaultTableModel) tblResults.getModel(); // موديل الجدول

    // نجيب رقم الحجز من العمود الأول (id)
    int bookingId = (int) model.getValueAt(selectedRow, 0);

    // نجيب القيم الحالية من الجدول (باش نظهروهم في الـ Dialog)
    String currentHall   = model.getValueAt(selectedRow, 1).toString();  // الصالة
    String currentCust   = model.getValueAt(selectedRow, 2).toString();  // الزبون
    String currentDate   = model.getValueAt(selectedRow, 3).toString();  // التاريخ
    String currentGuests = model.getValueAt(selectedRow, 4).toString();  // عدد الضيوف

    // نخلو الأدمن يعدّل التاريخ وعدد الضيوف من خلال Dialog
    String newDate = JOptionPane.showInputDialog(this,
            "أدخل التاريخ الجديد للحجز:",
            currentDate);   // القيمة الحالية كـ default

    if (newDate == null || newDate.trim().isEmpty()) {
        // لو لغى أو خلى التاريخ فاضي → ما نكملوش
        return;
    }

    String newGuestsStr = JOptionPane.showInputDialog(this,
            "أدخل عدد الضيوف الجديد:",
            currentGuests);

    if (newGuestsStr == null || newGuestsStr.trim().isEmpty()) {
        return;
    }

    int newGuests;
    try {
        newGuests = Integer.parseInt(newGuestsStr.trim());   // نحوله لرقم
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this,
                "عدد الضيوف يجب أن يكون رقم صحيح.",
                "خطأ",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    // أمر التعديل في الداتا بيز
    // ⚠️ تأكدي من اسم عمود التاريخ في جدول bookings:
    // لو اسمه booking_date خليه هيكي
    // لو اسمه date فقك، بدّلي booking_date إلى date
    String updateQuery = "UPDATE bookings SET date = ?, guests = ? WHERE id = ?";

    try (Connection conn = DBConnection_MA.getConnection();
         PreparedStatement ps = conn.prepareStatement(updateQuery)) {

        ps.setString(1, newDate);    // التاريخ الجديد
        ps.setInt(2, newGuests);     // عدد الضيوف الجديد
        ps.setInt(3, bookingId);     // رقم الحجز

        int rows = ps.executeUpdate();   // ننفذ التعديل

        if (rows > 0) {
            // لو التعديل نجح → نحدّث الجدول في الواجهة أيضاً
            model.setValueAt(newDate,   selectedRow, 3);  // نعدل التاريخ في الجدول
            model.setValueAt(newGuests, selectedRow, 4);  // نعدل عدد الضيوف في الجدول

            JOptionPane.showMessageDialog(this,
                    "تم تعديل بيانات الحجز بنجاح.",
                    "نجاح",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "تعذر تعديل بيانات الحجز.",
                    "خطأ",
                    JOptionPane.ERROR_MESSAGE);
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "حدث خطأ أثناء تعديل الحجز.",
                "خطأ",
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnEditBookingActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new SearchForm_TM().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDeleteBooking;
    private javax.swing.JButton btnEditBooking;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResults;
    private javax.swing.JTextField txtDateSearch;
    private javax.swing.JTextField txtHallSearch;
    // End of variables declaration//GEN-END:variables
}
