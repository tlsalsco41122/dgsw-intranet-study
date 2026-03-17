package com.dgsw.hs.kr.intranet.repository;

import com.dgsw.hs.kr.intranet.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmpNo(String empNo);
}
