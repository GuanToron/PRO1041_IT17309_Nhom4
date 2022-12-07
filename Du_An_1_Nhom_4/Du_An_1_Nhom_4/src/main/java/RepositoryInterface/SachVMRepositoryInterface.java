
package RepositoryInterface;

import ViewModel.SachVM;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xuan Truong
 */
public interface SachVMRepositoryInterface {

    ArrayList<SachVM> listSach();

    ArrayList<SachVM> listTimKiem(String tenSach);

    Void capNhatSLSach(Integer soLuong, String tenSach);

    List<SachVM> listTopDTCaoNhat();

    List<SachVM> listTopDTThapNhat();

    List<SachVM> listTopSLCaoNhat();

    List<SachVM> listTopSLThapNhat();

    List<SachVM> listsachbysql(String tenNPH);

    List<SachVM> getSearch(String tenSach);
    
     List<SachVM> listSPbanchay();
}
