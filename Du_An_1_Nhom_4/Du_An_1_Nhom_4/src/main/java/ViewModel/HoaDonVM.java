package ViewModel;

import DomainModel.KhachHang;
import ServiceImplement.NhanVienServiceImpl;
import ServiceImplement.manageKhachHangService;
import ServiceInterface.ImanageKhachHangService;
import ServiceInterface.NhanVienService;
import java.io.Serializable;
import static java.sql.JDBCType.NULL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Xuan Truong
 */
public class HoaDonVM implements Serializable {

    private ImanageKhachHangService serviceKH = new manageKhachHangService();
    private NhanVienService serviceNV = new NhanVienServiceImpl();
    private List<QLKhachHang> listKhachHang = serviceKH.getAll();
    private ArrayList<NhanVienRespone> listNV = serviceNV.listNhanVien();

    public HoaDonVM(Integer maHoaDon, float tongTien, int soHD) {
        this.maHoaDon = maHoaDon;
        this.tongTien = tongTien;
        this.soHD = soHD;
    }

    public HoaDonVM(Integer maHoaDon, float tongTien, Integer trangThai) {
        this.maHoaDon = maHoaDon;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    private Integer maHoaDon;
    private Integer maKhachHang;
    private String tenKhachHang;
    private String tenNhanVien;
    private Integer maNhanVien;
    private Date ngayTao;
    private float tongTien;
    private Integer trangThai;
    private int soHD;


    public HoaDonVM(Integer maHoaDon, String tenKhachHang, String tenNhanVien, Date ngayTao, Integer trangThai) {
        this.maHoaDon = maHoaDon;
        this.tenKhachHang = tenKhachHang;
        this.tenNhanVien = tenNhanVien;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }


    public HoaDonVM(Integer maHoaDon, String tenKhachHang, String tenNhanVien, Date ngayTao, float tongTien, Integer trangThai) {
        this.maHoaDon = maHoaDon;
        this.tenKhachHang = tenKhachHang;
        this.tenNhanVien = tenNhanVien;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public HoaDonVM(Integer maHoaDon, String tenKhachHang, Integer maNhanVien, Date ngayTao, Integer trangThai) {
        this.maHoaDon = maHoaDon;
        this.tenKhachHang = tenKhachHang;
        this.maNhanVien = maNhanVien;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }


    public HoaDonVM(Integer maHoaDon, String tenKhachHang, String tenNhanVien, Date ngayTao, float tongTien) {
        this.maHoaDon = maHoaDon;
        this.tenKhachHang = tenKhachHang;
        this.tenNhanVien = tenNhanVien;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

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

    private String trangThaiHD() {
        if (this.trangThai == 0) {
            return "Đang Chờ";
        } else if (this.trangThai == 1) {
            return "Chưa Thanh Toán";
        } else {
            return "Đã Thanh Toán";
        }
    }

    private String tenNhanVien() {
        String tenNhanVien = "";
        for (NhanVienRespone x : listNV) {
            if (x.getMaNhanVien() == this.maNhanVien) {
                tenNhanVien = x.getTenNhanVien();
            }
        }
        return tenNhanVien;
    }

    private String tenKhachHang() {
        String tenKhachHang = "";
        for (QLKhachHang x : listKhachHang) {
            if (x.getMaKH() == this.maKhachHang) {
                tenKhachHang = x.getTenKH();
            }
        }
        return tenKhachHang;
    }

    public Object[] toDataRow1() {
        return new Object[]{maHoaDon, tenKhachHang, tenNhanVien, ngayTao};
    }

    public Object[] toDataRow4() {
        return new Object[]{maHoaDon, maKhachHang, tenNhanVien(), ngayTao, trangThaiHD()};
    }

    public Object[] toDataRow3() {
        return new Object[]{maHoaDon, tenKhachHang, tenNhanVien, ngayTao, trangThaiHD()};
    }

    public Object[] toDataRow2() {
        return new Object[]{maHoaDon, tenKhachHang, tenNhanVien, ngayTao, tongTien, trangThaiHD()};
    }

    public String inHoaDon() {
        return "Ma hoa don: " + this.maHoaDon + ", Ten khach hang: " + this.tenKhachHang + "Ma nhan vien: " + this.maNhanVien + ", ngay tao: " + this.ngayTao;
    }
}
