/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.report;

import com.avbravo.jmoordbunit.pojos.Resumen;
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
    public void create(String pathr,Resumen resumen) {
        try {
            System.out.println("---> creando reporte en: " + pathr + "unitreports.html");
            Path path = Paths.get(pathr + UnitUtil.separator() + "unitreports.html");

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write("<!DOCTYPE html>");
                writer.write("<!-- saved from url=(0044)http://junit.org/junit4/surefire-report.html -->");
                writer.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">");
                writer.write("    <head>");
                writer.write("        <title>jmoordbUnit-Report</title>");
                writer.write("    <head>");
                writer.write("    <body>");
                /*  
                * title
                 */
                writer.write("<div>");
                writer.write("            <div>");
                writer.write("                <ul>");
                writer.write("                    <li>");
                writer.write("                        <h1>JmoordbUnit</h1> ");
                writer.write("                    </li>");
                writer.write("                    <li>Testing Report</li>");
                writer.write("                    <li>Fecha:" + UnitUtil.fechaFormateada() + " </li> ");
                writer.write("                </ul>");
                writer.write("            </div>");
                /*
                Body
                 */
                writer.write("            <div>");

                /*
                Heaader 2
                 */
                writer.write("                <div>");
                writer.write("                    <h2>Testing Report<a name=\"Testing_Report\"></a></h2>");
                writer.write("                </div>");
                /*
                Resumen
                 */
                writer.write("                <div>");

                writer.write("                    <h2>Resumen<a name=\"Resumen\"></a></h2><a name=\"Resumen\"></a>");
                writer.write("                    <p>[<a href=\"#Resumen\">Resumen</a>] [<a href=\"#Clases_List\">Clases List</a>] [<a href=\"#Test_Cases\">Test Cases</a>]</p><br>");
                writer.write("                    <table border=\"1\" >");
                writer.write("                        <tbody>");
                writer.write("                            <tr>");
                writer.write("                                <th>Tests</th>");
                writer.write("                                <th>Errors </th>");
                writer.write("                                <th>Failures</th>");
                writer.write("                                <th>Skipped</th>");
                writer.write("                                <th>Success</th>");
                writer.write("                                <th>Success Rate</th>");
                writer.write("                                <th>Time</th>");
                writer.write("                            </tr>");
                writer.write("                            <tr>");
                writer.write("                                <td>"+resumen.getTest()+"</td>");
                writer.write("                                <td>"+resumen.getError()+"</td>");
                writer.write("                                <td>"+resumen.getFailures()+"</td>");
                writer.write("                                <td>"+resumen.getSkipped()+"</td>");
                writer.write("                                <td>"+resumen.getSuccess()+"</td>");
                writer.write("                                <td>"+resumen.getSuccessrate()+"%</td>");
                writer.write("                                <td>"+resumen.getTime()+"</td>");
                writer.write("                            </tr>");
                writer.write("                        </tbody>");
                writer.write("                    </table>");

                //Resumen
                writer.write("                </div>");

                //body
                writer.write("            </div>");

                //title
                writer.write("        </div>");
                /**
                 * footer
                 */
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
