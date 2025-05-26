package hellojpa.section3;

import hellojpa.section3.entity.Member_JPQL;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Jpql {
    public static void main(String[] args) {
        EntityManagerFactory    emf = Persistence.createEntityManagerFactory("hello");
        EntityManager           em = emf.createEntityManager();
        EntityTransaction       tx = em.getTransaction();
        tx.begin();
        try {
            /**
             * createQuery 관련 메모
             * JPA 는 DB '테이블'을 대상으로 절대 코드를 짜지 않는다.
             * createQuery 에서 작성한 SQL 은 Member_JPQL '객체'에 대해서 날리는 SQL 이다.
             * JPQL = 객체를 대상으로 하는 객체 지향 쿼리
             */
            List<Member_JPQL> resultList = em
                                            .createQuery("SELECT M FROM Member_JPQL AS M", Member_JPQL.class) // FROM Member_JPQL --> class 이름과 대소문자까지 정확히 일치해야 함
                                            .getResultList();
            for(Member_JPQL member_jpql : resultList) {
                System.out.println("ID : " + member_jpql.getId());
                System.out.println("NAME : " + member_jpql.getName());
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