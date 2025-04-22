package com.andymartinez1.employee_service.service;

import com.andymartinez1.employee_service.dto.APIResponseDTO;
import com.andymartinez1.employee_service.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    APIResponseDTO getEmployeeById(Long employeeId);

}
