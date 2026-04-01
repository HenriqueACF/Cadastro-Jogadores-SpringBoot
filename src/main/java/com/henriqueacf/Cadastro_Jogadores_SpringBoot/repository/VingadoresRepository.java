package com.henriqueacf.Cadastro_Jogadores_SpringBoot.repository;

import java.util.List;

public class VingadoresRepository implements CodinomeRepository{
    @Override
    public List<String> buscarCodinomes() {
        return List.of();
    }
}
