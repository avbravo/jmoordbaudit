/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.util;

import com.avbravo.jmoordbunit.Test;
import com.avbravo.jmoordbunit.TestEnvironment;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author avbravo
 */
@Stateless
public class UnitTest {
@Inject
TestEnvironment testEnvironment;
    public  void start(String clase) {
        try {
             System.out.println("---------------------------------------");  
            System.out.println("Start clase: "+clase);
         testEnvironment.getResumen().setError(testEnvironment.getResumen().getError()+1);
     
          } catch (Exception e) {
              System.out.println("startTest() "+e.getLocalizedMessage());
        }

    }
    public  int startTest(final Object object) {
        try {
            
            System.out.println("-----> lllego a startTest");
        Class<?> claseAnalizar =object.getClass();
        final Field[] variables = claseAnalizar.getDeclaredFields();
         System.out.println("-----> voy a leer field");
        for (final Field variable : variables) {
            final Annotation anotacionObtenida = variable.getAnnotation(Test.class);
             System.out.println("-----> voy a leer anotaciones");
            if (anotacionObtenida != null && anotacionObtenida instanceof Test) {
                final Test anotacionTest = (Test) anotacionObtenida;
      
                String name = anotacionTest.name();
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println(" name "+name);

            }else{
                System.out.println("no es anotacion con data o es null");
            }

        }
          } catch (Exception e) {
              System.out.println("startTest() "+e.getLocalizedMessage());
        }
        return 0;
    }

    public void assertEquals(Object expect, Object result) {
        if (expect.equals(result)) {
            System.out.println(" es igual");
             testEnvironment.getResumen().setSuccess(testEnvironment.getResumen().getSuccess()+1);
        } else {
             testEnvironment.getResumen().setError(testEnvironment.getResumen().getError()+1);
            System.out.println(" No es igual");
        }

    }
    public void assertTrue(Boolean condition) {
        if (condition) {
            System.out.println(" es igual");
             testEnvironment.getResumen().setSuccess(testEnvironment.getResumen().getSuccess()+1);
        } else {
             testEnvironment.getResumen().setError(testEnvironment.getResumen().getError()+1);
            System.out.println(" No es igual");
        }

    }
    public void assertTrue(Boolean condition, String... message) {
         String mess = "";
            if (message.length != 0) {
                mess = message[0];

            }
        if (condition) {
            System.out.println("es true ");
             testEnvironment.getResumen().setSuccess(testEnvironment.getResumen().getSuccess()+1);
        } else {
             testEnvironment.getResumen().setError(testEnvironment.getResumen().getError()+1);
        }

    }
    public void assertFalse(Boolean condition) {
        if (!condition) {
            System.out.println(" es igual");
             testEnvironment.getResumen().setSuccess(testEnvironment.getResumen().getSuccess()+1);
        } else {
             testEnvironment.getResumen().setError(testEnvironment.getResumen().getError()+1);
            System.out.println(" No es igual");
        }

    }
    public void assertFalse(Boolean condition, String... message) {
         String mess = "";
            if (message.length != 0) {
                mess = message[0];

            }
        if (!condition) {
            System.out.println("es true ");
             testEnvironment.getResumen().setSuccess(testEnvironment.getResumen().getSuccess()+1);
        } else {
             testEnvironment.getResumen().setError(testEnvironment.getResumen().getError()+1);
        }

    }

    public void fail(String message) {      
            System.out.println(message);
             testEnvironment.getResumen().setFailures(testEnvironment.getResumen().getFailures()+1);
       

    }
    public void assertNull(Object object,String... message) {      
            System.out.println(message);
             testEnvironment.getResumen().setFailures(testEnvironment.getResumen().getFailures()+1);
       

    }
    public void assertNotNull(Object object,String... message) {      
            System.out.println(message);
             testEnvironment.getResumen().setFailures(testEnvironment.getResumen().getFailures()+1);
       

    }
    public void  assertNotSame(Object object,String... message) {      
            System.out.println(message);
             testEnvironment.getResumen().setFailures(testEnvironment.getResumen().getFailures()+1);
       

    }
}
