package com.revature.zahfosha.creditcard;

import com.revature.zahfosha.util.ConnectionFactory;
import com.revature.zahfosha.util.interfaces.Crudable;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CreditCardDao {

    //    // MVP - add credit card
    public CreditCardModel addCC(String ccNumber, String ccName, Integer cvv, String expDate, BigDecimal limit) {
        return null;
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