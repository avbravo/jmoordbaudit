/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.anotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author avbravo
 */
@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
public @interface Report {
        String path() default "";
}
