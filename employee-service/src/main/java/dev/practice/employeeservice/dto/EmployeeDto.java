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
        description = "Employee DTO model information"
)
public class EmployeeDto {
    @Schema(
            description = "Employee ID"
    )
    private Long id;
    @Schema(
            description = "Employee first name"
    )
    private String firstName;
    @Schema(
            description = "Employee last name"
    )
    private String lastName;
    @Schema(
            description = "Employee email"
    )
    private String email;
    @Schema(
            description = "Department code"
    )
    private String departmentCode;
    @Schema(
            description = "Organisation code"
    )
    private String organisationCode;
}
