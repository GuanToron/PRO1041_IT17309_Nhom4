/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RepositoryInterface;

import DomainModel.SanPhamLoi;
import ViewModel.QLSanPhamLoi;
import java.util.List;

/**
 *
 * @author DELL 5515
 */
public interface ISanPhamLoiRepository {

    List<QLSanPhamLoi> getAll();

    Boolean add(SanPhamLoi sp);

    Integer delete(String maspl);

    Boolean update(String maspl, SanPhamLoi sp);
}
