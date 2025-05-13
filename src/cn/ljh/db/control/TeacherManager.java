package cn.ljh.db.control;

import cn.ljh.db.model.BeanTeacher;
import cn.ljh.db.util.BaseException;
import cn.ljh.db.util.BusinessException;
import cn.ljh.db.util.DBUtil;
import cn.ljh.db.util.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherManager {

    public List<BeanTeacher> LoadAllTeachers() throws BaseException {
        List<BeanTeacher> result = new ArrayList<BeanTeacher>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from teacher";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BeanTeacher bt = new BeanTeacher();
                bt.setTeaNum(rs.getString("teaNum"));
                bt.setTeaName(rs.getString("teaName"));
                bt.setTeaemail(rs.getString("teaemail"));
                bt.setBelongCollege(rs.getString("belongCollege"));
                bt.setTeaTel(rs.getString("teaTel"));
                result.add(bt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public void createTeacher(BeanTeacher Teacher) throws BaseException {
        if (Teacher.getTeaNum() == null || Teacher.getTeaNum().equals("") || Teacher.getTeaNum().length() >20){
            throw new BusinessException("教师工号必须为1-20位");
        }
        if (Teacher.getTeaName() == null || Teacher.getTeaName().equals("") || Teacher.getTeaName().length() >10){
            throw new BusinessException("教师姓名必须为1-10位");
        }
        if (Teacher.getTeaemail() == null || Teacher.getTeaemail().equals("") || Teacher.getTeaemail().length() >30){
            throw new BusinessException("教师邮箱必须为1-30位");
        }
        if (Teacher.getBelongCollege() == null || Teacher.getBelongCollege().equals("") || Teacher.getBelongCollege().length() >20){
            throw new BusinessException("所属学院必须为1-20位");
        }
        if (Teacher.getTeaTel() == null || Teacher.getTeaTel().equals("") || Teacher.getTeaTel().length() >20){
            throw new BusinessException("教师电话必须为1-20位");
        }
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "select * from teacher where teaNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, Teacher.getTeaNum());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                throw new BusinessException("教师已存在");
            }
            pst.close();
            rs.close();
            sql = "insert into teacher(teaNum,teaName,teaemail,belongCollege,teaTel) values(?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, Teacher.getTeaNum());
            pst.setString(2, Teacher.getTeaName());
            pst.setString(3, Teacher.getTeaemail());
            pst.setString(4, Teacher.getBelongCollege());
            pst.setString(5, Teacher.getTeaTel());
            pst.execute();
            pst.close();
        }catch (SQLException e){
            e.printStackTrace();
            throw new DbException(e);
        }finally {

            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void deleteTeacher(String teaNum) throws BaseException {
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "delete from teacher where teaNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, teaNum);
            pst.execute();
            pst.close();
        }catch (SQLException e){
            e.printStackTrace();
            throw new BusinessException("该老师存在指导的队伍！");
        }finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }


    }

    public void modifyTeacher(BeanTeacher Teacher) throws BaseException {
        if (Teacher.getTeaNum() == null || Teacher.getTeaNum().equals("") || Teacher.getTeaNum().length() >20){
            throw new BusinessException("教师工号必须为1-20位");
        }
        if (Teacher.getTeaName() == null || Teacher.getTeaName().equals("") || Teacher.getTeaName().length() >10){
            throw new BusinessException("教师姓名必须为1-10位");
        }
        if (Teacher.getTeaemail() == null || Teacher.getTeaemail().equals("") || Teacher.getTeaemail().length() >30){
            throw new BusinessException("教师邮箱必须为1-30位");
        }
        if (Teacher.getBelongCollege() == null || Teacher.getBelongCollege().equals("") || Teacher.getBelongCollege().length() >20){
            throw new BusinessException("所属学院必须为1-20位");
        }
        if (Teacher.getTeaTel() == null || Teacher.getTeaTel().equals("") || Teacher.getTeaTel().length() >20){
            throw new BusinessException("教师电话必须为1-20位");
        }
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "update teacher set teaName=?,teaemail=?,belongCollege=?,teaTel=? where teaNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, Teacher.getTeaName());
            pst.setString(2, Teacher.getTeaemail());
            pst.setString(3, Teacher.getBelongCollege());
            pst.setString(4, Teacher.getTeaTel());
            pst.setString(5, Teacher.getTeaNum());
            pst.execute();
            pst.close();
        }catch (SQLException e){
            e.printStackTrace();
            throw new DbException(e);
        }finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }



    }

    public BeanTeacher LoadTeacherByNum(String teaNum) throws BaseException {
        Connection conn = null;
        BeanTeacher result = new BeanTeacher();;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from teacher where teaNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, teaNum);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result.setTeaNum(rs.getString("teaNum"));
                result.setTeaName(rs.getString("teaName"));
                result.setTeaemail(rs.getString("teaemail"));
                result.setBelongCollege(rs.getString("belongCollege"));
                result.setTeaTel(rs.getString("teaTel"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return result;
    }

    public List<BeanTeacher> searchteacher(String teaNumKeyword ,String teaNameKeyword) throws BaseException {
        List<BeanTeacher> result = new ArrayList<BeanTeacher>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from teacher where teaNum like ? and teaName like ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + teaNumKeyword + "%");
            pst.setString(2, "%" + teaNameKeyword + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BeanTeacher bt = new BeanTeacher();
                bt.setTeaNum(rs.getString("teaNum"));
                bt.setTeaName(rs.getString("teaName"));
                bt.setTeaemail(rs.getString("teaemail"));
                bt.setBelongCollege(rs.getString("belongCollege"));
                bt.setTeaTel(rs.getString("teaTel"));
                result.add(bt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BusinessException("查询失败");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 添加100个老师
        TeacherManager tm = new TeacherManager();
        for (int i = 0; i < 100; i++) {
            BeanTeacher bt = new BeanTeacher();
            bt.setTeaNum("T" + i);
            bt.setTeaName("老师" + i);
            bt.setTeaemail("teacher" + i + "@qq.com");
            bt.setBelongCollege("计算机学院");
            bt.setTeaTel("13812345678");
            try {
                tm.createTeacher(bt);
            } catch (BaseException e) {
                e.printStackTrace();
            }
        }
    }


}
