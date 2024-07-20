package com.spring.model.dto;

import org.springframework.beans.factory.annotation.Value;

public interface ProjectProjection {

	Long getBookCount();

	Long getAutherCount();
	
	@Value("#{target.bookCount + target.autherCount}")
	Long getCountAll();
}
