/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.BUS;

import java.util.ArrayList;
import quanlysieuthimini.DAO.LoaiSanPhamDAO;
import quanlysieuthimini.DTO.LoaiSanPhamDTO;

public class LoaiSanPhamBUS {
    private LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
    
    public LoaiSanPhamBUS() {
        
    }
    
    public ArrayList<LoaiSanPhamDTO> getAllSach(){ 
        return loaiSanPhamDAO.getAll();
    }
    
    public LoaiSanPhamDTO getById(int id){ 
        return loaiSanPhamDAO.getById(id);
    }
    
    public ArrayList<LoaiSanPhamDTO> getByCondition(String condition, String value){ 
        return loaiSanPhamDAO.getByCondition(condition + " LIKE '%" + value + "%'");
    }
 
    public boolean update(LoaiSanPhamDTO s) {
        return loaiSanPhamDAO.update(s);
    }
    
    public int insert(LoaiSanPhamDTO s) {
        return loaiSanPhamDAO.insert(s.getTenLoai(), s.getCachBaoQuan(), s.getMoTa());
    }
    
    public boolean delete(int maLoai) {
        return loaiSanPhamDAO.delete(maLoai);
    }    
}
