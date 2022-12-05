/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryImplement;

import RepositoryInterface.ISanPhamLoiRepository;
import DomainModel.SanPhamLoi;
import Utilities.DBConection;
import ViewModel.QLSanPhamLoi;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL 5515
 */
public class SanPhamLoiRepository implements ISanPhamLoiRepository {

    private List<QLSanPhamLoi> list;

    public SanPhamLoiRepository() {
        list = new ArrayList<>();
    }

    @Override
    public List<QLSanPhamLoi> getAll() {
        String selectAll = "SELECT SANPHAMLOI.MaSPL, SANPHAMLOI.MaSach, SANPHAMLOI.SoLuong, NPH.TenNPH, SANPHAMLOI.LyDoDoi\n"
                + "FROM NPH INNER JOIN SANPHAMLOI ON NPH.MaNPH = SANPHAMLOI.MaNPH";
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(selectAll);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new QLSanPhamLoi(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamLoiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Boolean add(SanPhamLoi sp) {
        String insert = "INSERT INTO [dbo].[SANPHAMLOI]([MaSach],[SoLuong],[MaNPH],[LyDoDoi])\n"
                + "VALUES(?,?,?,?)";
        int row = DBConection.excuteUpdate(insert, sp.getMaSach(), sp.getSoLuong(), sp.getMaNPH(), sp.getLyDoDoi());
        return row > 0;
    }

    @Override
    public Integer delete(String maspl) {
        String delete = "delete from SANPHAMLOI where MaSPL = ? ";
        int row = DBConection.excuteUpdate(delete, maspl);
        return row;
    }

    @Override
    public Boolean update(String maspl, SanPhamLoi sp) {
        String update = "update SANPHAMLOI set MaSach = ?, SoLuong = ?, LyDoDoi =  ? where MaSPL = ?";
        int row = DBConection.excuteUpdate(update, sp.getMaSach(), sp.getSoLuong(), sp.getLyDoDoi(), maspl);
        return row > 0;
    }

}
