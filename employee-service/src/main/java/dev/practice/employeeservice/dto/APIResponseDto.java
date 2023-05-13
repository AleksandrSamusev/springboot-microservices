package dev.practice.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "API response DTO model information"
)
public class APIResponseDto {
    @Schema(
            description = "Employee DTO "
    )
    private EmployeeDto employee;
    @Schema(
            description = "Department DTO "
    )
    private DepartmentDto department;
    @Schema(
            description = "Organisation DTO "
    )
    private OrganisationDto organisation;

}
