package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.model.dto.ProjectProjection;
import com.spring.model.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByAutherId(Long id);

	/**
	 * Interface Projection
	 */
	@Query(value = "select\r\n" + "(select count(*) from books) as bookCount,\r\n"
			+ "(select count(*) from books )as autherCount", nativeQuery = true)
	ProjectProjection projectProjection();

	/**
	 * Constructor Projection select b.name from books b where b.auther_id is null
	 */
	@Query(value = "select new Book(book.name) from Book book where book.auther is null")
	List<Book> findNotHaveAuther();

	/**
	 * if i give FetchType.LAZY and want to be FetchType.EAGER in one custome
	 * service i give annotaion @EntityGraph give array of attributePaths of
	 * attribute i want to be Eager
	 */
	@EntityGraph(attributePaths = { "borrowers", "auther" })
	List<Book> findAll();

}
