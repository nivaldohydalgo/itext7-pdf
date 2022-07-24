package br.dev.journey.generationPdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.Exception;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfDocument;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Chunk;
import com.lowagie.text.Paragraph;

import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfBorderDictionary;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfFormField;
import com.lowagie.text.pdf.PdfLayer;
import com.lowagie.text.pdf.PdfLayerMembership;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.TextField;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfPage;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfRectangle;

import com.lowagie.text.Element;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.pdf.PdfPage;
import com.lowagie.text.pdf.draw.LineSeparator;
import com.lowagie.text.Image;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class OpenPDFcopy {

    public static ByteArrayInputStream GeneratorPDF() {

        // Margens Gerais
        Float marginLeft = 50f;
        Float marginRight = 40f;
        Float marginTop = 40f;
        Float marginBottom = 30f;

        // Altura e largura do texto do Header
        Float widthHeader = 400f;
        Float heightHeader = 80f;

        // Altura do Footer
        Float heightFooter = 20f;

        // Margens Top e Bottom da area do texto do documento
        Float textMarginTop = marginTop + heightHeader + 10f;
        Float textMarginBottom = marginBottom + heightFooter + 10f;

        // Tamanho do QRCode
        Float sizeQRCode = 120f;

        String text = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.";
        String text2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        ByteArrayOutputStream pdfFinal = new ByteArrayOutputStream();

        try {
            Document document = new Document(PageSize.A4, marginLeft, marginRight, textMarginTop, textMarginBottom);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, saida);

            document.open();

            Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
            Paragraph paragraph1 = new Paragraph(text, fontParagraph);
            Paragraph paragraph2 = new Paragraph(text2, fontParagraph);
            paragraph1.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph1);
            document.add(paragraph2);


            document.close();

            // ############### Inclusão de Header, Footer, Watermark and QRCode
            // ################

            ByteArrayInputStream pdf = new ByteArrayInputStream(saida.toByteArray());
            PdfReader reader = new PdfReader(pdf);
            int n = reader.getNumberOfPages();

            PdfStamper stamp = new PdfStamper(reader, pdfFinal);
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);

            System.out.println("n: " + n);

            for (int i = 1; i <= n; i++) {

                // Recupera a pagina atual do loop
                PdfContentByte under = stamp.getUnderContent(i);

                // Inclui o texto do Header
                String contrato = "CONTRATO DE FINANCIAMENTO IMOBILIARIO COM RECURSOS DO SISTEMA FINANCEIRO HABITACIONAL-SFH FIRMADO ENTRE O BANCO DO BRASIL S/A E JOAO SILVA, EM 01/02/2022";
                Phrase frase = new Phrase(contrato, FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD));
                ColumnText ct = new ColumnText(under);
                Paragraph para = new Paragraph(frase);
                para.setAlignment(Element.ALIGN_JUSTIFIED);
                ct.addElement(para); // <- some filler text from constant
                ct.setSimpleColumn(50, 700, 470, 800);
                ct.go();

                // Inclui o QRCode
                int width = 140;
                int height = 140;
                QRCodeWriter qrCodeWriter = new QRCodeWriter();

                BitMatrix bitMatrix = new BitMatrix(140, 140);
                System.out.println("bitMatrix width....: " + bitMatrix.getWidth());
                System.out.println("bitMatrix height...: " + bitMatrix.getHeight());

                String formatQRCode = "25584523365542144587745552121455522200002556632221444000221441755214221254477"
                        + i;
                bitMatrix = qrCodeWriter.encode(formatQRCode, BarcodeFormat.QR_CODE, width, height);
                System.out.println("bitMatrix width....: " + bitMatrix.getWidth());
                System.out.println("bitMatrix height...: " + bitMatrix.getHeight());
                System.out.println("bitMatrix RowSize..: " + bitMatrix.getRowSize());

                ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
                MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
                byte[] pngData = pngOutputStream.toByteArray();
                Image qrCode = Image.getInstance(pngData);
                qrCode.setAbsolutePosition(450, 700);
                under.addImage(qrCode);

                // Line Separator Top
                LineSeparator lineTop = new LineSeparator();
                lineTop.drawLine(under, 50, 550, 730);

                // Line Separator Bottom
                LineSeparator lineBottom = new LineSeparator();
                lineBottom.drawLine(under, 50, 550, 50);

                // Inclui os números da pagina no Footer
                String paginas = "Pagina " + i + " de " + n;
                Phrase frase2 = new Phrase(paginas, FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD));
                ColumnText ct2 = new ColumnText(under);
                Paragraph para2 = new Paragraph(frase2);
                para2.setAlignment(Element.ALIGN_CENTER);
                ct2.addElement(para2); // <- some filler text from constant
                ct2.setSimpleColumn(50, 20, 570, 40);
                ct2.go();

                // Watermark
                BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);

                under.beginText();
                under.setFontAndSize(bf1, 46);
                under.setGrayFill(0.4f, 0.3f);
                under.showTextAligned(Element.ALIGN_LEFT, "VIA  NÃO  NEGOCIAVEL", 200, 160, 60);
                under.endText();

                // Inclui o texto do Header
                // String wm = "VIA NÃO NEGOCIAVEL";
                // Phrase fwm = new Phrase(wm, FontFactory.getFont(FontFactory.HELVETICA, 32,
                // Font.BOLD));
                // ColumnText ctwm = new ColumnText(under);
                // Paragraph parawm = new Paragraph(fwm);
                // parawm.setAlignment(Element.ALIGN_JUSTIFIED);

                // ctwm.addElement(parawm); // <- some filler text from constant
                // ctwm.setSimpleColumn(50, 300, 470, 400);
                // ctwm.go();

            }

            stamp.close();
            reader.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return new ByteArrayInputStream(pdfFinal.toByteArray());
    }

}
