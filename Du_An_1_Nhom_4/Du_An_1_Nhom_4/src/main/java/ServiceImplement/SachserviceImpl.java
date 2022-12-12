package ServiceImplement;

import DomainModel.Sach;
import RepositoryImplement.SachRepositoryImplement;
import ServiceInterface.SachService;
import ViewModel.SachVML;
import ViewModel.SachViewmodel;
import java.util.ArrayList;

/**
 *
 * @author dqv20
 */
public class SachserviceImpl implements SachService {

    private SachRepositoryImplement cc = new SachRepositoryImplement();

    @Override
    public ArrayList<SachViewmodel> getlist() {
        return cc.getlist();
    }

    @Override
    public String add(Sach s) {
        boolean them = cc.add(s);
        if (them) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String update(Sach s, int ma) {
        boolean sua = cc.update(s, ma);
        if (sua) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String delete(int ma) {
        boolean xoa = cc.delete(ma);
        if (xoa) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public ArrayList<SachViewmodel> listSearch(ArrayList<SachViewmodel> list, String text) {
        ArrayList<SachViewmodel> listSearch = new ArrayList<>();
        for (SachViewmodel x : list) {
            if (x.getTensach().contains(text)) {
                listSearch.add(x);
            }
        }
        return listSearch;
    }

    @Override
    public ArrayList<SachViewmodel> listLoc(ArrayList<SachViewmodel> list, String text) {
        ArrayList<SachViewmodel> listLoc = new ArrayList<>();
        for (SachViewmodel x : list) {
            if (x.getTenTheLoai().equalsIgnoreCase(text) || x.getTenTacGia().equalsIgnoreCase(text) || x.getTenNXB().equalsIgnoreCase(text) || x.getTenNPH().equalsIgnoreCase(text) || x.getTenDanhMuc().equalsIgnoreCase(text) || x.getNhomTuoi().equalsIgnoreCase(text)) {
                listLoc.add(x);
            }
        }
        return listLoc;
    }

    @Override
    public ArrayList<SachVML> listSach() {
        return cc.listSach();
    }

    @Override
    public String capNhat(Integer maSach, Integer soLuong) {
        boolean capNhat = cc.capNhat(maSach, soLuong);
        if (capNhat) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String capNhatTheoTen(String tenSach, Integer soLuong) {
        boolean capNhat = cc.capNhatTheoTen(tenSach, soLuong);
        if (capNhat) {
            return "Thanh cong";
        }
        return "That bai";
    }

}
