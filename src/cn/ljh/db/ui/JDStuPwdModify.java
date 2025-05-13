/*
 * Created by JFormDesigner on Fri Jul 12 08:36:17 CST 2024
 */

package cn.ljh.db.ui;

import cn.ljh.db.control.StudentManager;
import cn.ljh.db.util.BaseException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author LJH
 */
public class JDStuPwdModify extends JDialog {
    public JDStuPwdModify(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }
    private void ChoiceStu(ActionEvent e) {
        // TODO add your code here
        JDChoiceStu cc = new JDChoiceStu(this);
        cc.setVisible(true);
        if(cc.isOK){
            StuNum.setText(cc.getValue().getStuNum());
            StuName.setText(cc.getValue().getStuName());
        }
    }

    private void Yes(ActionEvent e) {
        // TODO add your code here
        String stuNum = StuNum.getText();
        String pwd = NewPwd.getText();
        String confPwd = ConfPwd.getText();
        if(StuNum.getText().equals("")){
            JOptionPane.showMessageDialog(this, "请先选择学生！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(pwd.equals(confPwd)){
            try {
                new StudentManager().modifyPwd(stuNum, pwd);
                JOptionPane.showMessageDialog(this, "修改密码成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
            }catch (BaseException e1){
                JOptionPane.showMessageDialog(this, "修改失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "两次输入的密码不一致，请重新输入！", "提示", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void Cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        StuNum = new JTextField();
        label2 = new JLabel();
        StuName = new JTextField();
        ChoiceStu = new JButton();
        label3 = new JLabel();
        NewPwd = new JTextField();
        label4 = new JLabel();
        ConfPwd = new JTextField();
        Cancel = new JButton();
        Yes = new JButton();

        //======== this ========
        setTitle("\u5b66\u751f\u5bc6\u7801\u4fee\u6539");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5b66\u751f\u5b66\u53f7\uff1a");

        //---- label2 ----
        label2.setText("\u5b66\u751f\u59d3\u540d\uff1a");

        //---- ChoiceStu ----
        ChoiceStu.setText("\u9009\u62e9\u5b66\u751f");
        ChoiceStu.addActionListener(e -> ChoiceStu(e));

        //---- label3 ----
        label3.setText("\u65b0\u5bc6\u7801\uff1a");

        //---- label4 ----
        label4.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");

        //---- Cancel ----
        Cancel.setText("\u53d6\u6d88");
        Cancel.addActionListener(e -> Cancel(e));

        //---- Yes ----
        Yes.setText("\u786e\u5b9a");
        Yes.addActionListener(e -> Yes(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(Cancel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 375, Short.MAX_VALUE)
                    .addComponent(Yes)
                    .addGap(49, 49, 49))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(175, 175, 175)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(5, 5, 5)
                            .addComponent(StuNum, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(5, 5, 5)
                            .addComponent(StuName, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(ChoiceStu))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(NewPwd, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4)
                            .addGap(5, 5, 5)
                            .addComponent(ConfPwd, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(192, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(StuNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(StuName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addComponent(ChoiceStu)
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(NewPwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(ConfPwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(68, 68, 68)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Cancel)
                        .addComponent(Yes))
                    .addContainerGap())
        );
        setSize(565, 410);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        StuNum.setEditable(false);
        StuName.setEditable(false);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField StuNum;
    private JLabel label2;
    private JTextField StuName;
    private JButton ChoiceStu;
    private JLabel label3;
    private JTextField NewPwd;
    private JLabel label4;
    private JTextField ConfPwd;
    private JButton Cancel;
    private JButton Yes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
