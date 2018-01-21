/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.view;

import com.avbravo.jmoordbunit.TestEnvironment;
import com.avbravo.jmoordbunit.pojos.ClasesHtml;
import com.avbravo.jmoordbunit.pojos.ColView;
import com.avbravo.jmoordbunit.pojos.RowView;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author avbravo
 */
@Stateless
public class UnitView<T> {

    private String nameOfClass = "";
    @Inject
    TestEnvironment testEnvironment;

    /*
Lee las anotaciones @Test, @Report
     */
    // <editor-fold defaultstate="collapsed" desc="start(Class<T> t)"> 
    public void start(Class<T> t) {
try {
        this.nameOfClass = t.getSimpleName();
        ClasesHtml clasesHtml = new ClasesHtml();
        clasesHtml.setClase(t.getSimpleName());
        StringBuilder viewHtml = new StringBuilder();
        viewHtml.append("");
        clasesHtml.setViewHtml(viewHtml);
    

        testEnvironment.getClasesHtmlList().add(clasesHtml);
   } catch (Exception e) {
            System.out.println("start() " + e.getLocalizedMessage());
        }
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="end"> 

    public void end(Class<T> t) {
        try {
            Integer index = -1;

            for (ClasesHtml c : testEnvironment.getClasesHtmlList()) {
                index++;
                if (c.getClase().equals(t.getSimpleName())) {
                    //actualizo los datos
//                    testEnvironment.getClasesHtmlList().get(index).getResumen().setMilisegundosend(UnitUtil.milisegundos());
//
//                    Resumen resumen = testEnvironment.getClasesHtmlList().get(index).getResumen();
//                    long milisegundos = UnitUtil.milisegundosTranscurridos(resumen.getMilisegundosstart(), resumen.getMilisegundosend());
//                    resumen.setTime(UnitUtil.milisegundosToSegundos(milisegundos).doubleValue());
//                    resumen.setSuccessrate((resumen.getSuccess().doubleValue() * 100) / resumen.getTest().doubleValue());
//
//                    testEnvironment.getClasesHtmlList().get(index).getResumen().setTime(resumen.getTime());
//                    testEnvironment.getClasesHtmlList().get(index).getResumen().setSuccessrate(resumen.getSuccessrate());
                }
            }
        } catch (Exception e) {
            System.out.println("end() " + e.getLocalizedMessage());
        }

    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="tableHeader(List<Row> rowList)"> 

    public void tableHeader(List<RowView> rowList) {
        try {
            if (!rowList.isEmpty()) {
                Integer index = indexOfClasesHtmlList();
                testEnvironment.getClasesHtmlList().get(index).getViewHtml().append("<table border=\"1\" >\n");
                testEnvironment.getClasesHtmlList().get(index).getViewHtml().append("   <tbody>\n");
                testEnvironment.getClasesHtmlList().get(index).getViewHtml().append("     <tr>\n");
                rowList.stream().map((r) -> {
                    StringBuilder temp = new StringBuilder();
                    temp.append("<th>").append(r.getTitle()).append("</th>\n");
                    return temp;
                }).forEachOrdered((temp) -> {
                    testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());
                });
                testEnvironment.getClasesHtmlList().get(index).getViewHtml().append("     </tr>\n");
            }
        } catch (Exception e) {
            System.out.println("tableHeader() " + e.getLocalizedMessage());
        }

    }// </editor-fold>
     // <editor-fold defaultstate="collapsed" desc="tableClose() "> 
    public void tableClose() {
        try {
     
                Integer index = indexOfClasesHtmlList();
                testEnvironment.getClasesHtmlList().get(index).getViewHtml().append("  </tbody>\n");
                testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(" </table>\n");
              
               
           
        } catch (Exception e) {
            System.out.println("tableClose() " + e.getLocalizedMessage());
        }

    }// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="tableCol(List<Col> colList) "> 

    public void tableCol(List<ColView> colList) {
        try {
            if (!colList.isEmpty()) {
                Integer index = indexOfClasesHtmlList();
                testEnvironment.getClasesHtmlList().get(index).getViewHtml().append("     <tr>\n");
                colList.stream().map((c) -> {
                    StringBuilder temp = new StringBuilder();
                    temp.append("<td>").append(c.getValue()).append("</td>\n");
                    return temp;
                }).forEachOrdered((temp) -> {
                    testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());
                });
                testEnvironment.getClasesHtmlList().get(index).getViewHtml().append("     </tr>\n");
            }
        } catch (Exception e) {
            System.out.println("tableCol() " + e.getLocalizedMessage());
        }

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="indexOfClasesHtmlList()"> 
    private Integer indexOfClasesHtmlList() {
        Integer index = -1;
        try {

            for (ClasesHtml c : testEnvironment.getClasesHtmlList()) {
                index++;
                if (c.getClase().equals(this.nameOfClass)) {

                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("indexOfClasesHtmlList()");
        }
        return index;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="h1(String texto)"> 
    public void h1(String texto) {
        try {

            Integer index = indexOfClasesHtmlList();
            StringBuilder temp = new StringBuilder();
            temp.append("<h1>").append(texto).append("</h1>");
            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());

        } catch (Exception e) {
            System.out.println("h1() " + e.getLocalizedMessage());
        }

    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="h2(String texto)"> 
    public void h2(String texto) {
        try {

            Integer index = indexOfClasesHtmlList();
            StringBuilder temp = new StringBuilder();
            temp.append("<h2>").append(texto).append("</h2>");
            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());

        } catch (Exception e) {
            System.out.println("h2() " + e.getLocalizedMessage());
        }

    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="h3(String texto)"> 
    public void h3(String texto) {
        try {

            Integer index = indexOfClasesHtmlList();
            StringBuilder temp = new StringBuilder();
            temp.append("<h3>").append(texto).append("</h3>");
            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());

        } catch (Exception e) {
            System.out.println("h3() " + e.getLocalizedMessage());
        }

    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="h4(String texto)"> 
    public void h4(String texto) {
        try {

            Integer index = indexOfClasesHtmlList();
            StringBuilder temp = new StringBuilder();
            temp.append("<h4>").append(texto).append("</h4>");
            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());

        } catch (Exception e) {
            System.out.println("h4() " + e.getLocalizedMessage());
        }

    }// </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="h5(String texto)"> 
    public void h5(String texto) {
        try {

            Integer index = indexOfClasesHtmlList();
            StringBuilder temp = new StringBuilder();
            temp.append("<h5>").append(texto).append("</h5>");
            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());

        } catch (Exception e) {
            System.out.println("h5() " + e.getLocalizedMessage());
        }

    }// </editor-fold>
    
    
     // <editor-fold defaultstate="collapsed" desc="h5(String texto)"> 
    public void p(String texto) {
        try {

            Integer index = indexOfClasesHtmlList();
            StringBuilder temp = new StringBuilder();
            temp.append("<p>").append(texto).append("</p>");
            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());

        } catch (Exception e) {
            System.out.println("p() " + e.getLocalizedMessage());
        }

    }// </editor-fold>
     // <editor-fold defaultstate="collapsed" desc="h5(String texto)"> 
    public void button(String texto) {
        try {

            Integer index = indexOfClasesHtmlList();
            StringBuilder temp = new StringBuilder();
            temp.append("<button type=\"button\">").append(texto).append("</button>");
            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());

        } catch (Exception e) {
            System.out.println("button " + e.getLocalizedMessage());
        }

    }// </editor-fold>
     // <editor-fold defaultstate="collapsed" desc="h5(String texto)"> 
    public void br() {
        try {

            Integer index = indexOfClasesHtmlList();
          
            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append("<br>");

        } catch (Exception e) {
            System.out.println("br" + e.getLocalizedMessage());
        }

    }// </editor-fold>
    
    
    
    
     // <editor-fold defaultstate="collapsed" desc="message(String texto) "> 
    public void message(String texto) {
        try {
     
                Integer index = indexOfClasesHtmlList();
                   StringBuilder temp = new StringBuilder();
                    temp.append("<br/>").append(texto).append("\n");
                
                testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());
              
              
               
           
        } catch (Exception e) {
            System.out.println("message() " + e.getLocalizedMessage());
        }

    }// </editor-fold>
    public void error(String texto) {
        try {
     
                Integer index = indexOfClasesHtmlList();
                   StringBuilder temp = new StringBuilder();
                    temp.append("<br/>").append("<font color=\"red\">").append(texto).append("</font>").append("\n");
                
                testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());
              
              
               
           
        } catch (Exception e) {
            System.out.println("error() " + e.getLocalizedMessage());
        }

    }// </editor-fold>

}
