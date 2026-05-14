package br.con.henriqueacf.cadastro_jogadores.web;

import br.con.henriqueacf.cadastro_jogadores.exception.GrupoCodinomeIndisponivelException;
import br.con.henriqueacf.cadastro_jogadores.model.GrupoCodinome;
import br.con.henriqueacf.cadastro_jogadores.model.Jogador;
import br.con.henriqueacf.cadastro_jogadores.service.JogadorService;
import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public String paginaCadastroJogador(Model model){
        return getViewAndModel(model, new Jogador(null, null, null, null, null));
    }

    @PostMapping
    public String cadastrarJogador(@ModelAttribute @Valid Jogador jogador, BindingResult result, Model model) throws Exception {
        if(result.hasErrors()){
            return getViewAndModel(model, jogador);
        }
        try {
            jogadorService.registrarJogador(jogador);
            return "redirect:/listagem-jogadores";
        } catch (GrupoCodinomeIndisponivelException e) {
            result.rejectValue("grupoCodinome", "grupoCodinomeIndisponivel", e.getMessage());
            return getViewAndModel(model, jogador);
        }
    }
    private static @NonNull String getViewAndModel(Model model, Jogador jogador) {
        model.addAttribute("jogador", jogador);
        model.addAttribute("gruposCodinomes", GrupoCodinome.values());
        return "cadastro-jogador";
    }
}
