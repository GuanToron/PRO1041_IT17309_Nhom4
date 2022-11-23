package ServiceInterface;

import ViewModel.HoaDonVM;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xuan Truong
 */
public interface HoaDonVMServiceInterface {

    String taoHD(HoaDonVM x);

    ArrayList<HoaDonVM> listHDVM();

    String capNhatHD(HoaDonVM x);
    
    List<HoaDonVM> loadDaThanhToan();
    List<HoaDonVM> loadChuaThanhToan();
}
