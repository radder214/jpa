package hellojpa.section3;

import hellojpa.section3.entity.Member;
import jakarta.persistence.*;

public class Crud {

    public static void main(String[] args) {
        // EntityManagerFactory 생성
        // application 로딩 시점(was 가 올라오는 시점)에 딱 1개만 있어야 함(application 전체에서 공유)
        // 정확히는 DB 당 1개만 생성돼야 한다.
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        // EntityManagerFactory 에서 EntityManager 생성
        // 하나의 트랜잭션 단위의 작업을 할 때 EntityManager 를 반드시 만들어줘야 한다.
        // Thread(쓰레드) 간 공유 X, 하나의 트랜잭션 단위에서 사용 후 버려야 한다.
        // 사용자 요청이 올 때마다 계속 [ 생성 - 사용 - clsoe() ] 해줘야 한다.
        EntityManager em = emf.createEntityManager();

        // JPA 의 모든 데이터 변경은 트랜잭션 안에서 실행돼야 한다.
        EntityTransaction tx = em.getTransaction(); // 트랜잭션을 얻는다.
        tx.begin(); // DB 트랜잭션 시작

        try {
            // INSERT
            Member member = new Member();
            member.setId(1L);
            member.setName("helloA");// 저장
            em.persist(member);

            Member member2 = new Member();
            member2.setId(2L);
            member2.setName("helloB");
            em.persist(member2);

            Member member3 = new Member();
            member3.setId(3L);
            member3.setName("helloC");
            em.persist(member3);

            // UPDATE
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("helloJPA");
            /**
             * em.persist(findMember); 같은 코드 없어도 됨
             * why?
             * - JPA 를 통해서 Entity 를 가져오면 해당 Entity 는 JPA 가 관리를 한다.
             * - 트랜잭션이 커밋되는 시점에 해당 Entity 의 값이 변경 됐는지 안 됐는지 JPA 가 체크를 한다.
             * - 변경됐으면 트랜잭션이 커밋되기 직전에 UPDATE 쿼리를 만들어 날려버린 후 트랜잭션 커밋을 해버린다.
             */

            // DELETE
            Member findMember_delete = em.find(Member.class, 3L);
            em.remove(findMember_delete); // 삭제

            tx.commit(); // 커밋
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}