package com.sweta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sweta.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

//	@Query(value = "Select b.bookname from Book b ,  Author r where r.id = b.author_id and  r.name=:an",nativeQuery = true)
	//public List<Book> getBookByName(@Param("an") String author);
	
	@Query("Select b from Book b where  b.bookname=:an")
	public List<Book> getBookByName(@Param("an") String bookname);

	List<Book> findBybookname(String bookname); // naming convention is like findByAttributename (Attribute name as defined in Class).
   
	List<Book> findBybooknameContaining(String bookname);
	
	List<Book> findByAuthorNotNull();
	
	List<Book> findByAuthorName(String name); //As author present in Book Class so use that and  added Author's attribute after that to create method.
  
	List<Book> findByBooknameAndAuthorName(String bookname,String Authorname);
	
	List<Book> findByBooknameOrAuthorName(String bookname,String Authorname);
}
