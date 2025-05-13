package cn.ljh.db.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.ljh.db.model.BeanCompetition;
import cn.ljh.db.model.BeanStudent;
import cn.ljh.db.util.BaseException;
import cn.ljh.db.util.BusinessException;
import cn.ljh.db.util.DBUtil;

public class StudentManager {
	public static BeanStudent currentStu = null;

	public List<BeanStudent> LodaAllStudent() throws BaseException{
		//全部学生信息加载
		List<BeanStudent> result = new ArrayList<BeanStudent>();
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "select * from student";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				BeanStudent std = new BeanStudent();
				std.setStuNum(rs.getString("stuNum"));
				std.setStuName(rs.getString("stuName"));
				std.setStuField(rs.getString("stuField"));
				std.setStuClass(rs.getString("stuClass"));
				std.setEntryYear(rs.getInt("entryYear"));
				std.setStuTel(rs.getString("stuTel"));
				std.setQq(rs.getString("qq"));
				std.setStumail(rs.getString("stumail"));
				std.setStuPwd(rs.getString("stuPwd"));
				result.add(std);
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

	public BeanStudent loadStudentByStuNum(String stuNum) throws BaseException{
		//根据学号查询学生信息
		BeanStudent result = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from student where stuNum = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, stuNum);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				result = new BeanStudent();
				result.setStuNum(rs.getString("stuNum"));
				result.setStuName(rs.getString("stuName"));
				result.setStuField(rs.getString("stuField"));
				result.setStuClass(rs.getString("stuClass"));
				result.setEntryYear(rs.getInt("entryYear"));
				result.setStuTel(rs.getString("stuTel"));
				result.setQq(rs.getString("qq"));
				result.setStumail(rs.getString("stumail"));
				result.setStuPwd(rs.getString("stuPwd"));
			}else {
				throw new BusinessException("学生不存在");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (conn != null) {
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

	public void createStudent(BeanStudent student) throws BaseException{
		//学生信息创建
		if(student.getStuNum().length()>20||student.getStuNum().equals("")||student.getStuNum()==null) {
			throw new BusinessException("学号必须为1-20字符");
		}
		if(student.getStuName().length()>10||student.getStuName().equals("")||student.getStuName()==null) {
			throw new BusinessException("姓名必须为1-10字符");
		}
		if(student.getStuField().length()>20||student.getStuField().equals("")||student.getStuField()==null) {
			throw new BusinessException("专业必须为1-20字符");
		}
		if(student.getStuClass().length()>20||student.getStuClass().equals("")||student.getStuClass()==null) {
			throw new BusinessException("班级必须为1-20字符");
		}
		if(student.getStuTel().length()!=11) {
			throw new BusinessException("必须为11位手机号");
		}
		if(student.getQq().length()>10||student.getQq().length()<6||student.getQq()==null) {
			throw new BusinessException("qq必须为6-10字符");
		}
		if(student.getStumail().length()>30||student.getStumail().equals("")||student.getStumail()==null) {
			throw new BusinessException("邮箱必须为1-30字符");
		}
		if(student.getStuPwd().length()>20||student.getStuPwd().equals("")||student.getStuPwd()==null) {
			throw new BusinessException("密码必须为1-20字符");
		}
		if (student.getEntryYear()==0){
			throw new BusinessException("入学年份不能为空");
		}
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select stuNum from student where stuNum = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, student.getStuNum());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				throw new BusinessException("学生已存在");
			}
			pst.close();
			rs.close();
			sql = "INSERT\r\n"
					+ "INTO student(stuNum,stuName,stuField,stuClass,entryYear,stuTel,qq,stumail,stuPwd)\r\n"
					+ "VALUES(?,?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, student.getStuNum());
			pst.setString(2, student.getStuName());
			pst.setString(3, student.getStuField());
			pst.setString(4, student.getStuClass());
			pst.setInt(5, student.getEntryYear());
			pst.setString(6, student.getStuTel());
			pst.setString(7, student.getQq());
			pst.setString(8, student.getStumail());
			pst.setString(9, student.getStuPwd());
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

	public void modifyStudent(BeanStudent student) throws BaseException {
		//学生信息修改

		if (student.getStuNum().length() > 20 || student.getStuNum().equals("") || student.getStuNum() == null) {
			throw new BusinessException("学号必须为1-20字符");
		}
		if (student.getStuName().length() > 10 || student.getStuName().equals("") || student.getStuName() == null) {
			throw new BusinessException("姓名必须为1-10字符");
		}
		if (student.getStuField().length() > 20 || student.getStuField().equals("") || student.getStuField() == null) {
			throw new BusinessException("专业必须为1-20字符");
		}
		if (student.getStuClass().length() > 20 || student.getStuClass().equals("") || student.getStuClass() == null) {
			throw new BusinessException("班级必须为1-20字符");
		}
		if (student.getStuTel().length() != 11) {
			throw new BusinessException("必须为11位手机号");
		}
		if (student.getQq().length() > 10 || student.getQq().length() < 6 || student.getQq() == null) {
			throw new BusinessException("qq必须为6-10字符");
		}
		if (student.getStumail().length() > 30 || student.getStumail().equals("") || student.getStumail() == null) {
			throw new BusinessException("邮箱必须为1-30字符");
		}

		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE student SET stuName=?,stuField=?,stuClass=?,entryYear=?,stuTel=?,qq=?,stumail=? WHERE stuNum=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, student.getStuName());
			pst.setString(2, student.getStuField());
			pst.setString(3, student.getStuClass());
			pst.setInt(4, student.getEntryYear());
			pst.setString(5, student.getStuTel());
			pst.setString(6, student.getQq());
			pst.setString(7, student.getStumail());
			pst.setString(8, student.getStuNum());
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}

			}
		}
	}

	public void deleteStudent(String stuNum) throws BaseException {
		//学生信息删除
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "DELETE FROM student WHERE stuNum=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, stuNum);
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new BusinessException("该学生已在队伍中！");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}


			}
		}
	}

	public List<BeanStudent> searchStudent(String Namekeyword,String NumKeyword) throws BaseException {
		List<BeanStudent> result = new ArrayList<BeanStudent>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from student where stuName like ? and stuNum like ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + Namekeyword + "%");
			pst.setString(2, "%" + NumKeyword + "%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				BeanStudent std = new BeanStudent();
				std.setStuNum(rs.getString("stuNum"));
				std.setStuName(rs.getString("stuName"));
				std.setStuField(rs.getString("stuField"));
				std.setStuClass(rs.getString("stuClass"));
				std.setEntryYear(rs.getInt("entryYear"));
				std.setStuTel(rs.getString("stuTel"));
				std.setQq(rs.getString("qq"));
				std.setStumail(rs.getString("stumail"));
				std.setStuPwd(rs.getString("stuPwd"));
				result.add(std);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

			if(conn!=null) {
				try {
					conn.close();
				}catch (SQLException e2){
					e2.printStackTrace();
				}
			}
		}
		return result;
	}

	public void modifyPwd(String stuNum,String newPwd) throws BaseException {
		if(newPwd.length() > 20 || newPwd.equals("") || newPwd == null){
			throw new BusinessException("密码必须为1-20字符");
		}
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE student SET stuPwd=? WHERE stuNum=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setString(2, stuNum);
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new BusinessException("修改密码失败");
		} finally {
			if (conn != null) {
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
