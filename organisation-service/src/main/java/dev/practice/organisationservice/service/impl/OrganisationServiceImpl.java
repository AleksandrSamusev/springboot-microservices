package dev.practice.organisationservice.service.impl;

import dev.practice.organisationservice.dto.OrganisationDto;
import dev.practice.organisationservice.entity.Organisation;
import dev.practice.organisationservice.mapper.OrganisationMapper;
import dev.practice.organisationservice.repository.OrganisationRepository;
import dev.practice.organisationservice.service.OrganisationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {

    private final OrganisationRepository organisationRepository;

    @Override
    public OrganisationDto saveOrganisation(OrganisationDto organisationDto) {
        Organisation savedOrganisation = organisationRepository.save(
                OrganisationMapper.mapToOrganisation(organisationDto));
        return OrganisationMapper.mapToOrganisationDto(savedOrganisation);
    }

    @Override
    public OrganisationDto getOrganisationByCode(String organisationCode) {
        return OrganisationMapper.mapToOrganisationDto(
                organisationRepository.findByOrganisationCode(organisationCode));
    }
}
