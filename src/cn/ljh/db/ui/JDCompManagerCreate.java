/*
 * Created by JFormDesigner on Mon Jul 08 13:41:42 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

import cn.ljh.db.control.CompetitionManager;
import cn.ljh.db.model.BeanCompetition;
import cn.ljh.db.util.BaseException;
import net.miginfocom.swing.*;

/**
 * @author LJH
 */
public class JDCompManagerCreate extends JDialog {
    public JDCompManagerCreate(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }

    private void Cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void Reset(ActionEvent e) {
        // TODO add your code here
        CompNum.setText("");
        CompName.setText("");
        MatchsCode.setText("");
        ChoicesTime.setDate(new Date());
        OrganizeArea.setText("");
    }

    private void Yes(ActionEvent e) {
        // TODO add your code here
        BeanCompetition comp = new BeanCompetition();
        CompetitionManager compM = new CompetitionManager();
        comp.setCompNum(CompNum.getText());
        comp.setCompName(CompName.getText());
        comp.setMatchsCode(MatchsCode.getText());
        comp.setOrganizeTime(ChoicesTime.getDate());
        comp.setOrganizeArea(OrganizeArea.getText());
        try{
            compM.createCompetition(comp);
            JOptionPane.showMessageDialog(this, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }catch (BaseException e1){
            JOptionPane.showMessageDialog(this, "添加失败！："+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ChoicesTime(ActionEvent e) {
        // TODO add your code here

    }

    private void ChoiceMatch(ActionEvent e) {
        // TODO add your code here
        JDChoiceMatch cm = new JDChoiceMatch(this);
        cm.setVisible(true);
        if (cm.ok){
            MatchsCode.setText(cm.getValue().getMatchsCode());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        CompNum = new JTextField();
        label2 = new JLabel();
        CompName = new JTextField();
        label3 = new JLabel();
        MatchsCode = new JTextField();
        ChoiceMatch = new JButton();
        label4 = new JLabel();
        ChoicesTime = new DateChooserJButton();
        label5 = new JLabel();
        OrganizeArea = new JTextField();
        Cancel = new JButton();
        Reset = new JButton();
        Yes = new JButton();

        //======== this ========
        setTitle("\u6dfb\u52a0\u8d5b\u4e8b");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8d5b\u4e8b\u5e8f\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));

        //---- label2 ----
        label2.setText("\u8d5b\u4e8b\u540d\u79f0\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));

        //---- label3 ----
        label3.setText("\u7ade\u8d5b\u7f16\u53f7\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));

        //---- ChoiceMatch ----
        ChoiceMatch.setText("\u9009\u62e9\u7ade\u8d5b");
        ChoiceMatch.addActionListener(e -> ChoiceMatch(e));

        //---- label4 ----
        label4.setText("\u4e3e\u529e\u65f6\u95f4\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));

        //---- ChoicesTime ----
        ChoicesTime.addActionListener(e -> ChoicesTime(e));

        //---- label5 ----
        label5.setText("\u4e3e\u529e\u5730\u70b9\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));

        //---- Cancel ----
        Cancel.setText("\u53d6\u6d88");
        Cancel.addActionListener(e -> Cancel(e));

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
                    .addGap(0, 31, Short.MAX_VALUE)
                    .addComponent(Cancel)
                    .addGap(270, 270, 270)
                    .addComponent(Reset)
                    .addGap(24, 24, 24)
                    .addComponent(Yes)
                    .addGap(17, 17, 17))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(114, 114, 114)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(7, 7, 7)
                            .addComponent(CompNum, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(7, 7, 7)
                            .addComponent(CompName, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addGap(7, 7, 7)
                            .addComponent(MatchsCode, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(ChoiceMatch))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4)
                            .addGap(7, 7, 7)
                            .addComponent(ChoicesTime, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(7, 7, 7)
                            .addComponent(OrganizeArea, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(143, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(CompNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(CompName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(MatchsCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(7, 7, 7)
                    .addComponent(ChoiceMatch)
                    .addGap(7, 7, 7)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(ChoicesTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label5)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(OrganizeArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Cancel)
                        .addComponent(Reset)
                        .addComponent(Yes))
                    .addGap(22, 22, 22))
        );
        setSize(515, 400);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        MatchsCode.setEditable(false);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField CompNum;
    private JLabel label2;
    private JTextField CompName;
    private JLabel label3;
    private JTextField MatchsCode;
    private JButton ChoiceMatch;
    private JLabel label4;
    private DateChooserJButton ChoicesTime;
    private JLabel label5;
    private JTextField OrganizeArea;
    private JButton Cancel;
    private JButton Reset;
    private JButton Yes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
