/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryImplement;

import RepositoryInterface.IKhachHangResponsitory;
import DomainModel.KhachHang;
import ViewModel.QLKhachHang;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilities.DBConection;

/**
 *
 * @author DELL 5515
 */
public class KhachHangResponsitory implements IKhachHangResponsitory {

    private List<QLKhachHang> listkh;

    private List<QLKhachHang> listSearch;
    public KhachHangResponsitory() {
        

    }

    @Override
    public List<QLKhachHang> getAll() {
        listkh = new ArrayList<>();
        String selectAll = "select * from KHACHHANG";
        ResultSet rs = DBConection.excutequery(selectAll);
        try {
            while (rs.next()) {
                listkh.add(new QLKhachHang(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listkh;
    }

    @Override
    public Integer add(KhachHang kh) {
        String insert = "insert into KHACHHANG( TenKH ,GioiTinh ,NgaySinh, DiaChi  ,SDT   ,DiemTichLuy) values (?,?,?,?,?,?)";
        int row = DBConection.excuteUpdate(insert, kh.getTenKH(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getDiaChi(), kh.getSdt(), kh.getDiemTichLuy());
        return row;
    }

    @Override
    public Integer delete(String maKH) {
        String delete = "delete from KHACHHANG where MaKH = ? ";
        int row = DBConection.excuteUpdate(delete, maKH);
        return row;
    }

    @Override
    public Integer update(String maKH, KhachHang kh) {
        String update = "update KHACHHANG set TenKH= ? ,GioiTinh= ? ,NgaySinh= ?, DiaChi= ?  ,SDT= ?   ,DiemTichLuy= ? where MaKH = ?";
        int row = DBConection.excuteUpdate(update, kh.getTenKH(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getDiaChi(), kh.getSdt(), kh.getDiemTichLuy(),maKH);
        return row;

    }

    @Override
    public List<QLKhachHang> getListSearch(String tenKH) {
        listSearch = new ArrayList<>();
        String selectAll = "SELECT MaKH, TenKH, GioiTinh, NgaySinh, DiaChi, SDT, DiemTichLuy FROM KHACHHANG where TenKH = ?";
        ResultSet rs = DBConection.excutequery(selectAll,tenKH);
        try {
            while (rs.next()) {
                listSearch.add(new QLKhachHang(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSearch;
    }

}
