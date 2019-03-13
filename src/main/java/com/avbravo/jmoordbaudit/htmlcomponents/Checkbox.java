/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbaudit.htmlcomponents;

/**
 *
 * @author avbravo
 */
public class Checkbox {
     private String name;
    private String value;
    private String text;

    public Checkbox() {
    }

    public Checkbox(String name, String value, String text) {
        this.name = name;
        this.value = value;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
}
