package RepositoryImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DomainModel.ChucVu;
import RepositoryInterface.CVRepositoryInterface;
import Utilities.DBConection;

/**
 *
 * @author Xuan Truong
 */
public class CVRepositoryImplement implements CVRepositoryInterface {

    @Override
    public ArrayList<ChucVu> listCV() {
        String query = "SELECT [MaCV],[TenCV] FROM [dbo].[CHUCVU]";
        ArrayList<ChucVu> listChucVu = new ArrayList<>();
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listChucVu.add(new ChucVu(rs.getInt(1), rs.getString(2)));
            }
            return listChucVu;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public Boolean themCV(ChucVu x) {
        String query = "INSERT INTO [dbo].[CHUCVU] ([TenCV]) VALUES (?)";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x.getTenChucVu());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean suaCV(ChucVu x) {
        String query = "UPDATE [dbo].[CHUCVU] SET [TenCV] = ? WHERE [MaCV] = ?";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x.getTenChucVu());
            ps.setObject(2, x.getMaChucVu());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean xoaCV(ChucVu x) {
        String query = "DELETE FROM [dbo].[CHUCVU] WHERE [MaCV] = ?";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x.getMaChucVu());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
