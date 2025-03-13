package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.GuitarrasDTO;
import br.unitins.tp1.model.Guitarra;
import br.unitins.tp1.model.Modelos;
import br.unitins.tp1.repository.GuitarraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class GuitarraServiceImpl implements GuitarraService {

    @Inject
    GuitarraRepository guitarraRepository;

    @Override
    @Transactional
    public Guitarra create(GuitarrasDTO guitarras) {
        Guitarra novaGuitarra = new Guitarra();
        novaGuitarra.setNome(guitarras.getNome());
        novaGuitarra.setTipo(guitarras.getTipo());
       
        // selecionar uma regiao
        Modelos modelos = null;
        for (Modelos x : Modelos.values()) {
            if (x.getId() == guitarras.getIdModelo())
                modelos = x;
        }

        novaGuitarra.setModelos(modelos);

        // realizando inclusao
        guitarraRepository.persist(novaGuitarra);

        return novaGuitarra;
    }

    @Override
    @Transactional
    public void update(long id, Guitarra guitarra) {
        Guitarra edicaoGuitarra = guitarraRepository.findById(id);

        edicaoGuitarra.setNome(guitarra.getNome());
        edicaoGuitarra.setTipo(guitarra.getTipo());
    }

    @Override
    @Transactional
    public void delete(long id) {
        guitarraRepository.deleteById(id);
    }

    @Override
    public Guitarra findById(long id) {
        return guitarraRepository.findById(id);
    }

    @Override
    public Guitarra findByTipo(String tipo) {
        return guitarraRepository.findByTipo(tipo);
    }

    @Override
    public List<Guitarra> findAll() {
        return guitarraRepository.findAll().list();
    }
    
}
