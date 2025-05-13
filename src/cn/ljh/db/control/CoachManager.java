package cn.ljh.db.control;

import cn.ljh.db.model.CoachInfo;
import cn.ljh.db.util.BaseException;
import cn.ljh.db.util.BusinessException;
import cn.ljh.db.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoachManager {

    public List<CoachInfo> LoadAllCoachInfo() throws BaseException {
        List<CoachInfo> result = new ArrayList<CoachInfo>();
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "select * from coach";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                CoachInfo coachInfo = new CoachInfo();
                coachInfo.setCompNum(rs.getString("compNum"));
                coachInfo.setTeamCode(rs.getString("teamCode"));
                coachInfo.setTeaNum(rs.getString("teaNum"));
                result.add(coachInfo);
            }

        }catch (SQLException e){
            e.printStackTrace();
            throw new BaseException("数据库操作异常");
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

    public void createCoachInfo(CoachInfo coachInfo) throws BaseException {
        if(coachInfo.getCompNum().length()>20||coachInfo.getCompNum() == null || coachInfo.getCompNum().equals("")){
            throw new BusinessException("赛事序号必须为1-20位字符");
        }
        if(coachInfo.getTeamCode().length()>20||coachInfo.getTeamCode() == null || coachInfo.getTeamCode().equals("")){
            throw new BusinessException("队伍编号必须为1-20位字符");
        }

        if(coachInfo.getTeaNum().length()>20||coachInfo.getTeaNum() == null || coachInfo.getTeaNum().equals("")){
            throw new BusinessException("教师职工号必须为1-20位字符");
        }
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "select * from coach where compNum=? and teamCode=? and teaNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, coachInfo.getCompNum());
            pst.setString(2, coachInfo.getTeamCode());
            pst.setString(3, coachInfo.getTeaNum());
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                throw new BaseException("指导信息已存在！");
            }
            pst.close();
            rs.close();
            sql = "insert into coach(compNum,teamCode,teaNum) values(?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, coachInfo.getCompNum());
            pst.setString(2, coachInfo.getTeamCode());
            pst.setString(3, coachInfo.getTeaNum());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new BusinessException("数据库异常");
        }finally {

            if(conn!=null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void deleteCoachInfo(CoachInfo coachInfo) throws BaseException {
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "delete from coach where compNum=? and teamCode=? and teaNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, coachInfo.getCompNum());
            pst.setString(2, coachInfo.getTeamCode());
            pst.setString(3, coachInfo.getTeaNum());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new BaseException("数据库操作异常");
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void modifyCoachInfo(CoachInfo newcoachInfo, CoachInfo oldcoachInfo) throws BaseException {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "update coach set compNum=?,teamCode=?,teaNum=? where compNum=? and teamCode=? and teaNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, newcoachInfo.getCompNum());
            pst.setString(2, newcoachInfo.getTeamCode());
            pst.setString(3, newcoachInfo.getTeaNum());
            pst.setString(4, oldcoachInfo.getCompNum());
            pst.setString(5, oldcoachInfo.getTeamCode());
            pst.setString(6, oldcoachInfo.getTeaNum());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BaseException("数据库操作异常");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
