package RepositoryInterface;

import ViewModel.HoaDonVM;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xuan Truong
 */
public interface HoaDomVMRepositoryInterface {

    ArrayList<HoaDonVM> listHDVM();

    Boolean taoHoaDon(HoaDonVM x);

    Boolean capNhatHoaDon(HoaDonVM x);
    
     List<HoaDonVM> loadDaThanhToan();
    List<HoaDonVM> loadChuaThanhToan();
}
