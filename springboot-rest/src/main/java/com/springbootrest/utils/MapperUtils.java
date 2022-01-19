package com.springbootrest.utils;

import com.springbootrest.dto.MovieDTO;
import com.springbootrest.entity.MovieEntity;

import java.sql.Timestamp;
import java.time.Instant;

public class MapperUtils {

    public static MovieDTO getDTO(MovieEntity entity) {
        return MovieDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .releaseDate(entity.getReleaseDate())
                .build();
    }

    public static MovieEntity getEntity(MovieDTO dto) {
        return MovieEntity.builder()
                .name(dto.getName())
                .releaseDate(dto.getReleaseDate())
                .updatedAt(Timestamp.from(Instant.now()))
                .cratedAt(Timestamp.from(Instant.now()))
                .build();
    }


    public static MovieEntity clone(MovieEntity entity, MovieDTO dto) {
        entity.setName(dto.getName());
        entity.setReleaseDate(dto.getReleaseDate());
        entity.setUpdatedAt(Timestamp.from(Instant.now()));
        return entity;
    }


}
