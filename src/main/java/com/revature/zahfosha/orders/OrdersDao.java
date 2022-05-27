package com.revature.zahfosha.orders;

import com.revature.zahfosha.util.interfaces.Crudable;

import java.io.IOException;
import java.util.List;

public class OrdersDao implements Crudable<OrdersModel> {

    // MVP - Make an order for a specific menu item
    @Override
    public OrdersModel create(OrdersModel newOrder) {
        return null;
    }

    // MVP - Add a comment to the order to request a change, if it is substitutable
    public OrdersModel createWithComment(OrdersModel newCommentOrder){
        return null;
    }

    // MVP - Favorite an order
    public OrdersModel createFavoriteOrder(OrdersModel newFavoriteOrder){
        return null;
    }

    // MVP - combo - make order, add comment for is substitutable, and favorite order
    public OrdersModel createCustomOrder(OrdersModel newCustomOrder){
        return null;
    }

    @Override
    public List<OrdersModel> findAll() throws IOException {
        return null;
    }

    // MVP - View past orders by date
    public OrdersModel findByDate(String orderDate){
        return null;
    }

    @Override
    public OrdersModel findById(String id) {
        return null;
    }

    @Override
    public OrdersModel update(OrdersModel updatedObject) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

}
