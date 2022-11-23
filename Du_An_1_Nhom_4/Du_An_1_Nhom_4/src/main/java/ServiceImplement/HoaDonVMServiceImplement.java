package ServiceImplement;

import RepositoryImplement.HoaDonVMRepositoryImplement;
import RepositoryInterface.HoaDomVMRepositoryInterface;
import ServiceInterface.HoaDonVMServiceInterface;
import ViewModel.HoaDonVM;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class HoaDonVMServiceImplement implements HoaDonVMServiceInterface {

    private HoaDomVMRepositoryInterface repo = new HoaDonVMRepositoryImplement();

    @Override
    public String taoHD(HoaDonVM x) {
        boolean taoHD = repo.taoHoaDon(x);
        if (taoHD) {
            return "Tao hoa don thanh cong";
        }
        return "Tao HD that bai";
    }

    @Override
    public ArrayList<HoaDonVM> listHDVM() {
        return repo.listHDVM();
    }

    @Override
    public String capNhatHD(HoaDonVM x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
