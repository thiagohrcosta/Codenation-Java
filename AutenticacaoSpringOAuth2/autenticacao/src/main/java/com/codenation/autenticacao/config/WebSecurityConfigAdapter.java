package com.codenation.autenticacao.config;

import com.codenation.autenticacao.dto.UsuarioCustomDTO;
import com.codenation.autenticacao.model.Usuario;
import com.codenation.autenticacao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception{
        return authenticationManagerBean();
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UsuarioRepository usuarioRepository) throws Exception {
        if (usuarioRepository.count() == 0) {
            Usuario usuario = new Usuario();
            usuario.setLogin("admin");
            usuario.setSenha("admin");
            usuarioRepository.save(usuario);
        }

        builder.userDetailsService(login -> new UsuarioCustomDTO(usuarioRepository.findByLogin(login)));
    }

}
