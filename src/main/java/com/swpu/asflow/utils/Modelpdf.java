package com.swpu.asflow.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.swpu.asflow.entity.Demand;
import com.swpu.asflow.entity.Model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Modelpdf {


    public static PdfPTable createTable(PdfWriter writer, List<Model> modelList) throws DocumentException, IOException{

        Font font = new Font(BaseFont.createFont( "STSongStd-Light" ,"UniGB-UCS2-H",BaseFont.NOT_EMBEDDED));
        PdfPTable table = new PdfPTable(3);
        PdfPCell cell;
        int size = 18;
        int width=20;
        table.setTotalWidth(new float[]{20,40,10});
        cell = new PdfPCell(new Paragraph("模块名",font));
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("模块描述",font));
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("创建时间",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        for(Model list:modelList){
                    cell = new PdfPCell(new Paragraph(list.getTitle(),font));
        cell.setFixedHeight(size);
        table.addCell(cell);
            cell = new PdfPCell(new Paragraph(list.getContent(),font));
            cell.setFixedHeight(size*list.getContent().length()/15);
            cell.setNoWrap(false);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph(list.getTime().toString().split("T")[0],font));
            cell.setFixedHeight(size);
            table.addCell(cell);
        }

        return table;
    }

    public void createPDF(String filename,List<Model> modelList) throws IOException {
        Document document = new Document(PageSize.A4);

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.addTitle("Demand of PDF");
            document.open();
            PdfPTable table = createTable(writer,modelList);
            document.add(table);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

}
