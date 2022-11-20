/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImplement;

import DomainModel.Sach;
import RepositoryImplement.sachRepository;
import ServiceInterface.SachService;
import ViewModel.SachViewmodel;
import java.util.ArrayList;

/**
 *
 * @author dqv20
 */
public class SachserviceImpl implements SachService {

    private sachRepository cc = new sachRepository();

    @Override
    public ArrayList<SachViewmodel> getlist() {
        return cc.getlist();
    }

    @Override
    public String add(Sach s) {
        if (s.getGiaban().toString().isBlank() || s.getNamxuatban().isBlank() || s.getNgonNgu().isBlank() || s.getNhomTuoi().isBlank() || s.getSoluong().toString().isBlank() || s.getSotrang().toString().isBlank() || s.getTaiBan().toString().isBlank() || s.getTensach().isBlank()) {
            return "Con tron du lieu";
        }
        String regex = "^[a-zA-Z]*$";
        if (!s.getTensach().matches(regex)) {
            return "Ten sach sai dinh dang";
        }
        try {
            Integer soLuong = s.getSoluong();
            if (soLuong <= 0) {
                return "So luong phai lon hon 0";
            }
        } catch (Exception e) {
            return "So luong phai la so";
        }
        try {
            Integer soTrang = s.getSotrang();
            if (soTrang <= 0) {
                return "So trang phai lon hon 0";
            }
        } catch (Exception e) {
            return "So trang phai la so";
        }
        try {
            Integer soTaiBan = s.getTaiBan();
            if (soTaiBan <= 0) {
                return "So tai ban phai lon hon 0";
            }
        } catch (Exception e) {
            return "So tai ban phai la so";
        }
        try {
            Integer namXuatBan = Integer.parseInt(s.getNamxuatban());
            if (namXuatBan <= 0) {
                return "Nam xuat ban phai lon hon 0";
            }
            if (namXuatBan > 2022) {
                return "Nam xuat ban phai nho hon 2022";
            }
        } catch (Exception e) {
            return "Nam xuat ban phai la so";
        }
        try {
            Float giaBan = s.getGiaban();
            if (0 > giaBan) {
                return "Gia ban phai lon hon 0";
            }
        } catch (Exception e) {
            return "Gia ban phai la so";
        }
        boolean them = cc.add(s);
        if (them) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String update(Sach s, int ma) {
        if (s.getGiaban().toString().isBlank() || s.getNamxuatban().isBlank() || s.getNgonNgu().isBlank() || s.getNhomTuoi().isBlank() || s.getSoluong().toString().isBlank() || s.getSotrang().toString().isBlank() || s.getTaiBan().toString().isBlank() || s.getTensach().isBlank()) {
            return "Con tron du lieu";
        }
        String regex = "^[a-zA-Z]*$";
        if (!s.getTensach().matches(regex)) {
            return "Ten sach sai dinh dang";
        }
        try {
            Integer soLuong = s.getSoluong();
            if (soLuong <= 0) {
                return "So luong phai lon hon 0";
            }
        } catch (Exception e) {
            return "So luong phai la so";
        }
        try {
            Integer soTrang = s.getSotrang();
            if (soTrang <= 0) {
                return "So trang phai lon hon 0";
            }
        } catch (Exception e) {
            return "So trang phai la so";
        }
        try {
            Integer soTaiBan = s.getTaiBan();
            if (soTaiBan <= 0) {
                return "So tai ban phai lon hon 0";
            }
        } catch (Exception e) {
            return "So tai ban phai la so";
        }
        try {
            Integer namXuatBan = Integer.parseInt(s.getNamxuatban());
            if (namXuatBan <= 0) {
                return "Nam xuat ban phai lon hon 0";
            }
            if (namXuatBan > 2022) {
                return "Nam xuat ban phai nho hon 2022";
            }
        } catch (Exception e) {
            return "Nam xuat ban phai la so";
        }
        try {
            Float giaBan = s.getGiaban();
            if (0 > giaBan) {
                return "Gia ban phai lon hon 0";
            }
        } catch (Exception e) {
            return "Gia ban phai la so";
        }
        boolean sua = cc.update(s, ma);
        if (sua) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String delete(int ma) {
        boolean xoa = cc.delete(ma);
        if (xoa) {
            return "Thanh cong";
        }
        return "That bai";
    }

}
