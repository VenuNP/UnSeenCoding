package com.springboot.jdbc.demos.utils;

import com.springboot.jdbc.demos.beans.AuditUser;
import com.springboot.jdbc.demos.beans.User;
import com.springboot.jdbc.demos.entity.AuditUserEntity;
import com.springboot.jdbc.demos.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

public class MapperUtils {

    public static User getUserFromEntity(UserEntity entity)
    {
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .city(entity.getCity())
                .dateOfBirth(entity.getDateOfBirth())
                .married(entity.isMarried())
                .gender(entity.getGender())
                .build();
    }

    public static UserEntity getUserEntity(User user)
    {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .city(user.getCity())
                .dateOfBirth(user.getDateOfBirth())
                .married(user.isMarried())
                .gender(user.getGender())
                .build();
    }

    public static AuditUserEntity getAuditUserEntity(UserEntity user)
    {
        return AuditUserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .city(user.getCity())
                .dateOfBirth(user.getDateOfBirth())
                .married(user.isMarried())
                .gender(user.getGender())
                .cratedAt(Timestamp.from(Instant.now()))
                .updatedAt(Timestamp.from(Instant.now()))
                .build();
    }

    public static AuditUser getAuditUserFromResultSet(ResultSet rs ) throws SQLException {
        return  AuditUser.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .city(rs.getString("city"))
                .dateOfBirth(rs.getDate("date_of_birth").toLocalDate())
                .married(rs.getBoolean("married"))
                .gender(rs.getString("gender").charAt(0))
                .cratedAt(rs.getTimestamp("created_at"))
                .updatedAt(rs.getTimestamp("updated_at"))
                .updatedBy(rs.getString("updatedBy"))
                .build();
    }

    public static UserEntity getUserEntityFromResultSet(ResultSet rs ) throws SQLException {
        return   UserEntity.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .city(rs.getString("city"))
                .dateOfBirth(rs.getDate("date_of_birth").toLocalDate())
                .married(rs.getBoolean("married"))
                .gender(rs.getString("gender"))
                .build();
    }
}
