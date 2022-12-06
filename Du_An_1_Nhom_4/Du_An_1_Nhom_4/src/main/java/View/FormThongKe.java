/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DomainModel.NPH;
import DomainModel.TheLoai;
import ServiceImplement.HoaDonVMServiceImplement;
import ServiceImplement.NPHServiceImplement;
import ServiceImplement.SachVMServiceImplement;
import ServiceImplement.TLServiceImplement;
import ServiceInterface.HoaDonVMServiceInterface;
import ServiceInterface.NPHServiceInterface;
import ServiceInterface.SachVMServiceInterface;
import ServiceInterface.TLServiceInterface;
import ViewModel.HoaDonVM;
import ViewModel.SachVM;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL 5515
 */
public class FormThongKe extends javax.swing.JFrame {

    private final TLServiceInterface tLServiceInterface;
    private final NPHServiceInterface pHServiceInterface;
    private final SachVMServiceInterface sachVMServiceInterface;
    private final HoaDonVMServiceInterface hoaDonVMServiceInterface;
    private DefaultComboBoxModel<TheLoai> cbotlmodel = new DefaultComboBoxModel();
    private DefaultComboBoxModel<NPH> cbonphmodel = new DefaultComboBoxModel();

    public FormThongKe() {
        initComponents();
        tLServiceInterface = new TLServiceImplement();
        pHServiceInterface = new NPHServiceImplement();
        sachVMServiceInterface = new SachVMServiceImplement();
        hoaDonVMServiceInterface = new HoaDonVMServiceImplement();
                
//        ArrayList<TheLoai> listtl = tLServiceInterface.listTL();
//        cbotlmodel = (DefaultComboBoxModel) new DefaultComboBoxModel(listtl.toArray());
//        cbotl.setModel((DefaultComboBoxModel) cbotlmodel);

//        String tenTL = cbotlmodel.getSelectedItem().toString();
//        List<NPH> listnph = pHServiceInterface.getNPHbySQL(tenTL);
//        cbonphmodel = (DefaultComboBoxModel) new DefaultComboBoxModel(listnph.toArray());
//        cbonph.setModel((DefaultComboBoxModel) cbonphmodel);
        TableDTCaoNhat();
       // TableDTThapNhat();
        //TableSLCaoNhat();
        //TableSLThapNhat();
        //loadTableByNPH();
        loadTableDT();
        tongDT();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cbothongke = new javax.swing.JComboBox<>();
        btnchon = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        btnclearSP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldoanhThu = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbltongtien = new javax.swing.JLabel();
        txtngaytao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(255, 102, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("TRANG CHỦ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("BÁN HÀNG");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 102, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("QUẢN LÝ SÁCH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 102, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("QUẢN LÝ HOÁ ĐƠN");

        jButton6.setBackground(new java.awt.Color(255, 102, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setText("QUẢN LÝ NHÂN VIÊN");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 102, 51));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setText("QUẢN LÝ KHÁCH HÀNG");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 102, 51));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setText("THỐNG KÊ");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 102, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setText("THOÁT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cbothongke.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Top sản phẩm được mua nhiều nhất ", "Top sản phẩm được mua ít nhất ", "Top sản phẩm doanh thu nhiều nhất ", "Top sản phẩm doanh thu ít nhất ", " " }));
        cbothongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbothongkeMouseClicked(evt);
            }
        });
        cbothongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbothongkeActionPerformed(evt);
            }
        });

        btnchon.setText("Chọn");
        btnchon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchonActionPerformed(evt);
            }
        });

        btnsearch.setText("SEARCH");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        btnclearSP.setText("Clear");
        btnclearSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnclearSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(cbothongke, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnchon)
                .addGap(29, 29, 29))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbothongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnchon)
                    .addComponent(btnclearSP))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách", "Năm xuất bản", "Ngôn ngữ", "Nhóm tuổi ", "Tái bản", "Số trang ", "Giá bán", "Số lượng", "Trạng thái ", "Số lượng đã bán ", "Doanh thu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblThongKe);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel3);

        tbldoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Thời gian", "Tổng doanh thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbldoanhThu);

        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Tổng doanh thu cửa hàng ");

        lbltongtien.setForeground(new java.awt.Color(51, 0, 51));
        lbltongtien.setText(".");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(lbltongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltongtien, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setText("Tìm theo thời gian");

        jButton5.setText("Tìm kiếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(btnclear))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(btnclear))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Doanh thu", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        new BanHang1().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        new QLSach1().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
        new QLNhanVien().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
        new QLKhachHang_().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cbothongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbothongkeActionPerformed
       
    }//GEN-LAST:event_cbothongkeActionPerformed

    private void cbothongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbothongkeMouseClicked
         
//        String loigoi = cbothongke.getSelectedItem().toString();
//        if (loigoi.equalsIgnoreCase("Top sản phẩm được mua nhiều nhất")) {
//        TableSLCaoNhat();
//        }else{
//        return;
//        }
//        if (loigoi.equalsIgnoreCase("Top sản phẩm được mua ít nhất")) {
//        TableSLThapNhat();
//        }else{
//        return;
//        }
//        
//        if (loigoi.equalsIgnoreCase("Top sản phẩm doanh thu nhiều nhất")) {
//        TableDTCaoNhat();
//        }else{
//        return;
//        }
//        
//        if (loigoi.equalsIgnoreCase("Top sản phẩm doanh thu ít nhất")) {
//        TableDTThapNhat();
//        }else{
//        return;
//        }
    }//GEN-LAST:event_cbothongkeMouseClicked

    private void btnchonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchonActionPerformed
        int loigoi = cbothongke.getSelectedIndex();
        
        if (loigoi== 0) {
        TableSLCaoNhat();
        }
        if (loigoi == 1 ) {
        TableSLThapNhat();
        }
        
        if (loigoi == 2) {
        TableDTCaoNhat();
        }
        if (loigoi  == 3) {
        TableDTThapNhat();
        }
    }//GEN-LAST:event_btnchonActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        search();
    }//GEN-LAST:event_btnsearchActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       String date = txtngaytao.getText();
       if(txtngaytao.getText().isBlank()){
        JOptionPane.showMessageDialog(this, "Vui lòng nhập thời gian cần tìm");
        return;
       }
       
        
        loadTableTimKiem(date);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        loadTableDT();
        txtngaytao.setText("");
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnclearSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearSPActionPerformed
        TableDTCaoNhat();
    }//GEN-LAST:event_btnclearSPActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         this.dispose();
        new FormThongKe().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

//    Top sản phẩm được mua nhiều nhất 
//Top sản phẩm được mua ít nhất 
//Top sản phẩm doanh thu nhiều nhất 
//Top sản phẩm doanh thu ít nhất 
    private void TableDTCaoNhat() {
        
            DefaultTableModel tbldtcaonhat = (DefaultTableModel) tblThongKe.getModel();
            tbldtcaonhat.setRowCount(0);
            List<SachVM> list = sachVMServiceInterface.listTopDTCaoNhat();
            for (SachVM s : list) {
                tbldtcaonhat.addRow(new Object[]{s.getMaSach(), s.getTenSach(), s.getNamXB(), s.getNgonngu(),s.getNhomtuoi(), s.getTaiban(), s.getSoTrang(), s.getGiaBan(), s.getSoLuong(), s.getTrangthai() == 1 ? "Còn hàng" : "Hết hàng", s.getSlBan(), s.getDoanhthu()});
            }
        }
    
    private void TableDTThapNhat() {
        
            DefaultTableModel tbldtthapnhat = (DefaultTableModel) tblThongKe.getModel();
            tbldtthapnhat.setRowCount(0);
            List<SachVM> list = sachVMServiceInterface.listTopDTThapNhat();
            for (SachVM s : list) {
                tbldtthapnhat.addRow(new Object[]{s.getMaSach(), s.getTenSach(), s.getNamXB(), s.getNgonngu(),s.getNhomtuoi(), s.getTaiban(), s.getSoTrang(), s.getGiaBan(), s.getSoLuong(), s.getTrangthai() == 1 ? "Còn hàng" : "Hết hàng", s.getSlBan(), s.getDoanhthu()});
            }
        }
    
    private void TableSLCaoNhat() {
        
            DefaultTableModel tblSLcaonhat = (DefaultTableModel) tblThongKe.getModel();
            tblSLcaonhat.setRowCount(0);
            List<SachVM> list = sachVMServiceInterface.listTopSLCaoNhat();
            for (SachVM s : list) {
                tblSLcaonhat.addRow(new Object[]{s.getMaSach(), s.getTenSach(), s.getNamXB(), s.getNgonngu(),s.getNhomtuoi(), s.getTaiban(), s.getSoTrang(), s.getGiaBan(), s.getSoLuong(), s.getTrangthai() == 1 ? "Còn hàng" : "Hết hàng", s.getSlBan(), s.getDoanhthu()});
            }
        }
    
    private void TableSLThapNhat() {
        
            DefaultTableModel tblQLThapnhat = (DefaultTableModel) tblThongKe.getModel();
            tblQLThapnhat.setRowCount(0);
            List<SachVM> list = sachVMServiceInterface.listTopSLThapNhat();
            for (SachVM s : list) {
                tblQLThapnhat.addRow(new Object[]{s.getMaSach(), s.getTenSach(), s.getNamXB(), s.getNgonngu(),s.getNhomtuoi(), s.getTaiban(), s.getSoTrang(), s.getGiaBan(), s.getSoLuong(), s.getTrangthai() == 1 ? "Còn hàng" : "Hết hàng", s.getSlBan(), s.getDoanhthu()});
            }
        }
    
    private void loadTableByNPH(){
     DefaultTableModel dtm = (DefaultTableModel) tblThongKe.getModel();
            dtm.setRowCount(0);
            String tenNPH = cbonphmodel.getSelectedItem().toString();
            List<SachVM> list = sachVMServiceInterface.listsachbysql(tenNPH);
            for (SachVM s : list) {
                dtm.addRow(new Object[]{s.getMaSach(), s.getTenSach(), s.getNamXB(), s.getNgonngu(),s.getNhomtuoi(), s.getTaiban(), s.getSoTrang(), s.getGiaBan(), s.getSoLuong(), s.getTrangthai() == 1 ? "Còn hàng" : "Hết hàng", s.getSlBan(), s.getDoanhthu()});
            }
    }
    
    
    private void search(){
     DefaultTableModel dtm = (DefaultTableModel) tblThongKe.getModel();
            dtm.setRowCount(0);
            String tenSach = txtsearch.getText();
            List<SachVM> list = sachVMServiceInterface.getSearch(tenSach);
            for (SachVM s : list) {
                dtm.addRow(new Object[]{s.getMaSach(), s.getTenSach(), s.getNamXB(), s.getNgonngu(),s.getNhomtuoi(), s.getTaiban(), s.getSoTrang(), s.getGiaBan(), s.getSoLuong(), s.getTrangthai() == 1 ? "Còn hàng" : "Hết hàng", s.getSlBan(), s.getDoanhthu()});
            }
    }


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
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnchon;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnclearSP;
    private javax.swing.JButton btnsearch;
    private javax.swing.JComboBox<String> cbothongke;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbltongtien;
    private javax.swing.JTable tblThongKe;
    private javax.swing.JTable tbldoanhThu;
    private javax.swing.JTextField txtngaytao;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables

    private void loadTableDT() {
      DefaultTableModel tblmodelDT = (DefaultTableModel) tbldoanhThu.getModel();
            tblmodelDT.setRowCount(0);
            List<HoaDonVM> list = hoaDonVMServiceInterface.listDT();
            for (HoaDonVM s : list) {
                tblmodelDT.addRow(new Object[]{s.getNgayTao(), s.getTongTien()});
            }
    }

    private void loadTableTimKiem(String date) {
      DefaultTableModel tblmodelSearch = (DefaultTableModel) tbldoanhThu.getModel();
            tblmodelSearch.setRowCount(0);
            
            List<HoaDonVM> list = hoaDonVMServiceInterface.TimKiemDTTheoNgay(date);
            for (HoaDonVM s : list) {
                tblmodelSearch.addRow(new Object[]{s.getNgayTao(), s.getTongTien()});
            }
    }
    
    private void tongDT(){
     List<HoaDonVM> list = hoaDonVMServiceInterface.TongDT();
     float tongDT = 0;
        for (HoaDonVM hd : list) {
            tongDT = hd.getTongTien();
        }
        lbltongtien.setText(String.valueOf(tongDT)+" VNĐ");
    }
}
