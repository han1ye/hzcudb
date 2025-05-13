/*
 * Created by JFormDesigner on Tue Jul 09 10:38:54 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.event.*;
import cn.ljh.db.control.*;
import cn.ljh.db.model.AwardInfo;
import cn.ljh.db.model.CoachInfo;
import cn.ljh.db.util.BaseException;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author LJH
 */
public class JDCoachManager extends JDialog {
    public JDCoachManager(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }

    private void Add(ActionEvent e) {
        // TODO add your code here
        new JDCoachManagerCreate(this).setVisible(true);
        this.reloatCoachTable();
    }

    private void Refresh(ActionEvent e) {
        // TODO add your code here
        this.reloatCoachTable();
    }

    private void Delete(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的行！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        CoachInfo coachInfo = CoachInfoList.get(row);
        int result = JOptionPane.showConfirmDialog(this, "确认删除?", "确认", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            new CoachManager().deleteCoachInfo(coachInfo);
            JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            this.reloatCoachTable();
        } catch (BaseException e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Modify(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的行！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        CoachInfo coachInfo = CoachInfoList.get(row);
        new JDCoachManagerModify(this, coachInfo).setVisible(true);
        this.reloatCoachTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        Add = new JButton();
        Modify = new JButton();
        Delete = new JButton();
        Refresh = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setTitle("\u6307\u5bfc\u4fe1\u606f\u7ba1\u7406");
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
        }
        setJMenuBar(menuBar1);
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        setSize(670, 460);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        {
            scrollPane1.setViewportView(table1);
        }
        reloatCoachTable();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JButton Add;
    private JButton Modify;
    private JButton Delete;
    private JButton Refresh;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    List<CoachInfo> CoachInfoList;
    private final Object[] tblTitle = {"队伍编号","队伍名","职工号","指导老师姓名","赛事序号","赛事名"};
    private  Object[][] tblData;
    DefaultTableModel tablmod = new DefaultTableModel();
    private final JTable table1 = new JTable(tablmod){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void reloatCoachTable(){
        try {
            List<CoachInfo> CoachInfoList = (new CoachManager().LoadAllCoachInfo());
            this.CoachInfoList = CoachInfoList;
            tblData = new Object[CoachInfoList.size()][6];
            for (int i = 0; i < CoachInfoList.size(); i++) {
                tblData[i][0] = CoachInfoList.get(i).getTeamCode();
                tblData[i][1] = (new TeamManager().LoadTeamByTeamCode(CoachInfoList.get(i).getTeamCode()).getTeamName());
                tblData[i][2] = CoachInfoList.get(i).getTeaNum();
                tblData[i][3] = (new TeacherManager().LoadTeacherByNum(CoachInfoList.get(i).getTeaNum()).getTeaName());
                tblData[i][4] = CoachInfoList.get(i).getCompNum();
                tblData[i][5] = (new CompetitionManager().LoadCompetitionByCompNum(CoachInfoList.get(i).getCompNum()).getCompName());
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
