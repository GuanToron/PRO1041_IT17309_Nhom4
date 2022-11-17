/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Model.TheLoai;
import Repository.theloaiRepository;
import Service.TheloaiService;
import java.util.ArrayList;

/**
 *
 * @author dqv20
 */
public class TheloaiServiceImpl implements TheloaiService{
    private theloaiRepository cc = new theloaiRepository();

    @Override
    public ArrayList<TheLoai> getlist() {
        return cc.getlist();
    }

    @Override
    public Boolean add(TheLoai tl) {
   cc.add(tl);
   return true;
   
    }

    @Override
    public Boolean delete(int ma) {
   cc.delete(ma);
   return true;
    }

    @Override
    public Boolean update(TheLoai tl, int ma) {
    cc.update(tl, ma);
    return true;
    }
    
}
