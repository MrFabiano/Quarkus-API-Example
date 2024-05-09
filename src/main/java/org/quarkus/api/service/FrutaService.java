package org.quarkus.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.quarkus.api.dto.FrutaDTO;
import org.quarkus.api.model.Fruta;
import org.quarkus.api.model.IndentificadorTransacao;

import java.util.List;

@ApplicationScoped
public class FrutaService {

    @Inject
    IndentificadorTransacao indentificadorTransacao;

    public List<Fruta> list(){
        System.out.println(indentificadorTransacao.getIndentificadorTransacao());
        return Fruta.listAll();
    }

    @Transactional
    public void novaFruta(FrutaDTO  frutaDTO){
        System.out.println(indentificadorTransacao.getIndentificadorTransacao());
        Fruta fruta = new Fruta();
        fruta.setNome(frutaDTO.getNome());
        fruta.setQtd(frutaDTO.getQtd());
        fruta.persist();

    }
}
