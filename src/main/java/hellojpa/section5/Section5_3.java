package hellojpa.section5;

import hellojpa.section5.entity.Member_section5_3;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Section5_3 {
    public static void main(String[] args) {
        EntityManagerFactory    emf = Persistence.createEntityManagerFactory("hello");
        EntityManager           em = emf.createEntityManager();
        EntityTransaction       tx = em.getTransaction();
        tx.begin();

        Member_section5_3 member_section5_3 = new Member_section5_3();
        try {
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
