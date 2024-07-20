package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.repository.BaseRepository;

@Service
public class BaseServices<T, ID> {

	private BaseRepository<T, ID> baseRepository;

	public List<T> findAll() {
		return baseRepository.findAll();
	}
	
	public T findById(ID id) {
		return baseRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
	}
	
	public T insert(T t ) {
		return baseRepository.save(t);
	}
	
	public T update(T t ) {
		return baseRepository.save(t);
	}
	
	public void deleteById(ID id) {
		baseRepository.deleteById(id);
	}

}
