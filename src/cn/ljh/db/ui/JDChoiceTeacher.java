/*
 * Created by JFormDesigner on Tue Jul 09 11:21:18 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.event.*;
import cn.ljh.db.control.TeacherManager;
import cn.ljh.db.model.BeanTeacher;
import cn.ljh.db.util.BaseException;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author LJH
 */
public class JDChoiceTeacher extends JDialog {
    public JDChoiceTeacher(Window owner) {
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
            JOptionPane.showMessageDialog(this, "请选择一个教师！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        selectedTeacher = teachers.get(row);
        JOptionPane.showMessageDialog(this, "选择的教师工号为："+selectedTeacher.getTeaNum(), "提示", JOptionPane.INFORMATION_MESSAGE);
        this.isOK = true;
        this.dispose();
    }

    private void Search(ActionEvent e) {
        // TODO add your code here
        this.reloadUserTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        label1 = new JLabel();
        label2 = new JLabel();
        TeaNum = new JTextField();
        label3 = new JLabel();
        TeaName = new JTextField();
        Search = new JButton();
        panel1 = new JPanel();
        Cancel = new JButton();
        Yes = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setTitle("\u9009\u62e9\u6559\u5e08");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //---- label1 ----
            label1.setText("\u7b5b\u9009\u6559\u5e08    ");
            menuBar1.add(label1);

            //---- label2 ----
            label2.setText("\u804c\u5de5\u53f7\uff1a");
            menuBar1.add(label2);
            menuBar1.add(TeaNum);

            //---- label3 ----
            label3.setText("\u6559\u5e08\u59d3\u540d\uff1a");
            menuBar1.add(label3);
            menuBar1.add(TeaName);

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
                        .addGap(25, 25, 25)
                        .addComponent(Cancel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 428, Short.MAX_VALUE)
                        .addComponent(Yes)
                        .addGap(31, 31, 31))
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
        setSize(600, 410);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        TeaNum.setText("");
        TeaName.setText("");
        {
            scrollPane1.setViewportView(table1);
        }
        this.reloadUserTable();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JLabel label1;
    private JLabel label2;
    private JTextField TeaNum;
    private JLabel label3;
    private JTextField TeaName;
    private JButton Search;
    private JPanel panel1;
    private JButton Cancel;
    private JButton Yes;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public boolean isOK = false;
    private BeanTeacher selectedTeacher = new BeanTeacher();;
    private final Object[] tblTitle = {"工号","姓名","所属学院","手机号码","电子邮箱"};
    private  Object[][] tblData;
    private List<BeanTeacher> teachers;
    DefaultTableModel tablmod = new DefaultTableModel();
    private final JTable table1 = new JTable(tablmod){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void reloadUserTable() {
        try {
            List<BeanTeacher> teachers = (new TeacherManager().searchteacher(TeaNum.getText(), TeaName.getText()));
            this.teachers = teachers;
            tblData = new Object[teachers.size()][5];
            for (int i = 0; i < teachers.size(); i++) {
                tblData[i][0] = teachers.get(i).getTeaNum();
                tblData[i][1] = teachers.get(i).getTeaName();
                tblData[i][2] = teachers.get(i).getBelongCollege();
                tblData[i][3] = teachers.get(i).getTeaTel();
                tblData[i][4] = teachers.get(i).getTeaemail();
            }
            tablmod.setDataVector(tblData, tblTitle);
            this.table1.validate();
            this.table1.repaint();
        } catch (BaseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public BeanTeacher getValue(){
        return selectedTeacher;
    }

}
