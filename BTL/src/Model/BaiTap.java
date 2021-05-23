/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author phamt
 */
public class BaiTap {

    public String maBaiTap, ghiChu, linkBaiTap;
    public Integer maNhom;

    public BaiTap() {
    }

    
    
    public Integer getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(Integer maNhom) {
        this.maNhom = maNhom;
    }

    public BaiTap(String maBaiTap, String ghiChu, String linkBaiTap, Integer maNhom) {
        this.maBaiTap = maBaiTap;
        this.ghiChu = ghiChu;
        this.linkBaiTap = linkBaiTap;
        this.maNhom = maNhom;
    }

    public BaiTap(String maBaiTap) {
        this.maBaiTap = maBaiTap;
    }

    public String getMaBaiTap() {
        return maBaiTap;
    }

    public void setMaBaiTap(String maBaiTap) {
        this.maBaiTap = maBaiTap;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getLinkBaiTap() {
        return linkBaiTap;
    }

    public void setLinkBaiTap(String linkBaiTap) {
        this.linkBaiTap = linkBaiTap;
    }

}
