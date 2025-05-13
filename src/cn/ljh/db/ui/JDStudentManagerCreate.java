/*
 * Created by JFormDesigner on Sat Jul 06 10:41:58 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.event.*;
import javax.swing.*;

import cn.ljh.db.control.StudentManager;
import cn.ljh.db.model.BeanStudent;
import net.miginfocom.swing.*;

import static java.lang.Integer.parseInt;

/**
 * @author LJH
 */
public class JDStudentManagerCreate extends JDialog {
    public JDStudentManagerCreate() {
        this.setModal(true);
        initComponents();
    }

    private void yes(ActionEvent e) {
        // TODO add your code here
        StudentManager stm = new StudentManager();
        BeanStudent st = new BeanStudent();
        st.setStuNum(stuNum.getText());
        st.setStuName(stuName.getText());
        st.setStuField(stuField.getText());
        st.setStuClass(stuClass.getText());
        if (entryYear.getText().equals("")){
            st.setEntryYear(0);
        }else {
            st.setEntryYear(parseInt(entryYear.getText()));
        }

        st.setQq(qq.getText());
        st.setStumail(stumail.getText());
        st.setStuTel(stuTel.getText());
        st.setStuPwd(stuPwd.getText());
        try {
            stm.createStudent(st);
            JOptionPane.showMessageDialog(null,"插入成功","提示",JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
        }catch (Exception e1){
            JOptionPane.showMessageDialog(null, "插入失败:"+e1.getMessage(), "错误提示", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }


    }

    private void cancle(ActionEvent e) {
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
        label9 = new JLabel();
        stuClass = new JTextField();
        label4 = new JLabel();
        entryYear = new JTextField();
        label5 = new JLabel();
        stuTel = new JTextField();
        label6 = new JLabel();
        stumail = new JTextField();
        label7 = new JLabel();
        qq = new JTextField();
        label8 = new JLabel();
        stuPwd = new JTextField();
        cancle = new JButton();
        reset = new JButton();
        yes = new JButton();

        //======== this ========
        setTitle("\u6dfb\u52a0\u5b66\u751f");
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
            "[]"));

        //---- label1 ----
        label1.setText("\u5b66\u751f\u5b66\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
        contentPane.add(label1, "cell 1 0");
        contentPane.add(stuNum, "cell 2 0 8 1");

        //---- label2 ----
        label2.setText("\u5b66\u751f\u59d3\u540d\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));
        contentPane.add(label2, "cell 1 1");
        contentPane.add(stuName, "cell 2 1 8 1");

        //---- label3 ----
        label3.setText("\u5b66\u751f\u4e13\u4e1a\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
        contentPane.add(label3, "cell 1 2");
        contentPane.add(stuField, "cell 2 2 8 1");

        //---- label9 ----
        label9.setText("\u5b66\u751f\u73ed\u7ea7\uff1a");
        label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 5f));
        contentPane.add(label9, "cell 1 3");
        contentPane.add(stuClass, "cell 2 3 8 1");

        //---- label4 ----
        label4.setText("\u5165\u5b66\u5e74\u4efd\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));
        contentPane.add(label4, "cell 1 4");
        contentPane.add(entryYear, "cell 2 4 8 1");

        //---- label5 ----
        label5.setText("\u624b\u673a\u53f7\u7801\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));
        contentPane.add(label5, "cell 1 5");
        contentPane.add(stuTel, "cell 2 5 8 1");

        //---- label6 ----
        label6.setText("\u7535\u5b50\u90ae\u7bb1\uff1a");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 5f));
        contentPane.add(label6, "cell 1 6");
        contentPane.add(stumail, "cell 2 6 8 1");

        //---- label7 ----
        label7.setText("QQ\u53f7\u7801\uff1a");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 5f));
        label7.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label7, "cell 1 7");
        contentPane.add(qq, "cell 2 7 8 1");

        //---- label8 ----
        label8.setText("\u767b\u9646\u5bc6\u7801\uff1a");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 5f));
        contentPane.add(label8, "cell 1 8");
        contentPane.add(stuPwd, "cell 2 8 8 1");

        //---- cancle ----
        cancle.setText("\u53d6\u6d88");
        cancle.addActionListener(e -> cancle(e));
        contentPane.add(cancle, "cell 1 10");

        //---- reset ----
        reset.setText("\u91cd\u7f6e");
        reset.addActionListener(e -> reset(e));
        contentPane.add(reset, "cell 8 10");

        //---- yes ----
        yes.setText("\u786e\u5b9a");
        yes.addActionListener(e -> yes(e));
        contentPane.add(yes, "cell 10 10");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField stuNum;
    private JLabel label2;
    private JTextField stuName;
    private JLabel label3;
    private JTextField stuField;
    private JLabel label9;
    private JTextField stuClass;
    private JLabel label4;
    private JTextField entryYear;
    private JLabel label5;
    private JTextField stuTel;
    private JLabel label6;
    private JTextField stumail;
    private JLabel label7;
    private JTextField qq;
    private JLabel label8;
    private JTextField stuPwd;
    private JButton cancle;
    private JButton reset;
    private JButton yes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private void reset(ActionEvent e) {
        // TODO add your code here
        this.stuNum.setText("");
        this.stuName.setText("");
        this.stuField.setText("");
        this.stuClass.setText("");
        this.entryYear.setText("");
        this.stuTel.setText("");
        this.stumail.setText("");
        this.qq.setText("");
        this.stuPwd.setText("");
    }
}
