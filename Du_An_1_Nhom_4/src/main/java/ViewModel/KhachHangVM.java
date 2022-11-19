package ViewModel;

import java.util.Date;

/**
 *
 * @author Xuan Truong
 */
public class KhachHangVM {

    private Integer MaKH;
    private String tenKH;
    private Integer gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String SDT;
    private Integer diemTichLuy;

    public KhachHangVM() {
    }

    public KhachHangVM(Integer MaKH, String tenKH, Integer gioiTinh, String ngaySinh, String diaChi, String SDT, Integer diemTichLuy) {
        this.MaKH = MaKH;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.diemTichLuy = diemTichLuy;
    }

    public Integer getMaKH() {
        return MaKH;
    }

    public void setMaKH(Integer MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Integer getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(Integer diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public Object[] toDataRow() {
        return new Object[]{MaKH, tenKH, gioiTinh == 1 ? "Nam" : "Nữ", ngaySinh, diaChi, SDT, diemTichLuy};
    }
}
