package com.ownProject.simple.service;

import com.ownProject.simple.dto.EmployeeRequestDto;
import com.ownProject.simple.dto.EmployeeResponseDto;

public interface EmployeeService {

    EmployeeResponseDto saveEmployee(EmployeeRequestDto employeeRequestDto);
    String deleteEmployeeById(Long employeeId);
}
