/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.UploaddetaiController.list;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import Model.DeTai;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author phamt
 */
public class UploaddetaiController {

    public static ArrayList<DeTai> list = new ArrayList<>();
    static Workbook wb;
    static Sheet sheet;
    static DeTai dt;

    executeSQL DL = new executeSQL();
//    String filename = "‪C:\\Users\\phamt\\Desktop\\detaiBTL.xls";

    public void DocDL(String filename) throws IOException, FileNotFoundException, Exception {

        FileInputStream file = new FileInputStream(filename);

        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            dt = new DeTai();
            dt.setMaDeTai(row.getCell(0).getStringCellValue());
            dt.setTenDeTai(row.getCell(1).getStringCellValue());

            list.add(dt);
        }
        file.close();
        for (DeTai i : list) {
            DL.insertdataDeTai(i);
        }

    }

}
