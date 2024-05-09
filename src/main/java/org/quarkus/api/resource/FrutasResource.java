package org.quarkus.api.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.quarkus.api.dto.FrutaDTO;
import org.quarkus.api.model.Fruta;
import org.quarkus.api.service.FrutaService;

import java.util.List;


@Path("/frutas")
public class FrutasResource {

    @Inject
    FrutaService  frutaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruta> list(){
        return Fruta.listAll();
    }

    @POST
    public void novaFruta(FrutaDTO  frutaDTO){
        frutaService.novaFruta(frutaDTO);

    }
}
