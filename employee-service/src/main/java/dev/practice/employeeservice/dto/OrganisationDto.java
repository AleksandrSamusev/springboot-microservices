package dev.practice.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Organisation DTO model information"
)
public class OrganisationDto {
    @Schema(
            description = "Organisation ID"
    )
    private Long id;
    @Schema(
            description = "Organisation name"
    )
    private String organisationName;
    @Schema(
            description = "Organisation description"
    )
    private String organisationDescription;
    @Schema(
            description = "Organisation code"
    )
    private String organisationCode;
    @Schema(
            description = "Organisation creation date   "
    )
    private LocalDateTime organisationCreatedDate;
}
