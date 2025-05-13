/*
 * Created by JFormDesigner on Tue Jul 09 14:08:01 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.event.*;
import cn.ljh.db.control.StudentManager;
import cn.ljh.db.model.BeanStudent;
import cn.ljh.db.util.BaseException;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author LJH
 */
public class JDChoiceStu extends JDialog {
    public JDChoiceStu(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }

    private void Cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void Yes(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择学生！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        selectedStudent = students.get(row);
        JOptionPane.showMessageDialog(this, "选择的学生为："+selectedStudent.getStuNum()+selectedStudent.getStuName(), "提示", JOptionPane.INFORMATION_MESSAGE);
        isOK = true;
        this.dispose();
    }

    private void Search(ActionEvent e) {
        // TODO add your code here
        this.reloadStudentTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        label1 = new JLabel();
        label2 = new JLabel();
        StuNum = new JTextField();
        label3 = new JLabel();
        StuName = new JTextField();
        Search = new JButton();
        panel1 = new JPanel();
        Cancel = new JButton();
        Yes = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setTitle("\u9009\u62e9\u5b66\u751f");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //---- label1 ----
            label1.setText("\u7b5b\u9009\u5b66\u751f    ");
            menuBar1.add(label1);

            //---- label2 ----
            label2.setText("\u5b66\u751f\u5b66\u53f7\uff1a");
            menuBar1.add(label2);
            menuBar1.add(StuNum);

            //---- label3 ----
            label3.setText("\u5b66\u751f\u59d3\u540d\uff1a");
            menuBar1.add(label3);
            menuBar1.add(StuName);

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

            //---- Yes ----
            Yes.setText("\u786e\u5b9a");
            Yes.addActionListener(e -> Yes(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(Cancel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 413, Short.MAX_VALUE)
                        .addComponent(Yes)
                        .addGap(26, 26, 26))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Cancel)
                        .addComponent(Yes))
            );
        }
        contentPane.add(panel1, BorderLayout.SOUTH);
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        setSize(580, 395);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        StuNum.setText("");
        StuName.setText("");
        {
        scrollPane1.setViewportView(table1);
        }
        this.reloadStudentTable();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JLabel label1;
    private JLabel label2;
    private JTextField StuNum;
    private JLabel label3;
    private JTextField StuName;
    private JButton Search;
    private JPanel panel1;
    private JButton Cancel;
    private JButton Yes;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public boolean isOK = false;
    private BeanStudent selectedStudent;
    private List<BeanStudent> students;
    private final Object[] tblTitle = {"学号","姓名","专业","班级","入学年份","电话","qq","电子邮箱","登录密码"};
    private  Object[][] tblData;
    DefaultTableModel tablmod = new DefaultTableModel();
    private final JTable table1 = new JTable(tablmod){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private void reloadStudentTable() {
        try {
            List<BeanStudent> students = (new StudentManager().searchStudent(StuName.getText(), StuNum.getText()));
            this.students = students;
            tblData = new Object[students.size()][9];
            for (int i = 0; i < students.size(); i++) {
                tblData[i][0] = students.get(i).getStuNum();
                tblData[i][1] = students.get(i).getStuName();
                tblData[i][2] = students.get(i).getStuField();
                tblData[i][3] = students.get(i).getStuClass();
                tblData[i][4] = students.get(i).getEntryYear();
                tblData[i][5] = students.get(i).getStuTel();
                tblData[i][6] = students.get(i).getQq();
                tblData[i][7] = students.get(i).getStumail();
                tblData[i][8] = students.get(i).getStuPwd();
            }
            tablmod.setDataVector(tblData, tblTitle);
            this.table1.validate();
            this.table1.repaint();
        } catch (BaseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public BeanStudent getValue(){
        return selectedStudent;
    }

}
