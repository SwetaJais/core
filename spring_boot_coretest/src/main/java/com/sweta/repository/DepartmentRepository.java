package com.sweta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sweta.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	 Optional<Department> findById(Long id);

	Department findByDepartmentId(Long id);
}
