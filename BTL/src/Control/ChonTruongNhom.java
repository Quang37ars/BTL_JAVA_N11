/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.TaoLop.lop;
import Model.Lop;
import Model.SinhVien;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author 2XHQ
 */
public class ChonTruongNhom {
    ArrayList<SinhVien> list ;
    int next;
    ArrayList<SinhVien> svnhom;
    Iterator<SinhVien> myiterator;
    ConnectDB db = new ConnectDB();
    excuteSQL exsql = new excuteSQL();
    int sonhom;
    Lop lop;
    public ChonTruongNhom(){
        list = TaoLop.list;
        sonhom = TaoLop.sonhom;
        svnhom = new ArrayList<SinhVien>();
        myiterator = list.iterator();
        lop = TaoLop.lop;
    }
    
    
    public ArrayList<SinhVien> getsvnhom(){
        svnhom.clear();
        for(int i = 0;i<5;i++){
            SinhVien sv = myiterator.next();
            svnhom.add(sv);
        }
        return svnhom;
    }
    
    public void setNhomTruong(int x){
        list.get(x).setNhomTruong(true);
    }
    
    
    public void insertDataLop() throws Exception{
        
        
       db.getConnect();
           String sql1 = "INSERT INTO LOPHOC "+
                   "VALUES ('" + TaoLop.lop.getMaLop() + "','"+ TaoLop.lop.getTenLop() + "'," +
                   TaoLop.lop.getSiso() + ",'"+ TaoLop.lop.getKhoa() + "','" + TaoLop.lop.getTenHP() +"')";
           db.doSQL(sql1);
           for(int i = 1;i<sonhom + 1 ; i++){
            String sql3 = "INSERT INTO NHOM(MANHOM,MALOP) " +
                    "VALUES("+ i +",'"+ lop.getMaLop()+"')";
            db.doSQL(sql3);
        }
       for(SinhVien sv:list){
            String sql = "INSERT INTO SINHVIEN(MASV,MANHOM,HOSV,TENSV,NHOMTRUONG)" +
                    "VALUES('" +sv.getMaSV() + "',"+sv.getMaNhom()+",'"+ sv.getHoSV() +
                    "','"+ sv.getTenSV() + "'," + sv.isNhomTruong() +")";
            db.doSQL(sql);
            if(sv.isNhomTruong()){
                String sql4 = "INSERT INTO TAIKHOAN"+
                        " VALUES('"+ sv.getMaSV() + "','123456','NT')";
                db.doSQL(sql4);
            }else{
                String sql4 = "INSERT INTO TAIKHOAN"+
                        " VALUES('"+ sv.getMaSV() + "','123456','TV')";
                db.doSQL(sql4);
            }
        }
        
        
        
        db.closeConnect();
    }
    
}
