package com.initial.start.bookmyshow.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Theater {
    private String id;
    private String name;
    private String location;
    private Integer distance;
    private Integer price;

}
