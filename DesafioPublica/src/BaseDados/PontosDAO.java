package BaseDados;

import java.sql.ResultSet;

public interface PontosDAO {

	public int salvar (Pontos pontos);   
	public ResultSet listar();
}
