package com.spring.jpa.springbootjpa.demos.utils;

import com.spring.jpa.springbootjpa.demos.beans.AuditUser;
import com.spring.jpa.springbootjpa.demos.beans.User;
import com.spring.jpa.springbootjpa.demos.entity.AuditUserEntity;
import com.spring.jpa.springbootjpa.demos.entity.UserEntity;

import java.sql.Timestamp;
import java.time.Instant;

public class MapperUtils {

    public static User getUserFromEntity(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .city(entity.getCity())
                .dateOfBirth(entity.getDateOfBirth())
                .married(entity.isMarried())
                .gender(entity.getGender())
                .build();
    }

    public static UserEntity getUserEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .city(user.getCity())
                .dateOfBirth(user.getDateOfBirth())
                .married(user.isMarried())
                .gender(user.getGender())
                .build();
    }

    public static AuditUserEntity getAuditUserEntity(UserEntity user) {
        return AuditUserEntity.builder()
                .name(user.getName())
                .city(user.getCity())
                .dateOfBirth(user.getDateOfBirth())
                .married(user.isMarried())
                .gender(user.getGender())
                .cratedAt(Timestamp.from(Instant.now()))
                .updatedAt(Timestamp.from(Instant.now()))
                .build();
    }


    public static AuditUser getAuditUserEntity(AuditUserEntity entity) {

        return AuditUser.builder()
                .id(entity.getId())
                .name(entity.getName())
                .city(entity.getCity())
                .dateOfBirth(entity.getDateOfBirth())
                .married(entity.isMarried())
                .gender(entity.getGender().charAt(0))
                .cratedAt(entity.getCratedAt())
                .updatedAt(entity.getUpdatedAt())
                .updatedBy("XX")
                .build();
    }


    public static AuditUser getAuditUser(Object[] objArr) {

        return AuditUser.builder()
                .id(Integer.valueOf(objArr[0] + ""))
                .name(objArr[1] + "")
                .updatedBy(objArr[2] + "")
                .build();
    }
}
