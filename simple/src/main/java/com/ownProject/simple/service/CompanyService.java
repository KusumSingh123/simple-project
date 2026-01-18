package com.ownProject.simple.service;

import com.ownProject.simple.dto.CompanyRequestDto;
import com.ownProject.simple.dto.CompanyResponseDto;

import java.util.List;

public interface CompanyService {

    CompanyResponseDto saveCompany(CompanyRequestDto companyRequestDto);

    CompanyResponseDto findCompanyById(Long id);

    CompanyResponseDto updateCompany(Long id,CompanyRequestDto companyRequestDto);

    String deleteCompany(Long id);

    List<CompanyResponseDto> getAllCompanies();

}
