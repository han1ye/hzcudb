package cn.ljh.db.model;

public class TeamMember {
	private String stuNum;
	private String teamCode;
	private boolean leader;
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public boolean isLeader() {
		return leader;
	}
	public void setLeader(boolean leader) {
		this.leader = leader;
	}
	

}
