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
import com.avbravo.jmoordbunit.pojos.Resumen;
import com.avbravo.jmoordbunit.util.UnitUtil;
import java.lang.annotation.Annotation;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.swing.plaf.synth.SynthLookAndFeel;

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
    // <editor-fold defaultstate="collapsed" desc="updateClasesList()"> 

    private Integer indexOfClasesList() {
        Integer index = -1;
        try {

            for (Clases c : testEnvironment.getClasesList()) {
                index++;
                if (c.getClase().equals(this.nameOfClass)) {
                    System.out.println("----->" +c.getClase() +"encontrole nombre de clase");
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("indexOfClasesList()");
        }
        return index;
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
    private void updateSuccess() {
        try {
            testEnvironment.getResumen().setSuccess(testEnvironment.getResumen().getSuccess() + 1);
            //update list
            Integer index = indexOfClasesList();
            if (index >= 0 && index <= testEnvironment.getClasesList().size()) {
                testEnvironment.getClasesList().get(index).getResumen().setSuccess(testEnvironment.getClasesList().get(index).getResumen().getSuccess() + 1);
            }

        } catch (Exception e) {
            System.out.println("udpateSuccess() " + e.getLocalizedMessage());
        }
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="updateFailures()"> 

    private void updateFailures() {
        try {
            testEnvironment.getResumen().setFailures(testEnvironment.getResumen().getFailures() + 1);
            //update list
            Integer index = indexOfClasesList();
            if (index >= 0 && index <= testEnvironment.getClasesList().size()) {
                testEnvironment.getClasesList().get(index).getResumen().setFailures(testEnvironment.getClasesList().get(index).getResumen().getFailures() + 1);
            }

        } catch (Exception e) {
            System.out.println("updateFailures() " + e.getLocalizedMessage());
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="udpateSuccess()"> 
    private void updateErrors() {
        try {
            testEnvironment.getResumen().setError(testEnvironment.getResumen().getError() + 1);
            //update list
            Integer index = indexOfClasesList();
            if (index >= 0 && index <= testEnvironment.getClasesList().size()) {
                testEnvironment.getClasesList().get(index).getResumen().setError(testEnvironment.getClasesList().get(index).getResumen().getError() + 1);
            }

        } catch (Exception e) {
            System.out.println("updateErrors() " + e.getLocalizedMessage());
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="udpateSuccess()"> 
    private void updateSkipped() {
        try {
            testEnvironment.getResumen().setSkipped(testEnvironment.getResumen().getSkipped() + 1);
            //update list
            Integer index = indexOfClasesList();
            if (index >= 0 && index <= testEnvironment.getClasesList().size()) {
                testEnvironment.getClasesList().get(index).getResumen().setSkipped(testEnvironment.getClasesList().get(index).getResumen().getSkipped() + 1);
            }

        } catch (Exception e) {
            System.out.println("updateSkipped() " + e.getLocalizedMessage());
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertEquals()"> 
    public void assertEquals(Object expect, Object result, String... message) {

        updateTest();
        String mess = "";
        if (message.length != 0) {
            mess = message[0];
            System.out.println(mess);
        }
        if (expect.equals(result)) {
            updateSuccess();

        } else {
           updateErrors();
        }

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertNotEquals()"> 
    public void assertNotEquals(Object expect, Object result, String... message) {

        updateTest();
        String mess = "";
        if (message.length != 0) {
            mess = message[0];
            System.out.println(mess);
        }
        if (!expect.equals(result)) {
            updateSuccess();
        } else {
           updateErrors();
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
       
           updateSkipped();
       

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertTrue(Boolean condition)"> 
    public void assertTrue(Boolean condition) {
        updateTest();
        if (condition) {
            updateSuccess();
        } else {
          updateErrors();
        }

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertTrue(Boolean condition, String... message)"> 
    public void assertTrue(Boolean condition, String... message) {
        updateTest();
        String mess = "";
        if (message.length != 0) {
            mess = message[0];

        }
        if (condition) {
            System.out.println("es true ");
            updateSuccess();
        } else {
          updateErrors();
        }

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertFalse(Boolean condition)"> 
    public void assertFalse(Boolean condition) {
        updateTest();
        if (!condition) {
            System.out.println(" es igual");
            updateSuccess();
        } else {
           updateErrors();
            System.out.println(" No es igual");
        }

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertFalse(Boolean condition, String... message)"> 
    public void assertFalse(Boolean condition, String... message) {
        updateTest();
        String mess = "";
        if (message.length != 0) {
            mess = message[0];

        }
        if (!condition) {
            System.out.println("es true ");
            updateSuccess();
        } else {
            updateErrors();
            
        }

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="fail(String message)"> 
    public void fail(String message) {
        updateTest();
        System.out.println(message);
        updateFailures();
    
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertNull(Object object, String... message)"> 
    public void assertNull(Object object, String... message) {
        updateTest();
        String mess = "";
        if (message.length != 0) {
            mess = message[0];

        }

        System.out.println(mess);
        updateFailures();

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="assertNotNull(Object object, String... message)"> 
    public void assertNotNull(Object object, String... message) {
        updateTest();
        String mess = "";
        if (message.length != 0) {
            mess = message[0];

        }

        System.out.println(mess);
         updateErrors();
    }// </editor-fold>

}
