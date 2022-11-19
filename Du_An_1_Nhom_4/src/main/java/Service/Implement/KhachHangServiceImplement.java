package Service.Implement;

import DomainModel.KhachHang;
import RepositoryImplement.KhachHangRepositoryImplement;
import RepositoryInterface.KhachHangRepositoryInterface;
import ServiceInterface.KhachHangServiceInterface;
import ViewModel.KhachHangVM;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class KhachHangServiceImplement implements KhachHangServiceInterface {

    private final KhachHangRepositoryInterface khRepo = new KhachHangRepositoryImplement();

    @Override
    public ArrayList<KhachHang> listKH() {
        return khRepo.listKH();
    }

    @Override
    public String themKH(KhachHang kh) {
        if (String.valueOf(kh.getDiemTichLuy()).isBlank() || String.valueOf(kh.getNgaySinh()).isBlank() || kh.getDiaChi().isBlank() || kh.getSdt().isBlank() || kh.getTenKH().isBlank()) {
            return "Còn trống dữ liệu";
        }
        String regex = "^[a-zA-Z]+$";
        String SDT = "^0[0-9]{9}";
        if (!kh.getTenKH().matches(regex)) {
            return "Tên sai định dạng";
        }
        if (!kh.getSdt().matches(SDT)) {
            return "SDT sai định dạng";
        }
        try {
            if (kh.getDiemTichLuy() < 0) {
                return "Điểm phải lớn hơn 0";
            }
        } catch (NumberFormatException e) {
            return "Điểm phải là số";
        }
        boolean them = khRepo.themKH(kh);
        if (them) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String suaKH(KhachHang kh) {
        if (String.valueOf(kh.getDiemTichLuy()).isBlank() || String.valueOf(kh.getNgaySinh()).isBlank() || kh.getDiaChi().isBlank() || kh.getSdt().isBlank() || kh.getTenKH().isBlank()) {
            return "Còn trống dữ liệu";
        }
        String regex = "^[a-zA-Z]+$";
        String SDT = "^0[0-9]{9}";
        if (!kh.getTenKH().matches(regex)) {
            return "Tên sai định dạng";
        }
        if (!kh.getSdt().matches(SDT)) {
            return "SDT sai định dạng";
        }
        try {
            if (kh.getDiemTichLuy() < 0) {
                return "Điểm phải lớn hơn 0";
            }
        } catch (NumberFormatException e) {
            return "Điểm phải là số";
        }
        boolean sua = khRepo.suaKH(kh);
        if (sua) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String xoaKH(KhachHang kh) {
        boolean xoa = khRepo.xoaKH(kh);
        if (xoa) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public ArrayList<KhachHang> timKH(String ma, String ten) {
        return khRepo.listSearch(ma, ten);
    }

}
