package io.rr.imagetopdf;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Pdfbox {

    public static void main(String[] args) throws IOException {
        createPDFFromImage("/Users/r.rudenko/Pictures/Sample.png", "/Users/r.rudenko/Pictures/21.pdf");
//        createPDFFromImage("/Users/r.rudenko/Pictures/Sample.heic", "/Users/r.rudenko/Pictures/22.pdf"); not supported
        createPDFFromImage("/Users/r.rudenko/Pictures/Sample.jpeg", "/Users/r.rudenko/Pictures/23.pdf");
    }

    private static void createPDFFromImage(String imagePath, String outputFile) throws IOException {
        //we will add the image to the first page.
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);

        // createFromFile is the easiest way with an image file
        // if you already have the image in a BufferedImage,
        // call LosslessFactory.createFromImage() instead
        PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, doc);

        try (PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, true)) {
            // contentStream.drawImage(ximage, 20, 20 );
            // better method inspired by http://stackoverflow.com/a/22318681/535646
            // reduce this value if the image is too large
            float scale = 1f;
            contentStream.drawImage(pdImage, 20, 20);
        }
        doc.save(outputFile);
    }

}
