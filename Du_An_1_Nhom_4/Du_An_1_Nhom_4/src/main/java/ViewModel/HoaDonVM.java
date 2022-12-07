package ViewModel;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Xuan Truong
 */
public class HoaDonVM implements Serializable{

    private Integer maHoaDon;
    private Integer maKhachHang;
    private Integer maNhanVien;
    private Date ngayTao;
    private float tongTien;
    private Integer trangThai;

    private int soHD;
    public HoaDonVM() {
    }

    public HoaDonVM(Integer maHoaDon, Integer trangThai) {
        this.maHoaDon = maHoaDon;
        this.trangThai = trangThai;
    }

    public HoaDonVM(int soHD) {
        this.soHD = soHD;
    }

    
    public HoaDonVM(Integer maHoaDon, Integer maKhachHang, Integer maNhanVien, Date ngayTao, float tongTien, Integer trangThai) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public HoaDonVM(float tongTien) {
        this.tongTien = tongTien;
    }

    public HoaDonVM(Date ngayTao, float tongTien) {
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
    }

    public int getSoHD() {
        return soHD;
    }

    public void setSoHD(int soHD) {
        this.soHD = soHD;
    }

    
    public Integer getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Integer getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(Integer maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public Integer getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(Integer maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public HoaDonVM(Integer maHoaDon, Integer maKhachHang, Integer maNhanVien, Date ngayTao, Integer trangThai) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public HoaDonVM(Integer maHoaDon, Integer maKhachHang, float tongTien, Integer trangThai) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public Object[] toDataRow() {
        return new Object[]{maHoaDon, maKhachHang, maNhanVien, ngayTao, trangThai == 0 ? "Đang chờ" : "Chưa thanh toán"};
    }
}
