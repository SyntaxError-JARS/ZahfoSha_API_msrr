package com.revature.zahfosha.creditcard;

import com.revature.zahfosha.util.ConnectionFactory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditCardDao {

    //    // MVP - add credit card
    public CreditCardModel addCC(String ccNumber, String ccName, Integer cvv, String expDate, Integer zip, BigDecimal limits, String customerUsername) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection();){
            String sql = "insert into credit_card values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,ccNumber);
            ps.setString(2, ccName);
            ps.setInt(3, cvv);
            ps.setString(4, expDate);
            ps.setInt(5, zip);
            ps.setBigDecimal(6, limits);
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
            newCreditCard.setLimits(rs.getBigDecimal("limits"));
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
    public CreditCardModel updateCC(String tableSelection, String newCellName, String ccNumber) {

        Connection conn = ConnectionFactory.getInstance().getConnection();

        if (tableSelection.equals("credit card name")){
            String sql = "update credit_card set cc_name = ? where cc_number = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, newCellName);
                ps.setString(2, ccNumber);

                int checkInsert = ps.executeUpdate();

                if (checkInsert == 0) {
                    throw new RuntimeException();
                }

                followUPUpdateCC(ccNumber);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (tableSelection.equals("expiration date")){
            String sql = "update credit_card set exp_date = ? where cc_number = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, newCellName);
                ps.setString(2, ccNumber);

                int checkInsert = ps.executeUpdate();

                if (checkInsert == 0) {
                    throw new RuntimeException();
                }

                followUPUpdateCC(ccNumber);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (tableSelection.equals("zip")){
            String sql = "update credit_card set zip = ? where cc_number = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);

                Integer newIntCellValue = Integer.parseInt(newCellName);

                ps.setInt(1, newIntCellValue);
                ps.setString(2, ccNumber);

                int checkInsert = ps.executeUpdate();

                if (checkInsert == 0) {
                    throw new RuntimeException();
                }

                followUPUpdateCC(ccNumber);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (tableSelection.equals("limits")){
            String sql = "update credit_card set limits = ? where cc_number = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);

                int newIntCellValue = Integer.parseInt(newCellName);
                BigDecimal newDecimalValue = BigDecimal.valueOf(newIntCellValue);

                ps.setBigDecimal(1, newDecimalValue);
                ps.setString(2, ccNumber);

                int checkInsert = ps.executeUpdate();

                if (checkInsert == 0) {
                    throw new RuntimeException();
                }

                followUPUpdateCC(ccNumber);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public CreditCardModel followUPUpdateCC(String ccNumber){
        Connection conn = ConnectionFactory.getInstance().getConnection();

        try {
            String sql2 = "select * from credit_card where cc_number = ?";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setString(1, ccNumber);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }

            CreditCardModel adjustedCreditCard = new CreditCardModel();

            adjustedCreditCard.setCcNumber(rs.getString("cc_number"));
            adjustedCreditCard.setCcName(rs.getString("cc_name"));
            adjustedCreditCard.setCvv(rs.getInt("cvv"));
            adjustedCreditCard.setExpDate(rs.getString("exp_date"));
            adjustedCreditCard.setZip(rs.getInt("zip"));
            adjustedCreditCard.setLimits(rs.getBigDecimal("limits"));
            adjustedCreditCard.setCustomerUsername(rs.getString("customer_username"));

            return adjustedCreditCard;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}