package com.revature.zahfosha.orders;

public class OrdersModel {

    private Integer id;
    private String menuItem;
    private String comment;
    private Integer isFavorite;
    private String orderDate;
    private String customerUsername;

    public OrdersModel(Integer id, String menuItem, String comment, Integer isFavorite, String orderDate, String customerUsername) {
        this.id = id;
        this.menuItem = menuItem;
        this.comment = comment;
        this.isFavorite = isFavorite;
        this.orderDate = orderDate;
        this.customerUsername = customerUsername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    @Override
    public String toString() {
        return "OrdersModel{" +
                "id=" + id +
                ", menuItem='" + menuItem + '\'' +
                ", comment='" + comment + '\'' +
                ", isFavorite=" + isFavorite +
                ", orderDate='" + orderDate + '\'' +
                ", customerUsername='" + customerUsername + '\'' +
                '}';
    }
}
