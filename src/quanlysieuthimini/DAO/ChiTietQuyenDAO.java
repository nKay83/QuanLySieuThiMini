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
import quanlysieuthimini.DTO.ChiTietQuyenDTO;

public class ChiTietQuyenDAO implements DAOInterface<ChiTietQuyenDTO> {

    public ChiTietQuyenDAO getInstance(){
        return new ChiTietQuyenDAO();
    }
    @Override
    public boolean insert(ChiTietQuyenDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối sql
        Connection connect = ConnectionDB.openConnection();
        if(connect != null){
            try {
                String sql = "INSERT INTO chitietquyen (MaQuyen,MaCN,HanhDong) VALUES(?, ?, ?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setInt(1, t.getMaQuyen());
                stmt.setInt(2, t.getMaCN());
                stmt.setString(3, t.getHanhDong());
                result = stmt.executeUpdate()>=1;
            } catch (SQLException e) {
                Logger.getLogger(ChiTietQuyenDAO.class.getName()).log(Level.SEVERE, null, e);
            } finally{
                ConnectionDB.closeConnection(connect);
            }
        }
        return result;
    }

    @Override
    public boolean update(ChiTietQuyenDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "UPDATE chitietquyen SET "
                        + "MaCN=? , HanhDong=?"
                        + "WHERE MaQuyen=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setInt(1, t.getMaCN());
                stmt.setString(2, t.getHanhDong());
                stmt.setInt(3, t.getMaQuyen());

                result = stmt.executeUpdate()>=1; 
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietQuyenDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                String sql = "UPDATE chitietquyen SET TrangThai=0 "
                        + "WHERE MaCN=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setInt(1 , id); 

                result = stmt.executeUpdate()>=1; 
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietQuyenDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<ChiTietQuyenDTO> getAll() {
        ArrayList<ChiTietQuyenDTO> result = new ArrayList<>();
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM chitietquyen WHERE TrangThai=1 AND";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    ChiTietQuyenDTO i = new ChiTietQuyenDTO();
                    i.setMaQuyen(rs.getInt(1));
                    i.setMaCN(rs.getInt(2));
                    i.setHanhDong(rs.getString(3));
                    result.add(i);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietQuyenDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ChiTietQuyenDTO getById(int id) {
        ChiTietQuyenDTO result = null;
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM chitietquyen WHERE TrangThai=1 AND MaQuyen=" + id;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                rs.next();
                result = new ChiTietQuyenDTO();
                result.setMaQuyen(rs.getInt(1));
                result.setMaCN(rs.getInt(2));
                result.setHanhDong(rs.getString(3));
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietQuyenDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }
    public ChiTietQuyenDTO getByMaCN(int id) {
        ChiTietQuyenDTO result = null;
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM chitietquyen WHERE TrangThai=1 AND MaCN=" + id;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                rs.next();
                result = new ChiTietQuyenDTO();
                result.setMaQuyen(rs.getInt(1));
                result.setMaCN(rs.getInt(2));
                result.setHanhDong(rs.getString(3));
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietQuyenDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<ChiTietQuyenDTO> getByCondition(String condition) {
        ArrayList<ChiTietQuyenDTO> result = new ArrayList<>();
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM chitietquyen WHERE TrangThai=1 AND " + condition;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()){
                    ChiTietQuyenDTO i = new ChiTietQuyenDTO();
                    i.setMaQuyen(rs.getInt(1));
                    i.setMaCN(rs.getInt(2));
                    i.setHanhDong(rs.getString(3));
                    result.add(i);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietQuyenDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }
    
}
