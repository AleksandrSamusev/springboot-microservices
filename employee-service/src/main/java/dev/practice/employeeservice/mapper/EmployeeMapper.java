package dev.practice.employeeservice.mapper;

import dev.practice.employeeservice.dto.EmployeeDto;
import dev.practice.employeeservice.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganisationCode()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode(),
                employeeDto.getOrganisationCode()
        );
    }
}
