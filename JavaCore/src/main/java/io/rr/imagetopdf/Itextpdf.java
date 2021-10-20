package io.rr.imagetopdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class Itextpdf {

    public static void main(String[] args) throws IOException, DocumentException {
        generatePDFFromImage("/Users/r.rudenko/Pictures/Sample.png", "/Users/r.rudenko/Pictures/11.pdf");
//        generatePDFFromImage("/Users/r.rudenko/Pictures/Sample.heic", "/Users/r.rudenko/Pictures/12.pdf");
        generatePDFFromImage("/Users/r.rudenko/Pictures/Sample.jpeg", "/Users/r.rudenko/Pictures/13.pdf");
    }

    private static void generatePDFFromImage(String filename, String output) throws IOException, DocumentException {
        Document document = new Document();
        FileOutputStream fos = new FileOutputStream(output);

        PdfWriter writer = PdfWriter.getInstance(document, fos);
        writer.open();
        document.open();
        document.add(Image.getInstance(filename));
        document.close();
        writer.close();
    }

}
