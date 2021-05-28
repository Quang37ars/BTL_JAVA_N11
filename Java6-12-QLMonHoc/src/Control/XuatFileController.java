package Control;

import Model.DanhGia;
import Model.Lop;
import View.XuatFileForm;
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

public class XuatFileController {

    private final ConnectDB db = new ConnectDB();

    public void selectDSLop(ArrayList<Lop> dsLop) {
        db.getDataLopQuan(dsLop);
    }

    public void selectDanhGia(ArrayList<DanhGia> dsDanhGia) {
        db.getDataDanhGia(dsDanhGia);
    }

    public void xuatFileAction(HSSFWorkbook workbook, ArrayList<DanhGia> dsDanhGia, String tenLop) {
        db.selectDanhGiaByTenLop(dsDanhGia, tenLop);
        initExcelFile(workbook, dsDanhGia, tenLop);
    }

    public void init(XuatFileForm jFrameXuatFile, JComboBox jComboBoxDSLop, ArrayList<Lop> dsLop) {
        jFrameXuatFile.setTitle("Xuất file Excel");
        jFrameXuatFile.setLocationRelativeTo(null);
        jFrameXuatFile.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initCbo(jComboBoxDSLop, dsLop);
    }

    public void initCbo(JComboBox jComboBoxDSLop, ArrayList<Lop> dsLop) {
        jComboBoxDSLop.setModel(new DefaultComboBoxModel());
        db.getDataLopQuan(dsLop);
        Iterator<Lop> itLopHoc = dsLop.iterator();
        while (itLopHoc.hasNext()) {
            jComboBoxDSLop.addItem(itLopHoc.next().getTenLop());
        }
        jComboBoxDSLop.setSelectedIndex(0);
    }

    public void initExcelFile(HSSFWorkbook workbook, ArrayList<DanhGia> dsDanhGia, String tenLop) {
        //Create a cellstyle
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        //Create a spreadsheet
        HSSFSheet sheet = workbook.createSheet("Đánh giá " + tenLop);

        //Create a row object
        HSSFRow row;

        //Create cell & setvalue
        row = sheet.createRow(0);
        Cell cell0 = row.createCell(0);
        Cell cell1 = row.createCell(1);
        Cell cell2 = row.createCell(2);

        cell0.setCellStyle(cellStyle);
        cell1.setCellStyle(cellStyle);
        cell2.setCellStyle(cellStyle);

        cell0.setCellValue("Mã đánh giá");
        cell1.setCellValue("Mã nhóm");
        cell2.setCellValue("Điểm");

        //Create cells & rows for the data
        for (int i = 0; i < dsDanhGia.size(); i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < 3; j++) {
                Cell cell = row.createCell(j);
                cell.setCellStyle(cellStyle);
                if (cell.getColumnIndex() == 0) {
                    cell.setCellValue(dsDanhGia.get(i).getMadanhgia());
                }
                if (cell.getColumnIndex() == 1) {
                    cell.setCellValue(dsDanhGia.get(i).getManhom());
                }
                if (cell.getColumnIndex() == 2) {
                    cell.setCellValue(dsDanhGia.get(i).getDiem());
                }
            }
        }

        //Auto resize column
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }
        //Writing excel file
        writingExcelFile(workbook, tenLop);
    }

    public void writingExcelFile(HSSFWorkbook workbook, String tenLop) {
        File a = new File("DanhGia" + tenLop + ".xls");
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
    }
}
