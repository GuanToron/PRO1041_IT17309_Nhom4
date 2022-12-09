package View;

import DomainModel.DanhMuc;
import DomainModel.KhachHang;
import DomainModel.NPH;
import DomainModel.NXB;
import DomainModel.TacGia;
import DomainModel.TheLoai;
import DomainModel.TraHangChiTiet;
import ServiceImplement.DMImplement_XT;
import ServiceImplement.HoaDonCTVMServiceImplement;
import ServiceImplement.HoaDonVMServiceImplement;
import ServiceImplement.NPHServiceImplement;
import ServiceImplement.SachVMServiceImplement;
import ServiceImplement.SachserviceImpl;
import ServiceImplement.TGServiceImplement;
import ServiceImplement.TLServiceImplement;
import ServiceImplement.TraHangChiTietServiceImplement;
import ServiceImplement.TraHangServiceImpllement;
import ServiceImplement.manageKhachHangService;
import ServiceImplement.manageNXBService;
import ServiceInterface.DMInterface_XT;
import ServiceInterface.HoaDonCTVMServiccecInterface;
import ServiceInterface.HoaDonVMServiceInterface;
import ServiceInterface.ImanageKhachHangService;
import ServiceInterface.ImanageNXBService;
import ServiceInterface.NPHServiceInterface;
import ServiceInterface.SachService;
import ServiceInterface.SachVMServiceInterface;
import ServiceInterface.TGServiceInterface;
import ServiceInterface.TLServiceInterface;
import ServiceInterface.TraHangChiTietServiceInterface;
import ViewModel.GioHangVM;
import ViewModel.HoaDonCTVM;
import ViewModel.HoaDonVM;
import ViewModel.QLKhachHang;
import ViewModel.QLTraHang;
import ViewModel.SachVM;
import ViewModel.SachViewmodel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Xuan Truong
 */
public class BanHang extends javax.swing.JFrame {

    private DefaultTableModel modelSach = new DefaultTableModel();
    private DefaultTableModel modelHoaDonVM = new DefaultTableModel();
    private DefaultTableModel modelHoaDonCTVM = new DefaultTableModel();
    private DefaultTableModel modelLoadGH = new DefaultTableModel();
    private DefaultTableModel modelTHHoaDon = new DefaultTableModel();
    private DefaultTableModel modelTHCDCT;
    private final DefaultTableModel modelTHTraHang = new DefaultTableModel();

    private ArrayList<QLTraHang> listTraHang = new ArrayList<>();
    private ArrayList<HoaDonVM> listHDVM = new ArrayList<>();
    private ArrayList<SachVM> listSach = new ArrayList<>();
    private ArrayList<SachViewmodel> listSachVM = new ArrayList<>();
    private ArrayList<SachViewmodel> listSach1 = new ArrayList<>();
    private ArrayList<GioHangVM> listGioHang = new ArrayList<>();
    private List<QLKhachHang> listKH = new ArrayList<>();
    private ArrayList<DanhMuc> listDM = new ArrayList<>();
    private ArrayList<TacGia> listTG = new ArrayList<>();
    private ArrayList<TheLoai> listTL = new ArrayList<>();
    private ArrayList<NPH> listNPH = new ArrayList<>();
    private ArrayList<String> listNhomTuoi = new ArrayList<>();
    private List<NXB> listnxb;

    private SachVMServiceInterface serviceSach = new SachVMServiceImplement();
    private SachService serviceSach1 = new SachserviceImpl();
    private ImanageKhachHangService serviceKH = new manageKhachHangService();
    private HoaDonVMServiceInterface serviceHoaDonVM = new HoaDonVMServiceImplement();
    private HoaDonCTVMServiccecInterface serviceHDCTVM = new HoaDonCTVMServiceImplement();
    private DMInterface_XT serviceDM = new DMImplement_XT();
    private TGServiceInterface serviceTG = new TGServiceImplement();
    private TLServiceInterface serviceTL = new TLServiceImplement();
    private NPHServiceInterface serviceNPH = new NPHServiceImplement();
    private final ImanageNXBService imanageNXBService = new manageNXBService();
    private HoaDonCTVMServiccecInterface serviceHDCT = new HoaDonCTVMServiceImplement();
    private final TraHangServiceImpllement serviceTH = new TraHangServiceImpllement();
    private SachService serviceSach2 = new SachserviceImpl();
    private TraHangChiTietServiceInterface serviceTraHangCT = new TraHangChiTietServiceImplement();

    private DefaultComboBoxModel boxModelTG = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelTL = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelDM = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelNhomTuoi = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelDanhMucSearch = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelNPH = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelNXB = new DefaultComboBoxModel();

    private ArrayList<String> listDanhMucSearch = new ArrayList<>();
    float tongtienGH = 0;
    float tongTienHD;
    float tienKhachDua = 0;
    Integer diemThua = 0;
    Integer diemSau = 0;
    Integer checkDiem = 0;
    Float donGia;
    Integer soSachBanDau;
    Integer maPHT;
    Integer soLuong;

    public BanHang() {
        initComponents();
        initComponents();
        setLocationRelativeTo(null);

        tblSach.setModel(modelSach);
        tblHoaDon.setModel(modelHoaDonVM);
        tblGioHang2.setModel(modelHoaDonCTVM);

        listSach = serviceSach.listSach();
        listHDVM = serviceHoaDonVM.listHDVM();
        listKH = serviceKH.getAll();

        loadTableSach(listSach);
        loadTableHoaDonVM(listHDVM);
        loadComBoDanhMucSearch();
    }

    private void loadTableSach(ArrayList<SachVM> list) {
        modelSach.setRowCount(0);
        modelSach.setColumnIdentifiers(new String[]{"Mã sách", "Tên sách", "Số lượng", "Giá bán"});
        for (SachVM x : list) {
            modelSach.addRow(new Object[]{x.getMaSach(), x.getTenSach(), x.getSoLuong(), x.getGiaBan()});
        }
    }

    private void loadTableHoaDonVM(ArrayList<HoaDonVM> list) {
        modelHoaDonVM.setRowCount(0);
        modelHoaDonVM.setColumnIdentifiers(new String[]{"Mã hoá đơn", "Khách hàng", "Mã nhân viên", "Ngày tạo", "Trạng thái"});
        for (HoaDonVM x : list) {
            modelHoaDonVM.addRow(x.toDataRow());
        }
    }

    private void loadTableGioHang(ArrayList<GioHangVM> list) {
        modelHoaDonCTVM.setRowCount(0);
        modelHoaDonCTVM.setColumnIdentifiers(new String[]{"Tên sách", "Số lượng", "Đơn giá", "Thành tiền"});
        for (GioHangVM x : list) {
            modelHoaDonCTVM.addRow(new Object[]{x.getTenSach(), x.getSoLuong(), x.getDonGia(), x.getThanhTien()});
        }
    }

    private void loadComBoDanhMucSearch() {
        boxModelDanhMucSearch.removeAllElements();
        listDanhMucSearch.add("Thể loại");
        listDanhMucSearch.add("Tác giả");
        listDanhMucSearch.add("Danh mục");
        listDanhMucSearch.add("NXB");
        listDanhMucSearch.add("NPH");
        listDanhMucSearch.add("Nhóm tuổi");
        for (String x : listDanhMucSearch) {
            boxModelDanhMucSearch.addElement(x);
        }
        cbDanhMucSearch.setModel(boxModelDanhMucSearch);
    }

    private void loadComboNhomTuoiSearch() {
        boxModelNhomTuoi.removeAllElements();
        listNhomTuoi.add("1-4");
        listNhomTuoi.add("5-9");
        listNhomTuoi.add("10-15");
        listNhomTuoi.add("15+");
        for (String x : listNhomTuoi) {
            boxModelNhomTuoi.addElement(x);
        }
        cbChiTetDanhMuc.setModel(boxModelNhomTuoi);
    }

    private void clear() {
        txtMaHoaDon.setText("");
        txtNgayTao.setText("");
        txtMaNhanVien.setText("");
        txtTongTien.setText("");
        txtMaKhachHang.setText("");
        txtTenKhachHang.setText("");
        txtDiemTichLuy.setText("");
        txtTienGiam.setText("");
        txtTienSauKhiGiam.setText("");
        txtTienKhachDua.setText("");
        txtTienThua.setText("");
        listGioHang.removeAll(listGioHang);
        loadTableGioHang(listGioHang);
    }

    private void inHoaDon(HoaDonVM x) {
        try {
            FileOutputStream fos = new FileOutputStream("D\\HoaDon\\Hoadon.doc");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(x);
            fos.close();
            oos.close();
            JOptionPane.showMessageDialog(this, "In hoá đơn thành công");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "In hoá đơn thất bại");
        }
    }

    private void loadhdcho() {
        DefaultTableModel tblhdchuathanhtoan = (DefaultTableModel) tblHoaDon.getModel();
        tblhdchuathanhtoan.setRowCount(0);
        List<HoaDonVM> listhdcho = serviceHoaDonVM.loaddangcho();

        for (HoaDonVM hd : listhdcho) {
            tblhdchuathanhtoan.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaKhachHang(), hd.getMaNhanVien(), hd.getNgayTao(), hd.getTrangThai() == 1 ? "Chưa thanh toán" : "Đang chờ "});
        }
    }

    private void loadHDChuathanhtoan() {
        DefaultTableModel tblhdchuathanhtoan = (DefaultTableModel) tblHoaDon.getModel();
        tblhdchuathanhtoan.setRowCount(0);
        List<HoaDonVM> listhdcho = serviceHoaDonVM.loadchuathanhtoan();

        for (HoaDonVM hd : listhdcho) {
            tblhdchuathanhtoan.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaKhachHang(), hd.getMaNhanVien(), hd.getNgayTao(), hd.getTrangThai() == 1 ? "Chưa thanh toán" : "Đang chờ "});
        }
    }

    private void loadComboDanhMuc() {
        boxModelDM.removeAllElements();
        listDM = serviceDM.listDM();
        for (DanhMuc x : listDM) {
            boxModelDM.addElement(x.getTenDM());
        }
        cbChiTetDanhMuc.setModel(boxModelDM);
    }

    private void loadComboNPH() {
        boxModelNPH.removeAllElements();
        listNPH = serviceNPH.listNPH();
        for (NPH x : listNPH) {
            boxModelNPH.addElement(x.getTenNPH());
        }
        cbChiTetDanhMuc.setModel(boxModelNPH);
    }

    private void loadComboTacGia() {
        boxModelTG.removeAllElements();
        listTG = serviceTG.listTG();
        for (TacGia x : listTG) {
            boxModelTG.addElement(x.getTenTacGia());
        }
        cbChiTetDanhMuc.setModel(boxModelTG);
    }

    private void loadComBoNXB() {
        boxModelNXB.removeAllElements();
        listnxb = imanageNXBService.getAll();
        for (NXB x : listnxb) {
            boxModelNXB.addElement(x.getTenNXB());
        }
        cbChiTetDanhMuc.setModel(boxModelNXB);
    }

    private void loadComboTheLoai() {
        boxModelTL.removeAllElements();
        listTL = serviceTL.listTL();
        for (TheLoai x : listTL) {
            boxModelTL.addElement(x.getTenTheLoai());
        }
        cbChiTetDanhMuc.setModel(boxModelTL);
    }

    private void loadTienSauKhiGiam() {
        float tongTien = 0;
        if (txtTongTien.getText().isBlank()) {
            tongTien = 0;
        } else {
            tongTien = Float.parseFloat(txtTongTien.getText());
        }
        Integer tienGiam = 0;
        if (txtTienGiam.getText().isBlank()) {
            tienGiam = 0;
        } else {
            tienGiam = Integer.valueOf(txtTienGiam.getText());
        }
        float tienSauKhiGiam = tongTien - tienGiam;
        txtTienSauKhiGiam.setText(String.valueOf(tienSauKhiGiam));
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

    private void capNhatSoLuong() {
        listSachVM = serviceSach2.getlist();
        for (SachViewmodel c : listSachVM) {
            if (c.getMasach() == Integer.parseInt(txtMaSach.getText())) {
                soSachBanDau = c.getSoluong();
            }
        }
        Integer soSachCapNhat = soSachBanDau + soLuong;
        serviceSach2.capNhat(Integer.parseInt(txtMaSach.getText()), soSachCapNhat);
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

        jPanel7 = new javax.swing.JPanel();
        btnBanHang = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblGioHang2 = new javax.swing.JTable();
        btnXoaGioHang2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rdCho = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        cbDanhMucSearch = new javax.swing.JComboBox<>();
        cbChiTetDanhMuc = new javax.swing.JComboBox<>();
        btnLoc = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnTaoHD = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTienSauKhiGiam = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        btnChonKH = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtDiemTichLuy = new javax.swing.JTextField();
        rdDiem = new javax.swing.JRadioButton();
        btnThemKH = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTienGiam = new javax.swing.JTextField();
        btnHoaDonCho = new javax.swing.JButton();
        btnClearGioHang1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblTHHoaDon = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        btnTimHoaDon = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblTHHoaDonChiTiet = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbltrahang1 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        btnthem = new javax.swing.JButton();
        txtMaPTH = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtmahd = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtmakh = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtngaytao = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtlydo = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtsotientralai = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(51, 255, 255));

        btnBanHang.setBackground(new java.awt.Color(255, 102, 51));
        btnBanHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBanHang.setText("BÁN HÀNG");
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("GIỎ HÀNG");

        tblGioHang2.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGioHang2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHang2tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblGioHang2);

        btnXoaGioHang2.setText("Xoa");
        btnXoaGioHang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGioHang2btnXoaGioHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaGioHang2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(btnXoaGioHang2)
                        .addGap(76, 76, 76))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("DANH SÁCH HOÁ ĐƠN CHỜ");

        rdCho.setText("Đang chờ");
        rdCho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdChoActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Chưa thanh toán");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(rdCho)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rdCho)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("SÁCH");

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblSach);

        jLabel15.setText("Lọc");

        cbDanhMucSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDanhMucSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDanhMucSearchItemStateChanged(evt);
            }
        });

        cbChiTetDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnLoc.setText("L");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(cbDanhMucSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbChiTetDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(cbDanhMucSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbChiTetDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTimKiem)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLoc)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Mã hoá đơn");

        txtMaHoaDon.setEditable(false);
        txtMaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHoaDonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("HOÁ ĐƠN");

        btnTaoHD.setText("Tạo HĐ");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        jLabel6.setText("Ngày tạo");

        txtMaNhanVien.setEditable(false);

        jLabel7.setText("Mã nhân viên");

        txtNgayTao.setEditable(false);

        jLabel9.setText("Tổng tiền");

        txtTongTien.setEditable(false);

        jLabel10.setText("Tiền khách đưa");

        txtTienSauKhiGiam.setEditable(false);

        jLabel11.setText("Tiền thừa");

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setText("Mã khách hàng");

        jLabel13.setText("Tên khách hàng");

        btnChonKH.setText("Chọn");
        btnChonKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKHActionPerformed(evt);
            }
        });

        jLabel8.setText("Điểm tích luỹ");

        rdDiem.setText("Dùng điểm");
        rdDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdDiemActionPerformed(evt);
            }
        });

        btnThemKH.setText("Thêm KH");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiemTichLuy))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemKH)
                    .addComponent(btnChonKH)
                    .addComponent(rdDiem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(btnThemKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDiemTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdDiem))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel14.setText("Tiền sau khi giảm");

        txtTienThua.setEditable(false);

        jLabel16.setText("Tiền giảm");

        txtTienGiam.setEditable(false);

        btnHoaDonCho.setText("Hoá đơn chờ");
        btnHoaDonCho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonChoActionPerformed(evt);
            }
        });

        btnClearGioHang1.setText("Huỷ hoá đơn");
        btnClearGioHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearGioHang1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel5))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                        .addComponent(txtTienSauKhiGiam)
                                        .addComponent(txtTongTien)
                                        .addComponent(txtMaNhanVien)
                                        .addComponent(txtNgayTao)
                                        .addComponent(txtTienThua)
                                        .addComponent(txtTienGiam))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(315, 315, 315)
                                .addComponent(btnTaoHD))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClearGioHang1)
                        .addGap(18, 18, 18)
                        .addComponent(btnThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHoaDonCho)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTaoHD)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTienSauKhiGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearGioHang1)
                    .addComponent(btnHoaDonCho))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane3.addTab("Ban hang", jPanel11);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Thông tin trả hàng");

        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
        jScrollPane7.setViewportView(tblTHHoaDon);

        btnTimHoaDon.setText("Tìm kiếm");
        btnTimHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnTimHoaDon)
                .addGap(61, 61, 61))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimHoaDon))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        jScrollPane8.setViewportView(tblTHHoaDonChiTiet);

        tbltrahang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PTH", "Mã HĐ", "Mã KH", "Mã NV", "Tổng tiền", "Ngày tạo", "Ngày trả", "Số tiền trả lại", "Lý do trả"
            }
        ));
        jScrollPane9.setViewportView(tbltrahang1);

        jLabel21.setText("Mã PTH");

        btnthem.setText("Đổi hàng");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        jLabel20.setText("Mã HĐ");

        jLabel22.setText("Mã KH");

        txtmakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmakhActionPerformed(evt);
            }
        });

        jLabel23.setText("Mã sách");

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

        jLabel24.setText("Số lượng");

        jLabel25.setText("Ngày tạo");

        jLabel26.setText("Lý do Trả");

        jLabel27.setText("Số tiền trả lại");

        txtsotientralai.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane8)
                            .addComponent(jScrollPane9)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtlydo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtmakh, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(txtMaPTH))))
                        .addGap(156, 156, 156)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(29, 29, 29))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel23))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)))
                                .addGap(49, 49, 49)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsotientralai, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(txtngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlydo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(txtsotientralai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnthem)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Tra hang", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane3)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblGioHang2tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHang2tblGioHangMouseClicked
        //        int row = tblGioHang.getSelectedRow();
        //        SachVM x = new SachVM();
        //        x.setSoLuong((Integer) tblGioHang.getValueAt(row, 1));
        //        x.setTenSach(tblGioHang.getValueAt(row, 0).toString());
        //        x.setGiaBan((Float) tblGioHang.getValueAt(row, 2));
        //        JOptionPane.showInputDialog(this, "Nhap so sach muon xoa");
    }//GEN-LAST:event_tblGioHang2tblGioHangMouseClicked

    private void btnXoaGioHang2btnXoaGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGioHang2btnXoaGioHangActionPerformed
        int temp = tblGioHang2.getSelectedRow();
        if (temp < 0) {
            return;
        } else {
            GioHangVM x = listGioHang.get(temp);
            String tenSach = x.getTenSach();
            Integer soSachBanDau = 0;
            Integer soLuongSachGHBanDau = x.getSoLuong();
            String sachTru = JOptionPane.showInputDialog(this, "Nhap so sach muon xoa");
            String regex = "^[0-9]*$";
            for (SachVM z : listSach) {
                if (z.getTenSach().equals(x.getTenSach())) {
                    soSachBanDau = z.getSoLuong();
                }
            }
            if (!sachTru.matches(regex)) {
                JOptionPane.showMessageDialog(this, "So sach muon xoa phai la so");
            } else {
                Integer soSachTru = Integer.parseInt(sachTru);
                if (soLuongSachGHBanDau < soSachTru) {
                    JOptionPane.showMessageDialog(this, "Vuot qua so luong tru");
                } else {
                    Integer soSachCon = soLuongSachGHBanDau - soSachTru;
                    x.setSoLuong(soSachCon);
                    loadTableGioHang(listGioHang);
                    Integer soSachSauKhiXoa = soSachBanDau + soSachTru;
                    serviceSach.capNhatSoSach(soSachSauKhiXoa, tenSach);
                    listSach = serviceSach.listSach();
                    loadTableSach(listSach);
                }
            }
        }
    }//GEN-LAST:event_btnXoaGioHang2btnXoaGioHangActionPerformed

    private void rdChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdChoActionPerformed
        loadhdcho();
    }//GEN-LAST:event_rdChoActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        loadHDChuathanhtoan();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        clear();
        int tem = tblHoaDon.getSelectedRow();
        if (tem < 0) {
            return;
        } else {
            if (tblHoaDon.getValueAt(tem, 4).toString().equals("Đang chờ")) {
                listGioHang.removeAll(listGioHang);
                loadTableGioHang(listGioHang);
                txtMaHoaDon.setText(tblHoaDon.getValueAt(tem, 0).toString());
                txtNgayTao.setText(tblHoaDon.getValueAt(tem, 3).toString());
                txtMaNhanVien.setText(tblHoaDon.getValueAt(tem, 2).toString());
                return;
            } else {
                String maHoaDon = tblHoaDon.getValueAt(tem, 0).toString();
                listGioHang = serviceHoaDonVM.getSach(maHoaDon);
                loadTableGioHang(listGioHang);
                txtMaHoaDon.setText(maHoaDon);
                txtMaKhachHang.setText(tblHoaDon.getValueAt(tem, 1).toString());
                for (QLKhachHang n : listKH) {
                    if (n.getMaKH() == (Integer.valueOf(txtMaKhachHang.getText()))) {
                        txtTenKhachHang.setText(n.getTenKH());
                        txtDiemTichLuy.setText(String.valueOf(n.getDiemTichLuy()));
                    }
                }
                txtNgayTao.setText(tblHoaDon.getValueAt(tem, 3).toString());
                txtMaNhanVien.setText(tblHoaDon.getValueAt(tem, 2).toString());
                listKH = serviceKH.getAll();
                String tenKH = "";
                for (QLKhachHang n : listKH) {
                    if (n.getMaKH() == (Integer.valueOf(txtMaKhachHang.getText()))) {
                        tenKH = n.getTenKH();
                        txtDiemTichLuy.setText(String.valueOf(n.getDiemTichLuy()));
                    }
                }
                txtTenKhachHang.setText(tenKH);
                float tienHang = 0;
                for (GioHangVM x : listGioHang) {
                    tienHang = tienHang + x.getThanhTien();
                }
                txtTongTien.setText(String.valueOf(tienHang));
            }
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String text = txtTimKiem.getText();
        String regex = "^[a-zA-Z]*$";
        if (!text.matches(regex)) {
            JOptionPane.showMessageDialog(this, "Ten sach phai la cac chu cai");
        } else {
            ArrayList<SachVM> listTimKiem = serviceSach.listSearch(text);
            loadTableSach(listTimKiem);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked
        int row = tblSach.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui long chon sach");
        } else {
            String soLuong = JOptionPane.showInputDialog(this, "Nhập số lượng");
            if (Integer.valueOf(soLuong) == JOptionPane.CANCEL_OPTION) {
                return;
            } else {
                if (listGioHang.isEmpty()) {
                    Integer slSachCon;
                    slSachCon = (Integer) tblSach.getValueAt(row, 2) - Integer.valueOf(soLuong);
                    String tenSach = tblSach.getValueAt(row, 1).toString();
                    serviceSach.capNhatSoSach(slSachCon, tenSach);
                    listSach = serviceSach.listSach();
                    loadTableSach(listSach);
                    GioHangVM x = new GioHangVM();
                    x.setTenSach(tblSach.getValueAt(row, 1).toString());
                    x.setSoLuong(Integer.valueOf(soLuong));
                    x.setDonGia((Float) tblSach.getValueAt(row, 3));
                    x.setMaSach(Integer.valueOf(tblSach.getValueAt(row, 0).toString()));
                    listGioHang.add(x);
                    loadTableGioHang(listGioHang);
                    for (GioHangVM z : listGioHang) {
                        tongtienGH = tongtienGH + z.getThanhTien();
                    }
                    txtTongTien.setText(String.valueOf(tongtienGH));
                } else {
                    Integer slSachCon;
                    slSachCon = (Integer) tblSach.getValueAt(row, 2) - Integer.valueOf(soLuong);
                    String tenSach = tblSach.getValueAt(row, 1).toString();
                    serviceSach.capNhatSoSach(slSachCon, tenSach);
                    listSach = serviceSach.listSach();
                    loadTableSach(listSach);
                    GioHangVM x = new GioHangVM();
                    x.setTenSach(tblSach.getValueAt(row, 1).toString());
                    x.setSoLuong(Integer.valueOf(soLuong));
                    x.setDonGia((Float) tblSach.getValueAt(row, 3));
                    x.setMaSach(Integer.valueOf(tblSach.getValueAt(row, 0).toString()));
                    listGioHang.add(x);
                    loadTableGioHang(listGioHang);
                    for (GioHangVM z : listGioHang) {
                        tongtienGH = tongtienGH + z.getThanhTien();
                    }
                    txtTongTien.setText(String.valueOf(tongtienGH));
                }
            }
        }
    }//GEN-LAST:event_tblSachMouseClicked

    private void cbDanhMucSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDanhMucSearchItemStateChanged
        String text = (String) cbDanhMucSearch.getSelectedItem();
        if (text.equalsIgnoreCase("Tác giả")) {
            loadComboTacGia();
        }
        if (text.equalsIgnoreCase("Thể loại")) {
            loadComboTheLoai();
        }
        if (text.equalsIgnoreCase("NXB")) {
            loadComBoNXB();
        }
        if (text.equalsIgnoreCase("Danh mục")) {
            loadComboDanhMuc();
        }
        if (text.equalsIgnoreCase("NPH")) {
            loadComboNPH();
        }
        if (text.equalsIgnoreCase("Nhóm tuổi")) {
            loadComboNhomTuoiSearch();
        }
    }//GEN-LAST:event_cbDanhMucSearchItemStateChanged

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        String text = (String) cbChiTetDanhMuc.getSelectedItem();
        listSach1 = serviceSach1.getlist();
        ArrayList<SachVM> listLoc = serviceSach.listLoc(listSach1, text);
        loadTableSach(listLoc);
    }//GEN-LAST:event_btnLocActionPerformed

    private void txtMaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHoaDonActionPerformed

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        for (int i = 0; i < listHDVM.size(); i++) {
            if (listHDVM.size() > 10) {
                JOptionPane.showMessageDialog(this, "Đat gioi hoa don cho, vui long thanh toan cac hoa don truoc do");
                return;
            }
        }
        HoaDonVM x = new HoaDonVM();
        x.setNgayTao(new Date());
        x.setMaNhanVien(1);
        x.setTrangThai(0);
        //        ArrayList<HoaDonCTVM> listHDCT = new ArrayList<>();
        //        for (GioHangVM h : listGioHang) {
        //            HoaDonCTVM z = new HoaDonCTVM();
        //            z.setDonGia(h.getDonGia());
        //            z.setMaHoaDon(Integer.valueOf(txtMaHoaDon.getText()));
        //            z.setSoLuong(h.getSoLuong());
        //            z.setMaSach(h.getMaSach());
        //            listHDCT.add(z);
        //        }
        //        for (HoaDonCTVM h : listHDCT) {
        //            serviceHDCTVM.themHDCCT(h);
        //        }
        JOptionPane.showMessageDialog(this, serviceHoaDonVM.taoHD(x));
        listHDVM = serviceHoaDonVM.listHDVM();
        loadTableHoaDonVM(listHDVM);
        listGioHang.removeAll(listGioHang);
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        thanhToan();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnChonKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKHActionPerformed
        String text = JOptionPane.showInputDialog(this, "Nhập số điện thoại khách hàng");
        String regex = "^0[0-9]{9}$";
        if (!text.matches(regex)) {
            JOptionPane.showMessageDialog(this, "SDT sai dịnh dang");
        } else {
            KhachHang x = serviceKH.timKH(text);
            if (x.getSdt() == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy. Vui lòng thử lại hoặc tạo mới");
                int choice = JOptionPane.showConfirmDialog(this, "Ban co muon tao moi khong ?");
                if (choice == JOptionPane.OK_OPTION) {
                    new FormKhachHang_Mini().setVisible(true);
                }
            } else {
                txtTenKhachHang.setText(x.getTenKH());
                txtMaKhachHang.setText(String.valueOf(x.getMaKH()));
                txtDiemTichLuy.setText(String.valueOf(x.getDiemTichLuy()));
            }
        }
    }//GEN-LAST:event_btnChonKHActionPerformed

    private void rdDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdDiemActionPerformed
        if (rdDiem.isSelected()) {
            if (txtMaKhachHang.getText().isBlank() || txtTenKhachHang.getText().isBlank() || txtDiemTichLuy.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "Chưa chọn khách hàng");
            } else {
                String diem = JOptionPane.showInputDialog("Nhap so diem can quy doi");
                String regex = "^[0-9]*$";
                if (!diem.matches(regex)) {
                    JOptionPane.showMessageDialog(this, "Diem quy doi can là so");
                } else {
                    if (Integer.parseInt(diem) > Integer.parseInt(txtDiemTichLuy.getText())) {
                        JOptionPane.showMessageDialog(this, "Diem quy doi lon hon diem hien co");
                    } else {
                        Integer tienGiam = Integer.parseInt(diem) * 1000;
                        txtTienGiam.setText(String.valueOf(tienGiam));
                        loadTienSauKhiGiam();
                        diemThua = Integer.parseInt(txtDiemTichLuy.getText()) - Integer.parseInt(diem);
                        checkDiem = 1;
                    }
                }
            }
        }
    }//GEN-LAST:event_rdDiemActionPerformed

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        new FormKhachHang_Mini().setVisible(true);
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btnHoaDonChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonChoActionPerformed
        ArrayList<HoaDonCTVM> listHDCT = new ArrayList<>();
        HoaDonCTVM z = new HoaDonCTVM();
        for (GioHangVM x : listGioHang) {
            z.setDonGia(x.getDonGia());
            z.setMaHoaDon(Integer.valueOf(txtMaHoaDon.getText()));
            z.setSoLuong(x.getSoLuong());
            z.setMaSach(x.getMaSach());
            listHDCT.add(z);
        }
        for (HoaDonCTVM x : listHDCT) {
            serviceHDCTVM.themHDCCT(x);
        }
        HoaDonVM x = new HoaDonVM(Integer.valueOf(txtMaHoaDon.getText()), Integer.valueOf(txtMaKhachHang.getText()), tongTienHD, 1);
        serviceHoaDonVM.capNhatHD(x);
        listHDVM = serviceHoaDonVM.listHDVM();
        loadTableHoaDonVM(listHDVM);
        clear();
    }//GEN-LAST:event_btnHoaDonChoActionPerformed

    private void btnClearGioHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearGioHang1ActionPerformed
        HoaDonVM x = new HoaDonVM(Integer.parseInt(txtMaHoaDon.getText()), 3);
        JOptionPane.showMessageDialog(this, serviceHoaDonVM.capNhatHD(x));
        clear();
    }//GEN-LAST:event_btnClearGioHang1ActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed

    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muon thoat chuong trinh khong ?");
        if (choice == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

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

    private void btnTimHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimHoaDonActionPerformed

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
        JOptionPane.showMessageDialog(this, "Vui long tra " + txtsotientralai.getText() + "dong cho khach");
        clearForm();
    }//GEN-LAST:event_btnthemActionPerformed

    private void txtmakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmakhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmakhActionPerformed

    private void txtSoLuongCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSoLuongCaretUpdate
        if (!txtSoLuong.getText().isBlank()) {
            soLuong = Integer.parseInt(txtSoLuong.getText());
            txtsotientralai.setText(String.valueOf(soLuong * donGia));
        }
    }//GEN-LAST:event_txtSoLuongCaretUpdate

    private void txtSoLuongInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSoLuongInputMethodTextChanged

    }//GEN-LAST:event_txtSoLuongInputMethodTextChanged

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
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHang().setVisible(true);
            }
        });
    }

    private void thanhToan() {
        if (txtTienKhachDua.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Chua nhap tien khach dưa");
            return;
        }
        String regex = "^[0-9]*$";
        if (!txtTienKhachDua.getText().matches(regex)) {
            JOptionPane.showMessageDialog(this, "Tien nhap sai dinh dang");
        } else {
            if (checkDiem == 1) {
                float tongTienHD = Float.parseFloat(txtTienSauKhiGiam.getText());
                float tienKhachDua = Float.parseFloat(txtTienKhachDua.getText());
                if (tienKhachDua < tongTienHD) {
                    JOptionPane.showMessageDialog(this, "Chưa du tien");
                } else {
                    if (tongTienHD >= 200000) {
                        diemSau = diemThua + 1;
                        float tienThua = tienKhachDua - tongTienHD;
                        txtTienThua.setText(String.valueOf(tienThua));
                        btnThanhToan.setVisible(true);
                        ArrayList<HoaDonCTVM> listHDCT = new ArrayList<>();
                        for (GioHangVM x : listGioHang) {
                            HoaDonCTVM z = new HoaDonCTVM();
                            z.setDonGia(x.getDonGia());
                            z.setMaHoaDon(Integer.valueOf(txtMaHoaDon.getText()));
                            z.setSoLuong(x.getSoLuong());
                            z.setMaSach(x.getMaSach());
                            listHDCT.add(z);
                        }
                        for (HoaDonCTVM x : listHDCT) {
                            serviceHDCTVM.themHDCCT(x);
                        }
                        HoaDonVM x = new HoaDonVM(Integer.valueOf(txtMaHoaDon.getText()), Integer.valueOf(txtMaKhachHang.getText()), tongTienHD, 2);
                        JOptionPane.showMessageDialog(this, serviceHoaDonVM.capNhatHD(x));
                        listGioHang.removeAll(listGioHang);
                        loadTableGioHang(listGioHang);
                        serviceKH.updateDiem(txtMaKhachHang.getText(), diemSau);
                        listHDVM = serviceHoaDonVM.listHDVM();
                        loadTableHoaDonVM(listHDVM);
                        HoaDonVM inHoaDon = serviceHoaDonVM.inHoaDon(txtMaHoaDon.getText());
                        int choice = JOptionPane.showConfirmDialog(this, "Ban co muon in hoa don khong?");
                        if (choice == JOptionPane.OK_OPTION) {
                            inHoaDon(inHoaDon);
                        }
                        clear();
                    } else {
                        float tienThua = tienKhachDua - tongTienHD;
                        txtTienThua.setText(String.valueOf(tienThua));
                        btnThanhToan.setVisible(true);
                        ArrayList<HoaDonCTVM> listHDCT = new ArrayList<>();
                        for (GioHangVM x : listGioHang) {
                            HoaDonCTVM z = new HoaDonCTVM();
                            z.setDonGia(x.getDonGia());
                            z.setMaHoaDon(Integer.valueOf(txtMaHoaDon.getText()));
                            z.setSoLuong(x.getSoLuong());
                            z.setMaSach(x.getMaSach());
                            listHDCT.add(z);
                        }
                        for (HoaDonCTVM x : listHDCT) {
                            serviceHDCTVM.themHDCCT(x);
                        }
                        HoaDonVM x = new HoaDonVM(Integer.valueOf(txtMaHoaDon.getText()), Integer.valueOf(txtMaKhachHang.getText()), tongTienHD, 2);
                        JOptionPane.showMessageDialog(this, serviceHoaDonVM.capNhatHD(x));
                        listGioHang.removeAll(listGioHang);
                        loadTableGioHang(listGioHang);
                        listHDVM = serviceHoaDonVM.listHDVM();
                        loadTableHoaDonVM(listHDVM);
                        HoaDonVM inHoaDon = serviceHoaDonVM.inHoaDon(txtMaHoaDon.getText());
                        int choice = JOptionPane.showConfirmDialog(this, "Ban co muon in hoa don khong?");
                        if (choice == JOptionPane.OK_OPTION) {
                            inHoaDon(inHoaDon);
                        }
                        clear();
                    }
                }
            } else {
                float tongTienHD = Float.parseFloat(txtTongTien.getText());
                float tienKhachDua = Float.parseFloat(txtTienKhachDua.getText());
                if (tienKhachDua < tongTienHD) {
                    JOptionPane.showMessageDialog(this, "Chưa du tien");
                } else {
                    if (tongTienHD >= 200000) {
                        diemSau = Integer.parseInt(txtDiemTichLuy.getText()) + 1;
                        float tienThua = tienKhachDua - tongTienHD;
                        txtTienThua.setText(String.valueOf(tienThua));
                        btnThanhToan.setVisible(true);
                        ArrayList<HoaDonCTVM> listHDCT = new ArrayList<>();
                        for (GioHangVM x : listGioHang) {
                            HoaDonCTVM z = new HoaDonCTVM();
                            z.setDonGia(x.getDonGia());
                            z.setMaHoaDon(Integer.valueOf(txtMaHoaDon.getText()));
                            z.setSoLuong(x.getSoLuong());
                            z.setMaSach(x.getMaSach());
                            listHDCT.add(z);
                        }
                        for (HoaDonCTVM x : listHDCT) {
                            serviceHDCTVM.themHDCCT(x);
                        }
                        HoaDonVM x = new HoaDonVM(Integer.valueOf(txtMaHoaDon.getText()), Integer.valueOf(txtMaKhachHang.getText()), tongTienHD, 2);
                        JOptionPane.showMessageDialog(this, serviceHoaDonVM.capNhatHD(x));
                        listGioHang.removeAll(listGioHang);
                        loadTableGioHang(listGioHang);
                        serviceKH.updateDiem(txtMaKhachHang.getText(), diemSau);
                        listHDVM = serviceHoaDonVM.listHDVM();
                        loadTableHoaDonVM(listHDVM);
                        HoaDonVM inHoaDon = serviceHoaDonVM.inHoaDon(txtMaHoaDon.getText());
                        int choice = JOptionPane.showConfirmDialog(this, "Ban co muon in hoa don khong?");
                        if (choice == JOptionPane.OK_OPTION) {
                            inHoaDon(inHoaDon);
                        }
                        clear();
                    } else {
                        float tienThua = tienKhachDua - tongTienHD;
                        txtTienThua.setText(String.valueOf(tienThua));
                        btnThanhToan.setVisible(true);
                        ArrayList<HoaDonCTVM> listHDCT = new ArrayList<>();
                        for (GioHangVM x : listGioHang) {
                            HoaDonCTVM z = new HoaDonCTVM();
                            z.setDonGia(x.getDonGia());
                            z.setMaHoaDon(Integer.valueOf(txtMaHoaDon.getText()));
                            z.setSoLuong(x.getSoLuong());
                            z.setMaSach(x.getMaSach());
                            listHDCT.add(z);
                        }
                        for (HoaDonCTVM x : listHDCT) {
                            serviceHDCTVM.themHDCCT(x);
                        }
                        HoaDonVM x = new HoaDonVM(Integer.valueOf(txtMaHoaDon.getText()), Integer.valueOf(txtMaKhachHang.getText()), tongTienHD, 2);
                        JOptionPane.showMessageDialog(this, serviceHoaDonVM.capNhatHD(x));
                        listHDVM = serviceHoaDonVM.listHDVM();
                        loadTableHoaDonVM(listHDVM);
                        listGioHang.removeAll(listGioHang);
                        loadTableGioHang(listGioHang);
                        HoaDonVM inHoaDon = serviceHoaDonVM.inHoaDon(txtMaHoaDon.getText());
                        int choice = JOptionPane.showConfirmDialog(this, "Ban co muon in hoa don khong?");
                        if (choice == JOptionPane.OK_OPTION) {
                            inHoaDon(inHoaDon);
                        }
                        clear();
                    }
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnChonKH;
    private javax.swing.JButton btnClearGioHang1;
    private javax.swing.JButton btnHoaDonCho;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimHoaDon;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaGioHang2;
    private javax.swing.JButton btnthem;
    private javax.swing.JComboBox<String> cbChiTetDanhMuc;
    private javax.swing.JComboBox<String> cbDanhMucSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton rdCho;
    private javax.swing.JRadioButton rdDiem;
    private javax.swing.JTable tblGioHang2;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSach;
    private javax.swing.JTable tblTHHoaDon;
    private javax.swing.JTable tblTHHoaDonChiTiet;
    private javax.swing.JTable tbltrahang1;
    private javax.swing.JTextField txtDiemTichLuy;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtMaPTH;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTienGiam;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienSauKhiGiam;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtlydo;
    private javax.swing.JTextField txtmahd;
    private javax.swing.JTextField txtmakh;
    private javax.swing.JTextField txtngaytao;
    private javax.swing.JTextField txtsotientralai;
    // End of variables declaration//GEN-END:variables
}
