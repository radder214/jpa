package hellojpa.section4;

import hellojpa.section4.entity.Member_section4;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Section4_1 {
    public static void main(String[] args) {
        EntityManagerFactory    emf = Persistence.createEntityManagerFactory("hello");
        EntityManager           em = emf.createEntityManager();
        EntityTransaction       tx = em.getTransaction();
        tx.begin();
        try {
            // 비영속
            Member_section4 memberSection4 = new Member_section4();
            memberSection4.setId(3L);
            memberSection4.setName("helloC");
            // 영속 - EntityManager 안의 영속성 컨텍스트를 통해 entity 가 관리된다.
            em.persist(memberSection4); // 이때 DB에 저장되는게 아니다.
            // 준영속 - member 엔티티를 영속성 컨텍스트에서 분리
            em.detach(memberSection4);
            // 삭제
            em.remove(memberSection4);
            tx.commit(); // 이때 실제로 DB에 저장되는 것이다.(이때 DB에 쿼리가 날라간다.)
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}