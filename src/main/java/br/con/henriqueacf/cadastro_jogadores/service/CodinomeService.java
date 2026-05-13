package br.con.henriqueacf.cadastro_jogadores.service;

import br.con.henriqueacf.cadastro_jogadores.model.GrupoCodinome;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CodinomeService {
    private final CodinomeRepositoryFactory codinomeRepositoryFactory;

    public CodinomeService(CodinomeRepositoryFactory codinomeRepositoryFactory) {
        this.codinomeRepositoryFactory = codinomeRepositoryFactory;
    }


    public String gerarCodinome(GrupoCodinome grupoCodinome, List<String> codinomesEmUso) throws Exception{
        var codinomesDisponiveis = listarCodinomesDisponiveis(grupoCodinome, codinomesEmUso);
            if(codinomesDisponiveis.isEmpty())
               throw new Exception("Não há codinomes disponíveis para o grupo " + grupoCodinome.getNome());

            var codinomeSorteado = sortearCodinome(codinomesDisponiveis);
            return codinomeSorteado;
    }

    private List<String> listarCodinomesDisponiveis(GrupoCodinome grupoCodinome, List<String> codinomesEmUso)  throws Exception
    {
        var codinomes = buscarCodinomes(grupoCodinome);

        var codinomesDisponivies = codinomes
                .stream()
                .filter(codinome -> !codinomesEmUso.contains(codinome))
                .toList();

        return codinomesDisponivies;
    }

    private List<String> buscarCodinomes(GrupoCodinome grupoCodinome) throws Exception {
        // FACTORY
        var codinomeRepository = codinomeRepositoryFactory.create(grupoCodinome);
        return codinomeRepository.buscarCodinomes().getCodinomes();
    }

    private String sortearCodinome(List<String> codinomesDisponiveis){
        return codinomesDisponiveis.get((int)(Math.random() * codinomesDisponiveis.size()));
    }
}
