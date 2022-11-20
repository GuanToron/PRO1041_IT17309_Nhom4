package RepositoryInterface;

import ViewModel.HoaDonVM;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface HoaDomVMRepositoryInterface {

    ArrayList<HoaDonVM> listHDVM();

    Boolean taoHoaDon(HoaDonVM x);
}
