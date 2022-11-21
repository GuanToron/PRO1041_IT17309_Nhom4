/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author ad
 */
public class TacGiaViewmodel {
    private int MaTG ;
    private String TenTG;

    public TacGiaViewmodel() {
    }

    public TacGiaViewmodel(int MaTG, String TenTG) {
        this.MaTG = MaTG;
        this.TenTG = TenTG;
    }

    public int getMaTG() {
        return MaTG;
    }

    public void setMaTG(int MaTG) {
        this.MaTG = MaTG;
    }

    public String getTenTG() {
        return TenTG;
    }

    public void setTenTG(String TenTG) {
        this.TenTG = TenTG;
    }
    
}
