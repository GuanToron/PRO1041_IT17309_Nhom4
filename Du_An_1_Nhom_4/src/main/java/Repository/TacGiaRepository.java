/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.TacGia;
import Utilities.DBConection;
import java.sql.*;
import java.util.ArrayList;

public class TacGiaRepository {

    private DBConection conection;

    public ArrayList<TacGia> getlist() {
        ArrayList<TacGia> list = new ArrayList<>();
        String sql = " select *from TACGIA";
        try ( Connection con = conection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery();) {
            TacGia tg = new TacGia();
            tg.setMaTG(rs.getInt("MaTG"));
            tg.setTenTG(rs.getString("TenTG"));

            list.add(tg);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean add(TacGia tg) {
        String sql = "insert into TACGIA(MATG,TenTG) "
                + " values ?,?";
        try ( Connection con = conection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, tg.getMaTG());
            ps.setObject(2, tg.getTenTG());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(int ma) {
        String sql = "delete TACGIA where MaTg=?";
        try ( Connection con = conection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public Boolean update(TacGia tG, int ma) {
        String sql = " update TACGIA set TenTG=? "
                + "where MaTG=?";
        try ( Connection con = conection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, tG.getTenTG());
            ps.setObject(2, ma);

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
