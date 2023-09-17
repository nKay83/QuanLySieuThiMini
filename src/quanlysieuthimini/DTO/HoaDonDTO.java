/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DTO;

import java.time.LocalDate;

public class HoaDonDTO {
    private int MaHD, MaKH, MaKM, MaNV;
    private LocalDate NgayLap;
    private double TongTriGia;
    private boolean TrangThai;

    public HoaDonDTO() {
    }

    public HoaDonDTO(int MaHD, int MaKH, int MaKM, int MaNV, LocalDate NgayLap, double TongTriGia, boolean TrangThai) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaKM = MaKM;
        this.MaNV = MaNV;
        this.NgayLap = NgayLap;
        this.TongTriGia = TongTriGia;
        this.TrangThai = TrangThai;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public int getMaKM() {
        return MaKM;
    }

    public void setMaKM(int MaKM) {
        this.MaKM = MaKM;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public LocalDate getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(LocalDate NgayLap) {
        this.NgayLap = NgayLap;
    }

    public double getTongTriGia() {
        return TongTriGia;
    }

    public void setTongTriGia(double TongTriGia) {
        this.TongTriGia = TongTriGia;
    }
    
}
