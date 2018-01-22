/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.htmlcomponents;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
public class Radio {
 private String name;
 private List<Item> item = new ArrayList<>();

    public Radio() {
    }

    public Radio(String name,List<Item> item) {
        this.name = name;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
 
 
 
}
