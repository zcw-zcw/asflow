package com.swpu.asflow.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.swpu.asflow.entity.Interface;
import com.swpu.asflow.entity.Model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Interfacepdf {


    public static PdfPTable createTable(PdfWriter writer, List<Interface> interfaceList) throws DocumentException, IOException{

        Font font = new Font(BaseFont.createFont( "STSongStd-Light" ,"UniGB-UCS2-H",BaseFont.NOT_EMBEDDED));
        PdfPTable table = new PdfPTable(4);
        PdfPCell cell;
        int size = 18;
        int width=20;
        table.setTotalWidth(new float[]{20,40,40,10});
        cell = new PdfPCell(new Paragraph("接口名",font));
        cell.setFixedHeight(size*2);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("接口参数",font));
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("返回参数",font));
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("创建时间",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        for(Interface list:interfaceList){
                    cell = new PdfPCell(new Paragraph(list.getTitle(),font));
        cell.setFixedHeight(size);
        table.addCell(cell);
            cell = new PdfPCell(new Paragraph(list.getParameter(),font));
            cell.setFixedHeight((list.getParameter().length()/20+1)*size);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph(list.getReturnss(),font));
            cell.setFixedHeight(size);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph(list.getTime().toString().split("T")[0],font));
            cell.setFixedHeight(size);
            table.addCell(cell);
        }

        return table;
    }

    public void createPDF(String filename, List<Interface> interfaceList)  throws IOException {
        Document document = new Document(PageSize.A4);

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.addTitle("Demand of PDF");
            document.open();
            PdfPTable table = createTable(writer,interfaceList);
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
