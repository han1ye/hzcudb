/*
 * Created by JFormDesigner on Mon Jul 08 13:03:38 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import cn.ljh.db.control.CompetitionManager;
import cn.ljh.db.model.BeanCompetition;
import cn.ljh.db.util.BaseException;

/**
 * @author LJH
 */
public class JDCompManager extends JDialog {
    public JDCompManager(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();

    }

    private void Refresh(ActionEvent e) {
        // TODO add your code here
        this.CompNum.setText("");
        this.CompName.setText("");
        this.reloatCompTable();
    }

    private void Add(ActionEvent e) {
        // TODO add your code here
        new JDCompManagerCreate(this).setVisible(true);
        this.reloatCompTable();
    }

    private void Delete(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的赛事！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        BeanCompetition comp = CompetitionList.get(row);
        try {
            if (JOptionPane.showConfirmDialog(this, "确定要删除该赛事吗？", "警告", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                CompetitionManager cm = new CompetitionManager();
                cm.deleteCompetition(comp.getCompNum());
                JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                this.reloatCompTable();
            }
        } catch (BaseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this, "删除失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void Modify(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的赛事！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        BeanCompetition comp = CompetitionList.get(row);
        new JDCompModify(this,comp).setVisible(true);
        this.reloatCompTable();
    }

    private void Search(ActionEvent e) {
        // TODO add your code here
        this.reloatCompTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        Add = new JButton();
        Modify = new JButton();
        Delete = new JButton();
        Refresh = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        CompNum = new JTextField();
        label3 = new JLabel();
        CompName = new JTextField();
        Search = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setTitle("\u8d5b\u4e8b\u7ba1\u7406");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //---- Add ----
            Add.setText("\u6dfb\u52a0");
            Add.addActionListener(e -> Add(e));
            menuBar1.add(Add);

            //---- Modify ----
            Modify.setText("\u4fee\u6539");
            Modify.addActionListener(e -> Modify(e));
            menuBar1.add(Modify);

            //---- Delete ----
            Delete.setText("\u5220\u9664");
            Delete.addActionListener(e -> Delete(e));
            menuBar1.add(Delete);

            //---- Refresh ----
            Refresh.setText("\u5237\u65b0");
            Refresh.addActionListener(e -> Refresh(e));
            menuBar1.add(Refresh);

            //---- label1 ----
            label1.setText("\u67e5\u627e\u8d5b\u4e8b    ");
            menuBar1.add(label1);

            //---- label2 ----
            label2.setText("\u8d5b\u4e8b\u5e8f\u53f7\uff1a");
            menuBar1.add(label2);
            menuBar1.add(CompNum);

            //---- label3 ----
            label3.setText("\u8d5b\u4e8b\u540d\u79f0\uff1a");
            menuBar1.add(label3);
            menuBar1.add(CompName);

            //---- Search ----
            Search.setText("\u641c\u7d22");
            Search.addActionListener(e -> Search(e));
            menuBar1.add(Search);
        }
        setJMenuBar(menuBar1);
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        setSize(660, 430);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        {
            scrollPane1.setViewportView(table1);
        }
        this.reloatCompTable();
        CompNum.setText("");
        CompName.setText("");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JButton Add;
    private JButton Modify;
    private JButton Delete;
    private JButton Refresh;
    private JLabel label1;
    private JLabel label2;
    private JTextField CompNum;
    private JLabel label3;
    private JTextField CompName;
    private JButton Search;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    List<BeanCompetition> CompetitionList;
    private final Object[] tblTitle = {"赛事序号","赛事名称","竞赛编号","举办时间","举办地点"};
    private  Object[][] tblData;
    DefaultTableModel tablmod = new DefaultTableModel();
    private final JTable table1 = new JTable(tablmod){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void reloatCompTable(){
        try {
            List<BeanCompetition> CompetitionList = (new CompetitionManager().searchCompetition(CompNum.getText(), CompName.getText()));
            this.CompetitionList = CompetitionList;
            tblData = new Object[CompetitionList.size()][5];
            for (int i = 0; i < CompetitionList.size(); i++) {
                tblData[i][0] = CompetitionList.get(i).getCompNum();
                tblData[i][1] = CompetitionList.get(i).getCompName();
                tblData[i][2] = CompetitionList.get(i).getMatchsCode();
                tblData[i][3] = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(CompetitionList.get(i).getOrganizeTime());
                tblData[i][4] = CompetitionList.get(i).getOrganizeArea();
            }
            tablmod.setDataVector(tblData, tblTitle);
            this.table1.validate();
            this.table1.repaint();
        } catch (BaseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
