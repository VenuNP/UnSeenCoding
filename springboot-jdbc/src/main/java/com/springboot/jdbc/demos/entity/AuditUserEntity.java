package com.springboot.jdbc.demos.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class AuditUserEntity implements Serializable {

    private Integer id;
    private String name;
    private String city;
    private LocalDate dateOfBirth;
    private String gender;
    private boolean married;
    private Timestamp cratedAt;
    private Timestamp updatedAt;
    private Integer auditUserId;
    private Integer updatedUserId;

}
