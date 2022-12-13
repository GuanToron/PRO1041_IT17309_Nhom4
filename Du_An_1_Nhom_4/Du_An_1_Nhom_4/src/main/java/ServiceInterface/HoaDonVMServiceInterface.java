package ServiceInterface;

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
public interface HoaDonVMServiceInterface {

    String taoHD(HoaDonVM x);

    ArrayList<HoaDonVM> listHDVM();

    ArrayList<HoaDonVM> listHDTH();

    HoaDonVM inHoaDon(String maHoaDon);

    ArrayList<HoaDonVM> listHD();

    String capNhatHDThanhToan(HoaDonVM x);

    String capNhatHDCho(HoaDonVM x);

    ArrayList<HoaDonVM> listloc(Date ngayBatDau, Date ngayKetThuc);

    ArrayList<GioHangVM> getSach(String maHD);

    List<HoaDonVM> loadchuathanhtoan();

    List<HoaDonVM> loaddangcho();

    List<HoaDonVM> listDT();

    List<HoaDonVM> TimKiemDTTheoNgay(String date);

    List<HoaDonVM> TongDT();

    List<HoaDonVM> tongHDthongke();

    List<HoaDonVM> timKiemTen(String ten);

}
