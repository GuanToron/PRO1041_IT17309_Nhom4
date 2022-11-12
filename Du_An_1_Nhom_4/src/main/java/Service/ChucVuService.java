package Service;

import java.util.ArrayList;
import Model.ChucVu;

/**
 *
 * @author Xuan Truong
 */
public interface ChucVuService {

    ArrayList<ChucVu> listChucVu();

    String themChucVu(ChucVu x);

    String xoaChucVu(ChucVu x);

    String suaChucVu(ChucVu x);
}
