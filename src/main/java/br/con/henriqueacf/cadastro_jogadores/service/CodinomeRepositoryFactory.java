package br.con.henriqueacf.cadastro_jogadores.service;

import br.con.henriqueacf.cadastro_jogadores.model.GrupoCodinome;
import br.con.henriqueacf.cadastro_jogadores.repository.CodinomeRepository;
import br.con.henriqueacf.cadastro_jogadores.repository.LigaDaJusticaRepository;
import br.con.henriqueacf.cadastro_jogadores.repository.VingadoresRepository;
import org.springframework.stereotype.Component;

@Component
public class CodinomeRepositoryFactory {
    private final LigaDaJusticaRepository ligaDaJusticaRepository;
    private final VingadoresRepository vingadoresRepository;

    public CodinomeRepositoryFactory(LigaDaJusticaRepository ligaDaJusticaRepository,
                                     VingadoresRepository vingadoresRepository){
        this.ligaDaJusticaRepository = ligaDaJusticaRepository;
        this.vingadoresRepository = vingadoresRepository;
    }

    public CodinomeRepository create(GrupoCodinome grupoCodinome){
        return switch (grupoCodinome){
            case LIGA_DA_JUSTICA -> ligaDaJusticaRepository;
            case VINGADORES -> vingadoresRepository;
        };
    }

}
