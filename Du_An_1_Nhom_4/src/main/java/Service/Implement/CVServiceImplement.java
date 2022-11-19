package Service.Implement;

import java.util.ArrayList;
import DomainModel.ChucVu;
import RepositoryImplement.CVRepositoryImplement;
import ServiceInterface.CVServiceInterface;

/**
 *
 * @author Xuan Truong
 */
public class CVServiceImplement implements CVServiceInterface {

    private CVRepositoryImplement repo = new CVRepositoryImplement();

    @Override
    public ArrayList<ChucVu> listChucVu() {
        return repo.listCV();
    }

    @Override
    public String themChucVu(ChucVu x) {
        if (x.getTenChucVu().isBlank()) {
            return "Ten CV khong duoc de trong";
        }
        String regex = "^[a-zA-Z]+$";
        if (!x.getTenChucVu().matches(regex)) {
            return "Ten NPH sai dinh dang";
        }
        boolean them = repo.themCV(x);
        if (them) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String xoaChucVu(ChucVu x) {
        boolean xoa = repo.xoaCV(x);
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
        boolean sua = repo.suaCV(x);
        if (sua) {
            return "Thanh cong";
        }
        return "That bai";
    }

}
