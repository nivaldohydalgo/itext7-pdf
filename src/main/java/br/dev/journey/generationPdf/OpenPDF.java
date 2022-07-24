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

public class OpenPDF {

    public static ByteArrayInputStream GeneratorPDF() {

        // Tamanho da Pagina
        Rectangle pageSize;

        // Margens Gerais
        Float marginLeft = 50f;
        Float marginRight = 40f;
        Float marginTop = 40f;
        Float marginBottom = 30f;

        // Altura e largura do texto do Header
        Float widthHeader = 420f;
        Float heightHeader = 100f;

        // Altura do Footer
        Float heightFooter = 20f;

        // Margens Top e Bottom da area do texto do documento
        Float textMarginTop = marginTop + heightHeader + 10f;
        Float textMarginBottom = marginBottom + heightFooter + 10f;

        // Tamanho do QRCode
        int sizeQRCode = 100;
        int marginQRCode = 30;

        String text = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.";
        String text2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        // OutputStream de saida contendo o PDF gerado
        ByteArrayOutputStream saida = new ByteArrayOutputStream();

        try {

            /* =========================================================== */
            /* == GERACAO DO PDF COM O TEXTO DO DOCUMENTO == */
            /* =========================================================== */

            // Prepara o documento para geração
            Document documento = new Document(PageSize.A4, marginLeft, marginRight, textMarginTop, textMarginBottom);
            PdfWriter.getInstance(documento, saida);
            documento.open();
            pageSize = documento.getPageSize();

            Font fonteParagrafo = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
            Paragraph p1 = new Paragraph(text, fonteParagrafo);
            Paragraph p2 = new Paragraph(text2, fonteParagrafo);
            p1.setAlignment(Element.ALIGN_JUSTIFIED);
            p1.setLeading(15);

            documento.add(p1);
            documento.add(p2);
            documento.add(p1);
            documento.add(p2);
            documento.add(p1);
            documento.add(p2);
            documento.add(p1);
            documento.add(p2);
            documento.add(p1);
            documento.add(p2);
            documento.add(p1);
            documento.add(p2);
            documento.add(p1);
            documento.add(p2);
            documento.add(p1);
            documento.add(p2);
            documento.add(p1);
            documento.add(p2);
            documento.add(p1);
            documento.add(p2);
            documento.add(p1);
            documento.add(p2);

            documento.close();

            /* ================================================================== */
            /* == INCLUSAO DE HEADER, FOOTER, QRCODE E WATERMARK == */
            /* ================================================================== */

            // Carrega o PDF gerado no passo anterior
            ByteArrayInputStream pdf = new ByteArrayInputStream(saida.toByteArray());
            PdfReader reader = new PdfReader(pdf);
            int totalPages = reader.getNumberOfPages();

            PdfStamper stamp = new PdfStamper(reader, saida);
            // BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI,
            // BaseFont.EMBEDDED);

            for (int numeroPagina = 1; numeroPagina <= totalPages; numeroPagina++) {

                // Recupera a pagina atual do loop
                PdfContentByte paginaAtual = stamp.getUnderContent(numeroPagina);

                // Inclui o texto do Header
                String contrato = "CONTRATO DE FINANCIAMENTO IMOBILIARIO COM RECURSOS DO SISTEMA FINANCEIRO HABITACIONAL-SFH FIRMADO ENTRE O BANCO DO BRASIL S/A E JOAO SILVA, EM 01/02/2022 NA CIDADE DE AGUAS CLARAS NO DISTRITO FEDERAL, COM REGISTRO NO SEGUNDO CARTORIO DE AVERBACAO DE DOCUMENTOS";
                Phrase frase = new Phrase(contrato, FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD));
                ColumnText ct = new ColumnText(paginaAtual);
                Paragraph para = new Paragraph(frase);
                para.setAlignment(Element.ALIGN_JUSTIFIED);
                para.setLeading(16);
                ct.addElement(para); // <- some filler text from constant
                ct.setSimpleColumn(
                        marginLeft,
                        pageSize.getTop() - marginTop - heightHeader,
                        marginLeft + widthHeader,
                        pageSize.getTop() - marginTop);
                ct.go();

                // Inclui o QRCode
                QRCodeWriter qrCodeWriter = new QRCodeWriter();
                BitMatrix bitMatrix = new BitMatrix(sizeQRCode, sizeQRCode);
                String formatQRCode = "25584523365542144587745552121455522200002556632221444000221441755214221254477"
                        + numeroPagina;
                bitMatrix = qrCodeWriter.encode(formatQRCode, BarcodeFormat.QR_CODE, sizeQRCode, sizeQRCode);
                ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
                MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
                byte[] pngData = pngOutputStream.toByteArray();
                Image qrCode = Image.getInstance(pngData);
                qrCode.setAbsolutePosition(pageSize.getWidth() - marginRight - sizeQRCode + marginQRCode,
                        pageSize.getTop() - marginTop - sizeQRCode + marginQRCode);
                paginaAtual.addImage(qrCode);

                // Line Separator
                LineSeparator lineSeparator = new LineSeparator();
                lineSeparator.setLineColor(Color.GRAY);
                lineSeparator.setLineWidth(0.5f);
                // Line Separator Top
                lineSeparator.drawLine(paginaAtual, marginLeft, pageSize.getWidth() - marginRight,
                        pageSize.getTop() - marginTop - heightHeader - 5);
                // Line Separator Bottom
                System.out.println("getBottom...: " + pageSize.getBottom());
                lineSeparator.drawLine(paginaAtual, marginLeft, pageSize.getWidth() - marginRight,
                        pageSize.getBottom() + marginBottom + heightFooter + 5);

                System.out.println("line: " + (pageSize.getBottom() + marginBottom + heightFooter + 5));

                // Inclui os números da pagina no Footer
                String paginas = "Pagina " + numeroPagina + " de " + totalPages;
                Phrase frase2 = new Phrase(paginas, FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL));
                ColumnText ct2 = new ColumnText(paginaAtual);
                Paragraph para2 = new Paragraph(frase2);
                para2.setAlignment(Element.ALIGN_CENTER);
                ct2.addElement(para2); // <- some filler text from constant
                System.out.println("footer: " + (pageSize.getBottom() + marginBottom + heightFooter));
                ct2.setSimpleColumn(
                        pageSize.getLeft() + marginLeft,
                        pageSize.getBottom() + marginBottom,
                        pageSize.getRight() - marginRight,
                        pageSize.getBottom() + marginBottom + heightFooter + 8);
                ct2.go();

                // Watermark
                BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
                paginaAtual.beginText();
                paginaAtual.setFontAndSize(bf1, 46);
                paginaAtual.setGrayFill(0.4f, 0.3f);
                paginaAtual.showTextAligned(Element.ALIGN_LEFT, "VIA  NÃO  NEGOCIAVEL", 200, 160, 60);
                paginaAtual.endText();


            }

            stamp.close();
            reader.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return new ByteArrayInputStream(saida.toByteArray());
    }

}
