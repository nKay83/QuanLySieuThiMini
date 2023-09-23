/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DTO;

public class ChucNangDTO {
    private int MaCN;
    private String TenCN;
    private boolean TrangThai;

    public ChucNangDTO() {
    }

    public ChucNangDTO(int MaCN, String TenCN) {
        this.MaCN = MaCN;
        this.TenCN = TenCN;
    }

    public int getMaCN() {
        return MaCN;
    }

    public void setMaCN(int MaCN) {
        this.MaCN = MaCN;
    }

    public String getTenCN() {
        return TenCN;
    }

    public void setTenCN(String TenCN) {
        this.TenCN = TenCN;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
