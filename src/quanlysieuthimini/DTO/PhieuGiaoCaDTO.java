/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class PhieuGiaoCaDTO {
    private int MaPGC, MaNV, SoGioLamViec;
    private LocalDate NgayTao;
    private LocalTime GioBatDau, GioKetThuc;
    private double SoTienThanhToan;

    public PhieuGiaoCaDTO() {
    }

    public PhieuGiaoCaDTO(int MaPGC, int MaNV, int SoGioLamViec, LocalDate NgayTao, LocalTime GioBatDau, LocalTime GioKetThuc, double SoTienThanhToan) {
        this.MaPGC = MaPGC;
        this.MaNV = MaNV;
        this.SoGioLamViec = SoGioLamViec;
        this.NgayTao = NgayTao;
        this.GioBatDau = GioBatDau;
        this.GioKetThuc = GioKetThuc;
        this.SoTienThanhToan = SoTienThanhToan;
    }

    public int getMaPGC() {
        return MaPGC;
    }

    public void setMaPGC(int MaPGC) {
        this.MaPGC = MaPGC;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public int getSoGioLamViec() {
        return SoGioLamViec;
    }

    public void setSoGioLamViec(int SoGioLamViec) {
        this.SoGioLamViec = SoGioLamViec;
    }

    public LocalDate getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(LocalDate NgayTao) {
        this.NgayTao = NgayTao;
    }

    public LocalTime getGioBatDau() {
        return GioBatDau;
    }

    public void setGioBatDau(LocalTime GioBatDau) {
        this.GioBatDau = GioBatDau;
    }

    public LocalTime getGioKetThuc() {
        return GioKetThuc;
    }

    public void setGioKetThuc(LocalTime GioKetThuc) {
        this.GioKetThuc = GioKetThuc;
    }

    public double getSoTienThanhToan() {
        return SoTienThanhToan;
    }

    public void setSoTienThanhToan(double SoTienThanhToan) {
        this.SoTienThanhToan = SoTienThanhToan;
    }
    
    
}
