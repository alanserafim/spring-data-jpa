package br.com.alura.spring.data.repositories;

import br.com.alura.spring.data.orm.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends CrudRepository <Integer, Funcionario> {

}
