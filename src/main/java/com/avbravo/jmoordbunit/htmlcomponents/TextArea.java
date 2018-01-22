/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.htmlcomponents;

/**
 *
 * @author avbravo
 */
public class TextArea {
    private String name;
    private Integer row=0;
    private Integer col=0;
    private String value="";

    public TextArea() {
    }

    public TextArea(String name,Integer row, Integer col, String value) {
        this.name = name;
        this.col=col;
        this.row=row;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
    
}
