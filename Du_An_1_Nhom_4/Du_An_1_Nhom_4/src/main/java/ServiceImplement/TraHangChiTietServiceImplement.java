package ServiceImplement;

import DomainModel.TraHangChiTiet;
import RepositoryImplement.TraHangChiTietRepositoryImpement;
import RepositoryInterface.TraHangChiTietRepositoryInteface;
import ServiceInterface.TraHangChiTietServiceInterface;
import ViewModel.QLTraHangCT;
import java.util.List;

/**
 *
 * @author Xuan Truong
 */
public class TraHangChiTietServiceImplement implements TraHangChiTietServiceInterface {

    private TraHangChiTietRepositoryInteface repo = new TraHangChiTietRepositoryImpement();

    @Override
    public Void themTraHang(TraHangChiTiet x) {
        return repo.theTraHangChiTiet(x);
    }

    @Override
    public List<QLTraHangCT> spTraNhieu() {
        return repo.spTraNhieu();
    }

}
