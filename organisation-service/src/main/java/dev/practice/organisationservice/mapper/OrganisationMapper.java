package dev.practice.organisationservice.mapper;

import dev.practice.organisationservice.dto.OrganisationDto;
import dev.practice.organisationservice.entity.Organisation;
import org.springframework.stereotype.Component;

@Component
public class OrganisationMapper {

    public static OrganisationDto mapToOrganisationDto(Organisation organisation) {
        return new OrganisationDto(
                organisation.getId(),
                organisation.getOrganisationName(),
                organisation.getOrganisationDescription(),
                organisation.getOrganisationCode(),
                organisation.getOrganisationCreatedDate()
        );
    }

    public static Organisation mapToOrganisation(OrganisationDto dto) {
        return new Organisation(
                dto.getId(),
                dto.getOrganisationName(),
                dto.getOrganisationDescription(),
                dto.getOrganisationCode(),
                dto.getOrganisationCreatedDate()
        );
    }
}
