package com.spring.jpa.springbootjpa.demos.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@Builder

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS_AUDIT")
public class AuditUserEntity implements Serializable {


    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CITY")
    private String city;
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "MARRIED")
    private boolean married;
    @Column(name = "CREATED_AT")
    private Timestamp cratedAt;
    @Column(name = "UPDATED_AT")
    private Timestamp updatedAt;

    @Column(name = "audit_user_id")
    private Integer auditUserId;
    @Column(name = "updated_user_id")
    private Integer updatedUserId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "audit_user_id", insertable = false, updatable = false)
    private UserEntity userAudit;


}
