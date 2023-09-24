package com.spring.repository;

import com.spring.base.BaseRepository;
import com.spring.model.Department;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepartmentRepository extends BaseRepository<Department,Long> {
}
