package hellojpa.section4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//  CREATE TABLE MEMBER (
//      ID BIGINT NOT NULL,
//      NAME VARCHAR(255),
//      PRIMARY KEY (ID)
//  )
@Entity
@Table(name = "MEMBER")
public class Member_section4 {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
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