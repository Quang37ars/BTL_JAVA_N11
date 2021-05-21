package Model;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ledan
 */
public class DeTai {
    private String maDeTai;
    private String tenDeTai;
    private String trangThai;

    public DeTai() {
        this.trangThai = "";
    }

    
    public DeTai(String madetai, String tendetai, String trangthai) {
        this.maDeTai = madetai;
        this.tenDeTai = tendetai;
        this.trangThai = trangthai;
    }

    public String getMaDeTai() {
        return maDeTai;
    }

    public void setMaDeTai(String maDeTai) {
        this.maDeTai = maDeTai;
    }

    public String getTenDeTai() {
        return tenDeTai;
    }

    public void setTenDeTai(String tenDeTai) {
        this.tenDeTai = tenDeTai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    

    @Override
    public String toString() {
        return "Detai{" + "madetai=" + maDeTai + ", tendetai=" + tenDeTai + ", trangthai=" + trangThai + '}';
    }
    
    
}
