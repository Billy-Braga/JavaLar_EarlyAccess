package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Planeta;
import model.Plano;
import view.PainelBotões;
import view.PainelJavaLar;

public class JavaLarDAO {

	private Conexão conexão;
	private PainelJavaLar painelJavaLar;
	private PainelBotões painelBotões;
	private ActionController actionController;
	private String combinacaoMaisRepetida;
	private int totalInstantes;
	private int somaDevsTotais;
	private int somaBugsTotais;
	private int somaAnosTotais;
	private double somaDiasTotais;

	public JavaLarDAO(Plano plano, List<Planeta> planetas, PainelJavaLar painelJavaLar,
			ActionController actionController) {
		this.painelJavaLar = painelJavaLar;
		this.painelBotões = painelBotões;
		this.actionController = actionController;
	}

	public void inserirDados(Plano plano, List<Planeta> planetas) {
		try {
			Connection conexao = new Conexão().getConexao();

			PreparedStatement insert = conexao.prepareStatement("INSERT INTO javalar (nome, matricula, nome_arquivo, "
					+ "bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, bug_cmais, bug_c, "
					+ "dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp, dev_cmais, dev_c, "
					+ "v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, "
					+ "d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c, "
					+ "a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, "
					+ "bug_q1, bug_q2, bug_q3, bug_q4, "
					+ "dev_q1, dev_q2, dev_q3, dev_q4) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			insert.setString(1, painelJavaLar.getPlano().getNome());
			insert.setString(2, painelJavaLar.getPlano().getMatricula() + "");
			insert.setString(3, actionController.getArquivo());

			int i = 4;
			for (Planeta planeta : planetas) {
				if (planeta.getNome().equals("Java") == false) {
					insert.setInt(i, planeta.getBugsColididos());
					i++;
				}
			}
			for (Planeta planeta : planetas) {
				if (planeta.getNome().equals("Java") == false) {
					insert.setInt(i, planeta.getDevsColididos());
					i++;
				}
			}
			for (Planeta planeta : planetas) {
				if (planeta.getNome().equals("Java") == false) {
					insert.setInt(i, (int) planeta.getMovimento());
					i++;
				}
			}
			for (Planeta planeta : planetas) {
				if (planeta.getNome().equals("Java") == false) {
					insert.setInt(i, (int) planeta.getTempoRodado());
					i++;
				}
			}
			for (Planeta planeta : planetas) {
				if (planeta.getNome().equals("Java") == false) {
					insert.setInt(i, planeta.getAnos());
					i++;
				}
			}
			insert.setInt(39, painelJavaLar.getPlano().getQuadranteBug1());
			insert.setInt(40, painelJavaLar.getPlano().getQuadranteBug2());
			insert.setInt(41, painelJavaLar.getPlano().getQuadranteBug3());
			insert.setInt(42, painelJavaLar.getPlano().getQuadranteBug4());
			insert.setInt(43, painelJavaLar.getPlano().getQuadranteDev1());
			insert.setInt(44, painelJavaLar.getPlano().getQuadranteDev2());
			insert.setInt(45, painelJavaLar.getPlano().getQuadranteDev3());
			insert.setInt(46, painelJavaLar.getPlano().getQuadranteDev4());

			insert.execute();
			conexao.close();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}

	}

	public void analisarDados() {
		try {
			Connection conexao = new Conexão().getConexao();
			String sql = "SELECT " + "CONCAT(nome, '|', matricula) AS combinacao, " + "COUNT(*) AS contagem, "
					+ "SUM(a_python + a_javascript + a_ruby + a_php + a_csharp + a_cmais + a_c) AS somaAnosTotais, "
					+ "SUM(dev_python + dev_javascript + dev_ruby + dev_php + dev_csharp + dev_cmais + dev_c) AS somaDevsTotais, "
					+ "SUM(bug_python + bug_javascript + bug_ruby + bug_php + bug_csharp + bug_cmais + bug_c) AS somaBugsTotais, "
					+ "SUM(d_python + d_javascript + d_ruby + d_php + d_csharp + d_cmais + d_c) AS somaDiasTotais "
					+ "FROM javalar GROUP BY combinacao ORDER BY contagem DESC LIMIT 1";

			PreparedStatement statement = conexao.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
			    combinacaoMaisRepetida = resultSet.getString("combinacao");
				somaDevsTotais = resultSet.getInt("somaDevsTotais");
				somaBugsTotais = resultSet.getInt("somaBugsTotais");
				somaAnosTotais = resultSet.getInt("somaAnosTotais");
				somaDiasTotais = resultSet.getDouble("somaDiasTotais");
			}

			conexao.close();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	public void gravarDados() {
		
		System.out.println("1) Campeão de análises: " + combinacaoMaisRepetida);
		System.out.println("2) Planeta que mais morreu: ");
		System.out.println("3) Planeta com mais vida: ");
		System.out.println("4) Quadrante com mais Bugs: ");
		System.out.println("5) Quadrante com mais Devs: ");
		System.out.println("6) Soma total de Instantes : ");
		System.out.println("7) Média de velocidade de cada planeta: ");
		System.out.println("8) Quantidade total de Devs: " + somaDevsTotais);
		System.out.println("9) Quantidade total de Bugs: " + somaBugsTotais);
		System.out.println("10) Soma total de Horas dos planetas: " + String.format("%.2f", somaDiasTotais / 24.0));
		System.out.println("11) Soma total de Anos dos planetas: " + somaAnosTotais);
	}
}
