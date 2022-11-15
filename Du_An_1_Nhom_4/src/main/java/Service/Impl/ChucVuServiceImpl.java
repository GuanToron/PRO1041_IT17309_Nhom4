package Service.Impl;

import java.util.ArrayList;
import Model.ChucVu;
import Repository.ChucVuRepository;
import Service.ChucVuService;

/**
 *
 * @author Xuan Truong
 */
public class ChucVuServiceImpl implements ChucVuService {

    private ChucVuRepository repo = new ChucVuRepository();

    @Override
    public ArrayList<ChucVu> listChucVu() {
        return repo.getAllChucVu();
    }

    @Override
    public String themChucVu(ChucVu x) {
        if (x.getTenChucVu().isBlank()) {
            return "Ten NPH khong duoc de trong";
        }
        String regex = "^[a-zA-Z]+$";
        if (!x.getTenChucVu().matches(regex)) {
            return "Ten NPH sai dinh dang";
        }
        boolean them = repo.themChucVu(x);
        if (them) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String xoaChucVu(ChucVu x) {
        boolean xoa = repo.xoaChucVu(x);
        if (xoa) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String suaChucVu(ChucVu x) {
        if (x.getTenChucVu().isBlank()) {
            return "Ten NPH khong duoc de trong";
        }
        String regex = "^[a-zA-Z]+$";
        if (!x.getTenChucVu().matches(regex)) {
            return "Ten NPH sai dinh dang";
        }
        boolean sua = repo.suaChucVu(x);
        if (sua) {
            return "Thanh cong";
        }
        return "That bai";
    }

}
