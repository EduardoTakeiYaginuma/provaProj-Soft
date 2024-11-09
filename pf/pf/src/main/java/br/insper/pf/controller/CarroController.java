package br.insper.pf.controller;

import br.insper.pf.classes.Carro;
import br.insper.pf.classes.Usuario;
import br.insper.pf.repositorys.CarroRepository;
import br.insper.pf.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private CarroService carroService;

    @PostMapping
    public Carro criarCarro(Carro carro) {
        return carroService.criarCarro(carro);
    }
    @PostMapping
    public Carro associarCarroDono(@PathVariable String idCarro, @PathVariable String cpf) {
        return carroService.associarCarroDono(idCarro, cpf);
    }

    @GetMapping("/{id}")
    public List<Carro> listaCarros(@PathVariable String id) {
        return carroService.listaCarros(id);
    }


}
