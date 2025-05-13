package cn.ljh.db.control;

import cn.ljh.db.model.BeanTeacher;
import cn.ljh.db.model.BeanTeam;
import cn.ljh.db.util.BaseException;
import cn.ljh.db.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TeamManager {

    public List<BeanTeam> LoadAllTeams() throws BaseException {
        List<BeanTeam> result = new ArrayList<BeanTeam>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM team";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BeanTeam bt = new BeanTeam();
                bt.setTeamCode(rs.getString("teamCode"));
                bt.setTeamName(rs.getString("teamName"));
                bt.setTeamNameEn(rs.getString("teamNameEn"));
                bt.setCreatTime(rs.getTimestamp("creatTime"));
                bt.setTeamSize(rs.getInt("teamSize"));
                bt.setNote(rs.getString("note"));
                result.add(bt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
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

    public void createTeam(BeanTeam team) throws BaseException {
        if (team.getTeamCode().length() > 20 || team.getTeamCode() == null || team.getTeamCode().equals("")) {
            throw new BaseException("队伍编号必须为1-20位字符");
        }
        if (team.getTeamName().length() > 20 || team.getTeamName() == null || team.getTeamName().equals("")) {
            throw new BaseException("队伍名称必须为1-20位字符");
        }
        if (team.getTeamNameEn().length() > 30 || team.getTeamNameEn() == null || team.getTeamNameEn().equals("")) {
            throw new BaseException("队伍名称英文必须为1-30位字符");
        }
        if (team.getTeamSize() < 1) {
            throw new BaseException("队伍至少有1人！");
        }
        if (team.getNote().length() > 200) {
            throw new BaseException("备注不能超过200字！");
        }
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from team where teamCode = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, team.getTeamCode());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                throw new BaseException("队伍已存在！");
            }
            pst.close();
            rs.close();
            sql = "insert into team(teamCode,teamName,teamNameEn, creatTime, teamSize, note) values(?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, team.getTeamCode());
            pst.setString(2, team.getTeamName());
            pst.setString(3, team.getTeamNameEn());
            pst.setString(4, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(team.getCreatTime())));
            pst.setInt(5, team.getTeamSize());
            pst.setString(6, team.getNote());
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
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

    public void deleteTeam(String teamCode) throws BaseException {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from team where teamCode = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, teamCode);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BaseException("队伍必须为空！并且该队伍不能存在指导以及获奖信息！");
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

    public void modifyTeam(BeanTeam team) throws BaseException {
        if (team.getTeamCode().length() > 20 || team.getTeamCode() == null || team.getTeamCode().equals("")) {
            throw new BaseException("队伍编号必须为1-20位字符");
        }
        if (team.getTeamName().length() > 20 || team.getTeamName() == null || team.getTeamName().equals("")) {
            throw new BaseException("队伍名称必须为1-20位字符");
        }
        if (team.getTeamNameEn().length() > 30 || team.getTeamNameEn() == null || team.getTeamNameEn().equals("")) {
            throw new BaseException("队伍名称英文必须为1-30位字符");
        }
        if (team.getTeamSize() < 1) {
            throw new BaseException("队伍至少有1人！");
        }
        if (team.getNote().length() > 200) {
            throw new BaseException("备注不能超过200字！");
        }
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "update team set teamName = ?, teamNameEn = ?, teamSize = ?, note = ? where teamCode = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, team.getTeamName());
            pst.setString(2, team.getTeamNameEn());
            pst.setInt(3, team.getTeamSize());
            pst.setString(4, team.getNote());
            pst.setString(5, team.getTeamCode());
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
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

    public BeanTeam LoadTeamByTeamCode(String teamCode) throws BaseException {
        BeanTeam result = new BeanTeam();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM team WHERE teamCode = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, teamCode);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result.setTeamCode(rs.getString("teamCode"));
                result.setTeamName(rs.getString("teamName"));
                result.setTeamNameEn(rs.getString("teamNameEn"));
                result.setCreatTime(rs.getTimestamp("creatTime"));
                result.setTeamSize(rs.getInt("teamSize"));
                result.setNote(rs.getString("note"));
            }
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
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

    public int LoadTeamStuNumByTeamCode(String teamCode) throws BaseException {
        int result = 0;
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select count(*) from teammember where teamCode = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, teamCode);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
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

    public List<BeanTeam> searchTeam(String teamCodeKeyword, String teamNameKeyword) throws BaseException {
        List<BeanTeam> result = new ArrayList<BeanTeam>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM team WHERE teamCode LIKE ? AND  teamName LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + teamCodeKeyword + "%");
            pst.setString(2, "%" + teamNameKeyword + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BeanTeam bt = new BeanTeam();
                bt.setTeamCode(rs.getString("teamCode"));
                bt.setTeamName(rs.getString("teamName"));
                bt.setTeamNameEn(rs.getString("teamNameEn"));
                bt.setCreatTime(rs.getTimestamp("creatTime"));
                bt.setTeamSize(rs.getInt("teamSize"));
                bt.setNote(rs.getString("note"));
                result.add(bt);
            }
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
        //添加100个队伍
        TeamManager tm = new TeamManager();
        for (int i = 0; i < 100; i++) {
            BeanTeam bt = new BeanTeam();
            bt.setTeamCode("team" + i);
            bt.setTeamName("队伍" + i);
            bt.setTeamNameEn("team" + i);
            bt.setCreatTime(new java.util.Date());
            bt.setTeamSize(10);
            bt.setNote("备注" + i);
            try {
                tm.createTeam(bt);
            } catch (BaseException e) {
                e.printStackTrace();
            }
        }

    }

}
