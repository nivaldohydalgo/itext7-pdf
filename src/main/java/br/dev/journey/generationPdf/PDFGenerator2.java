package br.dev.journey.generationPdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import org.apache.pdfbox.pdmodel.font.PDFont;
import java.util.List;
import java.util.ArrayList;

public class PDFGenerator2 {
    static int PAGE_WIDTH = 615;
    static int PAGE_HEIGHT = 815;

    private static final PDFont FONT = PDType1Font.HELVETICA;
    private static final float FONT_SIZE = 12;
    private static final float LEADING = -1.5f * FONT_SIZE;

    public static ByteArrayInputStream GeneratorPDF() throws Exception {

        String text = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.";
        String text2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        ByteArrayOutputStream saida = new ByteArrayOutputStream();

        PDDocument doc = new PDDocument();
        PDPage myPage = new PDPage(PDRectangle.A4);

        // PDRectangle box = new PDRectangle(PAGE_WIDTH, PAGE_HEIGHT);
        // myPage.setMediaBox(box); // MediaBox > BleedBox > TrimBox/CropBox

        doc.addPage(myPage);

        PDPageContentStream cont = new PDPageContentStream(doc, myPage);
        // cont.setLineWidth(64.5f);

        PDRectangle mediaBox = myPage.getMediaBox();
        float marginY = 80;
        float marginX = 60;
        float width = mediaBox.getWidth() - 2 * marginX;
        float startX = mediaBox.getLowerLeftX() + marginX;
        float startY = mediaBox.getUpperRightY() - marginY;

        cont.beginText();

        cont.setFont(PDType1Font.TIMES_ROMAN, 12);
        cont.setLeading(14.5f);

        cont.newLineAtOffset(25, 700);
        String line1 = "World War II (often abbreviated to WWII or WW2), "
                + "also known as the Second World War,";
        cont.showText(line1);

        cont.newLine();

        String line2 = "was a global war that lasted from 1939 to 1945, "
                + "although related conflicts began earlier.";
        cont.showText(line2);
        cont.newLine();

        String line3 = "It involved the vast majority of the world's "
                + "countries—including all of the great powers—";
        cont.showText(line3);
        cont.newLine();

        String line4 = "eventually forming two opposing military "
                + "alliances: the Allies and the Axis.";
        cont.showText(line4);
        cont.newLine();

        cont.showText(text);
        cont.newLine();

        cont.showText(text2);
        cont.newLine();

        addParagraph(cont, width, startX, startY, text, true);
 
        addParagraph(cont, 300, 20, 60, text, false);
  
        cont.endText();
        cont.close();

        doc.save(saida);
        doc.close();

        return new ByteArrayInputStream(saida.toByteArray());
    }

    private static void addParagraph(PDPageContentStream contentStream, float width, float sx,
            float sy, String text, boolean justify) throws IOException {
        List<String> lines = parseLines(text, width);
        contentStream.setFont(FONT, FONT_SIZE);
        contentStream.newLineAtOffset(sx, sy);
        for (String line : lines) {
            float charSpacing = 0;
            if (justify) {
                if (line.length() > 1) {
                    float size = FONT_SIZE * FONT.getStringWidth(line) / 1000;
                    float free = width - size;
                    if (free > 0 && !lines.get(lines.size() - 1).equals(line)) {
                        charSpacing = free / (line.length() - 1);
                    }
                }
            }
            contentStream.setCharacterSpacing(charSpacing);
            contentStream.showText(line);
            contentStream.newLineAtOffset(0, LEADING);
        }
    }

    private static List<String> parseLines(String text, float width) throws IOException {
        List<String> lines = new ArrayList<String>();
        int lastSpace = -1;
        while (text.length() > 0) {
            int spaceIndex = text.indexOf(' ', lastSpace + 1);
            if (spaceIndex < 0)
                spaceIndex = text.length();
            String subString = text.substring(0, spaceIndex);
            float size = FONT_SIZE * FONT.getStringWidth(subString) / 1000;
            if (size > width) {
                if (lastSpace < 0) {
                    lastSpace = spaceIndex;
                }
                subString = text.substring(0, lastSpace);
                lines.add(subString);
                text = text.substring(lastSpace).trim();
                lastSpace = -1;
            } else if (spaceIndex == text.length()) {
                lines.add(text);
                text = "";
            } else {
                lastSpace = spaceIndex;
            }
        }
        return lines;
    }

    private static Paragraph criaParagrafo(
            String text,
            String fontFamily,
            Float sizeFont,
            String alignText,
            Boolean isBold,
            Boolean isItalic,
            Float lineSpacing,
            Float maxWidth,
            Float marginTop,
            Float marginBottom) throws IOException {

        Style style = new Style();

        // ****** FONTE FAMILY ******
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        if (fontFamily == "courier") {
            font = PdfFontFactory.createFont(StandardFonts.COURIER);
        } else if (fontFamily == "times") {
            font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        }
        style.setFont(font);

        // ****** FONTE SIZE ******
        if (sizeFont < 6 || sizeFont > 30) {
            sizeFont = 12f;
        }
        style.setFontSize(sizeFont);

        // ****** ALIGNMENT TEXT ******
        if (alignText == "center") {
            style.setTextAlignment(TextAlignment.CENTER);
        } else if (alignText == "left") {
            style.setTextAlignment(TextAlignment.LEFT);
        } else if (alignText == "right") {
            style.setTextAlignment(TextAlignment.RIGHT);
        } else {
            style.setTextAlignment(TextAlignment.JUSTIFIED);
        }

        // ****** FONTE BOLD ******
        if (isBold) {
            style.setBold();
        }

        // ****** FONT ITALIC ******
        if (isItalic) {
            style.setItalic();
        }

        // ****** WAX WIDTH DO PARAGRAFO ******
        if (maxWidth > 0) {
            style.setMaxWidth(maxWidth);
        }

        Paragraph p = new Paragraph(text).addStyle(style);

        // ****** LINE SPACING ******
        if (lineSpacing != 0) {
            p.setFixedLeading(sizeFont + lineSpacing);
        }

        // ****** MARGIN TOP ******
        if (marginTop != 0) {
            p.setMarginTop(marginTop);
        }

        // ****** MARGIN BOTTOM ******
        if (marginBottom != 0) {
            p.setMarginBottom(marginBottom);
        }

        return p;
    }

    private static void processVarargIntegers(String... args) {

        for (String arg : args) {
            System.out.println("arg: " + arg);
        }

    }

}
