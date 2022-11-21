/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author dqv20
 */
public class Sach {

    private Integer masach;
    private String tensach;
    private DanhMuc maDanhMuc;
    private TheLoai maTheLoai;
    private NPH maNPH;
    private TacGia maTacGia;
    private NXB maNXB;
    private String namxuatban;
    private String ngonNgu;
    private String nhomTuoi;
    private Integer taiBan;
    private Integer sotrang;
    private Float giaban;
    private Integer soluong;
    private Integer trangthai;

    public Sach() {
    }

    public Sach(Integer masach, String tensach, DanhMuc maDanhMuc, TheLoai maTheLoai, NPH maNPH, TacGia maTacGia, NXB maNXB, String namxuatban, String ngonNgu, String nhomTuoi, Integer taiBan, Integer sotrang, Float giaban, Integer soluong, Integer trangthai) {
        this.masach = masach;
        this.tensach = tensach;
        this.maDanhMuc = maDanhMuc;
        this.maTheLoai = maTheLoai;
        this.maNPH = maNPH;
        this.maTacGia = maTacGia;
        this.maNXB = maNXB;
        this.namxuatban = namxuatban;
        this.ngonNgu = ngonNgu;
        this.nhomTuoi = nhomTuoi;
        this.taiBan = taiBan;
        this.sotrang = sotrang;
        this.giaban = giaban;
        this.soluong = soluong;
        this.trangthai = trangthai;
    }

    public Integer getMasach() {
        return masach;
    }

    public void setMasach(Integer masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public DanhMuc getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(DanhMuc maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public TheLoai getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(TheLoai maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public NPH getMaNPH() {
        return maNPH;
    }

    public void setMaNPH(NPH maNPH) {
        this.maNPH = maNPH;
    }

    public TacGia getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(TacGia maTacGia) {
        this.maTacGia = maTacGia;
    }

    public NXB getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(NXB maNXB) {
        this.maNXB = maNXB;
    }

    public String getNamxuatban() {
        return namxuatban;
    }

    public void setNamxuatban(String namxuatban) {
        this.namxuatban = namxuatban;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getNhomTuoi() {
        return nhomTuoi;
    }

    public void setNhomTuoi(String nhomTuoi) {
        this.nhomTuoi = nhomTuoi;
    }

    public Integer getTaiBan() {
        return taiBan;
    }

    public void setTaiBan(Integer taiBan) {
        this.taiBan = taiBan;
    }

    public Integer getSotrang() {
        return sotrang;
    }

    public void setSotrang(Integer sotrang) {
        this.sotrang = sotrang;
    }

    public Float getGiaban() {
        return giaban;
    }

    public void setGiaban(Float giaban) {
        this.giaban = giaban;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Integer getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Integer trangthai) {
        this.trangthai = trangthai;
    }

}
