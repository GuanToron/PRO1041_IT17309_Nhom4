package RepositoryImplement;

import DomainModel.TraHangChiTiet;
import RepositoryInterface.TraHangChiTietRepositoryInteface;
import Utilities.DBConection;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Xuan Truong
 */
public class TraHangChiTietRepositoryImpement implements TraHangChiTietRepositoryInteface {

    @Override
    public Void theTraHangChiTiet(TraHangChiTiet x) {
        String query = "INSERT INTO [dbo].[PHIEUTRAHANGCHITIET]([MaPTH],[MaSach],[SoLuong],[DonGia])VALUES(?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
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

}
