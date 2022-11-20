/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServiceInterface;

import DomainModel.TheLoai;
import java.util.ArrayList;

/**
 *
 * @author dqv20
 */
public interface TheloaiService {
     public ArrayList<TheLoai> getlist();
       public Boolean add(TheLoai tl);
         public Boolean delete(int ma);
          public Boolean update(TheLoai tl ,int ma);
    
}
