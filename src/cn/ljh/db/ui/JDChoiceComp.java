/*
 * Created by JFormDesigner on Tue Jul 09 09:09:27 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.OutputKeys;

import cn.ljh.db.control.CompetitionManager;
import cn.ljh.db.model.BeanCompetition;
import cn.ljh.db.util.BaseException;
import net.miginfocom.swing.*;

/**
 * @author LJH
 */
public class JDChoiceComp extends JDialog {
    public JDChoiceComp(Window owner) {
        super(owner);
        this.setModal(true);
        initComponents();
    }

    private void Yes(ActionEvent e) {
        // TODO add your code here
        int[] rows = table1.getSelectedRows();
        if (rows.length <=0 ) {
            JOptionPane.showMessageDialog(this, "请选择赛事！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        for (int i : rows) {
            selectedComp = CompetitionList.get(i);
            SelectedCompList.add(selectedComp);
        }
        if (SelectedCompList.size() ==1){
            JOptionPane.showMessageDialog(this, "你选择的赛事编号为："+selectedComp.getCompNum(), "提示", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "你选择的赛事编号为："+selectedComp.getCompNum(), "提示", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(this,"你选择了多个赛事，请确认！","提示",JOptionPane.WARNING_MESSAGE);
        }
        isok = true;
        this.dispose();
    }

    private void Cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void Search(ActionEvent e) {
        // TODO add your code here
        reloatCompTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        label3 = new JLabel();
        label1 = new JLabel();
        CompNum = new JTextField();
        label2 = new JLabel();
        CompName = new JTextField();
        Search = new JButton();
        panel1 = new JPanel();
        Cancel = new JButton();
        Yes = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setTitle("\u9009\u62e9\u6240\u5c5e\u8d5b\u4e8b");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //---- label3 ----
            label3.setText("\u7b5b\u9009\u8d5b\u4e8b    ");
            menuBar1.add(label3);

            //---- label1 ----
            label1.setText("\u8d5b\u4e8b\u5e8f\u53f7\uff1a");
            menuBar1.add(label1);
            menuBar1.add(CompNum);

            //---- label2 ----
            label2.setText("\u8d5b\u4e8b\u540d\uff1a");
            menuBar1.add(label2);
            menuBar1.add(CompName);

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
                        .addGap(15, 15, 15)
                        .addComponent(Cancel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                        .addComponent(Yes)
                        .addGap(23, 23, 23))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Cancel)
                        .addComponent(Yes))
            );
        }
        contentPane.add(panel1, BorderLayout.SOUTH);
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        setSize(495, 415);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        CompNum.setText("");
        CompName.setText("");
        {
            scrollPane1.setViewportView(table1);
        }
        this.reloatCompTable();

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JLabel label3;
    private JLabel label1;
    private JTextField CompNum;
    private JLabel label2;
    private JTextField CompName;
    private JButton Search;
    private JPanel panel1;
    private JButton Cancel;
    private JButton Yes;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private BeanCompetition selectedComp;
    private List<BeanCompetition> SelectedCompList=new ArrayList<BeanCompetition>();
    public boolean isok = false;
    java.util.List<BeanCompetition> CompetitionList;
    private final Object[] tblTitle = {"赛事序号","赛事名称","竞赛编号","举办时间","举办地点"};
    private  Object[][] tblData;
    DefaultTableModel tablmod = new DefaultTableModel();
    private final JTable table1 = new JTable(tablmod){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void reloatCompTable(){
        try {
            List<BeanCompetition> CompetitionList = (new CompetitionManager().searchCompetition(CompNum.getText(), CompName.getText()));
            this.CompetitionList = CompetitionList;
            tblData = new Object[CompetitionList.size()][5];
            for (int i = 0; i < CompetitionList.size(); i++) {
                tblData[i][0] = CompetitionList.get(i).getCompNum();
                tblData[i][1] = CompetitionList.get(i).getCompName();
                tblData[i][2] = CompetitionList.get(i).getMatchsCode();
                tblData[i][3] = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(CompetitionList.get(i).getOrganizeTime());
                tblData[i][4] = CompetitionList.get(i).getOrganizeArea();
            }
            tablmod.setDataVector(tblData, tblTitle);
            this.table1.validate();
            this.table1.repaint();
        } catch (BaseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public BeanCompetition getValue(){
        return selectedComp;
    }

}
