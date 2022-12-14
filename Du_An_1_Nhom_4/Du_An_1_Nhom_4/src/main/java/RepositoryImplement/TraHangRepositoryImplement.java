package RepositoryImplement;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Utilities.DBConection;
import ViewModel.QLTraHang;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xuan Truong
 */
public class TraHangRepositoryImplement {

    private List<QLTraHang> list;
    public ArrayList<QLTraHang> listTraHang() {
        String query = "SELECT PHIEUTRAHANG.MaPTH, PHIEUTRAHANG.MaHD,PHIEUTRAHANG.MaKH, PHIEUTRAHANG.MaNV, PHIEUTRAHANG.NgayTra, PHIEUTRAHANG.SoTienTraLai, PHIEUTRAHANG.LyDoTra\n"
                + "FROM PHIEUTRAHANG";
        ArrayList<QLTraHang> listTraHang = new ArrayList<>();
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listTraHang.add(new QLTraHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
                        rs.getDate(5), rs.getFloat(6), rs.getString(7)));
            }
            return listTraHang;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean themPTH(QLTraHang x) {
        String query = "INSERT INTO [dbo].[PHIEUTRAHANG]([MaHD],[MaKH],[MaNV],[NgayTra],[SoTienTraLai],[LyDoTra])\n"
                + "VALUES(?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x.getMaHD());
            ps.setObject(2, x.getMaKH());
            ps.setObject(3, x.getMaNV());
            ps.setObject(4, x.getNgayTra());
            ps.setObject(5, x.getTienTraLai());
            ps.setObject(6, x.getLyDo());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean suaPTH(QLTraHang x, String MaHD) {
        String query = "UPDATE [dbo].[PHIEUTRAHANG] SET [MaHD] = ?,[MaKH] = ?,[MaNV] = ?,[NgayTra] = ?,[SoTienTraLai] = ?,[LyDoTra] = ?\n"
                + " WHERE [MaHD]= ?";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, x.getMaHD());
            ps.setObject(2, x.getMaKH());
            ps.setObject(3, x.getMaNV());
            ps.setObject(4, x.getNgayTra());
            ps.setObject(5, x.getTienTraLai());
            ps.setObject(6, x.getLyDo());
            ps.setObject(7, MaHD);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean xoaPTH(String MaPTH) {
        String query = "DELETE FROM [dbo].[PHIEUTRAHANG] WHERE [MaPTH] = ?";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, MaPTH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
     public List<QLTraHang> tongSP() {
      list = new ArrayList<>();
      String sql = "select count(MaPTH) from PHIEUTRAHANG";
      ResultSet rs = DBConection.excutequery(sql);
        try {
            while(rs.next()){
                list.add(new QLTraHang(rs.getInt(1)));
                //System.out.println(list);
            } } catch (SQLException ex) {
            Logger.getLogger(TraHangChiTietRepositoryImpement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
