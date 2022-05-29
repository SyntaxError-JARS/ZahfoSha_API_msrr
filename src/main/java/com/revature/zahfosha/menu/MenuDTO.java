package com.revature.zahfosha.menu;

import java.math.BigDecimal;

public class MenuDTO {

    private String menuItem;
    private BigDecimal cost;
    private String protein;
    private Integer isSubstitutable;
    private String tableSelection;
    private String newCellName;
    private String oldCellName;

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

    public Integer getIsSubstitutable() {
        return isSubstitutable;
    }

    public void setIsSubstitutable(Integer isSubstitutable) {
        this.isSubstitutable = isSubstitutable;
    }

    public String getTableSelection() {
        return tableSelection;
    }

    public void setTableSelection(String tableSelection) {
        this.tableSelection = tableSelection;
    }

    public String getNewCellName() {
        return newCellName;
    }

    public void setNewCellName(String newCellName) {
        this.newCellName = newCellName;
    }

    public String getOldCellName() {
        return oldCellName;
    }

    public void setOldCellName(String oldCellName) {
        this.oldCellName = oldCellName;
    }
}
