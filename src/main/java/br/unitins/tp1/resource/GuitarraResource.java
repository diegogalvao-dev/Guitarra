package br.unitins.tp1.resource;

import java.util.List;

import br.unitins.tp1.dto.GuitarrasDTO;
import br.unitins.tp1.model.Guitarra;
import br.unitins.tp1.service.GuitarraService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("guitarra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GuitarraResource {

    @Inject
    GuitarraService service;

    @GET
    public List<Guitarra> buscarTodos() {
        return service.findAll();
    }

    @GET
    @Path("/tipo/{tipo}")
    public Guitarra buscarPortipo(String tipo) {
        return service.findByTipo(tipo);
    }

    @POST
    public Guitarra incluir(GuitarrasDTO dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(Long id, Guitarra guitarra) {
        service.update(id, guitarra);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void apagar(Long id) {
        service.delete(id);
    }

}
