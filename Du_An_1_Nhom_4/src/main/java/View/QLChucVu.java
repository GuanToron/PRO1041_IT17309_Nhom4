package View;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DomainModel.ChucVu;
import Service.Implement.ChucVuServiceImpl;

/**
 *
 * @author Xuan Truong
 */
public class QLChucVu extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    private ArrayList<ChucVu> listChucVu = new ArrayList<>();
    private ChucVuServiceImpl serviceCV = new ChucVuServiceImpl();

    public QLChucVu() {
        initComponents();
        setLocationRelativeTo(null);
        listChucVu = serviceCV.listChucVu();
        tblChucVu.setModel(model);
        loadTable();
    }

    private void loadTable() {
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Ma chuc vu", "Ten chuc vu"});
        for (ChucVu x : listChucVu) {
            model.addRow(new Object[]{x.getMaChucVu(), x.getTenChucVu()});
        }
    }

    private ChucVu getChucVu() {
        ChucVu x = new ChucVu();
        x.setMaChucVu(Integer.parseInt(txtMaChucVu.getText()));
        x.setTenChucVu(txtTenChucVu.getText());
        return x;
    }

    private void loadTextField(int i) {
        ChucVu x = listChucVu.get(i);
        txtMaChucVu.setText(x.getMaChucVu() + "");
        txtTenChucVu.setText(x.getTenChucVu());
    }

    private void clear() {
        txtMaChucVu.setText("");
        txtTenChucVu.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTenChucVu = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        lblMaChucVu = new javax.swing.JLabel();
        lblTenChucVu = new javax.swing.JLabel();
        lblLabel = new javax.swing.JLabel();
        txtMaChucVu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChucVu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        lblMaChucVu.setText("Mã chức vụ");

        lblTenChucVu.setText("Tên chức vụ");

        lblLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLabel.setForeground(new java.awt.Color(102, 153, 255));
        lblLabel.setText("QUẢN LÝ CHỨC VỤ");

        txtMaChucVu.setEditable(false);

        tblChucVu.setModel(new javax.swing.table.DefaultTableModel(
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
        tblChucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChucVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChucVu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSua)
                                .addGap(41, 41, 41)
                                .addComponent(btnXoa)
                                .addGap(26, 26, 26)
                                .addComponent(btnLamMoi))
                            .addComponent(txtTenChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenChucVu)
                            .addComponent(lblMaChucVu)
                            .addComponent(btnThem))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaChucVu)
                    .addComponent(txtMaChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenChucVu)
                    .addComponent(txtTenChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLamMoi))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int temp = tblChucVu.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Ban chua chon doi tuong de xoa");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Ban co muon xoa doi tuong nay khong ?");
            if (choice == JOptionPane.OK_OPTION) {
                ChucVu x = getChucVu();
                JOptionPane.showMessageDialog(this, serviceCV.xoaChucVu(x));
                listChucVu = serviceCV.listChucVu();
                loadTable();
                clear();
            } else {
                JOptionPane.showMessageDialog(this, "Da huy");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ChucVu x = new ChucVu(txtTenChucVu.getText());
        JOptionPane.showMessageDialog(this, serviceCV.themChucVu(x));
        listChucVu = serviceCV.listChucVu();
        loadTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblChucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChucVuMouseClicked
        int temp = tblChucVu.getSelectedRow();
        loadTextField(temp);
    }//GEN-LAST:event_tblChucVuMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        clear();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int temp = tblChucVu.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Ban chua chon doi tuong de xoa");
        } else {
            ChucVu x = getChucVu();
            JOptionPane.showMessageDialog(this, serviceCV.suaChucVu(x));
            listChucVu = serviceCV.listChucVu();
            loadTable();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

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
            java.util.logging.Logger.getLogger(QLChucVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLChucVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLChucVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLChucVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLChucVu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLabel;
    private javax.swing.JLabel lblMaChucVu;
    private javax.swing.JLabel lblTenChucVu;
    private javax.swing.JTable tblChucVu;
    private javax.swing.JTextField txtMaChucVu;
    private javax.swing.JTextField txtTenChucVu;
    // End of variables declaration//GEN-END:variables
}
