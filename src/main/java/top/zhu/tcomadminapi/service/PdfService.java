package top.zhu.tcomadminapi.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author mqxu
 * @date 2024/12/11
 * @description PdfService
 **/
@Service
public class PdfService {

    public String convertPdfToImages(String pdfFilePath) throws IOException {
        PDDocument document = PDDocument.load(new File(pdfFilePath));
        PDFRenderer pdfRenderer = new PDFRenderer(document);

        // Generate a unique folder to store images
        String outputDir = "src/main/resources/static/images/" + UUID.randomUUID().toString();
        new File(outputDir).mkdirs();

        // Loop through each page of the PDF and convert it to an image
        int numberOfPages = document.getNumberOfPages();
        for (int i = 0; i < numberOfPages; i++) {
            BufferedImage image = pdfRenderer.renderImage(i);
            ImageIO.write(image, "PNG", new File(outputDir + "/page_" + (i + 1) + ".png"));
        }
        // Close the PDF document
        document.close();
        return outputDir;
    }
}