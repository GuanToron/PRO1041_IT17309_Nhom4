/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImplement;

import DomainModel.KhachHang;
import RepositoryInterface.IKhachHangResponsitory;
import RepositoryImplement.KhachHangResponsitory;
import ServiceInterface.ImanageKhachHangService;
import ViewModel.QLKhachHang;
import java.util.List;

/**
 *
 * @author DELL 5515
 */
public class manageKhachHangService implements ImanageKhachHangService{

    private final IKhachHangResponsitory iKhachHangResponsitory;

    public manageKhachHangService() {
        this.iKhachHangResponsitory = new KhachHangResponsitory();
    }
    
    @Override
    public List<QLKhachHang> getAll() {
     return iKhachHangResponsitory.getAll();
    }

    @Override
    public Integer add(KhachHang kh) {
     return iKhachHangResponsitory.add(kh);
    }

    @Override
    public Integer delete(String maKH) {
     return iKhachHangResponsitory.delete(maKH);
    }

    @Override
    public Integer update(String maKH, KhachHang kh) {
     return iKhachHangResponsitory.update(maKH, kh);
    }

    @Override
    public List<QLKhachHang> getListSearch(String tenKH) {
      return iKhachHangResponsitory.getListSearch(tenKH);
    }
    
}
