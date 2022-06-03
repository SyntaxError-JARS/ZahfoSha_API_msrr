package com.revature.zahfosha.orders;

import com.revature.zahfosha.util.ConnectionFactory;
import com.revature.zahfosha.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.EntityManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Queue;

public class OrdersDao {

    private EntityManager em;

    // MVP - combo - make order, add comment for is substitutable, and favorite order
    public OrdersModel createCustomOrder(OrdersModel newOrder){
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(newOrder);
            transaction.commit();
            return newOrder;
        } catch (HibernateException | IOException e){
            e.printStackTrace();
            return null;
        }finally {
            HibernateUtil.closeSession();
        }
    }


    public List<OrdersModel> viewAllByDate(String orderDate){
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            String jpql = "SELECT o FROM OrdersModel o WHERE o.orderDate = :param1";
            List<OrdersModel> ordersFoundByDate = em.createQuery(jpql, OrdersModel.class).setParameter("param1", orderDate).getResultList();
            transaction.commit();
            return ordersFoundByDate;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return null;
        }finally {
            HibernateUtil.closeSession();
        }
    }
//
//    // MVP - View past orders by date
//    public OrdersModel[] viewAllByDate(String theDate){
//        Connection conn = ConnectionFactory.getInstance().getConnection();
//
//        OrdersModel[] orders = new OrdersModel[20];
//
//        int index = 0;
//
//        try{
//            String sql = "select * from orders where order_date = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            ps.setString(1, theDate);
//
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//
//                OrdersModel modelOrder = new OrdersModel();
//
//                modelOrder.setId(rs.getInt("id"));
//                modelOrder.setMenuItem(rs.getString("menu_item"));
//                modelOrder.setComment(rs.getString("comment"));
//                modelOrder.setIsFavorite(rs.getInt("is_favorite"));
//                modelOrder.setOrderDate(rs.getString("order_date"));
//                modelOrder.setCustomerUsername(rs.getString("customer_username"));
//
//                orders[index] = modelOrder;
//                index++;
//
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//            return null;
//        }
//        return orders;
//    }
//
//

}
