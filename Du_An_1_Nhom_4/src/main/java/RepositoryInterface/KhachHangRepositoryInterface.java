package RepositoryInterface;

import DomainModel.KhachHang;
import ViewModel.KhachHangVM;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface KhachHangRepositoryInterface {

    ArrayList<KhachHang> listKH();

    Boolean themKH(KhachHang kh);

    Boolean xoaKH(Integer maKhachHang);

    Boolean suaKH(KhachHang kh, Integer maKhachHang);
}
