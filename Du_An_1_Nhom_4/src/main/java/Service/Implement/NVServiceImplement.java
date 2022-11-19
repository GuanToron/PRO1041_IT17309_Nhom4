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
        boolean themNhanVien = repo.themNV(x);
        if (themNhanVien) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String xoaNhanVien(NhanVien x) {
        boolean xoaNhanVien = repo.xoaNV(x);
        if (xoaNhanVien) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String suaNhanVien(NhanVien x, Integer maNhanVien) {
        boolean suaNhanVien = repo.suaNV(x, maNhanVien);
        if (suaNhanVien) {
            return "Thanh cong";
        }
        return "That bai";

    }

    @Override
    public ArrayList<NhanVienVM> listSearch(String ten, String ma) {
        return listSearch(ten, ma);
    }
}
