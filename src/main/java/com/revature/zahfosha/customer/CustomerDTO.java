package com.revature.zahfosha.customer;

import java.math.BigDecimal;

public class CustomerDTO {

    private String username;
    private String fName;
    private String lName;
    private String password;
    private BigDecimal balance;
    private Integer isAdmin;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fname) {
        this.fName = fname;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lname) {
        this.lName = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

}
