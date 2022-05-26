package com.revature.zahfosha.util.interfaces;

import java.io.IOException;
import java.util.List;

public interface Crudable<T> {

    // Create
    T create(T newObject);

    // Read
    List<T> findAll() throws IOException;

    T findById(String id);

    // Update
    T update(T updatedObject);

    //Delete
    boolean delete(String id);

}
