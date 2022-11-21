/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.NXB;
import ViewModel.NXBViewmodel;
import java.util.ArrayList;

/**
 *
 * @author ad
 */
public interface NXBService {

    public ArrayList<NXBViewmodel> getlist();

    public Boolean add(NXB nxb);

    public Boolean delete(int ma);

    public Boolean update(NXB nxb, int ma);
}
