package br.dev.journey;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.dev.journey.services.GenerationPdfService;


@Path("/pdf")
public class GenerationPdfResource {

    @Inject
    GenerationPdfService generationPdfService;

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response generationPdf() throws Exception, IOException {

        return Response
            .ok(generationPdfService.loadPDF(),MediaType.APPLICATION_OCTET_STREAM)
            .header("content-disposition", "attachment; filename = documento.pdf")
            .build();        
        
    }
}
