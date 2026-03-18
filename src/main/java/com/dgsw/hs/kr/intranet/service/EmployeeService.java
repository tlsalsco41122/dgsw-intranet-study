package com.dgsw.hs.kr.intranet.service;

import com.dgsw.hs.kr.intranet.domain.Employee;
import com.dgsw.hs.kr.intranet.dto.JoinRequest;

public interface EmployeeService {
    Employee join(JoinRequest joinRequest);
}
