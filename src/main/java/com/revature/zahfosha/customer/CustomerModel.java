package com.revature.zahfosha.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "customer")
public class CustomerModel {

    @Id
    @Column(name = "customer_username")
    private String customerUsername;
    @Column(name = "fname")
    private String fName;
    @Column(name = "lname")
    private String lName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private BigDecimal balance;
    @Column(name = "is_admin")
    private Integer isAdmin;


    public CustomerModel(String customerUsername, String fName, String lName, String password, BigDecimal balance, Integer isAdmin) {
        this.customerUsername = customerUsername;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.balance = balance;
        this.isAdmin = isAdmin;
    }

    public CustomerModel() {

    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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

    @Override
    public String toString() {
        return "CustomerModel{" +
                "customerUsername='" + customerUsername + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", balance=" + balance +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
