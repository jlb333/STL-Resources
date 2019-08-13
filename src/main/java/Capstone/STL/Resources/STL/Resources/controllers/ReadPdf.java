/* package Capstone.STL.Resources.STL.Resources.controllers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;

public class ReadPdf {

    //can't have more than one 'main' method, right?
    //public static void main(String[] args) throws IOException {

    public static String readPdf() throws IOException {

        try (PDDocument document = PDDocument.load(new File("/https://www.startherestl.org/uploads/6/8/1/0/6810817/start_here-june-2019_copy.pdf"))) {

            document.getClass();

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                //System.out.println("Text:" + st);

                // split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    System.out.println(line);
                }

            }

        }

    }
}

*/