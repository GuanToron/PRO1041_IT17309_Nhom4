package ServiceInterface;

import ViewModel.HoaDonVM;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface HoaDonVMServiceInterface {

    String taoHD(HoaDonVM x);

    ArrayList<HoaDonVM> listHDVM();
}
