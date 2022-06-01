package com.revature.zahfosha.customer;

import com.revature.zahfosha.menu.MenuModel;
import com.revature.zahfosha.util.ConnectionFactory;
import com.revature.zahfosha.util.interfaces.Crudable;
import com.revature.zahfosha.creditcard.CreditCardModel;
import com.revature.zahfosha.orders.OrdersModel;
import com.revature.zahfosha.util.interfaces.Crudable;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.io.IOException;
import java.math.BigDecimal;

public class CustomerDao {

    public CustomerModel createCustomer(String username, String fname, String lname, String password, BigDecimal balance, Integer isAdmin) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "Insert into customer values (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, password);
            ps.setBigDecimal(5, balance);
            ps.setInt(6, isAdmin);

            int checkInsert = ps.executeUpdate();

            if (checkInsert == 0) {
                throw new RuntimeException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public CustomerModel updateCustomer(String fname, String lname, String password, BigDecimal balance, String username) {
        Connection conn = ConnectionFactory.getInstance().getConnection();

        String sql = "Update customer set fname = ?, lname = ?, password = ?, balance = ? where customer_username = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, password);
            ps.setBigDecimal(4, balance);
            ps.setString(5, username);

            int checkInsert = ps.executeUpdate();

            if (checkInsert == 0) {
                throw new RuntimeException();
            }

            return followUPUpdateCustomer(username);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CustomerModel followUPUpdateCustomer(String username) {
        Connection conn = ConnectionFactory.getInstance().getConnection();

        try {
            String sql = "select * from customer where customer_username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }

            CustomerModel updatedCustomerAccount = new CustomerModel();

            updatedCustomerAccount.setCustomerUsername(rs.getString("customer_username"));
            updatedCustomerAccount.setfName(rs.getString("fname"));
            updatedCustomerAccount.setlName(rs.getString("lname"));
            updatedCustomerAccount.setPassword(rs.getString("password"));
            updatedCustomerAccount.setBalance(rs.getBigDecimal("balance"));
            updatedCustomerAccount.setIsAdmin(rs.getInt("is_admin"));

            return updatedCustomerAccount;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteCustomer(String username) {
        Connection conn = ConnectionFactory.getInstance().getConnection();
        {
            String sql = "delete from credit_card where customer_username = ?";

            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);

                int checkInsert = ps.executeUpdate();

                if (checkInsert == 0) {
                    throw new RuntimeException();
                }

                return followUpDeleteCustomerPart1(username);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public boolean followUpDeleteCustomerPart1(String username) {
        Connection conn = ConnectionFactory.getInstance().getConnection();
        {
            String sql = "delete from orders where customer_username = ?";

            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);

                int checkInsert = ps.executeUpdate();

                if (checkInsert == 0) {
                    throw new RuntimeException();
                }

                return followUpDeleteCustomerPart2(username);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public boolean followUpDeleteCustomerPart2(String username) {
        Connection conn = ConnectionFactory.getInstance().getConnection();
        {
            String sql = "delete from customer where customer_username = ?";

            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);

                int checkInsert = ps.executeUpdate();

                if (checkInsert == 0) {
                    throw new RuntimeException();
                }

                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

}

