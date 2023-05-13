package dev.practice.employeeservice.controller;

import dev.practice.employeeservice.dto.APIResponseDto;
import dev.practice.employeeservice.dto.EmployeeDto;
import dev.practice.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
@Tag(
        name = "Employee Service - EmployeeController",
        description = "Employee controller exposes REST APIs for Employee Service"
)
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(
            summary = "Save Employee REST API",
            description = "save employee REST API is used to save employee object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedDto = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Employee REST API",
            description = "Get employee REST API is used to Get employee object from a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{employeeId}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable Long employeeId) {
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(apiResponseDto);
    }
}
