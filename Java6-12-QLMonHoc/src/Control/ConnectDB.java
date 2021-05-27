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
import Model.ThongBao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 2XHQ
 */
public class ConnectDB {

    Statement stm = null;
    ResultSet rs = null;
    Connection cnn = null;

    private String uRl = "jdbc:derby://localhost:1527/BTL";//;create=true";
    private String userName = "administrator";
    private String pas = "123456";

    public void getConnect() {
        try {
            //org.apache.derby.jdbc.ClientDriver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            cnn = DriverManager.getConnection(uRl, userName, pas);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Khong the ket noi voi database \n" + ex);
        }
    }

    public void doSQL(String sql) throws Exception {
        try {
            stm = cnn.createStatement();
            stm.execute(sql);
        } catch (SQLException ex) {
            throw new Exception("Cau lenh Query khong duoc thuc thi" + ex);
        }
    }

    public ArrayList getDataLop(String sql) {
        ArrayList<Lop> ds = new ArrayList<Lop>();
        try {

            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Lop lop = new Lop(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                ds.add(lop);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Loi lay du lieu tu bang \n" + ex);
            return null;
        }
        return ds;
    }

    public String getmalop(String sql) throws SQLException {
        String kq = "";
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                kq = rs.getString(1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Loi lay du lieu tu bang \n" + ex);
            return null;
        }
        return kq;
    }

    public ArrayList getDataSV(String sql) {
        ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
        try {

            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString("MASV"), rs.getInt("MANHOM"), rs.getString("HOSV"), rs.getString("TENSV"), rs.getBoolean("NHOMTRUONG"));
                dsSV.add(sv);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Loi lay du lieu tu bang \n" + ex);
            return null;
        }
        return dsSV;
    }

    public void closeConnect() throws SQLException {
        //dong tu nho den lon
        if (this.rs != null && !this.rs.isClosed()) {
            try {
                this.rs.close();
                this.rs = null;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Loi dong ket qua");
            }
        }

        if (this.stm != null && !this.stm.isClosed()) {
            try {
                this.stm.close();
                this.stm = null;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Loi dong lenh thuc thi");
            }
        }

        if (this.cnn != null && !this.cnn.isClosed()) {
            try {
                this.cnn.close();
                this.cnn = null;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Loi dong ket noi");
            }
        }

    }

    public ArrayList getDataTK(String sql) {
        ArrayList<DangNhap> dstk = new ArrayList<>();
        try {

            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DangNhap dn = new DangNhap(rs.getString(1), rs.getString(2), rs.getString(3));
                dstk.add(dn);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Loi lay du lieu tu bang \n" + ex);
            return null;
        }
        return dstk;
    }

    public ArrayList getDataDanhgia(String sql) {
        ArrayList<DanhGia> dsDanhgia = new ArrayList<>();
        try {

            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                DanhGia detai = new DanhGia(rs.getString(1), rs.getInt(2), rs.getDouble(3));
                dsDanhgia.add(detai);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Loi lay du lieu tu bang \n" + ex);
            return null;
        }
        return dsDanhgia;
    }

    public ArrayList<Integer> getMaNhomQ1(String sql) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Loi lay du lieu tu bang \n" + ex);
        }
        return list;
    }

    //Quang 36
    public ArrayList<DeTai> getdsDeTaiQ2(String sql) {
        ArrayList<DeTai> ds = new ArrayList<DeTai>();
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DeTai dt = new DeTai(rs.getString(1),
                        rs.getString(2), rs.getString(3));
                ds.add(dt);
            }
        } catch (Exception ex) {
            System.out.println("loi getData " + ex.toString());
            return null;
        }
        return ds;
    }

    public ArrayList<DanhGia> getDataDG(String sql) {
        ArrayList<DanhGia> ds = new ArrayList<DanhGia>();
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DanhGia dg = new DanhGia(rs.getString(1),
                        rs.getInt(2), rs.getDouble(3));
                ds.add(dg);
            }
        } catch (Exception ex) {
            System.out.println("loi getData " + ex.toString());
            return null;
        }
        return ds;
    }

    public int getmanhom(String sql) {
        int manhom = 0;
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                manhom = rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("loi getData " + ex.toString());
            return 0;
        }
        return manhom;
    }

    // Quý
    public ArrayList<BaiTap> getDataBT(String sql) throws SQLException {
        ArrayList<BaiTap> ds = new ArrayList<BaiTap>();
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                BaiTap bt = new BaiTap(rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getInt(4));
                ds.add(bt);
            }
        } catch (Exception ex) {
            System.out.println("loi get data " + ex.toString());
            return null;
        }
        return ds;
    }

    //Quân
    public void insertBaiTap(String maBaiTap, String ghiChu, String linkBaiTap, int maNhom) {
        String insertSQL = "INSERT INTO BAITAP VALUES(?, ?, ?, ?)";
        try {
            getConnect();
            PreparedStatement preSta = cnn.prepareStatement(insertSQL);
            preSta.setString(1, maBaiTap);
            preSta.setString(2, ghiChu);
            preSta.setString(3, linkBaiTap);
            preSta.setInt(4, maNhom);
            preSta.executeUpdate();
            closeConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi chen du lieu\n" + ex);
        }
    }

    public void getMaBaiTap(ArrayList maBT) {
        String sql = "select mabaitap from baitap where mabaitap = (select max(mabaitap) from baitap)";
        try {
            getConnect();
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                maBT.add(new BaiTap(rs.getString(1)));
            }
            closeConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi lay du lieu\n" + ex);
        }

    }

    public void getDataThongBao(ArrayList dsThongBao) {
        String sql = "SELECT * FROM THONGBAO";
        try {
            getConnect();
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                dsThongBao.add(new ThongBao(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            closeConnect();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Loi lay du lieu tu bang THONGBAO \n" + ex.getMessage());
        }
    }

    public void getDataDanhGia(ArrayList dsDanhGia) {
        String sql = "SELECT * FROM DANHGIA";
        try {
            getConnect();
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                dsDanhGia.add(new DanhGia(rs.getString(1), rs.getInt(2), rs.getDouble(3)));
            }
            closeConnect();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Loi lay du lieu tu bang DANHGIA \n" + ex.getMessage());
        }
    }

    public void selectDanhGiaByTenLop(ArrayList<DanhGia> dsDanhGia, String tenLop) {
        String selectSQL = "select * from danhgia\n"
                + "where manhom in (select manhom from nhom \n"
                + "where malop = (select malop from lophoc where tenlop = ?))";
        getConnect();
        try {
            PreparedStatement preSta = cnn.prepareStatement(selectSQL);
            preSta.setString(1, tenLop);
            rs = preSta.executeQuery();
            while (rs.next()) {
                dsDanhGia.add(new DanhGia(rs.getString(1), rs.getInt(2), rs.getDouble(3)));
            }
            closeConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi lay du lieu\n" + ex);
        }
    }

    public void getDataLopQuan(ArrayList dsLop) {
        String sql = "SELECT * FROM LOPHOC";
        try {
            getConnect();
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Lop lop = new Lop(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                dsLop.add(lop);
            }
            closeConnect();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Loi lay du lieu tu bang \n" + ex);
        }
    }

    public void getmaNhom(SinhVien sv) {
        String selectSQL = "SELECT MANHOM FROM SINHVIEN WHERE MASV = ?";
        try {
            getConnect();
            PreparedStatement preSta = cnn.prepareStatement(selectSQL);
            preSta.setString(1, sv.getMaSV());
            rs = preSta.executeQuery();
            while (rs.next()) {
                sv.setMaNhom(rs.getInt(1));
            }
            closeConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi lay du lieu tu bang \n" + ex);
        }
    }

    public int getmaNhomMax() {
        String sql = "SELECT MAX(MANHOM) FROM NHOM";
        int i = 0;
        
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int k = rs.getInt(1);
                if(k*1 == k)
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Loi lay du lieu tu bang \n" + ex);
        }
        return i;
    }
    
    public String getMaLopChoose(String sql){
        String kq = "";
                try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                kq = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Loi lay du lieu tu bang \n" + ex);
        }
        return kq;
    }
    public void getDataBaiTap(ArrayList dsbt){
        String sql = "SELECT * FROM BAITAP";
        try{
            getConnect();
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next())
            {
                BaiTap baitap = new BaiTap(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                dsbt.add(baitap);
            }
            closeConnect();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Loi lay du lieu tu bang \n" + ex);
        }
        
    }
    public void selectThuBaiByTenLop(ArrayList<BaiTap> dsbt, String tenLop) {
        String selectSQL = "select * from baitap\n"
                + "where manhom in (select manhom from nhom \n"
                + "where malop = (select malop from lophoc where tenlop = ?))";
        getConnect();
        try {
            PreparedStatement preSta = cnn.prepareStatement(selectSQL);
            preSta.setString(1, tenLop);
            rs = preSta.executeQuery();
            while (rs.next()) {
                dsbt.add(new BaiTap(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4)));
            }
            closeConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi lay du lieu\n" + ex);
        }
    }
    
    public ArrayList<Integer> getListMaNhom(String sql){
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                list.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi lay du lieu\n" + ex);
        }
        return  list;
    }
        
    
}
