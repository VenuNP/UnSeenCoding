package com.springboot.jdbc.demos.repository;

import com.springboot.jdbc.demos.entity.UserEntity;
import com.springboot.jdbc.demos.exception.UserNotFoundException;
import com.springboot.jdbc.demos.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public  void save(UserEntity entity)
    {
        String sql = "insert into users(id , name , city , " +
                "date_of_birth ,gender,married, " +
                "created_at, updated_at ) values(?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql,
                entity.getId(),
                entity.getName(),
                entity.getCity(),
                entity.getDateOfBirth(),
                entity.getGender(),
                entity.isMarried(),
                Timestamp.from(Instant.now()),
                Timestamp.from(Instant.now())
                );
    }

    public  void update(UserEntity entity)
    {
        String sql = "update users set name = ? , city = ?, " +
                "date_of_birth = ?,gender = ?, married = ?, " +
               " updated_at = ?  where id = ?";

        jdbcTemplate.update(sql,
                entity.getName(),
                entity.getCity(),
                entity.getDateOfBirth(),
                entity.getGender(),
                entity.isMarried(),
                Timestamp.from(Instant.now()),
                        entity.getId());
    }

    public UserEntity get(Integer id) throws UserNotFoundException
    {
        UserEntity userEntity = null;
        String sql = "Select id,name,city,date_of_birth,gender,married from users where id = ?";
        RowMapper<UserEntity> rowMapper = (rs,rowNum) ->
                MapperUtils.getUserEntityFromResultSet(rs);
        try {
            userEntity = jdbcTemplate.queryForObject(sql,rowMapper,id);
        }catch (IncorrectResultSizeDataAccessException exp) // Gives  if ID not found
        {
            throw new UserNotFoundException(exp.getMessage());
        }

        return userEntity;
    }

    public List<UserEntity> search(String city)
    {
        String sql = "Select id,name,city,date_of_birth,gender,married from users where  upper(city) like  ?";

        RowMapper<UserEntity> rowMapper = (rs,rowNum) ->
                MapperUtils.getUserEntityFromResultSet(rs);

        return jdbcTemplate.query(sql, rowMapper, "%"+city.trim().toUpperCase()+"%");
    }

    public void  delete(int id)
    {

        String sql = "Delete From Users where id = ?";
        jdbcTemplate.update(sql,id);
    }


    public Optional<Boolean> isExists(Integer userId)
    {
     try
     {
         get(userId);
     }catch (UserNotFoundException exp)
     {
         return  Optional.of(Boolean.FALSE);
     }
    return Optional.of(Boolean.TRUE);
    }


    public List<UserEntity> getAll()
    {
        List<UserEntity> userEntities = null;
        String sql = "Select id,name,city,date_of_birth,gender,married from users ";
        RowMapper<UserEntity> rowMapper = (rs,rowNum) ->
                MapperUtils.getUserEntityFromResultSet(rs);
            userEntities = jdbcTemplate.query(sql,rowMapper);

        return userEntities;
    }
}
