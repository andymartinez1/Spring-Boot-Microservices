package com.andymartinez1.employee_service.service;

import com.andymartinez1.employee_service.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("/api/departments/{department-code}")
    DepartmentDTO getDepartmentByCode(@PathVariable("department-code") String departmentCode);


}
