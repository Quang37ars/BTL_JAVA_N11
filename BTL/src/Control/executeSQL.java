/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.BaiTap;
import Model.DangNhap;
import Model.DanhGia;
import Model.DeTai;
import Model.Lop;
import Model.SinhVien;
import View.ManHinhDangNhap;
import View.QuanLyLopForm;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 2XHQ
 */
public class executeSQL {

    private ArrayList<SinhVien> dssv;
    private ArrayList<Lop> dslop = new ArrayList<>();
    private ConnectDB db = new ConnectDB();
    private String sql;
    private ArrayList<DangNhap> dstk = new ArrayList<>();
    private ArrayList<DanhGia> dsDanhGia = new ArrayList<>();
    private ArrayList<Integer> list;
    private ArrayList<DeTai> dsdt = new ArrayList<DeTai>();
    private ArrayList<DanhGia> dsdg = new ArrayList<DanhGia>();
    static int maTB = 0;
    final String STT = "TNTB";
    static int maGV = 0;
    final String stt = "GVTB";
    private ArrayList<BaiTap> dsbt = new ArrayList<BaiTap>();
    String msv;
    public executeSQL() {

    }

    //Quang 37
    public void insertSVc(SinhVien sv) throws Exception {
        db.getConnect();
        String sql = "INSERT INTO SINHVIEN VALUES('"
                + sv.getMaSV() + "'," + sv.getMaNhom() + ",'" + sv.getHoSV() + "','"
                + sv.getTenSV() + "'," + sv.isNhomTruong() + ")";
        db.doSQL(sql);
        sql = "INSERT INTO TAIKHOAN VALUES('"
                + sv.getMaSV() + "','123456','TV')";
        db.doSQL(sql);
        sql = "SELECT MALOP FROM LOPHOC WHERE TENLOP = '" + QuanLyLopForm.tl + "'";
        String ml = db.getmalop(sql);
        System.out.println(ml);
        sql = "UPDATE LOPHOC SET SISO = SISO + 1 WHERE MALOP = '" + ml + "'";
        db.doSQL(sql);
    }

    public void insertSVm(SinhVien sv) throws SQLException, Exception {
        db.getConnect();
        String sql = "SELECT MALOP FROM LOPHOC WHERE TENLOP = '" + QuanLyLopForm.tl + "'";
        String ml = db.getmalop(sql);
        sql = "INSERT INTO NHOM VALUES(" + sv.getMaNhom() + ",'" + ml + "'," + null + ")";
        db.doSQL(sql);
        sql = "INSERT INTO SINHVIEN VALUES('"
                + sv.getMaSV() + "'," + sv.getMaNhom() + ",'" + sv.getHoSV() + "','"
                + sv.getTenSV() + "'," + sv.isNhomTruong() + ")";
        db.doSQL(sql);
        if (sv.isNhomTruong()) {
            String sql4 = "INSERT INTO TAIKHOAN"
                    + " VALUES('" + sv.getMaSV() + "','123456','NT')";
            db.doSQL(sql4);
        } else {
            String sql4 = "INSERT INTO TAIKHOAN"
                    + " VALUES('" + sv.getMaSV() + "','123456','TV')";
            db.doSQL(sql4);
        }
        sql = "UPDATE LOPHOC SET SISO = SISO + 1 WHERE MALOP = '" + ml + "'";
        db.doSQL(sql);
    }

    public ArrayList<Lop> selectDSLop() {
        db.getConnect();
        sql = "SELECT * FROM LOPHOC";
        return db.getDataLop(sql);

    }

    public void selectSV() {
        db.getConnect();
        sql = "SELECT * FROM SINHVIEN";
        dssv = db.getDataSV(sql);
    }

    public ArrayList<SinhVien> getDssv() {
        return dssv;
    }

    public void setDssv(ArrayList<SinhVien> dssv) {
        this.dssv = dssv;
    }

    public ArrayList<Lop> getDslop() {
        return dslop;
    }

    public void setDslop(ArrayList<Lop> dslop) {
        this.dslop = dslop;
    }

    public void deleteLop(String MaLop) throws Exception {
        db.getConnect();
        String sql = "DELETE FROM LOPHOC WHERE MALOP = '" + MaLop + "'";
        db.doSQL(sql);
    }

    public ArrayList<SinhVien> getSvLopChoose(String tl) throws SQLException {
        db.getConnect();

        sql = "SELECT * FROM SINHVIEN,NHOM,LOPHOC WHERE TENLOP= '" + tl + "'";
        return db.getDataSV(sql);
    }

    public void updateSV(SinhVien e) throws Exception {
        db.getConnect();
        String sql = "Update SINHVIEN SET MASV = '" + e.getMaSV() + "', MANHOM = " + e.getMaNhom() + ", HOSV ='"
                + e.getHoSV() + "', TENSV='" + e.getTenSV()
                + "', NHOMTRUONG = " + e.isNhomTruong() + " WHERE MASV = '" + e.getMaSV() + "'";
        db.doSQL(sql);
    }

    public void deleteSV(String masv) throws Exception {
        db.getConnect();
        String sql = "DELETE FROM SINHVIEN WHERE MASV = '" + masv + "'";
        db.doSQL(sql);
        sql = "SELECT MALOP FROM LOPHOC WHERE TENLOP = '" + QuanLyLopForm.tl + "'";
        String ml = db.getmalop(sql);
        sql = "UPDATE LOPHOC SET SISO = SISO - 1 WHERE MALOP = '" + ml + "'";
        db.doSQL(sql);
        sql = "DELETE FROM TAIKHOAN WHERE TAIKHOAN ='" + masv + "'";
        db.doSQL(sql);

    }

    //Quảng
    public void selectDSTK() {
        db.getConnect();
        sql = "SELECT * FROM TAIKHOAN";
        dstk = db.getDataTK(sql);
    }

    public ArrayList<DangNhap> getDstk() {
        return dstk;
    }

    public void setDstk(ArrayList<DangNhap> dstk) {
        this.dstk = dstk;
    }

    public ArrayList<DanhGia> getDsDanhGia() {
        return dsDanhGia;
    }

    public void setDsDanhGia(ArrayList<DanhGia> dsDanhGia) {
        this.dsDanhGia = dsDanhGia;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

    public void selectDSDanhgia() {
        db.getConnect();
        sql = "SELECT * FROM DANHGIA ";
        dsDanhGia = db.getDataDanhgia(sql);
        
    }

    public void updateData(String mdg, Double diem) throws Exception {
        db.getConnect();
        sql = "update DANHGIA set DIEM=" + diem + " "
                + "WHERE MADANHGIA='" + mdg + "'";
        db.doSQL(sql);
    }

    public ArrayList<Integer> getMaNhom(String tenLop) {
        db.getConnect();
        String sql = "Select MANHOM FROM LOPHOC inner join NHOM on LOPHOC.MALOP = Nhom.MALOP WHERE TENLOP = '" + tenLop + "'";
        return db.getMaNhomQ1(sql);
    }
    //Quang 36
        public void getDetai()
    {
        db.getConnect();
        String sql = "select * from DETAI where TRANGTHAICHON = "+false+"";
        dsdt = db.getdsDeTaiQ2(sql);
    }
            public void setTrangthaidt(String u) throws Exception
    {
        db.getConnect();
        String sql = "update DETAi set TRANGTHAICHON = '"+true+"'" + " where MADETAI ='"+u+"'";
        db.doSQL(sql);
    }
                public void setmaDeTai(String mdt) throws Exception
    {
        db.getConnect();
        String sql = "update NHOM set MADETAI = '"+mdt+"' where MANHOM = "+getmanhomt()+" ";
        db.doSQL(sql);
    }
                    public void guiThongBao(String tb ,String filedk) throws Exception
    {
        maTB++;
        String matt = STT + maTB;
        db.getConnect();
        String sql = "Insert into THONGBAO values('"+matt+"','"+ tb+"','"+filedk+"')";
        db.doSQL(sql);
    }
                        public ArrayList<DeTai> getDsdt() {
        return dsdt;
    }

    public void setDsdt(ArrayList<DeTai> dsdt) {
        this.dsdt = dsdt;
    }
        public void getDanhGia()
    {
        db.getConnect();
        String sql = "select * from DANHGIA where MANHOM = "+getmanhomt()+"";
        dsdg = db.getDataDG(sql);
    }
    public ArrayList<DanhGia> getDsdg() {
        return dsdg;
    }

    public void setDsdg(ArrayList<DanhGia> dsdg) {
        this.dsdg = dsdg;
    }
        public int getmanhomt()
    {
        db.getConnect();
        msv = ManHinhDangNhap.taikhoan.getUsername();
        String sql = "select MANHOM from SINHVIEN where MASV ='"+msv+"'";
        return db.getmanhom(sql);
    }
        // Quý
    public void insertdataDeTai(DeTai k) throws Exception{
        db.getConnect();
        String sql = "Insert into DETAI values('"+k.getMaDeTai()+"','"+k.getTenDeTai()+"'," + k.getTrangThai()+")";
        db.doSQL(sql);
    }
        public void getBaiTap() throws SQLException{
        db.getConnect();
        String sql = "select * from BAITAP";
        dsbt = db.getDataBT(sql);
    }
            public ArrayList<BaiTap> getDsbt(){
        return dsbt;
    }
    public void setDsbt(ArrayList<BaiTap> dsbt){
        this.dsbt = dsbt;
    }
        public void guiThongBaoGV(String nd, String filedk) throws Exception{
        maGV++;
        String matt = stt + maGV;
        
        db.getConnect();
        String sql = "Insert into THONGBAO values('"+matt+"','"+nd+"','"+filedk+"')";
        db.doSQL(sql);
    }
}
