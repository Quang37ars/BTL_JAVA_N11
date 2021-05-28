package CustomTable;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Model.BaiTap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ledan
 */
public class CustomTableBaiTap extends AbstractTableModel {

    private String name[] = {"Mã bài tập", "Ghi chú", "Link bài tập", "Nhóm"};
    private Class classes[] = {String.class, String.class, String.class, Integer.class};
    ArrayList<BaiTap> baitap = new ArrayList<BaiTap>();

    public CustomTableBaiTap(ArrayList<BaiTap> baitap) {
        this.baitap = baitap;
    }

    @Override
    public int getRowCount() {
        return baitap.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1) {
            case 0:
                return baitap.get(i).getMaBaiTap();
            case 1:
                return baitap.get(i).getGhiChu();
            case 2:
                return baitap.get(i).getLinkBaiTap();
            case 3:
                return baitap.get(i).getMaNhom();
            default:
                return null;
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
