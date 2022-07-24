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


public class PDFGenerator {

    public static ByteArrayInputStream GeneratorPDF() throws Exception {

        // Margens do Documento
        Float documentMarginTop = 90f;
        Float documentMarginLeft = 60f;
        Float documentMarginRight = 45f;
        Float documentMarginBottom = 20f;

        // Margens do Texto
        Float heightHeader = 70f;
        Float heightFooter = 50f;
        Float textMarginTop = documentMarginTop + heightHeader;
        Float textMarginLeft = documentMarginLeft;
        Float textMarginRight = documentMarginRight;
        Float textMarginBottom = documentMarginBottom + heightFooter;

        // Dimensões do QRCode
        Float qrcodeWidth = 90f;
        Float qrcodeHeight = 90f;
        Float qtcodeTopMargin = 130f;

        // Atributos padrões
        Float maxWidthHeader = 370f;

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(saida);

        PdfDocument doc = new PdfDocument(writer);

        Document document = new Document(doc, PageSize.A4, false);
        document.setTextAlignment(TextAlignment.JUSTIFIED_ALL);
        document.setMargins(textMarginTop, textMarginRight, textMarginBottom, textMarginLeft);

        try {

            processVarargIntegers("Nivaldo", "fontSize: 12");

            String text = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.";
            String text2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

            document.add(criaParagrafo(text, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text2, "courier", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text, "times", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text2, "helvetica", 12f, "justified", true, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text, "helvetica", 12f, "justified", false, true, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text2, "helvetica", 12f, "justified", false, false, 8f, 0f, 0f, 0f));
            document.add(criaParagrafo(text, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 20f));
            document.add(criaParagrafo(text2, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text2, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text2, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text2, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text2, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text2, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text2, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text2, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text2, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text2, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));
            document.add(criaParagrafo(text, "helvetica", 12f, "justified", false, false, 3f, 0f, 0f, 0f));

            int width = 140;
            int height = 140;
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            
            BitMatrix bitMatrix = new BitMatrix(140, 140);
            System.out.println("bitMatrix width....: " + bitMatrix.getWidth());
            System.out.println("bitMatrix height...: " + bitMatrix.getHeight());

            //bitMatrix = qrCodeWriter.encode("25584523365542144587745552121455522200002556632221444000221441755214221254477", BarcodeFormat.QR_CODE, width, height);
            // bitMatrix = qrCodeWriter.encode("02547552114171221212008765434156554432310000098765644343455564443321345667777", BarcodeFormat.QR_CODE, width, height);
            bitMatrix = qrCodeWriter.encode("QRCode do Nivaldo Aparecido Alexandre Hydalgo", BarcodeFormat.QR_CODE, width, height);
            //bitMatrix = qrCodeWriter.encode("My QRCode", BarcodeFormat.QR_CODE, width, height);
            //bitMatrix.setRegion(20, 20, width, height);
            System.out.println("bitMatrix width....: " + bitMatrix.getWidth());
            System.out.println("bitMatrix height...: " + bitMatrix.getHeight());
            System.out.println("bitMatrix RowSize..: " + bitMatrix.getRowSize());
            
            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
            byte[] pngData = pngOutputStream.toByteArray(); 
            ImageData qrCode = ImageDataFactory.create(pngData);




            // ******* INCLUIR HEADER E FOOTER NO PDF *******
            int qtPages = doc.getNumberOfPages();
            for (int i = 1; i <= qtPages; i++) {

                // ****** CONFIGURACAO DO CANVAS ******
                PdfPage page = doc.getPage(i);
                PdfCanvas pdfCanvas = new PdfCanvas(page.getLastContentStream(), page.getResources(), doc);
                Rectangle pageSize = doc.getPage(i).getPageSize();
                Canvas canvas = new Canvas(pdfCanvas, pageSize);

                // ****** INCLUI O TEXTO DO HEADER ******
                String cabecalho = "CONTRATO DE FINANCIAMENTO DE IMÓVEL URBANO COM RECURSOS DO SFH, FIRMADO ENTRE O BANCO DO BRASIL E NIVALDO APARECIDO ALEXANDRE HYDALGO";
                canvas.showTextAligned(
                        criaParagrafo(cabecalho, "helvetica", 12f, "justified", true, false, 4f, maxWidthHeader, 0f,
                                0f),
                        pageSize.getLeft() + documentMarginLeft,
                        pageSize.getTop() - documentMarginTop, TextAlignment.LEFT);

                // ****** INCLUI O QRCODE ******
                //File directory = new File("./");
                //String path = directory.getAbsolutePath() + "/src/assets/";

                //qrCode.setWidth(qrcodeWidth);
                //qrCode.setHeight(qrcodeHeight);
                qrCode.setWidth(width);
                qrCode.setHeight(height);
                pdfCanvas.addImageAt(qrCode, pageSize.getWidth() - 158,
                        pageSize.getTop() - 158, false);
               

//                ImageData imageData = ImageDataFactory.create(path + "qrcode.jpg");
//                imageData.setWidth(qrcodeWidth);
//                imageData.setHeight(qrcodeHeight);
//                pdfCanvas.addImageAt(imageData, pageSize.getWidth() - (qrcodeWidth + documentMarginRight),
//                        pageSize.getTop() - qtcodeTopMargin, false);

                // ****** LINHA ABAIXO DO CABECALHO ******
                pdfCanvas.setLineWidth(1)
                        .moveTo(pageSize.getLeft() + textMarginLeft, pageSize.getTop() - textMarginTop + 8)
                        .lineTo(pageSize.getRight() - textMarginRight, pageSize.getTop() - textMarginTop + 8).stroke();

                // ****** LINHA ACIMA DO RODAPE ******
                pdfCanvas.setLineWidth(1)
                        .moveTo(pageSize.getLeft() + textMarginLeft, pageSize.getBottom() + textMarginBottom)
                        .lineTo(pageSize.getRight() - textMarginRight, pageSize.getBottom() + textMarginBottom)
                        .stroke();

                // ****** INCLUI O PAGINACAO ******
                String numeroPaginas = String.format("Pagina %s de %s", i, doc.getNumberOfPages());
                canvas.showTextAligned(
                        criaParagrafo(numeroPaginas, "helvetica", 12f, "left", false, false, 0f, 0f, 0f, 0f),
                        pageSize.getLeft() + documentMarginLeft,
                        pageSize.getBottom() + documentMarginBottom + 30, TextAlignment.LEFT);

                Paragraph viaNaoNegociavel = new Paragraph("VIA NÃO NEGOCIAVEL");
                viaNaoNegociavel.setFontSize(40);
                viaNaoNegociavel.setOpacity(0.2f);
                canvas.showTextAligned(viaNaoNegociavel, pageSize.getWidth() / 2, pageSize.getHeight() / 2, i,
                        TextAlignment.CENTER, VerticalAlignment.MIDDLE, 45);

                canvas.close();
            }

            document.close();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return new ByteArrayInputStream(saida.toByteArray());
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
