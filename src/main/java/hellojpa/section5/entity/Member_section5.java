package hellojpa.section5.entity;

import jakarta.persistence.*;

@Entity
// 유니크 제약조건 추가
@Table(
    name = "MEMBER",
    uniqueConstraints = {
        @UniqueConstraint(name = "NAME_AGE_UNIQUE"  , columnNames = {"NAME", "AGE"}),
        @UniqueConstraint(name = "ID_NAME_UNIQUE"   , columnNames = {"ID", "NAME"}),
        @UniqueConstraint(name = "ID_AGE_UNIQUE"    , columnNames = {"ID", "AGE"})
    }
)
public class Member_section5 {
    @Id
    private Long id;
    // unique & null 허용 (X) & 10자 초과 (X)
    @Column(name = "NAME", unique = true, nullable = false, length = 10)
    private String name;
    @Column(name = "AGE", unique = false, nullable = false, length = 3)
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}