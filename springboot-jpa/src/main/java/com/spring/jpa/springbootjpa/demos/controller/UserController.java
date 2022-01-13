package com.spring.jpa.springbootjpa.demos.controller;

import com.spring.jpa.springbootjpa.demos.beans.AuditUser;
import com.spring.jpa.springbootjpa.demos.beans.User;
import com.spring.jpa.springbootjpa.demos.exception.UserNotFoundException;
import com.spring.jpa.springbootjpa.demos.service.UserAuditService;
import com.spring.jpa.springbootjpa.demos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuditService userAuditService;

    private User user = null;

    @PostConstruct
    public void init() {

        String line = "1,SriForGeeks,Hyd-Aparna Zicon,1991-01-14,M,1";
        String[] userArray = line.split(",");
        user = User.builder().
                id(Integer.valueOf(userArray[0]))
                .name(userArray[1])
                .city(userArray[2])
                .gender(userArray[4])
                .married(Integer.valueOf(userArray[5]) == 1 ? true : false)
                .build();

        String[] dateOfBirt = userArray[3].split("-");
        user.setDateOfBirth(
                LocalDate.of(
                        Integer.valueOf(dateOfBirt[0]),
                        Integer.valueOf(dateOfBirt[1]),
                        Integer.valueOf(dateOfBirt[2])
                )
        );
        user.setUpdatedAt(Timestamp.from(Instant.now()));
    }


    public User get(Integer userId) throws UserNotFoundException {
        return userService.get(userId);
    }

    public List<User> search(String city) {
        return userService.search(city);
    }

    public void delete(Integer userId) throws UserNotFoundException {
        userService.delete(userId);
    }

    public List<AuditUser> getAudits(Integer userId) {
        return userAuditService.getUserAudits(userId);
    }

    public void update() throws UserNotFoundException {
        userService.update(user, 3);
    }

    public List<User> getAll() {
        return userService.getAll();
    }

    public List<AuditUser> getAuditsJQL(Integer userId) {
        return userAuditService.getAudits(userId);
    }
}
