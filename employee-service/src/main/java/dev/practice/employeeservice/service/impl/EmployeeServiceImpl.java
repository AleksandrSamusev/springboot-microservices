package dev.practice.employeeservice.service.impl;

import dev.practice.employeeservice.dto.EmployeeDto;
import dev.practice.employeeservice.entity.Employee;
import dev.practice.employeeservice.exception.ResourceNotFoundException;
import dev.practice.employeeservice.mapper.EmployeeMapper;
import dev.practice.employeeservice.repository.EmployeeRepository;
import dev.practice.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        //Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        //return modelMapper.map(savedEmployee, EmployeeDto.class);
        return EmployeeMapper.MAPPER.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", employeeId));

        //return modelMapper.map(employee, EmployeeDto.class);
        return EmployeeMapper.MAPPER.mapToEmployeeDto(employee);
    }
}
