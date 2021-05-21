package CustomTable;

import Model.ThongBao;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CustomTableThongBao extends AbstractTableModel{
  private final String[] title;
  private final Class[] classes;
  ArrayList<ThongBao> list = new ArrayList<>();

  public CustomTableThongBao(ArrayList<ThongBao> list) {
    this.classes = new Class[]{String.class, String.class, String.class};
    this.title = new String[]{"Mã thông báo", "Nội dung", "File kèm"};
    this.list = list;
  }
  
  @Override
  public int getRowCount() {
    return list.size();
  }

  @Override
  public int getColumnCount() {
    return title.length;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch(columnIndex){
      case 0: return list.get(rowIndex).getMaThongBao();
      case 1: return list.get(rowIndex).getNoiDung();
      case 2: return list.get(rowIndex).getFlieDinhKem();
      default: return null;
    }
  }

  @Override
  public Class<?> getColumnClass(int i) {
    return classes[i];
  }

  @Override
  public String getColumnName(int i) {
    return title[i];
  }
  
}
