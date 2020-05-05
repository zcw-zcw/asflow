package com.swpu.asflow.utils;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.swpu.asflow.entity.Demand;
import com.swpu.asflow.service.IDemandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Demandpdf {


    public static PdfPTable createTable(PdfWriter writer, List<Demand> demandList) throws DocumentException, IOException{

        Font font = new Font(BaseFont.createFont( "STSongStd-Light" ,"UniGB-UCS2-H",BaseFont.NOT_EMBEDDED));
        PdfPTable table = new PdfPTable(3);
        PdfPCell cell;
        int size = 18;
        int width=20;
        table.setTotalWidth(new float[]{20,40,10});
        cell = new PdfPCell(new Paragraph("需求名",font));
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("需求描述",font));
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("创建时间",font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        for(Demand list:demandList){
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

    public void createPDF(String filename,List<Demand> demandList) throws IOException {
        Document document = new Document(PageSize.A4);

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.addTitle("Demand of PDF");
            document.open();
            PdfPTable table = createTable(writer,demandList);
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
