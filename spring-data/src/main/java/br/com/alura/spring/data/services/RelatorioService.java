package br.com.alura.spring.data.services;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioService {
    private Boolean system = true;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual acao de relatorio deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar funcionario por nome");
            System.out.println("2 - Buscar funcionario por nome, data contratacao e salario maior");
            System.out.println("3 - Buscar funcionario por data contratacao");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaFuncionarioNome(scanner);
                    break;
                case 2:
                    buscaFuncionarioNomeSalarioMaiorData(scanner);
                    break;
                case 3:
                    buscaFuncionarioDataContratacao(scanner);
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

    private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner){
        System.out.println("Qual nome deseja pesquisar");
        String nome = scanner.next();

        System.out.println("Qual data contratacao deseja pesquisar");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        System.out.println("Qual salario deseja pesquisar");
        Double salario = scanner.nextDouble();

        List<Funcionario> list = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
        list.forEach(System.out::println);
    }

    private void buscaFuncionarioDataContratacao(Scanner scanner){
        System.out.println("Qual data contratacao deseja pesquisar");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        List<Funcionario> list = funcionarioRepository.findDataContratacaoMaior(localDate);
        list.forEach(System.out::println);
    }

}
