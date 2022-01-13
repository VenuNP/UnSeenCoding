package com.spring.jpa.springbootjpa.demos.service;

import com.spring.jpa.springbootjpa.demos.beans.AuditUser;
import com.spring.jpa.springbootjpa.demos.entity.AuditUserEntity;
import com.spring.jpa.springbootjpa.demos.repository.UserAuditRepository;
import com.spring.jpa.springbootjpa.demos.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserAuditService {

    @Autowired
    private UserAuditRepository userAuditRepository;

    public List<AuditUser> getUserAudits(Integer userId) {
        List<AuditUser> auditUsers = new ArrayList<>();
        List<AuditUserEntity> auditUserEntities =
                userAuditRepository.findByAuditUserId(userId).orElse(Collections.emptyList());
        auditUserEntities.stream().forEach(entity ->
                auditUsers.add(MapperUtils.getAuditUserEntity(entity))
        );

        return auditUsers;
    }


    public List<AuditUser> getAudits(Integer userId) {
        List<AuditUser> auditUsers = new ArrayList<>();
        List<Object[]> auditUserEntities =
                userAuditRepository.findAudits(userId).orElse(Collections.emptyList());
        auditUserEntities.stream().forEach(objArr ->
                auditUsers.add(MapperUtils.getAuditUser(objArr))
        );

        return auditUsers;
    }
}
