/*
 * Created by JFormDesigner on Sat Jul 06 10:08:05 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import cn.ljh.db.control.StudentManager;
import cn.ljh.db.control.TeacherManager;
import cn.ljh.db.model.BeanStudent;
import cn.ljh.db.model.BeanTeacher;
import cn.ljh.db.util.BaseException;

/**
 * @author LJH
 */
public class JDStudentManager extends JDialog {

    public JDStudentManager() {
        this.setModal(true);
        initComponents();

    }

    private void create(ActionEvent e) {
        // TODO add your code here
        new JDStudentManagerCreate().setVisible(true);
        this.refresh(e);
    }

    private void search(ActionEvent e) {
        // TODO add your code here
        this.reloadStudentTable();
    }



    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        create = new JButton();
        modify = new JButton();
        Butdel = new JButton();
        refresh = new JButton();
        label3 = new JLabel();
        label1 = new JLabel();
        StuName = new JTextField();
        label2 = new JLabel();
        StuNum = new JTextField();
        search = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setTitle("\u5b66\u751f\u7ba1\u7406");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //---- create ----
            create.setText("\u6dfb\u52a0");
            create.addActionListener(e -> create(e));
            menuBar1.add(create);

            //---- modify ----
            modify.setText("\u4fee\u6539");
            modify.addActionListener(e -> modify(e));
            menuBar1.add(modify);

            //---- Butdel ----
            Butdel.setText("\u5220\u9664");
            Butdel.addActionListener(e -> Butdel(e));
            menuBar1.add(Butdel);

            //---- refresh ----
            refresh.setText("\u5237\u65b0");
            refresh.addActionListener(e -> refresh(e));
            menuBar1.add(refresh);

            //---- label3 ----
            label3.setText("   \u67e5\u627e\u5b66\u751f  ");
            menuBar1.add(label3);

            //---- label1 ----
            label1.setText("\u59d3\u540d\uff1a");
            menuBar1.add(label1);
            menuBar1.add(StuName);

            //---- label2 ----
            label2.setText("\u5b66\u53f7\uff1a");
            menuBar1.add(label2);
            menuBar1.add(StuNum);

            //---- search ----
            search.setText("\u641c\u7d22");
            search.addActionListener(e -> search(e));
            menuBar1.add(search);
        }
        setJMenuBar(menuBar1);
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        setSize(700, 450);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        {
            scrollPane1.setViewportView(table1);
        }
        this.reloadStudentTable();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JButton create;
    private JButton modify;
    private JButton Butdel;
    private JButton refresh;
    private JLabel label3;
    private JLabel label1;
    private JTextField StuName;
    private JLabel label2;
    private JTextField StuNum;
    private JButton search;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    List<BeanStudent> students;

    private void refresh(ActionEvent e) {
        // TODO add your code here
        // 更新表格
        StuName.setText("");
        StuNum.setText("");
        this.reloadStudentTable();

    }
    // 刷新表格数据

    private void Butdel(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "请选择要删除的学生！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String stuNum = students.get(row).getStuNum();
        StudentManager stm = new StudentManager();
        if(JOptionPane.showConfirmDialog(this, "确定要删除该学生吗？", "提示", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            try {
                stm.deleteStudent(stuNum);   // 删除学生信息
                JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                // 更新表格
                this.refresh(e);
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "删除失败！"+e1.getMessage(), "提示", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    // 删除操作

    private void modify(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "请选择要修改的学生！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        BeanStudent st = new BeanStudent();
        st = students.get(row);
        JDStudentManagerModify fy = new JDStudentManagerModify(st.getStuNum());
        fy.setVisible(true);
        // 修改学生信息
        this.refresh(e);
    }

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
            String stuName = StuName.getText();
            String stuNum = StuNum.getText();
            List<BeanStudent> students = (new StudentManager().searchStudent(stuName, stuNum));
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


}
