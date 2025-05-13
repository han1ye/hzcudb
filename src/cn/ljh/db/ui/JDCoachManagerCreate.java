/*
 * Created by JFormDesigner on Tue Jul 09 11:12:28 CST 2024
 */

package cn.ljh.db.ui;

import cn.ljh.db.control.CoachManager;
import cn.ljh.db.control.CompetitionManager;
import cn.ljh.db.control.TeamManager;
import cn.ljh.db.model.CoachInfo;
import cn.ljh.db.util.BaseException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author LJH
 */
public class JDCoachManagerCreate extends JDialog {
    public JDCoachManagerCreate(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }

    private void ChoiceTeam(ActionEvent e) {
        // TODO add your code here
        JDChoiceTeam ct = new JDChoiceTeam(this);
        ct.setVisible(true);
        if(ct.isOK){
            TeamCode.setText(ct.getValue().getTeamCode());
            try {
                teamsize = ct.getValue().getTeamSize();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    private void ChoiceTeacher(ActionEvent e) {
        // TODO add your code here
        JDChoiceTeacher ct = new JDChoiceTeacher(this);
        ct.setVisible(true);
        if(ct.isOK){
            TeacherNum.setText(ct.getValue().getTeaNum());
        }
    }

    private void ChoiceComp(ActionEvent e) {
        // TODO add your code here
        JDChoiceComp ct = new JDChoiceComp(this);
        ct.setVisible(true);
        if(ct.isok){
            CompNum.setText(ct.getValue().getCompNum());
            try{
                CompGroup.setSelected((new CompetitionManager().compisgroup(ct.getValue().getCompNum())));
            }catch (Exception e1){
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "获取比赛组队信息失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private void Yes(ActionEvent e) {
        // TODO add your code here
        CoachManager cm = new CoachManager();
        CoachInfo cai = new CoachInfo();
        cai.setTeamCode(TeamCode.getText());
        cai.setTeaNum(TeacherNum.getText());
        cai.setCompNum(CompNum.getText());
        try{
            if(teamsize == 1&&CompGroup.isSelected()){
                JOptionPane.showMessageDialog(this, "该赛事为团体赛，队伍中队员最大数量应大于1！", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(teamsize >1&&!CompGroup.isSelected()){

                JOptionPane.showMessageDialog(this, "该赛事为个人赛，队伍中队员最大数量应为1！", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }
            cm.createCoachInfo(cai);
            JOptionPane.showMessageDialog(this, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }catch (BaseException e1){
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this, "添加失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        TeamCode = new JTextField();
        ChoiceTeam = new JButton();
        label2 = new JLabel();
        TeacherNum = new JTextField();
        ChoiceTeacher = new JButton();
        label3 = new JLabel();
        CompNum = new JTextField();
        ChoiceComp = new JButton();
        Cancel = new JButton();
        Reset = new JButton();
        Yes = new JButton();
        CompGroup = new JCheckBox();

        //======== this ========
        setTitle("\u6dfb\u52a0\u6307\u5bfc\u4fe1\u606f");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u961f\u4f0d\u7f16\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));

        //---- ChoiceTeam ----
        ChoiceTeam.setText("\u9009\u62e9\u961f\u4f0d");
        ChoiceTeam.addActionListener(e -> ChoiceTeam(e));

        //---- label2 ----
        label2.setText("\u804c\u5de5\u53f7\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));

        //---- ChoiceTeacher ----
        ChoiceTeacher.setText("\u9009\u62e9\u6307\u5bfc\u8001\u5e08");
        ChoiceTeacher.addActionListener(e -> ChoiceTeacher(e));

        //---- label3 ----
        label3.setText("\u8d5b\u4e8b\u5e8f\u53f7\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));

        //---- ChoiceComp ----
        ChoiceComp.setText("\u9009\u62e9\u8d5b\u4e8b");
        ChoiceComp.addActionListener(e -> ChoiceComp(e));

        //---- Cancel ----
        Cancel.setText("\u53d6\u6d88");

        //---- Reset ----
        Reset.setText("\u91cd\u7f6e");

        //---- Yes ----
        Yes.setText("\u786e\u5b9a");
        Yes.addActionListener(e -> Yes(e));

        //---- CompGroup ----
        CompGroup.setText("\u8be5\u8d5b\u4e8b\u662f\u5426\u4e3a\u7ec4\u961f\u8d5b");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(88, 88, 88)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(5, 5, 5)
                                    .addComponent(TeamCode, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(TeacherNum, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addGap(5, 5, 5)
                                    .addComponent(CompNum, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(89, 89, 89)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(ChoiceTeam, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ChoiceTeacher)
                                        .addComponent(ChoiceComp, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CompGroup)))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(Cancel)
                            .addGap(204, 204, 204)
                            .addComponent(Reset)
                            .addGap(30, 30, 30)
                            .addComponent(Yes)))
                    .addGap(31, 31, 31))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(TeamCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addComponent(ChoiceTeam)
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(TeacherNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addComponent(ChoiceTeacher)
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(CompNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addComponent(ChoiceComp)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(CompGroup)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Cancel)
                        .addComponent(Reset)
                        .addComponent(Yes))
                    .addGap(23, 23, 23))
        );
        setSize(465, 375);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        TeamCode.setEditable(false);
        TeacherNum.setEditable(false);
        CompNum.setEditable(false);
        CompGroup.setSelected(false);
        CompGroup.setEnabled(false);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField TeamCode;
    private JButton ChoiceTeam;
    private JLabel label2;
    private JTextField TeacherNum;
    private JButton ChoiceTeacher;
    private JLabel label3;
    private JTextField CompNum;
    private JButton ChoiceComp;
    private JButton Cancel;
    private JButton Reset;
    private JButton Yes;
    private JCheckBox CompGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private int teamsize = 0;
}
