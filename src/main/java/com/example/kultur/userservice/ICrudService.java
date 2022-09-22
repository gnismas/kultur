package com.example.kultur.userservice;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ICrudService<T,ID> {
    List<T> findAll();
    T save(T object);
    Optional<T> findById(ID id);
}