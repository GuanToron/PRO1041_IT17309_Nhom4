package Service.Impl;

import Model.NPH;
import Repository.NPHRepository;
import Service.NPHService;
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
        boolean them = repo.themNPH(x);
        if (them) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String suaNPH(NPH x) {
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
