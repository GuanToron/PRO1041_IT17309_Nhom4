/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServiceInterface;

import DomainModel.Sach;
import ViewModel.SachVML;
import ViewModel.SachViewmodel;
import java.util.ArrayList;

/**
 *
 * @author dqv20
 */
public interface SachService {

    ArrayList<SachViewmodel> getlist();

    String add(Sach s);

    String update(Sach s, int ma);

    String delete(int ma);

    String capNhat(Integer maSach, Integer soLuong);

    String capNhatTheoTen(String tenSach, Integer soLuong);

    ArrayList<SachViewmodel> listSearch(ArrayList<SachViewmodel> list, String text);

    ArrayList<SachViewmodel> listLoc(ArrayList<SachViewmodel> list, String text);

    ArrayList<SachVML> listSach();

}
