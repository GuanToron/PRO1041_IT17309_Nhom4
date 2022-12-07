package ServiceInterface;

import ViewModel.SachVM;
import ViewModel.SachViewmodel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xuan Truong
 */
public interface SachVMServiceInterface {

    ArrayList<SachVM> listSach();

    ArrayList<SachVM> listSearch(String text);

    ArrayList<SachVM> listLoc(ArrayList<SachViewmodel> list, String text);

    Void capNhatSoSach(Integer soLuong, String tenSach);

    List<SachVM> listTopDTCaoNhat();

    List<SachVM> listTopDTThapNhat();

    List<SachVM> listTopSLCaoNhat();

    List<SachVM> listTopSLThapNhat();

    List<SachVM> listsachbysql(String tenNPH);

    List<SachVM> getSearch(String tenSach);
    
    List<SachVM> listSPbanchay();
}
