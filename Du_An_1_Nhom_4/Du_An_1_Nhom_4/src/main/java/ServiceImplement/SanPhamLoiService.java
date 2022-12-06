/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImplement;

import DomainModel.SanPhamLoi;
import RepositoryInterface.ISanPhamLoiRepository;
import RepositoryImplement.SanPhamLoiRepository;
import ServiceInterface.ImanageSanPhamLoiService;
import ViewModel.QLSanPhamLoi;
import java.util.List;

/**
 *
 * @author DELL 5515
 */
public class SanPhamLoiService implements ImanageSanPhamLoiService {

    private final ISanPhamLoiRepository iSanPhamLoiRepository;

    public SanPhamLoiService() {
        this.iSanPhamLoiRepository = new SanPhamLoiRepository();
    }

    @Override
    public List<QLSanPhamLoi> getAll() {
        return iSanPhamLoiRepository.getAll();
    }

    @Override
    public String add(SanPhamLoi sp) {
        if (sp.getLyDoDoi().isBlank()) {
            return "Con trong du lieu";
        }
        String regexSo = "^[0-9]*$";
        if (!String.valueOf(sp.getSoLuong()).matches(regexSo)) {
            return "So luong phai la so";
        }
        if (sp.getSoLuong() <= 0) {
            return "So luong phai lon hon 0";
        }
        String regexChu = "^[a-zA-Z]*$";
        if (!sp.getLyDoDoi().matches(regexChu)) {
            return "Ly do doi phai la chu(Khong dau)";
        }
        boolean add = iSanPhamLoiRepository.add(sp);
        if (add) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public Integer delete(String maspl) {
        return iSanPhamLoiRepository.delete(maspl);
        
    }

    @Override
    public String update(String maspl, SanPhamLoi sp) {
        boolean update = iSanPhamLoiRepository.update(maspl, sp);
        if (update) {
            return "Thanh cong";
        }
        return "That bai";
    }

}
