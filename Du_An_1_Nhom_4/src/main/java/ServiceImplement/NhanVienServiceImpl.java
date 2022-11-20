package ServiceImplement;

import DomainModel.NhanVien;
import RepositoryImplement.NhanVienRepository;
import ServiceInterface.NhanVienService;
import ViewModel.NhanVienRespone;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository repo = new NhanVienRepository();

    @Override
    public ArrayList<NhanVienRespone> listNhanVien() {
        return repo.listNhanVien();
    }

    @Override
    public String themNhanVien(NhanVien x) {
        boolean themNhanVien = repo.themNhanVien(x);
        if (themNhanVien) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String xoaNhanVien(Integer maNhanVien) {
        boolean xoaNhanVien = repo.xoaNhanVien(maNhanVien);
        if (xoaNhanVien) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String suaNhanVien(NhanVien x, Integer maNhanVien) {
        boolean suaNhanVien = repo.suaNhanVien(x, maNhanVien);
        if (suaNhanVien) {
            return "Thanh cong";
        }
        return "That bai";
    }

}
