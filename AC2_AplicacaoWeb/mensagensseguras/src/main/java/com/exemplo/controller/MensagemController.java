package com.exemplo.mensagensseguras.controller;

import com.exemplo.mensagensseguras.service.CryptoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MensagemController {

    private final CryptoService cryptoService;
    private final List<Mensagem> mensagens = new ArrayList<>(); 

    public MensagemController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/")
    public String listarMensagens(Model model) {
        model.addAttribute("mensagens", mensagens);
        return "index";
    }

    @PostMapping("/enviarMensagem")
    public String enviarMensagem(@RequestParam String texto) {
        try {
            String mensagemCriptografada = CriptoService.encrypt(texto);
            String mensagemDescriptografada = CriptoService.decrypt(mensagemCriptografada);
            mensagens.add(new Mensagem("mel", mensagemDescriptografada)); 
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return "redirect:/";
    }

    public static class Mensagem {
        private String remetente;
        private String texto;

        public Mensagem(String remetente, String texto) {
            this.remetente = remetente;
            this.texto = texto;
        }

        public String getRemetente() {
            return remetente;
        }

        public String getTexto() {
            return texto;
        }
    }
}