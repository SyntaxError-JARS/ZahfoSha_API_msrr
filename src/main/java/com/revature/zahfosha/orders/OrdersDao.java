package com.revature.zahfosha.orders;

import com.revature.zahfosha.util.ConnectionFactory;
import com.revature.zahfosha.util.interfaces.Crudable;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.BitSet;
import java.util.List;

public class OrdersDao {

    // MVP - Make an order for a specific menu item
//    @Override
//    public OrdersModel create(OrdersModel newOrder) {
//        return null;
//    }

    // MVP - Add a comment to the order to request a change, if it is substitutable
//    public OrdersModel createWithComment(OrdersModel newCommentOrder) {
//        return null;
//    }

    // MVP - Favorite an order
//    public OrdersModel createFavoriteOrder(OrdersModel newFavoriteOrder) {
//        return null;
//    }

    // MVP - combo - make order, add comment for is substitutable, and favorite order
    public OrdersModel createCustomOrder(int id, String menuItem, String comment, int isFavorite, String orderDate, String customerUsername) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection();){
            String sql = "insert into orders values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,id);
            ps.setString(2, menuItem);
            ps.setString(3, comment);
            ps.setInt(4, isFavorite);
            ps.setString(5, orderDate);
            ps.setString(6, customerUsername);

            int checkInsert = ps.executeUpdate();

            if (checkInsert == 0){
                throw new RuntimeException();
            }

            followUpCreateCustomOrder(id, menuItem,comment,isFavorite, orderDate, customerUsername);

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public OrdersModel followUpCreateCustomOrder(int id, String menuItem, String comment, int isFavorite, String orderDate, String customerUsername) {
        Connection conn = ConnectionFactory.getInstance().getConnection();

        try {
            String sql2 = "select * from orders where id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, id);

            ResultSet rs = ps2.executeQuery();

            if (!rs.next()) {
                return null;
            }

            OrdersModel newCustomOrder = new OrdersModel();

            newCustomOrder.setId(rs.getInt("id"));
            newCustomOrder.setMenuItem(rs.getString("menu_item"));
            newCustomOrder.setComment(rs.getString("comment"));
            newCustomOrder.setIsFavorite(rs.getInt("is_favorite"));
            newCustomOrder.setOrderDate(rs.getString("order_date"));
            newCustomOrder.setCustomerUsername(rs.getString("customer_username"));

            return newCustomOrder;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    // MVP - View past orders by date
    public OrdersModel findByDate(String orderDate) {
        return null;
    }


}
