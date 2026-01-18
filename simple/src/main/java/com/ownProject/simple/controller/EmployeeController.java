package com.ownProject.simple.controller;

import com.ownProject.simple.dto.EmployeeRequestDto;
import com.ownProject.simple.dto.EmployeeResponseDto;
import com.ownProject.simple.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/save")
    public EmployeeResponseDto saveEmployee(@RequestBody EmployeeRequestDto employeeRequestDto){
        return employeeService.saveEmployee(employeeRequestDto);
    }

    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployeeById(@PathVariable Long employeeId){
        return employeeService.deleteEmployeeById(employeeId);
    }

}
