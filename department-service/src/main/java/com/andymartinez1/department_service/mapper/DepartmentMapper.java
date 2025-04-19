package com.andymartinez1.department_service.mapper;

import com.andymartinez1.department_service.dto.DepartmentDTO;
import com.andymartinez1.department_service.entity.Department;

public class DepartmentMapper {

    // Map Department entity to DepartmentDTO
    public static DepartmentDTO mapToEmployeeDTO(Department department) {
        return new DepartmentDTO(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    }

    // Map DepartmentDTO to Department entity
    public static Department mapToEmployee(DepartmentDTO departmentDTO) {
        return new Department(
                departmentDTO.getId(),
                departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescription(),
                departmentDTO.getDepartmentCode()
        );
    }

}
