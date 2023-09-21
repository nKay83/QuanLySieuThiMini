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
import quanlysieuthimini.DTO.DonViTinhDTO;

public class DonViTinhDAO implements DAOInterface<DonViTinhDTO>{
    public static DonViTinhDAO getInstance() {
        return new DonViTinhDAO();
    }

    public int insert(String tenDV) {
        boolean result = false;
        int auto_id = -1;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into donvitinh "
                        + "(TenDV) "
                        + "VALUES (?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
                
                stmt.setString(1, tenDV);
                

                result = stmt.executeUpdate()>=1;
                
                if (result) {
                    ResultSet rs = stmt.getGeneratedKeys();
                    rs.next();
                    auto_id = rs.getInt(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DonViTinhDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return auto_id;
    }

    public boolean update(DonViTinhDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        
        if (connect != null) {
            try {
                String sql = "UPDATE donvitinh SET "
                        + "TenDV=?"
                        + "WHERE MaDV=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                
                stmt.setString(1, t.getTenDV());
                stmt.setInt(2, t.getMaDV());
                

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(DonViTinhDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "UPDATE donvitinh SET TrangThai = 0 "
                        + "WHERE MaDV=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setInt(1, id); 

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(DonViTinhDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    public ArrayList<DonViTinhDTO> getAll() {
        ArrayList<DonViTinhDTO> result = new ArrayList<>();
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM donvitinh WHERE TrangThai = 1";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maDV = rs.getInt("MaDV");
                    String tenDV = rs.getString("TenDV");
                    
                    
                    DonViTinhDTO s = new DonViTinhDTO(maDV, tenDV);
                 
                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DonViTinhDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    public DonViTinhDTO getById(int id) {
        DonViTinhDTO result = null;
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM donvitinh WHERE TrangThai = 1 AND MaDV= " + id  ;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maDV = rs.getInt("MaDV");
                    String tenDV = rs.getString("TenDV");
                    
                    
                    result = new DonViTinhDTO(maDV, tenDV);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DonViTinhDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    public ArrayList<DonViTinhDTO> getByCondition(String condition) {
        ArrayList<DonViTinhDTO> result = new ArrayList<>();
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM donvitinh WHERE TrangThai=1 AND " + condition;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maDV = rs.getInt("MaDV");
                    String tenDV = rs.getString("TenDV");
                    
                    
                    DonViTinhDTO s = new DonViTinhDTO(maDV, tenDV);
                 
                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DonViTinhDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }
    
    public boolean insert(DonViTinhDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
