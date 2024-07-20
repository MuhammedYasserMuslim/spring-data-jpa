package com.spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.dto.ProjectProjection;
import com.spring.model.entity.Book;
import com.spring.service.BookService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/book")
@CrossOrigin("http://localhost:4200")
public class BookController {
	
	private BookService bookService;
	
	public BookController( BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Book> findAll() {
		return bookService.findAll();
	}
	
	@GetMapping("/book")
	@ResponseStatus(value = HttpStatus.OK)
	public Book findById(@RequestParam Long id) {
		return bookService.findById(id);
	}
	
	@GetMapping("/auther-id")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Book> findByAutherId(@RequestParam Long id) {
		return bookService.findByAutherId(id);
	}
	
	@GetMapping("/without-auther")
	@ResponseStatus(value = HttpStatus.OK)
	List<Book> findNotHaveAuther(){
		return bookService.findNotHaveAuther();
	}

	
	@GetMapping("/count")
	@ResponseStatus(value = HttpStatus.OK)
	public ProjectProjection projectProjection() {
		return bookService.projectProjection();
	}
	
	@PostMapping("/book")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Book insert(@RequestBody Book book){

		return bookService.insert(book);
	}
	
	@PutMapping("/book")
	@ResponseStatus(value = HttpStatus.OK)
	public Book update(@RequestBody Book book){
		return bookService.update(book);
	}
	
	@DeleteMapping("/book")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteById(@RequestParam Long id) {
		bookService.deleteById(id);
	}
}
