package DomainModel;

/**
 *
 * @author Xuan Truong
 */
public class TraHangChiTiet {

    private Integer maPhieuTraHang;
    private Integer maSach;
    private Integer soLuong;
    private Float donGia;

    public TraHangChiTiet() {
    }

    public TraHangChiTiet(Integer maSach, Integer soLuong, Float donGia) {
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public TraHangChiTiet(Integer maPhieuTraHang, Integer maSach, Integer soLuong, Float donGia) {
        this.maPhieuTraHang = maPhieuTraHang;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public Integer getMaPhieuTraHang() {
        return maPhieuTraHang;
    }

    public void setMaPhieuTraHang(Integer maPhieuTraHang) {
        this.maPhieuTraHang = maPhieuTraHang;
    }

    public Integer getMaSach() {
        return maSach;
    }

    public void setMaSach(Integer maSach) {
        this.maSach = maSach;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

}
