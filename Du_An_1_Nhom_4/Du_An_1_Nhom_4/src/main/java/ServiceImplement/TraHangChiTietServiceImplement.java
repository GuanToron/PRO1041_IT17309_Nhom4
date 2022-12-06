package ServiceImplement;

import DomainModel.TraHangChiTiet;
import RepositoryImplement.TraHangChiTietRepositoryImpement;
import RepositoryInterface.TraHangChiTietRepositoryInteface;
import ServiceInterface.TraHangChiTietServiceInterface;

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

}
