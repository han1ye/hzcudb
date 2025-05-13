package cn.ljh.db.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import cn.ljh.db.model.BeanSystemAdmin;
import cn.ljh.db.util.BaseException;
import cn.ljh.db.util.BusinessException;
import cn.ljh.db.util.DBUtil;

public class SystemAdminManager {
	public static BeanSystemAdmin currentAdmin = null;
	
	
	public BeanSystemAdmin loadAdmin(String AdminNum) throws BaseException{
		// 根据管理员Num载入管理员信息
		BeanSystemAdmin result = new BeanSystemAdmin();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from admin where adminNum = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, AdminNum);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				result.setAdminName(rs.getString("adminName"));
				result.setAdminNum(AdminNum);
				result.setAdminPwd(rs.getString("adminPwd"));
			}else {
				throw new BusinessException("账号不存在");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public void CreatAdmin(BeanSystemAdmin admin) throws BaseException{
		if(admin.getAdminName().length()>10||admin.getAdminName().equals("")||admin.getAdminName()==null) {
			throw new BusinessException("用户名必须为1-10字符");
		}
		if(admin.getAdminNum().length()>30||admin.getAdminNum().equals("")||admin.getAdminNum()==null) {
			throw new BusinessException("账号必须为1-20字符");
		}
		if(admin.getAdminPwd().length()>30||admin.getAdminPwd().equals("")||admin.getAdminPwd()==null) {
			throw new BusinessException("密码必须为1-20字符");
		}
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select adminNum from admin where adminNum = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getAdminNum());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				throw new BusinessException("账号已存在");
			}
			pst.close();
			rs.close();
			sql = "INSERT\r\n"
					+ "INTO admin(adminNum,adminName,adminPwd)\r\n"
					+ "VALUES(?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getAdminNum());
			pst.setString(2, admin.getAdminName());
			pst.setString(3, admin.getAdminPwd());
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
	}

	public void updateAdminPwd(String AdminNum, String newPwd) throws BaseException{
		if(newPwd.length()>20||newPwd.equals("")||newPwd==null) {
			throw new BusinessException("密码必须为1-20字符");
		}
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update admin set adminPwd = ? where adminNum = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setString(2, AdminNum);
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
	}

}
