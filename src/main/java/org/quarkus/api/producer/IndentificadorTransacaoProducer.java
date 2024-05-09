package org.quarkus.api.producer;

import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import org.quarkus.api.model.IndentificadorTransacao;

public class IndentificadorTransacaoProducer {

    @Produces
    @DefaultBean
    @RequestScoped
    public IndentificadorTransacao produce(){
        return new IndentificadorTransacao("");
    }
}
