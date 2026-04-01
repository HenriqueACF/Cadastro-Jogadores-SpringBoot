package com.henriqueacf.Cadastro_Jogadores_SpringBoot.service;

import com.henriqueacf.Cadastro_Jogadores_SpringBoot.model.GrupoCodinome;
import com.henriqueacf.Cadastro_Jogadores_SpringBoot.repository.CodinomeRepository;
import com.henriqueacf.Cadastro_Jogadores_SpringBoot.repository.LigaDaJusticaRepository;
import com.henriqueacf.Cadastro_Jogadores_SpringBoot.repository.VingadoresRepository;
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

    public CodinomeRepository create(GrupoCodinome grupoCodinome) {
        return switch (grupoCodinome) {
            case LIGA_DA_JUSTIÇA -> ligaDaJusticaRepository;
            case VINGADORES -> vingadoresRepository;
        };
    }
}
