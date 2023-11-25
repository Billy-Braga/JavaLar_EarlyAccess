package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Planeta;
import model.Plano;

public class RelatórioDAO {

	private Conexão conexão;

	public RelatórioDAO(Plano plano, List<Planeta> planetas) {
	
			try {
				Connection conexao = new Conexão().getConexao();

				PreparedStatement insert = conexao
						.prepareStatement("INSERT INTO javalar (nome, matricula, nome_arquivo, "
								+ "bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, bug_cmais, bug_c, "
								+ "dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp, dev_cmais, dev_c, "
								+ "v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, "
								+ "d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c, "
								+ "a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, "
								+ "bug_q1, bug_q2, bug_q3, bug_q4, "
								+ "dev_q1, dev_q2, dev_q3, dev_q4) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
				
				
				insert.setString(1, plano.getNome());
				insert.setString(2, plano.getMatricula() + "");
				insert.setString(3, null);
				int i=4;
				
				for(Planeta planeta : planetas) {
					if(planeta.getNome().equals("Java")==false) {
						insert.setInt(i, planeta.getBugsColididos());
						i++;
					}
				}
				for(Planeta planeta : planetas) {
					if(planeta.getNome().equals("Java")==false) {
						insert.setInt(i, planeta.getDevsColididos());
						i++;
					}
				}
				for(Planeta planeta : planetas) {
					if(planeta.getNome().equals("Java")==false) {
						insert.setInt(i, (int) planeta.getMovimento());
						i++;
					}
				}
				for(Planeta planeta : planetas) {
					if(planeta.getNome().equals("Java")==false) {
						insert.setInt(i, (int) planeta.getTempoRodado());
						i++;
					}
				}
				for(Planeta planeta : planetas) {
					if(planeta.getNome().equals("Java")==false) {
						insert.setInt(i, planeta.getAnos());
						i++;
					}
				}
				insert.setInt(39, plano.getQuadranteBug1());
				insert.setInt(40, plano.getQuadranteBug2());
				insert.setInt(41, plano.getQuadranteBug3());
				insert.setInt(42, plano.getQuadranteBug4());
				insert.setInt(43, plano.getQuadranteDev1());
				insert.setInt(44, plano.getQuadranteDev2());
				insert.setInt(45, plano.getQuadranteDev3());
				insert.setInt(46, plano.getQuadranteDev4());
				
				
				
				insert.execute();
				conexao.close();
				
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
	}

