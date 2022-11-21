/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.TacGia;
import ViewModel.TacGiaViewmodel;
import java.util.ArrayList;

public interface TacGiaService {

    public ArrayList<TacGiaViewmodel> getlist();

    public Boolean add(TacGia tg);

    public Boolean delete(int ma);

    public Boolean update(TacGia tl, int ma);
}
