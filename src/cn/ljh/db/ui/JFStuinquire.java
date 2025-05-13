/*
 * Created by JFormDesigner on Fri Jul 12 11:06:50 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.event.*;
import cn.ljh.db.control.AwardInfoManager;
import cn.ljh.db.control.MatchsManager;
import cn.ljh.db.model.AwardSearch;
import cn.ljh.db.model.BeanCompetition;
import cn.ljh.db.model.BeanMatchs;
import cn.ljh.db.model.BeanStudent;
import cn.ljh.db.util.BaseException;

import java.awt.*;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author LJH
 */
public class JFStuinquire extends JDialog {
    public JFStuinquire() {
        initComponents();
    }
    public JFStuinquire(Window owner,BeanStudent student) {
        this.stu = student;
        initComponents();
    }

    private void ChoiceComp(ActionEvent e) {
        // TODO add your code here
        JDChoiceComp cc = new JDChoiceComp(this);
        cc.setVisible(true);
        if(cc.isok){
            CompNum.setText(cc.getValue().getCompNum());
            CompName.setText(cc.getValue().getCompName());
        }
    }

    private void Sreach(ActionEvent e) {
        // TODO add your code here
        startDate = DateTimeBegin.getDate();
        endDate = DateTimeEnd.getDate();
        comp.setCompNum(CompNum.getText());
        comp.setCompName(CompName.getText());
        this.reloadStudentTable();
    }

    private void Reset(ActionEvent e) {
        // TODO add your code here
        comp.setCompNum("");
        comp.setCompName("");
        CompNum.setText("");
        CompName.setText("");
        DateTimeBegin.setDate((new Date(2000 - 1900, 0, 1)));
        DateTimeEnd.setDate((new Date(2050 - 1900, 11, 31)));
        startDate = DateTimeBegin.getDate();
        endDate = DateTimeEnd.getDate();
        this.reloadStudentTable();

    }

    private void Logout(ActionEvent e) {
        // TODO add your code here
        if(JOptionPane.showConfirmDialog(this,"确定要退出吗？","提示",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ){
            JFLogin login = new JFLogin();
            login.setVisible(true);
            this.setVisible(false);
        }

    }

    private void DateTimeEnd(ActionEvent e) {
        // TODO add your code here
    }

    private void DateTimeBegin(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label1 = new JLabel();
        StuNum = new JTextField();
        label2 = new JLabel();
        StuName = new JTextField();
        Logout = new JButton();
        label3 = new JLabel();
        DateTimeBegin = new DateChooserJButton();
        label4 = new JLabel();
        DateTimeEnd = new DateChooserJButton();
        label5 = new JLabel();
        CompNum = new JTextField();
        label6 = new JLabel();
        CompName = new JTextField();
        Reset = new JButton();
        ChoiceComp = new JButton();
        Sreach = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setTitle("\u5b66\u751f\u4e2a\u4eba\u7ade\u8d5b\u67e5\u8be2");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

            //---- label1 ----
            label1.setText("\u5b66\u751f\u5b66\u53f7\uff1a");
            panel1.add(label1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(StuNum, new GridBagConstraints(2, 0, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label2 ----
            label2.setText("\u5b66\u751f\u59d3\u540d\uff1a");
            panel1.add(label2, new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(StuName, new GridBagConstraints(9, 0, 6, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- Logout ----
            Logout.setText("\u9000\u51fa\u767b\u5f55");
            Logout.addActionListener(e -> Logout(e));
            panel1.add(Logout, new GridBagConstraints(15, 0, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label3 ----
            label3.setText("\u8d77\u59cb\u65f6\u95f4\uff1a");
            panel1.add(label3, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- DateTimeBegin ----
            DateTimeBegin.setText("text");
            DateTimeBegin.addActionListener(e -> DateTimeBegin(e));
            panel1.add(DateTimeBegin, new GridBagConstraints(2, 1, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label4 ----
            label4.setText("\u7ed3\u675f\u65f6\u95f4\uff1a");
            panel1.add(label4, new GridBagConstraints(8, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- DateTimeEnd ----
            DateTimeEnd.setText("text");
            DateTimeEnd.addActionListener(e -> DateTimeEnd(e));
            panel1.add(DateTimeEnd, new GridBagConstraints(9, 1, 6, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label5 ----
            label5.setText("\u8d5b\u4e8b\u5e8f\u53f7\uff1a");
            panel1.add(label5, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
            panel1.add(CompNum, new GridBagConstraints(2, 2, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- label6 ----
            label6.setText("\u8d5b\u4e8b\u540d\u79f0\uff1a");
            panel1.add(label6, new GridBagConstraints(8, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
            panel1.add(CompName, new GridBagConstraints(9, 2, 6, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- Reset ----
            Reset.setText("\u91cd\u7f6e");
            Reset.addActionListener(e -> Reset(e));
            panel1.add(Reset, new GridBagConstraints(15, 2, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- ChoiceComp ----
            ChoiceComp.setText("\u9009\u62e9\u8d5b\u4e8b");
            ChoiceComp.addActionListener(e -> ChoiceComp(e));
            panel1.add(ChoiceComp, new GridBagConstraints(17, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- Sreach ----
            Sreach.setText("\u67e5\u8be2");
            Sreach.addActionListener(e -> Sreach(e));
            panel1.add(Sreach, new GridBagConstraints(18, 2, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        contentPane.add(panel1, BorderLayout.NORTH);
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        setSize(710, 500);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        {
            scrollPane1.setViewportView(table1);
        }
        StuNum.setEditable(false);
        StuName.setEditable(false);
        CompNum.setEditable(false);
        CompName.setEditable(false);
        StuNum.setText(stu.getStuNum());
        StuName.setText(stu.getStuName());
        comp.setCompNum("");
        comp.setCompName("");
        DateTimeBegin.setDate((new Date(2000 - 1900, 0, 1)));
        DateTimeEnd.setDate((new Date(2050 - 1900, 11, 31)));
        startDate = DateTimeBegin.getDate();
        endDate = DateTimeEnd.getDate();
        this.reloadStudentTable();
        // 监听窗口关闭事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Logout(new ActionEvent(e.getSource(), e.getID(), "Logout"));
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label1;
    private JTextField StuNum;
    private JLabel label2;
    private JTextField StuName;
    private JButton Logout;
    private JLabel label3;
    private DateChooserJButton DateTimeBegin;
    private JLabel label4;
    private DateChooserJButton DateTimeEnd;
    private JLabel label5;
    private JTextField CompNum;
    private JLabel label6;
    private JTextField CompName;
    private JButton Reset;
    private JButton ChoiceComp;
    private JButton Sreach;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private BeanStudent stu;
    private BeanCompetition comp=new BeanCompetition();
    private Date startDate;
    private Date endDate;

    private final Object[] tblTitle = {"学号","姓名","专业","班级","参加赛事","奖项等级","获奖时间","是否组队赛"};
    private  Object[][] tblData;
    DefaultTableModel tablmod = new DefaultTableModel();
    private final JTable table1 = new JTable(tablmod){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };


    private void reloadStudentTable() {
        try {
            BeanMatchs matchs = new BeanMatchs();
            matchs.setMatchsCode("");
            matchs.setMatchsName("");
            List<AwardSearch> awards = (new AwardInfoManager().fuzzySearchAwardInfo(stu,matchs,comp,startDate,endDate));
            tblData = new Object[awards.size()][8];
            for (int i = 0; i < awards.size(); i++) {
                tblData[i][0] = awards.get(i).getStudent().getStuNum();
                tblData[i][1] = awards.get(i).getStudent().getStuName();
                tblData[i][2] = awards.get(i).getStudent().getStuField();
                tblData[i][3] = awards.get(i).getStudent().getStuClass();
                tblData[i][4] = awards.get(i).getCompetition().getCompName();
                tblData[i][5] = awards.get(i).getAwardInfo().getAwards();
                tblData[i][6] = awards.get(i).getOrganizetime();
                tblData[i][7] = (new MatchsManager().getMatchs(awards.get(i).getMatchs().getMatchsCode()).isMatchsGroup()? "是" : "否");
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
