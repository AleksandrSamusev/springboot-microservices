package dev.practice.departmentservice.controller;

import dev.practice.departmentservice.dto.DepartmentDto;
import dev.practice.departmentservice.entity.Department;
import dev.practice.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Service - DepartmentController",
        description = "Department controller exposes REST APIs for Department Service"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;



    @Operation(
            summary = "Save Department REST API",
            description = "save department REST API is used to save department object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto>saveDepartment(@RequestBody  DepartmentDto departmentDto) {
        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get Department REST API",
            description = "Get department REST API is used to Get department object from a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode) {
        DepartmentDto dto = departmentService.getDepartmentByCode(departmentCode);
        return ResponseEntity.ok(dto);
    }



}
