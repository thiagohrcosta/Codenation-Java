package com.projeto.Locadora.controller;

import com.projeto.Locadora.model.Usuario;
import com.projeto.Locadora.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios/")
    public List<Usuario> usuarios(){
        return usuarioService.listaDeUsuario();
    }
}
