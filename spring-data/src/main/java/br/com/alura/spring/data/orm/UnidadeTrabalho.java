package br.com.alura.spring.data.orm;

import javax.persistence.*;

@Entity
@Table(name = "unidade")
public class UnidadeTrabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private String Endereco;

}
