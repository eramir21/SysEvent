/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systemevent.jsfclass.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author Jose_Gascon
 */
public class FormatoPDF extends PdfPageEventHelper {
     private Image imagen;
    PdfPTable table = new PdfPTable(2);
        
    /**
     * Constructor de la clase, inicializa la imagen que se utilizara en el membrete
     */
    public FormatoPDF(String nombre)
    {
        try
        {
            PdfPCell celda1 = new PdfPCell(new Phrase("Nombre Cliente"));
            PdfPCell celda2 = new PdfPCell(new Phrase(nombre));
            
            imagen = Image.getInstance("C:\\Users\\Jose_Gascon\\Documents\\ProyectoSystemEvent\\sysevent\\src\\main\\webapp\\resources\\imagenes\\logoconstruccion.jpg");
            imagen.setAbsolutePosition(30, 720f);               
            imagen.scaleAbsolute(100, 100);
            celda1.setBorder(Rectangle.BOTTOM);
            celda2.setBorder(Rectangle.BOTTOM);
            celda2.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT);
            
            table.addCell(celda1);
            table.addCell(celda2);            
            
            table.setTotalWidth(350f);            
            
        }catch(Exception r)
        {
            System.err.println("Error al leer la imagen");
        }    
    }
    
    /**
     * Manejador del evento onEndPage, usado para generar el encabezado
     */
    @Override
    public void onEndPage(PdfWriter writer, Document document) {

        try{            
            document.add(imagen);
            table.writeSelectedRows(0, -1, 140f, 760f, writer.getDirectContent());
            
         }catch(Exception doc)
         {
             doc.printStackTrace();
         }         
     }
}
