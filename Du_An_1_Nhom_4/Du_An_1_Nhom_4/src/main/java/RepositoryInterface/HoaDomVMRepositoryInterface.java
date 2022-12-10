package RepositoryInterface;

import ViewModel.GioHangVM;
import ViewModel.HoaDonVM;
import ViewModel.SachVM;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Xuan Truong
 */
public interface HoaDomVMRepositoryInterface {

    ArrayList<HoaDonVM> listHDVM();

    ArrayList<HoaDonVM> listHDTH();

    ArrayList<HoaDonVM> listHD();

    HoaDonVM inHoaDon(String maHoaDon);

    Boolean taoHoaDon(HoaDonVM x);

    Boolean capNhatHoaDon(HoaDonVM x);

    ArrayList<GioHangVM> getSach(String maHD);

    List<HoaDonVM> loadchuathanhtoan();

    List<HoaDonVM> loaddangcho();

    ArrayList<HoaDonVM> listloc(Date ngayBatDau, Date ngayKetThuc);

    List<HoaDonVM> listDT();

    List<HoaDonVM> TimKiemDTTheoNgay(String date);

    List<HoaDonVM> TongDT();

    List<HoaDonVM> tongHDthongke();

    List<HoaDonVM> timKiemTheoTen(String ten );
}
