package com.ownProject.simple.service.impl;

import com.ownProject.simple.dto.EmployeeRequestDto;
import com.ownProject.simple.dto.EmployeeResponseDto;
import com.ownProject.simple.entity.Employee;
import com.ownProject.simple.repository.EmployeeRepo;
import com.ownProject.simple.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Override
    public EmployeeResponseDto saveEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee emp=new Employee();
        emp.setName(employeeRequestDto.getName());
        emp.setSalary(employeeRequestDto.getSalary());
        emp.setDesignation(employeeRequestDto.getDesignation());
        emp.setAddress(employeeRequestDto.getAddress());
        Employee savedEmployee=employeeRepo.save(emp);

        EmployeeResponseDto employeeResponseDto=new EmployeeResponseDto();

        employeeResponseDto.setId(savedEmployee.getId());
        employeeResponseDto.setName(savedEmployee.getName());
        employeeResponseDto.setSalary(savedEmployee.getSalary());
        employeeResponseDto.setDesignation(savedEmployee.getDesignation());
        employeeResponseDto.setAddress(savedEmployee.getAddress());

        return employeeResponseDto;

    }

    @Override
    public String deleteEmployeeById(Long employeeId) {
        Employee employee=employeeRepo.findById(employeeId)
                .orElseThrow(()->new RuntimeException("Employee not exist"));
        employeeRepo.delete(employee);
        return "Employee deleted successfully with id:"+employeeId;
    }

    public void name(){

    }
}
