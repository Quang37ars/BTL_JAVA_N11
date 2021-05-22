/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Lop;
import Model.SinhVien;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;






/**
 *
 * @author 2XHQ
 */
public class TaoLopController {
    public static ArrayList<SinhVien> list = new ArrayList<>();
    static Workbook wb;
    static Sheet sheet;
    static SinhVien sv;
    public static int sonhom;
    public static Lop lop = new Lop();
   // String filename1 = "C:\\Users\\2XHQ\\Desktop\\Sinhvien.xls";
    executeSQL exsql = new executeSQL();
    public TaoLopController(){
        
    }
         public void DocDL(String filename) throws FileNotFoundException, IOException, Exception {
        //doc file 
        FileInputStream file = new FileInputStream(filename);
        
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(0);
        
        Iterator<Row> rowIterator = sheet.iterator();
        //lay du lieu lop
        Row r = rowIterator.next();
        lop.setMaLop(r.getCell(1).getStringCellValue());
        lop.setTenLop(r.getCell(3).getStringCellValue());
        r = rowIterator.next();
        lop.setKhoa(r.getCell(1).getStringCellValue());
        r = rowIterator.next();
        lop.setTenHP(r.getCell(1).getStringCellValue());
        double a = r.getCell(3).getNumericCellValue();
        lop.setSiso((int)a);
        //tim so nhom
        if(lop.getSiso() % 5 == 0) sonhom =  lop.getSiso() /5;
                else sonhom =  lop.getSiso() /5 + 1;
        //lay du leu sinh vien
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            sv = new SinhVien();
            double ma = row.getCell(1).getNumericCellValue();
            Integer k = (int) ma;
            sv.setMaSV(k.toString());
            sv.setHoSV(row.getCell(2).getStringCellValue());
            sv.setTenSV(row.getCell(3).getStringCellValue());
            list.add(sv);
        }
        file.close();
        }
         public static void main(String[] args) {
        
    }
        public void TaoNhomRanDom(){
            //xao tron vi tri trong list
            Collections.shuffle(list);
            int i =1;
            int nhom = 1;
            Iterator<SinhVien> it = list.iterator();
            while(it.hasNext()){
                it.next().setMaNhom(nhom);
                i++;
                if(i == 6){
                    i = 1;
                    nhom ++; 
                }
            }
        }
       public void TaoNhomThuong(){
            int i =1;
            int nhom = 1;
            Iterator<SinhVien> it = list.iterator();
            while(it.hasNext()){
                it.next().setMaNhom(nhom);
                i++;
                if(i == 6){
                    i = 1;
                    nhom ++;
                }
            }
        }
       

       

    }
    
        
    

