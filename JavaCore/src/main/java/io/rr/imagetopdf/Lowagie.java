package io.rr.imagetopdf;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;

public class Lowagie {

    public static void main(String[] args) throws IOException, DocumentException, InterruptedException {
//        compressImage("/Users/r.rudenko/Pictures/new/Sample.jpg");

//        generatePDFFromImage("/Users/r.rudenko/Pictures/Sample.png", "/Users/r.rudenko/Pictures/01.pdf");
        System.out.println("before");
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                generatePDFFromImage("/Users/r.rudenko/Pictures/new/Sample.png", "/Users/r.rudenko/Pictures/new/01.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
//        generatePDFFromImage("/Users/r.rudenko/Pictures/new/Sample.png", "/Users/r.rudenko/Pictures/new/01.pdf");
        Thread.sleep(20000);
        System.out.println("after");
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    private static byte[] compressImage(String filename) throws IOException {
//        File destinationDirectory = new File ("/Users/r.rudenko/Pictures/new/compressed");
//
//        if (! destinationDirectory.exists()) {
//            destinationDirectory.mkdir();
//        }

        File input = new File(filename);
        BufferedImage image = ImageIO.read(input);
        double widthRatio = image.getWidth() / PageSize.A4.getWidth();
        double heightRatio = image.getHeight() / PageSize.A4.getHeight();
        double ratio = Math.max(widthRatio, heightRatio);
        System.out.println(PageSize.A4.getWidth() + "   " + PageSize.A4.getHeight());

        BufferedImage compressedImage = resizeImage(image, (int) (image.getWidth() / ratio), (int) (image.getHeight() / ratio));

//        save file
        String pathname = "/Users/r.rudenko/Pictures/new/compressedSample.jpg";
        File compressedImageFile = new File(pathname);
        OutputStream os = new FileOutputStream(compressedImageFile);
        ImageIO.write(compressedImage, "jpg", compressedImageFile);
        os.close();

//        get bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(compressedImage, "jpg", baos);
        byte[] bytes = baos.toByteArray();

//        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
//        ImageWriter writer = writers.next();
//        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
//        writer.setOutput(ios);
//        ImageWriteParam param = writer.getDefaultWriteParam();
//        if(param.canWriteCompressed()) {
//            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
//            param.setCompressionQuality(0.05f);
//        }
//        writer.write(null, new IIOImage(image, null, null), param);

//        ios.close();
//        writer.dispose();

        return bytes;
    }

    private static void generatePDFFromImage(String filename, String output) throws IOException {
        byte[] input = compressImage(filename);

        File destinationDirectory = new File("/Users/r.rudenko/Pictures/new");

        if (!destinationDirectory.exists()) {
            destinationDirectory.mkdir();
        }

        Document document = new Document();
        FileOutputStream fos = null;
        PdfWriter writer = null;
        try {
            Image image = Image.getInstance(input);
            int border = 70;
            image.scaleToFit(PageSize.A4.getWidth() - border, PageSize.A4.getHeight() - border);
            fos = new FileOutputStream(output);
            writer = PdfWriter.getInstance(document, fos);
            writer.open();
            document.open();
            document.add(image);

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
            if (writer != null) {
                writer.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

//    private static void generatePDFFromImage(String filename, String output) throws IOException {
//        filename = compressImage(filename);
//
//        File destinationDirectory = new File ("/Users/r.rudenko/Pictures/new");
//
//        if (! destinationDirectory.exists()) {
//            destinationDirectory.mkdir();
//        }
//
//        Document document = new Document();
//        FileOutputStream fos = null;
//        PdfWriter writer = null;
//        try {
//            fos = new FileOutputStream(output);
//            writer = PdfWriter.getInstance(document, fos);
//            writer.open();
//            document.open();
//            document.add(Image.getInstance(filename));
//
//        } catch (IOException | DocumentException e) {
//            e.printStackTrace();
//        } finally {
//            document.close();
//            if (writer != null) {
//                writer.close();
//            }
//            if (fos != null) {
//                fos.close();
//            }
//        }
//    }
}
