package com.andymartinez1.employee_service.service.impl;

import com.andymartinez1.employee_service.dto.APIResponseDTO;
import com.andymartinez1.employee_service.dto.DepartmentDTO;
import com.andymartinez1.employee_service.dto.EmployeeDTO;
import com.andymartinez1.employee_service.entity.Employee;
import com.andymartinez1.employee_service.mapper.EmployeeMapper;
import com.andymartinez1.employee_service.repository.EmployeeRepository;
import com.andymartinez1.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private WebClient webClient;

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

        DepartmentDTO departmentDTO = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .block();

        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployee(employeeDTO);
        apiResponseDTO.setDepartment(departmentDTO);
        return apiResponseDTO;
    }

}
