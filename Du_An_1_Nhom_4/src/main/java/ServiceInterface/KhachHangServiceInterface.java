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

    String suaKH(KhachHang kh, Integer maKhachHang);

    String xoaKH(Integer maKhachHang);

    ArrayList<KhachHang> listSearch(ArrayList<KhachHang> list, String text);
}
