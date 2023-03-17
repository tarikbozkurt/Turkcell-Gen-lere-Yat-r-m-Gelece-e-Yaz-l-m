package org.example.repository.GenericRepositories;

import org.example.entity.BaseEntity.BaseEntity;

import java.util.List;

public interface GenericRepository  <T extends BaseEntity<PK>, PK extends Object> {


    T getById(PK id);

    void create(T entity);
    void update(T entity);
    void delete(T entity);

    List<T> getAll();
}
