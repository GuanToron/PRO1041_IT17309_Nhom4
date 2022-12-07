package ViewModel;

import java.util.Date;

/**
 *
 * @author Xuan Truong
 */
public class SachVM {

    private Integer maHD;
    private Integer maSach;
    private String tenSach;

    private String namXB;
    private String ngonngu;
    private String nhomtuoi;
    private String taiban;
    private String soTrang;
    private Integer soLuong;
    private Float giaBan;
    private int trangthai;
    private int slBan;
    private double doanhthu;

    public SachVM() {
    }

    public SachVM(String tenSach) {
        this.tenSach = tenSach;
    }

    
    public SachVM(Integer maSach, String tenSach, Integer soLuong, Float giaBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public Integer getMaHD() {
        return maHD;
    }

    public void setMaHD(Integer maHD) {
        this.maHD = maHD;
    }

    public SachVM(String tenSach, Integer soLuong, Float giaBan) {
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public SachVM(Integer maHD, Integer maSach, String tenSach, String namXB, String ngonngu, String nhomtuoi, String taiban, String soTrang, Integer soLuong, Float giaBan, int trangthai, int slBan, double doanhthu) {
        this.maHD = maHD;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.namXB = namXB;
        this.ngonngu = ngonngu;
        this.nhomtuoi = nhomtuoi;
        this.taiban = taiban;
        this.soTrang = soTrang;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.trangthai = trangthai;
        this.slBan = slBan;
        this.doanhthu = doanhthu;
    }

   
    public String getNamXB() {
        return namXB;
    }

    public void setNamXB(String namXB) {
        this.namXB = namXB;
    }

    public String getNgonngu() {
        return ngonngu;
    }

    public void setNgonngu(String ngonngu) {
        this.ngonngu = ngonngu;
    }

    public String getNhomtuoi() {
        return nhomtuoi;
    }

    public void setNhomtuoi(String nhomtuoi) {
        this.nhomtuoi = nhomtuoi;
    }

    public String getTaiban() {
        return taiban;
    }

    public void setTaiban(String taiban) {
        this.taiban = taiban;
    }

    public String getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(String soTrang) {
        this.soTrang = soTrang;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getSlBan() {
        return slBan;
    }

    public void setSlBan(int slBan) {
        this.slBan = slBan;
    }

    public double getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(double doanhthu) {
        this.doanhthu = doanhthu;
    }

    public Integer getMaSach() {
        return maSach;
    }

    public void setMaSach(Integer maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Float giaBan) {
        this.giaBan = giaBan;
    }
}
