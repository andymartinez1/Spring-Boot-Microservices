package com.andymartinez1.employee_service.mapper;

import com.andymartinez1.employee_service.dto.EmployeeDTO;
import com.andymartinez1.employee_service.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    // Map DepartmentDTO to Department entity
    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail()
        );
    }

}
