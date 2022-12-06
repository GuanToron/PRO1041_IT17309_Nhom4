/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RepositoryInterface;

import ViewModel.QLTraHang;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Long
 */
public interface TraHangResponInterface {

    ArrayList<QLTraHang> listQLTH();

    Boolean taoPTH(QLTraHang x);
    
    Boolean capNhatPTH(QLTraHang x);
}
