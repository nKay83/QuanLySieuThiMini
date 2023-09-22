/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DAO;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import quanlysieuthimini.DTO.KhachHangDTO;

/**
 *
 * @author Phong
 */
public class CustomerDAO {
    
    public List<KhachHangDTO> getAllCustomer (){
        String query = "Select * From khachang";
        List<KhachHangDTO> list = new ArrayList<>();
        ConnectionDB connect = new ConnectionDB();
        ResultSet rs = connect.sqlQuery(query);
        try {
            while(rs.next()){
                list.add(new KhachHangDTO(rs.getInt("MaKH"),rs.getString("TenKH"),
                        rs.getString("DiaChi"),rs.getString("SDT"),rs.getBoolean("TrangThai")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        connect.closeConnect();
        return list;
    }
    
    public KhachHangDTO getCustomerById (int makh){
        String query = "Select * From khachang where `MaKH` = '" + makh + "'";
        KhachHangDTO customer = null;
        ConnectionDB connect = new ConnectionDB();
        ResultSet rs = connect.sqlQuery(query);
        try {
            while(rs.next()){
                customer = new KhachHangDTO(rs.getInt("MaKH"),rs.getString("TenKH"),
                        rs.getString("DiaChi"),rs.getString("SDT"),rs.getBoolean("TrangThai"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        connect.closeConnect();
        return customer;
    }
    
    public boolean update (int maKH, String tenkh, String sdt, String diachi,boolean trangthai){
        String querry = "UPDATE khachhang SET TenKH = '" + tenkh + "', SDT = '" + sdt + "', DiaChi = '" + diachi + "', TrangThai = '" + trangthai + "' WHERE MaKH = '" + maKH + "'";
	ConnectionDB conn = new ConnectionDB();
	boolean ok = conn.sqlUpdate(querry);
	conn.closeConnect();
	return ok;
    }
    
    public boolean add (int maKH, String tenkh, String sdt, String diachi,boolean trangthai){
        String querry = "INSERT INTO khachhang (MaKH, TenKH, SDT, DiaChi, TrangThai) VALUES ('" + maKH + "', '" + tenkh + "', '" + sdt + "', '" + diachi + "', '" + trangthai + "')";
	ConnectionDB conn = new ConnectionDB();
	boolean ok = conn.sqlUpdate(querry);
	conn.closeConnect();
	return ok;
    }
    
    public boolean delete (int maKH){
        ConnectionDB connect = new ConnectionDB();
        boolean ok = connect.sqlUpdate("DELETE FROM `khachhang` WHERE `MaKH` = '" + maKH + "'");
        connect.closeConnect();
        return ok;
    }
}
