package com.exemplo.mensagensseguras.service;

import org.springframework.stereotype.Service;

@Service
public class CriptoService {
    public String criptografar(String texto) {
        return new StringBuilder(texto).reverse().toString();
    }
}
