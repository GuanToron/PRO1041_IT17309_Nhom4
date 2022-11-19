package View;

import DomainModel.DanhMuc;
import DomainModel.NPH;
import DomainModel.TacGia;
import DomainModel.TheLoai;
import Service.Implement.DMImplement_XT;
import Service.Implement.NPHServiceImplement;
import Service.Implement.TGServiceImplement;
import Service.Implement.TLServiceImplement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ServiceInterface.DMInterface_XT;
import ServiceInterface.NPHServiceInterface;
import ServiceInterface.TGServiceInterface;
import ServiceInterface.TLServiceInterface;

/**
 *
 * @author Xuan Truong
 */
public class QLSach1 extends javax.swing.JFrame {

    private DefaultTableModel modelDM = new DefaultTableModel();
    private DefaultTableModel modelTG = new DefaultTableModel();
    private DefaultTableModel modelTL = new DefaultTableModel();
    private DefaultTableModel modelNPH = new DefaultTableModel();
    private DefaultTableModel modelDSSach = new DefaultTableModel();
    private DefaultTableModel modelSachLoi = new DefaultTableModel();

    private ArrayList<DanhMuc> listDM = new ArrayList<>();
    private ArrayList<TacGia> listTG = new ArrayList<>();
    private ArrayList<TheLoai> listTL = new ArrayList<>();
    private ArrayList<NPH> listNPH = new ArrayList<>();

    private DMInterface_XT serviceDM = new DMImplement_XT();
    private TGServiceInterface serviceTG = new TGServiceImplement();
    private TLServiceInterface serviceTL = new TLServiceImplement();
    private NPHServiceInterface serviceNPH = new NPHServiceImplement();

    public QLSach1() {
        initComponents();
        tblDanhMuc.setModel(modelDM);
        tblTacGia.setModel(modelTG);
        tblTheLoai.setModel(modelTL);
        tblNPH.setModel(modelNPH);

        listDM = serviceDM.listDM();
        listTG = serviceTG.listTG();
        listTL = serviceTL.listTL();
        listNPH = serviceNPH.listNPH();

        loadTableDM(listDM);
        loadTableTG(listTG);
        loadTableTL(listTL);
        loadTableNPH(listNPH);
    }

    private void loadTableDM(ArrayList<DanhMuc> list) {
        modelDM.setRowCount(0);
        modelDM.setColumnIdentifiers(new String[]{"Mã danh mục", "Tên danh mục"});
        for (DanhMuc x : list) {
            modelDM.addRow(new Object[]{x.getMaDM(), x.getTenDM()});
        }
    }

    private DanhMuc getDanhMuc() {
        DanhMuc x = new DanhMuc();
        x.setMaDM(Integer.valueOf(txtMaDanhMuc.getText()));
        x.setTenDM(txtTenDanhMuc.getText());
        return x;
    }

    private void loadTextFielDM(int i) {
        DanhMuc x = listDM.get(i);
        txtMaDanhMuc.setText(String.valueOf(x.getMaDM()));
        txtTenDanhMuc.setText(String.valueOf(x.getTenDM()));
    }

    private void clearDM() {
        txtMaDanhMuc.setText("");
        txtTenDanhMuc.setText("");
    }

    private void loadTableTG(ArrayList<TacGia> list) {
        modelTG.setRowCount(0);
        modelTG.setColumnIdentifiers(new String[]{"Mã tác giả", "Tên tác giả"});
        for (TacGia x : list) {
            modelTG.addRow(new Object[]{x.getMaTacGia(), x.getTenTacGia()});
        }
    }

    private TacGia getTacGia() {
        TacGia x = new TacGia();
        x.setMaTacGia(Integer.valueOf(txtMaTG.getText()));
        x.setTenTacGia(txtTenTG.getText());
        return x;
    }

    private void loatTextFieldTG(int i) {
        TacGia x = listTG.get(i);
        txtMaTG.setText(String.valueOf(x.getMaTacGia()));
        txtTenTG.setText(String.valueOf(x.getTenTacGia()));
    }

    private void clearTG() {
        txtMaTG.setText("");
        txtTenTG.setText("");
    }

    private void loadTableTL(ArrayList<TheLoai> list) {
        modelTL.setRowCount(0);
        modelTL.setColumnIdentifiers(new String[]{"Mã thể loại", "Tên thể loại"});
        for (TheLoai x : list) {
            modelTL.addRow(new Object[]{x.getMaTheLoai(), x.getTenTheLoai()});
        }
    }

    private TheLoai getTheLoai() {
        TheLoai x = new TheLoai();
        x.setMaTheLoai(Integer.valueOf(txtMaTheLoai.getText()));
        x.setTenTheLoai(txtTenTheLoai.getText());
        return x;
    }

    private void loadTextFieldTL(int i) {
        TheLoai x = listTL.get(i);
        txtMaTheLoai.setText(String.valueOf(x.getMaTheLoai()));
        txtTenTheLoai.setText(String.valueOf(x.getTenTheLoai()));
    }

    private void clearTL() {
        txtTenTheLoai.setText("");
        txtMaTheLoai.setText("");
    }

    private void loadTableNPH(ArrayList<NPH> list) {
        modelNPH.setRowCount(0);
        modelNPH.setColumnIdentifiers(new String[]{"Mã NPH", "Tên NPH"});
        for (NPH x : list) {
            modelNPH.addRow(new Object[]{x.getMaNPH(), x.getTenNPH()});
        }
    }

    private NPH getNPH() {
        NPH x = new NPH();
        x.setMaNPH(Integer.valueOf(txtMaNPH.getText()));
        x.setTenNPH(txtTenNPH.getText());
        return x;
    }

    private void loadTextFieldNPH(int i) {
        NPH x = listNPH.get(i);
        txtMaNPH.setText(String.valueOf(x.getMaNPH()));
        txtTenNPH.setText(String.valueOf(x.getTenNPH()));
    }

    private void clearNPH() {
        txtMaNPH.setText("");
        txtTenNPH.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        SidePanel = new javax.swing.JPanel();
        btnTrangChu = new javax.swing.JButton();
        btnBanHang = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnQLSach = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnQLHoaDon = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        btnQLNhanVien = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        btnQLKhachHang = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        btnThongKe = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        txtMaSach1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        cbTacGia1 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        cbNPH3 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        txtTenSach1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        cbNPH4 = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        cbNPH5 = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        txtSoLuong1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        rdKhongBan1 = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jTextField21 = new javax.swing.JTextField();
        jButton38 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhMuc = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtMaDanhMuc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTenDanhMuc = new javax.swing.JTextField();
        btnThemDanhMuc = new javax.swing.JButton();
        btnSuaDanhMuc = new javax.swing.JButton();
        btnXoaDanhMuc = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtMaTheLoai = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTenTheLoai = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTheLoai = new javax.swing.JTable();
        btnThemTL = new javax.swing.JButton();
        btnSuaTL = new javax.swing.JButton();
        btnXoaTL = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtMaTG = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTenTG = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTacGia = new javax.swing.JTable();
        btnThemTG = new javax.swing.JButton();
        btnSuaTG = new javax.swing.JButton();
        btnXoaTG = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtMaNPH = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtTenNPH = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNPH = new javax.swing.JTable();
        btnThemNPH = new javax.swing.JButton();
        btnSuaNPH = new javax.swing.JButton();
        btnXoaNPH = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        txtMaTuoi = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblSachLoi = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblDSSach = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        txtMaSoSachLoi = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        cbNPH = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtLyDoDoi = new javax.swing.JTextField();
        btnDoiSach = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackGround.setBackground(new java.awt.Color(153, 255, 153));

        SidePanel.setBackground(new java.awt.Color(51, 204, 255));

        btnTrangChu.setBackground(new java.awt.Color(255, 102, 51));
        btnTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTrangChu.setText("TRANG CHỦ");
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        btnBanHang.setBackground(new java.awt.Color(255, 102, 51));
        btnBanHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBanHang.setText("BÁN HÀNG");
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnQLSach.setBackground(new java.awt.Color(255, 102, 51));
        btnQLSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQLSach.setText("QUẢN LÝ SÁCH");
        btnQLSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLSachActionPerformed(evt);
            }
        });

        btnQLHoaDon.setBackground(new java.awt.Color(255, 102, 51));
        btnQLHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQLHoaDon.setText("QUẢN LÝ HOÁ ĐƠN");

        btnQLNhanVien.setBackground(new java.awt.Color(255, 102, 51));
        btnQLNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQLNhanVien.setText("QUẢN LÝ NHÂN VIÊN");
        btnQLNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLNhanVienActionPerformed(evt);
            }
        });

        btnQLKhachHang.setBackground(new java.awt.Color(255, 102, 51));
        btnQLKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQLKhachHang.setText("QUẢN LÝ KHÁCH HÀNG");
        btnQLKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLKhachHangActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(255, 102, 51));
        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThongKe.setText("THỐNG KÊ");

        jButton9.setBackground(new java.awt.Color(255, 102, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setText("THOÁT");

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(btnQLSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3)
            .addComponent(btnQLHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator4)
            .addComponent(jSeparator5)
            .addComponent(btnQLNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator6)
            .addComponent(btnQLKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator7)
            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLSach, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Mã sách");

        txtMaSach1.setEditable(false);
        txtMaSach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSach1ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Tác giả");

        cbTacGia1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("NPH");

        cbNPH3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Tên sách");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("NXB");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("Danh mục");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setText("Ngôn ngữ");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("Số trang");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Thể loại");

        cbNPH4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("Nhóm tuổi");

        cbNPH5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Số lượng");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setText("Trạng thái");

        jRadioButton2.setText("Đang bán");

        rdKhongBan1.setText("Không còn bán");

        jButton6.setText("THÊM");

        jButton35.setText("SỬA");

        jButton36.setText("XOÁ");

        jButton37.setText("LÀM MỚI");

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách"));

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(jTable10);

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setText("Lọc");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton38.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel43)
                .addGap(94, 94, 94)
                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(58, 58, 58)
                                .addComponent(txtSoLuong1))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addGap(46, 46, 46)
                                .addComponent(cbNPH5, 0, 239, Short.MAX_VALUE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(65, 65, 65)
                                .addComponent(cbNPH4, 0, 239, Short.MAX_VALUE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(84, 84, 84)
                                .addComponent(cbNPH3, 0, 239, Short.MAX_VALUE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(70, 70, 70)
                                .addComponent(cbTacGia1, 0, 239, Short.MAX_VALUE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(61, 61, 61)
                                .addComponent(txtMaSach1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
                        .addGap(135, 135, 135)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38)
                            .addComponent(jLabel42)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(94, 94, 94)
                        .addComponent(jButton35)
                        .addGap(96, 96, 96)
                        .addComponent(jButton36)
                        .addGap(1, 1, 1)))
                .addGap(52, 52, 52)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField20, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField19, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                .addComponent(txtTenSach1))
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.LEADING, 0, 241, Short.MAX_VALUE)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(73, 73, 73))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(rdKhongBan1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton37)
                .addGap(177, 177, 177))
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtMaSach1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(txtTenSach1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(cbTacGia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(cbNPH3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(cbNPH4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(cbNPH5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtSoLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jRadioButton2)
                    .addComponent(rdKhongBan1))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton35)
                    .addComponent(jButton36)
                    .addComponent(jButton37))
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin sách", jPanel14);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh mục", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhMucMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhMuc);

        jLabel14.setText("Mã danh mục");

        txtMaDanhMuc.setEditable(false);

        jLabel15.setText("Tên danh mục");

        btnThemDanhMuc.setText("Thêm");
        btnThemDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDanhMucActionPerformed(evt);
            }
        });

        btnSuaDanhMuc.setText("Sửa");
        btnSuaDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDanhMucActionPerformed(evt);
            }
        });

        btnXoaDanhMuc.setText("Xoá");
        btnXoaDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDanhMucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemDanhMuc)
                .addGap(39, 39, 39)
                .addComponent(btnSuaDanhMuc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaDanhMuc)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDanhMuc)
                    .addComponent(btnSuaDanhMuc)
                    .addComponent(btnXoaDanhMuc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thể loại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel16.setText("Mã thể loại");

        txtMaTheLoai.setEditable(false);

        jLabel17.setText("Tên thể loại");

        tblTheLoai.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTheLoaiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblTheLoai);

        btnThemTL.setText("Thêm");
        btnThemTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTLActionPerformed(evt);
            }
        });

        btnSuaTL.setText("Sửa");
        btnSuaTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTLActionPerformed(evt);
            }
        });

        btnXoaTL.setText("Xoá");
        btnXoaTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemTL)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnSuaTL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoaTL))
                            .addComponent(txtTenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtMaTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTL)
                    .addComponent(btnSuaTL)
                    .addComponent(btnXoaTL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tác giả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel18.setText("Mã tác giả");

        txtMaTG.setEditable(false);

        jLabel19.setText("Tên tác giả");

        tblTacGia.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTacGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTacGiaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblTacGia);

        btnThemTG.setText("Thêm");
        btnThemTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTGActionPerformed(evt);
            }
        });

        btnSuaTG.setText("Sửa");
        btnSuaTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTGActionPerformed(evt);
            }
        });

        btnXoaTG.setText("Xoá");
        btnXoaTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTenTG))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaTG, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThemTG)
                        .addGap(40, 40, 40)
                        .addComponent(btnSuaTG)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaTG)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtMaTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTenTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTG)
                    .addComponent(btnSuaTG)
                    .addComponent(btnXoaTG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhà phát hành", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel20.setText("Mã NPH");

        jLabel21.setText("Tên NPH");

        tblNPH.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNPH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNPHMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblNPH);

        btnThemNPH.setText("Thêm");
        btnThemNPH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNPHActionPerformed(evt);
            }
        });

        btnSuaNPH.setText("Sửa");
        btnSuaNPH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNPHActionPerformed(evt);
            }
        });

        btnXoaNPH.setText("Xoá");
        btnXoaNPH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNPHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaNPH)
                            .addComponent(txtTenNPH, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnThemNPH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(btnSuaNPH)
                        .addGap(61, 61, 61)
                        .addComponent(btnXoaNPH)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtMaNPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtTenNPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemNPH)
                    .addComponent(btnSuaNPH)
                    .addComponent(btnXoaNPH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NXB", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel22.setText("Mã NXB");

        jLabel23.setText("Tên NXB");

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable6);

        jButton26.setText("Thêm");

        jButton27.setText("Sửa");

        jButton28.setText("Xoá");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton26)
                        .addGap(28, 28, 28)
                        .addComponent(jButton27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton28))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(txtMaTuoi))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtMaTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton26)
                    .addComponent(jButton27)
                    .addComponent(jButton28))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ngôn ngữ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel24.setText("Mã NN");

        jLabel25.setText("Tên NN");

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTable7);

        jButton29.setText("Thêm");

        jButton30.setText("Sửa");

        jButton31.setText("Xoá");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton29)
                        .addGap(18, 18, 18)
                        .addComponent(jButton30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton31))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField13)
                            .addComponent(jTextField14, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton29)
                    .addComponent(jButton30)
                    .addComponent(jButton31))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thuộc tính sách", jPanel2);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sách lỗi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblSachLoi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(tblSachLoi);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblDSSach.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(tblDSSach);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Mã số sách lỗi");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Mã sách");

        jLabel28.setText("NPH");

        cbNPH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Số lượng");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Lý do ");

        btnDoiSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDoiSach.setText("Đổi sách");

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLamMoi.setText("Làm mới");

        btnHuy.setText("Huỷ");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28)
                    .addComponent(jLabel30))
                .addGap(40, 40, 40)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaSoSachLoi)
                    .addComponent(cbNPH, 0, 213, Short.MAX_VALUE)
                    .addComponent(txtLyDoDoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29))
                .addGap(55, 55, 55)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaSach)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                .addGap(83, 83, 83))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDoiSach)
                .addGap(141, 141, 141)
                .addComponent(btnLamMoi)
                .addGap(168, 168, 168)
                .addComponent(btnHuy)
                .addGap(193, 193, 193))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtMaSoSachLoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtLyDoDoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDoiSach)
                    .addComponent(btnLamMoi)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sách lỗi", jPanel11);

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQLKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLKhachHangActionPerformed

    }//GEN-LAST:event_btnQLKhachHangActionPerformed

    private void btnQLNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNhanVienActionPerformed
        this.dispose();
        new QLNhanVien().setVisible(true);
    }//GEN-LAST:event_btnQLNhanVienActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        this.dispose();
        new BanHang().setVisible(true);
    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        this.dispose();
        new MainApp().setVisible(true);
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void btnQLSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLSachActionPerformed
        this.dispose();
        new QLSach1().setVisible(true);
    }//GEN-LAST:event_btnQLSachActionPerformed

    private void txtMaSach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSach1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSach1ActionPerformed

    private void btnThemDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDanhMucActionPerformed
        DanhMuc x = new DanhMuc(txtTenDanhMuc.getText());
        JOptionPane.showMessageDialog(this, serviceDM.themDM(x));
        listDM = serviceDM.listDM();
        loadTableDM(listDM);
        clearDM();
    }//GEN-LAST:event_btnThemDanhMucActionPerformed

    private void btnSuaDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDanhMucActionPerformed
        int temp = tblDanhMuc.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            DanhMuc x = getDanhMuc();
            JOptionPane.showMessageDialog(this, serviceDM.suaDM(x));
            listDM = serviceDM.listDM();
            loadTableDM(listDM);
        }
    }//GEN-LAST:event_btnSuaDanhMucActionPerformed

    private void tblDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhMucMouseClicked
        int temp = tblDanhMuc.getSelectedRow();
        loadTextFielDM(temp);
    }//GEN-LAST:event_tblDanhMucMouseClicked

    private void btnXoaDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDanhMucActionPerformed
        int temp = tblDanhMuc.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá không ?");
            if (choice == JOptionPane.OK_OPTION) {
                DanhMuc x = getDanhMuc();
                JOptionPane.showMessageDialog(this, serviceDM.xoaDM(x));
                listDM = serviceDM.listDM();
                loadTableDM(listDM);
                clearDM();
            }
        }
    }//GEN-LAST:event_btnXoaDanhMucActionPerformed

    private void btnThemTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTGActionPerformed
        TacGia x = new TacGia(txtTenTG.getText());
        JOptionPane.showMessageDialog(this, serviceTG.themTG(x));
        listTG = serviceTG.listTG();
        loadTableTG(listTG);
        clearTG();
    }//GEN-LAST:event_btnThemTGActionPerformed

    private void btnSuaTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTGActionPerformed
        int temp = tblTacGia.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            TacGia x = getTacGia();
            JOptionPane.showMessageDialog(this, serviceTG.suaTG(x));
            listTG = serviceTG.listTG();
            loadTableTG(listTG);
        }
    }//GEN-LAST:event_btnSuaTGActionPerformed

    private void btnXoaTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTGActionPerformed
        int temp = tblTacGia.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá không ?");
            if (choice == JOptionPane.OK_OPTION) {
                TacGia x = getTacGia();
                JOptionPane.showMessageDialog(this, serviceTG.xoaTG(x));
                listTG = serviceTG.listTG();
                loadTableTG(listTG);
                clearTG();
            }
        }
    }//GEN-LAST:event_btnXoaTGActionPerformed

    private void tblTacGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTacGiaMouseClicked
        int temp = tblTacGia.getSelectedRow();
        loatTextFieldTG(temp);
    }//GEN-LAST:event_tblTacGiaMouseClicked

    private void btnThemTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTLActionPerformed
        TheLoai x = new TheLoai(txtTenTheLoai.getText());
        JOptionPane.showMessageDialog(this, serviceTL.themTL(x));
        listTL = serviceTL.listTL();
        loadTableTL(listTL);
        clearTL();
    }//GEN-LAST:event_btnThemTLActionPerformed

    private void tblTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTheLoaiMouseClicked
        int temo = tblTheLoai.getSelectedRow();
        loadTextFieldTL(temo);
    }//GEN-LAST:event_tblTheLoaiMouseClicked

    private void btnSuaTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTLActionPerformed
        int temp = tblTheLoai.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            TheLoai x = getTheLoai();
            JOptionPane.showMessageDialog(this, serviceTL.suaTL(x));
            listTL = serviceTL.listTL();
            loadTableTL(listTL);
        }
    }//GEN-LAST:event_btnSuaTLActionPerformed

    private void btnXoaTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTLActionPerformed
        int temp = tblTheLoai.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá không ?");
            if (choice == JOptionPane.OK_OPTION) {
                TheLoai x = getTheLoai();
                JOptionPane.showMessageDialog(this, serviceTL.xoaTL(x));
                listTL = serviceTL.listTL();
                loadTableTL(listTL);
                clearTL();
            }
        }
    }//GEN-LAST:event_btnXoaTLActionPerformed

    private void btnThemNPHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNPHActionPerformed
        NPH x = new NPH(txtTenNPH.getText());
        JOptionPane.showMessageDialog(this, serviceNPH.themNPH(x));
        listNPH = serviceNPH.listNPH();
        loadTableNPH(listNPH);
        clearNPH();
    }//GEN-LAST:event_btnThemNPHActionPerformed

    private void btnSuaNPHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNPHActionPerformed
        int temp = tblNPH.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            NPH x = getNPH();
            JOptionPane.showMessageDialog(this, serviceNPH.suaNPH(x));
            listNPH = serviceNPH.listNPH();
            loadTableNPH(listNPH);
        }
    }//GEN-LAST:event_btnSuaNPHActionPerformed

    private void btnXoaNPHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNPHActionPerformed
        int temp = tblNPH.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá không ?");
            if (choice == JOptionPane.OK_OPTION) {
                NPH x = getNPH();
                JOptionPane.showMessageDialog(this, serviceNPH.suaNPH(x));
                listNPH = serviceNPH.listNPH();
                loadTableNPH(listNPH);
                clearNPH();
            }
        }
    }//GEN-LAST:event_btnXoaNPHActionPerformed

    private void tblNPHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNPHMouseClicked
        int temp = tblNPH.getSelectedRow();
        loadTextFieldNPH(temp);
    }//GEN-LAST:event_tblNPHMouseClicked

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
            java.util.logging.Logger.getLogger(QLSach1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSach1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSach1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSach1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSach1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnDoiSach;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnQLHoaDon;
    private javax.swing.JButton btnQLKhachHang;
    private javax.swing.JButton btnQLNhanVien;
    private javax.swing.JButton btnQLSach;
    private javax.swing.JButton btnSuaDanhMuc;
    private javax.swing.JButton btnSuaNPH;
    private javax.swing.JButton btnSuaTG;
    private javax.swing.JButton btnSuaTL;
    private javax.swing.JButton btnThemDanhMuc;
    private javax.swing.JButton btnThemNPH;
    private javax.swing.JButton btnThemTG;
    private javax.swing.JButton btnThemTL;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnXoaDanhMuc;
    private javax.swing.JButton btnXoaNPH;
    private javax.swing.JButton btnXoaTG;
    private javax.swing.JButton btnXoaTL;
    private javax.swing.JComboBox<String> cbNPH;
    private javax.swing.JComboBox<String> cbNPH3;
    private javax.swing.JComboBox<String> cbNPH4;
    private javax.swing.JComboBox<String> cbNPH5;
    private javax.swing.JComboBox<String> cbTacGia1;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JRadioButton rdKhongBan1;
    private javax.swing.JTable tblDSSach;
    private javax.swing.JTable tblDanhMuc;
    private javax.swing.JTable tblNPH;
    private javax.swing.JTable tblSachLoi;
    private javax.swing.JTable tblTacGia;
    private javax.swing.JTable tblTheLoai;
    private javax.swing.JTextField txtLyDoDoi;
    private javax.swing.JTextField txtMaDanhMuc;
    private javax.swing.JTextField txtMaNPH;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtMaSach1;
    private javax.swing.JTextField txtMaSoSachLoi;
    private javax.swing.JTextField txtMaTG;
    private javax.swing.JTextField txtMaTheLoai;
    private javax.swing.JTextField txtMaTuoi;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuong1;
    private javax.swing.JTextField txtTenDanhMuc;
    private javax.swing.JTextField txtTenNPH;
    private javax.swing.JTextField txtTenSach1;
    private javax.swing.JTextField txtTenTG;
    private javax.swing.JTextField txtTenTheLoai;
    // End of variables declaration//GEN-END:variables
}
