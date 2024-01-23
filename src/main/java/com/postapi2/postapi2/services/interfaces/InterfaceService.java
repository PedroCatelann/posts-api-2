package com.postapi2.postapi2.services.interfaces;

import com.postapi2.postapi2.domain.User;

import java.util.List;

public interface InterfaceService<T> {
    List<T> findAll();
    T findById(Long id);
    T insert(T obj);
    T update(Long id, T obj);
    void delete(Long id);



}
