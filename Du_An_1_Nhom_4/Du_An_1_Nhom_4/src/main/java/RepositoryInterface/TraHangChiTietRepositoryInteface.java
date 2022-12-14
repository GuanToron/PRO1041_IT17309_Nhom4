package RepositoryInterface;

import DomainModel.TraHangChiTiet;
import ViewModel.QLTraHang;
import ViewModel.QLTraHangCT;
import java.util.List;

/**
 *
 * @author Xuan Truong
 */
public interface TraHangChiTietRepositoryInteface {

    Void theTraHangChiTiet(TraHangChiTiet x);
    
    List<QLTraHangCT> spTraNhieu();
}
