package Control;

import View.NopBaiForm;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

public class NopBaiController {
  
  public static int i = 0;
  private final ConnectDB db= new ConnectDB();
  
  public void selectMaBT(String a) {
    db.getMaBaiTap(a);
  }

  public void insertBaiTap(String linkBaiTap, String noiDung, int maNhom) {
    String a = "BT" + i;
    db.insertBaiTap(a, noiDung, linkBaiTap, maNhom);
    i++;
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
