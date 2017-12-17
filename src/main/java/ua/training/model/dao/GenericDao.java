package ua.training.model.dao;

import java.util.Set;

public interface GenericDao<T> extends AutoCloseable{
    void create (T entity);
    T findById(int id);
    Set<T> findAll();
    void update(T entity);
    void delete(int id);
}
