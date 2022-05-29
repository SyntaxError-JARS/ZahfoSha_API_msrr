package com.revature.zahfosha.menu;

import com.revature.zahfosha.util.interfaces.Crudable;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class MenuDao {

//    // MVP - Add items to the menu
    public MenuModel createMenu(String menuItem, BigDecimal cost, String protein, Integer isSubstitutable) {
        return null;
    }

//    // MVP - View all items on the menu without needing to Register or Login
    public MenuModel[] findAllMenuItems() throws IOException{
        return null;
    }

//     MVP - Delete items to the menu
    public boolean deleteByMenuItem(String menuItem) {
        return false;
    }

    //    // MVP - Update items to the menu
    public MenuModel updateMenu(String tableSelection, String newCellName, String ccNumber){
        return null;
    }

}
