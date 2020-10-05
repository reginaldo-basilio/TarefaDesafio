package Logica;

import java.util.List;

import Entidades.Pontos;

public class GerenciadoraPontos {
	public Pontos obterNovaPontuacao(List<Pontos> pontos, int pontosInseridos) {
		Pontos novaPontuacao = new Pontos();
		Pontos p = pontos.get(pontos.size()-1);
		if(pontosInseridos < p.getMinTemp()) {
			novaPontuacao.setPlacar(pontosInseridos);
			novaPontuacao.setMinTemp(pontosInseridos);
			novaPontuacao.setMaxTemp(p.getMaxTemp());
			novaPontuacao.setRecMin(p.getRecMin()+1);
			novaPontuacao.setRecMax(p.getRecMax());
			
		}else if(pontosInseridos > p.getMaxTemp()) {
			novaPontuacao.setPlacar(pontosInseridos);
			novaPontuacao.setMinTemp(p.getMinTemp());
			novaPontuacao.setMaxTemp(pontosInseridos);
			novaPontuacao.setRecMin(p.getRecMin());
			novaPontuacao.setRecMax(p.getRecMax()+1);
		}else {
			novaPontuacao.setPlacar(pontosInseridos);
			novaPontuacao.setMinTemp(p.getMinTemp());
			novaPontuacao.setMaxTemp(p.getMaxTemp());
			novaPontuacao.setRecMin(p.getRecMin());
			novaPontuacao.setRecMax(p.getRecMax());
		}
		return novaPontuacao;
	}
}