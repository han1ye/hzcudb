/*
 * Created by JFormDesigner on Mon Jul 08 15:41:02 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import cn.ljh.db.control.CompetitionManager;
import cn.ljh.db.model.BeanCompetition;
import cn.ljh.db.util.BaseException;
import net.miginfocom.swing.*;

/**
 * @author LJH
 */
public class JDCompModify extends JDialog {
    public JDCompModify(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }
    public JDCompModify(Window owner, BeanCompetition ModifyComp) {
        super(owner);
        this.setModal(true);
        this.ModifyComp = ModifyComp;
        initComponents();
    }

    private void ChoiceMatch(ActionEvent e) {
        // TODO add your code here
        JDChoiceMatch cm = new JDChoiceMatch(this);
        cm.setVisible(true);
        if(cm.ok){
            MatchsCode.setText(cm.getValue().getMatchsCode());
        }
    }

    private void Yes(ActionEvent e) {
        // TODO add your code here
        BeanCompetition bc = new BeanCompetition();
        CompetitionManager cm = new CompetitionManager();
        bc.setCompName(compName.getText());
        bc.setCompNum(compNum.getText());
        bc.setMatchsCode(MatchsCode.getText());
        bc.setOrganizeArea(OrganizeArea.getText());
        bc.setOrganizeTime(OrganizeTime.getDate());
        try{
            cm.modifyCompetition(bc);
            JOptionPane.showMessageDialog(this, "修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }catch (BaseException e1){
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this, "修改失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void Reset(ActionEvent e) {
        // TODO add your code here
        compName.setText(ModifyComp.getCompName());
        MatchsCode.setText(ModifyComp.getMatchsCode());
        OrganizeArea.setText(ModifyComp.getOrganizeArea());
        OrganizeTime.setDate(ModifyComp.getOrganizeTime());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        compNum = new JTextField();
        label2 = new JLabel();
        compName = new JTextField();
        label3 = new JLabel();
        MatchsCode = new JTextField();
        ChoiceMatch = new JButton();
        label4 = new JLabel();
        OrganizeTime = new DateChooserJButton();
        label5 = new JLabel();
        OrganizeArea = new JTextField();
        Cancel = new JButton();
        Reset = new JButton();
        Yes = new JButton();

        //======== this ========
        setTitle("\u8d5b\u4e8b\u4fee\u6539");
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
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("\u8d5b\u4e8b\u5e8f\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
        contentPane.add(label1, "cell 2 1");
        contentPane.add(compNum, "cell 3 1 8 1");

        //---- label2 ----
        label2.setText("\u8d5b\u4e8b\u540d\u79f0\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));
        contentPane.add(label2, "cell 2 3");
        contentPane.add(compName, "cell 3 3 8 1");

        //---- label3 ----
        label3.setText("\u7ade\u8d5b\u7f16\u53f7\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
        contentPane.add(label3, "cell 2 5");
        contentPane.add(MatchsCode, "cell 3 5 8 1");

        //---- ChoiceMatch ----
        ChoiceMatch.setText("\u9009\u62e9\u7ade\u8d5b");
        ChoiceMatch.addActionListener(e -> ChoiceMatch(e));
        contentPane.add(ChoiceMatch, "cell 3 6 4 1");

        //---- label4 ----
        label4.setText("\u4e3e\u529e\u65f6\u95f4\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));
        contentPane.add(label4, "cell 2 7");

        //---- OrganizeTime ----
        OrganizeTime.setText("text");
        contentPane.add(OrganizeTime, "cell 3 7 8 1");

        //---- label5 ----
        label5.setText("\u4e3e\u529e\u5730\u70b9\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));
        contentPane.add(label5, "cell 2 9");
        contentPane.add(OrganizeArea, "cell 3 9 8 1");

        //---- Cancel ----
        Cancel.setText("\u53d6\u6d88");
        Cancel.addActionListener(e -> Cancel(e));
        contentPane.add(Cancel, "cell 1 11");

        //---- Reset ----
        Reset.setText("\u91cd\u7f6e");
        Reset.addActionListener(e -> Reset(e));
        contentPane.add(Reset, "cell 10 11");

        //---- Yes ----
        Yes.setText("\u786e\u5b9a");
        Yes.addActionListener(e -> Yes(e));
        contentPane.add(Yes, "cell 12 11");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        compNum.setEditable(false);
        compNum.setText(ModifyComp.getCompNum());
        compName.setText(ModifyComp.getCompName());
        MatchsCode.setEditable(false);
        MatchsCode.setText(ModifyComp.getMatchsCode());
        OrganizeArea.setText(ModifyComp.getOrganizeArea());
        OrganizeTime.setDate(ModifyComp.getOrganizeTime());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField compNum;
    private JLabel label2;
    private JTextField compName;
    private JLabel label3;
    private JTextField MatchsCode;
    private JButton ChoiceMatch;
    private JLabel label4;
    private DateChooserJButton OrganizeTime;
    private JLabel label5;
    private JTextField OrganizeArea;
    private JButton Cancel;
    private JButton Reset;
    private JButton Yes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private BeanCompetition ModifyComp;
}
