/*
 * Created by JFormDesigner on Sat Jul 06 08:54:23 CST 2024
 */

package cn.ljh.db.ui;

import javax.swing.*;

/**
 * @author LJH
 */
public class JDAbout extends JDialog {
    public JDAbout() {
        this.setModal(true);
        initComponents();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();

        //======== this ========
        setTitle("\u5173\u4e8e\u6211\u4eec");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5f00\u53d1\u4eba\u5458\uff1a\u674e\u5609\u8c6a");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(132, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                    .addGap(118, 118, 118))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(118, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
