package ServiceImplement;

import RepositoryImplement.TraHangRepositoryImplement;
import ViewModel.QLTraHang;
import java.util.ArrayList;
import java.util.Date;
import ServiceInterface.TraHangServiceInterface;
import java.util.List;

/**
 *
 * @author Xuan Truong
 */
public class TraHangServiceImpllement implements TraHangServiceInterface {

    private final TraHangRepositoryImplement repo = new TraHangRepositoryImplement();

    @Override
    public ArrayList<QLTraHang> listTraHang() {
        return repo.listTraHang();
    }

    @Override
    public String themPTH(QLTraHang x) {
        boolean themPTH = repo.themPTH(x);
        if (themPTH) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String xoaPTH(String MaPTH) {
        boolean xoaPTH = repo.xoaPTH(MaPTH);
        if (xoaPTH) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String suaPTH(QLTraHang x, String MaPTH) {
        boolean themPTH = repo.suaPTH(x, MaPTH);
        if (themPTH) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public List<QLTraHang> tongSP() {
      return repo.tongSP();
    }

}
