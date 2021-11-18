package com.sweta.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Example of Many to Many Mapping
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	private String dname;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "author_department",
	joinColumns = @JoinColumn(name = "department_id",
	                           referencedColumnName = "departmentId")
	,
	inverseJoinColumns = @JoinColumn(name = "author_id",
	                                 referencedColumnName = "id")
	)
	@JsonIgnore
	private Collection<Author> authors = new ArrayList<>();
	
	
}


//Sample data insert using Postman, but one condition department should be present in table
/*{
    "name":"Ali",
    "department":[{
        "departmentId" :"1"
        }]
}*/