/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.BUS;

import java.util.ArrayList;
import quanlysieuthimini.DAO.DonViTinhDAO;
import quanlysieuthimini.DTO.DonViTinhDTO;

public class DonViTinhBUS {
    private DonViTinhDAO donViTinhDAO = new DonViTinhDAO();
    
    public DonViTinhBUS() {
        
    }
    
    public ArrayList<DonViTinhDTO> getAll(){ 
        return donViTinhDAO.getAll();
    }
    
    public DonViTinhDTO getById(int id){ 
        return donViTinhDAO.getById(id);
    }
    
    public ArrayList<DonViTinhDTO> getByCondition(String condition, String value){ 
        return donViTinhDAO.getByCondition(condition + " LIKE '%" + value + "%'");
    }
 
    public boolean update(DonViTinhDTO s) {
        return donViTinhDAO.update(s);
    }
    
    public int insert(DonViTinhDTO s) {
        return donViTinhDAO.insert(s.getTenDV());
    }
    
    public boolean delete(int maDV) {
        return donViTinhDAO.delete(maDV);
    }
}
