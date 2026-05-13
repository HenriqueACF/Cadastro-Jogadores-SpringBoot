package br.con.henriqueacf.cadastro_jogadores.repository;

import br.con.henriqueacf.cadastro_jogadores.web.CodinomeDTO;


public interface CodinomeRepository {
    CodinomeDTO buscarCodinomes() throws Exception;
}
