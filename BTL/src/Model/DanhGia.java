/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author quang
 */
public class DanhGia {
     private String maDanhGia;
     private int maNhom;
     private Double diem;

    public DanhGia() {
    }

    public DanhGia(String Madanhgia, int Manhom, Double Diem) {
        this.maDanhGia = Madanhgia;
        this.maNhom = Manhom;
        this.diem = Diem;
    }

    public String getMadanhgia() {
        return maDanhGia;
    }

    public void setMadanhgia(String Madanhgia) {
        this.maDanhGia = Madanhgia;
    }

    public int getManhom() {
        return maNhom;
    }

    public void setManhom(int Manhom) {
        this.maNhom = Manhom;
    }

    public Double getDiem() {
        return diem;
    }

    public void setDiem(Double Diem) {
        this.diem = Diem;
    }

    @Override
    public String toString() {
        return "Detai{" + "Madanhgia=" + maDanhGia + ", Manhom=" + maNhom + ", Diem=" + diem + '}';
    }
     
}
