package com.revature.zahfosha.creditcard;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "credit_card")
public class CreditCardModel {

    @Id
    @Column(name = "cc_number")
    private String ccNumber;
    @Column(name = "cc_name")
    private String ccName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer cvv; // this aka CSC it is a card security code and should be kept secret
    @Column(name = "exp_date")
    private String expDate;
    private Integer zip;
    private BigDecimal limits;
    @Column(name = "customer_username")
    private String customerUsername;

    public CreditCardModel(String ccNumber, String ccName, Integer cvv, String expDate, Integer zip, BigDecimal limits, String customerUsername) {
        this.ccNumber = ccNumber;
        this.ccName = ccName;
        this.cvv = cvv;
        this.expDate = expDate;
        this.zip = zip;
        this.limits = limits;
        this.customerUsername = customerUsername;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public CreditCardModel() {

    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public BigDecimal getLimits() {
        return limits;
    }

    public void setLimits(BigDecimal limits) {
        this.limits = limits;
    }


    @Override
    public String toString() {
        return "CreditCardModel{" +
                "ccNumber='" + ccNumber + '\'' +
                ", ccName='" + ccName + '\'' +
                ", expDate='" + expDate + '\'' +
                ", zip=" + zip +
                ", limit=" + limits +
                ", customerUsername='" + customerUsername + '\'' +
                '}';
    }
}
