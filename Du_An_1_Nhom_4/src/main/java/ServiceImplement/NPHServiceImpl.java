package ServiceImplement;

import DomainModel.NPH;
import RepositoryImplement.NPHRepository;
import ServiceInterface.NPHService;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class NPHServiceImpl implements NPHService {

    private final NPHRepository repo = new NPHRepository();

    @Override
    public ArrayList<NPH> listNPH() {
        return repo.getAllNPH();
    }

    @Override
    public String themNPH(NPH x) {
        if (x.getTenNPH().isBlank()) {
            return "Ten NPH khong duoc de trong";
        }
        String regex = "^[a-zA-Z]+$";
        if (!x.getTenNPH().matches(regex)) {
            return "Ten NPH sai dinh dang";
        }
        boolean them = repo.themNPH(x);
        if (them) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String suaNPH(NPH x) {
        if (x.getTenNPH().isBlank()) {
            return "Ten NPH khong duoc de trong";
        }
        String regex = "^[a-zA-Z]+$";
        if (!x.getTenNPH().matches(regex)) {
            return "Ten NPH sai dinh dang";
        }
        boolean sua = repo.suaNPH(x);
        if (sua) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String xoaNPH(NPH x) {
        boolean xoa = repo.xoaNPH(x);
        if (xoa) {
            return "Thanh cong";
        }
        return "That bai";
    }

}
