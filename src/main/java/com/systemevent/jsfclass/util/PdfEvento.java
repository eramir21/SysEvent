/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systemevent.jsfclass.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.systemevent.entity.Evento;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jose_Gascon
 */
public class PdfEvento {
    
    public void imprimirPdf(Evento events) {
           Evento event = events;
         
           //buscarPDF(n);
        try {
            //Generamos el archivo PDF
            String directorioArchivos;
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            directorioArchivos = ctx.getRealPath("\'") + "reports";
            String name = directorioArchivos + "\'document-report.pdf";
            //String name="C:\\Users\\Jose_Gascon\\Documents\\NetBeansProjects\\SystemEvent\\target\\SystemEvent-1.0-SNAPSHOT\\reports\\document-report.pdf";
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(name));
            FormatoPDF encabezado = new FormatoPDF("");
            Paragraph parrafo,datos,datos1;
            int i;
            
            // indicamos que objecto manejara los eventos al escribir el Pdf
            writer.setPageEvent(encabezado);
        
            document.open();
            document.addAuthor("Erick Ramirez");
            document.addTitle("Reporte");
            
            
             //Creamos una cantidad significativa de paginas para probar el encabezado
        
            //for (i = 0; i < 4; i++) {
                parrafo = new Paragraph("Presupuesto de Evento");            
                parrafo.setAlignment(Element.ALIGN_CENTER);

                document.add(parrafo);
              //  document.newPage();
            //}
               
              datos = new Paragraph("Ubicacion: " + event.getUbicacion());
              datos1 = new Paragraph("Pais: " +event.getCodigoPais().getNombre());
              datos.setAlignment(Element.ALIGN_RIGHT);
              datos1.setAlignment(Element.ALIGN_RIGHT);
              document.add(datos1);
              document.add(datos);
                          document.add(new Paragraph(""));
            document.add(new Paragraph(""));
                        document.add(new Paragraph(""));
            document.add(new Paragraph(""));
//              PdfPTable table = new PdfPTable(2);
//              
//              table.addCell("Cliente: ");
//              table.addCell(event.getIdCliente().getNombre());
//              
//              table.addCell("Descripcion del Evento: ");
//              table.addCell(event.getDescripcion());
//              
//              document.add(table);
              
              document.add(Tabla_compleja());
              
              




            document.close();
            //----------------------------
            //Abrimos el archivo PDF
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition",
                    "inline=filename=" + name);
            try {
                response.getOutputStream().write(Util.getBytesFromFile(new File(name)));  
                response.getOutputStream().flush();
                response.getOutputStream().close();
                context.responseComplete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public PdfPTable Tabla_compleja(){ 
         //creamos una tabla con 3 columnas
         PdfPTable mitablacompleja=new PdfPTable(3);
         //añadimos texto con formato a la primera celda
         PdfPCell celda =new PdfPCell (new Paragraph("Historial de Observaciones",
                 FontFactory.getFont("arial",   // fuente
                 22,                            // tamaño
                 Font.BOLD,                   // estilo
                 BaseColor.RED)));             // color
         //unimos esta celda con otras 2
         celda.setColspan(3);
         //alineamos el contenido al centro
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         // añadimos un espaciado
         celda.setPadding (12.0f);
         //colocamos un color de fondo
         celda.setBackgroundColor(BaseColor.GRAY);
         //se añade a la tabla
         mitablacompleja.addCell(celda);
         
         //fila 2
         celda = new PdfPCell(new Paragraph ("AUDITORIA DE SISTEMAS"));
         celda.setColspan(2);
         celda.setBackgroundColor(BaseColor.GREEN);
         mitablacompleja.addCell(celda);        
         celda = new PdfPCell(new Paragraph ("Aprobado"));        
         celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
         mitablacompleja.addCell(celda);
         //fila 3        
         celda = new PdfPCell(new Paragraph ("COMPILADORES"));
         celda.setColspan(2);
         celda.setBackgroundColor(BaseColor.YELLOW);
         mitablacompleja.addCell(celda);        
         celda = new PdfPCell(new Paragraph ("Reprobado"));        
         celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
         mitablacompleja.addCell(celda);
         //fila 4        
         celda = new PdfPCell(new Paragraph ("Prog. Bajo Nivel"));
         celda.setColspan(2);
         celda.setBackgroundColor(BaseColor.CYAN);
         mitablacompleja.addCell(celda);        
         celda = new PdfPCell(new Paragraph ("Eximido"));        
         celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
         mitablacompleja.addCell(celda);
         //fila 5
         mitablacompleja.addCell("Conclusion");
         celda = new PdfPCell(new Paragraph ("¡¡¡GET A LIFE!!!"));
         celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
         celda.setColspan(2);
         celda.setBackgroundColor(BaseColor.ORANGE);
         mitablacompleja.addCell(celda);
         // se retorna la tabla
         
         return mitablacompleja;    
     }
    
}
