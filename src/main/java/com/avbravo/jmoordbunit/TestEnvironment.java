/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit;

import com.avbravo.jmoordbunit.pojos.Clases;
import com.avbravo.jmoordbunit.pojos.ClasesHtml;
import com.avbravo.jmoordbunit.pojos.Resumen;
import com.avbravo.jmoordbunit.test.Colores;
import com.avbravo.jmoordbunit.test.UnitReport;
import com.avbravo.jmoordbunit.view.ViewReport;
import com.avbravo.jmoordbunit.util.UnitUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author avbravo
 */
@Startup
@Singleton
public class TestEnvironment {

//    @Inject
//    UnitReport unitReport;
    public enum States {
        BEFORESTARTED, STARTED, PAUSED, SHUTTINGDOWN
    };
    private States state;
    private Resumen resumen = new Resumen();
    private String pathReports = "";
    List<Clases> clasesList = new ArrayList<>();
    List<ClasesHtml> clasesHtmlList = new ArrayList<>();

    @PostConstruct
    public void initialize() {
        state = States.BEFORESTARTED;
        // Perform intialization

        state = States.STARTED;
        clasesList = new ArrayList<>();
        clasesHtmlList = new ArrayList<>();

        resumen.setError(0);
        resumen.setFailures(0);
        resumen.setTime(0.0);
        resumen.setSkipped(0);
        resumen.setSuccessrate(0.0);
        resumen.setTest(0);
        resumen.setSuccess(0);
        resumen.setMilisegundosstart(UnitUtil.milisegundos());
        resumen.setMilisegundosend(0);

        System.out.println(Colores.purpura()+"---------------------------------------------------");
        System.out.println(Colores.verde()+"");
        System.out.println(Colores.verde()+"              TestEnvironment Started     ");
        System.out.println(Colores.verde()+"");
        System.out.println(Colores.purpura()+"---------------------------------------------------");
    }

    @PreDestroy
    public void terminate() {
        state = States.SHUTTINGDOWN;

        //Resumen
        resumen.setMilisegundosend(UnitUtil.milisegundos());
        long milisegundos = UnitUtil.milisegundosTranscurridos(resumen.getMilisegundosstart(), resumen.getMilisegundosend());
        resumen.setTime(UnitUtil.milisegundosToSegundos(milisegundos).doubleValue());

        Collections.sort(clasesList,
                (Clases a, Clases b) -> a.getClase().compareTo(b.getClase()));

        Collections.sort(clasesHtmlList,
                (ClasesHtml a, ClasesHtml b) -> a.getClase().compareTo(b.getClase()));
        //Verifica el list
        if (!clasesList.isEmpty()) {
            Integer index = -1;
            for (Clases c : clasesList) {
                index++;
                Resumen resumen = new Resumen();
                resumen = c.getResumen();
                if (resumen.getMilisegundosend() == 0) {
                    //no se indico el fin
                    resumen.setMilisegundosend(UnitUtil.milisegundos());
                    clasesList.get(index).getResumen().setMilisegundosend(resumen.getMilisegundosend());
                    resumen.setTime(UnitUtil.milisegundosToSegundos(milisegundos).doubleValue());
                    resumen.setSuccessrate((resumen.getSuccess().doubleValue() * 100) / resumen.getTest().doubleValue());

                    clasesList.get(index).getResumen().setTime(resumen.getTime());
                    clasesList.get(index).getResumen().setSuccessrate(resumen.getSuccessrate());
                }

            }
        }

        // Perform termination
        System.out.println("");
        System.out.println("");
        System.out.println(Colores.verde() + "|=====================================================================|");
        System.out.println("|                           Jmoordbunit                           |");
        System.out.println("|                        Testing finalizado                       |");

        System.out.println("|                                   (Resumen)                     |");
        System.out.println("|     Test |  Error  | Failures | Skippes |  Success|SuccessRate | Time  |      |");
        System.out.println("|-------------------------------------------------------------------------------|");
        System.out.println("|     " + resumen.getTest() + "  | " + resumen.getError() + "   |  " + resumen.getFailures() + "  |  " + resumen.getSkipped() + "  |  " + resumen.getSuccess() + "  |  " + "  |  " + resumen.getSuccessrate() + "  | " + resumen.getTime() + " |");
        System.out.println("|-------------------------------------------------------------------------------|");

        System.out.println(Colores.verde() + "|=====================================================================|");

        if (pathReports.equals("")) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("-            No se ha definido un Test con la ruta para generar reportes  -");
            System.out.println("-            Agregue la anotacion:                                        -");
            System.out.println("-                             @Report(path=\"\\mypathtoreport\\\"         -");
            System.out.println("---------------------------------------------------------------------------");
        } else {
            System.out.println("");
            System.out.println("");
            System.out.println(Colores.verde() + "|=====================================================================|");
            System.out.println("|         Ruta de reportes generados: " + Colores.azul() + pathReports);
            System.out.println("|---------------------------------------------------------------------|");
            resumen.setSuccessrate((resumen.getSuccess().doubleValue() * 100) / resumen.getTest().doubleValue());
            /*
            Generar el reporte
             */
            UnitReport unitReport = new UnitReport();
            unitReport.create(pathReports, resumen, clasesList);

//            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
//            
//            for(ClasesHtml c:clasesHtmlList){
//                System.out.println("---------> "+c.getClase());
//                System.out.println("---------> "+c.getViewHtml().toString());
//            }
//            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            ViewReport viewReport = new ViewReport();
            viewReport.create(pathReports, clasesHtmlList);
            System.out.println(Colores.verde() + "|=====================================================================|");
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    public List<ClasesHtml> getClasesHtmlList() {
        return clasesHtmlList;
    }

    public void setClasesHtmlList(List<ClasesHtml> clasesHtmlList) {
        this.clasesHtmlList = clasesHtmlList;
    }

    public List<Clases> getClasesList() {
        return clasesList;
    }

    public void setClasesList(List<Clases> clasesList) {
        this.clasesList = clasesList;
    }

    public String getPathReports() {
        return pathReports;
    }

    public void setPathReports(String pathReports) {
        this.pathReports = pathReports;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public Resumen getResumen() {
        return resumen;
    }

    public void setResumen(Resumen resumen) {
        this.resumen = resumen;
    }

}
