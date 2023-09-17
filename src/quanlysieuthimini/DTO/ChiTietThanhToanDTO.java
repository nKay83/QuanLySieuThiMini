/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DTO;

import java.time.LocalDate;

public class ChiTietThanhToanDTO {
    private int MaHD, MaHTTT;
    private double SoTien;
    private LocalDate NgayThanhToan;

    public ChiTietThanhToanDTO() {
    }

    public ChiTietThanhToanDTO(int MaHD, int MaHTTT, double SoTien, LocalDate NgayThanhToan) {
        this.MaHD = MaHD;
        this.MaHTTT = MaHTTT;
        this.SoTien = SoTien;
        this.NgayThanhToan = NgayThanhToan;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getMaHTTT() {
        return MaHTTT;
    }

    public void setMaHTTT(int MaHTTT) {
        this.MaHTTT = MaHTTT;
    }

    public double getSoTien() {
        return SoTien;
    }

    public void setSoTien(double SoTien) {
        this.SoTien = SoTien;
    }

    public LocalDate getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(LocalDate NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }
    
    
}
