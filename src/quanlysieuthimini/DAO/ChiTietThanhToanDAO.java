/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DAO;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import quanlysieuthimini.DTO.ChiTietThanhToanDTO;

/**
 *
 * @author Phong
 */
public class ChiTietThanhToanDAO {
    
    public List<ChiTietThanhToanDTO> getAll (){
        String query = "Select * From chitietthanhtoan";
        List<ChiTietThanhToanDTO> list = new ArrayList<>();
        ConnectionDB connect = new ConnectionDB();
        ResultSet rs = connect.sqlQuery(query);
        try {
            while(rs.next()){
                list.add(new ChiTietThanhToanDTO(rs.getInt("MaKH"),rs.getInt("MaHTTT"),
                        rs.getDouble("SoTien"),rs.getObject("NgayTT", LocalDate.class)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        connect.closeConnect();
        return list;
    }
    
    public ChiTietThanhToanDTO getCustomerById (int MaHD){
        String query = "Select * From chitietthanhtoan where `MaHD` = '" + MaHD + "'";
        ChiTietThanhToanDTO cttt = null;
        ConnectionDB connect = new ConnectionDB();
        ResultSet rs = connect.sqlQuery(query);
        try {
            while(rs.next()){
                cttt = new ChiTietThanhToanDTO(rs.getInt("MaKH"),rs.getInt("MaHTTT"),
                        rs.getDouble("SoTien"),rs.getObject("NgayTT", LocalDate.class));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        connect.closeConnect();
        return cttt;
    }
    
    public boolean update (int MaHD,int MaHTTT , Double SoTien, LocalDate NgayTT){
        String querry = "UPDATE chitietthanhtoan SET SoTien = '" + SoTien + "', NgayTT = '" + NgayTT + "' WHERE MaHD = '" + MaHD + " AND MaHTTT = " + MaHTTT;
	ConnectionDB conn = new ConnectionDB();
	boolean ok = conn.sqlUpdate(querry);
	conn.closeConnect();
	return ok;
    }
    
    
    
}
