/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.Sach;
import RepositoryImplement.sachRepository;
import ServiceInterface.SachService;
import ViewModel.SachViewmodel;
import java.util.ArrayList;

/**
 *
 * @author dqv20
 */
public class SachserviceImpl  implements SachService{
    private sachRepository cc = new sachRepository();

    @Override
    public ArrayList<SachViewmodel> getlist() {
        ArrayList<Sach> ds = cc.getlist();
        ArrayList<SachViewmodel> listviewmodel = new ArrayList<>();
        for (Sach s : ds) {
            SachViewmodel ss = new SachViewmodel(
            s.getMasach(),
            s.getTensach(),
                    s.getMadm(),
                    s.getMatl(),
                    s.getManph(),
                    s.getMatg(),
                    s.getNamxuatban(),
                    s.getNgonngu(),
                    s.getNhomtuoi(),
                    s.getTaiban(),
                    s.getSotrang(),
                    s.getGiaban(),
                    s.getSoluong(),
                    s.getTrangthai()
            );
            listviewmodel.add(ss);
            
        }
        return listviewmodel;
        
    }

    @Override
    public Boolean add(Sach s) {
        cc.add(s);
        return true;
    }

    @Override
    public Boolean update(Sach s, int ma) {
    cc.update(s, ma);
    return true;
    
    }

    @Override
    public Boolean delete(int ma) {
    cc.delete(ma);
    return true;
    }
    
}
