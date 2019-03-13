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
public class Resumen {
    Integer test;
    Integer error;
    Integer failures;
    Integer skipped;
    Integer success;
    Double  successrate;
    Double  time;
    long milisegundosstart;
    long milisegundosend;

    public Resumen() {
    }

    public Resumen(Integer test, Integer error, Integer failures, Integer skipped, Integer success, Double successrate, Double time, long milisegundosstart, long milisegundosend) {
        this.test = test;
        this.error = error;
        this.failures = failures;
        this.skipped = skipped;
        this.success = success;
        this.successrate = successrate;
        this.time = time;
        this.milisegundosstart = milisegundosstart;
        this.milisegundosend = milisegundosend;
    }

    
    
    
    public long getMilisegundosstart() {
        return milisegundosstart;
    }

    public void setMilisegundosstart(long milisegundosstart) {
        this.milisegundosstart = milisegundosstart;
    }

    public long getMilisegundosend() {
        return milisegundosend;
    }

    public void setMilisegundosend(long milisegundosend) {
        this.milisegundosend = milisegundosend;
    }

  

    
    
    
    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

   
    
    
    

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

   
    
    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

   
   
    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public Integer getFailures() {
        return failures;
    }

    public void setFailures(Integer failures) {
        this.failures = failures;
    }

    public Integer getSkipped() {
        return skipped;
    }

    public void setSkipped(Integer skipped) {
        this.skipped = skipped;
    }

    public Double getSuccessrate() {
        return successrate;
    }

    public void setSuccessrate(Double successrate) {
        this.successrate = successrate;
    }

   
    
    
}
