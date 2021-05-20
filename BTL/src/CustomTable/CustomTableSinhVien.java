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
public class CustomTableSinhVien extends AbstractTableModel{
    private String a[] = {"Mã nhóm","Mã sinh viên","Họ sinh viên","Tên sinh viên","Nhóm trưởng"};
    private Class classes[] = {Integer.class,String.class,String.class,String.class,Boolean.class};

    
    ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
    @Override
    public int getRowCount() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dsSV.size();
    }

    public CustomTableSinhVien(ArrayList<SinhVien> dsSV) {
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
        switch(columnIndex){
            case 0: return dsSV.get(rowIndex).getMaNhom();
            case 1: return dsSV.get(rowIndex).getMaSV();
            case 2: return dsSV.get(rowIndex).getHoSV();
            case 3: return dsSV.get(rowIndex).getTenSV();
            case 4: return dsSV.get(rowIndex).isNhomTruong();
            
            default : return null;
        }
    }
    @Override
    public Class getColumnClass(int columnIndex)
    {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column)
    {
        return a[column];
    }
}
