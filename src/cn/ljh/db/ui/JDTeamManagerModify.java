/*
 * Created by JFormDesigner on Mon Jul 08 09:23:17 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import cn.ljh.db.control.TeamManager;
import cn.ljh.db.model.BeanTeacher;
import cn.ljh.db.model.BeanTeam;
import cn.ljh.db.util.BaseException;
import net.miginfocom.swing.*;

/**
 * @author LJH
 */
public class JDTeamManagerModify extends JDialog {
    public JDTeamManagerModify(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }

    private void Resate(ActionEvent e) {
        // TODO add your code here
        teamName.setText(ModifyTeam.getTeamName());
        teamNameEn.setText(ModifyTeam.getTeamNameEn());
        teamSize.setText(String.valueOf(ModifyTeam.getTeamSize()));
        Note.setText(ModifyTeam.getNote());
    }

    private void Cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void Yes(ActionEvent e) {
        // TODO add your code here
        BeanTeam Team = new BeanTeam();
        Team.setTeamCode(teamCode.getText());
        Team.setTeamName(teamName.getText());
        Team.setTeamNameEn(teamNameEn.getText());
        if (teamSize.getText().equals("")){
            Team.setTeamSize(0);
        }else{
            Team.setTeamSize(Integer.parseInt(teamSize.getText()));
        }
        Team.setNote(Note.getText());
        TeamManager tm = new TeamManager();
        try{
            tm.modifyTeam(Team);
            JOptionPane.showMessageDialog(this, "修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }catch (BaseException e1){
            JOptionPane.showMessageDialog(this, "修改失败！"+e1.getMessage(), "提示", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        teamCode = new JTextField();
        label2 = new JLabel();
        teamName = new JTextField();
        label3 = new JLabel();
        teamNameEn = new JTextField();
        label4 = new JLabel();
        teamSize = new JTextField();
        label5 = new JLabel();
        scrollPane1 = new JScrollPane();
        Note = new JTextArea();
        Cancel = new JButton();
        Resate = new JButton();
        Yes = new JButton();

        //======== this ========
        setTitle("\u961f\u4f0d\u4fe1\u606f\u4fee\u6539");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u961f\u4f0d\u7f16\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));

        //---- label2 ----
        label2.setText("\u961f\u4f0d\u540d\u79f0\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));

        //---- label3 ----
        label3.setText("\u82f1\u6587\u961f\u540d\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));

        //---- label4 ----
        label4.setText("\u961f\u4f0d\u5bb9\u91cf\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));

        //---- label5 ----
        label5.setText("\u5907\u6ce8\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));
        label5.setHorizontalAlignment(SwingConstants.RIGHT);

        //======== scrollPane1 ========
        {

            //---- Note ----
            Note.setLineWrap(true);
            Note.setWrapStyleWord(true);
            scrollPane1.setViewportView(Note);
        }

        //---- Cancel ----
        Cancel.setText("\u53d6\u6d88");
        Cancel.addActionListener(e -> Cancel(e));

        //---- Resate ----
        Resate.setText("\u91cd\u7f6e");
        Resate.addActionListener(e -> Resate(e));

        //---- Yes ----
        Yes.setText("\u786e\u5b9a");
        Yes.addActionListener(e -> Yes(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(Cancel)
                            .addGap(246, 246, 246)
                            .addComponent(Resate)
                            .addGap(49, 49, 49)
                            .addComponent(Yes))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(119, 119, 119)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(7, 7, 7)
                                    .addComponent(teamCode, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(7, 7, 7)
                                    .addComponent(teamName, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addGap(7, 7, 7)
                                    .addComponent(teamNameEn, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addGap(7, 7, 7)
                                    .addComponent(teamSize, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(35, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(36, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(teamCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(teamName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(teamNameEn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(teamSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label5)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Cancel)
                        .addComponent(Resate)
                        .addComponent(Yes))
                    .addGap(12, 12, 12))
        );
        setSize(530, 440);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        teamCode.setText(ModifyTeam.getTeamCode());
        teamCode.setEditable(false);
        teamName.setText(ModifyTeam.getTeamName());
        teamNameEn.setText(ModifyTeam.getTeamNameEn());
        teamSize.setText(String.valueOf(ModifyTeam.getTeamSize()));
        Note.setText(ModifyTeam.getNote());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField teamCode;
    private JLabel label2;
    private JTextField teamName;
    private JLabel label3;
    private JTextField teamNameEn;
    private JLabel label4;
    private JTextField teamSize;
    private JLabel label5;
    private JScrollPane scrollPane1;
    private JTextArea Note;
    private JButton Cancel;
    private JButton Resate;
    private JButton Yes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private BeanTeam ModifyTeam;

    public JDTeamManagerModify(Window owner, BeanTeam ModifyTeam) {
        super(owner);
        this.setModal(true);
        this.ModifyTeam = ModifyTeam;
        initComponents();

    }
}
