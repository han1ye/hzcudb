/*
 * Created by JFormDesigner on Tue Jul 09 15:55:29 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.event.*;
import cn.ljh.db.control.AwardInfoManager;
import cn.ljh.db.model.*;
import cn.ljh.db.util.BaseException;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author LJH
 */
public class JDAwardSearch extends JDialog {
    public JDAwardSearch(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }

    private void ChoiceStu(ActionEvent e) {
        // TODO add your code here
        JDChoiceStu cs = new JDChoiceStu(this);
        cs.setVisible(true);
        if(cs.isOK){
            StuNum.setText(cs.getValue().getStuNum());
            StuName.setText(cs.getValue().getStuName());
            StuClass.setText(cs.getValue().getStuClass());
            StuField.setText(cs.getValue().getStuField());
        }
    }

    private void ChoiceMatch(ActionEvent e) {
        // TODO add your code here
        JDChoiceMatch cm = new JDChoiceMatch(this);
        cm.setVisible(true);
        if(cm.ok){
            MatchsName.setText(cm.getValue().getMatchsName());
            MatchsCode.setText(cm.getValue().getMatchsCode());
        }
    }

    private void ChoiceComp(ActionEvent e) {
        // TODO add your code here
        JDChoiceComp cc = new JDChoiceComp(this);
        cc.setVisible(true);
        if(cc.isok){
            CompName.setText(cc.getValue().getCompName());
            CompNum.setText(cc.getValue().getCompNum());
        }
    }

    private void DateTimeBegin(ActionEvent e) {
        // TODO add your code here
    }

    private void DateTimeEnd(ActionEvent e) {
        // TODO add your code here
    }

    private void Search(ActionEvent e) {
        // TODO add your code here
        searchstu.setStuNum(StuNum.getText());
        searchstu.setStuName(StuName.getText());
        searchstu.setStuClass(StuClass.getText());
        searchstu.setStuField(StuField.getText());
        searchmatchs.setMatchsName(MatchsName.getText());
        searchmatchs.setMatchsCode(MatchsCode.getText());
        searchcomp.setCompName(CompName.getText());
        searchcomp.setCompNum(CompNum.getText());
        beginDate = DateTimeBegin.getDate();
        endDate = DateTimeEnd.getDate();
        this.reloatAwardInfoTable();
    }

    private void Reset(ActionEvent e) {
        // TODO add your code here
        StuNum.setText("");
        StuName.setText("");
        StuClass.setText("");
        StuField.setText("");
        MatchsName.setText("");
        CompName.setText("");
        MatchsCode.setText("");
        CompNum.setText("");
        DateTimeBegin.setDate(new Date(2000-1900,0,1));
        DateTimeEnd.setDate(new Date(2050-1900,11,31));
        searchstu.setStuNum(StuNum.getText());
        searchstu.setStuName(StuName.getText());
        searchstu.setStuClass(StuClass.getText());
        searchstu.setStuField(StuField.getText());
        searchmatchs.setMatchsName(MatchsName.getText());
        searchmatchs.setMatchsCode(MatchsCode.getText());
        searchcomp.setCompName(CompName.getText());
        searchcomp.setCompNum(CompNum.getText());
        beginDate = DateTimeBegin.getDate();
        endDate = DateTimeEnd.getDate();
        this.reloatAwardInfoTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label2 = new JLabel();
        DateTimeBegin = new DateChooserJButton();
        label1 = new JLabel();
        DateTimeEnd = new DateChooserJButton();
        label3 = new JLabel();
        StuNum = new JTextField();
        label5 = new JLabel();
        StuName = new JTextField();
        label6 = new JLabel();
        StuClass = new JTextField();
        label4 = new JLabel();
        StuField = new JTextField();
        label9 = new JLabel();
        MatchsCode = new JTextField();
        label7 = new JLabel();
        MatchsName = new JTextField();
        label10 = new JLabel();
        CompNum = new JTextField();
        label8 = new JLabel();
        CompName = new JTextField();
        ChoiceStu = new JButton();
        ChoiceMatch = new JButton();
        ChoiceComp = new JButton();
        Reset = new JButton();
        Search = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setTitle("\u83b7\u5956\u60c5\u51b5\u67e5\u8be2");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- label2 ----
            label2.setText("\u8d77\u59cb\u65f6\u95f4\uff1a");
            panel1.add(label2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- DateTimeBegin ----
            DateTimeBegin.setText("text");
            DateTimeBegin.addActionListener(e -> DateTimeBegin(e));
            panel1.add(DateTimeBegin, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label1 ----
            label1.setText("\u7ed3\u675f\u65f6\u95f4\uff1a");
            panel1.add(label1, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- DateTimeEnd ----
            DateTimeEnd.setText("text");
            DateTimeEnd.addActionListener(e -> DateTimeEnd(e));
            panel1.add(DateTimeEnd, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label3 ----
            label3.setText("\u5b66\u53f7\uff1a");
            panel1.add(label3, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(StuNum, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label5 ----
            label5.setText("\u59d3\u540d\uff1a");
            panel1.add(label5, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(StuName, new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label6 ----
            label6.setText("\u73ed\u7ea7\uff1a");
            panel1.add(label6, new GridBagConstraints(7, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(StuClass, new GridBagConstraints(8, 1, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label4 ----
            label4.setText("\u4e13\u4e1a\uff1a");
            panel1.add(label4, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(StuField, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label9 ----
            label9.setText("\u7ade\u8d5b\u7f16\u53f7\uff1a");
            panel1.add(label9, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(MatchsCode, new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label7 ----
            label7.setText("\u7ade\u8d5b\u540d\u79f0\uff1a");
            panel1.add(label7, new GridBagConstraints(7, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(MatchsName, new GridBagConstraints(8, 2, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label10 ----
            label10.setText("\u8d5b\u4e8b\u5e8f\u53f7\uff1a");
            panel1.add(label10, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(CompNum, new GridBagConstraints(6, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label8 ----
            label8.setText("\u8d5b\u4e8b\u540d\u79f0\uff1a");
            panel1.add(label8, new GridBagConstraints(7, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(CompName, new GridBagConstraints(8, 3, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- ChoiceStu ----
            ChoiceStu.setText("\u9009\u62e9\u5b66\u751f\u4fe1\u606f");
            ChoiceStu.addActionListener(e -> ChoiceStu(e));
            panel1.add(ChoiceStu, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- ChoiceMatch ----
            ChoiceMatch.setText("\u9009\u62e9\u7ade\u8d5b\u4fe1\u606f");
            ChoiceMatch.addActionListener(e -> ChoiceMatch(e));
            panel1.add(ChoiceMatch, new GridBagConstraints(3, 4, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- ChoiceComp ----
            ChoiceComp.setText("\u9009\u62e9\u8d5b\u4e8b\u4fe1\u606f");
            ChoiceComp.addActionListener(e -> ChoiceComp(e));
            panel1.add(ChoiceComp, new GridBagConstraints(6, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- Reset ----
            Reset.setText("\u91cd\u7f6e");
            Reset.addActionListener(e -> Reset(e));
            panel1.add(Reset, new GridBagConstraints(7, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- Search ----
            Search.setText("\u67e5\u8be2");
            Search.addActionListener(e -> Search(e));
            panel1.add(Search, new GridBagConstraints(8, 4, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        contentPane.add(panel1, BorderLayout.NORTH);
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        setSize(745, 510);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        {
            scrollPane1.setViewportView(table1);
        }
        this.Reset(new ActionEvent(this, 1, ""));
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label2;
    private DateChooserJButton DateTimeBegin;
    private JLabel label1;
    private DateChooserJButton DateTimeEnd;
    private JLabel label3;
    private JTextField StuNum;
    private JLabel label5;
    private JTextField StuName;
    private JLabel label6;
    private JTextField StuClass;
    private JLabel label4;
    private JTextField StuField;
    private JLabel label9;
    private JTextField MatchsCode;
    private JLabel label7;
    private JTextField MatchsName;
    private JLabel label10;
    private JTextField CompNum;
    private JLabel label8;
    private JTextField CompName;
    private JButton ChoiceStu;
    private JButton ChoiceMatch;
    private JButton ChoiceComp;
    private JButton Reset;
    private JButton Search;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    List<AwardSearch> AwardsearchList;
    BeanStudent searchstu = new BeanStudent();
    BeanMatchs searchmatchs = new BeanMatchs();
    BeanCompetition searchcomp = new BeanCompetition();
    Date beginDate = new Date();
    Date endDate = new Date();
    private final Object[] tblTitle = {"学生学号","学生姓名","学生班级","学生专业","赛事序号","赛事名称","竞赛编号","竞赛名称","奖项等级","举办时间"};
    private  Object[][] tblData;
    DefaultTableModel tablmod = new DefaultTableModel();
    private final JTable table1 = new JTable(tablmod){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void reloatAwardInfoTable(){
        try {
            java.util.List<AwardSearch> AwardsearchList = (new AwardInfoManager().fuzzySearchAwardInfo(searchstu, searchmatchs, searchcomp,beginDate,endDate));
            this.AwardsearchList = AwardsearchList;
            tblData = new Object[AwardsearchList.size()][10];
            for (int i = 0; i < AwardsearchList.size(); i++) {
                tblData[i][0] = AwardsearchList.get(i).getStudent().getStuNum();
                tblData[i][1] = AwardsearchList.get(i).getStudent().getStuName();
                tblData[i][2] = AwardsearchList.get(i).getStudent().getStuClass();
                tblData[i][3] = AwardsearchList.get(i).getStudent().getStuField();
                tblData[i][4] = AwardsearchList.get(i).getCompetition().getCompNum();
                tblData[i][5] = AwardsearchList.get(i).getCompetition().getCompName();
                tblData[i][6] = AwardsearchList.get(i).getMatchs().getMatchsCode();
                tblData[i][7] = AwardsearchList.get(i).getMatchs().getMatchsName();
                tblData[i][8] = AwardsearchList.get(i).getAwardInfo().getAwards();
                tblData[i][9] = new SimpleDateFormat("yyyy-MM-dd").format(AwardsearchList.get(i).getOrganizetime());
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
