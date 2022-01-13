package com.spring.jpa.springbootjpa.demos.service;

import com.spring.jpa.springbootjpa.demos.beans.User;
import com.spring.jpa.springbootjpa.demos.entity.AuditUserEntity;
import com.spring.jpa.springbootjpa.demos.entity.UserEntity;
import com.spring.jpa.springbootjpa.demos.exception.UserNotFoundException;
import com.spring.jpa.springbootjpa.demos.repository.UserAuditRepository;
import com.spring.jpa.springbootjpa.demos.repository.UserRepository;
import com.spring.jpa.springbootjpa.demos.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Autowired
    private UserAuditRepository userAuditRepository;

    @PostConstruct
    @Transactional(rollbackFor = Exception.class)
    public void init() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            String line = "";
            List<UserEntity> userEntities = new ArrayList<>();
            List<AuditUserEntity> userAuditEntities = new ArrayList<>();

            userRepository.findAll().stream().forEach(entity -> userRepository.deleteById(entity.getId()));
            while ((line = reader.readLine()) != null) {
                //1,Srinu,Hyderabad,1991-01-14,M,Y
                String[] userArray = line.split(",");
                UserEntity userEntity = UserEntity.builder().
                        id(Integer.valueOf(userArray[0]))
                        .name(userArray[1])
                        .city(userArray[2])
                        .gender(userArray[4])
                        .married(Integer.valueOf(userArray[5]) == 1 ? true : false)
                        .build();
                String[] dateOfBirt = userArray[3].split("-");
                userEntity.setDateOfBirth(
                        LocalDate.of(
                                Integer.valueOf(dateOfBirt[0]),
                                Integer.valueOf(dateOfBirt[1]),
                                Integer.valueOf(dateOfBirt[2])
                        )
                );
                userEntity.setCratedAt(
                        Timestamp.from(Instant.now())
                );
                userEntity.setUpdatedAt(
                        Timestamp.from(Instant.now())
                );


                userEntities.add(userEntity);
                AuditUserEntity auditUserEntity = MapperUtils.getAuditUserEntity(userEntity);
                auditUserEntity.setUpdatedUserId(userEntity.getId());
                auditUserEntity.setAuditUserId(userEntity.getId());
                userAuditEntities.add(auditUserEntity);

            }

            userRepository.saveAll(userEntities);
            userAuditRepository.saveAll(userAuditEntities);
        } catch (Exception exp) {
            exp.printStackTrace();
            throw new RuntimeException(exp.getMessage());
        }

    }

    public User get(Integer userId) throws UserNotFoundException {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId + " does not exist"));
        return MapperUtils.getUserFromEntity(userEntity);
    }

    public List<User> search(String city) {

        List<User> userList = new ArrayList<>();
        List<UserEntity> userEntitiesList =
                userRepository.findByCityIgnoreCaseLike(city).orElse(Collections.emptyList());

        userEntitiesList.stream().forEach(
                entity ->
                        userList.add(MapperUtils.getUserFromEntity(entity))
        );

        return userList;
    }


    @Transactional(rollbackFor = Exception.class)
    public void update(User user, Integer updateUserId) throws UserNotFoundException {
        UserEntity userEntity = userRepository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException(user.getId() + " Does not exist"));

        userRepository.save(MapperUtils.getUserEntity(user));
        AuditUserEntity entity = MapperUtils.getAuditUserEntity(userEntity);
        entity.setUpdatedUserId(updateUserId);
        entity.setAuditUserId(user.getId());
        userAuditRepository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer userId) throws UserNotFoundException {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId + " Does not exist"));
        userRepository.delete(userEntity);

    }


    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().stream().forEach(entity ->
                userList.add(MapperUtils.getUserFromEntity(entity)));
        return userList;
    }


}


