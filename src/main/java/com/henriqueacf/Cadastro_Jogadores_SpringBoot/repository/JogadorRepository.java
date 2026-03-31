package com.henriqueacf.Cadastro_Jogadores_SpringBoot.repository;

import com.henriqueacf.Cadastro_Jogadores_SpringBoot.model.Jogador;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import static org.springframework.web.servlet.function.RequestPredicates.param;

@Repository
public class JogadorRepository {
    private final JdbcClient jddbcClient;

    public JogadorRepository(JdbcClient jddbcClient){
        this.jddbcClient = jddbcClient;
    }

    public Jogador salvar(Jogador jogador) {
        jddbcClient.sql("""
            INSERT INTO JOGADORES(nome, email, telefone, codinome, grupo_codinome)
            VALUES(:nome, :email, :telefone, :codinome, :grupoCodinome)
        """)
        .param("nome", jogador.nome())
        .param("email", jogador.email())
        .param("telefone", jogador.telefone())
        .param("codinome", jogador.codinome())
        .param("grupoCodinome", jogador.grupoCodinome())
        .update();

        return jogador;
    }

}
