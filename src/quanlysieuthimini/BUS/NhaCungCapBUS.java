/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.BUS;

import java.util.ArrayList;
import quanlysieuthimini.DAO.NhaCungCapDAO;
import quanlysieuthimini.DTO.NhaCungCapDTO;

public class NhaCungCapBUS {
    private NhaCungCapDAO nhaCungCapDAL = new NhaCungCapDAO();
    
    public NhaCungCapBUS(){
    }
    
    public ArrayList<NhaCungCapDTO> getAll(){ 
        return nhaCungCapDAL.getAll();
    }
    
    public NhaCungCapDTO getById(int idNhaCungCap){ 
        return nhaCungCapDAL.getById(idNhaCungCap);
    }
    
    public ArrayList<NhaCungCapDTO> getByCondition(String condition){ 
        return nhaCungCapDAL.getByCondition(condition);
    }
    
    public boolean update(NhaCungCapDTO s) {
        return nhaCungCapDAL.update(s);
    }
    
    public int insert(NhaCungCapDTO s) {
        return nhaCungCapDAL.insert(s.getTenNCC(), s.getDiaChi(), s.getSDT(), s.getEmail());
    }
    
    public boolean delete(int maNhaCungCap) {
        return nhaCungCapDAL.delete(maNhaCungCap);
    }
}
