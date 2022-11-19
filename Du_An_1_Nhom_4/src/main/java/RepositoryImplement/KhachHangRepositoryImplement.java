package RepositoryImplement;

import DomainModel.KhachHang;
import RepositoryInterface.KhachHangRepositoryInterface;
import Utilities.DBConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class KhachHangRepositoryImplement implements KhachHangRepositoryInterface {

    @Override
    public ArrayList<KhachHang> listKH() {
        String query = "SELECT [MaKH],[TenKH],[GioiTinh],[NgaySinh],[DiaChi],[SDT],[DiemTichLuy] FROM [dbo].[KHACHHANG]";
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ArrayList<KhachHang> listKH = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listKH().add(new KhachHang(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
            return listKH();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean themKH(KhachHang kh) {
        String query = "INSERT INTO [dbo].[KHACHHANG]([TenKH],[GioiTinh],[NgaySinh],[DiaChi],[SDT],[DiemTichLuy])\n"
                + "VALUES (?,?,?,?,?,?)";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getTenKH());
            ps.setObject(2, kh.getGioiTinh());
            ps.setObject(3, kh.getNgaySinh());
            ps.setObject(4, kh.getDiaChi());
            ps.setObject(5, kh.getSdt());
            ps.setObject(6, kh.getDiemTichLuy());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean xoaKH(KhachHang kh) {
        String query = "DELETE FROM [dbo].[KHACHHANG] WHERE [MaKH] = ?";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getMaKH());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean suaKH(KhachHang kh) {
        String query = "UPDATE [dbo].[KHACHHANG]\n"
                + "SET [TenKH] = ?,[GioiTinh] = ?,[NgaySinh] = ?,[DiaChi] = ?,[SDT] = ?,[DiemTichLuy] = ?\n"
                + " WHERE [MaKH] = ?";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getTenKH());
            ps.setObject(2, kh.getGioiTinh());
            ps.setObject(3, kh.getNgaySinh());
            ps.setObject(4, kh.getDiaChi());
            ps.setObject(5, kh.getSdt());
            ps.setObject(6, kh.getDiemTichLuy());
            ps.setObject(7, kh.getMaKH());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public ArrayList<KhachHang> listSearch(String ma, String ten) {
        String query = "SELECT [MaKH],[TenKH],[GioiTinh],[NgaySinh],[DiaChi],[SDT],[DiemTichLuy] FROM [dbo].[KHACHHANG] where  [TenKH] like ? or [MaKH] = ?";
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ps.setObject(2, ten);
            ArrayList<KhachHang> listKH = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listKH().add(new KhachHang(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
            return listKH();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
