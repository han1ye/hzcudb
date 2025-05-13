/*
 * Created by JFormDesigner on Sat Jul 06 09:52:07 CST 2024
 */

package cn.ljh.db.ui;



import java.awt.event.*;
import javax.swing.*;

import cn.ljh.db.model.BeanSystemAdmin;
import net.miginfocom.swing.*;

/**
 * @author LJH
 */
public class JFMain extends JFrame {
    public JFMain() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    public JFMain(BeanSystemAdmin admin){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.admin = admin;
        initComponents();
    }


    private void logout(ActionEvent e) {
        // TODO add your code here
        int result =  JOptionPane.showConfirmDialog(null, "确认退出系统？");
        if(result==0) {
            dispose();
            new JFLogin().setVisible(true);
        }
    }

    private void About(ActionEvent e) {
        // TODO add your code here
        new JDAbout().setVisible(true);

    }

    private void StudentManager(ActionEvent e) {
        // TODO add your code here
        new JDStudentManager().setVisible(true);
    }

    private void TeacherManager(ActionEvent e) {
        // TODO add your code here
        new JDTeacherManager().setVisible(true);
    }

    private void TeamManager(ActionEvent e) {
        // TODO add your code here
        new JDTeamManager().setVisible(true);
    }

    private void MatchsManager(ActionEvent e) {
        // TODO add your code here
        new JDMatchsManager().setVisible(true);
    }

    private void CompetitionManager(ActionEvent e) {
        // TODO add your code here
        new JDCompManager(this).setVisible(true);
    }

    private void AwardInfoManager(ActionEvent e) {
        // TODO add your code here
        new JDAwardInfoManager(this).setVisible(true);
    }

    private void CoachManager(ActionEvent e) {
        // TODO add your code here
        new JDCoachManager(this).setVisible(true);
    }

    private void TeamMemberManager(ActionEvent e) {
        // TODO add your code here
        new JDTeamMemberManager(this).setVisible(true);
    }

    private void AwardSearch(ActionEvent e) {
        // TODO add your code here
        new JDAwardSearch(this).setVisible(true);
    }

    private void AwardStat(ActionEvent e) {
        // TODO add your code here
        new JDAwardStat(this).setVisible(true);
    }

    private void StuPwdModify(ActionEvent e) {
        // TODO add your code here
        new JDStuPwdModify(this).setVisible(true);
    }

    private void AdminManager(ActionEvent e) {
        // TODO add your code here
        new JDAdminManager(this,admin).setVisible(true);
    }

    private void AddAdmin(ActionEvent e) {
        // TODO add your code here
        new JDAddAdmin(this).setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        StudentManager = new JMenuItem();
        TeacherManager = new JMenuItem();
        TeamManager = new JMenuItem();
        MatchsManager = new JMenuItem();
        CompetitionManager = new JMenuItem();
        AddAdmin = new JMenuItem();
        menu2 = new JMenu();
        AwardInfoManager = new JMenuItem();
        CoachManager = new JMenuItem();
        TeamMemberManager = new JMenuItem();
        menu3 = new JMenu();
        AwardSearch = new JMenuItem();
        AwardStat = new JMenuItem();
        StuPwdModifyManager = new JMenu();
        StuPwdModify = new JMenuItem();
        menu4 = new JMenu();
        About = new JMenuItem();
        menu5 = new JMenu();
        AdminManager = new JMenuItem();
        logout = new JMenuItem();
        admintext = new JLabel();

        //======== this ========
        setTitle("\u7ade\u8d5b\u7ba1\u7406\u7cfb\u7edf\u4e3b\u754c\u9762");
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
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
            "[]"));

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7cfb\u7edf\u7ba1\u7406");

                //---- StudentManager ----
                StudentManager.setText("\u5b66\u751f\u7ba1\u7406");
                StudentManager.addActionListener(e -> StudentManager(e));
                menu1.add(StudentManager);

                //---- TeacherManager ----
                TeacherManager.setText("\u6559\u5e08\u7ba1\u7406");
                TeacherManager.addActionListener(e -> TeacherManager(e));
                menu1.add(TeacherManager);

                //---- TeamManager ----
                TeamManager.setText("\u961f\u4f0d\u7ba1\u7406");
                TeamManager.addActionListener(e -> TeamManager(e));
                menu1.add(TeamManager);

                //---- MatchsManager ----
                MatchsManager.setText("\u7ade\u8d5b\u7ba1\u7406");
                MatchsManager.addActionListener(e -> MatchsManager(e));
                menu1.add(MatchsManager);

                //---- CompetitionManager ----
                CompetitionManager.setText("\u8d5b\u4e8b\u7ba1\u7406");
                CompetitionManager.addActionListener(e -> CompetitionManager(e));
                menu1.add(CompetitionManager);

                //---- AddAdmin ----
                AddAdmin.setText("\u6dfb\u52a0\u7ba1\u7406\u5458");
                AddAdmin.addActionListener(e -> AddAdmin(e));
                menu1.add(AddAdmin);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u8d5b\u4e8b\u7ba1\u7406");

                //---- AwardInfoManager ----
                AwardInfoManager.setText("\u83b7\u5956\u7ba1\u7406");
                AwardInfoManager.addActionListener(e -> AwardInfoManager(e));
                menu2.add(AwardInfoManager);

                //---- CoachManager ----
                CoachManager.setText("\u6307\u5bfc\u4fe1\u606f\u7ba1\u7406");
                CoachManager.addActionListener(e -> CoachManager(e));
                menu2.add(CoachManager);

                //---- TeamMemberManager ----
                TeamMemberManager.setText("\u7ec4\u961f\u7ba1\u7406");
                TeamMemberManager.addActionListener(e -> TeamMemberManager(e));
                menu2.add(TeamMemberManager);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u67e5\u8be2\u7edf\u8ba1");

                //---- AwardSearch ----
                AwardSearch.setText("\u83b7\u5956\u60c5\u51b5\u67e5\u8be2");
                AwardSearch.addActionListener(e -> AwardSearch(e));
                menu3.add(AwardSearch);

                //---- AwardStat ----
                AwardStat.setText("\u83b7\u5956\u60c5\u51b5\u7edf\u8ba1");
                AwardStat.addActionListener(e -> AwardStat(e));
                menu3.add(AwardStat);
            }
            menuBar1.add(menu3);

            //======== StuPwdModifyManager ========
            {
                StuPwdModifyManager.setText("\u5b66\u751f\u5bc6\u7801\u4fee\u6539");

                //---- StuPwdModify ----
                StuPwdModify.setText("\u4fee\u6539\u5b66\u751f\u5bc6\u7801");
                StuPwdModify.addActionListener(e -> StuPwdModify(e));
                StuPwdModifyManager.add(StuPwdModify);
            }
            menuBar1.add(StuPwdModifyManager);

            //======== menu4 ========
            {
                menu4.setText("\u5173\u4e8e\u6211\u4eec");

                //---- About ----
                About.setText("\u7cfb\u7edf\u4f5c\u8005\u4fe1\u606f");
                About.addActionListener(e -> About(e));
                menu4.add(About);
            }
            menuBar1.add(menu4);

            //======== menu5 ========
            {
                menu5.setText("\u4e2a\u4eba\u7ba1\u7406");

                //---- AdminManager ----
                AdminManager.setText("\u4e2a\u4eba\u4fe1\u606f\u7ba1\u7406");
                AdminManager.addActionListener(e -> AdminManager(e));
                menu5.add(AdminManager);

                //---- logout ----
                logout.setText("\u9000\u51fa\u767b\u5f55");
                logout.addActionListener(e -> logout(e));
                menu5.add(logout);
            }
            menuBar1.add(menu5);

            //---- admintext ----
            admintext.setText("text");
            menuBar1.add(admintext);
        }
        setJMenuBar(menuBar1);
        setSize(775, 510);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        //判断时间在早上还是上午还是下午还是晚上并显示不同的欢迎信息
        String time = java.time.LocalTime.now().toString().substring(0, 2);
        if(time.compareTo("05")>=0 && time.compareTo("09")<0){
            admintext.setText(" 早上好，"+admin.getAdminName()+"！");
        }else if(time.compareTo("09")>=0 && time.compareTo("12")<0){
            admintext.setText(" 上午好，"+admin.getAdminName()+"！");
        }else if(time.compareTo("12")>=0 && time.compareTo("18")<0){
            admintext.setText(" 下午好，"+admin.getAdminName()+"！");
        }else{
            admintext.setText(" 晚上好，"+admin.getAdminName()+"！");
        }

        ImageIcon bg=new ImageIcon("imag/background.png");
        JLabel label=new JLabel(bg);
        label.setSize(bg.getIconWidth(),bg.getIconHeight());
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        //2.把窗口面板设为内容面板并设为透明、流动布局。
        JPanel pan=(JPanel)this.getContentPane();
        pan.setOpaque(false);
        //pan.setLayout(new FlowLayout());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem StudentManager;
    private JMenuItem TeacherManager;
    private JMenuItem TeamManager;
    private JMenuItem MatchsManager;
    private JMenuItem CompetitionManager;
    private JMenuItem AddAdmin;
    private JMenu menu2;
    private JMenuItem AwardInfoManager;
    private JMenuItem CoachManager;
    private JMenuItem TeamMemberManager;
    private JMenu menu3;
    private JMenuItem AwardSearch;
    private JMenuItem AwardStat;
    private JMenu StuPwdModifyManager;
    private JMenuItem StuPwdModify;
    private JMenu menu4;
    private JMenuItem About;
    private JMenu menu5;
    private JMenuItem AdminManager;
    private JMenuItem logout;
    private JLabel admintext;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private BeanSystemAdmin admin;
}
