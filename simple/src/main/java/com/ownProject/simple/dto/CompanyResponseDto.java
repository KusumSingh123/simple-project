package com.ownProject.simple.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponseDto {
    private Long id;

    private String name;

    private String location;

    private Double revenue;

    private LocalDate establishDate;

}
