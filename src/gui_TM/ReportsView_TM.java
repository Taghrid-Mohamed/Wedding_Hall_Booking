package gui_TM;
import service_MA.BookingService_MA;
import model_MA.Booking_MA;

import java.util.List;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ReportsView_TM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger =
java.util.logging.Logger.getLogger(ReportsView_TM.class.getName());
  private BookingService_MA bookingService = new BookingService_MA();

    public ReportsView_TM() {
        initComponents();
        setLocationRelativeTo(null); 
        setTitle("Reports");
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblReports.getModel();
        model.setColumnCount(0); //نمسح الأعمدة القديمة 
        model.addColumn("Booking ID");
        model.addColumn("Hall");
        model.addColumn("Customer");
        model.addColumn("Date");
        model.addColumn("Guests");
        model.addColumn("Total Price");
        loadReportsTable();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReports = new javax.swing.JTable();
        btnLoad = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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

        btnLoad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

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
                .addGap(207, 207, 207)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnLoad)
                        .addGap(53, 53, 53)
                        .addComponent(btnClose)
                        .addGap(52, 52, 52)
                        .addComponent(jButton1)
                        .addGap(38, 38, 38)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(43, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnLoad)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                      

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed

         loadReportsTable();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         exportToFile();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    try {
        List<Booking_MA> list = bookingService.getAllBookings();

        // HashMap: key = hall name, value = total guests
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();

        for (Booking_MA b : list) {
            String hall = b.getHall();
            int guests = b.getGuests();

            if (map.containsKey(hall)) {
                map.put(hall, map.get(hall) + guests);
            } else {
                map.put(hall, guests);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String hall : map.keySet()) {
            sb.append(hall)
              .append(" : ")
              .append(map.get(hall))
              .append(" guests\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString(), 
                "Guests Summary", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
                "Error generating summary: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
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
        }
    }
// -----------------------------------------
// THIS FUNCTION WE ADD IT HERE
private void exportToFile() {
    try {
        java.io.PrintWriter writer = new java.io.PrintWriter("reports.txt");

        DefaultTableModel model = (DefaultTableModel) tblReports.getModel();

        // كتابة العناوين
        for (int i = 0; i < model.getColumnCount(); i++) {
            writer.print(model.getColumnName(i) + "\t");
        }
        writer.println();

        // كتابة الصفوف
        for (int row = 0; row < model.getRowCount(); row++) {
            for (int col = 0; col < model.getColumnCount(); col++) {
                writer.print(model.getValueAt(row, col) + "\t");
            }
            writer.println();
        }

        writer.close();

        JOptionPane.showMessageDialog(this,
                "Report exported successfully to reports.txt",
                "Export",
                JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception ex) {
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
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblReports;
    // End of variables declaration//GEN-END:variables
}
