package gui_TM;
import service_MA.BookingService_MA;
import model_MA.Booking_MA;
import report_ES.ReportExporter_ES;
import report_ES.FileExporter_ES;

import threads_ES.AutoRefreshThread_ES;
import threads_ES.ProgressBarThread_ES;
import util_ES.LoggerUtil_ES;
import util_ES.ConfigUtil_ES;


import java.util.List;
import java.util.HashMap;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ReportsView_TM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger =
java.util.logging.Logger.getLogger(ReportsView_TM.class.getName());
  private BookingService_MA bookingService = new BookingService_MA();
  private AutoRefreshThread_ES autoRefreshThread;

  
public ReportsView_TM() {
    initComponents();
    setLocationRelativeTo(null);
    setTitle("Reports");

    // نخفي الشريط في البداية
    jProgressBar2.setVisible(false);

    String company = ConfigUtil_ES.getOrDefault("companyName", "Wedding Company");
    lblTitle.setText("Reports - " + company);

    prepareTable();
    loadReportsTable();

    autoRefreshThread = new AutoRefreshThread_ES(this);
    autoRefreshThread.start();
}
    private void prepareTable() {
        DefaultTableModel model = (DefaultTableModel) tblReports.getModel();
        model.setColumnCount(0);
        model.addColumn("Booking ID");
        model.addColumn("Hall");
        model.addColumn("Customer");
        model.addColumn("Date");
        model.addColumn("Guests");
        model.addColumn("Total Price");
    }

    // -------------------------------
    // زر Load
    // ------------------

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReports = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jProgressBar2 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitle.setText("Reports");

        tblReports.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblReports);

        btnClose.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jButton1.setText("Export ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Summary ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(375, 375, 375)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnClose)
                                .addGap(91, 91, 91)
                                .addComponent(jButton1)
                                .addGap(74, 74, 74)
                                .addComponent(jButton2)))))
                .addGap(428, 428, 428))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                      

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        
        if (autoRefreshThread != null) autoRefreshThread.stopRefreshing();
        this.dispose();

    }//GEN-LAST:event_btnCloseActionPerformed
//
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                       
    // نخلي الشريط يبدأ من 0 ويبان
    jProgressBar2.setValue(0);
    jProgressBar2.setVisible(true);

    // نبدأ الثريد اللي يحرّك الشريط
    ProgressBarThread_ES progressThread = new ProgressBarThread_ES(jProgressBar2);
    progressThread.start();

    // نخلو عملية التصدير تخدم في ثريد آخر
    new Thread(() -> {
        try {
            // التصدير (I/O + DB)
            exportToFile();
        } finally {
            // نوقف ثريد البار
            progressThread.stopRunning();

            // نرجع للـ Swing Thread باش نغيّر على الواجهه
            javax.swing.SwingUtilities.invokeLater(() -> {
                jProgressBar2.setValue(100);   // يوصل لآخره
                jProgressBar2.setVisible(false); // وبعدها يختفي
            });
        }
    }).start();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  
        try {
            List<Booking_MA> list = bookingService.getAllBookings();
            HashMap<String, Integer> map = new HashMap<>();

            for (Booking_MA b : list) {
                map.put(b.getHall(), map.getOrDefault(b.getHall(), 0) + b.getGuests());
            }

            StringBuilder sb = new StringBuilder();
            for (String hall : map.keySet()) {
                sb.append(hall).append(" : ").append(map.get(hall)).append(" guests\n");
            }

            JOptionPane.showMessageDialog(this, sb.toString(), "Guests Summary",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    

    }//GEN-LAST:event_jButton2ActionPerformed

     // دالة خاصة لتحميل البيانات من الداتا بيز للجدول
    private void loadReportsTable() {
       
        DefaultTableModel model = (DefaultTableModel) tblReports.getModel();
        model.setRowCount(0); // نمسح أي بيانات قديمة

        try {
            List<Booking_MA> list = bookingService.getAllBookings();

            for (Booking_MA b : list) {
                // هنا نحسب "Total Price" بشكل بسيط:
                // مثلاً نفترض سعر الشخص الواحد 100 (بس مثال، تقدري تغيريه)
                double totalPrice = b.getGuests() * 100.0;

                model.addRow(new Object[] {
                        b.getId(),
                        b.getHall(),
                        b.getCustomerName(),
                        b.getDate(),
                        b.getGuests(),
                        totalPrice
                });
              
            }

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error loading reports", ex);
            JOptionPane.showMessageDialog(this,
                    "Error loading reports: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }}
       
 // هذه يستعملها الثريد عشان يحدث الجدول
public void refreshFromThread() {
    loadReportsTable();
}

   
// -----------------------------------------
// THIS FUNCTION WE ADD IT HERE
private void exportToFile() {
    try {
        // نجيب كل الحجوزات من السيرفس (شغل عضو 2)
        List<Booking_MA> list = bookingService.getAllBookings();

        // نستعمل كلاس العضو 3 FileExporter_ES
        FileExporter_ES.exportBookingsToTxt(list, "reports.txt");

        util_ES.LoggerUtil_ES.logInfo("Exported " + list.size() + " bookings to reports.txt");

        JOptionPane.showMessageDialog(this,
                "Report exported successfully to reports.txt",
                "Export",
                JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception ex) {
        util_ES.LoggerUtil_ES.logError("Error exporting report: " + ex.getMessage());

        JOptionPane.showMessageDialog(this,
                "Error exporting report: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}

    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            new ReportsView_TM().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblReports;
    // End of variables declaration//GEN-END:variables
}
