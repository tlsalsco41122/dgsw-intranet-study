package com.dgsw.hs.kr.intranet.service;

import com.dgsw.hs.kr.intranet.domain.Employee;
import com.dgsw.hs.kr.intranet.domain.EmployeeRole;
import com.dgsw.hs.kr.intranet.dto.JoinRequest;
import com.dgsw.hs.kr.intranet.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Employee join(JoinRequest joinRequest) {
        return employeeRepository.save(Employee.builder()
                .empNo(joinRequest.getEmpNo())
                .password(passwordEncoder.encode(joinRequest.getPassword()))
                .name(joinRequest.getName())
                .role(EmployeeRole.STAFF)
                .build());
    }
}
