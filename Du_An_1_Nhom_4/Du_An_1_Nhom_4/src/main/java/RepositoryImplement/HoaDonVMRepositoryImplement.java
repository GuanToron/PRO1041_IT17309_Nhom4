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
                + "FROM [dbo].[HOADON]\n"
                + "WHERE TrangThai = 1 or TrangThai = 0";
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
    public Boolean capNhatHoaDon(HoaDonVM x) {
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
        String query = "SELECT [MaHD],[MaKH],[MaNV],[NgayTao],[TongTien],[TrangThai]\n"
                + "FROM [dbo].[HOADON]";
        ArrayList<HoaDonVM> listHDVM = new ArrayList<>();
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listHDVM.add(new HoaDonVM(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getFloat(5), rs.getInt(6)));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listHDVM;
    }

    @Override
    public ArrayList<HoaDonVM> listHDTH() {
        String query = "SELECT [MaHD],[MaKH],[MaNV],[NgayTao],[TongTien],[TrangThai]\n"
                + "FROM [dbo].[HOADON]\n"
                + "WHERE TrangThai = 2";
        ArrayList<HoaDonVM> listHDVM = new ArrayList<>();
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listHDVM.add(new HoaDonVM(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getFloat(5), rs.getInt(6)));
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
                tongDT.add(new HoaDonVM( rs.getFloat(1)));
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
                listHDThongke.add(new HoaDonVM( rs.getInt(1)));
                System.out.println(listHDThongke);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHDThongke;
    }

}
