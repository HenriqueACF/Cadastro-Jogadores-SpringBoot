package br.con.henriqueacf.cadastro_jogadores.repository;

import java.util.List;

public interface CodinomeRepository {
    List<String> buscarCodinomes() throws Exception;
}
