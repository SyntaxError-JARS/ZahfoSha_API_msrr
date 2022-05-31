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
        try(Connection conn = ConnectionFactory.getInstance().getConnection();){

            String sql = "Insert into customer values (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,username);
            ps.setString(2,fname);
            ps.setString(3,lname);
            ps.setString(4,password);
            ps.setBigDecimal(5,balance);
            ps.setInt(6,isAdmin);

            int checkInsert = ps.executeUpdate();

            if (checkInsert == 0){
                throw new RuntimeException();
            }

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public CustomerModel updateCustomer(String username, String fname, String lname, String password, BigDecimal balance, Integer isAdmin) {
        Connection conn = ConnectionFactory.getInstance().getConnection();

        String sql = "Update customer set fname = ?, lname = ?, password = ? where username = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,username);
            ps.setString(2,fname);
            ps.setString(3,lname);
            ps.setString(4,password);
            ps.setBigDecimal(5,balance);
            ps.setInt(6,isAdmin);

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

    public boolean deleteCustomer(String username) {
        Connection conn = ConnectionFactory.getInstance().getConnection();{
            String sql = "Delete from customer where username = ?";

            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,username);

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


//    // MVP - register customer account
//    @Override
//    public CustomerModel create(CustomerModel newCustomer) {
//        return null;
//    }
//
//    @Override
//    public List<CustomerModel> findAll() throws IOException { return null; }
//
//    @Override
//    public CustomerModel findById(String id) {
//        return null;
//    }
//
//    // MVP - update customer account
//    @Override
//    public CustomerModel update(CustomerModel updatedCustomer) {
//        return null;
//    }
//
//    // MVP - delete customer account
//    @Override
//    public boolean delete(String id) {
//        return false;
//    }
//
//    public boolean deleteByUsername(String customerUsername) { return false; }
}
