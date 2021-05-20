package CustomTable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.DeTai;
/**
 *
 * @author ledan
 */
public class CustomTableDeTai extends AbstractTableModel {
    private String name[] = {"Mã đề tài","Tên đề tài"};
    private Class classes[] = {String.class,String.class};
    ArrayList<DeTai> DsDetai = new ArrayList<DeTai>();

    public CustomTableDeTai(ArrayList<DeTai> detai) {
        this.DsDetai = detai;
    }
    

    @Override
    public int getRowCount() {
        return DsDetai.size();
    }

    @Override
    public int getColumnCount() {
       return name.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch(i1)
        {
            case 0: return DsDetai.get(i).getMaDeTai();
            case 1: return DsDetai.get(i).getTenDeTai();
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
