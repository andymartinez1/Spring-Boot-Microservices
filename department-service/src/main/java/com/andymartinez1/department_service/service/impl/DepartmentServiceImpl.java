package com.andymartinez1.department_service.service.impl;

import com.andymartinez1.department_service.dto.DepartmentDTO;
import com.andymartinez1.department_service.entity.Department;
import com.andymartinez1.department_service.mapper.DepartmentMapper;
import com.andymartinez1.department_service.repository.DepartmentRepository;
import com.andymartinez1.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        Department department = DepartmentMapper.mapToEmployee(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToEmployeeDTO(savedDepartment);
    }

}
