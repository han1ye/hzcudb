/*
 * Created by JFormDesigner on Sun Jul 07 09:48:31 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.event.*;
import javax.swing.*;

import cn.ljh.db.control.TeacherManager;
import cn.ljh.db.model.BeanTeacher;
import cn.ljh.db.util.BaseException;

/**
 * @author LJH
 */
public class JDTeacherManagerCreate extends JDialog {
    public JDTeacherManagerCreate() {
        this.setModal(true);
        initComponents();
    }

    private void reset(ActionEvent e) {
        // TODO add your code here
        teaNum.setText("");
        teaName.setText("");
        belongCollege.setText("");
        teaTel.setText("");
        teaemail.setText("");
    }

    private void cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void yes(ActionEvent e) {
        // TODO add your code here
        TeacherManager teamg = new TeacherManager();
        BeanTeacher teacher= new BeanTeacher();
        teacher.setTeaNum(teaNum.getText());
        teacher.setTeaName(teaName.getText());
        teacher.setBelongCollege(belongCollege.getText());
        teacher.setTeaTel(teaTel.getText());
        teacher.setTeaemail(teaemail.getText());
        try{
            teamg.createTeacher(teacher);
            this.teacher = teacher;
            JOptionPane.showMessageDialog(this, "添加成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        }catch (BaseException e1){
            JOptionPane.showMessageDialog(this,"添加失败！"+e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        teaNum = new JTextField();
        label2 = new JLabel();
        teaName = new JTextField();
        label3 = new JLabel();
        belongCollege = new JTextField();
        label4 = new JLabel();
        teaTel = new JTextField();
        label5 = new JLabel();
        teaemail = new JTextField();
        cancel = new JButton();
        reset = new JButton();
        yes = new JButton();

        //======== this ========
        setTitle("\u6dfb\u52a0\u6559\u5e08");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u6559\u5e08\u5de5\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));

        //---- label2 ----
        label2.setText("\u6559\u5e08\u59d3\u540d\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));

        //---- label3 ----
        label3.setText("\u6240\u5c5e\u5b66\u9662\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));

        //---- label4 ----
        label4.setText("\u624b\u673a\u53f7\u7801\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));

        //---- label5 ----
        label5.setText("\u7535\u5b50\u90ae\u7bb1\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));

        //---- cancel ----
        cancel.setText("\u53d6\u6d88");
        cancel.addActionListener(e -> cancel(e));

        //---- reset ----
        reset.setText("\u91cd\u7f6e");
        reset.addActionListener(e -> reset(e));

        //---- yes ----
        yes.setText("\u786e\u5b9a");
        yes.addActionListener(e -> yes(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(7, 7, 7)
                            .addComponent(teaNum, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(7, 7, 7)
                            .addComponent(teaName, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addGap(7, 7, 7)
                            .addComponent(belongCollege, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4)
                            .addGap(7, 7, 7)
                            .addComponent(teaTel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(7, 7, 7)
                            .addComponent(teaemail, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
                    .addGap(140, 140, 140))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cancel)
                    .addGap(206, 206, 206)
                    .addComponent(reset)
                    .addGap(61, 61, 61)
                    .addComponent(yes)
                    .addGap(22, 22, 22))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(teaNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(teaName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(20, 20, 20)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(belongCollege, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(teaTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(20, 20, 20)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label5)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(teaemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(cancel)
                        .addComponent(reset)
                        .addComponent(yes))
                    .addGap(39, 39, 39))
        );
        setSize(495, 375);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField teaNum;
    private JLabel label2;
    private JTextField teaName;
    private JLabel label3;
    private JTextField belongCollege;
    private JLabel label4;
    private JTextField teaTel;
    private JLabel label5;
    private JTextField teaemail;
    private JButton cancel;
    private JButton reset;
    private JButton yes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private BeanTeacher teacher = null;
    public BeanTeacher getTeacher() {
        return teacher;
    }
}
