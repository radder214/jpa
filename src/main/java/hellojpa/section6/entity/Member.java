package hellojpa.section6.entity;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id; // Member 의 PK

    @Column(name = "USERNAME")
    private String name;

    // worst
    @Column(name = "TEAM_ID")
    private Long teamId;

    // best
    // 회원과 팀은 다대일(N:1) 관계(회원 = N, 팀 = 1)
    // Member 입장에서 annotation 작성
    @ManyToOne
    // MEMBER 'table' 의 team_id 컬럼과 매핑
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
        this.team.getMembers().add(this);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamId=" + teamId +
                ", team=" + team +
                '}';
    }
}