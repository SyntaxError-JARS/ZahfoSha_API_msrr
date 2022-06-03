package com.revature.zahfosha.menu;

import com.revature.zahfosha.creditcard.CreditCardModel;
import com.revature.zahfosha.orders.OrdersModel;
import com.revature.zahfosha.util.ConnectionFactory;
import com.revature.zahfosha.util.HibernateUtil;
import com.revature.zahfosha.util.interfaces.Crudable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class MenuDao {

    //    // MVP - Add items to the menu
    public MenuModel createMenu(MenuModel newMenuItem) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(newMenuItem);
            transaction.commit();
            return newMenuItem;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }


    public List<MenuModel> findAllMenuItems(){
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            List<MenuModel> allMenuItemsList = session.createQuery("FROM MenuModel").list();
            transaction.commit();
            return allMenuItemsList;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }


    public boolean deleteByMenuItem(String menuItem){
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            MenuModel deletedMenuItem = session.load(MenuModel.class, menuItem);
            session.remove(deletedMenuItem);
            transaction.commit();
            return true;
        } catch (HibernateException | IOException e){
            e.printStackTrace();
            return false;
        }finally {
            HibernateUtil.closeSession();
        }
    }


    public MenuModel updateMenu(String menuItem, BigDecimal cost, String protein, Integer isSubstitutable){
        try {
            MenuModel updatedMenuItem = new MenuModel(menuItem, cost, protein, isSubstitutable);
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.merge(updatedMenuItem);
            transaction.commit();

        } catch (HibernateException | IOException e){
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
        return followUpUpdateMenu(menuItem);
    }

    public MenuModel followUpUpdateMenu(String menuItem){
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            MenuModel foundMenuItem = session.get(MenuModel.class, menuItem);
            transaction.commit();
            return foundMenuItem;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }


}
