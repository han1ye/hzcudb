/*
 * Created by JFormDesigner on Sun Jul 07 14:14:47 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

import cn.ljh.db.control.TeamManager;
import cn.ljh.db.model.BeanTeam;
import cn.ljh.db.util.BaseException;
import net.miginfocom.swing.*;

import static java.lang.Integer.parseInt;

/**
 * @author LJH
 */
public class JDTeamManagerCreate extends JDialog {
    public JDTeamManagerCreate(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }

    private void Reset(ActionEvent e) {
        // TODO add your code here
        teamCode.setText("");
        teamName.setText("");
        teamNameEn.setText("");
        creatTime.setText("");
        teamSize.setText("");
        note.setText("");
    }

    private void Exit(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void Yes(ActionEvent e) {
        // TODO add your code here
        TeamManager tmag = new TeamManager();
        BeanTeam bt = new BeanTeam();
        bt.setTeamCode(teamCode.getText());
        bt.setTeamName(teamName.getText());
        bt.setTeamNameEn(teamNameEn.getText());
        bt.setCreatTime(new Date());
        if (teamSize.getText().equals("")){
            bt.setTeamSize(0);
        }else {
            bt.setTeamSize(parseInt(teamSize.getText()));
        }
        bt.setNote(note.getText());
        try{
            tmag.createTeam(bt);
            JOptionPane.showMessageDialog(this, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            this.Exit(e);
        }catch (BaseException e1){
            JOptionPane.showMessageDialog(this, "添加失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);

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
        creatTime = new JTextField();
        label5 = new JLabel();
        teamSize = new JTextField();
        label6 = new JLabel();
        scrollPane1 = new JScrollPane();
        note = new JTextArea();
        Exit = new JButton();
        Reset = new JButton();
        Yes = new JButton();

        //======== this ========
        setTitle("\u6dfb\u52a0\u961f\u4f0d");
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
        label4.setText("\u521b\u5efa\u65f6\u95f4\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));

        //---- label5 ----
        label5.setText("\u961f\u4f0d\u5bb9\u91cf\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));

        //---- label6 ----
        label6.setText("\u5907\u6ce8\uff1a");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 5f));
        label6.setHorizontalAlignment(SwingConstants.RIGHT);

        //======== scrollPane1 ========
        {

            //---- note ----
            note.setWrapStyleWord(true);
            note.setLineWrap(true);
            scrollPane1.setViewportView(note);
        }

        //---- Exit ----
        Exit.setText("\u9000\u51fa");
        Exit.addActionListener(e -> Exit(e));

        //---- Reset ----
        Reset.setText("\u91cd\u7f6e");
        Reset.addActionListener(e -> Reset(e));

        //---- Yes ----
        Yes.setText("\u786e\u8ba4");
        Yes.addActionListener(e -> Yes(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label1)
                                .addGap(5, 5, 5)
                                .addComponent(teamCode, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label2)
                                .addGap(5, 5, 5)
                                .addComponent(teamName, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label3)
                                .addGap(5, 5, 5)
                                .addComponent(teamNameEn, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label4)
                                .addGap(5, 5, 5)
                                .addComponent(creatTime, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label5)
                                .addGap(5, 5, 5)
                                .addComponent(teamSize, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(scrollPane1)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(Exit)
                            .addGap(259, 259, 259)
                            .addComponent(Reset)))
                    .addGap(18, 18, 18)
                    .addComponent(Yes)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(teamCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(teamName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(teamNameEn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(creatTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(teamSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Exit)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Reset)
                            .addComponent(Yes)))
                    .addGap(16, 16, 16))
        );
        setSize(505, 440);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        time = new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                creatTime.setText(new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss").format(new Date()));
            }
        });
        time.start();
        creatTime.setEditable(false);
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField teamCode;
    private JLabel label2;
    private JTextField teamName;
    private JLabel label3;
    private JTextField teamNameEn;
    private JLabel label4;
    private JTextField creatTime;
    private JLabel label5;
    private JTextField teamSize;
    private JLabel label6;
    private JScrollPane scrollPane1;
    private JTextArea note;
    private JButton Exit;
    private JButton Reset;
    private JButton Yes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private Timer time;
    //时间显示



}
