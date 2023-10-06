/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.BUS;

import java.util.ArrayList;
import quanlysieuthimini.DAO.ChiTietQuyenDAO;
import quanlysieuthimini.DTO.ChiTietQuyenDTO;

public class ChiTietQuyenBUS {
    private ChiTietQuyenDAO dao = new ChiTietQuyenDAO();

    public ChiTietQuyenBUS(){} //constructor

    public ArrayList<ChiTietQuyenDTO>getAll(){
        return  dao.getAll();
    }
    public ChiTietQuyenDTO getById(int id){
        return  dao.getById(id);
    }
    public ChiTietQuyenDTO getByMaCN(int id){
        return  dao.getByMaCN(id);
    }
    public ArrayList<ChiTietQuyenDTO>getBycondition(String cond){
        return dao.getByCondition(cond);
    }
    public boolean update(ChiTietQuyenDTO user){
        return dao.update(user);
    }
    public boolean insert(ChiTietQuyenDTO user){
        return dao.insert(user);
    }
    public boolean delete(int id){
        return dao.delete(id);
    }
}
