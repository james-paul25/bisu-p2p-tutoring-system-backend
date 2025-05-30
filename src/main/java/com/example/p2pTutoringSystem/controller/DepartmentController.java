package com.example.p2pTutoringSystem.controller;

import com.example.p2pTutoringSystem.dto.AddDepartmentRequest;
import com.example.p2pTutoringSystem.entities.Department;
import com.example.p2pTutoringSystem.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController()
@RequestMapping("api/v1/departments")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<String> addDepartment(@RequestBody AddDepartmentRequest addDepartmentRequest) {
        String response = departmentService.addDepartment(addDepartmentRequest);
        if (response.equals("Department already exists")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/getAllDepartment")    
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
}
