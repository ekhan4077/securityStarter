package com.example.masaiSecurityApp.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.masaiSecurityApp.employee.Employee;
import com.example.masaiSecurityApp.employee.EmployeeDao;

@Service
public class MyUserDetailService implements UserDetailsService {

	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
			Optional<Employee> employee=employeeDao.findByUserName(username);
		
			if(employee.isEmpty()) {
		
				throw new UsernameNotFoundException("No User Exist with this username");
			}
			else {
		
				return new myUserDetail(employee.get());
			}
		
		}
	

}
