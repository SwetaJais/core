package com.sweta.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweta.entity.Department;
import com.sweta.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department findDepartmentById(Long id)
	{
		return departmentRepository.findByDepartmentId(id);
		
	}

}
