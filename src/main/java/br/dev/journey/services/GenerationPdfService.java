package br.dev.journey.services;

import javax.enterprise.context.ApplicationScoped;

import br.dev.journey.generationPdf.PDFGenerator;

import java.io.ByteArrayInputStream;

@ApplicationScoped
public class GenerationPdfService {
    
    public ByteArrayInputStream loadPDF() throws Exception {
        ByteArrayInputStream pdf = PDFGenerator.GeneratorPDF();
        return pdf;
    }

}
