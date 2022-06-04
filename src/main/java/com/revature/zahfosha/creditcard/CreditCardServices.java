package com.revature.zahfosha.creditcard;


import com.revature.zahfosha.util.exceptions.InvalidRequestException;

public class CreditCardServices {


//    private String ccNumber;
//    private String ccName;
//    private Integer cvv;
//    private String expDate;
//    private Integer zip;
//    private BigDecimal limits;
//    private String customerUsername;

    private CreditCardDao ccDao;

    public CreditCardServices(CreditCardDao ccDao) {
        this.ccDao = ccDao;
    }

    public CreditCardModel create(CreditCardModel newCreditCard){
        if (!validateInput(newCreditCard)){
            throw new InvalidRequestException("User inputs are invalid. Please remember that credit card number and credit card name must be entered with the correct characters. CVV must be the correct 3 or 4 digits. expiration date must be entered year/month/day. Zip code must be the correct 5 digits. credit card limit must be entered as a currency and your username must be entered in exactly as provide when you created your account.");
        }
        CreditCardModel persistedCreditCard = ccDao.addCC(newCreditCard);

        return persistedCreditCard;
    }

    public boolean validateInput(CreditCardModel newCreditCard){
        if (newCreditCard.getCcNumber() == null || newCreditCard.getCcNumber().equals("")){return false;}
        if (newCreditCard.getCcName() == null || newCreditCard.getCcName().equals("")){return false;}
        if (newCreditCard.getCvv() < 99 || newCreditCard.getCvv() > 9999) {return false;} // sometimes it can have 4 digits
        if (newCreditCard.getExpDate() == null || newCreditCard.getExpDate().equals("")){return false;}
        if (newCreditCard.getZip() < 9999 || newCreditCard.getZip() > 99999) {return false;}
        if (newCreditCard.getLimits() == null) {return false;}
        if (newCreditCard.getCustomerUsername() == null || newCreditCard.getCustomerUsername().equals("")){return false;}

        return true;
    }

}
