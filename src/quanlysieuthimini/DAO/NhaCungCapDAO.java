/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DAO;

import quanlysieuthimini.DAO.DAOInterface.DAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import quanlysieuthimini.DTO.NhaCungCapDTO;

public class NhaCungCapDAO implements DAOInterface<NhaCungCapDTO>{
    
    public static NhaCungCapDAO getInstance() {
        return new NhaCungCapDAO();
    }
    
    @Override
    public ArrayList<NhaCungCapDTO> getAll() {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM nhacungcap WHERE TrangThai=1";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maNhaCungCap = rs.getInt(1);
                    String tenNhaCungCap = rs.getString(2);
                    String diaChi = rs.getString(3);
                    String soDienThoai = rs.getString(4);
                    String email = rs.getString(5);
                    NhaCungCapDTO s = new NhaCungCapDTO(maNhaCungCap,tenNhaCungCap,diaChi, email,soDienThoai);
                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    public int insert(String tenNhaCungCap,String diaChi,String soDienThoai,String email) {
        boolean result = false;
        int auto_id = -1;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into nhacungcap "+ "(TenNCC,DiaChi,SDT,Email) "+ "VALUES (?, ?, ?, ?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
                stmt.setString(1, tenNhaCungCap);
                stmt.setString(2, diaChi);
                stmt.setString(3, soDienThoai);
                stmt.setString(4, email);
                
                result = stmt.executeUpdate()>=1;
                
                if (result) {
                    ResultSet rs = stmt.getGeneratedKeys();
                    rs.next();
                    auto_id = rs.getInt(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return auto_id;
    }

    @Override
    public boolean update(NhaCungCapDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
 
        if (connect != null) {
            try {
                String sql = "UPDATE nhacungcap SET "
                        + "TenNCC=? , DiaChi=? ,SDT = ?,Email = ?"
                        + "WHERE MaNCC=?";
                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, t.getTenNCC());
                stmt.setString(2, t.getDiaChi());
                stmt.setString(3, t.getSDT());
                stmt.setString(4, t.getEmail());
                stmt.setInt(5, t.getMaNCC());

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                String sql = "UPDATE nhacungcap SET TrangThai=0 "
                        + "WHERE MaNCC=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setInt(1, id); 

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }
    
    @Override
    public NhaCungCapDTO getById(int id) {
        NhaCungCapDTO result = null;
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM nhacungcap WHERE TrangThai=1 AND MaNCC=" + id;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maNhaCungCap = rs.getInt(1);
                    String tenNhaCungCap = rs.getString(2);
                    String diaChi = rs.getString(3);
                    String soDienThoai = rs.getString(4);
                    String email = rs.getString(5);
                    
                    result = new NhaCungCapDTO(maNhaCungCap,tenNhaCungCap,diaChi,email,soDienThoai);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<NhaCungCapDTO> getByCondition(String condition) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM nhacungcap WHERE TrangThai=1 AND " + condition;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maNhaCungCap = rs.getInt(1);
                    String tenNhaCungCap = rs.getString(2);
                    String diaChi = rs.getString(3);
                    String soDienThoai = rs.getString(4);
                    String email = rs.getString(5);
                    
                    NhaCungCapDTO s = new NhaCungCapDTO(maNhaCungCap,tenNhaCungCap,diaChi,email,soDienThoai);
                 
                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public boolean insert(NhaCungCapDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
