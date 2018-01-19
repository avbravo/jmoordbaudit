/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.report;

import com.avbravo.jmoordbunit.util.UnitUtil;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 *
 * @author avbravoserver
 */
//@Stateless
public class UnitReport {

    private String separator = java.nio.file.FileSystems.getDefault().getSeparator();
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(UnitReport.class.getName());

    /**
     * Creates a new instance of Facade
     */
    public void create(String pathr) {
        try {
            System.out.println("---> creando reporte en: " + pathr + UnitUtil.separator() + "unitreports.html");
            Path path = Paths.get(pathr + UnitUtil.separator() + "unitreports.html");

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write("<!DOCTYPE html>");
                writer.write("<!-- saved from url=(0044)http://junit.org/junit4/surefire-report.html -->");
                writer.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">");
                writer.write("    <head>");
                writer.write("        <title>jmoordbUnit-Report</title>");
                writer.write("    <head>");
                writer.write("    <body>");
                writer.write("    <hr>");
                writer.write("        <footer>");
                writer.write("            <div>");
                writer.write("                <div>Copyright ©                    2018");
                writer.write("                     <a href=\"http://avbravo.blogspot.com/\">jmoordbUnit</a>.");
                writer.write("                     All Rights Reserved.");
                writer.write("            </div>");
                writer.write("        </footer>");
                writer.write("    </body>");
                writer.write("</html>");

            }

        } catch (Exception e) {
            System.out.println("create() " + e.getLocalizedMessage());

        }
    }

}
