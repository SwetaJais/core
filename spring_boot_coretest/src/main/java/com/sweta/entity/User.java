package com.sweta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@Column(nullable = false, length = 20)
		private String name;
		private String address;
		@Column(nullable = false, length = 9)
		private int phoneno;
		private String gender;
		 @Column(nullable = false, unique = true, length = 45)
		private String email;
		@Column(nullable = false, length = 64)
		private String password;
		private String joiningdate;
		private String dob;
		private int deleteflag=0;
		
		
}
