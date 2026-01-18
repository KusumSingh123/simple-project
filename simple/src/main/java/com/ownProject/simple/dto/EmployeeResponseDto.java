package com.ownProject.simple.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {
    private Long id;

    private String  name;

    private Double salary;

    private String designation;

    private String address;

}
