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
public class Metodos {
    private String nombre;
    private String result;
    private String message;
  

    public Metodos() {
    }

//    public Metodos(String nombre, String result) {
//        this.nombre = nombre;
//        this.result = result;
//     
//    }

    public Metodos(String nombre, String result, String message) {
        this.nombre = nombre;
        this.result = result;
        this.message = message;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

   
    
    
}
