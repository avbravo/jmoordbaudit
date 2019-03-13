/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbaudit.test;

/**
 *
 * @author avbravo
 */
public class Colores {

    public static String reset() {
        return "\u001B[0m";
    }

    public static String negro() {
        return "\u001B[30m";
    }

    public static String rojo() {
        return "\u001B[31m";
    }

    public static String verde() {
        return "\u001B[32m";
    }

    public static String amarillo() {
        return "\u001B[33m";
    }

  
    public static  String azul(){
        return "\u001B[34m";
    }
  
    public static  String purpura(){
        return  "\u001B[35m";
    }
    
    public static String cyan(){
        return "\u001B[36m";
    }
    
    public static String blanco(){
        return "\u001B[37m";
    }
}
