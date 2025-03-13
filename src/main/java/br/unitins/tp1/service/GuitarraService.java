package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.GuitarrasDTO;
import br.unitins.tp1.model.Guitarra;

public interface GuitarraService {

    Guitarra create(GuitarrasDTO guitarra);
    void update(long id, Guitarra guitarra);
    void delete(long id);
    Guitarra findById(long id);
    Guitarra findByTipo(String tipo);
    List<Guitarra> findAll();
    
}
