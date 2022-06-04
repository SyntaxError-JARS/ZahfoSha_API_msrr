package com.revature.zahfosha.customer;

import com.revature.zahfosha.util.exceptions.AuthenticationException;
import com.revature.zahfosha.util.exceptions.InvalidRequestException;

import java.math.BigDecimal;

public class CustomerServices {

    private CustomerDao cDao;

    public CustomerServices(CustomerDao cDao) {
        this.cDao = cDao;
    }

    public CustomerModel create(CustomerModel newCustomer){
        if(!validateInput(newCustomer)){
            throw new InvalidRequestException("User input is invalid, all values must be entered, customer username, first name, last name, and password must all be a normal string. Balance must be a currency value, and admin status must be a 1 for true a 0 for false");
        }
        CustomerModel persistedCustomer = cDao.createCustomer(newCustomer);

        return persistedCustomer;
    }

    public boolean validateInput(CustomerModel newCustomer){
        if (newCustomer.getCustomerUsername() == null || newCustomer.getCustomerUsername().equals("")) {return false;}
        if (newCustomer.getfName() == null || newCustomer.getfName().equals("")) {return false;}
        if (newCustomer.getlName() == null || newCustomer.getlName().equals("")) {return false;}
        if (newCustomer.getPassword() == null || newCustomer.getPassword().equals("")) {return false;}
        if (newCustomer.getBalance() == null) {return false;}
        if (newCustomer.getIsAdmin() != 0 && newCustomer.getIsAdmin() != 1){return false;}
        return true;
    }

    public CustomerModel authenticateAccount(String customerUsername, String password, Integer isAdmin){
        if (customerUsername == null || customerUsername.trim().equals("") || password == null || password.trim().equals("")){
            throw new InvalidRequestException("Either username or password is an invalid entry. Please try logging in again");
        }

        CustomerModel authenticatedAccount = cDao.authenticatingCustomerAccount(customerUsername, password, isAdmin);

        if (authenticatedAccount == null){
            throw new AuthenticationException("Unauthenticated user, information provided was not consistent with our database.");
        }
        return authenticatedAccount;
    }

}
