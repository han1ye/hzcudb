/*
 * Created by JFormDesigner on Tue Jul 09 09:23:25 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.event.*;
import cn.ljh.db.control.TeamManager;
import cn.ljh.db.model.BeanTeam;
import cn.ljh.db.util.BaseException;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author LJH
 */
public class JDChoiceTeam extends JDialog {
    public JDChoiceTeam(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }

    private void Cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void OK(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择一个队伍！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        selectedTeam = Teams.get(row);
        JOptionPane.showMessageDialog(this, "选择的队伍编号为：" + selectedTeam.getTeamCode(), "提示", JOptionPane.INFORMATION_MESSAGE);
        isOK = true;
        this.dispose();
    }

    private void Search(ActionEvent e) {
        // TODO add your code here
        this.reloadTeamTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        label1 = new JLabel();
        label2 = new JLabel();
        TeamCode = new JTextField();
        label3 = new JLabel();
        TeamName = new JTextField();
        Search = new JButton();
        panel1 = new JPanel();
        Cancel = new JButton();
        OK = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setTitle("\u9009\u62e9\u6240\u5c5e\u961f\u4f0d");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //---- label1 ----
            label1.setText("\u7b5b\u9009\u961f\u4f0d    ");
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

        //======== panel1 ========
        {

            //---- Cancel ----
            Cancel.setText("\u53d6\u6d88");
            Cancel.addActionListener(e -> Cancel(e));

            //---- OK ----
            OK.setText("\u786e\u5b9a");
            OK.addActionListener(e -> OK(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(Cancel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 464, Short.MAX_VALUE)
                        .addComponent(OK)
                        .addGap(35, 35, 35))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Cancel)
                        .addComponent(OK))
            );
        }
        contentPane.add(panel1, BorderLayout.SOUTH);
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        setSize(640, 435);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        TeamName.setText("");
        TeamCode.setText("");
        {
            scrollPane1.setViewportView(table1);
        }
        this.reloadTeamTable();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JLabel label1;
    private JLabel label2;
    private JTextField TeamCode;
    private JLabel label3;
    private JTextField TeamName;
    private JButton Search;
    private JPanel panel1;
    private JButton Cancel;
    private JButton OK;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public boolean isOK = false;
    private BeanTeam selectedTeam;
    java.util.List<BeanTeam> Teams;
    private final Object[] tblTitle = {"队伍编号","队伍名称","英文队名","创建时间","队伍容量","队伍剩余容量","备注"};
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
            tblData = new Object[Teams.size()][7];
            for (int i = 0; i < Teams.size(); i++) {
                tblData[i][0] = Teams.get(i).getTeamCode();
                tblData[i][1] = Teams.get(i).getTeamName();
                tblData[i][2] = Teams.get(i).getTeamNameEn();
                tblData[i][3] = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(Teams.get(i).getCreatTime());
                tblData[i][4] = Teams.get(i).getTeamSize();
                tblData[i][5] = (new TeamManager().LoadTeamByTeamCode(Teams.get(i).getTeamCode()).getTeamSize() - (new TeamManager().LoadTeamStuNumByTeamCode(Teams.get(i).getTeamCode())));
                tblData[i][6] = Teams.get(i).getNote();
            }
            tablmod.setDataVector(tblData, tblTitle);
            this.table1.validate();
            this.table1.repaint();
        } catch (BaseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public BeanTeam getValue() {
        return selectedTeam;
    }
}
