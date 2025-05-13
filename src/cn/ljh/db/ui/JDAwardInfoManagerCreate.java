/*
 * Created by JFormDesigner on Tue Jul 09 09:04:21 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import cn.ljh.db.control.AwardInfoManager;
import cn.ljh.db.control.CompetitionManager;
import cn.ljh.db.model.AwardInfo;
import cn.ljh.db.util.BaseException;
import net.miginfocom.swing.*;

/**
 * @author LJH
 */
public class JDAwardInfoManagerCreate extends JDialog {
    public JDAwardInfoManagerCreate(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }

    private void ChoiceComp(ActionEvent e) {
        // TODO add your code here
        JDChoiceComp cc = new JDChoiceComp(this);
        CompetitionManager cm = new CompetitionManager();
        cc.setVisible(true);
        if (cc.isok) {
            try{
                CompNum.setText(cc.getValue().getCompNum());
                matchsgroup.setSelected(cm.compisgroup(cc.getValue().getCompNum()));
            }catch (BaseException e1){
                JOptionPane.showMessageDialog(this, "获取比赛组队信息失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
            }

        }
    }

    private void ChoiceTeam(ActionEvent e) {
        // TODO add your code here
        JDChoiceTeam ct = new JDChoiceTeam(this);
        ct.setVisible(true);
        if (ct.isOK) {
            TeamCode.setText(ct.getValue().getTeamCode());
            teamsize = ct.getValue().getTeamSize();
        }
    }

    private void ok(ActionEvent e) {
        // TODO add your code here
        AwardInfo award = new AwardInfo();
        AwardInfoManager aim = new AwardInfoManager();
        award.setCompNum(CompNum.getText());
        award.setTeamCode(TeamCode.getText());
        award.setAwards(JAwardInfo.getText());
        try{
            if(!matchsgroup.isSelected()&&teamsize>1){
                JOptionPane.showMessageDialog(this, "该赛事为个人赛，队伍中队员最大数量应为1！", "提示", JOptionPane.INFORMATION_MESSAGE);
                return;
            }else if(matchsgroup.isSelected()&&teamsize==1){
                JOptionPane.showMessageDialog(this, "该赛事为团体赛，队伍中队员最大数量应大于1！", "提示", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            aim.createAwardInfo(award);
            JOptionPane.showMessageDialog(this, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }catch (BaseException e1){
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this, "添加失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Reset(ActionEvent e) {
        // TODO add your code here
        CompNum.setText("");
        TeamCode.setText("");
        JAwardInfo.setText("");
        this.teamsize = 0;
        this.matchsgroup.setSelected(false);
    }

    private void Cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        CompNum = new JTextField();
        ChoiceComp = new JButton();
        matchsgroup = new JCheckBox();
        label2 = new JLabel();
        TeamCode = new JTextField();
        ChoiceTeam = new JButton();
        label3 = new JLabel();
        JAwardInfo = new JTextField();
        Cancel = new JButton();
        Reset = new JButton();
        ok = new JButton();

        //======== this ========
        setTitle("\u6dfb\u52a0\u83b7\u5956\u4fe1\u606f");
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
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("\u8d5b\u4e8b\u5e8f\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
        contentPane.add(label1, "cell 2 2");
        contentPane.add(CompNum, "cell 3 2 8 1");

        //---- ChoiceComp ----
        ChoiceComp.setText("\u9009\u62e9\u8d5b\u4e8b");
        ChoiceComp.addActionListener(e -> ChoiceComp(e));
        contentPane.add(ChoiceComp, "cell 3 3");

        //---- matchsgroup ----
        matchsgroup.setText("\u8be5\u8d5b\u4e8b\u662f\u5426\u4e3a\u7ec4\u961f\u8d5b");
        contentPane.add(matchsgroup, "cell 5 3 6 1");

        //---- label2 ----
        label2.setText("\u961f\u4f0d\u7f16\u53f7\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));
        contentPane.add(label2, "cell 2 5");
        contentPane.add(TeamCode, "cell 3 5 8 1");

        //---- ChoiceTeam ----
        ChoiceTeam.setText("\u9009\u62e9\u961f\u4f0d");
        ChoiceTeam.addActionListener(e -> ChoiceTeam(e));
        contentPane.add(ChoiceTeam, "cell 3 6");

        //---- label3 ----
        label3.setText("\u5956\u9879\u7b49\u7ea7\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
        contentPane.add(label3, "cell 2 7");
        contentPane.add(JAwardInfo, "cell 3 7 8 1");

        //---- Cancel ----
        Cancel.setText("\u53d6\u6d88");
        Cancel.addActionListener(e -> Cancel(e));
        contentPane.add(Cancel, "cell 1 11");

        //---- Reset ----
        Reset.setText("\u91cd\u7f6e");
        Reset.addActionListener(e -> Reset(e));
        contentPane.add(Reset, "cell 10 11");

        //---- ok ----
        ok.setText("\u786e\u5b9a");
        ok.addActionListener(e -> ok(e));
        contentPane.add(ok, "cell 12 11");
        setSize(525, 375);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        CompNum.setEditable(false);
        TeamCode.setEditable(false);
        matchsgroup.setEnabled(false);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField CompNum;
    private JButton ChoiceComp;
    private JCheckBox matchsgroup;
    private JLabel label2;
    private JTextField TeamCode;
    private JButton ChoiceTeam;
    private JLabel label3;
    private JTextField JAwardInfo;
    private JButton Cancel;
    private JButton Reset;
    private JButton ok;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private int teamsize = 0;

}
