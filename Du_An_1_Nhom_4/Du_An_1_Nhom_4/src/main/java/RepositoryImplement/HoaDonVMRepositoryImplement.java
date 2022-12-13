package RepositoryImplement;

import RepositoryInterface.HoaDomVMRepositoryInterface;
import Utilities.DBConection;
import ViewModel.GioHangVM;
import ViewModel.HoaDonCTVM;
import ViewModel.HoaDonVM;
import ViewModel.SachVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xuan Truong
 */
public class HoaDonVMRepositoryImplement implements HoaDomVMRepositoryInterface {

    private List<GioHangVM> listGH;
    private List<HoaDonVM> listchuathanhtoan;
    private List<HoaDonVM> listdangcho;
    private List<HoaDonVM> listDT;
    private List<HoaDonVM> timkiem;

    private List<HoaDonVM> listHDThongke;
    private List<HoaDonVM> tongDT;

    @Override
    public Boolean taoHoaDon(HoaDonVM x) {
        String query = "INSERT INTO [dbo].[HOADON]([MaNV],[NgayTao],[TrangThai])\n"
                + "VALUES(?,?,?)";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x.getMaNhanVien());
            ps.setObject(2, x.getNgayTao());
            ps.setObject(3, x.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
        return check > 0;
    }

    @Override
    public ArrayList<HoaDonVM> listHDVM() {
        String query = "SELECT [MaHD],[MaKH],[MaNV],[NgayTao],[TrangThai]\n"
                + "FROM [dbo].[HOADON] WHERE TrangThai = 0 or TrangThai = 1";
        ArrayList<HoaDonVM> listHDVM = new ArrayList<>();
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listHDVM.add(new HoaDonVM(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listHDVM;
    }

    @Override
    public Boolean capNhatHoaDonThanhToan(HoaDonVM x) {
        String query = "UPDATE [dbo].[HOADON]SET [MaKH] = ? ,[TongTien] = ? ,[TrangThai] = ? WHERE [MaHD] = ?";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, x.getMaKhachHang());
            ps.setObject(2, x.getTongTien());
            ps.setObject(3, x.getTrangThai());
            ps.setObject(4, x.getMaHoaDon());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
        return check > 0;
    }

    @Override
    public ArrayList<GioHangVM> getSach(String maHD) {
        ArrayList<GioHangVM> listGH = new ArrayList<>();
        String query = "SELECT SACH.TenSach, HOADONCT.SoLuong, HOADONCT.DonGia\n"
                + "FROM HOADONCT INNER JOIN SACH ON HOADONCT.MaSACH = SACH.MaSach\n"
                + "WHERE [MaHD] = ?";
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listGH.add(new GioHangVM(rs.getString(1), rs.getInt(2), rs.getFloat(3)));
            }
        } catch (Exception e) {
        }
        return listGH;
    }

    @Override
    public List<HoaDonVM> loadchuathanhtoan() {
        listchuathanhtoan = new ArrayList<>();
        String sql = "select MaHD, MaKH, MaNV, NgayTao, TrangThai  from  HOADON where TrangThai = 1";
        ResultSet rs = DBConection.excutequery(sql);
        try {
            while (rs.next()) {
                listchuathanhtoan.add(new HoaDonVM(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listchuathanhtoan;
    }

    @Override
    public List<HoaDonVM> loaddangcho() {
        listdangcho = new ArrayList<>();
        String sql = "select MaHD, MaKH, MaNV, NgayTao, TrangThai  from  HOADON where TrangThai = 0";
        ResultSet rs = DBConection.excutequery(sql);
        try {
            while (rs.next()) {
                listdangcho.add(new HoaDonVM(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listdangcho;
    }

    @Override
    public ArrayList<HoaDonVM> listloc(Date ngayBatDau, Date ngayKetThuc) {
        String query = "SELECT [MaHD]\n"
                + "      ,[MaKH]\n"
                + "      ,[MaNV]\n"
                + "      ,[NgayTao]\n"
                + "      ,[TongTien]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[HOADON]\n"
                + "  WHERE [NgayTao] between ? and ?";
        ArrayList<HoaDonVM> listHDVM = new ArrayList<>();
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ngayBatDau);
            ps.setObject(2, ngayKetThuc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listHDVM.add(new HoaDonVM(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getInt(5), rs.getInt(6)));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listHDVM;
    }

    @Override
    public ArrayList<HoaDonVM> listHD() {
        String query = "SELECT    HOADON.MaHD, KHACHHANG.TenKH, NHANVIEN.TenNV, HOADON.NgayTao, HOADON.TongTien, HOADON.TrangThai\n"
                + "                FROM         HOADON INNER JOIN\n"
                + "                                     KHACHHANG ON HOADON.MaKH = KHACHHANG.MaKH INNER JOIN\n"
                + "                                      NHANVIEN ON HOADON.MaNV = NHANVIEN.MaNV";
        ArrayList<HoaDonVM> listHDVM = new ArrayList<>();
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                listHDVM.add(new HoaDonVM(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getFloat(5), rs.getInt(6)));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listHDVM;
    }

    @Override
    public ArrayList<HoaDonVM> listHDTH() {
        String query = "SELECT    HOADON.MaHD, KHACHHANG.TenKH, NHANVIEN.TenNV, HOADON.NgayTao, HOADON.TongTien, HOADON.TrangThai\n"
                + "                FROM         HOADON INNER JOIN\n"
                + "                                     KHACHHANG ON HOADON.MaKH = KHACHHANG.MaKH INNER JOIN\n"
                + "                                      NHANVIEN ON HOADON.MaNV = NHANVIEN.MaNV WHERE TrangThai = 2";
        ArrayList<HoaDonVM> listHDVM = new ArrayList<>();
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listHDVM.add(new HoaDonVM(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getFloat(5), rs.getInt(6)));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listHDVM;
    }

    @Override
    public List<HoaDonVM> listDT() {
        listDT = new ArrayList<>();
        String sql = "select NgayTao as 'Nam',SUM(TongTien) as 'doanh thu ' from HOADON \n"
                + "group by NgayTao\n"
                + "order by SUM( TongTien) desc";
        ResultSet rs = DBConection.excutequery(sql);
        try {
            while (rs.next()) {
                listDT.add(new HoaDonVM(rs.getDate(1), rs.getFloat(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDT;
    }

    @Override
    public List<HoaDonVM> TimKiemDTTheoNgay(String date) {
        timkiem = new ArrayList<>();
        String sql = "select NgayTao as 'thoi gian ',SUM(TongTien) as 'doanh thu ' from HOADON where NgayTao = ?\n"
                + "group by NgayTao\n"
                + "order by SUM( TongTien) desc";
        ResultSet rs = DBConection.excutequery(sql, date);
        try {
            while (rs.next()) {
                timkiem.add(new HoaDonVM(rs.getDate(1), rs.getFloat(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return timkiem;
    }

    @Override
    public List<HoaDonVM> TongDT() {
        tongDT = new ArrayList<>();
        String sql = "select SUM(TongTien) as 'doanh thu ' from HOADON\n"
                + "order by SUM( TongTien) desc";
        ResultSet rs = DBConection.excutequery(sql);
        try {
            while (rs.next()) {
                tongDT.add(new HoaDonVM(rs.getFloat(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tongDT;
    }

    @Override
    public List<HoaDonVM> tongHDthongke() {
        listHDThongke = new ArrayList<>();
        String sql = "select count(MaHD) from HOADON";
        ResultSet rs = DBConection.excutequery(sql);
        try {
            while (rs.next()) {
                listHDThongke.add(new HoaDonVM(rs.getInt(1)));
                System.out.println(listHDThongke);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHDThongke;
    }

    @Override
    public HoaDonVM inHoaDon(String maHoaDon) {
        String query = "SELECT HOADON.MaHD, KHACHHANG.TenKH, HOADON.MaNV, HOADON.NgayTao, HOADON.[TongTien]\n"
                + "FROM HOADON INNER JOIN KHACHHANG ON HOADON.MaKH = KHACHHANG.MaKH"
                + "WHERE MaHD = ?";
        HoaDonVM x = new HoaDonVM();
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, maHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                x.setMaHoaDon(rs.getInt(1));
                x.setTenKhachHang(rs.getString(2));
                x.setMaNhanVien(rs.getInt(3));
                x.setNgayTao(rs.getDate(4));
                x.setTongTien(rs.getFloat(5));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return x;
    }

    @Override
    public List<HoaDonVM> timKiemTheoTen(String ten) {
        List<HoaDonVM> lstVM = new ArrayList<>();
        String sql = "SELECT    HOADON.MaHD, KHACHHANG.TenKH, NHANVIEN.TenNV, HOADON.NgayTao, HOADON.TongTien, HOADON.TrangThai\n"
                + "FROM         HOADON INNER JOIN\n"
                + "                      KHACHHANG ON HOADON.MaKH = KHACHHANG.MaKH INNER JOIN\n"
                + "                      NHANVIEN ON HOADON.MaNV = NHANVIEN.MaNV\n"
                + "					  where TenKH = ? ";
        ResultSet rs = DBConection.excutequery(sql, ten);
        try {
            while (rs.next()) {
                lstVM.add(new HoaDonVM(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getFloat(5), rs.getInt(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstVM;
    }

    @Override
    public Boolean capNhatHoaDonCho(HoaDonVM x) {
        String query = "UPDATE [dbo].[HOADON]SET [TongTien] = ? ,[TrangThai] = ? WHERE [MaHD] = ?";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, x.getTongTien());
            ps.setObject(2, x.getTrangThai());
            ps.setObject(3, x.getMaHoaDon());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
        return check > 0;
    }

}
