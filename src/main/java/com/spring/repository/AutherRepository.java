package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.model.entity.Auther;

import jakarta.transaction.Transactional;

@Repository
public interface AutherRepository extends JpaRepository<Auther, Long> {

	/**
	 * @Transactional dafault is readOnly = true to open transactional for update
	 * add @Transactional to make readOnly = false 
	 */
	@Transactional
	@Modifying
	@Query(value = "update Auther auth set auth.name = :name where auth.id = :id")
	void updateName(String name, Long id);
	

}
