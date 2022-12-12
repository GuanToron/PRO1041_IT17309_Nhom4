package View;

import DomainModel.DanhMuc;
import DomainModel.KhachHang;
import DomainModel.NPH;
import DomainModel.NXB;
import DomainModel.Sach;
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
public class BanHangDoiTra extends javax.swing.JFrame {

    private DefaultTableModel modelSach = new DefaultTableModel();
    private DefaultTableModel modelBHHoaDonVM = new DefaultTableModel();
    private DefaultTableModel modelGioHang = new DefaultTableModel();
    private DefaultTableModel modelTHCDCT;
    private DefaultTableModel modelTHTraHang = new DefaultTableModel();
    private DefaultTableModel modelTHHoaDon = new DefaultTableModel();

    private DMInterface_XT serviceDM = new DMImplement_XT();
    private TGServiceInterface serviceTG = new TGServiceImplement();
    private TLServiceInterface serviceTL = new TLServiceImplement();
    private NPHServiceInterface serviceNPH = new NPHServiceImplement();
    private final ImanageNXBService imanageNXBService = new manageNXBService();
    private SachVMServiceInterface serviceSach = new SachVMServiceImplement();
    private SachService serviceSach1 = new SachserviceImpl();
    private HoaDonVMServiceInterface serviceBHHoaDon = new HoaDonVMServiceImplement();
    private ImanageKhachHangService serviceKH = new manageKhachHangService();
    private HoaDonCTVMServiccecInterface serviceBHHoaDonChiTiet = new HoaDonCTVMServiceImplement();
    private final TraHangServiceImpllement serviceTH = new TraHangServiceImpllement();
    private TraHangChiTietServiceInterface serviceTraHangCT = new TraHangChiTietServiceImplement();

    private DefaultComboBoxModel boxModelTG = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelTL = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelDM = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelNhomTuoi = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelNPH = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelNXB = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelDanhMucSearch = new DefaultComboBoxModel();

    private ArrayList<String> listDanhMucSearch = new ArrayList<>();
    private List<QLKhachHang> listKH = new ArrayList<>();
    private ArrayList<DanhMuc> listDM = new ArrayList<>();
    private ArrayList<TacGia> listTG = new ArrayList<>();
    private ArrayList<TheLoai> listTL = new ArrayList<>();
    private ArrayList<NPH> listNPH = new ArrayList<>();
    private ArrayList<String> listNhomTuoi = new ArrayList<>();
    private List<NXB> listnxb;
    private ArrayList<SachVM> listSach = new ArrayList<>();
    private List<HoaDonVM> listTHHoaDon;
    private ArrayList<SachViewmodel> listSachTH = new ArrayList<>();
    private ArrayList<SachViewmodel> listSachBH = new ArrayList<>();
    private ArrayList<GioHangVM> listGioHang = new ArrayList<>();
    private ArrayList<HoaDonVM> listBHHoaDon = new ArrayList<>();
    private ArrayList<QLTraHang> listTraHang = new ArrayList<>();

    float tongtienGH = 0;
    float tongTienHD = 0;
    float tienKhachDua = 0;
    Integer diemThua = 0;
    Integer checkDiem = 0;
    Integer diemSau = 0;
    Float donGia;
    Integer soLuong;
    Integer soSachBanDau;
    Integer maPHT;
    Integer maKhachHang = 0;

    public BanHangDoiTra() {
        initComponents();
        setLocationRelativeTo(null);

        tblSach.setModel(modelSach);
        tblBHHoaDon.setModel(modelBHHoaDonVM);
        tblBHGioHang.setModel(modelGioHang);
        tblTHHoaDon.setModel(modelTHHoaDon);
        tblTraHang.setModel(modelTHTraHang);

        listSach = serviceSach.listSach();
        listBHHoaDon = serviceBHHoaDon.listHDVM();
        listTHHoaDon = serviceBHHoaDon.listHDTH();
        listTraHang = serviceTH.listTraHang();

        loadTableSach(listSach);
        loadTableBanHangHoaDon(listBHHoaDon);
        loadtableTHHoaDon(listTHHoaDon);
        loadTableTH(listTraHang);
        loadComBoDanhMucSearch();

    }
    private void thanhToanKhachLe(){
        float tongTienHD = Float.parseFloat(txtTongTien.getText());
            float tienKhachDua = Float.parseFloat(txtTienKhachDua.getText());
            if (tienKhachDua < tongTienHD) {
                JOptionPane.showMessageDialog(this, "Chưa du tien");
            } else {
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
                    serviceBHHoaDonChiTiet.themHDCCT(x);
                }
                HoaDonVM x = new HoaDonVM();
                x.setTongTien(tongTienHD);
                x.setTrangThai(2);
                x.setMaHoaDon(Integer.valueOf(txtMaHoaDon.getText()));
                JOptionPane.showMessageDialog(this, serviceBHHoaDon.capNhatHDCho(x));
                listGioHang.removeAll(listGioHang);
                loadTableGioHang(listGioHang);
                listBHHoaDon = serviceBHHoaDon.listHDVM();
                loadTableBanHangHoaDon(listBHHoaDon);
                HoaDonVM inHoaDon = serviceBHHoaDon.inHoaDon(txtMaHoaDon.getText());
                int choice = JOptionPane.showConfirmDialog(this, "Ban co muon in hoa don khong?");
                if (choice == JOptionPane.OK_OPTION) {
                    inHoaDon(inHoaDon);
                }
                clear();
            }
    }
    private void loadTableSach(ArrayList<SachVM> list) {
        modelSach.setRowCount(0);
        modelSach.setColumnIdentifiers(new String[]{"Mã sách", "Tên sách", "Số lượng", "Giá bán"});
        for (SachVM x : list) {
            modelSach.addRow(new Object[]{x.getMaSach(), x.getTenSach(), x.getSoLuong(), x.getGiaBan()});
        }
    }

    private void loadTableTH(ArrayList<QLTraHang> list) {

        modelTHTraHang.setRowCount(0);
        modelTHTraHang.setColumnIdentifiers(new String[]{"Mã PTH", "Mã HĐ", "Mã KH", "Mã NV", "Ngày Trả", "Số Tiền Trả Lại", "Lý Do Trả"});
        for (QLTraHang x : list) {
            modelTHTraHang.addRow(x.toDataRow());
        }
    }

    private void loadTableBanHangHoaDon(ArrayList<HoaDonVM> list) {
        modelBHHoaDonVM.setRowCount(0);
        modelBHHoaDonVM.setColumnIdentifiers(new String[]{"Mã hoá đơn", "Khách hàng", "Mã nhân viên", "Ngày tạo", "Trạng thái"});
        for (HoaDonVM x : list) {
            modelBHHoaDonVM.addRow(x.toDataRow4());
        }
    }

    private void loadtableTHHoaDon(List<HoaDonVM> list) {
        modelTHHoaDon.setColumnCount(0);
        modelTHHoaDon.setColumnIdentifiers(new String[]{"Mã hoá đơn", "Khách hàng", "Mã nhân viên", "Ngày tạo"});
        for (HoaDonVM x : list) {
            modelTHHoaDon.addRow(x.toDataRow1());
        }
    }

    private void thanhToan() {
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
            serviceBHHoaDonChiTiet.themHDCCT(x);
        }
        HoaDonVM x = new HoaDonVM(Integer.valueOf(txtMaHoaDon.getText()), Integer.valueOf(txtMaKhachHang.getText()), tongTienHD, 2);
        JOptionPane.showMessageDialog(this, serviceBHHoaDon.capNhatHDThanhToan(x));
        listGioHang.removeAll(listGioHang);
        loadTableGioHang(listGioHang);
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

    private void loadSachFormHD(List<GioHangVM> list) {
        modelBHHoaDonVM.setRowCount(0);
        modelBHHoaDonVM.setColumnIdentifiers(new String[]{"Tên sách", "Số lượng", "Đơn giá", "Thành tiền"});
        for (GioHangVM sach : list) {
            modelBHHoaDonVM.addRow(new Object[]{sach.getTenSach(), sach.getSoLuong(), sach.getDonGia(), sach.getThanhTien()});
        }
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

    private void loadTableGioHang(ArrayList<GioHangVM> list) {
        modelGioHang.setRowCount(0);
        modelGioHang.setColumnIdentifiers(new String[]{"Tên sách", "Số lượng", "Đơn giá", "Thành tiền"});
        for (GioHangVM x : list) {
            modelGioHang.addRow(new Object[]{x.getTenSach(), x.getSoLuong(), x.getDonGia(), x.getThanhTien()});
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

    private void clear() {
        txtMaHoaDon.setText("");
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

    private QLTraHang getTraHang() {
        QLTraHang x = new QLTraHang();
        x.setMaHD(Integer.parseInt(txtMaHD.getText()));
        listKH = serviceKH.getAll();
        for (QLKhachHang z : listKH) {
            if (z.getTenKH().equalsIgnoreCase(txtTenKhachHang1.getText())) {
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

    private void capNhatSoLuong() {
        Integer maSach = 0;
        for (SachViewmodel z : listSachTH) {
            if (txtMaSach.getText().equals(z.getTenTheLoai())) {
                maSach = z.getMasach();
            }
        }
        listSachTH = serviceSach1.getlist();
        for (SachViewmodel c : listSachTH) {
            if (c.getTensach().equals(txtMaSach.getText())) {
                soSachBanDau = c.getSoluong();
            }
        }
        Integer soSachCapNhat = soSachBanDau + soLuong;
        serviceSach1.capNhat(maSach, soSachCapNhat);
    }

    private void clearForm() {
        txtLyDo.setText("");
        txtMaHD.setText("");
        txtTenKhachHang.setText("");
        txtSoLuong.setText("");
        txtMaPTH.setText("");
        txtSoTienTraLai.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLyDoTra = new javax.swing.JLabel();
        SidePanel = new javax.swing.JPanel();
        btnTrangChu = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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
        btnThoat = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rdCho = new javax.swing.JRadioButton();
        rdChuaThanhToan = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBHHoaDon = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBHGioHang = new javax.swing.JTable();
        btnXoaGioHang = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbDanhMucSearch = new javax.swing.JComboBox<>();
        cbChiTetDanhMuc = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        btnTimTenSach = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        btnChonKH = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtDiemTichLuy = new javax.swing.JTextField();
        rdDiem = new javax.swing.JRadioButton();
        btnThemKH = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        btnTaoHD = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTienGiam = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTienSauKhiGiam = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        btnClearGioHang1 = new javax.swing.JButton();
        btnHoaDonCho = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtTimKiem1 = new javax.swing.JTextField();
        btnTimHoaDon = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblTHHoaDon = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblTHHoaDonChiTiet = new javax.swing.JTable();
        lblMaPTH = new javax.swing.JLabel();
        txtMaPTH = new javax.swing.JTextField();
        lblmaHD = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        maKH = new javax.swing.JLabel();
        txtTenKhachHang1 = new javax.swing.JTextField();
        lblMaSach = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        lblSoLuong = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        lblNgayTao = new javax.swing.JLabel();
        txtNgayTao1 = new javax.swing.JTextField();
        lblLyDoTra1 = new javax.swing.JLabel();
        txtLyDo = new javax.swing.JTextField();
        lblSoTienTraLai = new javax.swing.JLabel();
        txtSoTienTraLai = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblTraHang = new javax.swing.JTable();
        btnDoiHang = new javax.swing.JButton();

        lblLyDoTra.setText("Lý do Trả");

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

        jButton2.setBackground(new java.awt.Color(255, 102, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("BÁN HÀNG");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        rdChuaThanhToan.setText("Chưa thanh toán");
        rdChuaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdChuaThanhToanActionPerformed(evt);
            }
        });

        tblBHHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBHHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBHHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblBHHoaDon);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(rdCho)
                .addGap(56, 56, 56)
                .addComponent(rdChuaThanhToan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rdCho)
                    .addComponent(rdChuaThanhToan))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("GIỎ HÀNG");

        tblBHGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên sách", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tblBHGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBHGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBHGioHang);

        btnXoaGioHang.setText("Bỏ sách");
        btnXoaGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGioHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnXoaGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("SÁCH");

        jLabel15.setText("Lọc theo");

        cbDanhMucSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDanhMucSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDanhMucSearchItemStateChanged(evt);
            }
        });

        cbChiTetDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbChiTetDanhMuc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbChiTetDanhMucItemStateChanged(evt);
            }
        });

        btnTimTenSach.setText("Tìm kiếm");
        btnTimTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimTenSachActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(cbDanhMucSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbChiTetDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimTenSach)
                .addGap(23, 23, 23))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane5)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimTenSach)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cbDanhMucSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbChiTetDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("HOÁ ĐƠN");

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setText("Mã khách hàng");

        jLabel13.setText("Tên khách hàng");

        txtTenKhachHang.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTenKhachHangCaretUpdate(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiemTichLuy))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemKH)
                    .addComponent(btnChonKH)
                    .addComponent(rdDiem))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(btnThemKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDiemTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdDiem))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel4.setText("Mã hoá đơn");

        txtMaHoaDon.setEditable(false);

        btnTaoHD.setText("Tạo HĐ");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        jLabel9.setText("Tổng tiền");

        txtTongTien.setEditable(false);

        jLabel16.setText("Tiền giảm");

        txtTienGiam.setEditable(false);

        jLabel14.setText("Tiền sau khi giảm");

        txtTienSauKhiGiam.setEditable(false);

        jLabel10.setText("Tiền khách đưa");

        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });

        jLabel11.setText("Tiền thừa");

        txtTienThua.setEditable(false);

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnClearGioHang1.setText("Huỷ hoá đơn");
        btnClearGioHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearGioHang1ActionPerformed(evt);
            }
        });

        btnHoaDonCho.setText("Hoa don cho");
        btnHoaDonCho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonChoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTaoHD)
                                .addGap(29, 29, 29))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel16))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel10))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnThanhToan))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(txtTienKhachDua)
                            .addComponent(txtTienSauKhiGiam))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnClearGioHang1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHoaDonCho)
                .addGap(33, 33, 33))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoHD))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTienSauKhiGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHoaDonCho)
                    .addComponent(btnClearGioHang1))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Ban hang", jPanel1);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Thông tin trả hàng");

        btnTimHoaDon.setText("Tìm kiếm");
        btnTimHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimHoaDonActionPerformed(evt);
            }
        });

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
        jScrollPane6.setViewportView(tblTHHoaDon);

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
        jScrollPane7.setViewportView(tblTHHoaDonChiTiet);

        lblMaPTH.setText("Mã PTH");

        txtMaPTH.setEditable(false);

        lblmaHD.setText("Mã HĐ");

        maKH.setText("Tên khách hàng");

        txtTenKhachHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhachHang1ActionPerformed(evt);
            }
        });

        lblMaSach.setText("Tên sách");

        lblSoLuong.setText("Số lượng");

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

        txtNgayTao1.setEditable(false);

        lblLyDoTra1.setText("Lý do Trả");

        lblSoTienTraLai.setText("Số tiền trả lại");

        txtSoTienTraLai.setEditable(false);

        tblTraHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PTH", "Mã HĐ", "Mã KH", "Mã NV", "Tổng tiền", "Ngày tạo", "Ngày trả", "Số tiền trả lại", "Lý do trả"
            }
        ));
        jScrollPane9.setViewportView(tblTraHang);

        btnDoiHang.setText("Đổi hàng");
        btnDoiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSoLuong)
                                            .addComponent(lblLyDoTra1))
                                        .addGap(29, 29, 29))
                                    .addComponent(lblMaPTH, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(txtLyDo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaPTH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(maKH)
                                .addGap(43, 43, 43)
                                .addComponent(txtTenKhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(193, 193, 193)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSoTienTraLai)
                            .addComponent(lblNgayTao)
                            .addComponent(lblMaSach)
                            .addComponent(lblmaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoTienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgayTao1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(btnDoiHang)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(jLabel17)
                        .addGap(0, 422, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTimHoaDon)
                .addGap(87, 87, 87))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimHoaDon))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaPTH)
                    .addComponent(lblmaHD)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maKH)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMaSach)
                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenKhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoLuong)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNgayTao)
                    .addComponent(txtNgayTao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLyDoTra1)
                    .addComponent(txtLyDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSoTienTraLai)
                    .addComponent(txtSoTienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Doi tra", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        this.dispose();
        new MainAppNhanVien().setVisible(true);
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnQLSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLSachActionPerformed
        JOptionPane.showMessageDialog(this, "Ban khong co quyen truy cap vao quan ly sach");
    }//GEN-LAST:event_btnQLSachActionPerformed

    private void btnQLHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLHoaDonActionPerformed
        JOptionPane.showMessageDialog(this, "Ban khong co quyen truy cap vao quan ly hoa don");
    }//GEN-LAST:event_btnQLHoaDonActionPerformed

    private void btnQLNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNhanVienActionPerformed
        JOptionPane.showMessageDialog(this, "Ban khong co quyen truy cap vao quan ly nhan vien");
    }//GEN-LAST:event_btnQLNhanVienActionPerformed

    private void btnQLKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLKhachHangActionPerformed
        JOptionPane.showMessageDialog(this, "Ban khong co quyen truy cap vao quan ly khach hang");
    }//GEN-LAST:event_btnQLKhachHangActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        JOptionPane.showMessageDialog(this, "Ban khong co quyen truy cap vao quan ly thong ke");
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Ban co muon dang xuat khong ?");
        if (choice == JOptionPane.OK_OPTION) {
            this.dispose();
            new LoginView().setVisible(true);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void rdChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdChoActionPerformed
        DefaultTableModel tblhdchuathanhtoan = (DefaultTableModel) tblBHHoaDon.getModel();
        tblhdchuathanhtoan.setRowCount(0);
        List<HoaDonVM> listhdcho = serviceBHHoaDon.loaddangcho();
        for (HoaDonVM hd : listhdcho) {
            tblhdchuathanhtoan.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaKhachHang(), hd.getMaNhanVien(), hd.getNgayTao(), hd.getTrangThai() == 1 ? "Chưa thanh toán" : "Đang chờ "});
        }

    }//GEN-LAST:event_rdChoActionPerformed

    private void rdChuaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdChuaThanhToanActionPerformed
        DefaultTableModel tblhdchuathanhtoan = (DefaultTableModel) tblBHHoaDon.getModel();
        tblhdchuathanhtoan.setRowCount(0);
        List<HoaDonVM> listhdcho = serviceBHHoaDon.loadchuathanhtoan();
        for (HoaDonVM hd : listhdcho) {
            tblhdchuathanhtoan.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaKhachHang(), hd.getMaNhanVien(), hd.getNgayTao(), hd.getTrangThai() == 1 ? "Chưa thanh toán" : "Đang chờ "});
        }
    }//GEN-LAST:event_rdChuaThanhToanActionPerformed

    private void tblBHHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBHHoaDonMouseClicked
        int tem = tblBHHoaDon.getSelectedRow();
        if (tem < 0) {
            return;
        } else {
            if (tblBHHoaDon.getValueAt(tem, 4).toString().equals("Đang chờ")) {
                listGioHang.removeAll(listGioHang);
                loadTableGioHang(listGioHang);
                txtMaHoaDon.setText(tblBHHoaDon.getValueAt(tem, 0).toString());
                return;
            } else {
                String maHoaDon = tblBHHoaDon.getValueAt(tem, 0).toString();
                listGioHang = serviceBHHoaDon.getSach(maHoaDon);
                loadTableGioHang(listGioHang);
                txtMaHoaDon.setText(maHoaDon);
                txtTenKhachHang.setText(tblBHHoaDon.getValueAt(tem, 1).toString());
                float tienHang = 0;
                for (GioHangVM x : listGioHang) {
                    tienHang = tienHang + x.getThanhTien();
                }
                txtTongTien.setText(String.valueOf(tienHang));
            }
        }
    }//GEN-LAST:event_tblBHHoaDonMouseClicked

    private void tblBHGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBHGioHangMouseClicked

    }//GEN-LAST:event_tblBHGioHangMouseClicked

    private void btnXoaGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGioHangActionPerformed
        int temp = tblBHGioHang.getSelectedRow();
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
    }//GEN-LAST:event_btnXoaGioHangActionPerformed

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

    private void cbChiTetDanhMucItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbChiTetDanhMucItemStateChanged
        String text = (String) cbChiTetDanhMuc.getSelectedItem();
        listSachBH = serviceSach1.getlist();
        ArrayList<SachVM> listLoc = serviceSach.listLoc(listSachBH, text);
        loadTableSach(listLoc);
    }//GEN-LAST:event_cbChiTetDanhMucItemStateChanged

    private void btnTimTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimTenSachActionPerformed
        String text = txtTimKiem.getText();
        String regex = "^[a-zA-Z]*$";
        if (!text.matches(regex)) {
            JOptionPane.showMessageDialog(this, "Ten sach phai la cac chu cai");
        } else {
            ArrayList<SachVM> listTimKiem = serviceSach.listSearch(text);
            loadTableSach(listTimKiem);
        }
    }//GEN-LAST:event_btnTimTenSachActionPerformed

    private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked
        int row = tblSach.getSelectedRow();
        String regex = "^[0-9]*$";
        Integer soSachGioHang = 0;
        Integer viTri = 0;
        String soLuong = JOptionPane.showInputDialog(this, "Nhập số lượng");
        if (!soLuong.matches(regex)) {
            JOptionPane.showMessageDialog(this, "So luong phai la so");
            return;
        }
        if (Integer.valueOf(soLuong) < 0) {
            JOptionPane.showMessageDialog(this, "So luong phai lon hon 0");
            return;
        }
        if (Integer.valueOf(soLuong) > Integer.valueOf(tblSach.getValueAt(row, 2).toString())) {
            JOptionPane.showMessageDialog(this, "So luong phai nho hon so sach hien co");
            return;
        }
        if (Integer.valueOf(soLuong) > 50) {
            JOptionPane.showMessageDialog(this, "So luong mua qua nhieu, vui long thu lai");
            return;
        }
        if (Integer.valueOf(soLuong) == JOptionPane.CANCEL_OPTION) {
            return;
        } else {
            Integer slSachCon;
            slSachCon = (Integer) tblSach.getValueAt(row, 2) - Integer.valueOf(soLuong);
            String tenSach = tblSach.getValueAt(row, 1).toString();
            serviceSach.capNhatSoSach(slSachCon, tenSach);
            listSach = serviceSach.listSach();
            loadTableSach(listSach);
//            for (GioHangVM z : listGioHang) {
//                if (tenSach.equalsIgnoreCase(z.getTenSach())) {
//                    soSachGioHang = z.getSoLuong();
//                    z.setSoLuong(Integer.valueOf(soLuong) + soSachGioHang);
//                    loadTableGioHang(listGioHang);
//                    for (GioHangVM s : listGioHang) {
//                        tongtienGH = tongtienGH + s.getThanhTien();
//                    }
//                    txtTongTien.setText(String.valueOf(tongtienGH));
//                }
//            }
            GioHangVM x = new GioHangVM();
            x.setTenSach(tblSach.getValueAt(row, 1).toString());
            x.setSoLuong(Integer.valueOf(soLuong));
            x.setDonGia((Float) tblSach.getValueAt(row, 3));
            x.setMaSach(Integer.valueOf(tblSach.getValueAt(row, 0).toString()));
            listGioHang.add(x);
            loadTableGioHang(listGioHang);
            for (GioHangVM s : listGioHang) {
                tongtienGH = tongtienGH + s.getThanhTien();
            }
            txtTongTien.setText(String.valueOf(tongtienGH));
        }
    }//GEN-LAST:event_tblSachMouseClicked

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

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        for (int i = 0; i < listBHHoaDon.size(); i++) {
            if (listBHHoaDon.size() > 10) {
                JOptionPane.showMessageDialog(this, "Đat gioi hoa don cho, vui long thanh toan cac hoa don truoc do");
                return;
            }
        }
        HoaDonVM x = new HoaDonVM();
        x.setMaKhachHang(1);
        x.setNgayTao(new Date());
        x.setMaNhanVien(1);
        x.setTrangThai(0);
        JOptionPane.showMessageDialog(this, serviceBHHoaDon.taoHD(x));
        listBHHoaDon = serviceBHHoaDon.listHDVM();
        loadTableBanHangHoaDon(listBHHoaDon);
        listGioHang.removeAll(listGioHang);
        tongTienHD = 0;
        tongtienGH = 0;
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (txtTongTien.getText().isBlank() || txtTongTien.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Chua co hoa don, vui long tao moi");
            return;
        }
        if (txtTienKhachDua.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Chua nhap tien khach dua");
            return;
        }
        String regex = "^[0-9]*$";
        if (!txtTienKhachDua.getText().matches(regex)) {
            JOptionPane.showMessageDialog(this, "Tien phai la so");
            return;
        }

        if (checkDiem == -1) {
            float tongTienHD = Float.parseFloat(txtTienSauKhiGiam.getText());
            float tienKhachDua = Float.parseFloat(txtTienKhachDua.getText());
            if (tienKhachDua < tongTienHD) {
                JOptionPane.showMessageDialog(this, "Chưa du tien");
            } else {
                if (tongTienHD > 200000) {
                    diemSau = diemThua + 1;
                    float tienThua = tienKhachDua - tongTienHD;
                    txtTienThua.setText(String.valueOf(tienThua));
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
                        serviceBHHoaDonChiTiet.themHDCCT(x);
                    }
                    HoaDonVM x = new HoaDonVM(Integer.valueOf(txtMaHoaDon.getText()), Integer.valueOf(txtMaKhachHang.getText()), tongTienHD, 2);
                    JOptionPane.showMessageDialog(this, serviceBHHoaDon.capNhatHDThanhToan(x));
                    listGioHang.removeAll(listGioHang);
                    loadTableGioHang(listGioHang);
                    serviceKH.updateDiem(txtMaKhachHang.getText(), diemSau);
                    listBHHoaDon = serviceBHHoaDon.listHDVM();
                    loadTableBanHangHoaDon(listBHHoaDon);
                    HoaDonVM inHoaDon = serviceBHHoaDon.inHoaDon(txtMaHoaDon.getText());
                    int choice = JOptionPane.showConfirmDialog(this, "Ban co muon in hoa don khong?");
                    if (choice == JOptionPane.OK_OPTION) {
                        inHoaDon(inHoaDon);
                    }
                    clear();
                } else {
                    float tienThua = tienKhachDua - tongTienHD;
                    txtTienThua.setText(String.valueOf(tienThua));
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
                        serviceBHHoaDonChiTiet.themHDCCT(x);
                    }
                    HoaDonVM x = new HoaDonVM(Integer.valueOf(txtMaHoaDon.getText()), Integer.valueOf(txtMaKhachHang.getText()), tongTienHD, 2);
                    JOptionPane.showMessageDialog(this, serviceBHHoaDon.capNhatHDThanhToan(x));
                    listGioHang.removeAll(listGioHang);
                    loadTableGioHang(listGioHang);
                    listBHHoaDon = serviceBHHoaDon.listHDVM();
                    loadTableBanHangHoaDon(listBHHoaDon);
                    HoaDonVM inHoaDon = serviceBHHoaDon.inHoaDon(txtMaHoaDon.getText());
                    int choice = JOptionPane.showConfirmDialog(this, "Ban co muon in hoa don khong?");
                    if (choice == JOptionPane.OK_OPTION) {
                        inHoaDon(inHoaDon);
                    }
                    clear();
                }
            }
        } else if (!txtDiemTichLuy.getText().isBlank()) {
            float tongTienHD = Float.parseFloat(txtTongTien.getText());
            float tienKhachDua = Float.parseFloat(txtTienKhachDua.getText());
            if (tienKhachDua < tongTienHD) {
                JOptionPane.showMessageDialog(this, "Chưa du tien");
            } else {
                if (tongTienHD > 200000) {
                    diemSau = Integer.parseInt(txtDiemTichLuy.getText()) + 1;
                    float tienThua = tienKhachDua - tongTienHD;
                    txtTienThua.setText(String.valueOf(tienThua));
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
                        serviceBHHoaDonChiTiet.themHDCCT(x);
                    }
                    HoaDonVM x = new HoaDonVM(Integer.valueOf(txtMaHoaDon.getText()), Integer.valueOf(txtMaKhachHang.getText()), tongTienHD, 2);
                    JOptionPane.showMessageDialog(this, serviceBHHoaDon.capNhatHDThanhToan(x));
                    listGioHang.removeAll(listGioHang);
                    loadTableGioHang(listGioHang);
                    serviceKH.updateDiem(txtMaKhachHang.getText(), diemSau);
                    listBHHoaDon = serviceBHHoaDon.listHDVM();
                    loadTableBanHangHoaDon(listBHHoaDon);
                    HoaDonVM inHoaDon = serviceBHHoaDon.inHoaDon(txtMaHoaDon.getText());
                    int choice = JOptionPane.showConfirmDialog(this, "Ban co muon in hoa don khong?");
                    if (choice == JOptionPane.OK_OPTION) {
                        inHoaDon(inHoaDon);
                    }
                    clear();
                } else {
                    float tienThua = tienKhachDua - tongTienHD;
                    txtTienThua.setText(String.valueOf(tienThua));
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
                        serviceBHHoaDonChiTiet.themHDCCT(x);
                    }
                    HoaDonVM x = new HoaDonVM(Integer.valueOf(txtMaHoaDon.getText()), Integer.valueOf(txtMaKhachHang.getText()), tongTienHD, 2);
                    JOptionPane.showMessageDialog(this, serviceBHHoaDon.capNhatHDThanhToan(x));
                    listGioHang.removeAll(listGioHang);
                    loadTableGioHang(listGioHang);
                    listBHHoaDon = serviceBHHoaDon.listHDVM();
                    loadTableBanHangHoaDon(listBHHoaDon);
                    HoaDonVM inHoaDon = serviceBHHoaDon.inHoaDon(txtMaHoaDon.getText());
                    int choice = JOptionPane.showConfirmDialog(this, "Ban co muon in hoa don khong?");
                    if (choice == JOptionPane.OK_OPTION) {
                        inHoaDon(inHoaDon);
                    }
                    clear();
                }
            }
        } else {
            thanhToanKhachLe();
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnClearGioHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearGioHang1ActionPerformed
        Integer soSachBD = 0;
        Integer soSachCapNhat = 0;
        if (txtMaHoaDon.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui long chon hoa don can huy");
        } else {
            int choie = JOptionPane.showConfirmDialog(this, "Ban co muon huy hoa don khong?");
            if (choie == JOptionPane.OK_OPTION) {
                for (int i = 0; i < tblBHGioHang.getRowCount(); i++) {
                    String tenSach = tblBHGioHang.getValueAt(i, 0).toString();
                    Integer soLuong = (Integer) tblBHGioHang.getValueAt(i, 1);
                    for (SachVM x : listSach) {
                        if (x.getTenSach().equalsIgnoreCase(tenSach)) {
                            soSachBD = x.getSoLuong();
                        }
                    }
                    soSachCapNhat = soSachBD + soLuong;
                    serviceSach1.capNhatTheoTen(tenSach, soSachCapNhat);
                    soSachBD = 0;
                    soSachCapNhat = 0;
                }
                HoaDonVM x = new HoaDonVM();
                x.setTrangThai(3);
                x.setMaHoaDon(Integer.parseInt(txtMaHoaDon.getText()));
                JOptionPane.showMessageDialog(this, serviceBHHoaDon.capNhatHDThanhToan(x));
                listSach = serviceSach.listSach();
                loadTableSach(listSach);
                clear();
            } else {
                return;
            }
        }
    }//GEN-LAST:event_btnClearGioHang1ActionPerformed

    private void btnHoaDonChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonChoActionPerformed
        if (txtMaHoaDon.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui long chon hoa don");
        } else if (Float.valueOf(txtTongTien.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Chua co san pham");
        } else {
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
                serviceBHHoaDonChiTiet.themHDCCT(x);
            }
            HoaDonVM x = new HoaDonVM();
            x.setTongTien(Float.parseFloat(txtTongTien.getText()));
            x.setMaHoaDon(Integer.parseInt(txtMaHoaDon.getText()));
            x.setTrangThai(1);
            serviceBHHoaDon.capNhatHDCho(x);
            listBHHoaDon = serviceBHHoaDon.listHDVM();
            loadTableBanHangHoaDon(listBHHoaDon);
            listGioHang.removeAll(listGioHang);
            loadTableGioHang(listGioHang);
            clear();
        }
    }//GEN-LAST:event_btnHoaDonChoActionPerformed

    private void txtTenKhachHangCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTenKhachHangCaretUpdate
        listKH = serviceKH.getAll();
        for (QLKhachHang n : listKH) {
            if (n.getTenKH().equalsIgnoreCase(txtTenKhachHang.getText())) {
                txtMaKhachHang.setText(String.valueOf(n.getMaKH()));
                txtDiemTichLuy.setText(String.valueOf(n.getDiemTichLuy()));
            }
        }
    }//GEN-LAST:event_txtTenKhachHangCaretUpdate

    private void btnTimHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimHoaDonActionPerformed
        String ten = txtTimKiem.getText();
        List<KhachHang> lst = new ArrayList<>();
        lst = serviceKH.timKiem(ten);
        Integer maKhachHang = 0;
        for (KhachHang kH : lst) {
            if (kH.getTenKH().equals(ten)) {
                maKhachHang = kH.getMaKH();

            }
        }
        List<HoaDonVM> lstVM = serviceBHHoaDon.timKiemTen(ten);
        loadtableTHHoaDon(lstVM);
    }//GEN-LAST:event_btnTimHoaDonActionPerformed

    private void tblTHHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTHHoaDonMouseClicked
        int row = tblTHHoaDon.getSelectedRow();
        String ma = tblTHHoaDon.getValueAt(row, 0).toString();
        Integer maHoaDon = Integer.valueOf(ma);
        modelTHCDCT = (DefaultTableModel) tblTHHoaDonChiTiet.getModel();
        modelTHCDCT.setRowCount(0);
        ArrayList<HoaDonCTVM> list = serviceBHHoaDonChiTiet.getlist(maHoaDon);
        loadTableTHHDCT(list);
        txtMaHD.setText(ma);
        txtTenKhachHang1.setText(tblTHHoaDon.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblTHHoaDonMouseClicked

    private void tblTHHoaDonChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTHHoaDonChiTietMouseClicked
        int row = tblTHHoaDonChiTiet.getSelectedRow();
        txtMaSach.setText(tblTHHoaDonChiTiet.getValueAt(row, 2).toString());
        donGia = Float.parseFloat(tblTHHoaDonChiTiet.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblTHHoaDonChiTietMouseClicked

    private void txtTenKhachHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhachHang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhachHang1ActionPerformed

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

    private void txtSoLuongInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSoLuongInputMethodTextChanged

    }//GEN-LAST:event_txtSoLuongInputMethodTextChanged

    private void btnDoiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiHangActionPerformed

        if (txtMaHD.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống ma hoa don");
            txtMaHD.requestFocus();
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
        for (SachViewmodel c : listSachTH) {
            if (txtMaSach.getText().equals(c.getTensach())) {
                maSach = c.getMasach();
            }
        }
        z.setMaSach(maSach);
        z.setDonGia(donGia);
        z.setMaPhieuTraHang(maPHT);
        serviceTraHangCT.themTraHang(z);
        clearForm();
    }//GEN-LAST:event_btnDoiHangActionPerformed

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        if (txtTienKhachDua.getText().isBlank()) {
            return;
        } else {
            if (txtTienGiam.getText().isBlank() || txtTienSauKhiGiam.getText().isBlank()) {
                Float tongTien = Float.parseFloat(txtTongTien.getText());
                Float tienKhachDua = Float.parseFloat(txtTienKhachDua.getText());
                txtTienThua.setText(String.valueOf(tienKhachDua - tongTien));
            } else {
                Float tongTien = Float.parseFloat(txtTienSauKhiGiam.getText());
                Float tienKhachDua = Float.parseFloat(txtTienKhachDua.getText());
                txtTienThua.setText(String.valueOf(tienKhachDua - tongTien));
            }
        }
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

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
            java.util.logging.Logger.getLogger(BanHangDoiTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHangDoiTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHangDoiTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHangDoiTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHangDoiTra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton btnChonKH;
    private javax.swing.JButton btnClearGioHang1;
    private javax.swing.JButton btnDoiHang;
    private javax.swing.JButton btnHoaDonCho;
    private javax.swing.JButton btnQLHoaDon;
    private javax.swing.JButton btnQLKhachHang;
    private javax.swing.JButton btnQLNhanVien;
    private javax.swing.JButton btnQLSach;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTimHoaDon;
    private javax.swing.JButton btnTimTenSach;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnXoaGioHang;
    private javax.swing.JComboBox<String> cbChiTetDanhMuc;
    private javax.swing.JComboBox<String> cbDanhMucSearch;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblLyDoTra;
    private javax.swing.JLabel lblLyDoTra1;
    private javax.swing.JLabel lblMaPTH;
    private javax.swing.JLabel lblMaSach;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblSoTienTraLai;
    private javax.swing.JLabel lblmaHD;
    private javax.swing.JLabel maKH;
    private javax.swing.JRadioButton rdCho;
    private javax.swing.JRadioButton rdChuaThanhToan;
    private javax.swing.JRadioButton rdDiem;
    private javax.swing.JTable tblBHGioHang;
    private javax.swing.JTable tblBHHoaDon;
    private javax.swing.JTable tblSach;
    private javax.swing.JTable tblTHHoaDon;
    private javax.swing.JTable tblTHHoaDonChiTiet;
    private javax.swing.JTable tblTraHang;
    private javax.swing.JTextField txtDiemTichLuy;
    private javax.swing.JTextField txtLyDo;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaPTH;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNgayTao1;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoTienTraLai;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenKhachHang1;
    private javax.swing.JTextField txtTienGiam;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienSauKhiGiam;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem1;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
