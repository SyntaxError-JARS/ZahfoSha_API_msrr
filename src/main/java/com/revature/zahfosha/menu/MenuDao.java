package com.revature.zahfosha.menu;

import com.revature.zahfosha.orders.OrdersModel;
import com.revature.zahfosha.util.ConnectionFactory;
import com.revature.zahfosha.util.interfaces.Crudable;

import java.sql.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class MenuDao {

    //    // MVP - Add items to the menu
    public MenuModel createMenu(String menuItem, BigDecimal cost, String protein, Integer isSubstitutable) {
        return null;
    }

    //    // MVP - View all items on the menu without needing to Register or Login
    public MenuModel[] findAllMenuItems() throws IOException {
        Connection conn = ConnectionFactory.getInstance().getConnection();

        MenuModel[] menuItems = new MenuModel[20];

        int index = 0;

        try {
            String sql = "select * from menu";
            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {

                MenuModel fillInMenu = new MenuModel();

                fillInMenu.setMenuItem(rs.getString("menu_item"));
                fillInMenu.setCost(rs.getBigDecimal("cost"));
                fillInMenu.setProtein(rs.getString("protein"));
                fillInMenu.getIsSubstitutable(rs.getInt("is_substitutable"));

                menuItems[index] = fillInMenu;
                index++;

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return menuItems;

    }

    //     MVP - Delete items to the menu
    public boolean deleteByMenuItem(String menuItem) {
        return false;
    }

    //    // MVP - Update items to the menu
    public MenuModel updateMenu(String tableSelection, String newCellName, String ccNumber) {
        return null;
    }

}
