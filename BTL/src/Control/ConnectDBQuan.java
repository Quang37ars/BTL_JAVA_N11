package Control;

import Model.BaiTap;
import Model.DanhGia;
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


public class ConnectDBQuan {
  Statement  stm = null;
  ResultSet rs = null;
  Connection cnn = null;

  private String uRl = "jdbc:derby://localhost:1527/BTL";
  private String userName = "administrator";
  private String pas = "123456";

  public void getConnect(){
    try {         
       //org.apache.derby.jdbc.ClientDriver
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        cnn = DriverManager.getConnection(uRl, userName,pas);    
    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
        JOptionPane.showMessageDialog(null,"Khong the ket noi voi database \n"+ex);
    }
  }
  
  public void closeConnect() throws SQLException
  {
    
    if(this.rs!=null&&!this.rs.isClosed())
    try{
        this.rs.close();
        this.rs=null;
    }catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "Loi dong ket qua");
    }

    if(this.stm!=null&&!this.stm.isClosed())
    try{
        this.stm.close();
        this.stm=null;
    }catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "Loi dong lenh thuc thi");
    }

    if(this.cnn!=null&&!this.cnn.isClosed())
    try{
        this.cnn.close();
        this.cnn=null;
    }catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "Loi dong ket noi");
    }

  }

  /*Bang 
  BAI
  TAP
  */
  
  public void getDataBaiTap(ArrayList dsBaiTap)  {
    String sql = "SELECT * FROM BAITAP" ;
    try {
      getConnect();
      stm = cnn.createStatement();
      rs = stm.executeQuery(sql);
      while (rs.next()) {
          BaiTap baiTap = new BaiTap(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
          dsBaiTap.add(baiTap);
      }   
      closeConnect();
    } catch (Exception ex) {           
        JOptionPane.showMessageDialog(null,"Loi lay du lieu tu bang \n"+ex);
    }
  }
  
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
      JOptionPane.showMessageDialog(null,"Loi chen du lieu\n"+ex);
    }
  }
  
  public void deleteBaiTap(String maBaiTap) {
    String deleteSQL = "DELETE FROM BAITAP WHERE MABAITAP = ?";
    try {
      getConnect();
      PreparedStatement preSta = cnn.prepareStatement(deleteSQL);
      preSta.setString(1, maBaiTap);
      preSta.executeUpdate();
      closeConnect();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,"Loi xoa du lieu\n"+ex);
    }
  }
  
  public void updateBaiTap(String maBaiTap, String ghiChuMoi, String linkBaiTapMoi) {
    String updateSQL = "UPDATE BAITAP "
                     + "SET LINKBAITAP =  ? AND GHICHU = ?"
                     + "WHERE MABAITAP = ?";
    try {
      getConnect();
      PreparedStatement preSta = cnn.prepareStatement(updateSQL);
      preSta.setString(2, ghiChuMoi);
      preSta.setString(1, linkBaiTapMoi);
      preSta.setString(3, maBaiTap);
      preSta.executeUpdate();
      closeConnect();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,"Loi cap nhat du lieu\n"+ex);
    }
  }
  
  public void getMaBaiTap(String a) {
    String sql = "Select mabaitap from baitap";
    try {
      getConnect();
      stm = cnn.createStatement();
      rs = stm.executeQuery(sql);
      while (rs.next()) {
          a = a + rs.getString("MABAITAP");
      } 
      
      closeConnect();
    } catch (SQLException ex) {
      Logger.getLogger(ConnectDBQuan.class.getName()).log(Level.SEVERE, null, ex);
    }
    
  }
  
  /*Bang
  THONG
  BAO
  */
  
  public void getDataThongBao(ArrayList dsThongBao)  {
    String sql = "SELECT * FROM THONGBAO";
    try {
      getConnect();
      stm = cnn.createStatement();
      rs = stm.executeQuery(sql);
      while (rs.next()) {
          dsThongBao.add(new ThongBao(rs.getString(1),rs.getString(2),rs.getString(3)));
      }  
      closeConnect();
    } catch (Exception ex) {           
        JOptionPane.showMessageDialog(null,"Loi lay du lieu tu bang THONGBAO \n"+ex.getMessage());
    }
  }
  
  public void insertThongBao(String maThongBao, String noiDung, String fileKem) {
    String insertSQL = "INSERT INTO THONGBAO VALUES(?, ?, ?)";
    try {
      getConnect();
      PreparedStatement preSta = cnn.prepareStatement(insertSQL);
      preSta.setString(1, maThongBao);
      preSta.setString(2, noiDung);
      preSta.setString(3, fileKem);
      preSta.executeUpdate();
      closeConnect();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,"Loi chen du lieu\n"+ex);
    }
  }
  
  public void deleteThongBao(String maThongBao) {
    String deleteSQL = "DELETE FROM THONGBAO WHERE MATHONGBAO = ?";
    try {
      getConnect();
      PreparedStatement preSta = cnn.prepareStatement(deleteSQL);
      preSta.setString(1, maThongBao);
      preSta.executeUpdate();
      closeConnect();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,"Loi xoa du lieu\n"+ex);
    }
  }
  
  public void updateThongBao(String maThongBao, String noiDung, String fileKem) {
    String updateSQL = "UPDATE THONGBAO "
                     + "SET NOIDUNG =  ? AND FILEKEM = ?"
                     + "WHERE MATHONGBAO = ?";
    try {
      getConnect();
      PreparedStatement preSta = cnn.prepareStatement(updateSQL);
      preSta.setString(1, noiDung);
      preSta.setString(2, fileKem);
      preSta.setString(3, maThongBao);
      preSta.executeUpdate();
      closeConnect();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,"Loi cap nhat du lieu\n"+ex);
    }
  }
  
  /*BANG
  DANH
  GIA
  */
  
  public void getDataDanhGia(ArrayList dsDanhGia)  {
    String sql = "SELECT * FROM DANHGIA";
    try {
      getConnect();
      stm = cnn.createStatement();
      rs = stm.executeQuery(sql);
      while (rs.next()) {
          dsDanhGia.add(new DanhGia(rs.getString(1),rs.getInt(2),rs.getDouble(3)));
      }    
      closeConnect();
    } catch (Exception ex) {           
        JOptionPane.showMessageDialog(null,"Loi lay du lieu tu bang DANHGIA \n"+ex.getMessage());
    }
  }
  
  public void insertDanhGia(String maDanhGia, int maNhom, double diem) {
    String insertSQL = "INSERT INTO DANHGIA VALUES(?, ?, ?)";
    try {
      getConnect();
      PreparedStatement preSta = cnn.prepareStatement(insertSQL);
      preSta.setString(1, maDanhGia);
      preSta.setInt(2, maNhom);
      preSta.setDouble(3, diem);
      preSta.executeUpdate();
      closeConnect();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,"Loi chen du lieu\n"+ex);
    }
  }
  
  public void deleteDanhGia(String maDanhGia) {
    String deleteSQL = "DELETE FROM DANHGIA WHERE MADANHGIA = ?";
    try {
      getConnect();
      PreparedStatement preSta = cnn.prepareStatement(deleteSQL);
      preSta.setString(1, maDanhGia);
      preSta.executeUpdate();
      closeConnect();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,"Loi xoa du lieu\n"+ex);
    }
  }
  
  public void updateDanhGia(String maDanhGia, int maNhom, double diem) {
    String updateSQL = "UPDATE DANHGIA "
                     + "SET MANHOM =  ? AND DIEM = ?"
                     + "WHERE MADANHGIA = ?";
    try {
      getConnect();
      PreparedStatement preSta = cnn.prepareStatement(updateSQL);
      preSta.setInt(1, maNhom);
      preSta.setDouble(2, diem);
      preSta.setString(3, maDanhGia);
      preSta.executeUpdate();
      closeConnect();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,"Loi cap nhat du lieu\n"+ex);
    }
  }
  
  public void selectDanhGiaByTenLop(ArrayList<DanhGia> dsDanhGia, String tenLop) {
    String selectSQL = "select * from danhgia\n" +
                       "where manhom in (select manhom from nhom \n" +
                       "where malop = (select malop from lophoc where tenlop = ?))";
    getConnect();
    try {
      PreparedStatement preSta = cnn.prepareStatement(selectSQL);
      preSta.setString(1, tenLop);
      rs = preSta.executeQuery();
      while (rs.next()) {
        dsDanhGia.add(new DanhGia(rs.getString(1),rs.getInt(2),rs.getDouble(3)));
      }
      closeConnect();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,"Loi lay du lieu\n"+ex);
    }
    
    
    
  }
  
  /*Bang
  LOP
  */

  public void getDataLopQuan(ArrayList dsLop)  {
    String sql = "SELECT * FROM LOPHOC" ;
    try {
      getConnect();
      stm = cnn.createStatement();
      rs = stm.executeQuery(sql);
      while (rs.next()) {
          Lop lop = new Lop(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
          dsLop.add(lop);
      } 
      closeConnect();
    } catch (Exception ex) {           
        JOptionPane.showMessageDialog(null,"Loi lay du lieu tu bang \n"+ex);
    }
  }
  public void getDataSVQuan(String sql)  {
    ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
    try {
      stm = cnn.createStatement();
      rs = stm.executeQuery(sql);

      while (rs.next()) {
          SinhVien sv = new SinhVien(rs.getString("MASV"),rs.getInt("MANHOM"),rs.getString("HOSV"),rs.getString("TENSV"),rs.getBoolean("NHOMTRUONG"));
          dsSV.add(sv);
      } 
      closeConnect();
    } catch (Exception ex) {           
        JOptionPane.showMessageDialog(null,"Loi lay du lieu tu bang \n"+ex);
    }
  }

}  