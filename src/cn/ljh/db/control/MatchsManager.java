package cn.ljh.db.control;

import cn.ljh.db.model.BeanMatchs;
import cn.ljh.db.util.BaseException;
import cn.ljh.db.util.BusinessException;
import cn.ljh.db.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatchsManager {

    public List<BeanMatchs> LodaAllMatchs() throws BaseException{
        List<BeanMatchs> result = new ArrayList<BeanMatchs>();
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "select * from matchs";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                BeanMatchs bm = new BeanMatchs();
                bm.setMatchsCode(rs.getString("matchsCode"));
                bm.setMatchsName(rs.getString("matchsName"));
                bm.setOrganizer(rs.getString("organizer"));
                bm.setContractor(rs.getString("contractor"));
                bm.setMatchsGroup(rs.getBoolean("matchsGroup"));
                bm.setMatchsInfo(rs.getString("matchsInfo"));
                result.add(bm);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public void createMatchs(BeanMatchs matchs) throws BaseException {
        if (matchs.getMatchsCode().length()>20 || matchs.getMatchsCode().equals("")||matchs.getMatchsCode()==null){
            throw new BusinessException("竞赛编号必须为1-20位字符！");
        }
        if (matchs.getMatchsName().length()>20 || matchs.getMatchsName().equals("")||matchs.getMatchsName()==null){
            throw new BusinessException("竞赛名称必须为1-20位字符！");
        }
        if (matchs.getOrganizer().length()>20 || matchs.getOrganizer().equals("")||matchs.getOrganizer()==null){
            throw new BusinessException("主办方必须为1-20位字符！");
        }
        if (matchs.getContractor().length()>20 || matchs.getContractor().equals("")||matchs.getContractor()==null){
            throw new BusinessException("承办方必须为1-20位字符！");
        }
        if (matchs.getMatchsInfo().length()>200){
            throw new BusinessException("竞赛简介最多200字！");
        }
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "select * from matchs where matchsCode=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,matchs.getMatchsCode());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                throw new BusinessException("竞赛已存在！");
            }
            pst.close();
            rs.close();
            sql = "insert into matchs(matchsCode,matchsName,organizer,contractor,matchsGroup,matchsInfo) values(?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,matchs.getMatchsCode());
            pst.setString(2,matchs.getMatchsName());
            pst.setString(3,matchs.getOrganizer());
            pst.setString(4,matchs.getContractor());
            pst.setBoolean(5,matchs.isMatchsGroup());
            pst.setString(6,matchs.getMatchsInfo());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new BaseException("创建失败！"+e.getMessage());
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void deleteMatchs(String matchsCode) throws BaseException {
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "delete from matchs where matchsCode=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,matchsCode);
            pst.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw new BusinessException("该竞赛存在赛事！");
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void modifyMatchs(BeanMatchs matchs) throws BaseException {
        if (matchs.getMatchsName().length()>20 || matchs.getMatchsName().equals("")||matchs.getMatchsName()==null){
            throw new BusinessException("竞赛名称必须为1-20位字符！");
        }
        if (matchs.getOrganizer().length()>20 || matchs.getOrganizer().equals("")||matchs.getOrganizer()==null){
            throw new BusinessException("主办方必须为1-20位字符！");
        }
        if (matchs.getContractor().length()>20 || matchs.getContractor().equals("")||matchs.getContractor()==null){
            throw new BusinessException("承办方必须为1-20位字符！");
        }
        if (matchs.getMatchsInfo().length()>200){
            throw new BusinessException("竞赛简介最多200字！");
        }
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "update matchs set matchsName=?,organizer=?,contractor=?,matchsGroup=?,matchsInfo=? where matchsCode=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,matchs.getMatchsName());
            pst.setString(2,matchs.getOrganizer());
            pst.setString(3,matchs.getContractor());
            pst.setBoolean(4,matchs.isMatchsGroup());
            pst.setString(5,matchs.getMatchsInfo());
            pst.setString(6,matchs.getMatchsCode());
            pst.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw new BaseException("修改失败！"+e.getMessage());
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<BeanMatchs> searchMatchs(String matchsCodeKeyword,String matchsNameKeyword) throws BaseException{
        List<BeanMatchs> result = new ArrayList<BeanMatchs>();
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "select * from matchs where matchsCode like ? and matchsName like ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%"+matchsCodeKeyword+"%");
            pst.setString(2, "%"+matchsNameKeyword+"%");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                BeanMatchs bm = new BeanMatchs();
                bm.setMatchsCode(rs.getString("matchsCode"));
                bm.setMatchsName(rs.getString("matchsName"));
                bm.setOrganizer(rs.getString("organizer"));
                bm.setContractor(rs.getString("contractor"));
                bm.setMatchsGroup(rs.getBoolean("matchsGroup"));
                bm.setMatchsInfo(rs.getString("matchsInfo"));
                result.add(bm);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new BaseException("查询失败！"+e.getMessage());
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
         }
        return result;
    }

    public BeanMatchs getMatchs(String matchsCode) throws BaseException{
        BeanMatchs result = null;
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "select * from matchs where matchsCode=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,matchsCode);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                result = new BeanMatchs();
                result.setMatchsCode(rs.getString("matchsCode"));
                result.setMatchsName(rs.getString("matchsName"));
                result.setOrganizer(rs.getString("organizer"));
                result.setContractor(rs.getString("contractor"));
                result.setMatchsGroup(rs.getBoolean("matchsGroup"));
                result.setMatchsInfo(rs.getString("matchsInfo"));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new BaseException("查询失败！"+e.getMessage());
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
         }
        return result;
    }

    public static void main(String[] args) {
        //添加10个竞赛
        MatchsManager mm = new MatchsManager();
        for(int i=0;i<10;i++){
            BeanMatchs bm = new BeanMatchs();
            bm.setMatchsCode(String.format("%02d",i));
            bm.setMatchsName("竞赛"+i);
            bm.setOrganizer("主办方"+i);
            bm.setContractor("承办方"+i);
            if(i%2==0){
                bm.setMatchsGroup(false);
            }else {

                bm.setMatchsGroup(true);
            }
            bm.setMatchsInfo("竞赛简介"+i);
            try {

                mm.createMatchs(bm);
            }catch (BaseException e){
                e.printStackTrace();}
        }



    }
}
