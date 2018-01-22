/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbunit.view;

import com.avbravo.jmoordbunit.TestEnvironment;
import com.avbravo.jmoordbunit.pojos.ClasesHtml;
import com.avbravo.jmoordbunit.datatable.ColView;
import com.avbravo.jmoordbunit.datatable.RowView;
import com.avbravo.jmoordbunit.htmlcomponents.InputText;
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
            temp.append("<h1 class=\"yellowgreen\">").append(texto).append("</h1>");
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
            temp.append("<h2 class=\"yellowgreen\">").append(texto).append("</h2>");
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
            temp.append("<h3 class=\"yellowgreen\">").append(texto).append("</h3>");
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
            temp.append("<h4 class=\"yellowgreen\">").append(texto).append("</h4>");
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
            temp.append("<h5 class=\"yellowgreen\">").append(texto).append("</h5>");
            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());

        } catch (Exception e) {
            System.out.println("h5() " + e.getLocalizedMessage());
        }

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="p(String texto)"> 
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
    // <editor-fold defaultstate="collapsed" desc=button(String texto)"> 

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
    // <editor-fold defaultstate="collapsed" desc="br("> 

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
    // <editor-fold defaultstate="collapsed" desc="error(String texto) "> 

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

    // <editor-fold defaultstate="collapsed" desc="form() "> 
    public void form() {
        try {
            Integer index = indexOfClasesHtmlList();
            StringBuilder temp = new StringBuilder();
            temp.append("<form>").append("\n");

            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());
        } catch (Exception e) {
            System.out.println("form() " + e.getLocalizedMessage());
        }
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="formClose() "> 

    public void formClose() {
        try {
            Integer index = indexOfClasesHtmlList();
            StringBuilder temp = new StringBuilder();
            temp.append("<br/>").append("</form>").append("\n");

            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());
        } catch (Exception e) {
            System.out.println("formClose() " + e.getLocalizedMessage());
        }
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="panel() "> 

    public void panel() {
        try {
            Integer index = indexOfClasesHtmlList();
            StringBuilder temp = new StringBuilder();
            temp.append("<table>").append("\n");

            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());
        } catch (Exception e) {
            System.out.println("panel() " + e.getLocalizedMessage());
        }
    }// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="panelClose() "> 

    public void panelClose() {
        try {
            Integer index = indexOfClasesHtmlList();
            StringBuilder temp = new StringBuilder();
            temp.append("</table>").append("\n");

            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());
        } catch (Exception e) {
            System.out.println("panelClose() " + e.getLocalizedMessage());
        }
    }// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="panelRow() "> 

    public void panelRow() {
        try {
            Integer index = indexOfClasesHtmlList();
            StringBuilder temp = new StringBuilder();
            temp.append("<tr>").append("\n");

            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());
        } catch (Exception e) {
            System.out.println("panelRow() " + e.getLocalizedMessage());
        }
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="panelRowClose() "> 

    public void panelRowClose() {
        try {
            Integer index = indexOfClasesHtmlList();
            StringBuilder temp = new StringBuilder();
            temp.append("<tr>").append("\n");

            testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());
        } catch (Exception e) {
            System.out.println("panelRowClose() " + e.getLocalizedMessage());
        }
    }// </editor-fold>
     // <editor-fold defaultstate="collapsed" desc="panelAdd(List<InputText> inputTextList)) "> 
    public void panelAdd(List<InputText> inputTextList){
        try {
            Integer index = indexOfClasesHtmlList();
            StringBuilder temp = new StringBuilder();
           
            if(!inputTextList.isEmpty()){
                inputTextList.stream().map((i) -> {
                    temp.append("<td>").append(i.getLabel()).append("</td>").append("\n");
                    return i;
                }).forEachOrdered((i) -> {
                    temp.append("<td>").append("<input type=\"text\" value=\"").append(i.getValue()).append("\"></td>").append("\n");
                });
                 testEnvironment.getClasesHtmlList().get(index).getViewHtml().append(temp.toString());
            }

           
        } catch (Exception e) {
            System.out.println("panelAdd(List<InputText>) " + e.getLocalizedMessage());
        } 
    }// </editor-fold>
    

}
