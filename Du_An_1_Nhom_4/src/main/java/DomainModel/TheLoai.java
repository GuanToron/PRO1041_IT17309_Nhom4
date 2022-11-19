/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

/**
 *
 * @author Xuan Truong
 */
public class TheLoai {

    private Integer maTheLoai;
    private String tenTheLoai;

    public TheLoai() {
    }

    public TheLoai(Integer maTheLoai, String tenTheLoai) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
    }

    public TheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public Integer getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(Integer maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

}
