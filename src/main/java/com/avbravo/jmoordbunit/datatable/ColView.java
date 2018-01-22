/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.datatable;

/**
 *
 * @author avbravo
 */
public class ColView {
 private Object value;
 public ColView(){
     
 }
 public ColView(Object value){
     this.value = value;
 }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
 
}
