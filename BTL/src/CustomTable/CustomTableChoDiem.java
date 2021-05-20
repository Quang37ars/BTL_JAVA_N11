/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;


import Model.DanhGia;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author quang
 */
public class CustomTableChoDiem extends AbstractTableModel  {
     private String a[] = {"Mã đánh giá","Mã nhóm","Điểm"};
    private Class classes[] = {String.class,int.class,Double.class};

    
    
    ArrayList<DanhGia> dsDetai = new ArrayList<>();
     @Override
    public int getRowCount() {
        return dsDetai.size();
    }
    
    public CustomTableChoDiem(ArrayList<DanhGia> dsDetai) {
        this.dsDetai=dsDetai;
    }

     @Override
    public int getColumnCount() {
        return a.length;
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return dsDetai.get(rowIndex).getMadanhgia();
            case 1: return dsDetai.get(rowIndex).getManhom();
            case 2: return dsDetai.get(rowIndex).getDiem();
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
