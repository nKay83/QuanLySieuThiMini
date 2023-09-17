/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DTO;

public class TaiKhoanDTO {
    private int MaNguoiDung, MaQuyen;
    private String TenTK, MatKhau;
    private boolean TrangThai;

    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(int MaNguoiDung, int MaQuyen, String TenTK, String MatKhau, boolean TrangThai) {
        this.MaNguoiDung = MaNguoiDung;
        this.MaQuyen = MaQuyen;
        this.TenTK = TenTK;
        this.MatKhau = MatKhau;
        this.TrangThai = TrangThai;
    }

    public int getMaNguoiDung() {
        return MaNguoiDung;
    }

    public void setMaNguoiDung(int MaNguoiDung) {
        this.MaNguoiDung = MaNguoiDung;
    }

    public int getMaQuyen() {
        return MaQuyen;
    }

    public void setMaQuyen(int MaQuyen) {
        this.MaQuyen = MaQuyen;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    
}
