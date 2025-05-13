package cn.ljh.db.control;

import cn.ljh.db.model.*;
import cn.ljh.db.util.BaseException;
import cn.ljh.db.util.BusinessException;
import cn.ljh.db.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AwardInfoManager {

    public List<AwardInfo> LoadAllAwardInfo() throws BaseException {
        List<AwardInfo> result = new ArrayList<AwardInfo>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from awardinfo";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                AwardInfo awardInfo = new AwardInfo();
                awardInfo.setTeamCode(rs.getString("teamCode"));
                awardInfo.setCompNum(rs.getString("compNum"));
                awardInfo.setAwards(rs.getString("awards"));
                result.add(awardInfo);
            }
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


        return result;
    }

    public void createAwardInfo(AwardInfo awardInfo) throws BaseException {
        if (awardInfo.getTeamCode().length() > 20 || awardInfo.getTeamCode().equals("") || awardInfo.getTeamCode() == null) {
            throw new BusinessException("队伍编号必须为1-20位字符");
        }
        if (awardInfo.getCompNum().length() > 20 || awardInfo.getCompNum().equals("") || awardInfo.getCompNum() == null) {
            throw new BusinessException("比赛编号必须为1-20位字符");
        }
        if (awardInfo.getAwards().length() > 10 || awardInfo.getAwards().equals("") || awardInfo.getAwards() == null) {
            throw new BusinessException("奖项名称必须为1-10位字符");
        }
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from awardinfo where teamCode=? and compNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, awardInfo.getTeamCode());
            pst.setString(2, awardInfo.getCompNum());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                throw new BusinessException("该队伍已存在该比赛的奖项信息！");
            }
            sql = "select * from teammember where teamCode=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, awardInfo.getTeamCode());
            rs = pst.executeQuery();
            if (!rs.next()) {
                throw new BusinessException("该队伍不存在成员！");
            }
            sql = "insert into awardinfo(teamCode,compNum,awards) values(?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, awardInfo.getTeamCode());
            pst.setString(2, awardInfo.getCompNum());
            pst.setString(3, awardInfo.getAwards());
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

    public void modifyAwardInfo(AwardInfo awardInfo, AwardInfo oldAwardInfo) throws BaseException {
        if (awardInfo.getTeamCode().length() > 20 || awardInfo.getTeamCode().equals("") || awardInfo.getTeamCode() == null) {
            throw new BusinessException("队伍编号必须为1-20位字符");
        }
        if (awardInfo.getCompNum().length() > 20 || awardInfo.getCompNum().equals("") || awardInfo.getCompNum() == null) {
            throw new BusinessException("比赛编号必须为1-20位字符");
        }
        if (awardInfo.getAwards().length() > 10 || awardInfo.getAwards().equals("") || awardInfo.getAwards() == null) {
            throw new BusinessException("奖项名称必须为1-10位字符");
        }
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "update awardinfo set teamCode=?,compNum=?,awards=? where teamCode=? and compNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, awardInfo.getTeamCode());
            pst.setString(2, awardInfo.getCompNum());
            pst.setString(3, awardInfo.getAwards());
            pst.setString(4, oldAwardInfo.getTeamCode());
            pst.setString(5, oldAwardInfo.getCompNum());
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

    public void deleteAwardInfo(AwardInfo awardInfo) throws BaseException {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from awardinfo where teamCode=? and compNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, awardInfo.getTeamCode());
            pst.setString(2, awardInfo.getCompNum());
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

    public List<AwardSearch> fuzzySearchAwardInfo(BeanStudent student, BeanMatchs matchs, BeanCompetition comp, Date startDate, Date endDate) throws BaseException {
        List<AwardSearch> result = new ArrayList<AwardSearch>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from awardsearch where stuNum like ? and stuName like ? and stuClass like ? and" +
                    " stuField like ? and compNum like ? and compName like ? and matchsCode like ? and matchsName like ? and organizeTime between ? and ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + student.getStuNum() + "%");
            pst.setString(2, "%" + student.getStuName() + "%");
            pst.setString(3, "%" + student.getStuClass() + "%");
            pst.setString(4, "%" + student.getStuField() + "%");
            pst.setString(5, "%" + comp.getCompNum() + "%");
            pst.setString(6, "%" + comp.getCompName() + "%");
            pst.setString(7, "%" + matchs.getMatchsCode() + "%");
            pst.setString(8, "%" + matchs.getMatchsName() + "%");
            pst.setString(9, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(10, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                AwardSearch AwardSearch = new AwardSearch();
                BeanStudent stu = new BeanStudent();
                BeanCompetition rcomp = new BeanCompetition();
                BeanMatchs mat = new BeanMatchs();
                AwardInfo aw = new AwardInfo();
                stu.setStuNum(rs.getString("stuNum"));
                stu.setStuName(rs.getString("stuName"));
                stu.setStuClass(rs.getString("stuClass"));
                stu.setStuField(rs.getString("stuField"));
                AwardSearch.setStudent(stu);
                rcomp.setCompNum(rs.getString("compNum"));
                rcomp.setCompName(rs.getString("compName"));
                AwardSearch.setCompetition(rcomp);
                mat.setMatchsCode(rs.getString("matchsCode"));
                mat.setMatchsName(rs.getString("matchsName"));
                AwardSearch.setMatchs(mat);
                aw.setAwards(rs.getString("awards"));
                AwardSearch.setAwardInfo(aw);
                AwardSearch.setOrganizetime(rs.getTimestamp("organizeTime"));
                result.add(AwardSearch);
            }
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

            return result;
        }


    }

    public List<AwardSearch> searchAwardInfobyComp(String compNum,String compName) throws BaseException {
        List<AwardSearch> result = new ArrayList<AwardSearch>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select distinct * from awardsearch where compNum like ? and compName like ? group by compNum,teamCode";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + compNum + "%");
            pst.setString(2, "%" + compName + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                AwardSearch AwardSearch = new AwardSearch();
                BeanStudent stu = new BeanStudent();
                BeanCompetition rcomp = new BeanCompetition();
                BeanMatchs mat = new BeanMatchs();
                BeanTeam team = new BeanTeam();
                AwardInfo aw = new AwardInfo();
                stu.setStuNum(rs.getString("stuNum"));
                stu.setStuName(rs.getString("stuName"));
                stu.setStuClass(rs.getString("stuClass"));
                stu.setStuField(rs.getString("stuField"));
                AwardSearch.setStudent(stu);
                rcomp.setCompNum(rs.getString("compNum"));
                rcomp.setCompName(rs.getString("compName"));
                AwardSearch.setCompetition(rcomp);
                mat.setMatchsCode(rs.getString("matchsCode"));
                mat.setMatchsName(rs.getString("matchsName"));
                AwardSearch.setMatchs(mat);
                aw.setAwards(rs.getString("awards"));
                AwardSearch.setAwardInfo(aw);
                team.setTeamCode(rs.getString("teamCode"));
                team.setTeamName(rs.getString("teamName"));
                AwardSearch.setTeam(team);
                AwardSearch.setOrganizetime(rs.getTimestamp("organizeTime"));
                result.add(AwardSearch);
            }
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

            return result;
        }
    }

    public AwardInfo searchAwardInfo(String teamCode, String compNum) throws BaseException {
        AwardInfo result = new AwardInfo();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from awardinfo where teamCode=? and compNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, teamCode);
            pst.setString(2, compNum);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                result.setTeamCode(rs.getString("teamCode"));
                result.setCompNum(rs.getString("compNum"));
                result.setAwards(rs.getString("awards"));
            }
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
        return result;
    }

    public List<BeanStudent> statawardbystu(AwardSearch aw, Date startDate, Date endDate) throws BaseException {
        List<BeanStudent> result = new ArrayList<BeanStudent>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select distinct stuNum,stuName,stuClass,stuField from awardsearch where stuNum like ? and stuName like ?  and organizeTime between ? and ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + aw.getStudent().getStuNum() + "%");
            pst.setString(2, "%" + aw.getStudent().getStuName() + "%");
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(4, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BeanStudent stu = new BeanStudent();
                stu.setStuNum(rs.getString("stuNum"));
                stu.setStuName(rs.getString("stuName"));
                stu.setStuClass(rs.getString("stuClass"));
                stu.setStuField(rs.getString("stuField"));
                result.add(stu);
            }


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
        return result;
    }

    public int countAwardInfobystu(BeanStudent stu, Date startDate, Date endDate) throws BaseException {
        int result = 0;
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select count(*) count from awardsearch where stuNum = ? and organizeTime between ? and ? group by stuNum";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, stu.getStuNum());
            pst.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt("count");
            }
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
        return result;
    }

    public List<BeanCompetition> statawardbycomp(AwardSearch aw, Date startDate, Date endDate) throws BaseException {
        List<BeanCompetition> result = new ArrayList<BeanCompetition>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select distinct compNum,compName from awardsearch where compNum like ? and compName like ?  and organizeTime between ? and ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + aw.getCompetition().getCompNum() + "%");
            pst.setString(2, "%" + aw.getCompetition().getCompName() + "%");
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(4, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BeanCompetition comp = new BeanCompetition();
                comp.setCompNum(rs.getString("compNum"));
                comp.setCompName(rs.getString("compName"));
                result.add(comp);
            }
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
        return result;
    }

    public int countAwardInfobycomp(BeanCompetition comp, Date startDate, Date endDate) throws BaseException {
        int result = 0;
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select count(*) count from awardsearch where compNum = ?  and organizeTime between ? and ? group by compNum";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, comp.getCompNum());
            pst.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt("count");
            }
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
        return result;
    }

    public List<BeanMatchs> statawardbymatchs(AwardSearch aw, Date startDate, Date endDate) throws BaseException {
        List<BeanMatchs> result = new ArrayList<BeanMatchs>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select distinct matchsCode,matchsName from awardsearch where matchsCode like ? and matchsName like ?  and organizeTime between ? and ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + aw.getMatchs().getMatchsCode() + "%");
            pst.setString(2, "%" + aw.getMatchs().getMatchsName() + "%");
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(4, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BeanMatchs mat = new BeanMatchs();
                mat.setMatchsCode(rs.getString("matchsCode"));
                mat.setMatchsName(rs.getString("matchsName"));
                result.add(mat);
            }
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
        return result;
    }

    public int countAwardInfobymatchs(BeanMatchs mat, Date startDate, Date endDate) throws BaseException {
        int result = 0;
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select count(*) count from awardsearch where matchsCode = ?  and organizeTime between ? and ? group by matchsCode";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, mat.getMatchsCode());
            pst.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt("count");
            }
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
        return result;
    }

    public List<String> statawardbyclass(AwardSearch aw, Date startDate, Date endDate) throws BaseException {
        List<String> result = new ArrayList<String>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select distinct stuClass from awardsearch where stuClass like ?  and organizeTime between ? and ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + aw.getStudent().getStuClass() + "%");
            pst.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("stuClass"));
            }
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
        return result;
    }

    public int countAwardInfobyclass(String stuClass, Date startDate, Date endDate) throws BaseException {
        int result = 0;
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select count(*) count from awardsearch where stuClass = ?  and organizeTime between ? and ? group by stuClass";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, stuClass);
            pst.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt("count");
            }
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
        return result;
    }

    public List<String> statawardbyfield(AwardSearch aw, Date startDate, Date endDate) throws BaseException {
        List<String> result = new ArrayList<String>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select distinct stuField from awardsearch where stuField like ?  and organizeTime between ? and ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + aw.getStudent().getStuField() + "%");
            pst.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("stuField"));
            }
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
        return result;
    }

    public int countAwardInfobyfield(String stuField, Date startDate, Date endDate) throws BaseException {
        int result = 0;
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select count(*) count from awardsearch where stuField = ?  and organizeTime between ? and ? group by stuField";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, stuField);
            pst.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt("count");
            }
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
            return result;
        }


    }

    public List<AwardSearch> detailstatawardbystu(String stuNum,Date startDate,Date endDate) throws BaseException {
        List<AwardSearch> result = new ArrayList<AwardSearch>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from awardsearch where stuNum = ? and organizeTime between ? and ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, stuNum);
            pst.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                AwardSearch AwardSearch = new AwardSearch();
                BeanStudent stu = new BeanStudent();
                BeanCompetition rcomp = new BeanCompetition();
                BeanMatchs mat = new BeanMatchs();
                AwardInfo aw = new AwardInfo();
                stu.setStuNum(rs.getString("stuNum"));
                stu.setStuName(rs.getString("stuName"));
                stu.setStuClass(rs.getString("stuClass"));
                stu.setStuField(rs.getString("stuField"));
                AwardSearch.setStudent(stu);
                rcomp.setCompNum(rs.getString("compNum"));
                rcomp.setCompName(rs.getString("compName"));
                AwardSearch.setCompetition(rcomp);
                mat.setMatchsCode(rs.getString("matchsCode"));
                mat.setMatchsName(rs.getString("matchsName"));
                AwardSearch.setMatchs(mat);
                aw.setAwards(rs.getString("awards"));
                AwardSearch.setAwardInfo(aw);
                AwardSearch.setOrganizetime(rs.getTimestamp("organizeTime"));
                result.add(AwardSearch);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new BaseException("数据库操作异常");
        }finally {
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

    public List<AwardSearch> detailstatawardbycomp(String compNum,Date startDate,Date endDate) throws BaseException {
        List<AwardSearch> result = new ArrayList<AwardSearch>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from awardsearch where compNum = ? and organizeTime between ? and ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, compNum);
            pst.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                AwardSearch AwardSearch = new AwardSearch();
                BeanStudent stu = new BeanStudent();
                BeanCompetition rcomp = new BeanCompetition();
                BeanMatchs mat = new BeanMatchs();
                BeanTeam team = new BeanTeam();
                AwardInfo aw = new AwardInfo();
                stu.setStuNum(rs.getString("stuNum"));
                stu.setStuName(rs.getString("stuName"));
                stu.setStuClass(rs.getString("stuClass"));
                stu.setStuField(rs.getString("stuField"));
                AwardSearch.setStudent(stu);
                rcomp.setCompNum(rs.getString("compNum"));
                rcomp.setCompName(rs.getString("compName"));
                AwardSearch.setCompetition(rcomp);
                mat.setMatchsCode(rs.getString("matchsCode"));
                mat.setMatchsName(rs.getString("matchsName"));
                AwardSearch.setMatchs(mat);
                aw.setAwards(rs.getString("awards"));
                AwardSearch.setAwardInfo(aw);
                AwardSearch.setOrganizetime(rs.getTimestamp("organizeTime"));
                team.setTeamName(rs.getString("teamName"));
                team.setTeamCode(rs.getString("teamCode"));
                AwardSearch.setTeam(team);
                result.add(AwardSearch);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new BaseException("数据库操作异常");
        }finally {
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

    public List<AwardSearch> detailstatawardbymatchs(String matchsCode,Date startDate,Date endDate) throws BaseException {
        List<AwardSearch> result = new ArrayList<AwardSearch>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from awardsearch where matchsCode = ? and organizeTime between ? and ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, matchsCode);
            pst.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                AwardSearch AwardSearch = new AwardSearch();
                BeanStudent stu = new BeanStudent();
                BeanCompetition rcomp = new BeanCompetition();
                BeanMatchs mat = new BeanMatchs();
                AwardInfo aw = new AwardInfo();
                stu.setStuNum(rs.getString("stuNum"));
                stu.setStuName(rs.getString("stuName"));
                stu.setStuClass(rs.getString("stuClass"));
                stu.setStuField(rs.getString("stuField"));
                AwardSearch.setStudent(stu);
                rcomp.setCompNum(rs.getString("compNum"));
                rcomp.setCompName(rs.getString("compName"));
                AwardSearch.setCompetition(rcomp);
                mat.setMatchsCode(rs.getString("matchsCode"));
                mat.setMatchsName(rs.getString("matchsName"));
                AwardSearch.setMatchs(mat);
                aw.setAwards(rs.getString("awards"));
                AwardSearch.setAwardInfo(aw);
                AwardSearch.setOrganizetime(rs.getTimestamp("organizeTime"));
                result.add(AwardSearch);
            }
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
        return result;
    }

    public List<AwardSearch> detailstatawardbyclass(String stuClass,Date startDate,Date endDate) throws BaseException {
        List<AwardSearch> result = new ArrayList<AwardSearch>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from awardsearch where stuClass = ? and organizeTime between ? and ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, stuClass);
            pst.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                AwardSearch AwardSearch = new AwardSearch();
                BeanStudent stu = new BeanStudent();
                BeanCompetition rcomp = new BeanCompetition();
                BeanMatchs mat = new BeanMatchs();
                AwardInfo aw = new AwardInfo();
                stu.setStuNum(rs.getString("stuNum"));
                stu.setStuName(rs.getString("stuName"));
                stu.setStuClass(rs.getString("stuClass"));
                stu.setStuField(rs.getString("stuField"));
                AwardSearch.setStudent(stu);
                rcomp.setCompNum(rs.getString("compNum"));
                rcomp.setCompName(rs.getString("compName"));
                AwardSearch.setCompetition(rcomp);
                mat.setMatchsCode(rs.getString("matchsCode"));
                mat.setMatchsName(rs.getString("matchsName"));
                AwardSearch.setMatchs(mat);
                aw.setAwards(rs.getString("awards"));
                AwardSearch.setAwardInfo(aw);
                AwardSearch.setOrganizetime(rs.getTimestamp("organizeTime"));
                result.add(AwardSearch);
            }
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
        return result;
    }

    public List<AwardSearch> detailstatawardbyfield(String stuField,Date startDate,Date endDate) throws BaseException {
        List<AwardSearch> result = new ArrayList<AwardSearch>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from awardsearch where stuField = ? and organizeTime between ? and ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, stuField);
            pst.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime())));
            pst.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate.getTime())));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                AwardSearch AwardSearch = new AwardSearch();
                BeanStudent stu = new BeanStudent();
                BeanCompetition rcomp = new BeanCompetition();
                BeanMatchs mat = new BeanMatchs();
                AwardInfo aw = new AwardInfo();
                stu.setStuNum(rs.getString("stuNum"));
                stu.setStuName(rs.getString("stuName"));
                stu.setStuClass(rs.getString("stuClass"));
                stu.setStuField(rs.getString("stuField"));
                AwardSearch.setStudent(stu);
                rcomp.setCompNum(rs.getString("compNum"));
                rcomp.setCompName(rs.getString("compName"));
                AwardSearch.setCompetition(rcomp);
                mat.setMatchsCode(rs.getString("matchsCode"));
                mat.setMatchsName(rs.getString("matchsName"));
                AwardSearch.setMatchs(mat);
                aw.setAwards(rs.getString("awards"));
                AwardSearch.setAwardInfo(aw);
                AwardSearch.setOrganizetime(rs.getTimestamp("organizeTime"));
                result.add(AwardSearch);
            }
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
        return result;
    }


}
