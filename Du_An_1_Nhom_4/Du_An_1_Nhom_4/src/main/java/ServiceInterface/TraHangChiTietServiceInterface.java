package ServiceInterface;

import DomainModel.TraHangChiTiet;
import ViewModel.QLTraHangCT;
import java.util.List;

/**
 *
 * @author Xuan Truong
 */
public interface TraHangChiTietServiceInterface {

    Void themTraHang(TraHangChiTiet x);
    List<QLTraHangCT> spTraNhieu();
}
