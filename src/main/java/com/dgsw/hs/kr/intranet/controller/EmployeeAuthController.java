package com.dgsw.hs.kr.intranet.controller;

import com.dgsw.hs.kr.intranet.domain.Employee;
import com.dgsw.hs.kr.intranet.dto.EmployeeResponse;
import com.dgsw.hs.kr.intranet.dto.JoinRequest;
import com.dgsw.hs.kr.intranet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class EmployeeAuthController {
    private final EmployeeService employeeService;

    @PostMapping("/join")
    public ResponseEntity<EmployeeResponse> join(@RequestBody JoinRequest joinRequest) {
        Employee employee = employeeService.join(joinRequest);
        EmployeeResponse employeeResponse = new EmployeeResponse(
                employee.getId(),
                employee.getEmpNo(),
                employee.getName(),
                employee.getRole());

        return ResponseEntity.ok(employeeResponse);
    }
}
