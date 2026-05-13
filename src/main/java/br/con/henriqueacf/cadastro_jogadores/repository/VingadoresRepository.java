package br.con.henriqueacf.cadastro_jogadores.repository;

import br.con.henriqueacf.cadastro_jogadores.model.GrupoCodinome;
import br.con.henriqueacf.cadastro_jogadores.web.CodinomeDTO;
import br.con.henriqueacf.cadastro_jogadores.web.VingadoresDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.ObjectMapper;


@Repository
public class VingadoresRepository implements CodinomeRepository{
    @Override
    public CodinomeDTO buscarCodinomes() throws Exception {
        var codinomes = RestClient
                .builder()
                .baseUrl(GrupoCodinome.VINGADORES.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);

        var objectMapper = new ObjectMapper();
        var vingadores  = objectMapper.readValue(codinomes, VingadoresDTO.class);

        return vingadores;
    }
}
