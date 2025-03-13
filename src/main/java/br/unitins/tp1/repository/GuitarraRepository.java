package br.unitins.tp1.repository;

import br.unitins.tp1.model.Guitarra;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GuitarraRepository implements PanacheRepository<Guitarra> {

    public Guitarra findByTipo(String tipo) {
        return find("SELECT e FROM Guitarra e WHERE e.tipo = ?1 ", tipo).firstResult();
    }

}