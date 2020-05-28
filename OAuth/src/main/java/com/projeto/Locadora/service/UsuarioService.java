package com.projeto.Locadora.service;

import com.projeto.Locadora.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private static List<Usuario> usuarios;

    public UsuarioService(){

        usuarios = new ArrayList<Usuario>();

        Usuario user1 = new Usuario();
        user1.setNome("Joao da Silva");
        user1.setIdade(40);
        user1.setClienteVip(Boolean.TRUE);

        usuarios.add(user1);

        Usuario user2 = new Usuario();
        user2.setNome("Ana Maria");
        user2.setIdade(30);
        user2.setClienteVip(Boolean.FALSE);

        usuarios.add(user2);
    }

    public static List<Usuario> listaDeUsuario(){
        return usuarios;
    }
}
