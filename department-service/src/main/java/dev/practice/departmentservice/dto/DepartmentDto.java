package dev.practice.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "Department DTO model information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    @Schema(
            description = "department name"
    )
    private String departmentName;

    @Schema(
            description = "department description"
    )
    private String departmentDescription;

    @Schema(
            description = "department code"
    )
    private String departmentCode;
}
