package ServiceInterface;

import java.util.ArrayList;



import ViewModel.QLTraHang;

/**
 *
 * @author Xuan Truong
 */
public interface TraHangServiceInterface {

    ArrayList<QLTraHang> listTraHang();

    String themPTH(QLTraHang x);

    String xoaPTH(String MaPTH);

    String suaPTH(QLTraHang x,String MaPTH);

}
