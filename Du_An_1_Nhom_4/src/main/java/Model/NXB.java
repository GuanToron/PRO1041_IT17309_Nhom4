/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ad
 */
public class NXB {
   private int MaNXB ;
   private String TenNXB;

    public NXB() {
    }

    public NXB(int MaNXB, String TenNXB) {
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
