package com.sweta.service;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweta.entity.Author;
import com.sweta.entity.Department;
import com.sweta.repository.AuthorRepository;


@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	DepartmentService departmentService;

	public Author addDepartmentWithAuthor(Author author) {
		Author newAuthor = new Author();
		newAuthor.setName(author.getName());
		newAuthor.getDepartment().addAll(author.getDepartment()
				.stream().map(
						depart-> {
			Department  dept = departmentService.findDepartmentById(depart.getDepartmentId());				
				dept.getAuthors().add(newAuthor);
				return dept;
			
		}).collect(Collectors.toList()));	
		return authorRepository.save(newAuthor);
	}


}
