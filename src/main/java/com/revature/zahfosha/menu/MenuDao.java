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


//    //    // MVP - Update items to the menu
//    public MenuModel updateMenu(BigDecimal cost, String protein, Integer isSubstitutable, String menuItem) {
//        Connection conn = ConnectionFactory.getInstance().getConnection();
//
//        String sql = "update menu set cost = ?, protein = ?, is_substitutable = ? where menu_item = ?";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setBigDecimal(1, cost);
//            ps.setString(2, protein);
//            ps.setInt(3, isSubstitutable);
//            ps.setString(4, menuItem);
//
//            int checkInsert = ps.executeUpdate();
//
//            if (checkInsert == 0) {
//                throw new RuntimeException();
//            }
//
//            followUPUpdateMenu(menuItem);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return null;
//    }
//
//    public MenuModel followUPUpdateMenu(String menuItem){
//        Connection conn = ConnectionFactory.getInstance().getConnection();
//
//        try {
//            String sql = "select * from menu where menu_item = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, menuItem);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (!rs.next()) {
//                return null;
//            }
//
//            MenuModel updatedMenuItem = new MenuModel();
//
//            updatedMenuItem.setMenuItem(rs.getString("menu_item"));
//            updatedMenuItem.setCost(rs.getBigDecimal("cost"));
//            updatedMenuItem.setProtein(rs.getString("protein"));
//            updatedMenuItem.setIsSubstitutable(rs.getInt("is_substitutable"));
//
//            return updatedMenuItem;
//
//        }catch (SQLException e){
//            e.printStackTrace();
//            return null;
//        }
//    }

}
