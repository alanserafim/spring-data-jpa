package br.com.alura.spring.data.services;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public void inicial(Scanner scanner){
        salvar(scanner);
    }

    private void salvar(Scanner scanner){
        System.out.println("Descricao do Cargo");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Salvo");
    }

}
