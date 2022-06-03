package com.revature.zahfosha.orders;

import com.revature.zahfosha.util.exceptions.InvalidRequestException;

public class OrdersServices {

    private OrdersDao oDao;

    public OrdersServices(OrdersDao oDao) {
        this.oDao = oDao;
    }

    public OrdersModel create(OrdersModel newOrder){
        if(!validateInput(newOrder)){
            throw new InvalidRequestException("User input invalid. Order must have words for menu item, a new integer for id, comment can be nothing, is favorite must be 1 for true and 0 for false, a valid order date, and your correct customer username");
        }
        OrdersModel persistedOrder = oDao.createCustomOrder(newOrder);

        return persistedOrder;
    }

    public boolean validateInput(OrdersModel newOrder){
        if (newOrder.getId() == null) {return false;}
        if (newOrder.getMenuItem() == null || newOrder.getMenuItem().equals("")){return false;}
        if (newOrder.getIsFavorite() != 0 && newOrder.getIsFavorite() != 1){return false;}
        if (newOrder.getOrderDate() == null || newOrder.getOrderDate().equals("")){return false;}
        if (newOrder.getCustomerUsername() == null || newOrder.getCustomerUsername().equals("")){return false;}
        return true;
    }

}
