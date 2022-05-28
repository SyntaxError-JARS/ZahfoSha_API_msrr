package com.revature.zahfosha.creditcard;

import java.math.BigDecimal;

public class CreditCardModel {

    private String ccNumber;
    private String ccName;
    private Integer cvv;
    private String expDate;
    private Integer zip;
    private BigDecimal limit;
    private String customerUsername;

    public CreditCardModel(String ccNumber, String ccName, Integer cvv, String expDate, Integer zip, BigDecimal limit, String customerUsername) {
        this.ccNumber = ccNumber;
        this.ccName = ccName;
        this.cvv = cvv;
        this.expDate = expDate;
        this.zip = zip;
        this.limit = limit;
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

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }


    @Override
    public String toString() {
        return "CreditCardModel{" +
                "ccNumber='" + ccNumber + '\'' +
                ", ccName='" + ccName + '\'' +
                ", cvv=" + cvv +
                ", expDate='" + expDate + '\'' +
                ", zip=" + zip +
                ", limit=" + limit +
                ", customerUsername='" + customerUsername + '\'' +
                '}';
    }
}
