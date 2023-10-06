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
import quanlysieuthimini.DTO.ChucNangDTO;

public class ChucNangDAO implements DAOInterface<ChucNangDTO> {

    public ChucNangDAO getInstance(){
        return new ChucNangDAO();
    }
    @Override
    public boolean insert(ChucNangDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối sql
        Connection connect = ConnectionDB.openConnection();
        if(connect != null){
            try {
                String sql = "INSERT INTO chucnang (MaCN,TenCN) VALUES(?, ?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setInt(1, t.getMaCN());
                stmt.setString(2, t.getTenCN());
                result = stmt.executeUpdate()>=1;
            } catch (SQLException e) {
                Logger.getLogger(ChucNangDAO.class.getName()).log(Level.SEVERE, null, e);
            } finally{
                ConnectionDB.closeConnection(connect);
            }
        }
        return result;
    }

    @Override
    public boolean update(ChucNangDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "UPDATE chucnang SET "
                        + "TenCN=?  "
                        + "WHERE MaCN=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, t.getTenCN());
                stmt.setInt(2, t.getMaCN());

                result = stmt.executeUpdate()>=1; 
            } catch (SQLException ex) {
                Logger.getLogger(ChucNangDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                String sql = "UPDATE chucnang SET TrangThai=0 "
                        + "WHERE MaCN=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setInt(1 , id); 

                result = stmt.executeUpdate()>=1; 
            } catch (SQLException ex) {
                Logger.getLogger(ChucNangDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<ChucNangDTO> getAll() {
        ArrayList<ChucNangDTO> result = new ArrayList<>();
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM chucnang WHERE TrangThai=1";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    ChucNangDTO i = new ChucNangDTO();
                    i.setMaCN(rs.getInt(1));
                    i.setTenCN(rs.getString(2));
                    result.add(i);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChucNangDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ChucNangDTO getById(int id) {
        ChucNangDTO result = null;
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM chucnang WHERE TrangThai=1 AND MaCN=" + id;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                rs.next();
                result = new ChucNangDTO();
                result.setMaCN(rs.getInt(1));
                result.setTenCN(rs.getString(2));
            } catch (SQLException ex) {
                Logger.getLogger(ChucNangDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }
    
    @Override
    public ArrayList<ChucNangDTO> getByCondition(String condition) {
        ArrayList<ChucNangDTO> result = new ArrayList<>();
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM chucnang WHERE TrangThai=1 AND" + condition;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()){
                    ChucNangDTO i = new ChucNangDTO();
                    i.setMaCN(rs.getInt(1));
                    i.setTenCN(rs.getString(2));
                    result.add(i);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChucNangDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }
    
    
}
