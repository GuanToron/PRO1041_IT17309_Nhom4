package Repository;

import Model.NXB;
import Utilities.DBConection;
import java.sql.*;
import java.util.ArrayList;

public class NXBRepository {

    private DBConection conection;

    public ArrayList<NXB> getlist() {
        ArrayList<NXB> list = new ArrayList<>();
        String sql = " select *from TACGIA";
        try ( Connection con = conection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery();) {
            NXB nxb = new NXB();
            nxb.setMaNXB(rs.getInt("MaNXB"));
            nxb.setTenNXB(rs.getString("TenNXB"));

            list.add(nxb);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean add(NXB nxb) {
        String sql = "insert into NXB(MaNXB,TenNXB) "
                + " values ?,?";
        try ( Connection con = conection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nxb.getMaNXB());
            ps.setObject(2, nxb.getTenNXB());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(int ma) {
        String sql = "delete NXB where MaNXB=?";
        try ( Connection con = conection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public Boolean update(NXB nxB, int ma) {
        String sql = " update NXB set TenNXB=? "
                + "where MaNXB=?";
        try ( Connection con = conection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nxB.getMaNXB());
            ps.setObject(2, ma);

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
