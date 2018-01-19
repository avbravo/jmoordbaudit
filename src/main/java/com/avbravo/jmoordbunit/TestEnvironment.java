/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit;

import com.avbravo.jmoordbunit.pojos.Resumen;
import com.avbravo.jmoordbunit.report.UnitReport;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

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

    @PostConstruct
    public void initialize() {
        state = States.BEFORESTARTED;
        // Perform intialization
        state = States.STARTED;
        resumen.setError(0);
        resumen.setFailures(0);
        resumen.setTime(0.0);
        resumen.setSkipped(0);
        resumen.setSuccessrate(0.0);
        resumen.setTest(0);
        resumen.setSuccess(0);

        System.out.println("--------------------------------");
        System.out.println("----------->TestEnvironment Started");
        System.out.println("--------------------------------");
    }

    @PreDestroy
    public void terminate() {
        state = States.SHUTTINGDOWN;
        // Perform termination
        System.out.println("|------------------------------------------------------------------- -----------|");
        System.out.println("|----------------- Jmoordb Finalizo de generar los test ------------------------|");

        System.out.println("|     (Resumen)                                                                 |");
        System.out.println("|     Test |  Error  | Failures | Skippes |  Success|SuccessRate | Time  |      |");
        System.out.println("|-------------------------------------------------------------------------------|");
        System.out.println("|     " + resumen.getTest() + " | " + resumen.getError() + "  | " + resumen.getFailures() + "|" + resumen.getSkipped() + " | " + resumen.getSuccess() + " |" + " | " + resumen.getSuccessrate() + " |" + resumen.getTime() + "   |  |");
        System.out.println("|-------------------------------------------------------------------------------|");

        if (pathReports.equals("")) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("-            No se ha definido un Test con la ruta para generar reportes  -");
            System.out.println("-            Agregue la anotacion:                                        -");
            System.out.println("-                             @Report(path=\"\\mypathtoreport\\\"         -");
            System.out.println("---------------------------------------------------------------------------");
        } else {
            System.out.println("Se genero el reporte en la ruta: " + pathReports + "                         -");
            UnitReport unitReport = new UnitReport();
            unitReport.create(pathReports);
        }
        System.out.println("--------------------------------------------------------------------------------");
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
