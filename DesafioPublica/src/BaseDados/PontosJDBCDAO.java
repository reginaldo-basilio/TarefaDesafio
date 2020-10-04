package BaseDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PontosJDBCDAO implements PontosDAO{

private JDBCUtil banco;
	
	public PontosJDBCDAO() {
		banco = new JDBCUtil();
	}

	@Override
	public int salvar(Pontos pontos) {
		String sql = "insert into anotacao (placar, minTemp, maxTemp, recMin, recMax) values (?, ?, ?, ?, ?);";		
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

//	@Override
//	public void remover(Anotacao pontos) {
//		String sql = "delete from anotacao where id = ?";
//		PreparedStatement ps;
//		try {
//			ps = banco.getConnection().prepareStatement(sql);
//			ps.setInt(1, pontos.getId());
//			ps.execute();			
//		}
//		catch (Exception e) {			 
//			 e.printStackTrace();
//		}		
//	}
//
//	@Override
//	public void atualizar(Anotacao anotacao) {
//		String sql = "update anotacao set titulo = ?, descricao = ? where id = ?";
//		PreparedStatement ps;
//		try {
//			ps = banco.getConnection().prepareStatement(sql);
//			ps.setString(1, anotacao.getTitulo());
//			ps.setString(2, anotacao.getDescricao());
//			ps.setInt(3, anotacao.getId());
//			ps.execute();			
//		}
//		catch (Exception e) {			 
//			 e.printStackTrace();
//		}		
//	}
//	
//	@Override
//	public List<Anotacao> listar() {
//		ArrayList<Anotacao> notas = new ArrayList<Anotacao>();
//		String sql = "select * from pais;";
//		try {
//			Statement st = banco.getConnection().createStatement();
//			ResultSet rs = st.executeQuery(sql);
//			while(rs.next()) {
//				Anotacao nota = new Anotacao();
//				nota.setId(rs.getInt(1));
//				nota.setTitulo(rs.getString(2));
//				nota.setDescricao(rs.getString(3));
//				notas.add(nota);
//			}
//		} catch (SQLException e) {			
//			e.printStackTrace();
//		}
//		return notas;
//	}

	
}
