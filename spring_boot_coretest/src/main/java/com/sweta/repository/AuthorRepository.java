package com.sweta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweta.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
