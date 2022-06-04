package com.revature.zahfosha.creditcard;

import com.revature.zahfosha.customer.CustomerModel;
import com.revature.zahfosha.util.ConnectionFactory;
import com.revature.zahfosha.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditCardDao {


    public CreditCardModel addCC(CreditCardModel newCreditCard) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(newCreditCard);
            transaction.commit();
            return newCreditCard;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }


    public CreditCardModel updateCreditCard(String ccNumber, String ccName, Integer cvv, String expDate, Integer zip, BigDecimal limits, String customerUsername) {
        try {
            CreditCardModel updatedCreditCard = new CreditCardModel(ccNumber, ccName, cvv, expDate, zip, limits, customerUsername);
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.merge(updatedCreditCard);
            transaction.commit();

        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
        return followUpUpdateCreditCard(ccNumber);
    }

    public CreditCardModel followUpUpdateCreditCard(String ccNumber) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            CreditCardModel foundCreditCard = session.get(CreditCardModel.class, ccNumber);
            transaction.commit();
            return foundCreditCard;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }


    //    // MVP - delete credit card
//    public boolean deleteByCCNumber(String ccNumber) {
//        Connection conn = ConnectionFactory.getInstance().getConnection();{
//            String sql = "delete from credit_card where cc_number = ?";
//
//            try {
//                PreparedStatement ps = conn.prepareStatement(sql);
//                ps.setString(1, ccNumber);
//
//                int checkInsert = ps.executeUpdate();
//
//                if (checkInsert == 0){
//                    throw new RuntimeException();
//                }
//
//                return true;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//        return false;
//    }



}