package dev.practice.organisationservice.controller;

import dev.practice.organisationservice.dto.OrganisationDto;
import dev.practice.organisationservice.service.OrganisationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/organisations")
@Tag(
        name = "Organisation Service - OrganisationController",
        description = "Organisation controller exposes REST APIs for Organisation Service"
)
public class OrganisationController {

    private final OrganisationService organisationService;

    @Operation(
            summary = "Save Organisation REST API",
            description = "save organisation REST API is used to save organisation object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    ResponseEntity<OrganisationDto> saveOrganisation(@RequestBody OrganisationDto organisationDto) {
        OrganisationDto savedOrganisation = organisationService.saveOrganisation(organisationDto);
        return new ResponseEntity<>(savedOrganisation, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Organisation REST API",
            description = "Get organisation REST API is used to Get organisation object from a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{organisationCode}")
    ResponseEntity<OrganisationDto> getOrganisationByCode(@PathVariable String organisationCode) {
        return ResponseEntity.ok(organisationService.getOrganisationByCode(organisationCode));
    }
}
