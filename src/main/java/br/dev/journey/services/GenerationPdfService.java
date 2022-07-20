package br.dev.journey.services;

import javax.enterprise.context.ApplicationScoped;

import br.dev.journey.generationPdf.PDFGenerator2;

import java.io.ByteArrayInputStream;

@ApplicationScoped
public class GenerationPdfService {
    
    public ByteArrayInputStream loadPDF() throws Exception {
        ByteArrayInputStream pdf = PDFGenerator2.GeneratorPDF();
        return pdf;
    }

}
