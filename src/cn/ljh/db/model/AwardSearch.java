package cn.ljh.db.model;

import java.util.Date;

public class AwardSearch {
    BeanStudent student;
    AwardInfo awardInfo;
    BeanCompetition competition;
    BeanMatchs matchs;
    BeanTeam team;
    Date organizetime;

    public BeanTeam getTeam() {
        return team;
    }

    public void setTeam(BeanTeam team) {
        this.team = team;
    }

    public BeanStudent getStudent() {
        return student;
    }

    public void setStudent(BeanStudent student) {
        this.student = student;
    }


    public Date getOrganizetime() {
        return organizetime;
    }

    public void setOrganizetime(Date organizetime) {
        this.organizetime = organizetime;
    }

    public AwardInfo getAwardInfo() {
        return awardInfo;
    }

    public void setAwardInfo(AwardInfo awardInfo) {
        this.awardInfo = awardInfo;
    }

    public BeanCompetition getCompetition() {
        return competition;
    }

    public void setCompetition(BeanCompetition competition) {
        this.competition = competition;
    }

    public BeanMatchs getMatchs() {
        return matchs;
    }

    public void setMatchs(BeanMatchs matchs) {
        this.matchs = matchs;
    }
}
