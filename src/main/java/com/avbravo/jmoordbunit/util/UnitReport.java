/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author avbravoserver
 */
@Named
@RequestScoped
public class UnitReport implements Serializable {
private String separator = java.nio.file.FileSystems.getDefault().getSeparator();
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(UnitReport.class.getName());

   
    /**
     * Creates a new instance of Facade
     */
    public void generar() {
        try {
            //recorrer el entity para verificar que existan todos los EJB

            procesar("footer.xhtml", "/home/avbravo/Descargas/" + "footer.xhtml");

        } catch (Exception e) {
            System.out.println("generar() " + e.getLocalizedMessage());

        }
    }

    private Boolean procesar(String archivo, String ruta) {
        try {

            Path path = Paths.get(ruta);
            if (Files.notExists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
                crearFile(ruta, archivo);
            }

        } catch (Exception e) {
            System.out.println("procesar() " + e.getLocalizedMessage());
        }
        return true;

    }

    /**
     * deleteAll
     *
     * @param entidad
     * @param archivo
     * @return
     */
    private Boolean crearFile(String path, String archivo) throws IOException {
        try {

            String ruta = path;
            File file = new File(ruta);
            BufferedWriter bw;
            if (file.exists()) {
                // El fichero ya existe
            } else {
                // El fichero no existe y hay que crearlo
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.close();
//      bw.write("Acabo de crear el fichero de texto.");

                File file2 = new File(ruta);
                //Creamos un objeto para escribir caracteres en el archivo de prueba
                try (FileWriter fw = new FileWriter(file)) {

                    fw.write("<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"" + "\r\n");
                    fw.write("      xmlns:ui=\"http://java.sun.com/jsf/facelets\"" + "\r\n");
                    fw.write("      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"" + "\r\n");
                    fw.write("      xmlns:b=\"http://bootsfaces.net/ui\"" + "\r\n");
                    fw.write("      xmlns:f=\"http://xmlns.jcp.org/jsf/core\"" + "\r\n");
                    fw.write("      xmlns:p=\"http://primefaces.org/ui\">" + "\r\n");
                    fw.write("" + "\r\n");
                    fw.write("      <footer class=\"main-footer\">" + "\r\n");
                    fw.write("          <!-- To the right -->" + "\r\n");
                    fw.write("          <div class=\"pull-right hidden-xs\">" + "\r\n");
                    fw.write("                            #{msg['footer.texto']}" + "\r\n");
                    fw.write("          </div>" + "\r\n");
                    fw.write("          <!-- Default to the left -->" + "\r\n");
                    fw.write("          <strong>#{msg['footer.copyright']}<a href=\"#\">#{msg['footer.empresa']}</a>.</strong> " + "\r\n");
                    fw.write("                          #{msg['footer.derechosreservados']}" + "\r\n");
                    fw.write("      </footer>" + "\r\n");
                    fw.write("    </ui:composition>" + "\r\n");
                    fw.close();

                } catch (IOException ex) {
                    System.out.println("crearFile() " + ex.getLocalizedMessage());
                }

            }
        } catch (Exception e) {
            System.out.println("crearFile() " + e.getLocalizedMessage());
        }
        return false;
    }

}
