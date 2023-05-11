package dev.practice.employeeservice.service.impl;

import dev.practice.employeeservice.dto.APIResponseDto;
import dev.practice.employeeservice.dto.DepartmentDto;
import dev.practice.employeeservice.dto.EmployeeDto;
import dev.practice.employeeservice.entity.Employee;
import dev.practice.employeeservice.exception.ResourceNotFoundException;
import dev.practice.employeeservice.mapper.EmployeeMapper;
import dev.practice.employeeservice.repository.EmployeeRepository;
import dev.practice.employeeservice.service.APIClient;
import dev.practice.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final APIClient apiClient;
    //private final RestTemplate restTemplate;
    //private WebClient webClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = modelMapper.map(employeeDto, Employee.class);
        //Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
        //return EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", employeeId));

/*        ResponseEntity<DepartmentDto> response = restTemplate.getForEntity(
                "http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
                DepartmentDto.class);
        DepartmentDto departmentDto = response.getBody();*/

        /*DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();*/

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

       EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        //return modelMapper.map(employee, EmployeeDto.class);
        return apiResponseDto;
    }
}
