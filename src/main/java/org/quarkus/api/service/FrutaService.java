package org.quarkus.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.quarkus.api.dto.FrutaDTO;
import org.quarkus.api.model.Fruta;
import org.quarkus.api.model.IndentificadorTransacao;

import java.util.List;

@ApplicationScoped
public final class FrutaService {

    @Inject
    IndentificadorTransacao indentificadorTransacao;

    @Inject
    EntityManager entityManager;

    public List<Fruta> list(){
        System.out.println(indentificadorTransacao.getIndentificadorTransacao());
        return Fruta.listAll();
    }

    @Transactional
    public Fruta novaFruta(FrutaDTO  frutaDTO){
        System.out.println(indentificadorTransacao.getIndentificadorTransacao());
        Fruta fruta = new Fruta();
        fruta.setNome(frutaDTO.getNome());
        fruta.setQtd(frutaDTO.getQtd());
        fruta.persist();

        return fruta;

    }

    @Transactional
    public Fruta update(Fruta fruta){
        return entityManager.merge(fruta);
    }

    public Fruta buscarPorId(Long id){
        return entityManager.find(Fruta.class, id);
    }

    @Transactional
    public void deletar(Fruta fruta){
      entityManager.remove(entityManager.contains(fruta) ? fruta : entityManager.merge(fruta));
    }
}
