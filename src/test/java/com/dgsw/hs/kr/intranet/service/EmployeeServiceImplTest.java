package com.dgsw.hs.kr.intranet.service;

import com.dgsw.hs.kr.intranet.domain.Employee;
import com.dgsw.hs.kr.intranet.dto.JoinRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class EmployeeServiceImplTest {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("임직원 회원가입 및 비밀번호 암호화 테스트")
    void join() {
        // Given
        String rawPwd = "pwd12345";
        JoinRequest joinRequest = new JoinRequest();
        joinRequest.setEmpNo("12345");
        joinRequest.setName("홍길동");
        joinRequest.setPassword(rawPwd);

        // When
        Employee savedEmployee = employeeService.join(joinRequest);

        // Then
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getEmpNo()).isEqualTo("12345");
        assertThat(savedEmployee.getPassword()).isNotEqualTo(rawPwd);
        assertThat(passwordEncoder.matches(rawPwd, savedEmployee.getPassword())).isTrue();
    }
}