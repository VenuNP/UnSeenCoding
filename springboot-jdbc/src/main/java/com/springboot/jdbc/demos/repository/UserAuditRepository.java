package com.springboot.jdbc.demos.repository;

import com.springboot.jdbc.demos.beans.AuditUser;
import com.springboot.jdbc.demos.entity.AuditUserEntity;
import com.springboot.jdbc.demos.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Repository
public class UserAuditRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public  void save(AuditUserEntity entity)
    {
        String sql = "insert into users_audit( name , city , " +
                "date_of_birth ,gender,married, " +
                "created_at, updated_at,audit_user_id, updated_user_id) values(?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(
                sql,
                entity.getName(),
                entity.getCity(),
                entity.getDateOfBirth(),
                entity.getGender(),
                entity.isMarried(),
                Timestamp.from(Instant.now()),
                Timestamp.from(Instant.now()),
                entity.getAuditUserId(),
                entity.getUpdatedUserId()
        );
    }


    public List<AuditUser> getUserAuditData(Integer userId)
    {
        String sql = "Select  ua.id,ua.name,ua.city,ua.date_of_birth,ua.gender,ua.married, ua.created_at, " +
                "                 ua.updated_at, (select name from users where id = ua.updated_user_id) as updatedBy " +
                "                 From Users u " +
                "                 join users_audit ua on (u.id = ua.audit_user_id) " +
                "                 where  u.id =  ? order by ua.updated_at asc";

        RowMapper<AuditUser> rowMapper = (rs, rowNum) ->{
            AuditUser auditUser = null;

            try{
                auditUser = MapperUtils.getAuditUserFromResultSet(rs);
            }catch (Exception exp)
            {
                exp.printStackTrace();
                throw  new RuntimeException(exp.getMessage());
            }

            return auditUser;
        };



        return jdbcTemplate.query(sql,rowMapper,userId);
    }
}
