package com.sweta.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Example of One to One Mapping

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String bookname;

@OneToOne(cascade = CascadeType.ALL) //cascade means whatever operation(i.e. insert,delete) done in book table that also gets reflected in author table
@JoinColumn(name="author_id") //either we can use @JoinColumn or mappedBy
@JsonManagedReference
private Author author;
}
