package dev.practice.employeeservice.service;

import dev.practice.employeeservice.dto.APIResponseDto;
import dev.practice.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
