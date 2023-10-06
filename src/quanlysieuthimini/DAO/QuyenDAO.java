
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
import quanlysieuthimini.DTO.QuyenDTO;

public class QuyenDAO implements DAOInterface<QuyenDTO> {

    public QuyenDAO getInstance(){
        return new QuyenDAO();
    }
    @Override
    public boolean insert(QuyenDTO t) {    
        boolean result = false;
        //Bước 1: tạo kết nối sql
        Connection connect = ConnectionDB.openConnection();
        if(connect != null){
            try {
                String sql = "INSERT INTO quyen (MaQuyen,TenQuyen) VALUES(?, ?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setInt(1, t.getMaQuyen());
                stmt.setString(2, t.getTenQuyen());
                result = stmt.executeUpdate()>=1;
            } catch (SQLException e) {
                Logger.getLogger(QuyenDAO.class.getName()).log(Level.SEVERE, null, e);
            } finally{
                ConnectionDB.closeConnection(connect);
            }
        }
        return result;    }

    @Override
    public boolean update(QuyenDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "UPDATE quyen SET "
                        + "TenQuyen=?"
                        + "WHERE MaQuyen=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, t.getTenQuyen());
                stmt.setInt(2, t.getMaQuyen());

                result = stmt.executeUpdate()>=1; 
            } catch (SQLException ex) {
                Logger.getLogger(QuyenDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "UPDATE quyen SET TrangThai=0 "
                        + "WHERE MaQuyen=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setInt(1 , id); 
                result = stmt.executeUpdate()>=1; 
            } catch (SQLException ex) {
                Logger.getLogger(QuyenDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<QuyenDTO> getAll() {
        ArrayList<QuyenDTO> result = new ArrayList<>();
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM quyen WHERE TrangThai=1";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    QuyenDTO i = new QuyenDTO();
                    i.setMaQuyen(rs.getInt(1));
                    i.setTenQuyen(rs.getString(2));
                    result.add(i);
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuyenDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public QuyenDTO getById(int id) {
        QuyenDTO result = null;
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM quyen WHERE TrangThai=1 AND MaQuyen=" + id;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                rs.next();
                result = new QuyenDTO();
                result.setMaQuyen(rs.getInt(1));
                result.setTenQuyen(rs.getString(2));
            } catch (SQLException ex) {
                Logger.getLogger(QuyenDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<QuyenDTO> getByCondition(String condition) {
        ArrayList<QuyenDTO> result = new ArrayList<>();
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM quyen WHERE TrangThai=1 AND " + condition;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()){
                    QuyenDTO i = new QuyenDTO();
                    i.setMaQuyen(rs.getInt(1));
                    i.setTenQuyen(rs.getString(2));
                    result.add(i);
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuyenDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }
    
}