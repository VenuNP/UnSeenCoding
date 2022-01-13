package com.spring.jpa.springbootjpa.demos.repository;

import com.spring.jpa.springbootjpa.demos.entity.AuditUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAuditRepository extends JpaRepository<AuditUserEntity, Integer> {


    Optional<List<AuditUserEntity>> findByAuditUserId(Integer id);


    @Query(value = "Select u.id, u.name, " +
            "(Select name from Users where id = ua.updated_user_id) updatedBy " +
            " From USERS u  " +
            " JOIN Users_Audit ua ON (u.id = ua.audit_user_id) " +
            " where ua.audit_user_Id = :id", nativeQuery = true)
    Optional<List<Object[]>> findAudits(int id);

}
