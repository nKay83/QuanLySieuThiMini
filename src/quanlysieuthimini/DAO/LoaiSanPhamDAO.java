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
import quanlysieuthimini.DTO.LoaiSanPhamDTO;

public class LoaiSanPhamDAO implements DAOInterface<LoaiSanPhamDTO>{
    public static LoaiSanPhamDAO getInstance() {
        return new LoaiSanPhamDAO();
    }

    public int insert(String tenLoai, String cachBaoQuan, String moTa) {
        boolean result = false;
        int auto_id = -1;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into loaisanpham "
                        + "(TenLoai, CachBaoQuan, MoTa) "
                        + "VALUES (?,?,?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
                
                stmt.setString(1, tenLoai);
                stmt.setString(2, cachBaoQuan);
                stmt.setString(3, moTa);
                
                result = stmt.executeUpdate()>=1;
                
                if (result) {
                    ResultSet rs = stmt.getGeneratedKeys();
                    rs.next();
                    auto_id = rs.getInt(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return auto_id;
    }

    public boolean update(LoaiSanPhamDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        
        if (connect != null) {
            try {
                String sql = "UPDATE loaisanpham SET "
                        + "TenLoai=?,CachBaoQuan=?,MoTa=?"
                        + "WHERE MaLoai=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                
                stmt.setString(1, t.getTenLoai());
                stmt.setString(2, t.getCachBaoQuan());
                stmt.setString(3, t.getMoTa());
                stmt.setInt(4, t.getMaLoai());
                
                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                String sql = "UPDATE loaisanpham SET TrangThai = 0 "
                        + "WHERE MaLoai=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setInt(1, id); 

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<LoaiSanPhamDTO> getAll() {
        ArrayList<LoaiSanPhamDTO> result = new ArrayList<>();
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM loaisanpham WHERE TrangThai = 1";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maLoai = rs.getInt(1);
                    String tenLoai = rs.getString(2);
                    String cachBaoQuan = rs.getString(3);
                    String moTa = rs.getString(4);
                    
                    LoaiSanPhamDTO s = new LoaiSanPhamDTO(maLoai, tenLoai, cachBaoQuan, moTa);
                 
                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public LoaiSanPhamDTO getById(int id) {
        LoaiSanPhamDTO result = null;
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM loaisanpham WHERE TrangThai = 1 AND MaLoai= " + id  ;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maLoai = rs.getInt(1);
                    String tenLoai = rs.getString(2);
                    String cachBaoQuan = rs.getString(3);
                    String moTa = rs.getString(4);
                    
                    result = new LoaiSanPhamDTO(maLoai, tenLoai, cachBaoQuan, moTa);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<LoaiSanPhamDTO> getByCondition(String condition) {
        ArrayList<LoaiSanPhamDTO> result = new ArrayList<>();
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM loaisanpham WHERE TrangThai=1 AND " + condition;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maLoai = rs.getInt(1);
                    String tenLoai = rs.getString(2);
                    String cachBaoQuan = rs.getString(3);
                    String moTa = rs.getString(4);
                    
                    LoaiSanPhamDTO s = new LoaiSanPhamDTO(maLoai, tenLoai, cachBaoQuan, moTa);
                 
                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }
    
    @Override
    public boolean insert(LoaiSanPhamDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
