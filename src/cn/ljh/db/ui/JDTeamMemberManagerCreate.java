/*
 * Created by JFormDesigner on Tue Jul 09 13:53:56 CST 2024
 */

package cn.ljh.db.ui;

import cn.ljh.db.control.TeamMemberManager;
import cn.ljh.db.model.TeamMember;
import cn.ljh.db.util.BaseException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author LJH
 */
public class JDTeamMemberManagerCreate extends JDialog {
    public JDTeamMemberManagerCreate(Window owner) {
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
            TeamName.setText(ct.getValue().getTeamName());
        }
    }

    private void ChoiceStu(ActionEvent e) {
        // TODO add your code here
        JDChoiceStu cs = new JDChoiceStu(this);
        cs.setVisible(true);
        if(cs.isOK){
            StuNum.setText(cs.getValue().getStuNum());
            StuName.setText(cs.getValue().getStuName());
        }
    }

    private void Cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void Reset(ActionEvent e) {
        // TODO add your code here
        TeamCode.setText("");
        TeamName.setText("");
        StuNum.setText("");
        StuName.setText("");
        Leader.setSelected(false);
    }

    private void Yes(ActionEvent e) {
        // TODO add your code here
        TeamMemberManager tmm = new TeamMemberManager();
        TeamMember tm = new TeamMember();
        tm.setTeamCode(TeamCode.getText());
        tm.setStuNum(StuNum.getText());
        tm.setLeader(Leader.isSelected());
        try{
            tmm.createTeamMember(tm);
            JOptionPane.showMessageDialog(this, "创建成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }catch (BaseException e1){
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this, "创建失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
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
        Cancel = new JButton();
        Reset = new JButton();
        Yes = new JButton();

        //======== this ========
        setTitle("\u961f\u4f0d\u6210\u5458\u6dfb\u52a0");
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label1 ----
        label1.setText("\u6240\u5c5e\u961f\u4f0d\u7f16\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
        contentPane.add(label1, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(TeamCode, new GridBagConstraints(4, 2, 6, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label2 ----
        label2.setText("\u6240\u5c5e\u961f\u4f0d\u540d\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));
        contentPane.add(label2, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(TeamName, new GridBagConstraints(4, 3, 6, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- ChoiceTeam ----
        ChoiceTeam.setText("\u9009\u62e9\u961f\u4f0d");
        ChoiceTeam.addActionListener(e -> ChoiceTeam(e));
        contentPane.add(ChoiceTeam, new GridBagConstraints(4, 4, 3, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label3 ----
        label3.setText("\u5b66\u751f\u5b66\u53f7\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
        contentPane.add(label3, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(StuNum, new GridBagConstraints(4, 6, 6, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label4 ----
        label4.setText("\u5b66\u751f\u59d3\u540d\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));
        contentPane.add(label4, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(StuName, new GridBagConstraints(4, 7, 6, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- ChoiceStu ----
        ChoiceStu.setText("\u9009\u62e9\u5b66\u751f");
        ChoiceStu.addActionListener(e -> ChoiceStu(e));
        contentPane.add(ChoiceStu, new GridBagConstraints(4, 8, 3, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label5 ----
        label5.setText("\u662f\u5426\u4e3a\u961f\u957f\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));
        contentPane.add(label5, new GridBagConstraints(3, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(Leader, new GridBagConstraints(4, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- Cancel ----
        Cancel.setText("\u53d6\u6d88");
        Cancel.addActionListener(e -> Cancel(e));
        contentPane.add(Cancel, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- Reset ----
        Reset.setText("\u91cd\u7f6e");
        Reset.addActionListener(e -> Reset(e));
        contentPane.add(Reset, new GridBagConstraints(9, 12, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- Yes ----
        Yes.setText("\u786e\u5b9a");
        Yes.addActionListener(e -> Yes(e));
        contentPane.add(Yes, new GridBagConstraints(11, 12, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        TeamCode.setEditable(false);
        TeamName.setEditable(false);
        StuNum.setEditable(false);
        StuName.setEditable(false);
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
    private JButton Cancel;
    private JButton Reset;
    private JButton Yes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
