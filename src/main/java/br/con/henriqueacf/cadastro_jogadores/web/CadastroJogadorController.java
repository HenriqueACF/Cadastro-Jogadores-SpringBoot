package br.con.henriqueacf.cadastro_jogadores.web;

import br.con.henriqueacf.cadastro_jogadores.model.Jogador;
import br.con.henriqueacf.cadastro_jogadores.service.JogadorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cadastro-jogador")
public class CadastroJogadorController {
    private final JogadorService jogadorService;

    public CadastroJogadorController(JogadorService jogadorService){
        this.jogadorService = jogadorService;
    }

    @PostMapping
    public String cadastrarJogador(@ModelAttribute Jogador jogador){
        try{
            jogadorService.registrarJogador(jogador);
            return "redirect:/cadastro-jogador";
        } catch (Exception e){
            return "redirect:/cadastro-jogador";
        }

    }
}
