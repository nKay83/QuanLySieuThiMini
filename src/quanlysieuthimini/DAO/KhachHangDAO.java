/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DAO;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;
import quanlysieuthimini.DAO.DAOInterface.DAOInterface;
import quanlysieuthimini.DTO.KhachHangDTO;

public class KhachHangDAO implements DAOInterface<KhachHangDTO> {
    
    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }

    @Override
    public boolean insert(KhachHangDTO t) {
        boolean result = false;
        int auto_id = -1;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into khachhang "
                        + "(TenKH,DiaChi,SDT,TrangThai) "
                        + "VALUES (?,?,?,?)";
               
                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
                
                stmt.setString(1,t.getTenKH());
                stmt.setString(2,t.getDiaChi());
                stmt.setString(3,t.getSDT());
                stmt.setInt(4, t.isTrangThai()?1:0);

                result = stmt.executeUpdate()>=1;
                
                if (result) {
                    ResultSet rs = stmt.getGeneratedKeys();
                    rs.next();
                    auto_id = rs.getInt(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        return result;
    }

    

    @Override
    public boolean update(KhachHangDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        
        if (connect != null) {
            try {
                String sql = "UPDATE khachhang SET "
                        + "TenKH=?, DiaChi=?, SDT=?, TrangThai=?"
                        + "WHERE MaKH=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                
                stmt.setString(1,t.getTenKH());
                stmt.setString(2,t.getDiaChi());
                stmt.setString(3,t.getSDT());
                stmt.setInt(4, t.isTrangThai()?1:0);
                stmt.setInt(5,t.getMaKH());

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                String sql = "UPDATE khachhang SET TrangThai = 0 "
                        + "WHERE MaKH=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setInt(1, id); 

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<KhachHangDTO> getAll() {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM khachhang WHERE TrangThai = 1";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maKH = rs.getInt("MaKH");
                    String tenKH = rs.getString("TenKH");
                    String diaChi = rs.getString("DiaChi");
                    String SDT = rs.getString("SDT");
                    Boolean status = rs.getBoolean("TrangThai");
                    
                    
                    KhachHangDTO s = new KhachHangDTO(maKH,tenKH,diaChi,SDT,status);
                 
                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }


    @Override
    public KhachHangDTO getById(int id) {
        KhachHangDTO result = null;
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM khachhang WHERE TrangThai = 1 AND MaKH= " + id  ;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maKH = rs.getInt("MaKH");
                    String tenKH = rs.getString("TenKH");
                    String diaChi = rs.getString("DiaChi");
                    String SDT = rs.getString("SDT");
                    Boolean status = rs.getBoolean("TrangThai");
                    
                    result = new KhachHangDTO(maKH,tenKH,diaChi,SDT,status);
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<KhachHangDTO> getByCondition(String condition) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM khachhang WHERE TrangThai=1 AND " + condition;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maKH = rs.getInt("MaKH");
                    String tenKH = rs.getString("TenKH");
                    String diaChi = rs.getString("DiaChi");
                    String SDT = rs.getString("SDT");
                    Boolean status = rs.getBoolean("TrangThai");
                    
                    
                    KhachHangDTO s = new KhachHangDTO(maKH,tenKH,diaChi,SDT,status);
                 
                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }
    
}
