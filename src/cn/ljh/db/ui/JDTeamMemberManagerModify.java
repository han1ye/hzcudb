/*
 * Created by JFormDesigner on Tue Jul 09 14:47:10 CST 2024
 */

package cn.ljh.db.ui;

import cn.ljh.db.control.StudentManager;
import cn.ljh.db.control.TeamManager;
import cn.ljh.db.control.TeamMemberManager;
import cn.ljh.db.model.TeamMember;
import cn.ljh.db.util.BaseException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author LJH
 */
public class JDTeamMemberManagerModify extends JDialog {
    public JDTeamMemberManagerModify(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }
    public JDTeamMemberManagerModify(Window owner, TeamMember modifyTeamMember) {
        super(owner);
        this.setModal(true);
        this.modifyTeamMember= modifyTeamMember;
        initComponents();
    }

    private void ChoiceTeam(ActionEvent e) {
        // TODO add your code here
        JDChoiceTeam jdc = new JDChoiceTeam(this);
        jdc.setVisible(true);
        if(jdc.isOK){
            TeamCode.setText(jdc.getValue().getTeamCode());
            TeamName.setText(jdc.getValue().getTeamName());
        }
    }

    private void ChoiceStu(ActionEvent e) {
        // TODO add your code here
        JDChoiceStu jds = new JDChoiceStu(this);
        jds.setVisible(true);
        if(jds.isOK) {
            StuNum.setText(jds.getValue().getStuNum());
            StuName.setText(jds.getValue().getStuName());
        }
    }

    private void Reset(ActionEvent e) {
        // TODO add your code here
        StuNum.setText(modifyTeamMember.getStuNum());
        TeamCode.setText(modifyTeamMember.getTeamCode());
        try{
            StuName.setText(new StudentManager().loadStudentByStuNum(modifyTeamMember.getStuNum()).getStuName());

            TeamName.setText(new TeamManager().LoadTeamByTeamCode(modifyTeamMember.getTeamCode()).getTeamName());
        }catch (Exception e1){
            e1.printStackTrace();
        }
        if(modifyTeamMember.isLeader()){
            Leader.setSelected(true);
        }else{
            Leader.setSelected(false);
        }
    }

    private void Cancle(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void Yes(ActionEvent e) {
        // TODO add your code here
        TeamMember teamMember = new TeamMember();
        TeamMemberManager tmm = new TeamMemberManager();
        teamMember.setStuNum(StuNum.getText());
        teamMember.setTeamCode(TeamCode.getText());
        teamMember.setLeader(Leader.isSelected());
        try{
            tmm.modifyTeamMember(teamMember,modifyTeamMember);
            JOptionPane.showMessageDialog(this, "修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }catch (BaseException e1){
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this, "修改失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        TeamCode = new JTextField();
        label2 = new JLabel();
        TeamName = new JTextField();
        ChoiceTeam = new JButton();
        label3 = new JLabel();
        StuNum = new JTextField();
        label4 = new JLabel();
        StuName = new JTextField();
        ChoiceStu = new JButton();
        label5 = new JLabel();
        Leader = new JRadioButton();
        Cancle = new JButton();
        Reset = new JButton();
        Yes = new JButton();

        //======== this ========
        setTitle("\u961f\u4f0d\u6210\u5458\u4fee\u6539");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u961f\u4f0d\u7f16\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));

        //---- label2 ----
        label2.setText("\u961f\u4f0d\u540d\u79f0\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));

        //---- ChoiceTeam ----
        ChoiceTeam.setText("\u9009\u62e9\u961f\u4f0d");
        ChoiceTeam.addActionListener(e -> ChoiceTeam(e));

        //---- label3 ----
        label3.setText("\u5b66\u751f\u5b66\u53f7\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));

        //---- label4 ----
        label4.setText("\u5b66\u751f\u59d3\u540d\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));

        //---- ChoiceStu ----
        ChoiceStu.setText("\u9009\u62e9\u5b66\u751f");
        ChoiceStu.addActionListener(e -> ChoiceStu(e));

        //---- label5 ----
        label5.setText("\u662f\u5426\u4e3a\u961f\u957f\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));

        //---- Cancle ----
        Cancle.setText("\u53d6\u6d88");
        Cancle.addActionListener(e -> Cancle(e));

        //---- Reset ----
        Reset.setText("\u91cd\u7f6e");
        Reset.addActionListener(e -> Reset(e));

        //---- Yes ----
        Yes.setText("\u786e\u5b9a");
        Yes.addActionListener(e -> Yes(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(0, 42, Short.MAX_VALUE)
                    .addComponent(Cancle)
                    .addGap(297, 297, 297)
                    .addComponent(Reset)
                    .addGap(18, 18, 18)
                    .addComponent(Yes)
                    .addGap(25, 25, 25))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(113, 113, 113)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(TeamCode, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(TeamName, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(StuNum, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(StuName, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(5, 5, 5)
                            .addComponent(Leader))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(106, 106, 106)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(ChoiceTeam)
                                .addComponent(ChoiceStu))))
                    .addContainerGap(153, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(TeamCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(TeamName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addComponent(ChoiceTeam)
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(StuNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(StuName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addComponent(ChoiceStu)
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Leader))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Cancle)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Reset)
                            .addComponent(Yes)))
                    .addGap(22, 22, 22))
        );
        setSize(555, 375);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        StuNum.setEditable(false);
        StuName.setEditable(false);
        TeamCode.setEditable(false);
        TeamName.setEditable(false);
        StuNum.setText(modifyTeamMember.getStuNum());
        TeamCode.setText(modifyTeamMember.getTeamCode());
        try{
            StuName.setText(new StudentManager().loadStudentByStuNum(modifyTeamMember.getStuNum()).getStuName());

            TeamName.setText(new TeamManager().LoadTeamByTeamCode(modifyTeamMember.getTeamCode()).getTeamName());
        }catch (Exception e){
            e.printStackTrace();
        }
        if(modifyTeamMember.isLeader()){
            Leader.setSelected(true);
        }else{
            Leader.setSelected(false);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField TeamCode;
    private JLabel label2;
    private JTextField TeamName;
    private JButton ChoiceTeam;
    private JLabel label3;
    private JTextField StuNum;
    private JLabel label4;
    private JTextField StuName;
    private JButton ChoiceStu;
    private JLabel label5;
    private JRadioButton Leader;
    private JButton Cancle;
    private JButton Reset;
    private JButton Yes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private TeamMember modifyTeamMember;
}
