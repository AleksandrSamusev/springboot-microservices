package dev.practice.organisationservice.service;

import dev.practice.organisationservice.dto.OrganisationDto;

public interface OrganisationService {
    OrganisationDto saveOrganisation(OrganisationDto organisationDto);
    OrganisationDto getOrganisationByCode(String organisationCode);
}
