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

        // MVP - View past orders by date
    public List<OrdersModel> viewAllByDate(){
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            List<OrdersModel> ordersFoundByDate = session.createQuery("FROM OrdersModel").list();
            transaction.commit();
            return ordersFoundByDate;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return null;
        }finally {
            HibernateUtil.closeSession();
        }
    }


}
