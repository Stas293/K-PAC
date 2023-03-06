package org.spring.app.dao;

import java.util.List;

public interface GenericDao<T> {
    List<T> findAll();

    T findById(Long id);

    Long save(T model);

    void delete(Long id);
}
