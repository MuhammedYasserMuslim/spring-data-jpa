package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.model.dto.BookDto;
import com.spring.model.dto.ProjectProjection;
import com.spring.model.entity.Book;
import com.spring.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book findById(Long id) {
		return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
	}

	public List<Book> findByAutherId(Long id) {
		return bookRepository.findByAutherId(id);
	}

	public List<Book> findNotHaveAuther() {
		return bookRepository.findNotHaveAuther();
	}

	public ProjectProjection projectProjection() {
		return bookRepository.projectProjection();
	}

	public Book insert(Book book) {
		return bookRepository.save(book);
	}

	public Book update(Book book) {
		if (book.getId() != null)
			return bookRepository.save(book);
		else
			throw new RuntimeException("Not Fount");
	}

	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}

	private BookDto mapToDto(Book book) {
		BookDto dto = new BookDto(book.getId(), book.getName(), book.getAuther().getName());
		return dto;
	}

	private List<BookDto> mapToDto(List<Book> books) {
		List<BookDto> dtos = new ArrayList<>();
		for (Book book : books) {
			dtos.add(mapToDto(book));
		}
		return dtos;
	}

}
