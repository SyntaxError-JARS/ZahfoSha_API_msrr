package com.revature.zahfosha.menu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "menu")
public class MenuModel {

    @Id
    private String menuItem;
    private BigDecimal cost;
    private String protein;
    private Integer isSubstitutable;

    public MenuModel(String menuItem, BigDecimal cost, String protein, Integer isSubstitutable) {
        this.menuItem = menuItem;
        this.cost = cost;
        this.protein = protein;
        this.isSubstitutable = isSubstitutable;
    }

    public MenuModel() {

    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public Integer getIsSubstitutable(int is_substitutable) {
        return isSubstitutable;
    }

    public void setIsSubstitutable(Integer isSubstitutable) {
        this.isSubstitutable = isSubstitutable;
    }

    @Override
    public String toString() {
        return "MenuModel{" +
                "menuItem='" + menuItem + '\'' +
                ", cost=" + cost +
                ", protein='" + protein + '\'' +
                ", isSubstitutable=" + isSubstitutable +
                '}';
    }
}
