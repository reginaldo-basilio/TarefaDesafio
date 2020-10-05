package BaseDados;

import java.sql.ResultSet;
import java.util.List;

import Entidades.Pontos;

public interface PontosDAO {

	public int salvar (Pontos pontos);   
	public ResultSet listar();
	public List<Pontos> listaPontos();
}
