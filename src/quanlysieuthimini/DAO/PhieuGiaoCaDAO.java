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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlysieuthimini.DAO.DAOInterface.DAOInterface;
import quanlysieuthimini.DTO.PhieuGiaoCaDTO;

public class PhieuGiaoCaDAO implements DAOInterface<PhieuGiaoCaDTO>{
    
    public static PhieuGiaoCaDAO getInstance(){
        return new PhieuGiaoCaDAO();
    }

    @Override
    public boolean insert(PhieuGiaoCaDTO t) {
       boolean result = false;
        int auto_id = -1;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into phieugiaoca "
                        + "(NgayTao,GioBatDau,GioKetThuc,SoGioLam,SoTienThanhToan,MaNV) "
                        + "VALUES (?,?,?,?,?,?)";
               
                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
                
                stmt.setDate(1,java.sql.Date.valueOf(t.getNgayTao()));
                stmt.setTime(2, java.sql.Time.valueOf(t.getGioBatDau()));
                stmt.setTime(3, java.sql.Time.valueOf(t.getGioKetThuc()));
                stmt.setInt(4, t.getSoGioLamViec());
                stmt.setDouble(5, t.getSoTienThanhToan());
                stmt.setInt(6, t.getMaNV());

                result = stmt.executeUpdate()>=1;
                
                if (result) {
                    ResultSet rs = stmt.getGeneratedKeys();
                    rs.next();
                    auto_id = rs.getInt(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuGiaoCaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        return result;
    }

    @Override
    public boolean update(PhieuGiaoCaDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectionDB.openConnection();
        
        if (connect != null) {
            try {
                String sql = "UPDATE phieugiaoca SET "
                        + "NgayTao=?, GioBatDau=?, GioKetThuc=?, SoGioLam=?, SoTienThanhToan=?, MaNV=?"
                        + "WHERE MaPGC=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                
                stmt.setDate(1,java.sql.Date.valueOf(t.getNgayTao()));
                stmt.setTime(2, java.sql.Time.valueOf(t.getGioBatDau()));
                stmt.setTime(3, java.sql.Time.valueOf(t.getGioKetThuc()));
                stmt.setInt(4, t.getSoGioLamViec());
                stmt.setDouble(5, t.getSoTienThanhToan());
                stmt.setInt(6, t.getMaNV());
                stmt.setInt(7, t.getMaPGC());

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PhieuGiaoCaDTO> getAll() {
        ArrayList<PhieuGiaoCaDTO> result = new ArrayList<>();
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM phieugiaoca";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maPGC = rs.getInt("MaPGC");
                    LocalDate ngayTao = rs.getDate("NgayTao").toLocalDate();
                    LocalTime gioBD = rs.getTime("GioBatDau").toLocalTime();
                    LocalTime gioKT = rs.getTime("GioKetThuc").toLocalTime();
                    int soGioLam = rs.getInt("SoGioLam");
                    double soTienTT = rs.getDouble("SoTienThanhToan");
                    int maNV = rs.getInt("MaNV");
                    
                    PhieuGiaoCaDTO s = new PhieuGiaoCaDTO(maPGC,maNV,soGioLam,ngayTao,gioBD,gioKT,soTienTT);
                 
                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuGiaoCaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public PhieuGiaoCaDTO getById(int id) {
        PhieuGiaoCaDTO result = null;
        
        Connection connect = ConnectionDB.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM phieugiaoca WHERE MaPGC= " + id  ;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maPGC = rs.getInt("MaPGC");
                    LocalDate ngayTao = rs.getDate("NgayTao").toLocalDate();
                    LocalTime gioBD = rs.getTime("GioBatDau").toLocalTime();
                    LocalTime gioKT = rs.getTime("GioKetThuc").toLocalTime();
                    int soGioLam = rs.getInt("SoGioLam");
                    double soTienTT = rs.getDouble("SoTienThanhToan");
                    int maNV = rs.getInt("MaNV");
                    
                    
                    result = new PhieuGiaoCaDTO(maPGC,maNV,soGioLam,ngayTao,gioBD,gioKT,soTienTT);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuGiaoCaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionDB.closeConnection(connect);
            }
        }
        return result;
    }

    @Override
    public ArrayList<PhieuGiaoCaDTO> getByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
