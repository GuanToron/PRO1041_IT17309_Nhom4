package RepositoryInterface;

import DomainModel.ChucVu;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface CVRepositoryInterface {

    ArrayList<ChucVu> listCV();

    Boolean themCV(ChucVu x);

    Boolean suaCV(ChucVu x);

    Boolean xoaCV(ChucVu x);
}
