package hellojpa.section3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//  CREATE TABLE MEMBER (
//      ID BIGINT NOT NULL,
//      NAME VARCHAR(255),
//      PRIMARY KEY (ID)
//  )
@Entity // JPA가 관리하는 class로 인식하게 해주는 annotataion
@Table(name = "MEMBER") // class 명과 Table 명이 다를 경우 사용
public class Member {
    @Id // JPA에게 얘가 PK라는 것을 알려준다.(데이터베이스 PK와 매핑)
    private Long id;
    @Column(name = "NAME") // 컬럼명과 필드명이 다를 경우 사용
    private String name;

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
}