package br.com.alura.spring.data.services;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioService {
    private Boolean system = true;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual acao de relatorio deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar funcionario por nome");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaFuncionarioNome(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void buscaFuncionarioNome(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar");
        String nome = scanner.next();
        List<Funcionario> list = funcionarioRepository.findByNome(nome);
        list.forEach(System.out::println);
    }

}
