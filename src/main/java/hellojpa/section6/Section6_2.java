package hellojpa.section6;

import hellojpa.section6.entity.Member;
import hellojpa.section6.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Section6_2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.setTeam(team);
            em.persist(member);

            // 아래 2줄의 코드가 있어야 member.getId()로 DB 에서 값을 가져올 수 있다.
            em.flush();
            em.clear();

            // Member -> Team, Team -> Member 로 자유롭게 조회한다.
            // 이게 바로 양방향 연관관계
            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();
            for(Member m : members) {
                System.out.println(m);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}