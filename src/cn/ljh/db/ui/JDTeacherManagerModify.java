/*
 * Created by JFormDesigner on Sun Jul 07 10:28:18 CST 2024
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
public class JDTeacherManagerModify extends JDialog {
    public JDTeacherManagerModify() {

    }

    private void yes(ActionEvent e) {
        // TODO add your code here
        this.setModal(true);
        BeanTeacher teacher = new BeanTeacher();
        teacher.setTeaNum(teaNum.getText());
        teacher.setTeaName(teaName.getText());
        teacher.setBelongCollege(belongCollege.getText());
        teacher.setTeaTel(teaTel.getText());
        teacher.setTeaemail(teamile.getText());
        TeacherManager tm = new TeacherManager();
        try {
            tm.modifyTeacher(teacher);
            JOptionPane.showMessageDialog(null, "修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (BaseException e1) {
            JOptionPane.showMessageDialog(null, "修改失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }

    }

    private void reset(ActionEvent e) {
        // TODO add your code here
        teaName.setText(modifyTeacher.getTeaName());
        belongCollege.setText(modifyTeacher.getBelongCollege());
        teaTel.setText(modifyTeacher.getTeaTel());
        teamile.setText(modifyTeacher.getTeaemail());
    }

    private void Exit(ActionEvent e) {
        // TODO add your code here
        this.dispose();
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
        teamile = new JTextField();
        Exit = new JButton();
        reset = new JButton();
        yes = new JButton();

        //======== this ========
        setTitle("\u6559\u5e08\u4fe1\u606f\u4fee\u6539");
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

        //---- Exit ----
        Exit.setText("\u9000\u51fa");
        Exit.addActionListener(e -> Exit(e));

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
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(5, 5, 5)
                                    .addComponent(teaNum, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(5, 5, 5)
                                    .addComponent(teaName, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addGap(5, 5, 5)
                                    .addComponent(belongCollege, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addGap(5, 5, 5)
                                    .addComponent(teaTel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label5)
                                    .addGap(5, 5, 5)
                                    .addComponent(teamile, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(Exit)
                            .addGap(231, 231, 231)
                            .addComponent(reset)
                            .addGap(18, 18, 18)
                            .addComponent(yes)))
                    .addGap(18, 18, 18))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(teaNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(teaName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(belongCollege, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(teaTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(teamile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Exit)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(yes)
                            .addComponent(reset)))
                    .addGap(14, 14, 14))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        teaNum.setText(modifyTeacher.getTeaNum());
        teaNum.setEditable(false);
        teaName.setText(modifyTeacher.getTeaName());
        belongCollege.setText(modifyTeacher.getBelongCollege());
        teaTel.setText(modifyTeacher.getTeaTel());
        teamile.setText(modifyTeacher.getTeaemail());
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
    private JTextField teamile;
    private JButton Exit;
    private JButton reset;
    private JButton yes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private BeanTeacher modifyTeacher;
    public JDTeacherManagerModify(String teaNum){
        TeacherManager tm = new TeacherManager();
        try{
            this.modifyTeacher = tm.LoadTeacherByNum(teaNum);
        }catch(BaseException e){
            JOptionPane.showMessageDialog(null, "该教师不存在！请刷新后重试！", "错误", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        initComponents();
        this.setModal(true);

    }

}
