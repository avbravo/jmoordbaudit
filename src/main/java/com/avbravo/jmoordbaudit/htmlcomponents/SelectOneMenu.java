/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbaudit.htmlcomponents;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
public class SelectOneMenu {
    private String name;
    private List<Item> itemList = new ArrayList<>();

    public SelectOneMenu() {
    }

    public SelectOneMenu(String name, List<Item> itemList) {
        this.name = name;
        this.itemList =itemList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    
    
    
    
    
}
