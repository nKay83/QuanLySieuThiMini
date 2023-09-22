/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DTO;

public class HangSanXuatDTO {
    private int MaHang;
    private String TenHang;

    public HangSanXuatDTO() {
    }

    public HangSanXuatDTO(int MaHang, String TenHang) {
        this.MaHang = MaHang;
        this.TenHang = TenHang;
    }

    public int getMaHang() {
        return MaHang;
    }

    public void setMaHang(int MaHang) {
        this.MaHang = MaHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }
    
}
