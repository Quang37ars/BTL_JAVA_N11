package Control;

import CustomTable.CustomTableThongBao;
import Model.ThongBao;
import View.XemThongBaoForm;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTable;

public class XemThongBaoController {

    private final ConnectDB db = new ConnectDB();

    public void init(XemThongBaoForm jFrameXemThongBao, ArrayList<ThongBao> list, JTable jTableThongBao) {
        jFrameXemThongBao.setResizable(false);
        jFrameXemThongBao.setTitle("Xem thông báo");
        jFrameXemThongBao.setLocationRelativeTo(null);
        jFrameXemThongBao.setDefaultCloseOperation(EXIT_ON_CLOSE);
        loadTable(list, jTableThongBao);
    }

    public void loadTable(ArrayList<ThongBao> list, JTable jTableThongBao) {
        selectDSThongBao(list);
        jTableThongBao.setModel(new CustomTableThongBao(list));
    }

    public void selectDSThongBao(ArrayList<ThongBao> dsThongBao) {
        db.getDataThongBao(dsThongBao);
    }

}
