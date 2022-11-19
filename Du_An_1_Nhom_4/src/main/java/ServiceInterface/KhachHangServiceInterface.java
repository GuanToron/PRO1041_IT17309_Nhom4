package ServiceInterface;

import DomainModel.KhachHang;
import ViewModel.KhachHangVM;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface KhachHangServiceInterface {

    ArrayList<KhachHang> listKH();

    String themKH(KhachHang kh);

    String suaKH(KhachHang kh);

    String xoaKH(KhachHang kh);

    ArrayList<KhachHang> timKH(String ma, String ten);
}
