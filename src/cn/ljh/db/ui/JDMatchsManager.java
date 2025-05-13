/*
 * Created by JFormDesigner on Mon Jul 08 09:53:22 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import cn.ljh.db.control.MatchsManager;
import cn.ljh.db.control.TeamManager;
import cn.ljh.db.model.BeanMatchs;
import cn.ljh.db.util.BaseException;
import net.miginfocom.swing.*;

/**
 * @author LJH
 */
public class JDMatchsManager extends JDialog {
    public JDMatchsManager() {
        this.setModal(true);
        initComponents();
    }

    private void add(ActionEvent e) {
        // TODO add your code here
        new JDMatchsManagerCreate(this).setVisible(true);
        this.reloatMatchsTable();
    }

    private void Refresh(ActionEvent e) {
        // TODO add your code here
        MatchsCode.setText("");
        MatchsName.setText("");
        this.reloatMatchsTable();
    }

    private void Delete(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的行！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(this, "确认删除该行吗？", "确认", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            String matchsCode = (String) tblData[row][0];
            try {
                new MatchsManager().deleteMatchs(matchsCode);
                JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                this.reloatMatchsTable();
            } catch (BaseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "删除失败！"+e1.getMessage(), "提示", JOptionPane.ERROR_MESSAGE);
            }
    }
    }

    private void Modify(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的行！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        BeanMatchs matchs = matchsList.get(row);
        new JDMatchsManagerModify(matchs).setVisible(true);
        this.reloatMatchsTable();
    }

    private void Search(ActionEvent e) {
        // TODO add your code here
        this.reloatMatchsTable();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        add = new JButton();
        Modify = new JButton();
        Delete = new JButton();
        Refresh = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        MatchsCode = new JTextField();
        label3 = new JLabel();
        MatchsName = new JTextField();
        Search = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setTitle("\u7ade\u8d5b\u7ba1\u7406");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //---- add ----
            add.setText("\u6dfb\u52a0");
            add.addActionListener(e -> add(e));
            menuBar1.add(add);

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
            label1.setText("\u67e5\u627e\u7ade\u8d5b    ");
            menuBar1.add(label1);

            //---- label2 ----
            label2.setText("\u7ade\u8d5b\u7f16\u53f7\uff1a");
            menuBar1.add(label2);
            menuBar1.add(MatchsCode);

            //---- label3 ----
            label3.setText("\u7ade\u8d5b\u540d\u79f0\uff1a");
            menuBar1.add(label3);
            menuBar1.add(MatchsName);

            //---- Search ----
            Search.setText("\u641c\u7d22");
            Search.addActionListener(e -> Search(e));
            menuBar1.add(Search);
        }
        setJMenuBar(menuBar1);
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        setSize(660, 460);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        {
            scrollPane1.setViewportView(table1);
        }
        this.reloatMatchsTable();
        MatchsCode.setText("");
        MatchsName.setText("");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JButton add;
    private JButton Modify;
    private JButton Delete;
    private JButton Refresh;
    private JLabel label1;
    private JLabel label2;
    private JTextField MatchsCode;
    private JLabel label3;
    private JTextField MatchsName;
    private JButton Search;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    List<BeanMatchs> matchsList;
    private final Object[] tblTitle = {"竞赛编号","竞赛名称","主办单位","承办单位","是否为组队赛","竞赛介绍"};
    private  Object[][] tblData;
    DefaultTableModel tablmod = new DefaultTableModel();
    private final JTable table1 = new JTable(tablmod){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private void reloatMatchsTable(){
        try {
            List<BeanMatchs> matchsList = (new MatchsManager().searchMatchs(MatchsCode.getText(), MatchsName.getText()));
            this.matchsList = matchsList;
            tblData = new Object[matchsList.size()][6];
            for (int i = 0; i < matchsList.size(); i++) {
                tblData[i][0] = matchsList.get(i).getMatchsCode();
                tblData[i][1] = matchsList.get(i).getMatchsName();
                tblData[i][2] = matchsList.get(i).getOrganizer();
                tblData[i][3] = matchsList.get(i).getContractor();
                tblData[i][4] = matchsList.get(i).isMatchsGroup()? "是" : "否";
                tblData[i][5] = matchsList.get(i).getMatchsInfo();
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
