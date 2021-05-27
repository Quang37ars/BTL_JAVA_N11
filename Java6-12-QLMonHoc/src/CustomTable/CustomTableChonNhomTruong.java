/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Model.Lop;
import Model.SinhVien;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 2XHQ
 */
public class CustomTableChonNhomTruong extends AbstractTableModel {

    private String a[] = {"Mã sinh viên", "Tên sinh viên"};
    private Class classes[] = {String.class, String.class};

    ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();

    @Override
    public int getRowCount() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dsSV.size();
    }

    public CustomTableChonNhomTruong(ArrayList<SinhVien> dsSV) {
        this.dsSV = dsSV;
    }

    @Override
    public int getColumnCount() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return a.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        switch (columnIndex) {
            case 0:
                return dsSV.get(rowIndex).getMaSV();
            case 1:
                return dsSV.get(rowIndex).getTenSV();

            default:
                return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return a[column];
    }
}
