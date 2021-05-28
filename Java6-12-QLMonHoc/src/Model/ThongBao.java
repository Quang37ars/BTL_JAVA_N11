/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ledan
 */
public class ThongBao {

    private String maThongBao;
    private String noiDung;
    private String flieDinhKem;

    public ThongBao() {
    }

    public ThongBao(String maThongBao, String noiDung, String flieDinhKem) {
        this.maThongBao = maThongBao;
        this.noiDung = noiDung;
        this.flieDinhKem = flieDinhKem;
    }

    public String getMaThongBao() {
        return maThongBao;
    }

    public void setMaThongBao(String maThongBao) {
        this.maThongBao = maThongBao;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getFlieDinhKem() {
        return flieDinhKem;
    }

    public void setFlieDinhKem(String flieDinhKem) {
        this.flieDinhKem = flieDinhKem;
    }

}
