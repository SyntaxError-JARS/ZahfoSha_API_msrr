package com.revature.zahfosha.creditcard;

import com.revature.zahfosha.util.interfaces.Crudable;

import java.io.IOException;
import java.util.List;

public class CreditCardDao implements Crudable<CreditCardModel> {

    // MVP - add credit card
    @Override
    public CreditCardModel create(CreditCardModel newObject) {
        return null;
    }

    @Override
    public List<CreditCardModel> findAll() throws IOException {
        return null;
    }

    @Override
    public CreditCardModel findById(String id) {
        return null;
    }

    // MVP - update credit card
    @Override
    public CreditCardModel update(CreditCardModel updatedCard) {
        return null;
    }

    public CreditCardModel updateChargeCard(CreditCardModel chargedCard){
        return null;
    }

    // MVP - delete credit card
    @Override
    public boolean delete(String id) {
        return false;
    }

}
