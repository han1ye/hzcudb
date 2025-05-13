/*
 * Created by JFormDesigner on Tue Jul 09 13:26:57 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.event.*;
import cn.ljh.db.control.*;
import cn.ljh.db.model.CoachInfo;
import cn.ljh.db.model.TeamMember;
import cn.ljh.db.util.BaseException;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author LJH
 */
public class JDTeamMemberManager extends JDialog {
    public JDTeamMemberManager(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }

    private void Add(ActionEvent e) {
        // TODO add your code here
        new JDTeamMemberManagerCreate(this).setVisible(true);
        this.reloatTeamMemberTable();
    }

    private void Modify(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的行！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        TeamMember teamMember = TeamMemberList.get(row);
        new JDTeamMemberManagerModify(this, teamMember).setVisible(true);
        this.reloatTeamMemberTable();
    }

    private void Delete(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的行！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        TeamMember teamMember = TeamMemberList.get(row);
        int result = JOptionPane.showConfirmDialog(this, "确认删除？", "提示", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            try {
                new TeamMemberManager().deleteTeamMember(teamMember);
                JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                this.reloatTeamMemberTable();
            } catch (BaseException e1) {
                JOptionPane.showMessageDialog(this, "删除失败！" + e1.getMessage(), "提示", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void Refresh(ActionEvent e) {
        // TODO add your code here
        this.reloatTeamMemberTable();
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
        setTitle("\u961f\u4f0d\u6210\u5458\u7ba1\u7406");
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
        setSize(625, 425);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        {
            scrollPane1.setViewportView(table1);
        }
        this.reloatTeamMemberTable();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JButton Add;
    private JButton Modify;
    private JButton Delete;
    private JButton Refresh;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    List<TeamMember> TeamMemberList;
    private final Object[] tblTitle = {"所属队伍编号","队伍名","队伍容量","队伍人数","学号","姓名","是否为队长"};
    private  Object[][] tblData;
    DefaultTableModel tablmod = new DefaultTableModel();
    private final JTable table1 = new JTable(tablmod){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void reloatTeamMemberTable(){
        try {
            List<TeamMember> TeamMemberList = (new TeamMemberManager().LoadAllTeamMember());
            this.TeamMemberList = TeamMemberList;
            tblData = new Object[TeamMemberList.size()][7];
            for (int i = 0; i < TeamMemberList.size(); i++) {
                tblData[i][0] = TeamMemberList.get(i).getTeamCode();
                tblData[i][1] = (new TeamManager().LoadTeamByTeamCode(TeamMemberList.get(i).getTeamCode()).getTeamName());
                tblData[i][2] = (new TeamManager().LoadTeamByTeamCode(TeamMemberList.get(i).getTeamCode()).getTeamSize());
                tblData[i][3] = (new TeamManager().LoadTeamStuNumByTeamCode(TeamMemberList.get(i).getTeamCode()));
                tblData[i][4] = TeamMemberList.get(i).getStuNum();
                tblData[i][5] = (new StudentManager().loadStudentByStuNum(TeamMemberList.get(i).getStuNum()).getStuName());
                tblData[i][6] = TeamMemberList.get(i).isLeader()? "是" : "否";
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
