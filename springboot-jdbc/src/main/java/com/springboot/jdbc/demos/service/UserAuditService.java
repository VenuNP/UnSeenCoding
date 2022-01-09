package com.springboot.jdbc.demos.service;

import com.springboot.jdbc.demos.beans.AuditUser;
import com.springboot.jdbc.demos.repository.UserAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuditService {

    @Autowired
    private UserAuditRepository userAuditRepository;

    public List<AuditUser> getUserAudits(Integer userId)
    {
        return userAuditRepository.getUserAuditData(userId);
    }
}
