package com.springboot.jdbc.demos.service;

import com.springboot.jdbc.demos.beans.User;
import com.springboot.jdbc.demos.entity.AuditUserEntity;
import com.springboot.jdbc.demos.entity.UserEntity;
import com.springboot.jdbc.demos.exception.UserNotFoundException;
import com.springboot.jdbc.demos.repository.UserAuditRepository;
import com.springboot.jdbc.demos.repository.UserRepository;
import com.springboot.jdbc.demos.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAuditRepository userAuditRepository;

    @PostConstruct
    @Transactional(rollbackFor = Exception.class)
    public void init()
    {

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            String line = "";
            userRepository.getAll().stream().forEach(entity -> userRepository.delete(entity.getId()));
            while( (line = reader.readLine()) != null)
            {
                //1,Srinu,Hyderabad,1991-01-14,M,Y
                String[] userArray = line.split(",");
                UserEntity userEntity = UserEntity.builder().
                        id(Integer.valueOf(userArray[0]))
                        .name(userArray[1])
                        .city(userArray[2])
                        .gender(userArray[4])
                        .married(Integer.valueOf(userArray[5]) == 1 ? true:false)
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


                userRepository.save(userEntity);
                AuditUserEntity auditUser = MapperUtils.getAuditUserEntity(userEntity);
                auditUser.setUpdatedUserId(userEntity.getId());
                auditUser.setAuditUserId(userEntity.getId());
                userAuditRepository.save(auditUser);

            }
        }catch (Exception exp)
        {
            exp.printStackTrace();
            throw new RuntimeException(exp.getMessage());
        }

    }

    public User get(Integer userId) throws UserNotFoundException
    {
        return MapperUtils.getUserFromEntity(userRepository.get(userId));
    }

    public List<User> search(String city)
    {
        List<User> userList = new ArrayList<>();

        userRepository.search(city).stream().forEach(
                entity ->
                userList.add(MapperUtils.getUserFromEntity(entity))
        );

        return userList;
    }


    @Transactional(rollbackFor = Exception.class)
    public void update(User user,Integer updateUserId) throws UserNotFoundException
    {
        if(
               userRepository.isExists(user.getId())
                        .orElseThrow(() ->  new UserNotFoundException() )
        ) {
            userRepository.update(MapperUtils.getUserEntity(user));
            AuditUserEntity entity = MapperUtils.getAuditUserEntity(userRepository.get(user.getId()));
            entity.setUpdatedUserId(updateUserId);
            entity.setAuditUserId(user.getId());
            userAuditRepository.save(entity);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer userId) throws UserNotFoundException
    {
        if(
                userRepository.isExists(userId)
                .orElseThrow(() ->  new UserNotFoundException() )
        )
        {
            userRepository.delete(userId);
        }
    }


    public List<User> getAll()
    {
        List<User> userList = new ArrayList<>();
         userRepository.getAll().stream().forEach(entity ->
                 userList.add(MapperUtils.getUserFromEntity(entity)));
         return userList;
    }


}


