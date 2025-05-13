package cn.ljh.db.model;

import java.util.Date;

public class BeanCompetition {
	private String compNum;
	private String matchsCode;
	private Date organizeTime;
	private String organizeArea;
	private String compName;
	public String getCompNum() {
		return compNum;
	}
	public void setCompNum(String compNum) {
		this.compNum = compNum;
	}
	public String getMatchsCode() {
		return matchsCode;
	}
	public void setMatchsCode(String matchsCode) {
		this.matchsCode = matchsCode;
	}
	public Date getOrganizeTime() {
		return organizeTime;
	}
	public void setOrganizeTime(Date organizeTime) {
		this.organizeTime = organizeTime;
	}
	public String getOrganizeArea() {
		return organizeArea;
	}
	public void setOrganizeArea(String organizeArea) {
		this.organizeArea = organizeArea;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	

}
