/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DTO;

import java.time.LocalDate;

public class PhieuNhapDTO {
    private int MaPN, MaNV, MaNCC;
    private LocalDate NgayNhap;
    private double TongTriGia;
    private boolean TrangThai;

    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(int MaPN, int MaNV, int MaNCC, LocalDate NgayNhap, double TongTriGia, boolean TrangThai) {
        this.MaPN = MaPN;
        this.MaNV = MaNV;
        this.MaNCC = MaNCC;
        this.NgayNhap = NgayNhap;
        this.TongTriGia = TongTriGia;
        this.TrangThai = TrangThai;
    }

    public int getMaPN() {
        return MaPN;
    }

    public void setMaPN(int MaPN) {
        this.MaPN = MaPN;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int MaNCC) {
        this.MaNCC = MaNCC;
    }

    public LocalDate getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(LocalDate NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public double getTongTriGia() {
        return TongTriGia;
    }

    public void setTongTriGia(double TongTriGia) {
        this.TongTriGia = TongTriGia;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
