package com.sweta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sweta.entity.Author;
import com.sweta.entity.Book;
import com.sweta.entity.Department;
import com.sweta.repository.AuthorRepository;
import com.sweta.repository.BookRepository;
import com.sweta.repository.DepartmentRepository;
import com.sweta.service.AuthorService;


import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class Controller {
	

	//@Autowired
	//private DepartmentRepository departmentRepository;

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/come")
	public String welcome()
	{
		return "Happy for you";
	}
	
/*	@PostMapping("/departadd")
	public Department addDepartment(@RequestBody Author author)
	{
	//	return departmentRepository.save(department);
		return departmentService.addDepartmentWithAuthor(author);
		
	} */
	@PostMapping("/departadd")
	public ResponseEntity<?> addAuthor(@RequestBody Author author)
	{
		return new ResponseEntity<>(authorService.addDepartmentWithAuthor(author),HttpStatus.CREATED);
		
	} 
	@PostMapping("/add")
	public Book addBook(@RequestBody Book book )
	{
		return bookRepository.save(book);
		
	} 
	@GetMapping("/get")
	public List<Book> getAllBook()
	{
		return bookRepository.findAll();
		
	} 
	
	@GetMapping("/get/{id}")
	public Optional<Author> getAuthor(@PathVariable("id") Long id)
	{
		return authorRepository.findById(id);
		
	} 
	
	@GetMapping("/getbook/{name}")
	public  Optional<List<Book>> getBookByNameCustom(@PathVariable("name") String name) {
		return Optional.of(bookRepository.getBookByName(name));
		
	}
	
	//JPA Inbuilt Methods
	@GetMapping("/getByname/{bname}")
	public List<Book> getBookByName(@PathVariable("bname") String bname)
	{
		return bookRepository.findBybookname(bname);
		
	} 
	@GetMapping("/bookcontain/{bname}")
	public List<Book> getBookContains(@PathVariable("bname") String bname)
	{
		return bookRepository.findBybooknameContaining(bname);
		
	} 
	
	//not working as expected
	@GetMapping("/hasauthor")
	public List<Book> getBookHasAuthor()
	{
		return bookRepository.findByAuthorNotNull();
		
	} 
	
	@GetMapping("/authorname/{name}")
	public List<Book> getBookByAuthorName(@PathVariable("name") String name)
	{
		return bookRepository.findByAuthorName(name);
		
	} 
	
	@GetMapping("/bookandauthorname/{bname}/{aname}")
	public List<Book> getBookByBookAndAuthorName(@PathVariable("bname") String bname,@PathVariable("aname") String aname)
	{
		return bookRepository.findByBooknameAndAuthorName(bname, aname);
		
	} 

	@GetMapping("/bookorauthorname/{bname}/{aname}")
	public List<Book> getBookByBookOrAuthorName(@PathVariable("bname") String bname,@PathVariable("aname") String aname)
	{
		return bookRepository.findByBooknameOrAuthorName(bname, aname);
		
	} 

	
/*	@PostMapping("/addD")
	public Book addAuthor(@RequestBody  Department department )
	{
		return departmentRepository.save(department);
		
	} */
}
