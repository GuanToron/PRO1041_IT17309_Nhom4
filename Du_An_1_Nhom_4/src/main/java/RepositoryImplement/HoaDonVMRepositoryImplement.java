package RepositoryImplement;

import RepositoryInterface.HoaDomVMRepositoryInterface;
import ServiceImplement.HoaDonVMServiceImplement;
import Utilities.DBConection;
import ViewModel.HoaDonVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Xuan Truong
 */
public class HoaDonVMRepositoryImplement implements HoaDomVMRepositoryInterface {

     private List<HoaDonVM> listthanhtoan;
     private List<HoaDonVM> listchuathanhtoan;
    @Override
    public Boolean taoHoaDon(HoaDonVM x) {
        String query = "INSERT INTO [dbo].[HOADON]([MaKH],[MaNV],[NgayTao],[TrangThai])VALUES(?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x.getMaKhachHang());
            ps.setObject(2, x.getMaNhanVien());
            ps.setObject(3, x.getNgayTao());
            ps.setObject(4, x.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
        return check > 0;
    }

    @Override
    public ArrayList<HoaDonVM> listHDVM() {
        String query = "SELECT [MaHD],[MaKH],[MaNV],[NgayTao],[TrangThai] FROM [dbo].[HOADON]";
        ArrayList<HoaDonVM>listHDVM = new ArrayList<>();
        try( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                listHDVM.add(new HoaDonVM(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4),rs.getInt(5)));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listHDVM;
    }

    @Override
    public Boolean capNhatHoaDon(HoaDonVM x) {
                String query = "UPDATE [dbo].[HOADON] SET [TongTien] = ?,[TrangThai] = ? WHERE [MaHD] = ?";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
//            ps.setObject(1, x.g());
//            ps.setObject(2, x.getMaNhanVien());
//            ps.setObject(3, x.getNgayTao());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
        return check > 0;
    }

    @Override
    public List<HoaDonVM> loadDaThanhToan() {
       listthanhtoan = new ArrayList<>();
      String sql = "select MaHD, MaKH, MaNV, NgayTao, TrangThai   from HOADON where TrangThai = 1";
      ResultSet rs = DBConection.excutequery(sql);
        try {
            while(rs.next()){
                listthanhtoan.add(new HoaDonVM(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getInt(5)));
            } } catch (SQLException ex) {
            Logger.getLogger(HoaDonVMServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listthanhtoan;
    }

    @Override
    public List<HoaDonVM> loadChuaThanhToan() {
        listchuathanhtoan = new ArrayList<>();
      String sql = "select MaHD, MaKH, MaNV, NgayTao, TrangThai   from HOADON where TrangThai = 0";
      ResultSet rs = DBConection.excutequery(sql);
        try {
            while(rs.next()){
                listchuathanhtoan.add(new HoaDonVM(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getInt(5)));
            } } catch (SQLException ex) {
            Logger.getLogger(HoaDonVMServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listchuathanhtoan;
    }

}
