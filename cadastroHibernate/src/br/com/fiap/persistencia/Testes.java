package br.com.fiap.persistencia;

import java.sql.SQLException;

import br.com.fiap.persistencia.dao.PessoaDAO;
import br.com.fiap.persistencia.model.Pessoa;

public class Testes {

	public static void main(String[] args) throws SQLException {
		String cpf = Math.random()+"";
		Pessoa pessoa = new Pessoa(cpf, "Mario", 40);
	    
	    // testa insert
	    System.out.println("--------- INSERT ---------");
	    new PessoaDAO().insere(pessoa);
	    
	    //testa select
	    System.out.println("--------- SELECT ---------");
	    System.out.println(new PessoaDAO().busca(cpf));
	    
	    //testa update
	    System.out.println("--------- UPDATE ---------");
	    pessoa.setNome("Luigi");
	    new PessoaDAO().atualiza(pessoa);
	    System.out.println(new PessoaDAO().busca(cpf));
	    
	    //testa delete
	    System.out.println("--------- DELETE ---------");
	    new PessoaDAO().deleta(pessoa);
	    System.out.println(new PessoaDAO().busca(cpf));
	    
	}
}
