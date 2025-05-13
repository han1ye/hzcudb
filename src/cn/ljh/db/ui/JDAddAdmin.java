/*
 * Created by JFormDesigner on Sat Jul 13 08:32:44 CST 2024
 */

package cn.ljh.db.ui;

import cn.ljh.db.control.SystemAdminManager;
import cn.ljh.db.model.BeanSystemAdmin;
import cn.ljh.db.util.BaseException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author LJH
 */
public class JDAddAdmin extends JDialog {
    public JDAddAdmin(Window owner) {
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
        if(!AdminPwd.getText().equals(AdminPwdConf.getText())){
            JOptionPane.showMessageDialog(null,"两次输入的密码不一致！请检查！","警告",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(AdminPwd.getText().equals("")||AdminNum.getText().equals("")||AdminName.getText().equals("")){
            JOptionPane.showMessageDialog(null,"账号，姓名，密码均不能为空！","警告",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(AdminNum.getText().length()>20||AdminName.getText().length()>10||AdminPwd.getText().length()>20){
            JOptionPane.showMessageDialog(null,"姓名长度不能超过10，账号和密码长度不能超过20！","警告",JOptionPane.WARNING_MESSAGE);
            return;
        }
        SystemAdminManager sam = new SystemAdminManager();
        BeanSystemAdmin sa = new BeanSystemAdmin();
        sa.setAdminName(AdminName.getText());
        sa.setAdminNum(AdminNum.getText());
        sa.setAdminPwd(AdminPwd.getText());
        try{
            sam.CreatAdmin(sa);
            JOptionPane.showMessageDialog(null,"添加成功！","提示",JOptionPane.INFORMATION_MESSAGE);
        }catch (BaseException e1){
            e1.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        AdminNum = new JTextField();
        label2 = new JLabel();
        AdminName = new JTextField();
        label3 = new JLabel();
        AdminPwd = new JTextField();
        label4 = new JLabel();
        AdminPwdConf = new JTextField();
        Cancel = new JButton();
        Yes = new JButton();

        //======== this ========
        setTitle("\u6dfb\u52a0\u7ba1\u7406\u5458");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u7ba1\u7406\u5458\u8d26\u53f7\uff1a");

        //---- label2 ----
        label2.setText("\u7ba1\u7406\u5458\u59d3\u540d\uff1a");

        //---- label3 ----
        label3.setText("\u5bc6\u7801\uff1a");

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
                    .addGap(51, 51, 51)
                    .addComponent(Cancel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 407, Short.MAX_VALUE)
                    .addComponent(Yes)
                    .addGap(46, 46, 46))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(177, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(5, 5, 5)
                            .addComponent(AdminNum, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(5, 5, 5)
                            .addComponent(AdminName, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(AdminPwd, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(AdminPwdConf, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
                    .addGap(169, 169, 169))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(108, 108, 108)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(AdminNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(AdminName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(AdminPwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(AdminPwdConf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(77, 77, 77)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Yes)
                        .addComponent(Cancel))
                    .addContainerGap())
        );
        setSize(620, 430);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        AdminPwd.setText("");
        AdminNum.setText("");
        AdminName.setText("");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField AdminNum;
    private JLabel label2;
    private JTextField AdminName;
    private JLabel label3;
    private JTextField AdminPwd;
    private JLabel label4;
    private JTextField AdminPwdConf;
    private JButton Cancel;
    private JButton Yes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
