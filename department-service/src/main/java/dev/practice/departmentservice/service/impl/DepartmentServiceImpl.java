package dev.practice.departmentservice.service.impl;

import dev.practice.departmentservice.dto.DepartmentDto;
import dev.practice.departmentservice.entity.Department;
import dev.practice.departmentservice.exception.ResourceNotFoundException;
import dev.practice.departmentservice.mapper.DepartmentMapper;
import dev.practice.departmentservice.repository.DepartmentRepository;
import dev.practice.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        //Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return modelMapper.map(savedDepartment, DepartmentDto.class);
        //return DepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        if (department == null) {
            throw new ResourceNotFoundException("Department", "code", code);
        }
        return DepartmentMapper.MAPPER.mapToDepartmentDto(department);
    }
}
