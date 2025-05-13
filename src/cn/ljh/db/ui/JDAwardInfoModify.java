/*
 * Created by JFormDesigner on Tue Jul 09 10:08:21 CST 2024
 */

package cn.ljh.db.ui;

import cn.ljh.db.control.AwardInfoManager;
import cn.ljh.db.control.CompetitionManager;
import cn.ljh.db.control.TeamManager;
import cn.ljh.db.model.AwardInfo;
import cn.ljh.db.util.BaseException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author LJH
 */
public class JDAwardInfoModify extends JDialog {
    public JDAwardInfoModify(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }
    public JDAwardInfoModify(Window owner, AwardInfo ModifyAwardInfo) {
        super(owner);
        this.setModal(true);
        this.ModifyAwardInfo = ModifyAwardInfo;
        initComponents();
    }

    private void ChoiceComp(ActionEvent e) {
        // TODO add your code here
        JDChoiceComp cc = new JDChoiceComp(this);
        cc.setVisible(true);
        if(cc.isok){
            try {
                CompGroup.setSelected((new CompetitionManager().compisgroup(cc.getValue().getCompNum())));
            }catch (Exception e1){
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "获取比赛组队信息失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
            JCompNum.setText(cc.getValue().getCompNum());

        }
    }

    private void ChoiceTeam(ActionEvent e) {
        // TODO add your code here
        JDChoiceTeam ct = new JDChoiceTeam(this);
        ct.setVisible(true);
        if(ct.isOK){
            try{
                teamsize = ct.getValue().getTeamSize();
            }catch (Exception e1){
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "获取队伍人数失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
            JTeamCode.setText(ct.getValue().getTeamCode());
        }
    }

    private void Reset(ActionEvent e) {
        // TODO add your code here
        JCompNum.setText(ModifyAwardInfo.getCompNum());
        JTeamCode.setText(ModifyAwardInfo.getTeamCode());
        JAwareInfo.setText(ModifyAwardInfo.getAwards());
        try{
            teamsize = (new TeamManager().LoadTeamStuNumByTeamCode(ModifyAwardInfo.getTeamCode()));
        }catch (Exception e1){
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this, "获取队伍人数失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
        try {
            CompGroup.setSelected((new CompetitionManager().compisgroup(ModifyAwardInfo.getCompNum())));
        }catch (Exception e1){
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this, "获取比赛组队信息失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void Yes(ActionEvent e) {
        // TODO add your code here
        AwardInfo awardInfo = new AwardInfo();
        AwardInfoManager aim = new AwardInfoManager();
        awardInfo.setCompNum(JCompNum.getText());
        awardInfo.setTeamCode(JTeamCode.getText());
        awardInfo.setAwards(JAwareInfo.getText());
        try{
            if(CompGroup.isSelected()&&teamsize==1){
                JOptionPane.showMessageDialog(this, "该赛事为团队赛，队伍人数最大数量应大于1！", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }else if(!CompGroup.isSelected()&&teamsize>1){
                JOptionPane.showMessageDialog(this, "该赛事为个人赛，队伍人数最大数量应为1！", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }
            aim.modifyAwardInfo(awardInfo,ModifyAwardInfo);
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
        JCompNum = new JTextField();
        ChoiceComp = new JButton();
        label2 = new JLabel();
        JTeamCode = new JTextField();
        ChoiceTeam = new JButton();
        label3 = new JLabel();
        JAwareInfo = new JTextField();
        Cancel = new JButton();
        Reset = new JButton();
        Yes = new JButton();
        CompGroup = new JCheckBox();

        //======== this ========
        setTitle("\u83b7\u5956\u4fe1\u606f\u4fee\u6539");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8d5b\u4e8b\u5e8f\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));

        //---- ChoiceComp ----
        ChoiceComp.setText("\u9009\u62e9\u8d5b\u4e8b");
        ChoiceComp.addActionListener(e -> ChoiceComp(e));

        //---- label2 ----
        label2.setText("\u961f\u4f0d\u7f16\u53f7\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));

        //---- ChoiceTeam ----
        ChoiceTeam.setText("\u9009\u62e9\u961f\u4f0d");
        ChoiceTeam.addActionListener(e -> ChoiceTeam(e));

        //---- label3 ----
        label3.setText("\u5956\u9879\u7b49\u7ea7\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));

        //---- Cancel ----
        Cancel.setText("\u53d6\u6d88");
        Cancel.addActionListener(e -> Cancel(e));

        //---- Reset ----
        Reset.setText("\u91cd\u7f6e");
        Reset.addActionListener(e -> Reset(e));

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
                    .addGap(121, 121, 121)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(5, 5, 5)
                            .addComponent(JCompNum, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(5, 5, 5)
                            .addComponent(JTeamCode, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addGap(5, 5, 5)
                            .addComponent(JAwareInfo, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(ChoiceTeam)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(ChoiceComp)
                                    .addGap(18, 18, 18)
                                    .addComponent(CompGroup)))))
                    .addGap(86, 86, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(Cancel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                    .addComponent(Reset)
                    .addGap(50, 50, 50)
                    .addComponent(Yes)
                    .addGap(44, 44, 44))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JCompNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ChoiceComp)
                        .addComponent(CompGroup))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTeamCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(ChoiceTeam)
                            .addGap(30, 30, 30)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                .addComponent(JAwareInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Cancel)
                                .addComponent(Yes)
                                .addComponent(Reset))))
                    .addGap(26, 26, 26))
        );
        setSize(530, 390);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        JCompNum.setEditable(false);
        JTeamCode.setEditable(false);
        JTeamCode.setText(ModifyAwardInfo.getTeamCode());
        JCompNum.setText(ModifyAwardInfo.getCompNum());
        JAwareInfo.setText(ModifyAwardInfo.getAwards());
        CompGroup.setEnabled(false);
        try{
            teamsize = (new TeamManager().LoadTeamByTeamCode(ModifyAwardInfo.getTeamCode()).getTeamSize());
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "获取队伍人数失败！"+e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
        try {
            CompGroup.setSelected((new CompetitionManager().compisgroup(ModifyAwardInfo.getCompNum())));
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "获取比赛组队信息失败！"+e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField JCompNum;
    private JButton ChoiceComp;
    private JLabel label2;
    private JTextField JTeamCode;
    private JButton ChoiceTeam;
    private JLabel label3;
    private JTextField JAwareInfo;
    private JButton Cancel;
    private JButton Reset;
    private JButton Yes;
    private JCheckBox CompGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private AwardInfo ModifyAwardInfo;
    private int teamsize = 0;

}
