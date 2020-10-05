package testes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import org.junit.Assert;

import Entidades.Pontos;
import Logica.GerenciadoraPontos;

public class GerenciadoraPontosTests {
	private List<Pontos> pontos;
	private GerenciadoraPontos gerenciadora;
	public GerenciadoraPontosTests() {
		gerenciadora = new GerenciadoraPontos();
		pontos = new ArrayList<Pontos>();
		pontos.add(new Pontos(10, 8, 10, 2, 3));
		pontos.add(new Pontos(7, 7, 10, 3, 3));
		pontos.add(new Pontos(14, 7, 14, 3, 4));
	}
	@Test
	public void atualizaMinTemporadaEMinRecorde() {
		//arrange
		int pontosInseridos = 5;
		Pontos ultimaRodada = pontos.get(pontos.size() -1);
		
		//action
		Pontos novaPontuacao = gerenciadora.obterNovaPontuacao(pontos, pontosInseridos);
		
		//assert
		Assert.assertTrue(novaPontuacao.getMinTemp()==pontosInseridos);
		Assert.assertTrue(novaPontuacao.getRecMin()==ultimaRodada.getRecMin()+1);
		Assert.assertTrue(novaPontuacao.getRecMax()==ultimaRodada.getRecMax());
		Assert.assertTrue(novaPontuacao.getMaxTemp()==ultimaRodada.getMaxTemp());
	}
	
	public void atualizaMaxTemporadaEMaxRecorde() {
		//arrange
		int pontosInseridos = 16;
		Pontos ultimaRodada = pontos.get(pontos.size() -1);
		
		//action
		Pontos novaPontuacao = gerenciadora.obterNovaPontuacao(pontos, pontosInseridos);
		
		//assert
		Assert.assertTrue(novaPontuacao.getMaxTemp()==pontosInseridos);
		Assert.assertTrue(novaPontuacao.getRecMax()==ultimaRodada.getRecMax()+1);
		Assert.assertTrue(novaPontuacao.getMinTemp()==ultimaRodada.getMinTemp());
		Assert.assertTrue(novaPontuacao.getRecMin()==ultimaRodada.getRecMin());
	}
}