package Service;

import java.util.ArrayList;
import Model.NhanVien;
import ViewModel.NhanVienRespone;

/**
 *
 * @author Xuan Truong
 */
public interface NhanVienService {

    ArrayList<NhanVienRespone> listNhanVien();

    String themNhanVien(NhanVien x);

    String xoaNhanVien(Integer maNhanVien);

    String suaNhanVien(NhanVien x,Integer maNhanVien);
}
