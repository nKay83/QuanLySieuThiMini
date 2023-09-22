/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.BUS;

import java.util.ArrayList;
import quanlysieuthimini.DAO.PhieuGiaoCaDAO;
import quanlysieuthimini.DTO.PhieuGiaoCaDTO;

public class PhieuGiaoCaBUS {
    private PhieuGiaoCaDAO phieuGiaoCaDAO = new PhieuGiaoCaDAO();
    
    public PhieuGiaoCaBUS(){
        
    }
    
    public ArrayList<PhieuGiaoCaDTO> getAll(){ 
        return phieuGiaoCaDAO.getAll();
    }
    
    public PhieuGiaoCaDTO getById(int maPGC){ 
        return phieuGiaoCaDAO.getById(maPGC);
    }
    
    public ArrayList<PhieuGiaoCaDTO> getByCondition(String condition, String value){ 
        return null;
    }
 
    public boolean update(PhieuGiaoCaDTO s) {
        return phieuGiaoCaDAO.update(s);
    }
    
    public boolean insert(PhieuGiaoCaDTO s) {
        return phieuGiaoCaDAO.insert(s);
    }
    
    public boolean delete(int maPGC) {
        return false;
    }
}
