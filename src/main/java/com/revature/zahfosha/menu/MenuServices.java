package com.revature.zahfosha.menu;

import com.revature.zahfosha.util.exceptions.InvalidRequestException;

import java.math.BigDecimal;

public class MenuServices {

    private MenuDao mDao;

    public MenuServices(MenuDao mDao) {
        this.mDao = mDao;
    }

    public MenuModel create(MenuModel newMenuItem){
        if(!validateInput(newMenuItem)){
            throw new InvalidRequestException("User input was not valid, values cannot be empty, menu item needs to be words, cost needs to be money, protein needs to be in grams, and is substitutable needs to be a 1 if true or an 0 if false");
        }
        MenuModel persistedModel = mDao.createMenu(newMenuItem);

        return persistedModel;
    }


    public boolean validateInput(MenuModel newMenuItem){
        if (newMenuItem.getMenuItem() == null || newMenuItem.getMenuItem().trim().equals("")) {return false;}
        if (newMenuItem.getCost() == null ) {return false;}
        if (newMenuItem.getProtein() == null || newMenuItem.getProtein().trim().equals("")) {return false;}
        if (newMenuItem.getIsSubstitutable() != 0 && newMenuItem.getIsSubstitutable() != 1) {return false;}

        return true;
    }


}
