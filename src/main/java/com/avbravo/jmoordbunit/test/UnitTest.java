/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.test;

import com.avbravo.jmoordbunit.anotation.Test;
import com.avbravo.jmoordbunit.TestEnvironment;
import com.avbravo.jmoordbunit.anotation.Report;
import com.avbravo.jmoordbunit.util.UnitUtil;
import java.lang.annotation.Annotation;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author avbravo
 */
@Stateless
public class UnitTest<T> {

    @Inject
    TestEnvironment testEnvironment;

    /*
Lee las anotaciones @Test, @Report
     */
    public void start(Class<T> t) {

        System.out.println("--->Name of Clase(): " + t.getSimpleName());


        Annotation a = t.getAnnotation(Test.class);
        if (a == null) {
//            System.out.println("..." + t.getSimpleName() + " No tiene anotacion @Test");
        }


        Annotation b = t.getAnnotation(Report.class);
        if (b == null) {
            //System.out.println("----> no tiene la anotacion @Report");
        } else {
            String data = b.toString();
            System.out.println(data);
            if (data.contains("@com.avbravo.jmoordbunit.anotation.Report(path=)")) {
                System.out.println("----->solo tiene la anotacion @Report definida sin valor");
            } else {

//                String texto = data.replace("@com.avbravo.jmoordbunit.anotation.Report(path=", "");
//                texto = texto.replace(")", "");
//                texto = texto.trim();
//
//                if (!UnitUtil.getLastLetter(texto).equals(UnitUtil.separator())) {
//                    texto = texto + UnitUtil.separator();
//                }
//                testEnvironment.setPathReports(texto);
//                System.out.println("--->Path del reporte " + texto);
                
                testEnvironment.setPathReports(UnitUtil.getPathOfReportsFromAnnotation(data));
            }

        }

//        Annotation[] das = t.getDeclaredAnnotations();
//        System.out.println("============= <B> ==============");
//        for(int i=0;i<das.length;i++){
//            System.out.println(das[i].annotationType());        
//        }        
//        System.out.println("===================================");
    }
//    public  int startTest(final Object object) {
//        try {
//            
////            System.out.println("-----> lllego a startTest");
////        Class<?> claseAnalizar =object.getClass();
////        final Field[] variables = claseAnalizar.getDeclaredFields();
////         System.out.println("-----> voy a leer field");
////        for (final Field variable : variables) {
////            final Annotation anotacionObtenida = variable.getAnnotation(Test.class);
////             System.out.println("-----> voy a leer anotaciones");
////            if (anotacionObtenida != null && anotacionObtenida instanceof Test) {
////                final Test anotacionTest = (Test) anotacionObtenida;
////      
////                String name = anotacionTest.name();
////                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
////                System.out.println(" name "+name);
////
////            }else{
////                System.out.println("no es anotacion con data o es null");
////            }
//
////        }
//          } catch (Exception e) {
//              System.out.println("startTest() "+e.getLocalizedMessage());
//        }
//        return 0;
//    }

    public void assertEquals(Object expect, Object result, String... message) {
        String mess = "";
        if (message.length != 0) {
            mess = message[0];
        }

        if (expect.equals(result)) {
            System.out.println(mess);
            testEnvironment.getResumen().setSuccess(testEnvironment.getResumen().getSuccess() + 1);
        } else {
            testEnvironment.getResumen().setError(testEnvironment.getResumen().getError() + 1);
            System.out.println(mess);
        }

    }

    public void assertTrue(Boolean condition) {
        if (condition) {
            System.out.println(" es igual");
            testEnvironment.getResumen().setSuccess(testEnvironment.getResumen().getSuccess() + 1);
        } else {
            testEnvironment.getResumen().setError(testEnvironment.getResumen().getError() + 1);
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
            testEnvironment.getResumen().setSuccess(testEnvironment.getResumen().getSuccess() + 1);
        } else {
            testEnvironment.getResumen().setError(testEnvironment.getResumen().getError() + 1);
        }

    }

    public void assertFalse(Boolean condition) {
        if (!condition) {
            System.out.println(" es igual");
            testEnvironment.getResumen().setSuccess(testEnvironment.getResumen().getSuccess() + 1);
        } else {
            testEnvironment.getResumen().setError(testEnvironment.getResumen().getError() + 1);
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
            testEnvironment.getResumen().setSuccess(testEnvironment.getResumen().getSuccess() + 1);
        } else {
            testEnvironment.getResumen().setError(testEnvironment.getResumen().getError() + 1);
        }

    }

    public void fail(String message) {
        System.out.println(message);
        testEnvironment.getResumen().setFailures(testEnvironment.getResumen().getFailures() + 1);

    }

    public void assertNull(Object object, String... message) {
        System.out.println(message);
        testEnvironment.getResumen().setFailures(testEnvironment.getResumen().getFailures() + 1);

    }

    public void assertNotNull(Object object, String... message) {
        System.out.println(message);
        testEnvironment.getResumen().setFailures(testEnvironment.getResumen().getFailures() + 1);

    }

    public void assertNotSame(Object object, String... message) {
        System.out.println(message);
        testEnvironment.getResumen().setFailures(testEnvironment.getResumen().getFailures() + 1);

    }

    public void path() {
//        Path resourceDirectory = Paths.get("src","test","resources");
//        System.out.println(" "+ resourceDirectory.toAbsolutePath());
//        URL location =  this.getClass().getResource("/reports");
//    String FullPath = location.getPath();
//    testEnvironment.setPathReports(FullPath);
//    System.out.println(FullPath);
//   // System.setProperty("javax.net.ssl.keyStore", FullPath); 
    }
}
