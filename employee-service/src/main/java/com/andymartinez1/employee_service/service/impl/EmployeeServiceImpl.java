package com.andymartinez1.employee_service.service.impl;

import com.andymartinez1.employee_service.dto.APIResponseDTO;
import com.andymartinez1.employee_service.dto.DepartmentDTO;
import com.andymartinez1.employee_service.dto.EmployeeDTO;
import com.andymartinez1.employee_service.entity.Employee;
import com.andymartinez1.employee_service.mapper.EmployeeMapper;
import com.andymartinez1.employee_service.repository.EmployeeRepository;
import com.andymartinez1.employee_service.service.APIClient;
import com.andymartinez1.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private APIClient apiClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public APIResponseDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        EmployeeDTO employeeDTO = EmployeeMapper.mapToEmployeeDTO(employee);

        DepartmentDTO departmentDTO = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployee(employeeDTO);
        apiResponseDTO.setDepartment(departmentDTO);
        return apiResponseDTO;
    }

}
