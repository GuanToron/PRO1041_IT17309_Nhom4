package DomainModel;

/**
 *
 * @author Xuan Truong
 */
public class TacGia {

    private Integer maTacGia;
    private String tenTacGia;

    public TacGia() {
    }

    public TacGia(Integer maTacGia, String tenTacGia) {
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
    }

    public TacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public Integer getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(Integer maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

}
