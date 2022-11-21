/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author ad
 */
public class NXBViewmodel {
     private int MaNXB ;
   private String TenNXB;

    public NXBViewmodel() {
    }

    public NXBViewmodel(int MaNXB, String TenNXB) {
        this.MaNXB = MaNXB;
        this.TenNXB = TenNXB;
    }

    public int getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(int MaNXB) {
        this.MaNXB = MaNXB;
    }

    public String getTenNXB() {
        return TenNXB;
    }

    public void setTenNXB(String TenNXB) {
        this.TenNXB = TenNXB;
    }
   
}
