/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DTO;

public class LoaiSanPhamDTO {
    private int MaLoai;
    private String TenLoai, MoTa, CachBaoQuan;

    public LoaiSanPhamDTO() {
    }

    public LoaiSanPhamDTO(int MaLoai, String TenLoai, String MoTa, String CachBaoQuan) {
        this.MaLoai = MaLoai;
        this.TenLoai = TenLoai;
        this.MoTa = MoTa;
        this.CachBaoQuan = CachBaoQuan;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getCachBaoQuan() {
        return CachBaoQuan;
    }

    public void setCachBaoQuan(String CachBaoQuan) {
        this.CachBaoQuan = CachBaoQuan;
    }
    
    
}
