/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author Long
 */
public class QLTraHang {

    private Integer maPTH;
    private Integer maHD;
    private Integer maKH;
    private Integer maNV;
    private Date ngayTra;
    private Float tienTraLai;
    private String lyDo;

    private int tongPTH;
    private String spTraNhieu;
    public QLTraHang() {
    }

    
    public QLTraHang(Integer maPTH, Integer maHD, Integer maKH, Integer maNV, Date ngayTra, Float tienTraLai, String lyDo) {
        this.maPTH = maPTH;
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayTra = ngayTra;
        this.tienTraLai = tienTraLai;
        this.lyDo = lyDo;
    }

    public QLTraHang(int tongPTH) {
        this.tongPTH = tongPTH;
    }

    public QLTraHang(String spTraNhieu) {
        this.spTraNhieu = spTraNhieu;
    }

    public int getTongPTH() {
        return tongPTH;
    }

    public void setTongPTH(int tongPTH) {
        this.tongPTH = tongPTH;
    }

    public String getSpTraNhieu() {
        return spTraNhieu;
    }

    public void setSpTraNhieu(String spTraNhieu) {
        this.spTraNhieu = spTraNhieu;
    }

    
    
    public Integer getMaPTH() {
        return maPTH;
    }

    public void setMaPTH(Integer maPTH) {
        this.maPTH = maPTH;
    }

    public Integer getMaHD() {
        return maHD;
    }

    public void setMaHD(Integer maHD) {
        this.maHD = maHD;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Float getTienTraLai() {
        return tienTraLai;
    }

    public void setTienTraLai(Float tienTraLai) {
        this.tienTraLai = tienTraLai;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

   

    public Object[] toDataRow() {
        return new Object[]{maPTH, maHD, maKH, maNV, ngayTra, tienTraLai, lyDo};
    }

}
