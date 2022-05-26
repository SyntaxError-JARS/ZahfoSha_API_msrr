package com.revature.zahfosha.util;

import java.io.IOException;
import java.util.List;

public interface Crudable<T> {

    // Create
    T create(T newObject);

    // Read
    List<T> findAll() throws IOException;

    T findById(String id);

    // Update
    public boolean update(T updatedObj);

    //Delete
    boolean delete(String id);

}
