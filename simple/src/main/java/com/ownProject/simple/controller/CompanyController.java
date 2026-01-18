package com.ownProject.simple.controller;


import com.ownProject.simple.dto.CompanyRequestDto;
import com.ownProject.simple.dto.CompanyResponseDto;
import com.ownProject.simple.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/save")
    public CompanyResponseDto saveCompany(@RequestBody CompanyRequestDto companyRequestDto) {
        return companyService.saveCompany(companyRequestDto);

    }

    @GetMapping("/{id}")
    public CompanyResponseDto findCompanyById(@PathVariable Long id){
        return companyService.findCompanyById(id);
    }


    @PutMapping("/{id}")
    public CompanyResponseDto updateCompany(@PathVariable Long id,@RequestBody CompanyRequestDto companyRequestDto){
        return companyService.updateCompany(id,companyRequestDto);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable Long id){
        return companyService.deleteCompany(id);

    }

    @GetMapping("/all")
    public List<CompanyResponseDto> getAllCompanies(){
        return companyService.getAllCompanies();
    }


}
