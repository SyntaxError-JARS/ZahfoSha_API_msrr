package com.revature.zahfosha.util.interfaces;

import com.revature.zahfosha.orders.OrdersModel;

import java.io.IOException;
import java.util.List;

public interface Crudable<T> {

    // Create
    T create(T newObject);

    // MVP - combo - make order, add comment for is substitutable, and favorite order
    OrdersModel createCustomOrder(OrdersModel newCustomOrder);

    // Read
    List<T> findAll() throws IOException;

    T findById(String id);

    // Update
    T update(T updatedObject);

    //Delete
    boolean delete(String id);

}
