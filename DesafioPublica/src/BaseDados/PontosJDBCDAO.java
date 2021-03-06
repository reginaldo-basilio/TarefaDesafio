package BaseDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entidades.Pontos;

public class PontosJDBCDAO implements PontosDAO{

private JDBCUtil banco;
	
	public PontosJDBCDAO() {
		banco = new JDBCUtil();
	}

	@Override
	public int salvar(Pontos pontos) {
		String sql = "insert into pontuacao (placar, minTemp, maxTemp, recMin, recMax) values (?, ?, ?, ?, ?);";		
		PreparedStatement ps;
		try {
			ps = banco.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);	
			ps.setInt(1, pontos.getPlacar());
			ps.setInt(2, pontos.getMinTemp());
			ps.setInt(3, pontos.getMaxTemp());
			ps.setInt(4, pontos.getRecMin());
			ps.setInt(5, pontos.getRecMax());
			ps.execute();
			ResultSet generatedKeys = ps.getGeneratedKeys();
	        generatedKeys.next();
	        int retornarID = generatedKeys.getInt(1);
	        return retornarID;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;	
		
	}

	@Override
	public ResultSet listar() {
		ArrayList<Pontos> notas = new ArrayList<Pontos>();
		String sql = "select id as 'Jogo', placar as Placar, minTemp as 'Mínimo na temporada', maxTemp as 'Máximo na temporada', recMin as 'Recorde Mínimo', recMax as 'Recorde Máximo' from pontuacao;";
		try {
			Statement st = banco.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Pontos> listaPontos() {
		ArrayList<Pontos> pontos = new ArrayList<Pontos>();
		String sql = "select * from pontuacao;";
		try {
			Statement st = banco.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Pontos ponto = new Pontos();
				ponto.setId(rs.getInt(1));
				ponto.setPlacar(rs.getInt(2));
				ponto.setMinTemp(rs.getInt(3));
				ponto.setMaxTemp(rs.getInt(4));
				ponto.setRecMin(rs.getInt(5));
				ponto.setRecMax(rs.getInt(6));
				pontos.add(ponto);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return pontos;
	}
	
}
