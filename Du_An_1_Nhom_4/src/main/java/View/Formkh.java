/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.KhachHang;
import Service.ImanageKhachHangService;
import Service.Impl.manageKhachHangService;
import ViewModel.QLKhachHang;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL 5515
 */
public class Formkh extends javax.swing.JFrame {

   private final ImanageKhachHangService imanageKhachHangService;
    public Formkh() {
        initComponents();
        imanageKhachHangService = new manageKhachHangService();
        loadTable();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        txtdiachi = new javax.swing.JTextField();
        txtngaysinh = new javax.swing.JTextField();
        txtsdt = new javax.swing.JTextField();
        txtdiemtichluy = new javax.swing.JTextField();
        rdonu = new javax.swing.JRadioButton();
        rdonam = new javax.swing.JRadioButton();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKH = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã");

        jLabel2.setText("Tên");

        jLabel3.setText("Giới tính ");

        jLabel4.setText("Địa chỉ");

        jLabel5.setText("Ngày sinh");

        jLabel6.setText("SĐT");

        jLabel7.setText("Điểm tích lũy");

        rdonu.setText("Nữ");

        rdonam.setText("Nam");

        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        tblKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "Giới tính", "Địa chỉ", "Ngày sinh", "SĐT", "Điểm tích lũy "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnadd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btndelete)
                        .addGap(110, 110, 110))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtma)
                                            .addComponent(txtten, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdonam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                        .addComponent(rdonu)))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtdiemtichluy, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(txtsdt)
                                    .addComponent(txtngaysinh)
                                    .addComponent(txtdiachi)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(btnupdate)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdonu)
                    .addComponent(rdonam))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtdiemtichluy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd)
                    .addComponent(btnupdate)
                    .addComponent(btndelete))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        KhachHang kh = getdataFromInput();
        if (txtten.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống tên ");
            return;
        }
        if (txtdiachi.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống địa chỉ");
            return;
        }

        if (txtngaysinh.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống ngày sinh ");
            return;
        }
        if (txtsdt.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống sdt");
            return;
        }

        if (txtdiemtichluy.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống điểm tích lũy ");
            return;
        }
        
        int diem = Integer.parseInt(txtdiemtichluy.getText());
        if(diem <0){
         JOptionPane.showMessageDialog(this, "Điểm tích lũy > 0");
         return;
        }
        if(diem == 0){
        JOptionPane.showMessageDialog(this, "Điểm tích lũy phải là số nguyên");
         return;
        }
        // add
        if (imanageKhachHangService.add(kh) != null) {
            JOptionPane.showMessageDialog(this, "Add thành công ");

        } else {
            JOptionPane.showMessageDialog(this, "Add thất bại  ");
            return;
        }
        loadTable();
        clearForm();

    }//GEN-LAST:event_btnaddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
         int row = tblKH.getSelectedRow();
        KhachHang kh = getdataFromInput();
        String makh = tblKH.getValueAt(row, 0).toString();
        if (txtten.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống tên ");
            return;
        }
        if (txtdiachi.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống địa chỉ");
            return;
        }

        if (txtngaysinh.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống ngày sinh ");
            return;
        }
        if (txtsdt.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống sdt");
            return;
        }

        if (txtdiemtichluy.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống điểm tích lũy ");
            return;
        }
        
        int diem = Integer.parseInt(txtdiemtichluy.getText());
        if(diem <0){
         JOptionPane.showMessageDialog(this, "Điểm tích lũy > 0");
         return;
        }
        if(diem == 0){
        JOptionPane.showMessageDialog(this, "Điểm tích lũy phải là số nguyên");
         return;
        }
        
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trên table để update");
        }
        if (imanageKhachHangService.update(makh, kh) != null) {
            JOptionPane.showMessageDialog(this, " Update thành công ");

        } else {
            JOptionPane.showMessageDialog(this, "Update thất bại  ");
            return;
        }
        loadTable();
        clearForm();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        int row = tblKH.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trên table để xóa");
            return;
        }
        String makh = tblKH.getValueAt(row, 0).toString();
        if(txtma.getText().trim().equals("")){ 
         JOptionPane.showMessageDialog(this, "Nhập mã KH để xóa");
         return;
        }
        
        
        if (imanageKhachHangService.delete(makh) != null) {
            JOptionPane.showMessageDialog(this, " Delete thành công ");

        } else {
            JOptionPane.showMessageDialog(this, "Delete thất bại  ");
            return;
        }
        loadTable();
        clearForm();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void tblKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKHMouseClicked
       int row = tblKH.getSelectedRow();
        txtdiachi.setText(tblKH.getValueAt(row, 3).toString());
        txtma.setText(tblKH.getValueAt(row, 0).toString());
        txtngaysinh.setText(tblKH.getValueAt(row, 4).toString());
        txtsdt.setText(tblKH.getValueAt(row, 5).toString());
        txtten.setText(tblKH.getValueAt(row, 1).toString());
        String gt = tblKH.getValueAt(row, 2).toString();
        if (gt.equalsIgnoreCase("Nam")) {
            rdonam.setSelected(true);
        } else {
            rdonu.setSelected(true);
        }
        txtdiemtichluy.setText(tblKH.getValueAt(row, 6).toString());
    }//GEN-LAST:event_tblKHMouseClicked

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
            java.util.logging.Logger.getLogger(Formkh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formkh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formkh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formkh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formkh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JTable tblKH;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtdiemtichluy;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtngaysinh;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables

    private void loadTable() {
        DefaultTableModel tblmodel = (DefaultTableModel) tblKH.getModel();
        tblmodel.setRowCount(0);
        List<QLKhachHang> list = imanageKhachHangService.getAll();
        
        for (QLKhachHang kh : list) {
            tblmodel.addRow(new Object[] {kh.getMaKH(), kh.getTenKH(), kh.getGioiTinh() == 0 ? "Nữ" : "Nam", kh.getDiaChi(), kh.getNgaySinh(), kh.getSdt(), kh.getDiemTichLuy()});
        }
    }

    private KhachHang getdataFromInput() {
     KhachHang kh = new KhachHang();
        kh.setDiaChi(txtdiachi.getText());
        try {
            kh.setDiemTichLuy(Integer.parseInt(txtdiemtichluy.getText()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        int gt = 0;
        if (rdonam.isSelected() == true) {
            gt = 1;
        } else {
            gt = 0;
        }
        kh.setGioiTinh(gt);

        String ngsinh = txtngaysinh.getText();
        Date d = null;
        try {
            d = new SimpleDateFormat("yyyy-mm-dd").parse(ngsinh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        kh.setNgaySinh(d);
        kh.setSdt(txtsdt.getText());
        kh.setTenKH(txtten.getText());

        return kh;
    }

    private void clearForm() {
        txtdiachi.setText("");
        txtma.setText("");
        txtngaysinh.setText("");
        txtsdt.setText("");
        txtten.setText("");
        txtdiemtichluy.setText("");
    }
}
