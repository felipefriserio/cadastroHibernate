package br.com.fiap.persistencia.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import br.com.fiap.persistencia.HibernateUtil;
import br.com.fiap.persistencia.interfaces.CrudPessoa;
import br.com.fiap.persistencia.model.Pessoa;

public class PessoaDAO implements CrudPessoa{
	private Session session;
	
	private Session getCurrentSession(){
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	public void insere(Pessoa pessoa) {
		this.session = getCurrentSession();
		session.beginTransaction();
		session.save(pessoa);
		session.getTransaction().commit();
	}
	
	public Pessoa busca(String cpf){
		this.session = getCurrentSession();
		session.beginTransaction();
		TypedQuery<Pessoa> query = session.createQuery("SELECT p FROM Pessoa p WHERE p.cpf = :cpf ", Pessoa.class);
		Pessoa pessoa = query.setParameter("cpf", cpf).getSingleResult();
		session.getTransaction().commit();
		return pessoa;
	}
	
	public void deleta(Pessoa pessoa) {
		this.session = getCurrentSession();
		session.beginTransaction();
		session.delete(session.merge(pessoa));
		session.getTransaction().commit();
	}

	public void atualiza(Pessoa pessoa) {
		this.session = getCurrentSession();
		session.beginTransaction();
		session.merge(pessoa);
		session.getTransaction().commit();
	}
}
