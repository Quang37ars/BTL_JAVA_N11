package Control;

import Model.ThongBao;
import View.XemThongBaoForm;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTable;

public class XemThongBaoController {
  
  private final ConnectDBQuan db= new ConnectDBQuan();
  
  public void init(XemThongBaoForm jFrameXemThongBao, ArrayList<ThongBao> list, JTable jTableThongBao) {
    jFrameXemThongBao.setResizable(false);
    jFrameXemThongBao.setTitle("Xem thông báo");
    jFrameXemThongBao.setLocationRelativeTo(null);
    jFrameXemThongBao.setDefaultCloseOperation(EXIT_ON_CLOSE);
    loadTable(list, jTableThongBao);
  }
  
  public void initList(ArrayList<ThongBao> list) {
    list.add(new ThongBao("TB01", "Nộp bài", "?"));
    list.add(new ThongBao("TB02", "Nộp bài", "?"));
    list.add(new ThongBao("TB03", "Bộp bài", "?"));
  }
  
  public void loadTable(ArrayList<ThongBao> list, JTable jTableThongBao){
    selectDSThongBao(list);
    jTableThongBao.setModel(new XemThongBaoCustomTable(list));
  }
  
  public void selectDSThongBao(ArrayList<ThongBao> dsThongBao) {
    db.getDataThongBao(dsThongBao);
  }
  
}
