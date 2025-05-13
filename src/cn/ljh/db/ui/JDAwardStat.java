/*
 * Created by JFormDesigner on Wed Jul 10 10:14:09 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.event.*;
import cn.ljh.db.control.AwardInfoManager;
import cn.ljh.db.model.AwardSearch;
import cn.ljh.db.model.BeanCompetition;
import cn.ljh.db.model.BeanMatchs;
import cn.ljh.db.model.BeanStudent;
import cn.ljh.db.util.BaseException;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * @author LJH
 */
public class JDAwardStat extends JDialog {
    public JDAwardStat(Window owner) {
        super(owner);
        initComponents();
    }

    private void Statbystu(ActionEvent e) {
        // TODO add your code here
        BeanStudent st = new BeanStudent();
        st.setStuNum(StuNum.getText());
        st.setStuName(StuName.getText());
        awardSearch = new AwardSearch();
        awardSearch.setStudent(st);
        startdate = startDate.getDate();
        enddate = endDate.getDate();
        {
            scrollPane2.setViewportView(tablestu);
        }
        this.flag = 1;
        this.reloadStudentTable();
    }

    private void resetstu(ActionEvent e) {
        // TODO add your code here
        StuNum.setText("");
        StuName.setText("");
        startDate.setDate((new Date(2000 - 1900, 0, 1)));
        endDate.setDate((new Date(2050 - 1900, 11, 31)));
    }

    private void ChoiceStu(ActionEvent e) {
        // TODO add your code here
        JDChoiceStu cs = new JDChoiceStu(this);
        cs.setVisible(true);
        if (cs.isOK) {
            StuNum.setText(cs.getValue().getStuNum());
            StuName.setText(cs.getValue().getStuName());
        }
    }

    private void Statbycomp(ActionEvent e) {
        // TODO add your code here
        BeanCompetition comp = new BeanCompetition();
        comp.setCompNum(CompNum.getText());
        comp.setCompName(CompName.getText());
        awardSearch = new AwardSearch();
        awardSearch.setCompetition(comp);
        startdate = startDate.getDate();
        enddate = endDate.getDate();
        {
            scrollPane2.setViewportView(tablecomp);
        }
        this.flag = 2;
        this.reloadCompetitionTable();
    }

    private void ChoiceComp(ActionEvent e) {
        // TODO add your code here
        JDChoiceComp cc = new JDChoiceComp(this);
        cc.setVisible(true);
        if (cc.isok) {
            CompNum.setText(cc.getValue().getCompNum());
            CompName.setText(cc.getValue().getCompName());
        }
    }

    private void resetcomp(ActionEvent e) {
        // TODO add your code here
        CompNum.setText("");
        CompName.setText("");
        startDate.setDate((new Date(2000 - 1900, 0, 1)));
        endDate.setDate((new Date(2050 - 1900, 11, 31)));
    }

    private void ChoiceMatchs(ActionEvent e) {
        // TODO add your code here
        JDChoiceMatch cm = new JDChoiceMatch(this);
        cm.setVisible(true);
        if (cm.ok) {
            MatchsCode.setText(cm.getValue().getMatchsCode());
            MatchsName.setText(cm.getValue().getMatchsName());
        }
    }

    private void resetmatchs(ActionEvent e) {
        // TODO add your code here
        MatchsCode.setText("");
        MatchsName.setText("");
        startDate.setDate((new Date(2000 - 1900, 0, 1)));
        endDate.setDate((new Date(2050 - 1900, 11, 31)));
    }

    private void StatbyMatchs(ActionEvent e) {
        // TODO add your code here
        BeanMatchs matchs = new BeanMatchs();
        matchs.setMatchsCode(MatchsCode.getText());
        matchs.setMatchsName(MatchsName.getText());
        awardSearch = new AwardSearch();
        awardSearch.setMatchs(matchs);
        startdate = startDate.getDate();
        enddate = endDate.getDate();
        {
            scrollPane2.setViewportView(tablematch);
        }
        this.flag = 3;
        this.reloadMatchTable();
    }

    private void StatbyClass(ActionEvent e) {
        // TODO add your code here
        BeanStudent st = new BeanStudent();
        st.setStuClass(Class.getText());
        awardSearch = new AwardSearch();
        awardSearch.setStudent(st);
        startdate = startDate.getDate();
        enddate = endDate.getDate();
        {
            scrollPane2.setViewportView(tableclass);
        }
        this.flag = 4;
        this.reloadClassTable();
    }

    private void StatbyField(ActionEvent e) {
        // TODO add your code here
        BeanStudent st = new BeanStudent();
        st.setStuField(Field.getText());
        awardSearch = new AwardSearch();
        awardSearch.setStudent(st);
        startdate = startDate.getDate();
        enddate = endDate.getDate();
        {
            scrollPane2.setViewportView(tablefield);
        }
        this.flag = 5;
        this.reloadFieldTable();
    }

    private void resetDate(ActionEvent e) {
        // TODO add your code here
        startDate.setDate((new Date(2000 - 1900, 0, 1)));
        endDate.setDate((new Date(2050 - 1900, 11, 31)));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label1 = new JLabel();
        startDate = new DateChooserJButton();
        label2 = new JLabel();
        endDate = new DateChooserJButton();
        resetDate = new JButton();
        label3 = new JLabel();
        StuNum = new JTextField();
        label4 = new JLabel();
        StuName = new JTextField();
        ChoiceStu = new JButton();
        resetstu = new JButton();
        Statbystu = new JButton();
        label5 = new JLabel();
        CompNum = new JTextField();
        label8 = new JLabel();
        CompName = new JTextField();
        ChoiceComp = new JButton();
        resetcomp = new JButton();
        Statbycomp = new JButton();
        label7 = new JLabel();
        MatchsCode = new JTextField();
        label6 = new JLabel();
        MatchsName = new JTextField();
        ChoiceMatchs = new JButton();
        resetmatchs = new JButton();
        StatbyMatchs = new JButton();
        label9 = new JLabel();
        Class = new JTextField();
        StatbyClass = new JButton();
        label10 = new JLabel();
        Field = new JTextField();
        StatbyField = new JButton();
        panel2 = new JPanel();
        panel3 = new JPanel();
        scrollPane2 = new JScrollPane();
        panel4 = new JPanel();
        scrollPane3 = new JScrollPane();

        //======== this ========
        setTitle("\u83b7\u5956\u60c5\u51b5\u7edf\u8ba1");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- label1 ----
            label1.setText("\u8d77\u59cb\u65f6\u95f4\uff1a");
            panel1.add(label1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- startDate ----
            startDate.setText("text");
            panel1.add(startDate, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label2 ----
            label2.setText("\u7ed3\u675f\u65f6\u95f4\uff1a");
            panel1.add(label2, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- endDate ----
            endDate.setText("text");
            panel1.add(endDate, new GridBagConstraints(7, 0, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- resetDate ----
            resetDate.setText("\u91cd\u7f6e");
            resetDate.addActionListener(e -> resetDate(e));
            panel1.add(resetDate, new GridBagConstraints(12, 0, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label3 ----
            label3.setText("\u5b66\u751f\u5b66\u53f7\uff1a");
            panel1.add(label3, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(StuNum, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label4 ----
            label4.setText("\u5b66\u751f\u59d3\u540d\uff1a");
            panel1.add(label4, new GridBagConstraints(3, 1, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(StuName, new GridBagConstraints(6, 1, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- ChoiceStu ----
            ChoiceStu.setText("\u9009\u62e9\u5b66\u751f\u4fe1\u606f");
            ChoiceStu.addActionListener(e -> ChoiceStu(e));
            panel1.add(ChoiceStu, new GridBagConstraints(11, 1, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- resetstu ----
            resetstu.setText("\u91cd\u7f6e");
            resetstu.addActionListener(e -> resetstu(e));
            panel1.add(resetstu, new GridBagConstraints(16, 1, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- Statbystu ----
            Statbystu.setText("\u7edf\u8ba1");
            Statbystu.addActionListener(e -> Statbystu(e));
            panel1.add(Statbystu, new GridBagConstraints(19, 1, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label5 ----
            label5.setText("\u8d5b\u4e8b\u5e8f\u53f7\uff1a");
            panel1.add(label5, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(CompNum, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label8 ----
            label8.setText("\u8d5b\u4e8b\u540d\u79f0\uff1a");
            panel1.add(label8, new GridBagConstraints(3, 2, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(CompName, new GridBagConstraints(6, 2, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- ChoiceComp ----
            ChoiceComp.setText("\u9009\u62e9\u8d5b\u4e8b\u4fe1\u606f");
            ChoiceComp.addActionListener(e -> ChoiceComp(e));
            panel1.add(ChoiceComp, new GridBagConstraints(11, 2, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- resetcomp ----
            resetcomp.setText("\u91cd\u7f6e");
            resetcomp.addActionListener(e -> resetcomp(e));
            panel1.add(resetcomp, new GridBagConstraints(16, 2, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- Statbycomp ----
            Statbycomp.setText("\u7edf\u8ba1");
            Statbycomp.addActionListener(e -> Statbycomp(e));
            panel1.add(Statbycomp, new GridBagConstraints(19, 2, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label7 ----
            label7.setText("\u7ade\u8d5b\u7f16\u53f7\uff1a");
            panel1.add(label7, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(MatchsCode, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label6 ----
            label6.setText("\u7ade\u8d5b\u540d\u79f0\uff1a");
            panel1.add(label6, new GridBagConstraints(3, 3, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(MatchsName, new GridBagConstraints(6, 3, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- ChoiceMatchs ----
            ChoiceMatchs.setText("\u9009\u62e9\u7ade\u8d5b\u4fe1\u606f");
            ChoiceMatchs.addActionListener(e -> ChoiceMatchs(e));
            panel1.add(ChoiceMatchs, new GridBagConstraints(11, 3, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- resetmatchs ----
            resetmatchs.setText("\u91cd\u7f6e");
            resetmatchs.addActionListener(e -> resetmatchs(e));
            panel1.add(resetmatchs, new GridBagConstraints(16, 3, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- StatbyMatchs ----
            StatbyMatchs.setText("\u7edf\u8ba1");
            StatbyMatchs.addActionListener(e -> StatbyMatchs(e));
            panel1.add(StatbyMatchs, new GridBagConstraints(19, 3, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label9 ----
            label9.setText("\u73ed\u7ea7\uff1a");
            panel1.add(label9, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
            panel1.add(Class, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- StatbyClass ----
            StatbyClass.setText("\u7edf\u8ba1");
            StatbyClass.addActionListener(e -> StatbyClass(e));
            panel1.add(StatbyClass, new GridBagConstraints(3, 4, 4, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- label10 ----
            label10.setText("\u4e13\u4e1a\uff1a");
            panel1.add(label10, new GridBagConstraints(7, 4, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
            panel1.add(Field, new GridBagConstraints(9, 4, 7, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- StatbyField ----
            StatbyField.setText("\u7edf\u8ba1");
            StatbyField.addActionListener(e -> StatbyField(e));
            panel1.add(StatbyField, new GridBagConstraints(16, 4, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        contentPane.add(panel1, BorderLayout.PAGE_START);

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout());

            //======== panel3 ========
            {
                panel3.setLayout(new BorderLayout());
                panel3.add(scrollPane2, BorderLayout.CENTER);
            }
            panel2.add(panel3);

            //======== panel4 ========
            {
                panel4.setLayout(new BorderLayout());
                panel4.add(scrollPane3, BorderLayout.CENTER);
            }
            panel2.add(panel4);
        }
        contentPane.add(panel2, BorderLayout.CENTER);
        setSize(805, 475);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        this.flag = 0;
        startDate.setDate((new Date(2000 - 1900, 0, 1)));
        endDate.setDate((new Date(2050 - 1900, 11, 31)));
        // 选中学生表格时判断选中的行进行监听然后加载
        tablestu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tablestu.getSelectedRow();
                if (row >= 0) {
                    String stuNum = students.get(row).getStuNum();
                    {
                        scrollPane3.setViewportView(tabledetail);
                    }
                    loadDetailTablebystu(stuNum);

                }
            }
        });
        // 选中赛事表格时判断选中的行进行监听然后加载
        tablecomp.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tablecomp.getSelectedRow();
                if (row >= 0) {
                    String compNum = competitions.get(row).getCompNum();
                    {
                        scrollPane3.setViewportView(tabledetail);
                    }
                    loadDetailTablebycomp(compNum);
                }
            }
        });
        // 选中竞赛表格时判断选中的行进行监听然后加载
        tablematch.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tablematch.getSelectedRow();
                if (row >= 0) {
                    String matchsCode = matchs.get(row).getMatchsCode();
                    {
                        scrollPane3.setViewportView(tabledetail);
                    }
                    loadDetailTablebymatchs(matchsCode);
                }
            }
        });
        // 选中班级表格时判断选中的行进行监听然后加载
        tableclass.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tableclass.getSelectedRow();
                if (row >= 0) {
                    String stuClass = classes.get(row);
                    {
                        scrollPane3.setViewportView(tabledetail);
                    }
                    loadDetailTablebyclass(stuClass);
                }
            }
        });
        // 选中专业表格时判断选中的行进行监听然后加载
        tablefield.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tablefield.getSelectedRow();
                if (row >= 0) {
                    String stuField = fields.get(row);
                    {
                        scrollPane3.setViewportView(tabledetail);
                    }
                    loadDetailTablebyfield(stuField);
                }
            }
        });




    }


    // 查询时间段定义
    private Date startdate;
    private Date enddate;
    // 设置标记便于知道目前在统计什么 0 无，1 学生，2 赛事，3 竞赛，4，班级，5 专业
    private int flag = 0;
    // 待统计信息定义
    private AwardSearch awardSearch;
    //详细信息表定义
    private List<AwardSearch> detailList;
    private final Object[] detailTitle = {"学生学号", "学生姓名", "学生班级", "所在专业", "竞赛编号", "竞赛名称", "赛事序号","赛事名称","奖项等级","获奖时间"};
    private Object[][] detailData;
    DefaultTableModel detailmod = new DefaultTableModel();
    private final JTable tabledetail = new JTable(detailmod) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    // 学生详细信息表加载方法
    private void loadDetailTablebystu(String stuNum) {
        try {
            detailList = (new AwardInfoManager().detailstatawardbystu(stuNum, startdate, enddate));
            detailData = new Object[detailList.size()][10];
            for (int i = 0; i < detailList.size(); i++) {
                detailData[i][0] = detailList.get(i).getStudent().getStuNum();
                detailData[i][1] = detailList.get(i).getStudent().getStuName();
                detailData[i][2] = detailList.get(i).getStudent().getStuClass();
                detailData[i][3] = detailList.get(i).getStudent().getStuField();
                detailData[i][4] = detailList.get(i).getMatchs().getMatchsCode();
                detailData[i][5] = detailList.get(i).getMatchs().getMatchsName();
                detailData[i][6] = detailList.get(i).getCompetition().getCompNum();
                detailData[i][7] = detailList.get(i).getCompetition().getCompName();
                detailData[i][8] = detailList.get(i).getAwardInfo().getAwards();
                detailData[i][9] = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(detailList.get(i).getOrganizetime());
            }
            detailmod.setDataVector(detailData, detailTitle);
            tabledetail.validate();
            tabledetail.repaint();
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    //赛事详细信息表加载方法
    private void loadDetailTablebycomp(String compNum) {
        try {
            detailList = (new AwardInfoManager().detailstatawardbycomp(compNum, startdate, enddate));
            detailData = new Object[detailList.size()][10];
            for (int i = 0; i < detailList.size(); i++) {
                detailData[i][0] = detailList.get(i).getStudent().getStuNum();
                detailData[i][1] = detailList.get(i).getStudent().getStuName();
                detailData[i][2] = detailList.get(i).getStudent().getStuClass();
                detailData[i][3] = detailList.get(i).getStudent().getStuField();
                detailData[i][4] = detailList.get(i).getMatchs().getMatchsCode();
                detailData[i][5] = detailList.get(i).getMatchs().getMatchsName();
                detailData[i][6] = detailList.get(i).getCompetition().getCompNum();
                detailData[i][7] = detailList.get(i).getCompetition().getCompName();
                detailData[i][8] = detailList.get(i).getAwardInfo().getAwards();
                detailData[i][9] = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(detailList.get(i).getOrganizetime());
            }
            detailmod.setDataVector(detailData, detailTitle);
            tabledetail.validate();
            tabledetail.repaint();
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }


    //竞赛详细信息表加载方法
    private void loadDetailTablebymatchs(String matchsCode) {
        try {
            detailList = (new AwardInfoManager().detailstatawardbymatchs(matchsCode, startdate, enddate));
            detailData = new Object[detailList.size()][10];
            for (int i = 0; i < detailList.size(); i++) {
                detailData[i][0] = detailList.get(i).getStudent().getStuNum();
                detailData[i][1] = detailList.get(i).getStudent().getStuName();
                detailData[i][2] = detailList.get(i).getStudent().getStuClass();
                detailData[i][3] = detailList.get(i).getStudent().getStuField();
                detailData[i][4] = detailList.get(i).getMatchs().getMatchsCode();
                detailData[i][5] = detailList.get(i).getMatchs().getMatchsName();
                detailData[i][6] = detailList.get(i).getCompetition().getCompNum();
                detailData[i][7] = detailList.get(i).getCompetition().getCompName();
                detailData[i][8] = detailList.get(i).getAwardInfo().getAwards();
                detailData[i][9] = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(detailList.get(i).getOrganizetime());
            }
            detailmod.setDataVector(detailData, detailTitle);
            tabledetail.validate();
            tabledetail.repaint();
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }


    //班级详细信息表加载方法
    private void loadDetailTablebyclass(String stuClass) {
        try {
            detailList = (new AwardInfoManager().detailstatawardbyclass(stuClass, startdate, enddate));
            detailData = new Object[detailList.size()][10];
            for (int i = 0; i < detailList.size(); i++) {
                detailData[i][0] = detailList.get(i).getStudent().getStuNum();
                detailData[i][1] = detailList.get(i).getStudent().getStuName();
                detailData[i][2] = detailList.get(i).getStudent().getStuClass();
                detailData[i][3] = detailList.get(i).getStudent().getStuField();
                detailData[i][4] = detailList.get(i).getMatchs().getMatchsCode();
                detailData[i][5] = detailList.get(i).getMatchs().getMatchsName();
                detailData[i][6] = detailList.get(i).getCompetition().getCompNum();
                detailData[i][7] = detailList.get(i).getCompetition().getCompName();
                detailData[i][8] = detailList.get(i).getAwardInfo().getAwards();
                detailData[i][9] = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(detailList.get(i).getOrganizetime());
            }
            detailmod.setDataVector(detailData, detailTitle);
            tabledetail.validate();
            tabledetail.repaint();
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    //专业详细信息表加载方法
    private void loadDetailTablebyfield(String stuField) {
        try {
            detailList = (new AwardInfoManager().detailstatawardbyfield(stuField, startdate, enddate));
            detailData = new Object[detailList.size()][10];
            for (int i = 0; i < detailList.size(); i++) {
                detailData[i][0] = detailList.get(i).getStudent().getStuNum();
                detailData[i][1] = detailList.get(i).getStudent().getStuName();
                detailData[i][2] = detailList.get(i).getStudent().getStuClass();
                detailData[i][3] = detailList.get(i).getStudent().getStuField();
                detailData[i][4] = detailList.get(i).getMatchs().getMatchsCode();
                detailData[i][5] = detailList.get(i).getMatchs().getMatchsName();
                detailData[i][6] = detailList.get(i).getCompetition().getCompNum();
                detailData[i][7] = detailList.get(i).getCompetition().getCompName();
                detailData[i][8] = detailList.get(i).getAwardInfo().getAwards();
                detailData[i][9] = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(detailList.get(i).getOrganizetime());
            }
            detailmod.setDataVector(detailData, detailTitle);
            tabledetail.validate();
            tabledetail.repaint();
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }



    // 按学生信息查询总表定义以及加载
    private List<BeanStudent> students;
    private final Object[] stutblTitle = {"学号", "姓名", "专业", "班级", "获奖数量"};
    private Object[][] stutblData;
    DefaultTableModel stutablmod = new DefaultTableModel();
    private final JTable tablestu = new JTable(stutablmod) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void reloadStudentTable() {
        try {
            List<BeanStudent> students = (new AwardInfoManager().statawardbystu(awardSearch, startdate, enddate));
            this.students = students;
            stutblData = new Object[students.size()][5];
            for (int i = 0; i < students.size(); i++) {
                stutblData[i][0] = students.get(i).getStuNum();
                stutblData[i][1] = students.get(i).getStuName();
                stutblData[i][2] = students.get(i).getStuField();
                stutblData[i][3] = students.get(i).getStuClass();
                stutblData[i][4] = (new AwardInfoManager().countAwardInfobystu(students.get(i), startdate, enddate));
            }
            stutablmod.setDataVector(stutblData, stutblTitle);
            this.tablestu.validate();
            this.tablestu.repaint();
        } catch (BaseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }





    // 按赛事信息查询总表定义以及加载
    private List<BeanCompetition> competitions;
    private final Object[] comptblTitle = {"赛事编号", "赛事名称", "获奖数量"};
    private Object[][] comptblData;
    DefaultTableModel comptablmod = new DefaultTableModel();
    private final JTable tablecomp = new JTable(comptablmod) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void reloadCompetitionTable() {
        try {
            List<BeanCompetition> competitions = (new AwardInfoManager().statawardbycomp(awardSearch, startdate, enddate));
            this.competitions = competitions;
            comptblData = new Object[competitions.size()][3];
            for (int i = 0; i < competitions.size(); i++) {
                comptblData[i][0] = competitions.get(i).getCompNum();
                comptblData[i][1] = competitions.get(i).getCompName();
                comptblData[i][2] = (new AwardInfoManager().countAwardInfobycomp(competitions.get(i), startdate, enddate));
            }
            comptablmod.setDataVector(comptblData, comptblTitle);
            this.tablecomp.validate();
            this.tablecomp.repaint();
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    // 按竞赛信息查询总表定义以及加载
    private List<BeanMatchs> matchs;
    private final Object[] matchtblTitle = {"竞赛编号", "竞赛名称", "获奖数量"};
    private Object[][] matchtblData;
    DefaultTableModel matchtablmod = new DefaultTableModel();
    private final JTable tablematch = new JTable(matchtablmod) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void reloadMatchTable() {
        try {
            List<BeanMatchs> matchs = (new AwardInfoManager().statawardbymatchs(awardSearch, startdate, enddate));
            this.matchs = matchs;
            matchtblData = new Object[matchs.size()][3];
            for (int i = 0; i < matchs.size(); i++) {
                matchtblData[i][0] = matchs.get(i).getMatchsCode();
                matchtblData[i][1] = matchs.get(i).getMatchsName();
                matchtblData[i][2] = (new AwardInfoManager().countAwardInfobymatchs(matchs.get(i), startdate, enddate));
            }
            matchtablmod.setDataVector(matchtblData, matchtblTitle);
            this.tablematch.validate();
            this.tablematch.repaint();
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    // 按班级信息查询总表定义以及加载
    private List<String> classes;
    private final Object[] classtblTitle = {"班级", "获奖数量"};
    private Object[][] classtblData;
    DefaultTableModel classtablmod = new DefaultTableModel();
    private final JTable tableclass = new JTable(classtablmod) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private void reloadClassTable() {
        try {
            List<String> classes = (new AwardInfoManager().statawardbyclass(awardSearch, startdate, enddate));
            this.classes = classes;
            classtblData = new Object[classes.size()][2];
            for (int i = 0; i < classes.size(); i++) {
                classtblData[i][0] = classes.get(i);
                classtblData[i][1] = (new AwardInfoManager().countAwardInfobyclass(classes.get(i), startdate, enddate));
            }
            classtablmod.setDataVector(classtblData, classtblTitle);
            this.tableclass.validate();
            this.tableclass.repaint();
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    // 按专业信息查询总表定义以及加载
    private List<String> fields;
    private final Object[] fieldtblTitle = {"专业", "获奖数量"};
    private Object[][] fieldtblData;
    DefaultTableModel fieldtablmod = new DefaultTableModel();
    private final JTable tablefield = new JTable(fieldtablmod) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void reloadFieldTable() {
        try {
            List<String> fields = (new AwardInfoManager().statawardbyfield(awardSearch, startdate, enddate));
            this.fields = fields;
            fieldtblData = new Object[fields.size()][2];
            for (int i = 0; i < fields.size(); i++) {
                fieldtblData[i][0] = fields.get(i);
                fieldtblData[i][1] = (new AwardInfoManager().countAwardInfobyfield(fields.get(i), startdate, enddate));
            }
            fieldtablmod.setDataVector(fieldtblData, fieldtblTitle);
            this.tablefield.validate();
            this.tablefield.repaint();
        } catch (BaseException e) {
            e.printStackTrace();
        }

    }








    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label1;
    private DateChooserJButton startDate;
    private JLabel label2;
    private DateChooserJButton endDate;
    private JButton resetDate;
    private JLabel label3;
    private JTextField StuNum;
    private JLabel label4;
    private JTextField StuName;
    private JButton ChoiceStu;
    private JButton resetstu;
    private JButton Statbystu;
    private JLabel label5;
    private JTextField CompNum;
    private JLabel label8;
    private JTextField CompName;
    private JButton ChoiceComp;
    private JButton resetcomp;
    private JButton Statbycomp;
    private JLabel label7;
    private JTextField MatchsCode;
    private JLabel label6;
    private JTextField MatchsName;
    private JButton ChoiceMatchs;
    private JButton resetmatchs;
    private JButton StatbyMatchs;
    private JLabel label9;
    private JTextField Class;
    private JButton StatbyClass;
    private JLabel label10;
    private JTextField Field;
    private JButton StatbyField;
    private JPanel panel2;
    private JPanel panel3;
    private JScrollPane scrollPane2;
    private JPanel panel4;
    private JScrollPane scrollPane3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
