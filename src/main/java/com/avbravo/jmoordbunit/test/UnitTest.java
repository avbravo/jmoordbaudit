/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.test;

import com.avbravo.jmoordbunit.anotation.Test;
import com.avbravo.jmoordbunit.TestEnvironment;
import com.avbravo.jmoordbunit.anotation.Report;
import com.avbravo.jmoordbunit.pojos.Clases;
import com.avbravo.jmoordbunit.pojos.Metodos;
import com.avbravo.jmoordbunit.pojos.Resumen;
import com.avbravo.jmoordbunit.util.UnitUtil;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author avbravo
 */
@Stateless
public class UnitTest<T> {

    private String nameOfClass = "";
    @Inject
    TestEnvironment testEnvironment;

    /*
Lee las anotaciones @Test, @Report
     */
    // <editor-fold defaultstate="collapsed" desc="start(Class<T> t)"> 
    public void start(Class<T> t) {
        System.out.println("|--------------------------------------------|");
        System.out.println("|----->Clase: " + t.getSimpleName());
        this.nameOfClass = t.getSimpleName();
        Clases clases = new Clases();
        clases.setClase(t.getSimpleName());
        clases.setResumen(new Resumen(0, 0, 0, 0, 0, 0.0, 0.0, UnitUtil.milisegundos(), 0));
        List<Metodos> metodosList = new ArrayList<>();
        clases.setMetodos(metodosList);
        
        testEnvironment.getClasesList().add(clases);
        Annotation a = t.getAnnotation(Test.class);
        if (a == null) {
//            System.out.println("..." + t.getSimpleName() + " No tiene anotacion @Test");
        }

        Annotation b = t.getAnnotation(Report.class);
        if (b == null) {
            //System.out.println("----> no tiene la anotacion @Report");
        } else {
            String data = b.toString();
            //  System.out.println(data);
            if (data.contains("@com.avbravo.jmoordbunit.anotation.Report(path=)")) {
                System.out.println("----->Solo tiene la anotacion @Report definida sin valor");
            } else {

                testEnvironment.setPathReports(UnitUtil.getPathOfReportsFromAnnotation(data));
            }

        }

    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="end"> 

    public void end(Class<T> t) {
        try {
            Integer index = -1;

            for (Clases c : testEnvironment.getClasesList()) {
                index++;
                if (c.getClase().equals(t.getSimpleName())) {
                    //actualizo los datos
                    testEnvironment.getClasesList().get(index).getResumen().setMilisegundosend(UnitUtil.milisegundos());

                    Resumen resumen = testEnvironment.getClasesList().get(index).getResumen();
                    long milisegundos = UnitUtil.milisegundosTranscurridos(resumen.getMilisegundosstart(), resumen.getMilisegundosend());
                    resumen.setTime(UnitUtil.milisegundosToSegundos(milisegundos).doubleValue());
                    resumen.setSuccessrate((resumen.getSuccess().doubleValue() * 100) / resumen.getTest().doubleValue());

                    testEnvironment.getClasesList().get(index).getResumen().setTime(resumen.getTime());
                    testEnvironment.getClasesList().get(index).getResumen().setSuccessrate(resumen.getSuccessrate());
                }
            }
        } catch (Exception e) {
            System.out.println("end() " + e.getLocalizedMessage());
        }

    }// </editor-fold>
   
 // <editor-fold defaultstate="collapsed" desc="indexOfClasesList()"> 

    private Integer indexOfClasesList() {
        Integer index = -1;
        try {

            for (Clases c : testEnvironment.getClasesList()) {
                index++;
                if (c.getClase().equals(this.nameOfClass)) {
                 
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("indexOfClasesList()");
        }
        return index;
    }// </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="indexOfClasesList()"> 

    private Integer sizeOfMethods() {
        Integer size= 0;
        try {

            for (Clases c : testEnvironment.getClasesList()) {
 
                if (c.getClase().equals(this.nameOfClass)) {
                  size=c.getMetodos().size();
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("indexOfClasesList()");
        }
        return size;
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="updateTest()"> 
    private void updateTest() {
        try {
            testEnvironment.getResumen().setTest(testEnvironment.getResumen().getTest() + 1);
            Integer index = indexOfClasesList();
            if (index >= 0 && index <= testEnvironment.getClasesList().size()) {
                testEnvironment.getClasesList().get(index).getResumen().setTest(testEnvironment.getClasesList().get(index).getResumen().getTest() + 1);
            }
        } catch (Exception e) {
            System.out.println("udpateTest() " + e.getLocalizedMessage());
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="udpateSuccess()"> 
    private void updateSuccess(String metodo) {
        try {
            testEnvironment.getResumen().setSuccess(testEnvironment.getResumen().getSuccess() + 1);
            //update list
            Integer index = indexOfClasesList();
            if (index >= 0 && index <= testEnvironment.getClasesList().size()) {
                testEnvironment.getClasesList().get(index).getResumen().setSuccess(testEnvironment.getClasesList().get(index).getResumen().getSuccess() + 1);
                
                testEnvironment.getClasesList().get(index).getMetodos().add(new Metodos(metodo, "success"));
            }

        } catch (Exception e) {
            System.out.println("udpateSuccess() " + e.getLocalizedMessage());
        }
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="updateFailures()"> 

    private void updateFailures(String metodo) {
        try {
            testEnvironment.getResumen().setFailures(testEnvironment.getResumen().getFailures() + 1);
            //update list
            Integer index = indexOfClasesList();
            if (index >= 0 && index <= testEnvironment.getClasesList().size()) {
                testEnvironment.getClasesList().get(index).getResumen().setFailures(testEnvironment.getClasesList().get(index).getResumen().getFailures() + 1);
                testEnvironment.getClasesList().get(index).getMetodos().add(new Metodos(metodo, "failures"));
            }

        } catch (Exception e) {
            System.out.println("updateFailures() " + e.getLocalizedMessage());
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="udpateErrors()"> 
    private void updateErrors(String metodo) {
        try {
            testEnvironment.getResumen().setError(testEnvironment.getResumen().getError() + 1);
            //update list
            Integer index = indexOfClasesList();
            if (index >= 0 && index <= testEnvironment.getClasesList().size()) {
                testEnvironment.getClasesList().get(index).getResumen().setError(testEnvironment.getClasesList().get(index).getResumen().getError() + 1);
                testEnvironment.getClasesList().get(index).getMetodos().add(new Metodos(metodo, "errors"));
            }

        } catch (Exception e) {
            System.out.println("updateErrors() " + e.getLocalizedMessage());
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="udpateSkipped()"> 
    private void updateSkipped(String metodo) {
        try {
            testEnvironment.getResumen().setSkipped(testEnvironment.getResumen().getSkipped() + 1);
            //update list
            Integer index = indexOfClasesList();
            if (index >= 0 && index <= testEnvironment.getClasesList().size()) {
                testEnvironment.getClasesList().get(index).getResumen().setSkipped(testEnvironment.getClasesList().get(index).getResumen().getSkipped() + 1);
                testEnvironment.getClasesList().get(index).getMetodos().add(new Metodos(metodo, "skipped"));
            }

        } catch (Exception e) {
            System.out.println("updateSkipped() " + e.getLocalizedMessage());
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertEquals()"> 
    public void assertEquals(String metodo,Object expect, Object result, String... message) {

        updateTest();
        String mess = "";
        if (message.length != 0) {
            mess = message[0];
            System.out.println(mess);
        }
        if (expect.equals(result)) {
            updateSuccess(metodo);

        } else {
           updateErrors(metodo);
        }

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertNotEquals()"> 
    public void assertNotEquals(String metodo,Object expect, Object result, String... message) {

        updateTest();
        String mess = "";
        if (message.length != 0) {
            mess = message[0];
            System.out.println(mess);
        }
        if (!expect.equals(result)) {
            updateSuccess(metodo);
        } else {
           updateErrors(metodo);
        }

    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="skipper()"> 
    public void skipper(String method, String... message) {

        updateTest();
        String mess = "";
        if (message.length != 0) {
            mess = message[0];
            System.out.println(mess);
        }
       
           updateSkipped(method);
       

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertTrue(Boolean condition)"> 
    public void assertTrue(String metodo,Boolean condition) {
        updateTest();
        if (condition) {
            updateSuccess(metodo);
        } else {
          updateErrors(metodo);
        }

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertTrue(Boolean condition, String... message)"> 
    public void assertTrue(String metodo,Boolean condition, String... message) {
        updateTest();
        String mess = "";
        if (message.length != 0) {
            mess = message[0];

        }
        if (condition) {
            System.out.println("es true ");
            updateSuccess(metodo);
        } else {
          updateErrors(metodo);
        }

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertFalse(Boolean condition)"> 
    public void assertFalse(String metodo,Boolean condition) {
        updateTest();
        if (!condition) {
            System.out.println(" es igual");
            updateSuccess(metodo);
        } else {
           updateErrors(metodo);
            System.out.println(" No es igual");
        }

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertFalse(Boolean condition, String... message)"> 
    public void assertFalse(String metodo,Boolean condition, String... message) {
        updateTest();
        String mess = "";
        if (message.length != 0) {
            mess = message[0];

        }
        if (!condition) {
            System.out.println("es true ");
            updateSuccess(metodo);
        } else {
            updateErrors(metodo);
            
        }

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="fail(String message)"> 
    public void fail(String metodo,String message) {
        updateTest();
        System.out.println(message);
        updateFailures(metodo);
    
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertNull(Object object, String... message)"> 
    public void assertNull(String metodo,Object object, String... message) {
        updateTest();
        String mess = "";
        if (message.length != 0) {
            mess = message[0];

        }

        System.out.println(mess);
        updateFailures(metodo);

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertNotNull(Object object, String... message)"> 
    public void assertNotNull(String metodo,Object object, String... message) {
        updateTest();
        String mess = "";
        if (message.length != 0) {
            mess = message[0];

        }

        System.out.println(mess);
         updateErrors(metodo);
    }// </editor-fold>

}
