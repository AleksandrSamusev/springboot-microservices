package dev.practice.organisationservice.dto;

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
    private Long id;
    @Schema(
            description = "organisation name"
    )
    private String organisationName;
    @Schema(
            description = "organisation description"
    )
    private String organisationDescription;
    @Schema(
            description = "organisation code"
    )
    private String organisationCode;
    @Schema(
            description = "organisation creation date"
    )
    private LocalDateTime organisationCreatedDate;
}
