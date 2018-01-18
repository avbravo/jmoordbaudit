/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit;

import com.avbravo.jmoordbunit.util.Resumen;
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
    public enum States {BEFORESTARTED, STARTED, PAUSED, SHUTTINGDOWN};
    private States state;
    private Resumen resumen = new Resumen();
    @PostConstruct
    public void initialize() {
        state = States.BEFORESTARTED;
        // Perform intialization
        state = States.STARTED;
        resumen.setError(0);
        resumen.setFailures(0);
        resumen.setSeconds(0.0);
        resumen.setSkipped(0);
        resumen.setSuccessrate(0.0);
        resumen.setTestvalue(0);
        resumen.setSuccess(0);
        
        System.out.println("--------------------------------");
        System.out.println("----------->TestEnvironment Started");
        System.out.println("--------------------------------");
    }
    @PreDestroy
    public void terminate() {
        state = States.SHUTTINGDOWN;
        // Perform termination
        System.out.println("--------------------------------");
        System.out.println("------------->TestEnvironment Shut down in progress ");
        System.out.println("--------------------------------");
        
        System.out.println("Resumen");
        System.out.println("Total de Errores" +resumen.getError());
        System.out.println("Total de Failures" +resumen.getFailures());
        System.out.println("Total de Success(" +resumen.getSuccess());
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

