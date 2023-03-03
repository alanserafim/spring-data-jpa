package br.com.alura.spring.data;

import br.com.alura.spring.data.services.CargoService;
import br.com.alura.spring.data.services.FuncionarioService;
import br.com.alura.spring.data.services.RelatorioService;
import br.com.alura.spring.data.services.UnidadeTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	@Autowired
	private CargoService cargoService;
	@Autowired
	private RelatorioService relatoriosService;
	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private UnidadeTrabalhoService unidadeTrabalhoService;

	private Boolean system = true;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while(system){
			System.out.println("1 - Funcionario");
			System.out.println("2 - Cargo");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatorios");

			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					funcionarioService.inicial(scanner);
					break;
				case 2:
					cargoService.inicial(scanner);
					break;
				case 3:
					unidadeTrabalhoService.inicial(scanner);
					break;
				case 4:
					relatoriosService.inicial(scanner);
					break;
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}

	}

}
