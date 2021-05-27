/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.BaiTap;
import Model.Lop;
import View.BaitapUI;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 *
 * @author phamt
 */
public class XuatfileThuBai {
     private final ConnectDB db = new ConnectDB();

    public void selectDSLop(ArrayList<Lop> dsLop) {
        db.getDataLopQuan(dsLop);
    }

    public void selectDanhGia(ArrayList<BaiTap> dsbt) {
        db.getDataBaiTap(dsbt);
    }

    public void xuatFileAction(HSSFWorkbook workbook, ArrayList<BaiTap> dsbt, String tenLop) {
        db.selectThuBaiByTenLop(dsbt, tenLop);
        initExcelFile(workbook, dsbt, tenLop);
    }

    public void init(BaitapUI jFrameXuatFile, JComboBox jComboBoxchonlop, ArrayList<Lop> dsLop) {
        jFrameXuatFile.setTitle("Xuất file Excel");
        jFrameXuatFile.setLocationRelativeTo(null);
        jFrameXuatFile.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initCbo(jComboBoxchonlop, dsLop);
    }

    public void initCbo(JComboBox jComboBoxchonlop, ArrayList<Lop> dsLop) {
        jComboBoxchonlop.setModel(new DefaultComboBoxModel());
        db.getDataLopQuan(dsLop);
        Iterator<Lop> itLopHoc = dsLop.iterator();
        while (itLopHoc.hasNext()) {
            jComboBoxchonlop.addItem(itLopHoc.next().getTenLop());
        }
        jComboBoxchonlop.setSelectedIndex(0);
    }

    public void initExcelFile(HSSFWorkbook workbook, ArrayList<BaiTap> dsbt, String tenLop) {
        //Create a cellstyle
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        //Create a spreadsheet
        HSSFSheet sheet = workbook.createSheet("Thu Bai " + tenLop);

        //Create a row object
        HSSFRow row;

        //Create cell & setvalue
        row = sheet.createRow(0);
        Cell cell0 = row.createCell(0);
        Cell cell1 = row.createCell(1);
        Cell cell2 = row.createCell(2);
        Cell cell3 = row.createCell(3);
        
        cell0.setCellStyle(cellStyle);
        cell1.setCellStyle(cellStyle);
        cell2.setCellStyle(cellStyle);
        cell3.setCellStyle(cellStyle);
        
        cell0.setCellValue("Mã bài tập");
        cell1.setCellValue("Ghi chú");
        cell2.setCellValue("Link bài tập");
        cell3.setCellValue("Nhóm");

        //Create cells & rows for the data
        for (int i = 0; i < dsbt.size(); i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < 4; j++) {
                Cell cell = row.createCell(j);
                cell.setCellStyle(cellStyle);
                if (cell.getColumnIndex() == 0) {
                    cell.setCellValue(dsbt.get(i).getMaBaiTap());
                }
                if (cell.getColumnIndex() == 1) {
                    cell.setCellValue(dsbt.get(i).getGhiChu());
                }
                if (cell.getColumnIndex() == 2) {
                    cell.setCellValue(dsbt.get(i).getLinkBaiTap());
                }
                if (cell.getColumnIndex() == 3) {
                    cell.setCellValue(dsbt.get(i).getMaNhom());
                }
            }
        }

        //Auto resize column
        for (int i = 0; i < 4; i++) {
            sheet.autoSizeColumn(i);
        }
        //Writing excel file
        writingExcelFile(workbook, tenLop);
    }

    public void writingExcelFile(HSSFWorkbook workbook, String tenLop) {
//    JFileChooser saveFile = new JFileChooser();
//    saveFile.setDialogTitle("Save file");
//    saveFile.setSelectedFile(new File(".xlsx"));
//    FileNameExtensionFilter xlsxfilter = new FileNameExtensionFilter("xlsx (*.xlsx)", "xlsx");
//    saveFile.setFileFilter(xlsxfilter);
//    if(saveFile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
//      File output = saveFile.getSelectedFile();
        File a = new File("THUBAI" + tenLop + ".xls");
        try (FileOutputStream out = new FileOutputStream(a)) {
            workbook.write(out);
            out.close();
            File f = a.getAbsoluteFile();
            if (!f.exists()) {
                JOptionPane.showMessageDialog(null, "File không tồn tại.", "Message", JOptionPane.OK_OPTION);
            } else if (!Desktop.isDesktopSupported()) {
                JOptionPane.showMessageDialog(null, "Desktop không hỗ trợ file này.", "Warning", JOptionPane.OK_OPTION);
            } else {
                Desktop.getDesktop().open(f);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.CLOSED_OPTION);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Message", JOptionPane.CLOSED_OPTION);
        }
//    }
    }
}
