package RepositoryImplement;

import RepositoryInterface.SachVMRepositoryInterface;
import Utilities.DBConection;
import ViewModel.SachVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xuan Truong
 */
public class SachVMRepositoryImplement implements SachVMRepositoryInterface {

    private List<SachVM> listDTCaoNhat;
    private List<SachVM> listDTThapNhat;
    private List<SachVM> listSLCaoNhat;
    private List<SachVM> listSLThapNhat;
    private List<SachVM> listSachByNPH;
    private List<SachVM> listSPbanChay;
    private List<SachVM> search;

    @Override
    public ArrayList<SachVM> listSach() {
        ArrayList<SachVM> listSach = new ArrayList<>();
        String query = "SELECT MaSach,TenSach,SoLuong,GiaBan FROM SACH";
        ResultSet rs = DBConection.excutequery(query);
        try {
            while (rs.next()) {
                listSach.add(new SachVM(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSach;
    }

    @Override
    public Void capNhatSLSach(Integer soLuong, String tenSach) {
        String query = "UPDATE [dbo].[SACH] SET [SoLuong] = ? WHERE TenSach = ?";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, soLuong);
            ps.setObject(2, tenSach);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<SachVM> listTimKiem(String tenSach) {
        ArrayList<SachVM> listSach = new ArrayList<>();
        String query = "SELECT MaSach,TenSach,SoLuong,GiaBan FROM SACH WHERE TenSach = ?";
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tenSach);
            ResultSet rs = DBConection.excutequery(query);
            while (rs.next()) {
                listSach.add(new SachVM(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSach;
    }

    @Override
    public List<SachVM> listTopDTCaoNhat() {
        listDTCaoNhat = new ArrayList<>();
        String sql = "select HOADONCT.MaHD, SACH.MaSach,TenSach, NamXuatBan, NgonNgu, NhomTuoi, TaiBan, SoTrang, GiaBan, SACH.SoLuong, TrangThai, HOADONCT.SoLuong as 'soluongdaban',  DonGia as 'doanh thu'\n"
                + "from SACH join HOADONCT on HOADONCT.MaSACH = Sach.MaSach \n"
                + "order by  HOADONCT.DonGia desc";
        ResultSet rs = DBConection.excutequery(sql);
        try {
            while (rs.next()) {
                listDTCaoNhat.add(new SachVM(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(10), rs.getFloat(9), rs.getInt(11), rs.getInt(12), rs.getDouble(13)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDTCaoNhat;
    }

    @Override
    public List<SachVM> listTopDTThapNhat() {
        listDTThapNhat = new ArrayList<>();
        String sql = "select HOADONCT.MaHD, SACH.MaSach,TenSach, NamXuatBan, NgonNgu, NhomTuoi, TaiBan, SoTrang, GiaBan, SACH.SoLuong, TrangThai, HOADONCT.SoLuong as 'soluongdaban',  DonGia as 'doanh thu'\n"
                + "from SACH join HOADONCT on HOADONCT.MaSACH = Sach.MaSach \n"
                + "order by  HOADONCT.DonGia asc";
        ResultSet rs = DBConection.excutequery(sql);
        try {
            while (rs.next()) {
                listDTThapNhat.add(new SachVM(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(10), rs.getFloat(9), rs.getInt(11), rs.getInt(12), rs.getDouble(13)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDTThapNhat;
    }

    @Override
    public List<SachVM> listTopSLCaoNhat() {
        listSLCaoNhat = new ArrayList<>();
        String sql = "select HOADONCT.MaHD, SACH.MaSach,TenSach, NamXuatBan, NgonNgu, NhomTuoi, TaiBan, SoTrang, GiaBan, SACH.SoLuong, TrangThai, HOADONCT.SoLuong as 'soluongdaban', DonGia\n"
                + "from SACH join HOADONCT on HOADONCT.MaSACH = Sach.MaSach\n"
                + "order by  HOADONCT.SoLuong desc";
        ResultSet rs = DBConection.excutequery(sql);
        try {
            while (rs.next()) {
                listSLCaoNhat.add(new SachVM(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(10), rs.getFloat(9), rs.getInt(11), rs.getInt(12), rs.getDouble(13)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSLCaoNhat;
    }

    @Override
    public List<SachVM> listTopSLThapNhat() {
        listSLThapNhat = new ArrayList<>();
        String sql = "select HOADONCT.MaHD, SACH.MaSach,TenSach, NamXuatBan, NgonNgu, NhomTuoi, TaiBan, SoTrang, GiaBan, SACH.SoLuong, TrangThai, HOADONCT.SoLuong as 'soluongdaban', DonGia\n"
                + "from SACH join HOADONCT on HOADONCT.MaSACH = Sach.MaSach\n"
                + "order by  HOADONCT.SoLuong asc";
        ResultSet rs = DBConection.excutequery(sql);
        try {
            while (rs.next()) {
                listSLThapNhat.add(new SachVM(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(10), rs.getFloat(9), rs.getInt(11), rs.getInt(12), rs.getDouble(13)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSLThapNhat;
    }

    @Override
    public List<SachVM> listsachbysql(String tenNPH) {
        listSachByNPH = new ArrayList<>();
        String sql1 = "select MaNPH  from  NPH where TenNPH = ?";
        String sql2 = "select SACH.MaSach,TenSach, NamXuatBan, NgonNgu, NhomTuoi, TaiBan, SoTrang, GiaBan, SACH.SoLuong, TrangThai, HOADONCT.SoLuong as 'soluongdaban', DonGia\n"
                + "from SACH join HOADONCT on HOADONCT.MaSACH = Sach.MaSach where  MaNPH = ?";
        ResultSet rs1 = DBConection.excutequery(sql2, tenNPH);
        String ma = null;
        try {
            while (rs1.next()) {
                ma = rs1.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = DBConection.excutequery(sql2, ma);
        try {
            while (rs.next()) {
                listSachByNPH.add(new SachVM(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(10), rs.getFloat(9), rs.getInt(11), rs.getInt(12), rs.getDouble(13)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSachByNPH;
    }

    @Override
    public List<SachVM> getSearch(String tenSach) {
        search = new ArrayList<>();
        String sql = "select SACH.MaSach,TenSach, NamXuatBan, NgonNgu, NhomTuoi, TaiBan, SoTrang, GiaBan, SACH.SoLuong, TrangThai, HOADONCT.SoLuong as 'soluongdaban',  DonGia as 'doanh thu'\n"
                + "from SACH join HOADONCT on HOADONCT.MaSACH = Sach.MaSach  where TenSach = ?\n"
                + "order by  HOADONCT.DonGia asc ";
        ResultSet rs = DBConection.excutequery(sql, tenSach);
        try {
            while (rs.next()) {
                search.add(new SachVM(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(10), rs.getFloat(9), rs.getInt(11), rs.getInt(12), rs.getDouble(13)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachVMRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return search;
    }

    @Override
    public List<SachVM> listSPbanchay() {
       listSPbanChay = new ArrayList<>();
        String query = " SELECT TOP 1 SACH.TenSach FROM HOADONCT\n" +
"                JOIN HoaDon ON HoaDon.MaHD = HOADONCT.MaHD\n" +
"                JOIN SACH ON SACH.MaSach=HOADONCT.MaSACH \n" +
"                WHERE HoaDon.TrangThai = 2\n" +
"                GROUP BY HOADONCT.MaSACH, SACH.TenSach \n" +
"                HAVING Sum(HOADONCT.SoLuong) >= ALL(SELECT Sum(SoLuong) FROM HOADONCT \n" +
"                JOIN HoaDon ON HoaDon.MaHD = HOADONCT.MaHD \n" +
"                WHERE HoaDon.TrangThai = 2\n" +
"                GROUP BY HOADONCT.MaSACH)";
        ResultSet rs = DBConection.excutequery(query);
        try {
            while (rs.next()) {
                listSPbanChay.add(new SachVM(rs.getString(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSPbanChay;
    }

}
