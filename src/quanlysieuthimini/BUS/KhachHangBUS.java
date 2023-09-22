/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.BUS;

import java.util.ArrayList;
import quanlysieuthimini.DAO.KhachHangDAO;
import quanlysieuthimini.DTO.KhachHangDTO;

public class KhachHangBUS {
    
    private KhachHangDAO repo = new KhachHangDAO();
    
    public KhachHangBUS(){
        
    }
    
    public ArrayList<KhachHangDTO> getAll(){ 
        return repo.getAll();
    }
    
    public KhachHangDTO getById(int maKH){ 
        return repo.getById(maKH);
    }
    
    public ArrayList<KhachHangDTO> getByCondition(String condition, String value){ 
        return repo.getByCondition(condition + " LIKE '%" + value + "%'");
    }
 
    public boolean update(KhachHangDTO s) {
        return repo.update(s);
    }
    
    public boolean insert(KhachHangDTO s) {
        return repo.insert(s);
    }
    
    public boolean delete(int maKH) {
        return repo.delete(maKH);
    }
    
}
