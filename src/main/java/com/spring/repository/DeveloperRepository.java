package com.spring.repository;

import com.spring.model.Developer;
import com.spring.base.BaseRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DeveloperRepository extends BaseRepository<Developer,Long> {
}
