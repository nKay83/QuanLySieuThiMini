/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.BUS;

import java.util.ArrayList;
import quanlysieuthimini.DAO.HinhThucThanhToanDAO;
import quanlysieuthimini.DTO.HinhThucThanhToanDTO;

public class HinhThucThanhToanBUS {
    
    private HinhThucThanhToanDAO hinhThucThanhToanDAO = new HinhThucThanhToanDAO();
    
    public HinhThucThanhToanBUS(){
        
    }
    
    public ArrayList<HinhThucThanhToanDTO> getAll(){ 
        return hinhThucThanhToanDAO.getAll();
    }
    
    public HinhThucThanhToanDTO getById(int maHTTT){ 
        return hinhThucThanhToanDAO.getById(maHTTT);
    }
    
    public ArrayList<HinhThucThanhToanDTO> getByCondition(String condition, String value){ 
        return hinhThucThanhToanDAO.getByCondition(condition + " LIKE '%" + value + "%'");
    }
 
    public boolean update(HinhThucThanhToanDTO s) {
        return hinhThucThanhToanDAO.update(s);
    }
    
    public boolean insert(HinhThucThanhToanDTO s) {
        return hinhThucThanhToanDAO.insert(s);
    }
    
    public boolean delete(int maHTTT) {
        return hinhThucThanhToanDAO.delete(maHTTT);
    }
    
}
