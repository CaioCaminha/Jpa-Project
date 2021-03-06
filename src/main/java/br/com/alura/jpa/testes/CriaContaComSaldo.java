package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Mariana Chaves");
		conta.setAgencia(12345);
		conta.setNumero(54321);
		conta.setSaldo(9000.0);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
	}
}
