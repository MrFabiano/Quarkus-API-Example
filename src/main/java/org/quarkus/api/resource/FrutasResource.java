package org.quarkus.api.resource;

import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
    public Response novaFruta(FrutaDTO  frutaDTO){
        Fruta fruta = frutaService.novaFruta(frutaDTO);
        return Response.status(Response.Status.CREATED).entity(fruta).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updatePorId(@PathParam("id")Long id, FrutaDTO frutaDTO){
        Fruta frutaExiste = frutaService.buscarPorId(id);
        if (frutaExiste == null){
            throw new EntityNotFoundException("Fruta com ID " + id + "Não encontrada");
        }

        frutaExiste.setNome(frutaDTO.getNome());
        frutaExiste.setQtd(frutaDTO.getQtd());

        Fruta frutaAtualizada = frutaService.update(frutaExiste);
        return Response.ok(frutaAtualizada).build();
    }

    @GET()
    @Path("/{id}")
    public Fruta getFrutaId(@PathParam("id") Long id){
        return frutaService.buscarPorId(id);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id){
        Fruta fruta = frutaService.buscarPorId(id);
        if(fruta == null){
            throw new EntityNotFoundException("Fruta com ID" + id + "Não encontrada");
        }

        frutaService.deletar(fruta);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
