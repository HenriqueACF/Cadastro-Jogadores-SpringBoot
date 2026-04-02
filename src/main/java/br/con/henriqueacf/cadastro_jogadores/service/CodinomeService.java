package br.con.henriqueacf.cadastro_jogadores.service;

import br.con.henriqueacf.cadastro_jogadores.model.GrupoCodinome;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodinomeService {
    private final CodinomeRepositoryFactory codinomeRepositoryFactory;

    public CodinomeService(CodinomeRepositoryFactory codinomeRepositoryFactory) {
        this.codinomeRepositoryFactory = codinomeRepositoryFactory;
    }


    public String gerarCodinome(GrupoCodinome grupoCodinome, List<String> codinomesEmUso){
        var codinomesDisponiveis = listarCodinomesDisponiveis(grupoCodinome, codinomesEmUso);
            if(codinomesDisponiveis.isEmpty())
               throw new Exception("Não há codinomes disponíveis para o grupo " + grupoCodinome.getNome());

            var codinomeSorteado = sortearCodinome(codinomesDisponiveis);
            return codinomeSorteado;
    }

    private List<String> listarCodinomesDisponiveis(GrupoCodinome grupoCodinome, List<String> codinomesEmUso) {
        var codinomes = buscarCodinomes(grupoCodinome);

        var codinomesDisponivies = codinomes
                .stream()
                .filter(codinome -> !codinomesEmUso.contains(codinome))
                .toList();

        return codinomesDisponivies;
    }

    private List<String> buscarCodinomes(GrupoCodinome grupoCodinome) {
        // FACTORY
        var codinomeRepository = codinomeRepositoryFactory.create(grupoCodinome);
    }
}
