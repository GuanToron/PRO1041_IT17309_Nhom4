package RepositoryImplement;

import RepositoryInterface.HoaDomVMRepositoryInterface;
import Utilities.DBConection;
import ViewModel.HoaDonVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Xuan Truong
 */
public class HoaDonVMRepositoryImplement implements HoaDomVMRepositoryInterface {

    @Override
    public Boolean taoHoaDon(HoaDonVM x) {
        String query = "INSERT INTO [dbo].[HOADON]([MaKH],[MaNV],[NgayTao],[TrangThai])VALUES(?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
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

}
