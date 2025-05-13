/*
 * Created by JFormDesigner on Sun Jul 07 11:57:37 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import cn.ljh.db.control.TeacherManager;
import cn.ljh.db.control.TeamManager;
import cn.ljh.db.model.BeanTeacher;
import cn.ljh.db.model.BeanTeam;
import cn.ljh.db.util.BaseException;
import net.miginfocom.swing.*;

/**
 * @author LJH
 */
public class JDTeamManager extends JDialog {
    public JDTeamManager() {
        this.setModal(true);
        initComponents();
    }

    private void add(ActionEvent e) {
        // TODO add your code here
        new JDTeamManagerCreate(this).setVisible(true);
//        ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
//        s.schedule(this::reloadTeamTable, 500, TimeUnit.MICROSECONDS);
        this.Refresh(e);
    }

    private void Refresh(ActionEvent e) {
        // TODO add your code here
        TeamCode.setText("");
        TeamName.setText("");
        this.reloadTeamTable();
    }

    private void Delete(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的行！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String teamCode = Teams.get(row).getTeamCode();
        try {
            if (JOptionPane.showConfirmDialog(this, "确认删除队伍吗？", "警告", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                TeamManager tm = new TeamManager();
                tm.deleteTeam(teamCode);
                JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                this.reloadTeamTable();
            }
        }catch (BaseException e1){
            JOptionPane.showMessageDialog(this, "删除失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }

    }

    private void Modify(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的行！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        BeanTeam team = Teams.get(row);
        new JDTeamManagerModify(this, team).setVisible(true);
        this.Refresh(e);

    }

    private void Search(ActionEvent e) {
        // TODO add your code here
        this.reloadTeamTable();
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
        TeamCode = new JTextField();
        label3 = new JLabel();
        TeamName = new JTextField();
        Search = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setTitle("\u961f\u4f0d\u7ba1\u7406");
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
            label1.setText("\u67e5\u627e\u961f\u4f0d    ");
            menuBar1.add(label1);

            //---- label2 ----
            label2.setText("\u961f\u4f0d\u7f16\u53f7\uff1a");
            menuBar1.add(label2);
            menuBar1.add(TeamCode);

            //---- label3 ----
            label3.setText("\u961f\u4f0d\u540d\uff1a");
            menuBar1.add(label3);
            menuBar1.add(TeamName);

            //---- Search ----
            Search.setText("\u641c\u7d22");
            Search.addActionListener(e -> Search(e));
            menuBar1.add(Search);
        }
        setJMenuBar(menuBar1);
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        setSize(635, 415);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        {
            scrollPane1.setViewportView(table1);
        }
        this.reloadTeamTable();
        TeamCode.setText("");
        TeamName.setText("");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JButton add;
    private JButton Modify;
    private JButton Delete;
    private JButton Refresh;
    private JLabel label1;
    private JLabel label2;
    private JTextField TeamCode;
    private JLabel label3;
    private JTextField TeamName;
    private JButton Search;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    List<BeanTeam> Teams;
    private final Object[] tblTitle = {"队伍编号","队伍名称","英文队名","创建时间","队伍容量","备注"};
    private  Object[][] tblData;
    DefaultTableModel tablmod = new DefaultTableModel();
    private final JTable table1 = new JTable(tablmod){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void reloadTeamTable() {
        try {
            List<BeanTeam> Teams = (new TeamManager().searchTeam(TeamCode.getText(), TeamName.getText()));
            this.Teams = Teams;
            tblData = new Object[Teams.size()][6];
            for (int i = 0; i < Teams.size(); i++) {
                tblData[i][0] = Teams.get(i).getTeamCode();
                tblData[i][1] = Teams.get(i).getTeamName();
                tblData[i][2] = Teams.get(i).getTeamNameEn();
                tblData[i][3] = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(Teams.get(i).getCreatTime());
                tblData[i][4] = Teams.get(i).getTeamSize();
                tblData[i][5] = Teams.get(i).getNote();
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
