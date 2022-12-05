package ViewModel;

/**
 *
 * @author Xuan Truong
 */
public class SachVML {

    private Integer maSach;
    private String tenSach;
    private String tenNPH;
    private Integer soLuong;

    public SachVML() {
    }

    public SachVML(Integer maSach, String tenSach, String tenNPH, Integer soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tenNPH = tenNPH;
        this.soLuong = soLuong;
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

    public String getTenNPH() {
        return tenNPH;
    }

    public void setTenNPH(String tenNPH) {
        this.tenNPH = tenNPH;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Object[] toDataRow() {
        return new Object[]{maSach, tenSach, tenNPH, soLuong};
    }
}
