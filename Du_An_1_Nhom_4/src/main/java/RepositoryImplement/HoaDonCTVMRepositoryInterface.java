package RepositoryImplement;

import Utilities.DBConection;
import ViewModel.HoaDonCTVM;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Xuan Truong
 */
public class HoaDonCTVMRepositoryInterface implements RepositoryInterface.HoaDonCTVMRepositoryInterface {

    @Override
    public Boolean themHDCT(HoaDonCTVM x) {
        String query = "INSERT INTO [dbo].[HOADONCT]([MaHD],[MaSACH],[SoLuong],[DonGia])VALUES(?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, x.getMaHoaDon());
            ps.setObject(2, x.getMaSach());
            ps.setObject(3, x.getSoLuong());
            ps.setObject(4, x.getDonGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
        return check > 0;
    }

}
