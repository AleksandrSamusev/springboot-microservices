package dev.practice.employeeservice.service.impl;

import dev.practice.employeeservice.dto.APIResponseDto;
import dev.practice.employeeservice.dto.DepartmentDto;
import dev.practice.employeeservice.dto.EmployeeDto;
import dev.practice.employeeservice.dto.OrganisationDto;
import dev.practice.employeeservice.entity.Employee;
import dev.practice.employeeservice.exception.ResourceNotFoundException;
import dev.practice.employeeservice.mapper.EmployeeMapper;
import dev.practice.employeeservice.mapper.EmployeeMapstructMapper;
import dev.practice.employeeservice.repository.EmployeeRepository;
import dev.practice.employeeservice.service.EmployeeService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    //private final APIClient apiClient;
    //private final RestTemplate restTemplate;
    private WebClient webClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = modelMapper.map(employeeDto, Employee.class);
        //Employee employee = EmployeeMapstructMapper.MAPPER.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
        //return EmployeeMapstructMapper.MAPPER.mapToEmployeeDto(savedEmployee);
    }

    @Override
    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getEmployeeById(Long employeeId) {

        LOGGER.info("Inside getEmployeeById() method");
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", employeeId));

/*        ResponseEntity<DepartmentDto> response = restTemplate.getForEntity(
                "http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
                DepartmentDto.class);
        DepartmentDto departmentDto = response.getBody();*/

        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        //DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        OrganisationDto organisationDto = webClient.get()
                .uri("http://localhost:8083/api/organisations/" + employee.getOrganisationCode())
                .retrieve()
                .bodyToMono(OrganisationDto.class)
                .block();

        //EmployeeDto employeeDto = EmployeeMapstructMapper.MAPPER.mapToEmployeeDto(employee);
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganisation(organisationDto);

        //return modelMapper.map(employee, EmployeeDto.class);
        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {
        LOGGER.info("Inside getDefaultDepartment() method");
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", employeeId));

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentName("R&D department");
        departmentDto.setDepartmentDescription("Research and Development Department");

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
