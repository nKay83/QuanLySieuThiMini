/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import quanlysieuthimini.DAO.DAOInterface.DAOInterface;
import quanlysieuthimini.DTO.TaiKhoanDTO;

public class TaiKhoanDAO implements DAOInterface<TaiKhoanDTO> {

    public static TaiKhoanDAO getInstance(){
        return new TaiKhoanDAO();
    }

    public TaiKhoanDTO login(String tenTK, String passwd){
        TaiKhoanDTO acc = null;
        ResultSet rs = null;
        Connection connect = ConnectionDB.openConnection();
        if(connect != null){
            try {
                String sql = "SELECT * FROM taikhoan WHERE TenTK=? and MatKhau=?";

                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setString(1, tenTK);
                stmt.setString(2, passwd);
                rs = stmt.executeQuery();
                if(rs.next()){
                    acc = new TaiKhoanDTO();
                    acc.setTenTK(rs.getString("TenTK"));
                    acc.setMaNguoiDung(rs.getInt("MaNguoiDung"));
                    acc.setMaQuyen(rs.getInt("MaQuyen"));
                    acc.setMatKhau(rs.getString("MatKhau"));
                    acc.setTrangThai(rs.getBoolean("TrangThai"));
                    return acc;
                }
            } catch (Exception e) {
                // TODO: handle exception
                return null;
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        return null;
    }
    @Override
    public boolean insert(TaiKhoanDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối sql
        Connection connect = ConnectionDB.openConnection();
        if(connect != null){
            try {
                String sql = "INSERT INTO taikhoan (TenTK,MaNguoiDung,MaQuyen,MatKhau,TrangThai) VALUES(?, ?, ?, ?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setString(1, t.getTenTK());
                stmt.setInt(2, t.getMaNguoiDung());
                stmt.setInt(3, t.getMaQuyen());
                stmt.setString(4, t.getMatKhau());
                if(t.isTrangThai())
                    stmt.setInt(5, 1);
                else
                    stmt.setInt(5, 0);
                
                result = stmt.executeUpdate()>=1;
            } catch (SQLException e) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, e);
            } finally{
                ConnectionDB.closeConnection(connect);
            }
        }
        return result;
    }

    @Override
    public boolean update(TaiKhoanDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "UPDATE taikhoan SET "
                        + "TenTK=?, MaQuyen=?, MatKhau=?, TrangThai=?"
                        + "WHERE MaNguoiDung=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, t.getTenTK());
                stmt.setInt(2, t.getMaQuyen());
                stmt.setString(3, t.getMatKhau());
                if(t.isTrangThai())
                    stmt.setInt(4, 1);
                else
                    stmt.setInt(4, 0);
                stmt.setInt(5, t.getMaNguoiDung());

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
                String sql = "UPDATE taikhoan SET TrangThai=0 "
                        + "WHERE MaNguoiDung=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setInt(1 , id); 

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
    public ArrayList<TaiKhoanDTO> getAll() {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM taikhoan WHERE TrangThai=1";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    TaiKhoanDTO User = new TaiKhoanDTO();
                    User.setTenTK(rs.getString(1));
                    User.setMaNguoiDung(rs.getInt(2));
                    User.setMaQuyen(rs.getInt(3));
                    User.setMatKhau(rs.getString(4));
                    int TrangThai = rs.getInt(5);
                    if(TrangThai == 1)
                        User.setTrangThai(true);
                    else
                        User.setTrangThai(false);
                    result.add(User);
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
    public TaiKhoanDTO getById(int id) {
        TaiKhoanDTO result = null;
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM taikhoan WHERE TrangThai=1 AND MaNguoiDung=" + id;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                rs.next();
                result = new TaiKhoanDTO();
                result.setTenTK(rs.getString(1));
                result.setMaNguoiDung(rs.getInt(2));
                result.setMaQuyen(rs.getInt(3));
                result.setMatKhau(rs.getString(4));
                int TrangThai = rs.getInt(5);
                    if(TrangThai == 1)
                        result.setTrangThai(true);
                    else
                        result.setTrangThai(false);
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<TaiKhoanDTO> getByCondition(String condition) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM taikhoan WHERE TrangThai=1 AND " + condition;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()){
                    TaiKhoanDTO user = new TaiKhoanDTO();
                    user.setTenTK(rs.getString(1));
                    user.setMaNguoiDung(rs.getInt(2));
                    user.setMaQuyen(rs.getInt(3));
                    user.setMatKhau(rs.getString(4));
                    int TrangThai = rs.getInt(5);
                    if(TrangThai == 1)
                        user.setTrangThai(true);
                    else
                        user.setTrangThai(false);
                    result.add(user);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }
    
}
