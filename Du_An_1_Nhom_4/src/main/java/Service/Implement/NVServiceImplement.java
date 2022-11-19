package Service.Implement;

import DomainModel.NhanVien;
import RepositoryImplement.NVRepositoryImplement;
import RepositoryInterface.NVRepositoryInterface;
import ViewModel.NhanVienVM;
import java.util.ArrayList;
import ServiceInterface.NVServiceInterface;

/**
 *
 * @author Xuan Truong
 */
public class NVServiceImplement implements NVServiceInterface {

    private NVRepositoryInterface repo = new NVRepositoryImplement();

    @Override
    public ArrayList<NhanVienVM> listNhanVien() {
        return repo.listNV();
    }

    @Override
    public String themNhanVien(NhanVien x) {
        if (x.getDiaChi().isBlank() || x.getMatKhau().isBlank() || x.getNgaySinh().isBlank() || x.getSDT().isBlank() || x.getTaiKhoan().isBlank() || x.getTenNhanVien().isBlank()) {
            return "Còn trống dữ liệu";
        }
        String regex = "^[a-zA-Z]+$";
        String SDT = "^0[0-9]{9}";
        if (!x.getTenNhanVien().matches(regex)) {
            return "Ten nhan vien sai dinh dang";
        }
        if (!x.getSDT().matches(SDT)) {
            return "SDT sai đinh dang";
        }
        ArrayList<NhanVienVM> list = repo.listNV();
        for (NhanVienVM z : list) {
            if (x.getTenNhanVien().equals(z.getTenNhanVien())) {
                return "Trùng tên đã có";
            }
        }
        boolean themNhanVien = repo.themNV(x);
        if (themNhanVien) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String xoaNhanVien(Integer maNhanVien) {
        boolean xoaNhanVien = repo.xoaNV(maNhanVien);
        if (xoaNhanVien) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String suaNhanVien(NhanVien x, Integer maNhanVien) {
        if (x.getDiaChi().isBlank() || x.getMatKhau().isBlank() || x.getNgaySinh().isBlank() || x.getSDT().isBlank() || x.getTaiKhoan().isBlank() || x.getTenNhanVien().isBlank()) {
            return "Còn trống dữ liệu";
        }
        String regex = "^[a-zA-Z]+$";
        String SDT = "^0[0-9]{9}";
        if (!x.getTenNhanVien().matches(regex)) {
            return "Ten nhan vien sai dinh dang";
        }
        if (!x.getSDT().matches(SDT)) {
            return "SDT sai đinh dang";
        }
        boolean suaNhanVien = repo.suaNV(x, maNhanVien);
        if (suaNhanVien) {
            return "Thanh cong";
        }
        return "That bai";

    }

    @Override
    public ArrayList<NhanVienVM> listSearch(ArrayList<NhanVienVM> list, String text) {
        ArrayList<NhanVienVM> listSearch = new ArrayList<>();
        for (NhanVienVM x : list) {
            if (text.contains(x.getTenNhanVien())) {
                listSearch.add(x);
            }
        }
        return listSearch;
    }
}
