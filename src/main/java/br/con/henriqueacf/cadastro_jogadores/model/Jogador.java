package br.con.henriqueacf.cadastro_jogadores.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record Jogador(
        @NotBlank String nome,
        @NotBlank @Email String email,
        String telefone,
        String codinome,
        GrupoCodinome grupoCodinome) {
}
