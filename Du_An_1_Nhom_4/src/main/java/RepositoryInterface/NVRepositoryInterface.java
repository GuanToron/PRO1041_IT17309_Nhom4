package RepositoryInterface;

import DomainModel.NhanVien;
import ViewModel.NhanVienVM;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface NVRepositoryInterface {

    ArrayList<NhanVienVM> listNV();

    Boolean themNV(NhanVien x);

    Boolean suaNV(NhanVien x, Integer maNhanVien);

    Boolean xoaNV(Integer maNhanVien);

}
