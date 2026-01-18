package com.ownProject.simple.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequestDto {
    private String name;

    private String location;

    private Double revenue;

    private LocalDate establishDate;

}
