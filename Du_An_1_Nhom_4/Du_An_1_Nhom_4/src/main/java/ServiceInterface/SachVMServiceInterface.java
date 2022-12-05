package ServiceInterface;

import ViewModel.SachVM;
import ViewModel.SachViewmodel;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface SachVMServiceInterface {

    ArrayList<SachVM> listSach();

    ArrayList<SachVM> listSearch(String text);
    
    ArrayList<SachVM> listLoc(ArrayList<SachViewmodel> list, String text);

    Void capNhatSoSach(Integer soLuong, String tenSach);
}
