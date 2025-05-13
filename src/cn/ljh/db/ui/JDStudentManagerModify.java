/*
 * Created by JFormDesigner on Sat Jul 06 14:16:13 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.event.*;
import javax.swing.*;

import cn.ljh.db.control.StudentManager;
import cn.ljh.db.model.BeanStudent;
import cn.ljh.db.util.BaseException;
import net.miginfocom.swing.*;

/**
 * @author LJH
 */
public class JDStudentManagerModify extends JDialog {
    public JDStudentManagerModify() {
    }
    public JDStudentManagerModify(String StudentNum) {
        this.setModal(true);
        StudentManager sm = new StudentManager();
        try {
            this.ModifyStudent = sm.loadStudentByStuNum(StudentNum);
        }catch (BaseException e){
            JOptionPane.showMessageDialog(null, "学生不存在！请刷新后重试！", "错误", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        initComponents();
    }

    private void cancel(ActionEvent e) {
        // TODO add your code here
        this.setVisible(false);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        stuNum = new JTextField();
        label2 = new JLabel();
        stuName = new JTextField();
        label3 = new JLabel();
        stuField = new JTextField();
        label4 = new JLabel();
        stuClass = new JTextField();
        label5 = new JLabel();
        entryYear = new JTextField();
        label6 = new JLabel();
        stuTel = new JTextField();
        label7 = new JLabel();
        stuQQ = new JTextField();
        label8 = new JLabel();
        stumail = new JTextField();
        cancel = new JButton();
        reset = new JButton();
        yes = new JButton();

        //======== this ========
        setTitle("\u5b66\u751f\u4fe1\u606f\u4fee\u6539");
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("\u5b66\u751f\u5b66\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
        contentPane.add(label1, "cell 3 2");
        contentPane.add(stuNum, "cell 4 2 10 1");

        //---- label2 ----
        label2.setText("\u5b66\u751f\u59d3\u540d\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));
        contentPane.add(label2, "cell 3 3");
        contentPane.add(stuName, "cell 4 3 10 1");

        //---- label3 ----
        label3.setText("\u5b66\u751f\u4e13\u4e1a\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
        contentPane.add(label3, "cell 3 4");
        contentPane.add(stuField, "cell 4 4 10 1");

        //---- label4 ----
        label4.setText("\u5b66\u751f\u73ed\u7ea7\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));
        contentPane.add(label4, "cell 3 5");
        contentPane.add(stuClass, "cell 4 5 10 1");

        //---- label5 ----
        label5.setText("\u5165\u5b66\u5e74\u4efd\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));
        contentPane.add(label5, "cell 3 6");
        contentPane.add(entryYear, "cell 4 6 10 1");

        //---- label6 ----
        label6.setText("\u624b\u673a\u53f7\u7801\uff1a");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 5f));
        contentPane.add(label6, "cell 3 7");
        contentPane.add(stuTel, "cell 4 7 10 1");

        //---- label7 ----
        label7.setText("QQ\u53f7\u7801\uff1a");
        label7.setHorizontalAlignment(SwingConstants.RIGHT);
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 5f));
        contentPane.add(label7, "cell 3 8");
        contentPane.add(stuQQ, "cell 4 8 10 1");

        //---- label8 ----
        label8.setText("\u7535\u5b50\u90ae\u4ef6\uff1a");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 5f));
        contentPane.add(label8, "cell 3 9");
        contentPane.add(stumail, "cell 4 9 10 1");

        //---- cancel ----
        cancel.setText("\u53d6\u6d88");
        cancel.addActionListener(e -> cancel(e));
        contentPane.add(cancel, "cell 1 14");

        //---- reset ----
        reset.setText("\u91cd\u7f6e");
        reset.addActionListener(e -> reset(e));
        contentPane.add(reset, "cell 13 14");

        //---- yes ----
        yes.setText("\u786e\u5b9a");
        yes.addActionListener(e -> yes(e));
        contentPane.add(yes, "cell 14 14");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        stuNum.setText(ModifyStudent.getStuNum());
        stuNum.setEditable(false);
        entryYear.setText(String.valueOf(ModifyStudent.getEntryYear()));
        entryYear.setEditable(false);
        stuName.setText(ModifyStudent.getStuName());
        stuField.setText(ModifyStudent.getStuField());
        stuClass.setText(ModifyStudent.getStuClass());
        stuTel.setText(ModifyStudent.getStuTel());
        stuQQ.setText(ModifyStudent.getQq());
        stumail.setText(ModifyStudent.getStumail());

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField stuNum;
    private JLabel label2;
    private JTextField stuName;
    private JLabel label3;
    private JTextField stuField;
    private JLabel label4;
    private JTextField stuClass;
    private JLabel label5;
    private JTextField entryYear;
    private JLabel label6;
    private JTextField stuTel;
    private JLabel label7;
    private JTextField stuQQ;
    private JLabel label8;
    private JTextField stumail;
    private JButton cancel;
    private JButton reset;
    private JButton yes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    BeanStudent student = new BeanStudent();
    BeanStudent ModifyStudent = null;




    private void yes(ActionEvent e) {
        StudentManager stm = new StudentManager();
        // TODO add your code here
        student.setStuNum(stuNum.getText());
        student.setStuName(stuName.getText());
        student.setStuField(stuField.getText());
        student.setStuClass(stuClass.getText());
        student.setEntryYear(Integer.parseInt(entryYear.getText()));
        student.setStuTel(stuTel.getText());
        student.setQq(stuQQ.getText());
        student.setStumail(stumail.getText());
        try {
            stm.modifyStudent(student);
            JOptionPane.showMessageDialog(this, "修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        }catch (Exception e1){
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this, "修改失败！"+e1.getMessage(), "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }



    }


    private void reset(ActionEvent e) {
        // TODO add your code here
        stuName.setText(ModifyStudent.getStuName());
        stuField.setText(ModifyStudent.getStuField());
        stuClass.setText(ModifyStudent.getStuClass());
        stuTel.setText( ModifyStudent.getStuTel());
        stuQQ.setText(ModifyStudent.getQq());
        stumail.setText(ModifyStudent.getStumail());
    }
}
