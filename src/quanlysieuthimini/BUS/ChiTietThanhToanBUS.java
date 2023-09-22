/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.BUS;

import java.util.ArrayList;
import quanlysieuthimini.DAO.ChiTietThanhToanDAO;
import quanlysieuthimini.DTO.ChiTietThanhToanDTO;

public class ChiTietThanhToanBUS {
    private ChiTietThanhToanDAO chiTietThanhToanDAO = new ChiTietThanhToanDAO();
    
    public ChiTietThanhToanBUS(){
        
    }
    
    public ArrayList<ChiTietThanhToanDTO> getAll(){ 
        return null;
    }
    
    public ChiTietThanhToanDTO getById(int id){ 
        return null;
    }
    
    public ArrayList<ChiTietThanhToanDTO> getByCondition(String condition, String value){ 
        return null;
    }
 
    public boolean update(ChiTietThanhToanDTO s) {
        return chiTietThanhToanDAO.update(s);
    }
    
    public boolean insert(ChiTietThanhToanDTO s) {
        return chiTietThanhToanDAO.insert(s);
    }
    
    public boolean delete(int mahd, int mahttt) {
        return false;
    }
}
