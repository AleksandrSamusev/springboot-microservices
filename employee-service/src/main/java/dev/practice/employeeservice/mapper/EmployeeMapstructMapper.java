package dev.practice.employeeservice.mapper;

import dev.practice.employeeservice.dto.EmployeeDto;
import dev.practice.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapstructMapper {
    EmployeeMapstructMapper MAPPER = Mappers.getMapper(EmployeeMapstructMapper.class);

    EmployeeDto mapToEmployeeDto(Employee employee);

    Employee mapToEmployee(EmployeeDto employeeDto);
}
