/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Model.Lop;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 2XHQ
 */
public class CustomTableLop extends AbstractTableModel{
    private String a[] = {"Mã lớp","Tên lớp","Tên học phần","Khóa","Sĩ số"};
    private Class classes[] = {String.class,String.class,String.class,String.class,Integer.class};

    
    ArrayList<Lop> dsLop = new ArrayList<Lop>();
    @Override
    public int getRowCount() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dsLop.size();
    }

    public CustomTableLop(ArrayList<Lop> dsLop) {
        this.dsLop = dsLop;
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
            case 0: return dsLop.get(rowIndex).getMaLop();
            case 1: return dsLop.get(rowIndex).getTenLop();
            case 2: return dsLop.get(rowIndex).getTenHP();
            case 3: return dsLop.get(rowIndex).getKhoa();
            case 4: return dsLop.get(rowIndex).getSiso();
            
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
