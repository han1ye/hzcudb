/*
 * Created by JFormDesigner on Mon Jul 08 15:11:24 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import cn.ljh.db.control.MatchsManager;
import cn.ljh.db.model.BeanMatchs;
import cn.ljh.db.util.BaseException;
import net.miginfocom.swing.*;

/**
 * @author LJH
 */
public class JDChoiceMatch extends JDialog {
    public JDChoiceMatch(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }

    private void Cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void Yes(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择一行！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        selectMatchs = matchsList.get(row);
        JOptionPane.showMessageDialog(this, "您选择的竞赛编号为：" + selectMatchs.getMatchsCode(), "提示", JOptionPane.INFORMATION_MESSAGE);
        ok = true;
        this.dispose();
    }

    private void Search(ActionEvent e) {
        // TODO add your code here
        this.reloatMatchsTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        label1 = new JLabel();
        label2 = new JLabel();
        MatchsCode = new JTextField();
        label3 = new JLabel();
        MatchsName = new JTextField();
        Search = new JButton();
        panel1 = new JPanel();
        Cancel = new JButton();
        Yes = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setTitle("\u9009\u62e9\u6240\u5c5e\u7ade\u8d5b");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //---- label1 ----
            label1.setText("\u7b5b\u9009\u7ade\u8d5b    ");
            menuBar1.add(label1);

            //---- label2 ----
            label2.setText("\u7ade\u8d5b\u7f16\u53f7\uff1a");
            menuBar1.add(label2);
            menuBar1.add(MatchsCode);

            //---- label3 ----
            label3.setText("\u7ade\u8d5b\u540d\u79f0\uff1a");
            menuBar1.add(label3);
            menuBar1.add(MatchsName);

            //---- Search ----
            Search.setText("\u641c\u7d22");
            Search.addActionListener(e -> Search(e));
            menuBar1.add(Search);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {

            //---- Cancel ----
            Cancel.setText("\u53d6\u6d88");
            Cancel.addActionListener(e -> Cancel(e));

            //---- Yes ----
            Yes.setText("\u786e\u5b9a");
            Yes.addActionListener(e -> Yes(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(Cancel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 421, Short.MAX_VALUE)
                        .addComponent(Yes)
                        .addGap(21, 21, 21))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Cancel)
                            .addComponent(Yes)))
            );
        }
        contentPane.add(panel1, BorderLayout.SOUTH);
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        setSize(565, 430);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        MatchsCode.setText("");
        MatchsName.setText("");
        {
            scrollPane1.setViewportView(table1);
        }
        this.reloatMatchsTable();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JLabel label1;
    private JLabel label2;
    private JTextField MatchsCode;
    private JLabel label3;
    private JTextField MatchsName;
    private JButton Search;
    private JPanel panel1;
    private JButton Cancel;
    private JButton Yes;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    Boolean ok = false;
    BeanMatchs selectMatchs;
    List<BeanMatchs> matchsList;
    private final Object[] tblTitle = {"竞赛编号","竞赛名称","主办单位","承办单位","是否为组队赛","竞赛介绍"};
    private  Object[][] tblData;
    DefaultTableModel tablmod = new DefaultTableModel();
    private final JTable table1 = new JTable(tablmod){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private void reloatMatchsTable(){
        try {
            List<BeanMatchs> matchsList = (new MatchsManager().searchMatchs(MatchsCode.getText(), MatchsName.getText()));
            this.matchsList = matchsList;
            tblData = new Object[matchsList.size()][6];
            for (int i = 0; i < matchsList.size(); i++) {
                tblData[i][0] = matchsList.get(i).getMatchsCode();
                tblData[i][1] = matchsList.get(i).getMatchsName();
                tblData[i][2] = matchsList.get(i).getOrganizer();
                tblData[i][3] = matchsList.get(i).getContractor();
                tblData[i][4] = matchsList.get(i).isMatchsGroup()? "是" : "否";
                tblData[i][5] = matchsList.get(i).getMatchsInfo();
            }
            tablmod.setDataVector(tblData, tblTitle);
            this.table1.validate();
            this.table1.repaint();
        } catch (BaseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public BeanMatchs getValue(){
        return selectMatchs;
    }

}
