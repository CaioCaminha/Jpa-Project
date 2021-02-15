package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TesteRelacionamentoMovimentacaoCategoria {
	public static void main(String[] args) {
		
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Neg�cios");
		
		Conta conta = new Conta();
		//Quando � Long tem que passar o L ap�s o n�mero
		conta.setId(2L);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem � SP");
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal(600.0));
		movimentacao.setCategoria(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem � Fortal");
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal(700.0));
		movimentacao2.setCategoria(Arrays.asList(categoria, categoria2));
		movimentacao2.setConta(conta);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			em.persist(categoria);
			em.persist(categoria2);
			em.persist(movimentacao);
			em.persist(movimentacao2);
		em.getTransaction().commit();
		em.close();
		
		
		
	}
}
