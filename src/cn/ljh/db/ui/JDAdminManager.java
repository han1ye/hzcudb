/*
 * Created by JFormDesigner on Fri Jul 12 13:39:29 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.event.*;

import cn.ljh.db.control.SystemAdminManager;
import cn.ljh.db.model.BeanSystemAdmin;

import java.awt.*;
import javax.swing.*;

/**
 * @author LJH
 */
public class JDAdminManager extends JDialog {
    public JDAdminManager(Window owner) {
        super(owner);
        initComponents();
    }

    public JDAdminManager(Window owner, BeanSystemAdmin admin) {
        super(owner);
        this.owner = owner;
        this.admin = admin;
        this.setModal(true);
        initComponents();
    }

    private void Cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void Yes(ActionEvent e) {
        // TODO add your code here
        // 验证密码
        if(AdminNewPwd.getText().length() >20 || AdminNewPwd.getText().equals("")){
            JOptionPane.showMessageDialog(this, "密码长度必须为1-20个字符，请重新输入！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!AdminNewPwd.getText().equals(AdminConfPwd.getText())){
            JOptionPane.showMessageDialog(this, "两次输入的密码不一致，请重新输入！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // 确认修改
        if(JOptionPane.showConfirmDialog(this, "确认修改？", "提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            SystemAdminManager am = new SystemAdminManager();
            try {
                am.updateAdminPwd(admin.getAdminNum(), AdminNewPwd.getText());
                JOptionPane.showMessageDialog(this, "修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                new JFLogin().setVisible(true);
                owner.dispose();
            }catch (Exception e1){
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "修改失败，请联系管理员！", "提示", JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        AdminNum = new JTextField();
        label2 = new JLabel();
        AdminName = new JTextField();
        label4 = new JLabel();
        AdminNewPwd = new JTextField();
        label5 = new JLabel();
        AdminConfPwd = new JTextField();
        Cancel = new JButton();
        Yes = new JButton();

        //======== this ========
        setTitle("\u4e2a\u4eba\u4fe1\u606f\u4fee\u6539");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u7ba1\u7406\u5458\u7f16\u53f7:");

        //---- label2 ----
        label2.setText("\u7ba1\u7406\u5458\u59d3\u540d\uff1a");

        //---- label4 ----
        label4.setText("\u65b0\u5bc6\u7801\uff1a");

        //---- label5 ----
        label5.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");

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
                    .addGap(147, 147, 147)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(AdminNum, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(147, 147, 147)
                    .addComponent(label2)
                    .addGap(5, 5, 5)
                    .addComponent(AdminName, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(147, 147, 147)
                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(AdminNewPwd, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(147, 147, 147)
                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(AdminConfPwd, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(Cancel)
                    .addGap(407, 407, 407)
                    .addComponent(Yes))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(AdminNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(AdminName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(55, 55, 55)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(AdminNewPwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(AdminConfPwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(80, 80, 80)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Cancel)
                        .addComponent(Yes)))
        );
        setSize(595, 425);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        AdminNum.setEditable(false);
        AdminNum.setText(admin.getAdminNum());
        AdminName.setText(admin.getAdminName());
        AdminNewPwd.setText("");
        AdminConfPwd.setText("");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField AdminNum;
    private JLabel label2;
    private JTextField AdminName;
    private JLabel label4;
    private JTextField AdminNewPwd;
    private JLabel label5;
    private JTextField AdminConfPwd;
    private JButton Cancel;
    private JButton Yes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private BeanSystemAdmin admin;
    private Window owner;
}
