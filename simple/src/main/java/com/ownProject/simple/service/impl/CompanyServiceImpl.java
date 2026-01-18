package com.ownProject.simple.service.impl;

import com.ownProject.simple.dto.CompanyRequestDto;
import com.ownProject.simple.dto.CompanyResponseDto;
import com.ownProject.simple.entity.Company;
import com.ownProject.simple.repository.CompanyRepo;
import com.ownProject.simple.repository.EmployeeRepo;
import com.ownProject.simple.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;
    private final EmployeeRepo employeeRepo;


    @Override

    public CompanyResponseDto saveCompany(CompanyRequestDto companyRequestDto) {
        Company company = new Company();
        company.setName(companyRequestDto.getName());
        company.setLocation(companyRequestDto.getLocation());
        company.setRevenue(companyRequestDto.getRevenue());
        company.setEstablishDate(LocalDate.now());
        Company savedCompany=companyRepo.save(company);
        return companyEntityToResponseDto(savedCompany);


    }

    @Override
    public CompanyResponseDto findCompanyById(Long id) {
        Company company = companyRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Company Not Found"));
        return companyEntityToResponseDto(company);
    }

    @Override
    public CompanyResponseDto updateCompany(Long id, CompanyRequestDto companyRequestDto) {
        Company company = companyRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Company Not Found"));
        company.setName(companyRequestDto.getName());
        company.setLocation(companyRequestDto.getLocation());
        company.setRevenue(companyRequestDto.getRevenue());
        company.setEstablishDate(companyRequestDto.getEstablishDate());
       Company updatedCompany= companyRepo.save(company);
       return companyEntityToResponseDto(updatedCompany);

    }

    @Override
    public String deleteCompany(Long id) {
        Company company=companyRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Id is not found"));
        companyRepo.delete(company);
        return "Company deleted successfully";
    }

    @Override
    public List<CompanyResponseDto> getAllCompanies() {
        List<Company> companies = companyRepo.findAll();
//        List<CompanyResponseDto> companyResponseDtoList=new ArrayList<>();
//
//        for(Company company:companies){
////            companyResponseDtoList.add(companyEntityToResponseDto(company));
//            CompanyResponseDto responseDto=companyEntityToResponseDto(company);
//            companyResponseDtoList.add(responseDto);
//
//        }
//        return companyResponseDtoList;
        return companies
                .stream()
                .map(company -> companyEntityToResponseDto(company))
                .toList();

    }

    private CompanyResponseDto companyEntityToResponseDto(Company company){

        CompanyResponseDto companyResponseDto = new CompanyResponseDto();
        companyResponseDto.setId(company.getId());
        companyResponseDto.setName(company.getName());
        companyResponseDto.setLocation(company.getLocation());
        companyResponseDto.setRevenue(company.getRevenue());
        companyResponseDto.setEstablishDate(company.getEstablishDate());
        return companyResponseDto;

    }
}
