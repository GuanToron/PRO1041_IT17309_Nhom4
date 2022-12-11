package View;

import DomainModel.KhachHang;
import DomainModel.TraHangChiTiet;
import ServiceImplement.HoaDonCTVMServiceImplement;
import ServiceImplement.HoaDonVMServiceImplement;
import ServiceImplement.SachserviceImpl;
import ServiceImplement.TraHangChiTietServiceImplement;
import ServiceImplement.TraHangServiceImpllement;
import ServiceImplement.manageKhachHangService;
import ServiceInterface.HoaDonCTVMServiccecInterface;
import ServiceInterface.HoaDonVMServiceInterface;
import ServiceInterface.ImanageKhachHangService;
import ServiceInterface.SachService;
import ServiceInterface.TraHangChiTietServiceInterface;
import ViewModel.HoaDonCTVM;
import ViewModel.HoaDonVM;
import ViewModel.QLKhachHang;
import ViewModel.QLTraHang;
import ViewModel.SachViewmodel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormHoaDon extends javax.swing.JFrame {

    private DefaultTableModel modelTTHoaDon = new DefaultTableModel();
    private DefaultTableModel modelTHHoaDon = new DefaultTableModel();
    private DefaultTableModel modelTTHDCT;
    private DefaultTableModel modelTHCDCT;
    private DefaultTableModel modelTHTraHang;
    private TraHangChiTietServiceInterface serviceTraHangCT = new TraHangChiTietServiceImplement();

    private HoaDonCTVMServiccecInterface serviceHDCT = new HoaDonCTVMServiceImplement();
    private HoaDonVMServiceInterface serviceHDVM = new HoaDonVMServiceImplement();
    private ArrayList<SachViewmodel> listSach = new ArrayList<>();
    private List<HoaDonVM> listTTHoaDon;
    private List<HoaDonVM> listTHHoaDon;
    private ArrayList<QLTraHang> listTraHang = new ArrayList<>();
    private final TraHangServiceImpllement serviceTH = new TraHangServiceImpllement();
    private SachService serviceSach = new SachserviceImpl();
    private ImanageKhachHangService timKiemKhachHsng = new manageKhachHangService();
    Integer soLuong;
    Float donGia;
    Integer soSachBanDau;
    Integer maPHT;

    public FormHoaDon() {
        initComponents();
        setLocationRelativeTo(null);
        listTTHoaDon = serviceHDVM.listHD();
        listTHHoaDon = serviceHDVM.listHDTH();
        loadtableTTHoaDon(listTTHoaDon);
        loadtableTHHoaDon(listTHHoaDon);
        loadTableTraHang();
    }

    private void loadtableTTHoaDon(List<HoaDonVM> list) {
        DefaultTableModel tblmodel = (DefaultTableModel) tblTTHoaDon1.getModel();
        tblmodel.setRowCount(0);
        tblmodel.setColumnIdentifiers(new String[]{"Mã hoá đơn", "Tên khách hàng", "Tên nhân viên", "Ngày tạo", "Tổng tiền", "Trạng Thái"});
        for (HoaDonVM hDVM : list) {
            tblmodel.addRow(hDVM.toDataRow2());
        }
    }

    private void loadTabltTTHDCT(ArrayList<HoaDonCTVM> listhdct) {
        modelTTHDCT = (DefaultTableModel) tblTTHoaDonChiTiet1.getModel();
        modelTTHDCT.setRowCount(0);
        for (HoaDonCTVM hoaDonCTVM : listhdct) {
            modelTTHDCT.addRow(new Object[]{hoaDonCTVM.getMaHoaDonCT(),
                //             hoaDonCTVM.getMaHoaDon(),
                hoaDonCTVM.getMaHoaDon(),
                hoaDonCTVM.getTenSach(),
                hoaDonCTVM.getSoLuong(),
                hoaDonCTVM.getDonGia()});

        }
    }
    private void loadTableTraHang(){
        modelTHTraHang = (DefaultTableModel) tblTraHang.getModel();
        modelTHTraHang.setRowCount(0);
        modelTHTraHang.setColumnIdentifiers(new String[]{"Mã phiếu trả hàng","Mã hoá đơn","Mã khách hàng","Ngày trả","Số tiền trả lại","Lý do trả"});
        ArrayList<QLTraHang> listTraHang = serviceTH.listTraHang();
        for (QLTraHang x : listTraHang) {
            modelTHTraHang.addRow(new Object[]{x.getMaPTH(),x.getMaHD(),x.getMaKH(),x.getNgayTra(),x.getTienTraLai(),x.getLyDo()});
        }
    }
    private void loadTableTHHDCT(ArrayList<HoaDonCTVM> listhdct) {
        modelTHCDCT = (DefaultTableModel) tblTHHoaDonChiTiet.getModel();
        modelTHCDCT.setRowCount(0);
        for (HoaDonCTVM hoaDonCTVM : listhdct) {
            modelTHCDCT.addRow(new Object[]{hoaDonCTVM.getMaHoaDonCT(),
                hoaDonCTVM.getMaHoaDon(),
                hoaDonCTVM.getTenSach(),
                hoaDonCTVM.getSoLuong(),
                hoaDonCTVM.getDonGia()});

        }
    }

    private void loadTraHang(int i) {
        QLTraHang x = listTraHang.get(i);
    }

    private void loadTableTH(ArrayList<QLTraHang> list) {

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
            tblmodel.addRow(hDVM.toDataRow3());
        }
    }

    private QLTraHang getTraHang() {
        QLTraHang x = new QLTraHang();
        x.setMaHD(Integer.parseInt(txtMaHD.getText()));
        Integer maKhachHang = 0;
        for (QLKhachHang z : timKiemKhachHsng.getAll()) {
            if (txtTenKhachHang.getText().equals(z.getTenKH())) {
                maKhachHang = z.getMaKH();
            }
        }
        x.setMaKH(maKhachHang);
        x.setMaNV(1);
        x.setNgayTra(new Date());
        x.setTienTraLai(Float.parseFloat(txtSoTienTraLai.getText()));
        x.setLyDo(txtLyDo.getText());
        return x;
    }

    private void clearForm() {
        txtLyDo.setText("");
        txtMaHD.setText("");
        txtTenKhachHang.setText("");
        txtSoLuong.setText("");
        txtMaPTH.setText("");

        txtNgayTao.setText("");
        txtSoTienTraLai.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(
            "unchecked")
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
        jPanel3 = new javax.swing.JPanel();
        lblTuNgay = new javax.swing.JLabel();
        lblDenNgay = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLocHoaDon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTTHoaDon1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTTHoaDonChiTiet1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnAll1 = new javax.swing.JButton();
        dtNgayBatDau = new com.toedter.calendar.JDateChooser();
        dtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        txtTenKH = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblTHHoaDon = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblTHHoaDonChiTiet = new javax.swing.JTable();
        lblMaPTH = new javax.swing.JLabel();
        maKH = new javax.swing.JLabel();
        lblmaHD = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        lblNgayTao = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        lblSoTienTraLai = new javax.swing.JLabel();
        txtSoTienTraLai = new javax.swing.JTextField();
        lblLyDoTra = new javax.swing.JLabel();
        txtLyDo = new javax.swing.JTextField();
        btnDoiHang = new javax.swing.JButton();
        txtMaPTH = new javax.swing.JTextField();
        lblMaSach = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        lblSoLuong = new javax.swing.JLabel();
        btnTimHoaDon = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblTraHang = new javax.swing.JTable();

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
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Quản Lý Hóa Đơn ");

        btnLocHoaDon.setText("Lọc Hóa Đơn");
        btnLocHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocHoaDonActionPerformed(evt);
            }
        });

        tblTTHoaDon1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTTHoaDon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTTHoaDon1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTTHoaDon1);

        tblTTHoaDonChiTiet1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã HDCT", "Mã HD", "Tên sách", "Số lượng ", "Đơn Giá "
            }
        ));
        tblTTHoaDonChiTiet1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTTHoaDonChiTiet1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTTHoaDonChiTiet1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Chi Tiết Hóa Đơn ");

        btnAll1.setText("ALL");
        btnAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAll1ActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm Kiếm ");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(dtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(322, 322, 322)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnLocHoaDon)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(btnAll1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(500, 576, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDenNgay)
                    .addComponent(dtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLocHoaDon)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAll1)
                        .addComponent(lblTuNgay))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(409, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản Lý Hóa Đơn ", jPanel1);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Thông tin trả hàng");

        tblTHHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Tên khách hàng", "Tên nhân viên", "Tổng tiền", "Trạng thái"
            }
        ));
        tblTHHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTHHoaDonMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblTHHoaDon);

        tblTHHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐCT", "Mã HD", "Tên Sách", "Số Lượng", "Đơn giá"
            }
        ));
        tblTHHoaDonChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTHHoaDonChiTietMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblTHHoaDonChiTiet);

        lblMaPTH.setText("Mã PTH");

        maKH.setText("Tên khách hàng");

        lblmaHD.setText("Mã HĐ");

        txtTenKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhachHangActionPerformed(evt);
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

        lblNgayTao.setText("Ngày trả");

        txtNgayTao.setEditable(false);

        lblSoTienTraLai.setText("Số tiền trả lại");

        txtSoTienTraLai.setEditable(false);

        lblLyDoTra.setText("Lý do Trả");

        btnDoiHang.setText("Đổi hàng");
        btnDoiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiHangActionPerformed(evt);
            }
        });

        lblMaSach.setText("Tên sách");

        lblSoLuong.setText("Số lượng");

        btnTimHoaDon.setText("Tìm kiếm");
        btnTimHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimHoaDonActionPerformed(evt);
            }
        });

        tblTraHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PTH", "Mã HĐ", "Mã KH", "Mã NV", "Tổng tiền", "Ngày tạo", "Ngày trả", "Số tiền trả lại", "Lý do trả"
            }
        ));
        jScrollPane9.setViewportView(tblTraHang);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maKH)
                    .addComponent(lblMaPTH)
                    .addComponent(lblSoLuong)
                    .addComponent(lblLyDoTra))
                .addGap(62, 62, 62)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(txtMaPTH)
                    .addComponent(txtTenKhachHang)
                    .addComponent(txtLyDo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(lblmaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(lblMaSach)
                            .addGap(47, 47, 47))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(lblNgayTao)
                            .addGap(43, 43, 43)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblSoTienTraLai)
                        .addGap(23, 23, 23)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(txtMaSach)
                    .addComponent(txtSoTienTraLai)
                    .addComponent(txtNgayTao))
                .addGap(63, 63, 63))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimHoaDon)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(330, 330, 330))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addComponent(btnDoiHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimHoaDon)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaPTH)
                    .addComponent(lblmaHD)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSach)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maKH)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNgayTao)
                        .addComponent(lblSoLuong)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLyDoTra)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLyDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSoTienTraLai)
                        .addComponent(txtSoTienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnDoiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản Lý Đổi Trả", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        this.dispose();
        new MainAppQuanLy().setVisible(true);
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
            this.dispose();
            new LoginView().setVisible(true);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnDoiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiHangActionPerformed

        if (txtMaHD.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống ma hoa don");
            txtMaHD.requestFocus();
            return;
        } else if (txtTenKhachHang.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống ma khach hang");
            txtTenKhachHang.requestFocus();
            return;
        } else if (txtSoLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống ma nhan vien");
            txtSoLuong.requestFocus();
            return;
        } else if (txtLyDo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống ly do");
            txtLyDo.requestFocus();
            return;
        } else if (txtSoTienTraLai.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống tien tra lai");
            txtSoTienTraLai.requestFocus();
            return;
        } else if (txtMaSach.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống ma sach");
            txtSoTienTraLai.requestFocus();
            return;
        }
        float tien = Float.parseFloat(txtSoTienTraLai.getText());
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
            if (c.getMaHD() == Integer.parseInt(txtMaHD.getText())) {
                maPHT = c.getMaPTH();
            }
        }
        TraHangChiTiet z = new TraHangChiTiet();
        z.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        Integer maSach = 0;
        for (SachViewmodel c : listSach) {
            if (txtMaSach.getText().equals(c.getTenTheLoai())) {
                maSach = c.getMasach();
            }
        }
        z.setMaSach(maSach);
        z.setDonGia(donGia);
        z.setMaPhieuTraHang(maPHT);
        serviceTraHangCT.themTraHang(z);
        clearForm();
    }//GEN-LAST:event_btnDoiHangActionPerformed

    private void txtSoLuongInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSoLuongInputMethodTextChanged

    }//GEN-LAST:event_txtSoLuongInputMethodTextChanged

    private void txtSoLuongCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSoLuongCaretUpdate
        if (!txtSoLuong.getText().isBlank()) {
            if (Integer.valueOf(txtSoLuong.getText()) > Integer.valueOf(tblTHHoaDonChiTiet.getValueAt(tblTHHoaDonChiTiet.getSelectedRow(), 3).toString())) {
                JOptionPane.showMessageDialog(this, "So sach doi lon hon so sach co trong hoadon. Vui long xem lai");
            } else {
                String regex = "^[0-9]*$";
                if (!txtSoLuong.getText().matches(regex)) {
                    JOptionPane.showMessageDialog(this, "So luong doi phai la so");
                } else {
                    soLuong = Integer.parseInt(txtSoLuong.getText());
                    txtSoTienTraLai.setText(String.valueOf(soLuong * donGia));
                }
            }
        }
    }//GEN-LAST:event_txtSoLuongCaretUpdate

    private void txtTenKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhachHangActionPerformed

    private void tblTHHoaDonChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTHHoaDonChiTietMouseClicked
        int row = tblTHHoaDonChiTiet.getSelectedRow();
        txtMaSach.setText(tblTHHoaDonChiTiet.getValueAt(row, 2).toString());
        donGia = Float.parseFloat(tblTHHoaDonChiTiet.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblTHHoaDonChiTietMouseClicked

    private void tblTHHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTHHoaDonMouseClicked
        int row = tblTHHoaDon.getSelectedRow();
        String ma = tblTHHoaDon.getValueAt(row, 0).toString();
        Integer maHoaDon = Integer.valueOf(ma);
        modelTHCDCT = (DefaultTableModel) tblTHHoaDonChiTiet.getModel();
        modelTHCDCT.setRowCount(0);
        ArrayList<HoaDonCTVM> list = serviceHDCT.getlist(maHoaDon);
        loadTableTHHDCT(list);
        txtMaHD.setText(ma);
        txtTenKhachHang.setText(tblTHHoaDon.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblTHHoaDonMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String ten = txtTenKH.getText();
        List<KhachHang> lst = new ArrayList<>();
        lst = timKiemKhachHsng.timKiem(ten);
        Integer maKhachHang = 0;
        for (KhachHang kH : lst) {
            if (kH.getTenKH().equals(ten)) {
                maKhachHang = kH.getMaKH();

            }

        }
        List<HoaDonVM> lstVM = serviceHDVM.timKiemTen(ten);
        loadtableTTHoaDon(lstVM);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAll1ActionPerformed
        // TODO add your handling code here:
        listTTHoaDon = serviceHDVM.listHD();
        loadtableTTHoaDon(listTTHoaDon);
    }//GEN-LAST:event_btnAll1ActionPerformed

    private void tblTTHoaDon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTTHoaDon1MouseClicked
        int row = tblTTHoaDon1.getSelectedRow();
        String ma = tblTTHoaDon1.getValueAt(row, 0).toString();
        Integer maHoaDon = Integer.valueOf(ma);
        modelTTHDCT = (DefaultTableModel) tblTTHoaDonChiTiet1.getModel();
        modelTTHDCT.setRowCount(0);
        ArrayList<HoaDonCTVM> list = serviceHDCT.getlist(maHoaDon);
        loadTabltTTHDCT(list);
    }//GEN-LAST:event_tblTTHoaDon1MouseClicked

    private void btnLocHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocHoaDonActionPerformed
        Date ngayBatDau = dtNgayBatDau.getDate();
        Date ngayKetThuc = dtNgayKetThuc.getDate();
        ArrayList<HoaDonVM> listloc = serviceHDVM.listloc(ngayBatDau, ngayKetThuc);
        loadtableTTHoaDon(listloc);
    }//GEN-LAST:event_btnLocHoaDonActionPerformed

    private void tblTTHoaDonChiTiet1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTTHoaDonChiTiet1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTTHoaDonChiTiet1MouseClicked

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        this.dispose();
        new FormThongKe().setVisible(true);
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnTimHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimHoaDonActionPerformed
        String ten = txtTimKiem.getText();
        List<KhachHang> lst = new ArrayList<>();
        lst = timKiemKhachHsng.timKiem(ten);
        Integer maKhachHang = 0;
        for (KhachHang kH : lst) {
            if (kH.getTenKH().equals(ten)) {
                maKhachHang = kH.getMaKH();

            }
        }
        List<HoaDonVM> lstVM = serviceHDVM.timKiemTen(ten);
        loadtableTHHoaDon(lstVM);
    }//GEN-LAST:event_btnTimHoaDonActionPerformed

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
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormHoaDon().setVisible(true);
            }
        });

    }

    private void capNhatSoLuong() {
        Integer maSach = 0;
        for (SachViewmodel z : listSach) {
            if (txtMaSach.getText().equals(z.getTenTheLoai())) {
                maSach = z.getMasach();
            }
        }
        listSach = serviceSach.getlist();
        for (SachViewmodel c : listSach) {
            if (c.getTensach().equals(txtMaSach.getText())) {
                soSachBanDau = c.getSoluong();
            }
        }
        Integer soSachCapNhat = soSachBanDau + soLuong;
        serviceSach.capNhat(maSach, soSachCapNhat);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton btnAll1;
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnDoiHang;
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
    private com.toedter.calendar.JDateChooser dtNgayBatDau;
    private com.toedter.calendar.JDateChooser dtNgayKetThuc;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDenNgay;
    private javax.swing.JLabel lblLyDoTra;
    private javax.swing.JLabel lblMaPTH;
    private javax.swing.JLabel lblMaSach;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblSoTienTraLai;
    private javax.swing.JLabel lblTuNgay;
    private javax.swing.JLabel lblmaHD;
    private javax.swing.JLabel maKH;
    private javax.swing.JTable tblTHHoaDon;
    private javax.swing.JTable tblTHHoaDonChiTiet;
    private javax.swing.JTable tblTTHoaDon1;
    private javax.swing.JTable tblTTHoaDonChiTiet1;
    private javax.swing.JTable tblTraHang;
    private javax.swing.JTextField txtLyDo;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaPTH;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoTienTraLai;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
