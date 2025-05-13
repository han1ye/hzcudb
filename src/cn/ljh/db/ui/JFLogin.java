/*
 * Created by JFormDesigner on Sat Jul 06 09:04:41 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import cn.ljh.db.control.StudentManager;
import cn.ljh.db.control.SystemAdminManager;
import cn.ljh.db.model.BeanStudent;
import cn.ljh.db.model.BeanSystemAdmin;
import cn.ljh.db.util.BaseException;

/**
 * @author LJH
 */
public class JFLogin extends JFrame {
    public JFLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFLogin frame = new JFLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void exit(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void ButLogin(ActionEvent e) {
        // TODO add your code here

        String userid = this.textField1.getText();
        String pwd = new String(this.Pwd.getPassword());
        if (userid.length() > 20 || pwd.length() > 20) {
            JOptionPane.showMessageDialog(null, "账号或密码过长：最长为20字符", "错误提示", JOptionPane.ERROR_MESSAGE);
        } else if (userid.equals("") || pwd.equals("") || userid == null || pwd == null) {
            JOptionPane.showMessageDialog(null, "账号或密码不能为空", "错误提示", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if (comboBox1.getSelectedIndex() == 0) {
                    StudentManager sm = new StudentManager();
                    BeanStudent stu = sm.loadStudentByStuNum(userid);
                    if (pwd.equals(stu.getStuPwd())) {
                        StudentManager.currentStu = stu;
                        JFStuinquire js = new JFStuinquire(this ,stu);
                        js.setVisible(true);
                        this.setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(null, "密码错误", "错误提示", JOptionPane.ERROR_MESSAGE);
                    }

                } else if (comboBox1.getSelectedIndex() == 1) {
                    SystemAdminManager sam = new SystemAdminManager();
                    BeanSystemAdmin admin = sam.loadAdmin(userid);
                    if (pwd.equals(admin.getAdminPwd())) {
                        SystemAdminManager.currentAdmin = admin;
                        new JFMain(admin).setVisible(true);
                        //setVisible(false);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "密码错误", "错误提示", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } catch (BaseException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "错误提示", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private void showpwd(ActionEvent e) {
        // TODO add your code here
        if (this.showpwd.isSelected()) {
            this.Pwd.setEchoChar((char) 0);
        } else {
            this.Pwd.setEchoChar('\u2022');
        }
    }

    private void reset(ActionEvent e) {
        // TODO add your code here
        this.textField1.setText("");
        this.Pwd.setText("");
        this.showpwd.setSelected(false);
    }


    


    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label3 = new JLabel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        Pwd = new JPasswordField();
        showpwd = new JToggleButton();
        comboBox1 = new JComboBox<>();
        exit = new JButton();
        reset = new JButton();
        ButLogin = new JButton();

        //======== this ========
        setTitle("\u7ba1\u7406\u5458\u767b\u5f55\u754c\u9762");
        setIconImage(null);
        setResizable(false);
        var contentPane = getContentPane();

        //---- label3 ----
        label3.setText("\u6b22\u8fce\u6765\u5230\u7ade\u8d5b\u7ba1\u7406\u7cfb\u7edf");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 22f));

        //---- label1 ----
        label1.setText("\u8d26\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 8f));

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 8f));

        //---- showpwd ----
        showpwd.setText("\u663e\u793a\u5bc6\u7801");
        showpwd.addActionListener(e -> showpwd(e));

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u5b66\u751f",
            "\u7ba1\u7406\u5458"
        }));

        //---- exit ----
        exit.setText("\u9000\u51fa");
        exit.addActionListener(e -> exit(e));

        //---- reset ----
        reset.setText("\u91cd\u7f6e");
        reset.addActionListener(e -> reset(e));

        //---- ButLogin ----
        ButLogin.setText("\u767b\u5f55");
        ButLogin.addActionListener(e -> ButLogin(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(780, 780, 780)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(5, 5, 5)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(5, 5, 5)
                            .addComponent(Pwd, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(showpwd))
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(exit, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addGap(205, 205, 205)
                            .addComponent(reset)
                            .addGap(19, 19, 19)
                            .addComponent(ButLogin, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(label3)
                    .addGap(105, 105, 105)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                    .addGap(80, 80, 80)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(Pwd, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                        .addComponent(showpwd))
                    .addGap(30, 30, 30)
                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(80, 80, 80)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(exit)
                        .addComponent(reset)
                        .addComponent(ButLogin)))
        );
        setSize(1260, 725);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        //账号改变时清空密码
        textField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Pwd.setText("");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Pwd.setText("");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                Pwd.setText("");
            }
        });

        //1.设置背景图片
        ImageIcon bg=new ImageIcon("imag/backgroundlogin.png");
        JLabel label=new JLabel(bg);
        label.setSize(bg.getIconWidth(),bg.getIconHeight());
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        //2.把窗口面板设为内容面板并设为透明、流动布局。
        JPanel pan=(JPanel)this.getContentPane();
        pan.setOpaque(false);
        //pan.setLayout(new FlowLayout());
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label3;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField Pwd;
    private JToggleButton showpwd;
    private JComboBox<String> comboBox1;
    private JButton exit;
    private JButton reset;
    private JButton ButLogin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


}
