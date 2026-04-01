package br.con.henriqueacf.cadastro_jogadores.model;

public record Jogador(
        String nome,
        String email,
        String telefone,
        String codinome,
        GrupoCodinome grupoCodinome) {
}
