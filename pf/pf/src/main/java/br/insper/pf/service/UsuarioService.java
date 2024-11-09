package br.insper.pf.service;

import br.insper.pf.classes.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioService {

    public Usuario getUsuario(String cpf) {
        RestTemplate restTemplate = new RestTemplate();
        Usuario usuario = restTemplate.getForEntity(
                "http://localhost:8080/usuario/" + cpf,
                Usuario.class).getBody();
        return usuario;
    }

}
