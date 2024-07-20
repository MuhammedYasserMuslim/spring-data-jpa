package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.model.dto.AutherDto;
import com.spring.model.entity.Auther;
import com.spring.repository.AutherRepository;

@Service
public class AutherService {

	private AutherRepository autherRepository;

	public AutherService(AutherRepository autherRepository) {
		this.autherRepository = autherRepository;
	}

	public List<Auther> findAll() {
		return autherRepository.findAll();
	}

	public Auther findById(Long id) {
		return autherRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
	}

	public Auther insert(Auther auther) {
		if (auther.getId() == null)
			return autherRepository.save(auther);
		else
			throw new RuntimeException("Cannot insert this record with id " + auther.getId());
	}

	public Auther update(Auther auther) {
		if (auther.getId() != null)
			return autherRepository.save(auther);
		else
			throw new RuntimeException("Not Fount");
	}

	public void updateName(String name, Long id) {
		if (autherRepository.findById(id).isPresent())
			autherRepository.updateName(name, id);
		else
			throw new RuntimeException("Not Fount");

	}

	public void deleteById(Long id) {
		autherRepository.deleteById(id);
	}

	private AutherDto mapToDto(Auther auther) {
		AutherDto dto = new AutherDto(auther.getId(), auther.getName());
		return dto;
	}

}
