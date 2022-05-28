package com.revature.zahfosha.creditcard;

import com.revature.zahfosha.orders.OrdersModel;
import com.revature.zahfosha.util.ConnectionFactory;
import com.revature.zahfosha.util.interfaces.Crudable;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CreditCardDao {

    //    // MVP - add credit card
    public CreditCardModel addCC(String ccNumber, String ccName, Integer cvv, String expDate, Integer zip, BigDecimal limit, String customerUsername) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection();){
            String sql = "insert into credit_card values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,ccNumber);
            ps.setString(2, ccName);
            ps.setInt(3, cvv);
            ps.setString(4, expDate);
            ps.setInt(5, zip);
            ps.setBigDecimal(6, limit);
            ps.setString(7, customerUsername);

            int checkInsert = ps.executeUpdate();

            if (checkInsert == 0){
                throw new RuntimeException();
            }

            followUpAddCC(ccNumber);

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public CreditCardModel followUpAddCC(String ccNumber) {
        Connection conn = ConnectionFactory.getInstance().getConnection();

        try {
            String sql2 = "select * from credit_card where cc_number = ?";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setString(1, ccNumber);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }

            CreditCardModel newCreditCard = new CreditCardModel();

            newCreditCard.setCcNumber(rs.getString("cc_number"));
            newCreditCard.setCcName(rs.getString("cc_name"));
            newCreditCard.setCvv(rs.getInt("cvv"));
            newCreditCard.setExpDate(rs.getString("exp_date"));
            newCreditCard.setZip(rs.getInt("zip"));
            newCreditCard.setLimit(rs.getBigDecimal("limit"));
            newCreditCard.setCustomerUsername(rs.getString("customer_username"));

            return newCreditCard;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    //    // MVP - delete credit card
    public boolean deleteByCCNumber(String ccNumber) {
        Connection conn = ConnectionFactory.getInstance().getConnection();{
            String sql = "delete from credit_card where cc_number = ?";

            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, ccNumber);

                int checkInsert = ps.executeUpdate();

                if (checkInsert == 0){
                    throw new RuntimeException();
                }

                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    //    // MVP - update credit card
    public CreditCardModel updateCC(String tableSelection, String newCellName, String oldCellName) {
        return null;
    }

}