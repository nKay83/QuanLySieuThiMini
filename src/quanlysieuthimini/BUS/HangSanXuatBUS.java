/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.BUS;

import java.util.ArrayList;
import quanlysieuthimini.DAO.HangSanXuatDAO;
import quanlysieuthimini.DTO.HangSanXuatDTO;

public class HangSanXuatBUS {
    private HangSanXuatDAO hangSanXuatDAO = new HangSanXuatDAO();
    
    public HangSanXuatBUS() {
        
    }
    
    public ArrayList<HangSanXuatDTO> getAllSach(){ 
        return hangSanXuatDAO.getAll();
    }
    
    public HangSanXuatDTO getById(int id){ 
        return hangSanXuatDAO.getById(id);
    }
    
    public ArrayList<HangSanXuatDTO> getByCondition(String condition, String value){ 
        return hangSanXuatDAO.getByCondition(condition + " LIKE '%" + value + "%'");
    }
 
    public boolean update(HangSanXuatDTO s) {
        return hangSanXuatDAO.update(s);
    }
    
    public int insert(HangSanXuatDTO s) {
        return hangSanXuatDAO.insert(s.getTenHang());
    }
    
    public boolean delete(int maHH) {
        return hangSanXuatDAO.delete(maHH);
    }
}
