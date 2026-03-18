package com.dgsw.hs.kr.intranet.security;

import com.dgsw.hs.kr.intranet.domain.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class EmployeeDetails implements UserDetails {
    private final Employee employee;
    private final Collection<GrantedAuthority> authorities;

    public EmployeeDetails(Employee employee) {
        this.employee = employee;
        this.authorities = List.of(new SimpleGrantedAuthority(employee.getRole().getKey()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return employee.getEmpNo();
    }

    @Override
    public String getPassword() {
        return employee.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
