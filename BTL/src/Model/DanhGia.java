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
     private String Madanhgia;
     private int Manhom;
     private Double Diem;

    public DanhGia() {
    }

    public DanhGia(String Madanhgia, int Manhom, Double Diem) {
        this.Madanhgia = Madanhgia;
        this.Manhom = Manhom;
        this.Diem = Diem;
    }

    public String getMadanhgia() {
        return Madanhgia;
    }

    public void setMadanhgia(String Madanhgia) {
        this.Madanhgia = Madanhgia;
    }

    public int getManhom() {
        return Manhom;
    }

    public void setManhom(int Manhom) {
        this.Manhom = Manhom;
    }

    public Double getDiem() {
        return Diem;
    }

    public void setDiem(Double Diem) {
        this.Diem = Diem;
    }

    @Override
    public String toString() {
        return "Detai{" + "Madanhgia=" + Madanhgia + ", Manhom=" + Manhom + ", Diem=" + Diem + '}';
    }
     
}
