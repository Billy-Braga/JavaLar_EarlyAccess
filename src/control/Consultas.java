package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas {
	private String combinacaoNomeMatricula;
	private int somaAnosTotais;
	private Conexão conexao;

	public Consultas(String combinacaoNomeMatricula, int somaAnosTotais) {
		this.combinacaoNomeMatricula = combinacaoNomeMatricula;
		this.somaAnosTotais = somaAnosTotais;
	}

	public String getCombinacaoMaisRepetida() {
		return combinacaoNomeMatricula;
	}

	public int getSomaAnosTotais() {
		return somaAnosTotais;
	}

	public Consultas AnalisarDados() {
		try {
			Connection conexao = new Conexão().getConexao();
			String sql = "SELECT " + "CONCAT(nome, '|', matricula) AS combinacao, " + "COUNT(*) AS contagem, "
					+ "SUM(a_python + a_javascript + a_ruby + a_php + a_sharp + a_cmais + a_c) AS somaAnosTotais "
					+ "FROM javalar GROUP BY combinacao ORDER BY contagem DESC LIMIT 1";

			PreparedStatement statement = conexao.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String combinacaoNomeMatricula = resultSet.getString("combinacao");
				int somaAnosTotais = resultSet.getInt("somaAnosTotais");

				System.out.println("Combinação mais repetida: " + combinacaoNomeMatricula);
				System.out.println("Soma total das velocidades dos planetas");

				resultSet.close();
				statement.close();
				conexao.close();

				return new Consultas(combinacaoNomeMatricula, somaAnosTotais);
			}

			conexao.close();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}
}