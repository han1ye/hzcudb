/*
 * Created by JFormDesigner on Sun Jul 07 08:57:28 CST 2024
 */

package cn.ljh.db.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import cn.ljh.db.control.TeacherManager;
import cn.ljh.db.model.BeanTeacher;
import cn.ljh.db.util.BaseException;

import java.util.List;

/**
 * @author LJH
 */
public class JDTeacherManager extends JDialog {
    public JDTeacherManager() {
        this.setModal(true);
        initComponents();
    }

    private void create(ActionEvent e) {
        // TODO add your code here
        JDTeacherManagerCreate jftmc = new JDTeacherManagerCreate();
        jftmc.setVisible(true);
        this.reloadUserTable();
    }

    private void refresh(ActionEvent e) {
        // TODO add your code here
        TeaNum.setText("");
        TeaName.setText("");
        this.reloadUserTable();
    }

    private void Modify(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "请选择要修改的行！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
            String teaNum = (String) tblData[row][0];
            JDTeacherManagerModify jftmm = new JDTeacherManagerModify(teaNum);
            jftmm.setVisible(true);
            this.reloadUserTable();

        }

    }

    private void Delete(ActionEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "请选择要删除的行！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }else {
            String teaNum = (String) tblData[row][0];
            int result = JOptionPane.showConfirmDialog(this, "确定要删除吗？", "提示", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                try {
                    new TeacherManager().deleteTeacher(teaNum);
                    JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                    this.reloadUserTable();
                } catch (BaseException e1) {
                    JOptionPane.showMessageDialog(this, "删除失败！"+e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void Search(ActionEvent e) {
        // TODO add your code here
        this.reloadUserTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        create = new JButton();
        Modify = new JButton();
        Delete = new JButton();
        refresh = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        TeaNum = new JTextField();
        label3 = new JLabel();
        TeaName = new JTextField();
        Search = new JButton();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setTitle("\u6559\u5e08\u7ba1\u7406");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //---- create ----
            create.setText("\u6dfb\u52a0");
            create.addActionListener(e -> create(e));
            menuBar1.add(create);

            //---- Modify ----
            Modify.setText("\u4fee\u6539");
            Modify.addActionListener(e -> Modify(e));
            menuBar1.add(Modify);

            //---- Delete ----
            Delete.setText("\u5220\u9664");
            Delete.addActionListener(e -> Delete(e));
            menuBar1.add(Delete);

            //---- refresh ----
            refresh.setText("\u5237\u65b0");
            refresh.addActionListener(e -> refresh(e));
            menuBar1.add(refresh);

            //---- label1 ----
            label1.setText("\u67e5\u627e\u6559\u5e08    ");
            menuBar1.add(label1);

            //---- label2 ----
            label2.setText("\u5de5\u53f7\uff1a");
            menuBar1.add(label2);
            menuBar1.add(TeaNum);

            //---- label3 ----
            label3.setText("\u59d3\u540d\uff1a");
            menuBar1.add(label3);
            menuBar1.add(TeaName);

            //---- Search ----
            Search.setText("\u641c\u7d22");
            Search.addActionListener(e -> Search(e));
            menuBar1.add(Search);
        }
        setJMenuBar(menuBar1);
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        setSize(630, 415);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        {
            scrollPane1.setViewportView(table1);
        }
        this.reloadUserTable();
        TeaNum.setText("");
        TeaName.setText("");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JButton create;
    private JButton Modify;
    private JButton Delete;
    private JButton refresh;
    private JLabel label1;
    private JLabel label2;
    private JTextField TeaNum;
    private JLabel label3;
    private JTextField TeaName;
    private JButton Search;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private final Object[] tblTitle = {"工号","姓名","所属学院","手机号码","电子邮箱"};
    private  Object[][] tblData;
    DefaultTableModel tablmod = new DefaultTableModel();
    private final JTable table1 = new JTable(tablmod){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void reloadUserTable() {
        try {
            List<BeanTeacher> teachers = (new TeacherManager().searchteacher(TeaNum.getText(), TeaName.getText()));
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


}
