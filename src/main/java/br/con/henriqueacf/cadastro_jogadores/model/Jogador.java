package br.con.henriqueacf.cadastro_jogadores.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record Jogador(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank String telefone,
        String codinome,
        @NotBlank GrupoCodinome grupoCodinome) {
}
