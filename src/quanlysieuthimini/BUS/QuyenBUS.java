/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.BUS;

import java.util.ArrayList;
import quanlysieuthimini.DAO.QuyenDAO;
import quanlysieuthimini.DTO.QuyenDTO;

/**
 *
 * @author domin
 */
public class QuyenBUS {
    private QuyenDAO dao = new QuyenDAO();

    public QuyenBUS(){} //constructor

    public ArrayList<QuyenDTO>getAll(){
        return  dao.getAll();
    }
    public QuyenDTO getById(int id){
        return  dao.getById(id);
    }
    public ArrayList<QuyenDTO>getBycondition(String cond){
        return dao.getByCondition(cond);
    }
    public boolean update(QuyenDTO user){
        return dao.update(user);
    }
    public boolean insert(QuyenDTO user){
        return dao.insert(user);
    }
    public boolean delete(int id){
        return dao.delete(id);
    }
}
