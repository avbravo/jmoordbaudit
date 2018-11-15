/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.interfaces;

import java.lang.reflect.Method;

/**
 *
 * @author avbravo
 */
public interface ITest {

   
    public void init();
    public void destroy();
   public default String getCurrentClassAndMethodNames() {
    final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
    final String s = e.getClassName();
    return s.substring(s.lastIndexOf('.') + 1, s.length()) + "." + e.getMethodName();
}
   public default String nameOfClass() {
    final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
    final String s = e.getClassName();
    return s.substring(s.lastIndexOf('.') + 1, s.length()) ;
}
   public default String nameOfMethod() {
    final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
    final String s = e.getClassName();
    return  e.getMethodName();
}
}
