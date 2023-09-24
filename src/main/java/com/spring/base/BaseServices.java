package com.spring.base;

import javax.persistence.MappedSuperclass;
import java.util.List;
import java.util.Optional;


@MappedSuperclass
public class BaseServices<T, ID> {


    private BaseRepository<T, ID> baseRepository;

    public Long count() {
        return baseRepository.count();

    }

    public List<T> findAll() {
        return baseRepository.findAll();
    }

    public Optional<T> findById(ID id) {
        return baseRepository.findById(id);
    }

    public void insert(T t) {
        baseRepository.save(t);
    }

    public void update(T t) {
        baseRepository.save(t);
    }

    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }


}
