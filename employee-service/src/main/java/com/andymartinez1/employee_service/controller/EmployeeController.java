package com.andymartinez1.employee_service.controller;

import com.andymartinez1.employee_service.dto.APIResponseDTO;
import com.andymartinez1.employee_service.dto.EmployeeDTO;
import com.andymartinez1.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDTO> getEmployee(@PathVariable("id") Long employeeId) {
        APIResponseDTO apiResponseDTO = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }

}
