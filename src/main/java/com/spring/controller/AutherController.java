package com.spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.entity.Auther;
import com.spring.service.AutherService;



@RestController
@RequestMapping("/auther")
public class AutherController {
	
	private AutherService autherService;
	
	public AutherController( AutherService autherService) {
		this.autherService = autherService;
	}
	
	@GetMapping("/authers")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Auther> findAll() {
		return autherService.findAll();
	}
	
	@GetMapping("/auther")
	@ResponseStatus(value = HttpStatus.OK)
	public Auther findById(@RequestParam Long id) {
		return autherService.findById(id);
	}
	
	@PostMapping("/auther")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Auther insert(@RequestBody Auther auther){
		return autherService.insert(auther);
	}
	
	@PostMapping("/auther-name/{name}/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void updateName(@PathVariable String name ,@PathVariable Long id) {
		 autherService.updateName(name, id);
	}
	
	@PutMapping("/auther")
	@ResponseStatus(value = HttpStatus.OK)
	public Auther update(@RequestBody Auther auther){
		return autherService.update(auther);
	}
	
	@DeleteMapping("/auther")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteById(@RequestParam Long id) {
		autherService.deleteById(id);
	}
	
}
