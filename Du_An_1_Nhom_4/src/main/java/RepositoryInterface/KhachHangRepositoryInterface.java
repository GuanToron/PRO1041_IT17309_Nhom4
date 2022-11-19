package RepositoryInterface;

import DomainModel.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface KhachHangRepositoryInterface {

    ArrayList<KhachHang> listKH();

    Boolean themKH(KhachHang kh);

    Boolean xoaKH(KhachHang kh);

    Boolean suaKH(KhachHang kh);

    ArrayList<KhachHang> listSearch(String ma, String ten);
}
