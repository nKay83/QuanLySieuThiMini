/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DTO;

import java.time.LocalDate;

public class SanPhamDTO {
    private int MaSP, MaLoai, MaHang, MaDV, MaNCC;
    private String TenSP, HinhAnh;
    private int SoLuong, DungTich;
    private double DonGia;
    private LocalDate NgaySX, HanSD;
    private boolean TrangThai;

    public SanPhamDTO() {
    }

    public SanPhamDTO(int MaSP, int MaLoai, int MaHang, int MaDV, int MaNCC, String TenSP, int SoLuong, int DungTich, double DonGia, LocalDate NgaySX, LocalDate HanSD, String HinhAnh, boolean TrangThai) {
        this.MaSP = MaSP;
        this.MaLoai = MaLoai;
        this.MaHang = MaHang;
        this.MaDV = MaDV;
        this.MaNCC = MaNCC;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.DungTich = DungTich;
        this.DonGia = DonGia;
        this.NgaySX = NgaySX;
        this.HanSD = HanSD;
        this.HinhAnh = HinhAnh;
        this.TrangThai = TrangThai;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int MaLoai) {
        this.MaLoai = MaLoai;
    }

    public int getMaHang() {
        return MaHang;
    }

    public void setMaHang(int MaHang) {
        this.MaHang = MaHang;
    }

    public int getMaDV() {
        return MaDV;
    }

    public void setMaDV(int MaDV) {
        this.MaDV = MaDV;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getDungTich() {
        return DungTich;
    }

    public void setDungTich(int DungTich) {
        this.DungTich = DungTich;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public LocalDate getNgaySX() {
        return NgaySX;
    }

    public void setNgaySX(LocalDate NgaySX) {
        this.NgaySX = NgaySX;
    }

    public LocalDate getHanSD() {
        return HanSD;
    }

    public void setHanSD(LocalDate HanSD) {
        this.HanSD = HanSD;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
}
