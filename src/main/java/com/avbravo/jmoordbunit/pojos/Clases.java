/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.pojos;

/**
 *
 * @author avbravo
 */
public class Clases {
    private String clase;
    private Resumen resumen;

    public Clases() {
    }

    public Clases(String clase, Resumen resumen) {
        this.clase = clase;
        this.resumen = resumen;
    }
    
    

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Resumen getResumen() {
        return resumen;
    }

    public void setResumen(Resumen resumen) {
        this.resumen = resumen;
    }
    
}
