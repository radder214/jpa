package hellojpa.section5;

import hellojpa.section5.entity.Member_section5_4;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Section5_4 {
    public static void main(String[] args) {
        EntityManagerFactory    emf = Persistence.createEntityManagerFactory("hello");
        EntityManager           em  = emf.createEntityManager();
        EntityTransaction       tx  = em.getTransaction();
        tx.begin();
        try {
            Member_section5_4 member_section5_4 = new Member_section5_4();
            member_section5_4.setId("ID_A");
            member_section5_4.setUsername("ID_A");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}