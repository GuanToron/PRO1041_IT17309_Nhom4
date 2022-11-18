/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Sach;
import ViewModel.SachViewmodel;
import java.util.ArrayList;

/**
 *
 * @author dqv20
 */
public interface SachService {
     public ArrayList<SachViewmodel> getlist() ;
     public Boolean add(Sach s);
      public Boolean update(Sach s ,int ma);
      public Boolean delete(int ma);
    
}
