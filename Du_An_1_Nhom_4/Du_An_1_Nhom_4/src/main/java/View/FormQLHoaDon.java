package View;

import DomainModel.TraHangChiTiet;
import ServiceImplement.HoaDonCTVMServiceImplement;
import ServiceImplement.HoaDonVMServiceImplement;
import ServiceImplement.SachserviceImpl;
import ServiceImplement.TraHangChiTietServiceImplement;
import ServiceImplement.TraHangServiceImpllement;
import ServiceInterface.HoaDonCTVMServiccecInterface;
import ServiceInterface.HoaDonVMServiceInterface;
import ServiceInterface.SachService;
import ServiceInterface.TraHangChiTietServiceInterface;
import ViewModel.HoaDonCTVM;
import ViewModel.HoaDonVM;
import ViewModel.QLTraHang;
import ViewModel.SachViewmodel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Xuan Truong
 */
public class FormQLHoaDon extends javax.swing.JFrame {

    private DefaultTableModel modelTTHoaDon = new DefaultTableModel();
    private DefaultTableModel modelTHHoaDon = new DefaultTableModel();
    private DefaultTableModel modelTTHDCT;
    private DefaultTableModel modelTHCDCT;
    private final DefaultTableModel modelTHTraHang = new DefaultTableModel();
    private TraHangChiTietServiceInterface serviceTraHangCT = new TraHangChiTietServiceImplement();

    private HoaDonCTVMServiccecInterface serviceHDCT = new HoaDonCTVMServiceImplement();
    private HoaDonVMServiceInterface serviceHDVM = new HoaDonVMServiceImplement();
    private ArrayList<SachViewmodel> listSach = new ArrayList<>();
    private List<HoaDonVM> listTTHoaDon;
    private List<HoaDonVM> listTHHoaDon;
    private ArrayList<QLTraHang> listTraHang = new ArrayList<>();
    private final TraHangServiceImpllement serviceTH = new TraHangServiceImpllement();
    private SachService serviceSach = new SachserviceImpl();
    Integer soLuong;
    Float donGia;
    Integer soSachBanDau;
    Integer maPHT;

    public FormQLHoaDon() {
        initComponents();
        setLocationRelativeTo(null);
        listTTHoaDon = serviceHDVM.listHD();
        listTHHoaDon = serviceHDVM.listHDTH();
        loadtableTTHoaDon(listTTHoaDon);
        loadtableTHHoaDon(listTHHoaDon);
    }

    private void loadtableTTHoaDon(List<HoaDonVM> list) {
        DefaultTableModel tblmodel = (DefaultTableModel) tblTTHoaDon.getModel();
        tblmodel.setRowCount(0);
        tblmodel.setColumnIdentifiers(new String[]{"Mã hoá đơn", "Mã khách hàng", "Mã nhân viên", "Ngày tạo", "Tổng tiền", "Trạng Thái"});
        for (HoaDonVM hDVM : list) {
            tblmodel.addRow(new Object[]{hDVM.getMaHoaDon(),
                hDVM.getMaKhachHang(),
                hDVM.getMaNhanVien(),
                hDVM.getNgayTao(),
                hDVM.getTongTien(),
                hDVM.getTrangThai()});
        }
    }

    private void loadTabltTTHDCT(ArrayList<HoaDonCTVM> listhdct) {
        modelTTHDCT = (DefaultTableModel) tblTTHoaDonChiTiet.getModel();
        modelTTHDCT.setRowCount(0);
        for (HoaDonCTVM hoaDonCTVM : listhdct) {
            modelTTHDCT.addRow(new Object[]{hoaDonCTVM.getMaHoaDonCT(),
                //             hoaDonCTVM.getMaHoaDon(),
                hoaDonCTVM.getMaSach(),
                hoaDonCTVM.getMaSach(),
                hoaDonCTVM.getSoLuong(),
                hoaDonCTVM.getDonGia()});

        }
    }

    private void loadTableTHHDCT(ArrayList<HoaDonCTVM> listhdct) {
        modelTHCDCT = (DefaultTableModel) tblTHHoaDonChiTiet.getModel();
        modelTHCDCT.setRowCount(0);
        for (HoaDonCTVM hoaDonCTVM : listhdct) {
            modelTHCDCT.addRow(new Object[]{hoaDonCTVM.getMaHoaDonCT(),
                hoaDonCTVM.getMaSach(),
                hoaDonCTVM.getMaSach(),
                hoaDonCTVM.getSoLuong(),
                hoaDonCTVM.getDonGia()});

        }
    }

    private void loadTraHang(int i) {
        QLTraHang x = listTraHang.get(i);
//        lbmapth.setText(x.getMaPTH());
//        txtmahd.setText(x.getMaHD() + "");
//        txtmakh.setText(x.getMaKH());
//        txtmanv.setText(x.getMaNV());
//        txtngaytra.setText(x.getNgayTra());
//        txtsotientralai.setText(x.getTienTraLai() + "");
//        txtlydo.setText(x.getLyDo());

    }

    private void loadTableTH(ArrayList<QLTraHang> list) {
//        DefaultTableModel tblmodel = (DefaultTableModel) tbltrahang.getModel();
//        tblmodel.setRowCount(0);
//        for(QLTraHang QLTH : list){
//            tblmodel.addRow(new Object[]{
//                QLTH.getMaPTH(),
//                QLTH.getMaHD(),
//                QLTH.getMaKH(),
//                QLTH.getMaNV(),
//                QLTH.getNgayTra(),
//                QLTH.getTienTraLai(),
//                QLTH.getLyDo()
//            });
//        }
        modelTHTraHang.setRowCount(0);
        modelTHTraHang.setColumnIdentifiers(new String[]{"Mã PTH", "Mã HĐ", "Mã KH", "Mã NV", "Ngày Trả", "Số Tiền Trả Lại", "Lý Do Trả"});
        for (QLTraHang x : list) {
            modelTHTraHang.addRow(x.toDataRow());
        }
    }

    private void loadtableTHHoaDon(List<HoaDonVM> list) {
        DefaultTableModel tblmodel = (DefaultTableModel) tblTHHoaDon.getModel();
        tblmodel.setRowCount(0);

        for (HoaDonVM hDVM : list) {
            tblmodel.addRow(new Object[]{hDVM.getMaHoaDon(),
                hDVM.getMaKhachHang(),
                hDVM.getMaNhanVien(),
                hDVM.getNgayTao(),
                hDVM.getTongTien(),
                hDVM.getTrangThai()});
        }
    }

    private QLTraHang getTraHang() {
        QLTraHang x = new QLTraHang();
        x.setMaHD(Integer.parseInt(txtmahd.getText()));
        x.setMaKH(Integer.parseInt(txtmakh.getText()));
        x.setMaNV(1);
        x.setNgayTra(new Date());
        x.setTienTraLai(Float.parseFloat(txtsotientralai.getText()));
        x.setLyDo(txtlydo.getText());
        return x;
    }

    private void clearForm() {
        txtlydo.setText("");
        txtmahd.setText("");
        txtmakh.setText("");
        txtSoLuong.setText("");
        txtMaPTH.setText("");
        txtngaytao.setText("");
        txtngaytao.setText("");
        txtsotientralai.setText("");
        txtsotientralai.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jSeparator8 = new javax.swing.JSeparator();
        btnThoat = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblTuNgay = new javax.swing.JLabel();
        lblDenNgay = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnLocHoaDon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTTHoaDon = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTTHoaDonChiTiet = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAll = new javax.swing.JButton();
        dtNgayBatDau = new com.toedter.calendar.JDateChooser();
        dtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTHHoaDon = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTHHoaDonChiTiet = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtmahd = new javax.swing.JTextField();
        txtmakh = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtngaytao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtsotientralai = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtlydo = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        txtMaPTH = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnTimHoaDon = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbltrahang1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        btnQLHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLHoaDonActionPerformed(evt);
            }
        });

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

        btnThoat.setBackground(new java.awt.Color(255, 102, 51));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThoat.setText("THOÁT");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

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
            .addComponent(jSeparator8)
            .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLSach, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTuNgay.setText("Từ Ngày : ");

        lblDenNgay.setText("Đến Ngày : ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lý Hóa Đơn ");

        btnLocHoaDon.setText("Lọc Hóa Đơn");
        btnLocHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocHoaDonActionPerformed(evt);
            }
        });

        tblTTHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD ", "Mã khách hàng ", "Mã NV ", "Ngày tạo", "Tổng tiền ", "Trạng thái"
            }
        ));
        tblTTHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTTHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTTHoaDon);

        btnTimKiem.setText("Tìm Kiếm ");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblTTHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã HDCT", "Mã HD", "Mã sách ", "Số lượng ", "Đơn Giá "
            }
        ));
        jScrollPane2.setViewportView(tblTTHoaDonChiTiet);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Chi Tiết Hóa Đơn ");

        btnAll.setText("ALL");
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiem)
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(256, 256, 256)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnAll, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblDenNgay)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnLocHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 33, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(320, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addGap(247, 247, 247))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(16, 16, 16)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAll)
                                    .addComponent(lblTuNgay))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnLocHoaDon)
                                    .addComponent(lblDenNgay)))
                            .addComponent(dtNgayKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Quản lý hoá đơn", jPanel1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Thông tin trả hàng");

        tblTHHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Mã KH", "Mã NV", "Tổng tiền", "Trạng thái"
            }
        ));
        tblTHHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTHHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblTHHoaDon);

        tblTHHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐCT", "Mã HD", "Mã Sách", "Số Lượng", "Đơn giá"
            }
        ));
        tblTHHoaDonChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTHHoaDonChiTietMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblTHHoaDonChiTiet);

        jLabel3.setText("Mã PTH");

        jLabel4.setText("Mã KH");

        jLabel5.setText("Mã HĐ");

        txtmakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmakhActionPerformed(evt);
            }
        });

        txtSoLuong.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSoLuongCaretUpdate(evt);
            }
        });
        txtSoLuong.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSoLuongInputMethodTextChanged(evt);
            }
        });

        jLabel10.setText("Ngày tạo");

        jLabel11.setText("Số tiền trả lại");

        txtsotientralai.setEditable(false);

        jLabel8.setText("Lý do Trả");

        btnthem.setText("Đổi hàng");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã sách");

        jButton1.setText("Đổi hàng");

        jLabel12.setText("Số lượng");

        btnTimHoaDon.setText("Tìm kiếm");

        jLabel6.setText("Mã nhân viên");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnthem)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoLuong)
                            .addComponent(txtMaPTH)
                            .addComponent(txtmakh)
                            .addComponent(txtlydo)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel10)))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jButton1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMaSach, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addComponent(txtngaytao)
                        .addComponent(txtmahd))
                    .addComponent(txtsotientralai, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(245, 245, 245))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnTimHoaDon)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimHoaDon)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaPTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(txtngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlydo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(txtsotientralai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý đổi trả", jPanel2);

        tbltrahang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PTH", "Mã HĐ", "Mã KH", "Mã NV", "Tổng tiền", "Ngày tạo", "Ngày trả", "Số tiền trả lại", "Lý do trả"
            }
        ));
        jScrollPane6.setViewportView(tbltrahang1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        this.dispose();
        new MainApp().setVisible(true);
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
//        this.dispose();
//        new BanHangNhanVien().setVisible(true);
        JOptionPane.showMessageDialog(this, "Ban la quan lý, khong phai nhan vien");
    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnQLSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLSachActionPerformed
        this.dispose();
        new QLSach1().setVisible(true);
    }//GEN-LAST:event_btnQLSachActionPerformed

    private void btnQLHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQLHoaDonActionPerformed

    private void btnQLNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNhanVienActionPerformed
        this.dispose();
        new QLNhanVien().setVisible(true);
    }//GEN-LAST:event_btnQLNhanVienActionPerformed

    private void btnQLKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLKhachHangActionPerformed
        this.dispose();
        new QLKhachHang_().setVisible(true);
    }//GEN-LAST:event_btnQLKhachHangActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muon thoat chuong trinh khong ?");
        if (choice == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnLocHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocHoaDonActionPerformed
        Date ngayBatDau = dtNgayBatDau.getDate();
        Date ngayKetThuc = dtNgayKetThuc.getDate();
        ArrayList<HoaDonVM> listloc = serviceHDVM.listloc(ngayBatDau, ngayKetThuc);
        loadtableTTHoaDon(listloc);
    }//GEN-LAST:event_btnLocHoaDonActionPerformed

    private void tblTTHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTTHoaDonMouseClicked
        int row = tblTTHoaDon.getSelectedRow();
        String ma = tblTTHoaDon.getValueAt(row, 0).toString();
        Integer maHoaDon = Integer.valueOf(ma);
        modelTTHDCT = (DefaultTableModel) tblTTHoaDonChiTiet.getModel();
        modelTTHDCT.setRowCount(0);
        ArrayList<HoaDonCTVM> list = serviceHDCT.getlist(maHoaDon);
        loadTabltTTHDCT(list);
    }//GEN-LAST:event_tblTTHoaDonMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        Integer maHoaDon = Integer.valueOf(txtTimKiem.getText());
        ArrayList<HoaDonCTVM> listTimKiem = serviceHDCT.getlist(maHoaDon);
        loadTabltTTHDCT(listTimKiem);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
        // TODO add your handling code here:
        listTTHoaDon = serviceHDVM.listHD();
        loadtableTTHoaDon(listTTHoaDon);
    }//GEN-LAST:event_btnAllActionPerformed

    private void tblTHHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTHHoaDonMouseClicked
        // TODO add your handling code here:
        //        int temp = tblhoadon.getSelectedRow();
        //        loadHoaDon(temp);

        int row = tblTHHoaDon.getSelectedRow();
        String ma = tblTHHoaDon.getValueAt(row, 0).toString();
        Integer maHoaDon = Integer.valueOf(ma);
        modelTHCDCT = (DefaultTableModel) tblTHHoaDonChiTiet.getModel();
        modelTHCDCT.setRowCount(0);
        ArrayList<HoaDonCTVM> list = serviceHDCT.getlist(maHoaDon);
        loadTableTHHDCT(list);
        txtmahd.setText(tblTHHoaDon.getValueAt(row, 0).toString());
        txtmakh.setText(tblTHHoaDon.getValueAt(row, 1).toString());
//        txtmanv.setText(tblTHHoaDon.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tblTHHoaDonMouseClicked

    private void tblTHHoaDonChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTHHoaDonChiTietMouseClicked
        int row = tblTHHoaDonChiTiet.getSelectedRow();
        txtMaSach.setText(tblTHHoaDonChiTiet.getValueAt(row, 2).toString());
        donGia = Float.parseFloat(tblTHHoaDonChiTiet.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblTHHoaDonChiTietMouseClicked

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed

        if (txtmahd.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống ma hoa don");
            txtmahd.requestFocus();
            return;
        } else if (txtmakh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống ma khach hang");
            txtmakh.requestFocus();
            return;
        } else if (txtSoLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống ma nhan vien");
            txtSoLuong.requestFocus();
            return;
        } else if (txtlydo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống ly do");
            txtlydo.requestFocus();
            return;
        } else if (txtsotientralai.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống tien tra lai");
            txtsotientralai.requestFocus();
            return;
        } else if (txtMaSach.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống ma sach");
            txtsotientralai.requestFocus();
            return;
        }
        float tien = Float.parseFloat(txtsotientralai.getText());
        if (tien < 0) {
            JOptionPane.showMessageDialog(this, "số tiền trả lại phải > 0");
            return;
        } else if (tien != tien) {
            JOptionPane.showMessageDialog(this, "số tiền trả lại phải là số nguyên ");
            return;
        }
        QLTraHang x = getTraHang();
        JOptionPane.showMessageDialog(this, serviceTH.themPTH(x));
        listTraHang = serviceTH.listTraHang();
        loadTableTH(listTraHang);
        capNhatSoLuong();
        for (QLTraHang c : listTraHang) {
            if (c.getMaHD() == Integer.parseInt(txtmahd.getText())) {
                maPHT = c.getMaPTH();
            }
        }
        TraHangChiTiet z = new TraHangChiTiet();
        z.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        z.setMaSach(Integer.parseInt(txtMaSach.getText()));
        z.setDonGia(donGia);
        z.setMaPhieuTraHang(maPHT);
        serviceTraHangCT.themTraHang(z);
        clearForm();
    }//GEN-LAST:event_btnthemActionPerformed

    private void txtmakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmakhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmakhActionPerformed

    private void txtSoLuongInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSoLuongInputMethodTextChanged

    }//GEN-LAST:event_txtSoLuongInputMethodTextChanged

    private void txtSoLuongCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSoLuongCaretUpdate
        if (!txtSoLuong.getText().isBlank()) {
            soLuong = Integer.parseInt(txtSoLuong.getText());
            txtsotientralai.setText(String.valueOf(soLuong * donGia));
        }
    }//GEN-LAST:event_txtSoLuongCaretUpdate

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
            java.util.logging.Logger.getLogger(FormQLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQLHoaDon().setVisible(true);
            }
        });
    }

    private void capNhatSoLuong() {
        listSach = serviceSach.getlist();
        for (SachViewmodel c : listSach) {
            if (c.getMasach() == Integer.parseInt(txtMaSach.getText())) {
                soSachBanDau = c.getSoluong();
            }
        }
        Integer soSachCapNhat = soSachBanDau + soLuong;
        serviceSach.capNhat(Integer.parseInt(txtMaSach.getText()), soSachCapNhat);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnLocHoaDon;
    private javax.swing.JButton btnQLHoaDon;
    private javax.swing.JButton btnQLKhachHang;
    private javax.swing.JButton btnQLNhanVien;
    private javax.swing.JButton btnQLSach;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTimHoaDon;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnthem;
    private com.toedter.calendar.JDateChooser dtNgayBatDau;
    private com.toedter.calendar.JDateChooser dtNgayKetThuc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblDenNgay;
    private javax.swing.JLabel lblTuNgay;
    private javax.swing.JTable tblTHHoaDon;
    private javax.swing.JTable tblTHHoaDonChiTiet;
    private javax.swing.JTable tblTTHoaDon;
    private javax.swing.JTable tblTTHoaDonChiTiet;
    private javax.swing.JTable tbltrahang1;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtMaPTH;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtlydo;
    private javax.swing.JTextField txtmahd;
    private javax.swing.JTextField txtmakh;
    private javax.swing.JTextField txtngaytao;
    private javax.swing.JTextField txtsotientralai;
    // End of variables declaration//GEN-END:variables
}
