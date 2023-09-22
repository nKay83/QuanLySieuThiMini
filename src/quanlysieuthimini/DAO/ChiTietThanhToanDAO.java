/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlysieuthimini.DTO.ChiTietThanhToanDTO;
import quanlysieuthimini.DAO.DAOInterface.DAOInterface;

public class ChiTietThanhToanDAO implements DAOInterface<ChiTietThanhToanDTO> {
    
    public static ChiTietThanhToanDAO getInstance() {
        return new ChiTietThanhToanDAO();
    }

    @Override
    public boolean insert(ChiTietThanhToanDTO t) {
        boolean result = false;
        int auto_id = -1;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into chitietthanhtoan "
                        + "(SoTien,NgayTT) "
                        + "VALUES (?,?)";
               
                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
                
                stmt.setDouble(1, t.getSoTien());
                stmt.setDate(2,java.sql.Date.valueOf(t.getNgayThanhToan()));

                result = stmt.executeUpdate()>=1;
                
                if (result) {
                    ResultSet rs = stmt.getGeneratedKeys();
                    rs.next();
                    auto_id = rs.getInt(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietThanhToanDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        return result;
    }

    @Override
    public boolean update(ChiTietThanhToanDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        
        if (connect != null) {
            try {
                String sql = "UPDATE chitietthanhtoan SET "
                        + "SoTien=?, NgayTT=?"
                        + "WHERE MaHD=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                
                stmt.setDouble(1, t.getSoTien());
                stmt.setDate(2, java.sql.Date.valueOf(t.getNgayThanhToan()));
                stmt.setInt(3, t.getMaHD());

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietThanhToanDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ChiTietThanhToanDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ChiTietThanhToanDTO> getByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }    

    @Override
    public ChiTietThanhToanDTO getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

    

