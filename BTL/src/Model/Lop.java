/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 2XHQ
 */
public class Lop {
    private String maLop;
    private String tenLop;
    private Integer Siso;
    private String khoa;
    private String tenHP;
    
    

    public Lop() {
    }

    public Lop(String maLop, String tenLop, Integer Siso,String khoa,String tenHP ) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.tenHP = tenHP;
        this.khoa = khoa;
        this.Siso = Siso;
    }

    @Override
    public String toString() {
        return "Lop{" + "maLop=" + maLop + ", tenLop=" + tenLop + ", tenHP=" + tenHP + ", khoa=" + khoa + ", Siso=" + Siso + '}';
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getTenHP() {
        return tenHP;
    }

    public void setTenHP(String tenHP) {
        this.tenHP = tenHP;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public Integer getSiso() {
        return Siso;
    }

    public void setSiso(Integer Siso) {
        this.Siso = Siso;
    }
    
    
    
}
