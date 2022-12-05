package ServiceImplement;

import RepositoryImplement.SachRepositoryImplement;
import RepositoryImplement.SachVMRepositoryImplement;
import RepositoryInterface.SachVMRepositoryInterface;
import ServiceInterface.SachVMServiceInterface;
import ViewModel.SachVM;
import ViewModel.SachViewmodel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xuan Truong
 */
public class SachVMServiceImplement implements SachVMServiceInterface {

    private final SachVMRepositoryInterface repo = new SachVMRepositoryImplement();
    private SachRepositoryImplement cc = new SachRepositoryImplement();

    @Override
    public ArrayList<SachVM> listSach() {
        return repo.listSach();
    }

    @Override
    public ArrayList<SachVM> listSearch(String text) {
        ArrayList<SachVM> listSach = repo.listSach();
        ArrayList<SachVM> listSearch = new ArrayList<>();
        for (SachVM x : listSach) {
            if (text.contains(x.getTenSach())) {
                listSearch.add(x);
            }
        }
        return listSearch;
    }

    @Override
    public Void capNhatSoSach(Integer soLuong, String tenSach) {
        return repo.capNhatSLSach(soLuong, tenSach);
    }

    @Override
    public ArrayList<SachVM> listLoc(ArrayList<SachViewmodel> listSA, String text) {
        ArrayList<SachVM> listLoc = new ArrayList<>();
        for (SachViewmodel x : listSA) {
            if (x.getTenTheLoai().equalsIgnoreCase(text) || x.getTenTacGia().equalsIgnoreCase(text) || x.getTenNXB().equalsIgnoreCase(text) || x.getTenNPH().equalsIgnoreCase(text) || x.getTenDanhMuc().equalsIgnoreCase(text) || x.getNhomTuoi().equalsIgnoreCase(text)) {
                SachVM z = new SachVM();
                z.setGiaBan(x.getGiaban());
                z.setMaSach(x.getMasach());
                z.setSoLuong(x.getSoluong());
                z.setTenSach(x.getTensach());
                listLoc.add(z);
            }
        }
        return listLoc;
    }

    @Override
    public List<SachVM> listTopDTCaoNhat() {
        return repo.listTopDTCaoNhat();
    }

    @Override
    public List<SachVM> listTopDTThapNhat() {
      return repo.listTopDTThapNhat();
    }

    @Override
    public List<SachVM> listTopSLCaoNhat() {
     return repo.listTopSLCaoNhat();
    }

    @Override
    public List<SachVM> listTopSLThapNhat() {
    return repo.listTopSLThapNhat();
    }

    @Override
    public List<SachVM> listsachbysql(String tenNPH) {
     return repo.listsachbysql(tenNPH);
    }

    @Override
    public List<SachVM> getSearch(String tenSach) {
     return repo.getSearch(tenSach);
    }

}
