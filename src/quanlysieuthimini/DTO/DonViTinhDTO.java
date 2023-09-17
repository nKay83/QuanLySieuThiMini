/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.DTO;

public class DonViTinhDTO {
    private int MaDV;
    private String TenDV;

    public DonViTinhDTO() {
    }

    public DonViTinhDTO(int MaDV, String TenDV) {
        this.MaDV = MaDV;
        this.TenDV = TenDV;
    }

    public int getMaDV() {
        return MaDV;
    }

    public void setMaDV(int MaDV) {
        this.MaDV = MaDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }
    
}
