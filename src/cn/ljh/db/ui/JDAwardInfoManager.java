/*
 * Created by JFormDesigner on Tue Jul 09 08:36:42 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import cn.ljh.db.control.AwardInfoManager;
import cn.ljh.db.control.CompetitionManager;
import cn.ljh.db.model.AwardInfo;
import cn.ljh.db.model.AwardSearch;
import cn.ljh.db.model.BeanCompetition;
import cn.ljh.db.util.BaseException;
import net.miginfocom.swing.*;

/**
 * @author LJH
 */
public class JDAwardInfoManager extends JDialog {
    public JDAwardInfoManager(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }

    private void Add(ActionEvent e) {
        // TODO add your code here
        new JDAwardInfoManagerCreate(this).setVisible(true);
        this.reloatAwardInfoTable();
    }

    private void Modify(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的行！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try{
            AwardInfo awardInfo = (new AwardInfoManager().searchAwardInfo(AwardInfoList.get(row).getTeam().getTeamCode(),AwardInfoList.get(row).getCompetition().getCompNum()));
            new JDAwardInfoModify(this, awardInfo).setVisible(true);
        }catch (BaseException e1){
            JOptionPane.showMessageDialog(this, "修改失败！"+e1.getMessage(), "提示", JOptionPane.ERROR_MESSAGE);
        }
        this.reloatAwardInfoTable();
    }

    private void Delete(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的行！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int option = JOptionPane.showConfirmDialog(this, "确认删除吗？", "提示", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            try {
                AwardInfo awardInfo = (new AwardInfoManager().searchAwardInfo(AwardInfoList.get(row).getTeam().getTeamCode(),AwardInfoList.get(row).getCompetition().getCompNum()));
                (new AwardInfoManager()).deleteAwardInfo(awardInfo);
                JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            } catch (BaseException e1) {
                JOptionPane.showMessageDialog(this, "删除失败！"+e1.getMessage(), "提示", JOptionPane.ERROR_MESSAGE);
            }
            this.reloatAwardInfoTable();
        }
    }

    private void Refresh(ActionEvent e) {
        // TODO add your code here
        CompCode.setText("");
        CompName.setText("");
        this.reloatAwardInfoTable();
    }

    private void Search(ActionEvent e) {
        // TODO add your code here
        this.reloatAwardInfoTable();
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
        CompCode = new JTextField();
        label3 = new JLabel();
        CompName = new JTextField();
        Search = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setTitle("\u83b7\u5956\u4fe1\u606f\u7ba1\u7406");
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
            label1.setText("\u7b5b\u9009\u83b7\u5956\u4fe1\u606f    ");
            menuBar1.add(label1);

            //---- label2 ----
            label2.setText("\u8d5b\u4e8b\u5e8f\u53f7\uff1a");
            menuBar1.add(label2);
            menuBar1.add(CompCode);

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
        setSize(665, 460);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        {
            scrollPane1.setViewportView(table1);
        }
        this.reloatAwardInfoTable();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JButton Add;
    private JButton Modify;
    private JButton Delete;
    private JButton Refresh;
    private JLabel label1;
    private JLabel label2;
    private JTextField CompCode;
    private JLabel label3;
    private JTextField CompName;
    private JButton Search;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    java.util.List<AwardSearch> AwardInfoList;
    private final Object[] tblTitle = {"赛事序号","赛事名称","队伍编号","队伍名称","奖项等级"};
    private  Object[][] tblData;
    DefaultTableModel tablmod = new DefaultTableModel();
    private final JTable table1 = new JTable(tablmod){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void reloatAwardInfoTable(){
        try {
            List<AwardSearch> AwardInfoList = (new AwardInfoManager().searchAwardInfobyComp(CompCode.getText(), CompName.getText()));
            this.AwardInfoList = AwardInfoList;
            tblData = new Object[AwardInfoList.size()][5];
            for (int i = 0; i < AwardInfoList.size(); i++) {
                tblData[i][0] = AwardInfoList.get(i).getCompetition().getCompNum();
                tblData[i][1] = AwardInfoList.get(i).getCompetition().getCompName();
                tblData[i][2] = AwardInfoList.get(i).getTeam().getTeamCode();
                tblData[i][3] = AwardInfoList.get(i).getTeam().getTeamName();
                tblData[i][4] = AwardInfoList.get(i).getAwardInfo().getAwards();
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
