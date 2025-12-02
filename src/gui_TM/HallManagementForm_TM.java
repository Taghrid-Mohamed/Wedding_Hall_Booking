package gui_TM;

public class HallManagementForm_TM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(HallManagementForm_TM.class.getName());

    public HallManagementForm_TM() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Manage Halls");
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblHalls.getModel();
        model.setColumnCount(0);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Capacity");
        model.addColumn("Price");
        model.addColumn("Status");
    }

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHallName = new javax.swing.JTextField();
        txtCapacity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHalls = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Halls");
        setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Hall Name:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Capacity:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Price:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Status:");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Not Available" }));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

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

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        tblHalls.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHalls.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHallsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHalls);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrice)
                            .addComponent(txtHallName)
                            .addComponent(txtCapacity)
                            .addComponent(cmbStatus, 0, 247, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(btnAdd)
                            .addGap(43, 43, 43)
                            .addComponent(btnUpdate)
                            .addGap(52, 52, 52)
                            .addComponent(btnDelete)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClose))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtHallName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String name = txtHallName.getText().trim();
        String capacityText = txtCapacity.getText().trim();
        String priceText = txtPrice.getText().trim();
        String status = (String)cmbStatus.getSelectedItem(); // الحالة من الكومبو
        // تحقق من الحقول الفاضية
        if (name.isEmpty() || capacityText.isEmpty() || priceText.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,"Please fill all fields (Name, Capacity, Price).","Validation Error",javax.swing.JOptionPane.WARNING_MESSAGE);
            return;}
        int capacity;
        double price;
        try {
            capacity = Integer.parseInt(capacityText); // نحول السعة لعدد صحيح
            if (capacity <= 0) {
                javax.swing.JOptionPane.showMessageDialog(this,"Capacity must be > 0.","Validation Error",javax.swing.JOptionPane.WARNING_MESSAGE);
                return;}
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,"Capacity must be an integer number.","Validation Error",javax.swing.JOptionPane.WARNING_MESSAGE);
            return;}
        try { // نحول السعر لرقم عشري
            price = Double.parseDouble(priceText);
            if (price < 0) {
                javax.swing.JOptionPane.showMessageDialog(this,"Price must be >= 0.","Validation Error",javax.swing.JOptionPane.WARNING_MESSAGE);
                return;}
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,"Price must be a valid number.", "Validation Error",javax.swing.JOptionPane.WARNING_MESSAGE);
            return;}
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblHalls.getModel(); // نجيب الموديل متاع الجدول
        int id = model.getRowCount() + 1; // نحدد ID بسيط  مؤقتاً
        model.addRow(new Object[]{id, name, capacity, price, status});
        // نمسح الحقول بعد الإضافة
        txtHallName.setText("");
        txtCapacity.setText("");
        txtPrice.setText("");
        cmbStatus.setSelectedIndex(0);
        txtHallName.requestFocus();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblHalls.getSelectedRow(); //تجيب الصف للمستخدم اختاره
        if (selectedRow == -1) { //لو مافيش صف مختار
            javax.swing.JOptionPane.showMessageDialog(this,"Please select a hall to delete.","No Selection",javax.swing.JOptionPane.WARNING_MESSAGE);
            return;}
        int result = javax.swing.JOptionPane.showConfirmDialog(this,"Are you sure you want to delete this hall?","Confirm Delete",javax.swing.JOptionPane.YES_NO_OPTION);//رسالة التاكيد
        if (result == javax.swing.JOptionPane.YES_OPTION) {
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblHalls.getModel();
            model.removeRow(selectedRow);//حذف الصف 
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int selectedRow = tblHalls.getSelectedRow(); 
        if (selectedRow == -1) { 
            javax.swing.JOptionPane.showMessageDialog(this,"Please select a hall to update.","No Selection",javax.swing.JOptionPane.WARNING_MESSAGE);
            return; }
        String name = txtHallName.getText().trim();    // تجيب القيم الجديدة
        String capacityText = txtCapacity.getText().trim();
        String priceText = txtPrice.getText().trim();
        String status = (String) cmbStatus.getSelectedItem();
        if (name.isEmpty() || capacityText.isEmpty() || priceText.isEmpty()) { 
            javax.swing.JOptionPane.showMessageDialog(this,"Please fill all fields (Name, Capacity, Price).","Validation Error",javax.swing.JOptionPane.WARNING_MESSAGE);
            return;}
        int capacity;
        double price;
        try {
            capacity = Integer.parseInt(capacityText); // تحول السعة لعدد
            price = Double.parseDouble(priceText);     // تحول السعر لرقم
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,"Capacity must be integer and Price must be numeric.","Validation Error",javax.swing.JOptionPane.WARNING_MESSAGE);
            return; }
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblHalls.getModel();
        model.setValueAt(name, selectedRow, 1);     // تحدث العمود 1 = Name
        model.setValueAt(capacity, selectedRow, 2); 
        model.setValueAt(price, selectedRow, 3); 
        model.setValueAt(status, selectedRow, 4); 
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblHallsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHallsMouseClicked
        int row = tblHalls.getSelectedRow(); // نجيب رقم الصف اللي ضغطنا عليه
        if (row == -1) { // لو ما فيش صف مختار (احتياط)
            return; }
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblHalls.getModel(); // تجيب مودل الجدول
        // نعبي الحقول من قيم الصف
        txtHallName.setText(model.getValueAt(row, 1).toString());   // العمود 1 = Name
        txtCapacity.setText(model.getValueAt(row, 2).toString()); 
        txtPrice.setText(model.getValueAt(row, 3).toString());
        String status = model.getValueAt(row, 4).toString(); 
        cmbStatus.setSelectedItem(status); // نختارو نفس الحالة في الكومبو
    }//GEN-LAST:event_tblHallsMouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new HallManagementForm_TM().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHalls;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtHallName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
