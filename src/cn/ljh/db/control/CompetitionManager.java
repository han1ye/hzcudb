package cn.ljh.db.control;

import cn.ljh.db.model.BeanCompetition;
import cn.ljh.db.util.BaseException;
import cn.ljh.db.util.BusinessException;
import cn.ljh.db.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CompetitionManager {

    public List<BeanCompetition> LoadAllCompetition() throws BaseException {
        List<BeanCompetition> result = new ArrayList<BeanCompetition>();
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "select * from competition";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                BeanCompetition bct = new BeanCompetition();
                bct.setCompNum(rs.getString("compNum"));
                bct.setCompName(rs.getString("compName"));
                bct.setMatchsCode(rs.getString("matchsCode"));
                bct.setOrganizeTime(rs.getTimestamp("organizeTime"));
                bct.setOrganizeArea(rs.getString("organizeArea"));
                result.add(bct);
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

    public void createCompetition(BeanCompetition comp) throws BaseException {
        if(comp.getCompNum().length() > 20 || comp.getCompNum().equals("") || comp.getCompNum() == null){
            throw new BaseException("赛事序号必须为1-20位字符");
        }
        if(comp.getCompName().length() > 40 || comp.getCompName().equals("") || comp.getCompName() == null){
            throw new BaseException("赛事名称必须为1-40位字符");
        }
        if(comp.getMatchsCode().length() > 20 || comp.getMatchsCode().equals("") || comp.getMatchsCode() == null){
            throw new BaseException("竞赛编号必须为1-20位字符");
        }
        if(comp.getOrganizeTime() == null){
            throw new BaseException("举办时间不能为空");
        }
        if(comp.getOrganizeArea().length() > 50 || comp.getOrganizeArea().equals("") || comp.getOrganizeArea() == null){
            throw new BaseException("举办地点必须为1-20位字符");
        }
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "select * from competition where compNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,comp.getCompNum());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                throw new BaseException("赛事已存在");
            }
            sql = "insert into competition(compNum,compName,matchsCode,organizeTime,organizeArea) values(?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,comp.getCompNum());
            pst.setString(2,comp.getCompName());
            pst.setString(3,comp.getMatchsCode());
            pst.setString(4,(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(comp.getOrganizeTime())));
            pst.setString(5,comp.getOrganizeArea());
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

    public void deleteCompetition(String compNum) throws BaseException {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from competition where compNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, compNum);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BusinessException("该赛事存在获奖信息或指导信息！");
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

    public void modifyCompetition(BeanCompetition comp) throws BaseException {
        if(comp.getCompName().length() > 40 || comp.getCompName().equals("") || comp.getCompName() == null){
            throw new BaseException("赛事名称必须为1-40位字符");
        }
        if(comp.getMatchsCode().length() > 20 || comp.getMatchsCode().equals("") || comp.getMatchsCode() == null){
            throw new BaseException("竞赛编号必须为1-20位字符");
        }
        if(comp.getOrganizeTime() == null){
            throw new BaseException("举办时间不能为空");
        }
        if(comp.getOrganizeArea().length() > 50 || comp.getOrganizeArea().equals("") || comp.getOrganizeArea() == null){
            throw new BaseException("举办地点必须为1-20位字符");
        }
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "update competition set compName=?,matchsCode=?,organizeTime=?,organizeArea=? where compNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,comp.getCompName());
            pst.setString(2,comp.getMatchsCode());
            pst.setString(3,(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(comp.getOrganizeTime())));
            pst.setString(4,comp.getOrganizeArea());
            pst.setString(5,comp.getCompNum());
            pst.execute();
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

    public BeanCompetition LoadCompetitionByCompNum(String compNum) throws BaseException {
        BeanCompetition result = new BeanCompetition();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from competition where compNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, compNum);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result.setCompNum(rs.getString("compNum"));
                result.setCompName(rs.getString("compName"));
                result.setMatchsCode(rs.getString("matchsCode"));
                result.setOrganizeTime(rs.getTimestamp("organizeTime"));
                result.setOrganizeArea(rs.getString("organizeArea"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BaseException("数据库操作异常");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public boolean compisgroup(String compNum) throws BaseException {
        boolean result = false;
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select matchsGroup from competition,matchs where competition.matchsCode=matchs.matchsCode and competition.compNum=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, compNum);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getBoolean("matchsGroup");
            }
        }catch (SQLException e) {
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

    public List<BeanCompetition> searchCompetition(String compNumKeyword,String compNameKeyword) throws BaseException {
        List<BeanCompetition> result = new ArrayList<BeanCompetition>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from competition where compNum like ? and compName like ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%"+compNumKeyword+"%");
            pst.setString(2, "%"+compNameKeyword+"%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BeanCompetition bct = new BeanCompetition();
                bct.setCompNum(rs.getString("compNum"));
                bct.setCompName(rs.getString("compName"));
                bct.setMatchsCode(rs.getString("matchsCode"));
                bct.setOrganizeTime(rs.getTimestamp("organizeTime"));
                bct.setOrganizeArea(rs.getString("organizeArea"));
                result.add(bct);
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

    public static void main(String[] args) {
        //添加100个赛事
        CompetitionManager cm = new CompetitionManager();
        for(int i=0;i<100;i++) {
            BeanCompetition bc = new BeanCompetition();
            bc.setCompNum(String.format("%03d", i + 1));
            bc.setCompName("测试赛事" + i);
            bc.setMatchsCode(String.format("%02d", i % 10));

            bc.setOrganizeTime(new java.sql.Timestamp(System.currentTimeMillis()));

            bc.setOrganizeArea("测试地点" + i);
            try {
                cm.createCompetition(bc);
            } catch (BaseException e) {
                e.printStackTrace();
            }
        }
    }



}
