package ServiceInterface;

import java.util.ArrayList;
import DomainModel.NhanVien;
import ViewModel.NhanVienVM;

/**
 *
 * @author Xuan Truong
 */
public interface NVServiceInterface {

    ArrayList<NhanVienVM> listNhanVien();

    String themNhanVien(NhanVien x);

    String xoaNhanVien(NhanVien x);

    String suaNhanVien(NhanVien x, Integer maNhanVien);

    ArrayList<NhanVienVM> listSearch(String ten, String ma);
}
