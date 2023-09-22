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
import quanlysieuthimini.DAO.DAOInterface.DAOInterface;
import quanlysieuthimini.DTO.HinhThucThanhToanDTO;

public class HinhThucThanhToanDAO implements DAOInterface<HinhThucThanhToanDTO>{
    
    public static HinhThucThanhToanDAO getInstance(){
        return new HinhThucThanhToanDAO();
    }

    @Override
    public boolean insert(HinhThucThanhToanDTO t) {
        boolean result = false;
        int auto_id = -1;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into hinhthucthanhtoan "
                        + "(TenHTTT) "
                        + "VALUES (?)";
               
                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
                
                stmt.setString(1,"TenHTTT");

                result = stmt.executeUpdate()>=1;
                
                if (result) {
                    ResultSet rs = stmt.getGeneratedKeys();
                    rs.next();
                    auto_id = rs.getInt(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(HinhThucThanhToanDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        return result;
    }

    @Override
    public boolean update(HinhThucThanhToanDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        
        if (connect != null) {
            try {
                String sql = "UPDATE hinhthucthanhtoan SET "
                        + "TenHTTT=?"
                        + "WHERE MaHTTT=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                
                stmt.setString(1, t.getTenHTTT());
                stmt.setInt(2, t.getMaHTTT());
                

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(HinhThucThanhToanDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "UPDATE hinhthucthanhtoan SET TrangThai = 0 "
                        + "WHERE MaHTTT=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setInt(1, id); 

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(HinhThucThanhToanDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<HinhThucThanhToanDTO> getAll() {
        ArrayList<HinhThucThanhToanDTO> result = new ArrayList<>();
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM hinhthucthanhtoan WHERE TrangThai = 1";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maHTTT = rs.getInt("MaHTTT");
                    String tenHTTT = rs.getString("TenHTTT");
                    
                    
                    HinhThucThanhToanDTO s = new HinhThucThanhToanDTO(maHTTT,   tenHTTT);
                 
                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(HinhThucThanhToanDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public HinhThucThanhToanDTO getById(int id) {
        HinhThucThanhToanDTO result = null;
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM hinhthucthanhtoan WHERE TrangThai = 1 AND MaHTTT= " + id  ;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maHTTT = rs.getInt("MaHTTT");
                    String tenHTTT = rs.getString("TenHTTT");
                    
                    
                    result = new HinhThucThanhToanDTO(maHTTT, tenHTTT);
                }
            } catch (SQLException ex) {
                Logger.getLogger(HinhThucThanhToanDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<HinhThucThanhToanDTO> getByCondition(String condition) {
        ArrayList<HinhThucThanhToanDTO> result = new ArrayList<>();
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM hinhthucthanhtoan WHERE TrangThai=1 AND " + condition;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maHTTT = rs.getInt("MaHTTT");
                    String tenHTTT = rs.getString("TenHTTT");
                    
                    
                    HinhThucThanhToanDTO s = new HinhThucThanhToanDTO(maHTTT, tenHTTT);
                 
                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(HinhThucThanhToanDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        return result;
    }
    
}
