package RepositoryImplement;

import DomainModel.TraHangChiTiet;
import RepositoryInterface.TraHangChiTietRepositoryInteface;
import Utilities.DBConection;
import ViewModel.QLTraHang;
import ViewModel.QLTraHangCT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xuan Truong
 */
public class TraHangChiTietRepositoryImpement implements TraHangChiTietRepositoryInteface {

    private List<QLTraHangCT> list;

    @Override
    public Void theTraHangChiTiet(TraHangChiTiet x) {
        String query = "INSERT INTO [dbo].[PHIEUTRAHANGCHITIET]([MaPTH],[MaSach],[SoLuong],[DonGia])VALUES(?,?,?,?)";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, x.getMaPhieuTraHang());
            ps.setObject(2, x.getMaSach());
            ps.setObject(3, x.getSoLuong());
            ps.setObject(4, x.getDonGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<QLTraHangCT> spTraNhieu() {
        list = new ArrayList<>();
        String sql = "select SACH.TenSach from SACH join PHIEUTRAHANGCHITIET on PHIEUTRAHANGCHITIET.MaSach = SACH.MaSach\n"
                + "where PHIEUTRAHANGCHITIET.SoLuong >= (select Max(SoLuong) from PHIEUTRAHANGCHITIET)";
        ResultSet rs = DBConection.excutequery(sql);
        try {
            while (rs.next()) {
                list.add(new QLTraHangCT(rs.getString(1)));
               // System.out.println(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraHangChiTietRepositoryImpement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
