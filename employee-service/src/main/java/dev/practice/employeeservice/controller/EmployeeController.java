package dev.practice.employeeservice.controller;

import dev.practice.employeeservice.dto.APIResponseDto;
import dev.practice.employeeservice.dto.EmployeeDto;
import dev.practice.employeeservice.entity.Employee;
import dev.practice.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto>saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedDto = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<APIResponseDto>getEmployeeById(@PathVariable Long employeeId) {
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(apiResponseDto);
    }
}
