/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RepositoryInterface;

import DomainModel.KhachHang;
import ViewModel.QLKhachHang;
import java.util.List;

/**
 *
 * @author DELL 5515
 */
public interface IKhachHangResponsitory {

    List<QLKhachHang> getAll();

    Integer add(KhachHang kh);

    Integer delete(String maKH);

    Integer update(String maKH, KhachHang kh);

    Void updateDiem(String maKH, Integer diem);

    KhachHang timKhachHang(String SĐT);
    
    List<QLKhachHang> tongKH();
    
    List<KhachHang> timTen(String ten);
}
