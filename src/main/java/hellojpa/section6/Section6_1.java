package hellojpa.section6;

import hellojpa.section6.entity.Member;
import hellojpa.section6.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Section6_1 {
    public static void main(String[] args) {
        EntityManagerFactory    emf = Persistence.createEntityManagerFactory("hello");
        EntityManager           em  = emf.createEntityManager();
        EntityTransaction       tx  = em.getTransaction();
        tx.begin();
        try {
            // ====================== worst ======================
            // 팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);
            // 회원 저장
            Member member = new Member();
            member.setName("member1");
            member.setTeamId(team.getId());
            em.persist(member);
            // 팀 조회
            Member  findMember  = em.find(Member.class, member.getId());
            Long    findTeamId  = findMember.getTeamId();
            Team    findTeam    = em.find(Team.class, findTeamId);
            System.out.println(findTeam);
            // ====================== best ======================
            // 팀 저장
            Team team2 = new Team();
            team2.setName("TeamB");
            em.persist(team2);
            // 회원 저장
            Member member2 = new Member();
            member2.setName("member2");
            member2.setTeam(team2);
            em.persist(member2);
            // 팀 조회
            Member  findMember2 = em.find(Member.class, member2.getId());
            Team    findTeam2   = findMember2.getTeam();
            System.out.println(findTeam2);

            // 연관관계 수정(TeamB --> TeamC 로 소속으로 변경하고 싶다.)
            // 새로운 팀 생성
            Team team3 = new Team();
            team3.setName("TeamC");
            em.persist(team3);
            // 팀 변경, 이렇게만 해주면 끝
            member2.setTeam(team3);
            
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}