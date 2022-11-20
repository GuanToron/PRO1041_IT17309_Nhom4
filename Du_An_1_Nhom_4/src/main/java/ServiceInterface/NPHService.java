package ServiceInterface;

import DomainModel.NPH;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface NPHService {

    ArrayList<NPH> listNPH();

    String themNPH(NPH x);

    String suaNPH(NPH x);

    String xoaNPH(NPH x);
}
