package cn.ljh.db.control;

import cn.ljh.db.model.TeamMember;
import cn.ljh.db.util.BaseException;
import cn.ljh.db.util.BusinessException;
import cn.ljh.db.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamMemberManager {

    public List<TeamMember> LoadAllTeamMember() {
        List<TeamMember> result = new ArrayList<TeamMember>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from teammember";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                TeamMember teamMember = new TeamMember();
                teamMember.setTeamCode(rs.getString("teamCode"));
                teamMember.setStuNum(rs.getString("stuNum"));
                teamMember.setLeader(rs.getBoolean("leader"));
                result.add(teamMember);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn!= null){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public void createTeamMember(TeamMember teamMember) throws BaseException {
        if (teamMember.getTeamCode().length() >20||teamMember.getTeamCode().equals("")||teamMember.getTeamCode()==null){
            throw new BaseException("队伍编号必须为1-20位字符！");
        }
        if (teamMember.getStuNum().length() > 20 || teamMember.getStuNum().equals("") || teamMember.getStuNum() == null) {
            throw new BaseException("学号必须为1-20位字符！");
        }
        TeamManager teamManager = new TeamManager();
        int Nums = teamManager.LoadTeamStuNumByTeamCode(teamMember.getTeamCode());
        if(Nums>=teamManager.LoadTeamByTeamCode(teamMember.getTeamCode()).getTeamSize()){
            throw new BusinessException("队伍人数已满！");
        }
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from teammember where teamCode =? and stuNum =?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, teamMember.getTeamCode());
            pst.setString(2, teamMember.getStuNum());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                throw new BusinessException("成员已存在！");
            }
            pst.close();
            rs.close();
            sql = "select * from teammember where teamCode =? and leader = true";
            pst = conn.prepareStatement(sql);
            pst.setString(1, teamMember.getTeamCode());

            ResultSet rs1 = pst.executeQuery();
            if (rs1.next()&&teamMember.isLeader()) {
                throw new BusinessException("队伍已存在队长！");
            }
            rs = pst.executeQuery();
            if(!rs.next()&&!teamMember.isLeader()){
                throw new BusinessException("队伍不存在队长！需要先添加队长！");
            }
            rs.close();
            pst.close();
            sql= "insert into teammember(teamCode, stuNum, leader) values(?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, teamMember.getTeamCode());
            pst.setString(2, teamMember.getStuNum());
            pst.setBoolean(3, teamMember.isLeader());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BaseException("创建成员失败！");
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

    public void deleteTeamMember(TeamMember teamMember) throws BaseException {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from teammember where teamCode =? and stuNum =?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, teamMember.getTeamCode());
            pst.setString(2, teamMember.getStuNum());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BaseException("删除成员失败！");
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

    public void modifyTeamMember(TeamMember newteamMember, TeamMember oldteamMember) throws BaseException {

        if (newteamMember.getTeamCode().length() > 20 || newteamMember.getTeamCode().equals("") || newteamMember.getTeamCode() == null) {
            throw new BaseException("队伍编号必须为1-20位字符！");
        }
        if (newteamMember.getStuNum().length() > 20 || newteamMember.getStuNum().equals("") || newteamMember.getStuNum() == null) {
            throw new BaseException("学号必须为1-20位字符！");
        }
        TeamManager teamManager = new TeamManager();
        int Nums = teamManager.LoadTeamStuNumByTeamCode(newteamMember.getTeamCode());
        if(Nums>=teamManager.LoadTeamByTeamCode(newteamMember.getTeamCode()).getTeamSize()&&!newteamMember.getTeamCode().equals(oldteamMember.getTeamCode())){
            throw new BusinessException("队伍人数已满！");
        }
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "update teammember set teamCode =?, stuNum =?, leader =? where teamCode =? and stuNum =?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, newteamMember.getTeamCode());
            pst.setString(2, newteamMember.getStuNum());
            pst.setBoolean(3, newteamMember.isLeader());
            pst.setString(4, oldteamMember.getTeamCode());
            pst.setString(5, oldteamMember.getStuNum());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BaseException("修改成员失败！");
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
