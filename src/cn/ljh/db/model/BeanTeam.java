package cn.ljh.db.model;

import java.util.Date;

public class BeanTeam {
	private String teamCode;
	private String teamName;
	private String teamNameEn;
	private Date creatTime;
	private int teamSize;
	private String note;
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamNameEn() {
		return teamNameEn;
	}
	public void setTeamNameEn(String teamNameEn) {
		this.teamNameEn = teamNameEn;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	

}
