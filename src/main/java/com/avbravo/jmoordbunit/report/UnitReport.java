/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.report;

import com.avbravo.jmoordbunit.pojos.Clases;
import com.avbravo.jmoordbunit.pojos.Metodos;
import com.avbravo.jmoordbunit.pojos.Resumen;
import com.avbravo.jmoordbunit.util.UnitUtil;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
    public void create(String pathr, Resumen resumen, List<Clases> clasesList) {
        try {
            System.out.println("---> creando reporte en: " + pathr + "unitreports.html");
            Path path = Paths.get(pathr + UnitUtil.separator() + "unitreports.html");

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write("<!DOCTYPE html>\n");
                writer.write("<!-- saved from url=(0044)http://junit.org/junit4/surefire-report.html -->\n");
                writer.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n");
                writer.write("    <head>\n");
                writer.write("        <title>jmoordbUnit-Report</title>\n");
                writer.write("<style>\n");
                writer.write(".tomato{\n");
                writer.write("    background-color: tomato;\n");
                writer.write("    color:white;\n");
                writer.write("    padding: 10px;\n");
                writer.write("}\n");

                writer.write(".burlywood{\n");
                writer.write("    background-color: burlywood;\n");
                writer.write("    color:white;\n");
                writer.write("    padding: 10px;\n");
                writer.write("}\n");
                
                writer.write(".darkcyan{\n");
                writer.write("    background-color: darkcyan;\n");
                writer.write("    color:white;\n");
                writer.write("    padding: 10px;\n");
                writer.write("}\n");

                writer.write("</style>\n");
                writer.write("    </head>\n");
                writer.write("    <body>\n");
                /*  
                * title
                 */
                writer.write("<h1 class=\"tomato\">JmoordbUnit</h1> \n");
                writer.write("<h2>Testing Report</h2>\n");
                writer.write("<div>\n");
                writer.write("            <div>\n");
                writer.write("                <ul>\n");
                writer.write("                    <li>Fecha:" + UnitUtil.fechaFormateada() + " </li> \n");
                writer.write("                </ul>\n");
                writer.write("            </div>\n");
                /*
                Body
                 */
                writer.write("            <div>\n");

                /*
                Heaader 2
                 */
//                writer.write("                <div>\n");
//                writer.write("                    <h2>Testing Report<a name=\"Testing_Report\"></a></h2>\n");
//                writer.write("                </div>\n");
                /*
                Resumen
                 */
                writer.write("                <div>\n");

                writer.write("                    <h2 class=\"burlywood\">Resumen<a name=\"Resumen\"></a></h2><a name=\"Resumen\"></a>\n");
                writer.write("                    <p>[<a href=\"#Resumen\">Resumen</a>] [<a href=\"#Clases_List\">Clases List</a>] [<a href=\"#Test_Cases\">Test Cases</a>]</p><br>\n");
                writer.write("                    <table border=\"1\" >\n");
                writer.write("                        <tbody>\n");
                writer.write("                            <tr>\n");
                writer.write("                                <th>Tests</th>\n");
                writer.write("                                <th>Errors </th>\n");
                writer.write("                                <th>Failures</th>\n");
                writer.write("                                <th>Skipped</th>");
                writer.write("                                <th>Success</th>\n\n");
                writer.write("                                <th>Success Rate</th>\n");
                writer.write("                                <th>Time</th>\n");
                writer.write("                            </tr>\n");
                writer.write("                            <tr>\n");
                writer.write("                                <td>" + resumen.getTest() + "</td>\n");
                if (resumen.getError() > 0) {
                    writer.write("                                <td><font color=\"red\">" + resumen.getError() + "</font></td>\n");
                } else {
                    writer.write("                                <td>" + resumen.getError() + "</td>\n");
                }
                if (resumen.getFailures() > 0) {
                    writer.write("                                <td><font color=\"blue\">" + resumen.getFailures() + "</font></td>\n");
                } else {
                    writer.write("                                <td>" + resumen.getFailures() + "</td>\n");
                }
                writer.write("                                <td>" + resumen.getSkipped() + "</td>\n");
                writer.write("                                <td>" + resumen.getSuccess() + "</td>\n");
                writer.write("                                <td>" + UnitUtil.redondear(resumen.getSuccessrate(), 2) + "%</td>\n");
                writer.write("                                <td>" + UnitUtil.redondear(resumen.getTime(), 2) + "</td>\n");
                writer.write("                            </tr>\n");
                writer.write("                        </tbody>\n");
                writer.write("                    </table>\n");

                //---Resumen
                writer.write("                </div>\n");
                writer.write("                    <br>\n");
                writer.write("                    <br>\n");
                writer.write("                    <br>\n");
                /*
               clases List
                 */
                writer.write("                <div>\n");

                writer.write("                    <h2 class=\"burlywood\">Clases List <a name=\"Clases_List\"></a></h2><a name=\"Clases_List\"></a>\n");
                writer.write("                    <p>[<a href=\"#Resumen\">Resumen</a>] [<a href=\"#Clases_List\">Clases List</a>] [<a href=\"#Test_Cases\">Test Cases</a>]</p><br>\n");
                writer.write("                    <table border=\"1\" >\n");
                writer.write("                        <tbody>\n");
                writer.write("                            <tr>\n");
                writer.write("                                <th>Clase</th>\n");
                writer.write("                                <th>Tests</th>\n");
                writer.write("                                <th>Errors </th>\n");
                writer.write("                                <th>Failures</th>\n");
                writer.write("                                <th>Skipped</th>\n");
                writer.write("                                <th>Success</th>\n");
                writer.write("                                <th>Success Rate</th>\n");
//                writer.write("                                <th>Time</th>\n");
                writer.write("                            </tr>\n");
                for (Clases c : clasesList) {
                    writer.write("                            <tr>\n");
                    writer.write("                                <td>" + c.getClase() + "</td>\n");
                    writer.write("                                <td>" + c.getResumen().getTest() + "</td>\n");
                    if (c.getResumen().getError() > 0) {
                        writer.write("                                <td><font color=\"red\">" + c.getResumen().getError() + "</font></td>\n");
                    } else {
                        writer.write("                                <td>" + c.getResumen().getError() + "</td>\n");
                    }
                    if (c.getResumen().getFailures() > 0) {
                        writer.write("                                <td><font color=\"blue\">" + c.getResumen().getFailures() + "</font></td>\n");
                    } else {
                        writer.write("                                <td>" + c.getResumen().getFailures() + "</td>\n");
                    }

                    writer.write("                                <td>" + c.getResumen().getSkipped() + "</td>\n");
                    writer.write("                                <td>" + c.getResumen().getSuccess() + "</td>\n");
                    writer.write("                                <td>" + UnitUtil.redondear(c.getResumen().getSuccessrate(), 2) + "%</td>\n");
//                    writer.write("                                <td>" + UnitUtil.redondear(c.getResumen().getTime(), 2) + "</td>\n");
                    writer.write("                            </tr>\n");
                }

                writer.write("                        </tbody>\n");
                writer.write("                    </table>\n");
                writer.write("                    <br>\n");
                writer.write("                    <br>\n");
                writer.write("                    <br>\n");

                //---Clases List
                writer.write("                </div>\n");

                /*
               Metodos por clases
                 */
                writer.write("                <div>\n");

                writer.write("                    <h2 class=\"burlywood\">TestCases <a name=\"Test_Cases\"></a></h2><a name=\"Test_Cases\"></a>\n");
                writer.write("                    <p>[<a href=\"#Resumen\">Resumen</a>] [<a href=\"#Clases_List\">Clases List</a>] [<a href=\"#Test_Cases\">Test Cases</a>]</p><br>\n");
                for (Clases c : clasesList) {
                    writer.write("                    <h3 class=\"darkcyan\">Class: " + c.getClase() + "</h3> <p>[<a href=\"#Resumen\">Resumen</a>] [<a href=\"#Clases_List\">Clases List</a>] [<a href=\"#Test_Cases\">Test Cases</a>]</p><br>\n");
                    writer.write("                    <table border=\"1\" >\n");
                    writer.write("                        <tbody>\n");
                    writer.write("                            <tr>\n");
                    writer.write("                                <th>Metodo</th>\n");
                    writer.write("                                <th>Result</th>\n");

                    writer.write("                            </tr>\n");
                    for (Metodos m : c.getMetodos()) {
                        writer.write("                            <tr>\n");
                        writer.write("                                <td>" + m.getNombre() + "</td>\n");
                        switch (m.getResult()) {
                            case "errors":
                                writer.write("                                <td><font color=\"red\">" + m.getResult() + "</font>\n");
                                break;

                            case "failures":
                                writer.write("                                <td><font color=\"blue\">" + m.getResult() + "</font>\n");
                                break;
                            default:
                                writer.write("                                <td>" + m.getResult() + "</td>\n");
                        }
                        if (m.getResult().equals("errors")) {

                        } else {

                        }

                        writer.write("                            </tr>\n");
                    }
                    writer.write("                        </tbody>\n");
                    writer.write("                    </table>\n");
                    writer.write("                    <br>\n");
                    writer.write("                    <br>\n");
                    writer.write("                    <br>\n");

                }

                //---Clases List
                writer.write("                </div>\n");

                //--body
                writer.write("            </div>\n");

                //--title
                writer.write("        </div>\n");
                /**
                 * footer
                 */
                writer.write("    <hr>\n");
                writer.write("        <footer>\n");
                writer.write("            <div>");
                writer.write("                <div>Copyright ©                    2018\n");
                writer.write("                     <a href=\"http://avbravo.blogspot.com/\">jmoordbUnit</a>.\n");
                writer.write("                     All Rights Reserved.\n");
                writer.write("            </div>\n");
                writer.write("        </footer>\n");
                writer.write("    </body>\n");
                writer.write("</html>\n");

            }

        } catch (Exception e) {
            System.out.println("create() " + e.getLocalizedMessage());

        }
    }

}
