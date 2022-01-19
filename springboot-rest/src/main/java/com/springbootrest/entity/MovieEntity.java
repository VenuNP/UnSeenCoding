package com.springbootrest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "MOVIES")
public class MovieEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(name = "CREATED_AT")
    private Timestamp cratedAt;
    @Column(name = "UPDATED_AT")
    private Timestamp updatedAt;

}
