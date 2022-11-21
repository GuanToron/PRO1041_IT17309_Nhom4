package ServiceImplement;

import RepositoryImplement.HoaDonCTVMRepositoryInterface;
import ServiceInterface.HoaDonCTVMServiccecInterface;
import ViewModel.HoaDonCTVM;

/**
 *
 * @author Xuan Truong
 */
public class HoaDonCTVMServiceImplement implements HoaDonCTVMServiccecInterface {

    private final HoaDonCTVMRepositoryInterface repo = new HoaDonCTVMRepositoryInterface();

    @Override
    public String themHDCCT(HoaDonCTVM x) {
        Boolean themHDCT = repo.themHDCT(x);
        if (themHDCT) {
            return "Thanh cong";
        }
        return "That bai";
    }

}
