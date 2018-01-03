package br.com.fiap.persistencia.interfaces;

import br.com.fiap.persistencia.model.Pessoa;

public interface CrudPessoa {
	public void insere(Pessoa p) ;
	public Pessoa busca(String cpf);
	public void deleta (Pessoa p);
	public void atualiza (Pessoa p);
}
