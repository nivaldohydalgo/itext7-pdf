package br.dev.journey.services;

import javax.enterprise.context.ApplicationScoped;

import br.dev.journey.generationPdf.OpenPDF;

import java.io.ByteArrayInputStream;

@ApplicationScoped
public class GenerationPdfService {
    
    public ByteArrayInputStream loadPDF() throws Exception {
        ByteArrayInputStream pdf = OpenPDF.GeneratorPDF();
        return pdf;
    }

}
