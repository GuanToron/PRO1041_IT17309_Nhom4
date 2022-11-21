
package Service.Impl;

import Model.TacGia;
import Repository.TacGiaRepository;
import Service.TacGiaService;
import ViewModel.TacGiaViewmodel;
import java.util.ArrayList;


public class TacGiaServiceImpl implements TacGiaService{
    private TacGiaRepository tgrp = new TacGiaRepository();

    @Override
    public ArrayList<TacGiaViewmodel> getlist() {
        ArrayList<TacGia> tg = tgrp.getlist();
        ArrayList<TacGiaViewmodel> listviewmodel = new ArrayList<>();
        for (TacGia tgmd : tg) {
            TacGiaViewmodel tgvd = new TacGiaViewmodel(
            tgmd.getMaTG(),
            tgmd.getTenTG()
            );
            listviewmodel.add(tgvd);
        }
        return listviewmodel;
    }

    @Override
    public Boolean add(TacGia tg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(int ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean update(TacGia tl, int ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
