/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.report;

import com.avbravo.jmoordbunit.pojos.ClasesHtml;
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
public class ViewReport {

    private String separator = java.nio.file.FileSystems.getDefault().getSeparator();
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(ViewReport.class.getName());

    /**
     * Creates a new instance of Facade
     */
    public void create(String pathr, List<ClasesHtml> clasesHtmlList) {
        try {
            System.out.println("---> creando reporte en: " + pathr + "unitreportsview.html");
            Path path = Paths.get(pathr + UnitUtil.separator() + "unitreportsview.html");

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write("<!DOCTYPE html>\n");
                writer.write("<!-- saved from url=(0044)http://junit.org/junit4/surefire-report.html -->\n");
                writer.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n");
                writer.write("    <head>\n");
                writer.write("        <title>jmoordbUnit-Report View</title>\n");
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
                writer.write("<h1 class=\"tomato\">JmoordbUnit View</h1> \n");
                writer.write("<h2>View Report</h2>\n");
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
//                writer.write("                    <h2>Report <a name=\"Report\"></a></h2>\n");
//                writer.write("                </div>\n");

                /*
               Metodos por clases
                 */
                writer.write("                <div>\n");

                writer.write("                    <h2 class=\"burlywood\">View Cases <a name=\"View_Cases\"></a></h2><a name=\"View_Cases\"></a>\n");
//                writer.write("                    <p>[<a href=\"#Resumen\">Resumen</a>] [<a href=\"#Clases_List\">Clases List</a>] [<a href=\"#Test_Cases\">Test Cases</a>]</p><br>\n");
                for (ClasesHtml c : clasesHtmlList) {
                    writer.write("                    <br>\n");
                    writer.write("                    <h3 class=\"darkcyan\">Class: " + c.getClase() + "</h3> <p>[<a href=\"#View_Cases\">View Cases</a>]</p><br>\n");
                    if (!c.getViewHtml().toString().isEmpty()) {
                        writer.write("                    <br>\n");
                        writer.write(c.getViewHtml().toString());
                    }

                }
                writer.write("                        </tbody>\n");
                writer.write("                    </table>\n");
                writer.write("                    <br>\n");
                writer.write("                    <br>\n");
                writer.write("                    <br>\n");

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
