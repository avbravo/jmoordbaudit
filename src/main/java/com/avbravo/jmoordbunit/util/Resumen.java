/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.util;

/**
 *
 * @author avbravo
 */
public class Resumen {
    Integer testvalue;
    Integer error;
    Integer failures;
    Integer skipped;
    Integer success;
    Double successrate;
    Double seconds;

    public Resumen() {
    }

    public Resumen(Integer testvalue, Integer error, Integer failures, Integer skipped, Integer success, Double successrate, Double seconds) {
        this.testvalue = testvalue;
        this.error = error;
        this.failures = failures;
        this.skipped = skipped;
        this.success = success;
        this.successrate = successrate;
        this.seconds = seconds;
    }

    
    
    
    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

   
    
    
    
    
    public Integer getTestvalue() {
        return testvalue;
    }

    public void setTestvalue(Integer testvalue) {
        this.testvalue = testvalue;
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

    public Double getSeconds() {
        return seconds;
    }

    public void setSeconds(Double seconds) {
        this.seconds = seconds;
    }
    
    
    
    
}
