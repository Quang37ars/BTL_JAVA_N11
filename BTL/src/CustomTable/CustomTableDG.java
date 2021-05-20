/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Model.DanhGia;
/**
 *
 * @author ledan
 */
public class CustomTableDG extends AbstractTableModel {
    private String name[] = {"Mã nhóm","Điểm"};
    private Class classes[] = {String.class,float.class};
    ArrayList<DanhGia> dsdg = new ArrayList<DanhGia>();

    public CustomTableDG(ArrayList<DanhGia> list) {
        this.dsdg = list;
    }
    
    @Override
    public int getRowCount() {
        return dsdg.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch(i1)
        {
            case 0: return dsdg.get(i).getManhom();
            case 1: return dsdg.get(i).getDiem();
            default: return null;
        }
    }

    @Override
    public Class getColumnClass(int i) {
        return classes[i];
    }

    @Override
    public String getColumnName(int i) {
        return name[i];
    }
    
}
