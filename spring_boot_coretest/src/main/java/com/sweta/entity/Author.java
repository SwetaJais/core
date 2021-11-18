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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

@OneToOne(cascade = CascadeType.ALL, mappedBy = "author") //cascade means whatever operation(i.e. insert,delete) done in book table that also gets reflected in author table
@JsonBackReference
private Book book; 


@ManyToMany(mappedBy ="authors" , cascade=CascadeType.ALL)
private Collection<Department> department=new ArrayList<>();

public void addDepartment(Department depart)
{
	this.department.add(depart);
}
}
