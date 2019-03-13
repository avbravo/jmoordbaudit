/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbaudit.pojos;

/**
 *
 * @author avbravo
 */
public class ClasesHtml {
    private String clase;
    private  StringBuilder viewHtml = new StringBuilder();

    public ClasesHtml() {
    }

    public ClasesHtml(String clase,StringBuilder viewHtml) {
        this.clase = clase;
        this.viewHtml = viewHtml;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public StringBuilder getViewHtml() {
        return viewHtml;
    }

    public void setViewHtml(StringBuilder viewHtml) {
        this.viewHtml = viewHtml;
    }
      
    
    
}
