package br.insper.pf.service;

import br.insper.pf.classes.Carro;
import br.insper.pf.classes.Usuario;
import br.insper.pf.repositorys.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Carro criarCarro(Carro carro) {
        if (carro.getMarca() == null || carro.getModelo() == null || carro.getAno() == null) {
            throw new IllegalArgumentException("Marca, modelo e ano são obrigatórios");
        }
        if (carro.getAno() < 1900 || carro.getAno() > 2021) {
            throw new IllegalArgumentException("Ano inválido");
        }
        return carroRepository.save(carro);
    }

    public Carro associarCarroDono(String idCarro, String cpf) {
        Carro carro = carroRepository.findById(idCarro).get();
        Usuario usuario = usuarioService.getUsuario(cpf);
        if (carro == null) {
            throw new IllegalArgumentException("Carro não encontrado");
        }
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        carro.setDono(usuario);
        return carroRepository.save(carro);
    }

    public List<Carro> listaCarros(String id) {
        if (id != null) {
            Carro carro = carroRepository.findById(id).get();
            if (carro != null) {
                return carroRepository.findAll();
            } else {
                throw new IllegalArgumentException("Carro não encontrado");
            }
        }
        return carroRepository.findAll();
    }


}
