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

    String xoaNhanVien(Integer maNhanVien);

    String suaNhanVien(NhanVien x, Integer maNhanVien);

    ArrayList<NhanVienVM> listSearch(ArrayList<NhanVienVM> list, String text);
}
