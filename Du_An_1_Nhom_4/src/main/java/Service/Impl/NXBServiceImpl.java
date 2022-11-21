
package Service.Impl;

import Model.NXB;
import Repository.NXBRepository;
import Service.NXBService;
import ViewModel.NXBViewmodel;
import java.util.ArrayList;


public class NXBServiceImpl implements NXBService{
    private NXBRepository nxbrp = new NXBRepository();   

    @Override
    public ArrayList<NXBViewmodel> getlist() {
        ArrayList<NXB> nxb = nxbrp.getlist();
        ArrayList<NXBViewmodel> listviewmodel = new ArrayList<>();
        for (NXB nXB : nxb) {
            NXBViewmodel nxbvd = new NXBViewmodel(
            nXB.getMaNXB(),
            nXB.getTenNXB()
            );
            listviewmodel.add(nxbvd);
        }
        return listviewmodel;
    }

    @Override
    public Boolean add(NXB nxb) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(int ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean update(NXB nxb, int ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
