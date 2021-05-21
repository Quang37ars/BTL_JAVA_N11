package Control;

import Model.BaiTap;
import View.NopBaiForm;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

public class NopBaiController {
  
  private final ConnectDB db= new ConnectDB();
  
  public void insertBaiTap(String linkBaiTap, String noiDung, int maNhom) {
    ArrayList<BaiTap> m = new ArrayList<>();
    db.getMaBaiTap(m);
    String a = null;
    if(m.isEmpty()) {
      a = "BT001";
    }
    else {
      String b[] = m.get(0).getMaBaiTap().split("BT");
      int maBT = Integer.parseInt(b[1]) + 1;
      switch(dem(maBT)) {
            case 0:
                a = "BT00" + maBT;
                break;
            case 1:
                a = "BT0" + maBT;
                break;
            case 2:
                a = "BT" + maBT;
                break;
      }
    }
    db.insertBaiTap(a, noiDung, linkBaiTap, maNhom);
  }
  
  public int dem(int maBT) {
      int count = 0;
      while(maBT >= 10) {
          maBT = maBT/10;
          count ++;
      }
      return count;
  }
  
  public void init(NopBaiForm jFrameNopBai){
  jFrameNopBai.setTitle("Nộp bài");
  jFrameNopBai.setLocationRelativeTo(null);
  jFrameNopBai.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
  public void guiBaiAction(String linkBaiTap, String noiDung, int maNhom){
    int dialogBtn = JOptionPane.showConfirmDialog(null, "Bạn có muốn gửi không", "Confirm", JOptionPane.YES_NO_OPTION);
    if(dialogBtn == JOptionPane.YES_OPTION) {
      JOptionPane.showMessageDialog(null, "Nộp bài thành công");
      insertBaiTap(linkBaiTap, noiDung, maNhom);
    }
  }
  
}
