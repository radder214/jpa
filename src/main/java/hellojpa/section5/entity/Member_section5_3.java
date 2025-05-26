package hellojpa.section5.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
/**
 * 1. 회원은 일반 회원과 관리자로 구분해야 한다.
 * 2. 회원 가입일과 수정일이 있어야 한다.
 * 3. 회원을 설명할 수 있는 필드가 있어야 한다. 이 필드는 길이 제한이 없다
 */
@Entity
@Table(name = "MEMBERS")
public class Member_section5_3 {
    @Id
    private Long id;

    @Column(
        name             = "NAME",
        insertable       = true,
        updatable        = true,
        nullable         = false,
        unique           = true,
        length           = 10,
        columnDefinition = "varchar(100) default 'EMPTY'"
    )
    private String username;
    // name                  => 컬럼명
    // insertable, updatable => insert, update 가능 여부
    // nullable              => false 설정 시 NOT NULL 제약조건이 붙는다.(DDL 생성 시)
    // unique                => 컬럼에 unique 제약조건이 붙는다.
    // length                => varchar(10), String 타입에만 사용 가능
    // columnDefinition      => 컬럼 정보를 직접 설정할 수 있다.

    @Column(
        precision = 20, // 소수점을 포함한 전체 자릿수
        scale     = 2   // 소수의 자릿수
    )
    private BigDecimal age;
    // precision, scale => BigDecimal, BigInteger type 인 경우에만 사용 가능

    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    // @Enumerated      => DB에는 check 제약조건으로 생성
    // EnumType.STRING  => enum '이름'을 DB에 저장
    // EnumType.ORDINAL => enum '순서'를 DB에 저장(사용 X)

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    // TemporalType.DATE        --> 날짜
    // TemporalType.TIME        --> 시간
    // TemporalType.TIMESTAMP   --> 날짜와 시간
    // java.util.Date, java.util.Calendar 을 매핑할 때 사용

    private LocalDate localDate;
    private LocalDateTime localDateTime;
    // LocalDate, LocalDateTime(Java8~) 을 사용할 때는 @Temporal 생략 가능

    @Lob
    private String description;
    // varchar 를 넘어서는 큰 사이즈의 데이터
    // 필드 타입이 문자면 CLOB 으로 기본 생성, 나머지는 BLOB 으로 생성

    @Transient
    private int money;
    // 해당 필드는 컬럼과 매핑하지 않는다.(매핑 무시)
    // DB와 일절 관계가 없는 필드임을 명시

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}