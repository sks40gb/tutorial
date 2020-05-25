package com.sun.jpa.hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class CourseInfoDto {
    private Long id;
    private String name;
    private String review;

}
