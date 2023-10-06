/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.BUS;

import java.util.ArrayList;
import quanlysieuthimini.DAO.ChucNangDAO;
import quanlysieuthimini.DTO.ChucNangDTO;

public class ChucNangBUS {
    private ChucNangDAO dao = new ChucNangDAO();

    public ChucNangBUS(){} //constructor

    public ArrayList<ChucNangDTO>getAll(){
        return  dao.getAll();
    }
    public ChucNangDTO getById(int id){
        return  dao.getById(id);
    }
    public ArrayList<ChucNangDTO>getBycondition(String cond){
        return dao.getByCondition(cond);
    }
    public boolean update(ChucNangDTO user){
        return dao.update(user);
    }
    public boolean insert(ChucNangDTO user){
        return dao.insert(user);
    }
    public boolean delete(int id){
        return dao.delete(id);
    }
}
