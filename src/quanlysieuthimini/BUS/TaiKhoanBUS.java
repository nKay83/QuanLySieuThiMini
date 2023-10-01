/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.BUS;
import quanlysieuthimini.DAO.TaiKhoanDAO;
import quanlysieuthimini.DTO.TaiKhoanDTO;
import java.util.ArrayList;
/**
 *
 * @author dinmo
 */
public class TaiKhoanBUS {
    private TaiKhoanDAO dao = new TaiKhoanDAO();

    public TaiKhoanBUS(){} //constructor

    public TaiKhoanDTO login(String username, String pass){
        return dao.login(username, pass);
    }
    public ArrayList<TaiKhoanDTO>getAll(){
        return  dao.getAll();
    }
    public TaiKhoanDTO getById(int id){
        return  dao.getById(id);
    }
    public ArrayList<TaiKhoanDTO>getBycondition(String cond){
        return dao.getByCondition(cond);
    }
    public boolean update(TaiKhoanDTO user){
        return dao.update(user);
    }
    public boolean insert(TaiKhoanDTO user){
        return dao.insert(user);
    }
    public boolean delete(int id){
        return dao.delete(id);
    }
}
