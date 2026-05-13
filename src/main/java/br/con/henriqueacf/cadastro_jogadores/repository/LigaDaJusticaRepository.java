package br.con.henriqueacf.cadastro_jogadores.repository;

import br.con.henriqueacf.cadastro_jogadores.model.GrupoCodinome;
import br.con.henriqueacf.cadastro_jogadores.web.CodinomeDTO;
import br.con.henriqueacf.cadastro_jogadores.web.LigaDaJusticaDTO;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.util.List;
@Repository
public class LigaDaJusticaRepository implements CodinomeRepository{
    @Override
    public CodinomeDTO buscarCodinomes() throws Exception {
        var codinomes =  RestClient.builder()
                .baseUrl(GrupoCodinome.LIGA_DA_JUSTICA.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);

        var xmlMapper = new XmlMapper();
        var ligaDaJustica = xmlMapper.readValue(codinomes, LigaDaJusticaDTO.class);
        return ligaDaJustica;
    }
}
