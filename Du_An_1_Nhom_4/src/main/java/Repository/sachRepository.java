/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.Sach;
import Utilities.DBConection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author dqv20
 */
public class sachRepository {

    private DBConection conection;

    public ArrayList<Sach> getlist() {
        ArrayList<Sach> list = new ArrayList<>();
        String sql = "select MaSach,TenSach,MaDM,MaTL,MaTL,MaNPH,MaTG,NamXuatBan,NgonNgu,NhomTuoi,TaiBan,SoTrang,SoLuong from sach";
        try ( Connection con = conection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Sach s = new Sach();
                s.setMasach(rs.getInt("MaSach"));
                s.setTensach(rs.getString("TenSach"));
                s.setMadm(rs.getInt("MaDM"));
                s.setMatl(rs.getInt("MaTL"));
                s.setManph(rs.getInt("MaNPH"));
                s.setMatg(rs.getInt("MaTG"));
                s.setNamxuatban(rs.getString("NamXuatBan"));
                s.setNgonngu(rs.getString("NgonNgu"));
                s.setNhomtuoi(rs.getInt("NhomTuoi"));
                s.setTaiban(rs.getString("TaiBan"));
                s.setMadm(rs.getInt("SoTrang"));
                s.setMadm(rs.getInt("SoLuong"));
                list.add(s);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean add(Sach s) {
        String sql = "insert into sach( TenSach,MaDM,MaTL,MaTL,MaNPH,MaTG,NamXuatBan,NgonNgu,NhomTuoi,TaiBan,SoTrang,SoLuong) values ?,?,?,?,?,?,?,?,?,?,?,?";
        try ( Connection con = conection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, s.getTensach());
            ps.setObject(2, s.getMadm());
            ps.setObject(3, s.getMatl());
            ps.setObject(4, s.getManph());
            ps.setObject(5, s.getMatg());
            ps.setObject(6, s.getNamxuatban());
            ps.setObject(7, s.getNgonngu());
            ps.setObject(8, s.getNhomtuoi());
            ps.setObject(9, s.getTaiban());
            ps.setObject(10, s.getSotrang());
            ps.setObject(11, s.getGiaban());
            ps.setObject(12, s.getSoluong());
            ps.setObject(12, s.getTrangthai());
            ps.executeUpdate();
return true;
        } catch (Exception e) {
 e.printStackTrace();
        return false;}

    }
    public Boolean update(Sach s ,int ma){
   String sql="update sach set TenSach =?,MaDM=?,MaTL=?,MaTL=?,MaNPH=?,MaTG=?,NamXuatBan=?,NgonNgu=?,NhomTuoi=?,TaiBan=?,SoTrang=?,SoLuong=?"
           + "  where masach=?";
    
        try (Connection con = conection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
             ps.setObject(1, s.getTensach());
            ps.setObject(2, s.getMadm());
            ps.setObject(3, s.getMatl());
            ps.setObject(4, s.getManph());
            ps.setObject(5, s.getMatg());
            ps.setObject(6, s.getNamxuatban());
            ps.setObject(7, s.getNgonngu());
            ps.setObject(8, s.getNhomtuoi());
            ps.setObject(9, s.getTaiban());
            ps.setObject(10, s.getSotrang());
            ps.setObject(11, s.getGiaban());
            ps.setObject(12, s.getSoluong());
            ps.setObject(12, s.getTrangthai());
            
            ps.setObject(13, ma);
          
            ps.executeUpdate();  return true;
        } catch (Exception e) {
      e.printStackTrace();
        return false;}
    }
    public Boolean delete(int ma){
    String sql = "delete sach where Masach=?";
        try (Connection con = conection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, ma);
            ps.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
