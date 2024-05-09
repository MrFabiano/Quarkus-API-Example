package org.quarkus.api.model;

import java.time.Instant;
import java.util.Random;

public class IndentificadorTransacao {

    String prefixo;
    int idTransacao;
    Instant incio;

    public IndentificadorTransacao(String prefixo) {
        this.prefixo = prefixo;
        this.idTransacao = new Random().nextInt();
        this.incio = Instant.now();
    }

    public String getIndentificadorTransacao() {
        return  prefixo + idTransacao + " - " + incio;
    }

}
