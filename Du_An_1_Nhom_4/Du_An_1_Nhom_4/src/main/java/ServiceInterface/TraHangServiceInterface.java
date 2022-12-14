package ServiceInterface;

import java.util.ArrayList;



import ViewModel.QLTraHang;
import java.util.List;

/**
 *
 * @author Xuan Truong
 */
public interface TraHangServiceInterface {

    ArrayList<QLTraHang> listTraHang();

    String themPTH(QLTraHang x);

    String xoaPTH(String MaPTH);

    String suaPTH(QLTraHang x,String MaPTH);
    
    List<QLTraHang> tongSP();

}
