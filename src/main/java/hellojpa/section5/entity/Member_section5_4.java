package hellojpa.section5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MEMBER")
public class Member_section5_4 {
    @Id // 이것만 쓰면 내가 직접 ID 값을 할당해줘야 한다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "NAME", nullable = false)
    private String username;

    public Member_section5_4() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
