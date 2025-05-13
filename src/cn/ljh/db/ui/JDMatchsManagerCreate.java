/*
 * Created by JFormDesigner on Mon Jul 08 10:48:24 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import cn.ljh.db.control.MatchsManager;
import cn.ljh.db.model.BeanMatchs;
import cn.ljh.db.util.BaseException;
import net.miginfocom.swing.*;

/**
 * @author LJH
 */
public class JDMatchsManagerCreate extends JDialog {
    public JDMatchsManagerCreate(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }

    private void Reset(ActionEvent e) {
        // TODO add your code here
        MatchsCode.setText("");
        MatchsName.setText("");
        Organizer.setText("");
        Contractor.setText("");
        MatchsInfo.setText("");
        MatchsGroup.setSelected(false);
    }

    private void Cancel(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void Yes(ActionEvent e) {
        // TODO add your code here
        BeanMatchs matchs = new BeanMatchs();
        MatchsManager mm = new MatchsManager();
        matchs.setMatchsCode(MatchsCode.getText());
        matchs.setMatchsName(MatchsName.getText());
        matchs.setContractor(Contractor.getText());
        matchs.setOrganizer(Organizer.getText());
        matchs.setMatchsInfo(MatchsInfo.getText());
        matchs.setMatchsGroup(MatchsGroup.isSelected());
        try{
            mm.createMatchs(matchs);
            JOptionPane.showMessageDialog(this, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }catch (BaseException e1){
            JOptionPane.showMessageDialog(this, "添加失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        MatchsCode = new JTextField();
        label2 = new JLabel();
        MatchsName = new JTextField();
        label3 = new JLabel();
        Organizer = new JTextField();
        label4 = new JLabel();
        Contractor = new JTextField();
        label5 = new JLabel();
        MatchsGroup = new JCheckBox();
        label6 = new JLabel();
        scrollPane1 = new JScrollPane();
        MatchsInfo = new JTextArea();
        Cancel = new JButton();
        Reset = new JButton();
        Yes = new JButton();

        //======== this ========
        setTitle("\u6dfb\u52a0\u7ade\u8d5b");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u7ade\u8d5b\u7f16\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));

        //---- label2 ----
        label2.setText("\u7ade\u8d5b\u540d\u79f0\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));

        //---- label3 ----
        label3.setText("\u4e3b\u529e\u5355\u4f4d\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));

        //---- label4 ----
        label4.setText("\u627f\u529e\u5355\u4f4d\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));

        //---- label5 ----
        label5.setText("\u662f\u5426\u4e3a\u7ec4\u961f\u8d5b\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));

        //---- label6 ----
        label6.setText("\u7ade\u8d5b\u4ecb\u7ecd\uff1a");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 5f));

        //======== scrollPane1 ========
        {

            //---- MatchsInfo ----
            MatchsInfo.setLineWrap(true);
            MatchsInfo.setWrapStyleWord(true);
            scrollPane1.setViewportView(MatchsInfo);
        }

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
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(32, Short.MAX_VALUE)
                    .addComponent(Cancel)
                    .addGap(361, 361, 361)
                    .addComponent(Reset)
                    .addGap(24, 24, 24)
                    .addComponent(Yes)
                    .addGap(15, 15, 15))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(7, 7, 7)
                            .addComponent(MatchsGroup))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addComponent(MatchsCode, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addComponent(MatchsName, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addComponent(Organizer, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addComponent(Contractor, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(163, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(MatchsCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(MatchsName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(Organizer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(Contractor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(label5))
                        .addComponent(MatchsGroup))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(label6))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Cancel)
                        .addComponent(Reset)
                        .addComponent(Yes))
                    .addGap(34, 34, 34))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField MatchsCode;
    private JLabel label2;
    private JTextField MatchsName;
    private JLabel label3;
    private JTextField Organizer;
    private JLabel label4;
    private JTextField Contractor;
    private JLabel label5;
    private JCheckBox MatchsGroup;
    private JLabel label6;
    private JScrollPane scrollPane1;
    private JTextArea MatchsInfo;
    private JButton Cancel;
    private JButton Reset;
    private JButton Yes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
