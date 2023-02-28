package br.com.alura.spring.data.repositories;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeTrabalhoRepository extends CrudRepository<Integer, UnidadeTrabalho> {

}
