package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DadosRelatório;
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
	private int planetaZikado;
	private int planetaIluminado;
	private int mediaPython;
	private int mediaJavaScript;
	private int mediaRuby;
	private int mediaPHP;
	private int mediaCsharp;
	private int mediaCplusplus;
	private int mediaC;
	private int maiorQuadranteBugs;
	private int maiorQuadranteDevs;
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

	public ArrayList<DadosRelatório> selecionarDados(){
		ArrayList<DadosRelatório> dadosRelatório = new ArrayList<DadosRelatório>();
		String indices[] = formatarString().split(", ");
		String [] informacoes = new String[indices.length];
		
		try {
			Connection conexao = new Conexão().getConexao();

			String query = "select * from javalar order by id desc";
			ResultSet dados = conexao.prepareStatement(query).executeQuery();

			while (dados.next()) {
				String nome = dados.getString("nome");
				int matricula = dados.getInt("matricula");
				String nome_arquivo	= dados.getString("nome_arquivo");
				
				for(int i=0;i<indices.length-1;i++) {
				informacoes[i] = dados.getString(indices[i]);
				}
				informacoes[indices.length-1] = dados.getString("dev_q4");

				DadosRelatório dr = new DadosRelatório(nome, matricula, nome_arquivo, informacoes);
				dadosRelatório.add(dr);
			}
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dadosRelatório;
	}
	
	
	public void escreverDados(ArrayList<DadosRelatório> dadosRelatório) {
	    EscreverDados e = new EscreverDados();
	    StringBuilder stringBuilder = new StringBuilder();

	    for (DadosRelatório dr : dadosRelatório) {
	        stringBuilder.append(dr.toString());
	    }

	    e.escreverDados("C:/Users/enzov/Downloads/Dados/dadosFinais.txt", stringBuilder.toString());
	}
	

	private String formatarString() {
		
		String[] nomePlanetas = new String[7];
		nomePlanetas[0] = "python";
		nomePlanetas[1] = "javascript";
		nomePlanetas[2] = "ruby";
		nomePlanetas[3] = "php";
		nomePlanetas[4] = "csharp";
		nomePlanetas[5] = "cmais";
		nomePlanetas[6] = "c";

		String[] nomeAux = new String[5];
		nomeAux[0] = "bug_";
		nomeAux[1] = "dev_";
		nomeAux[2] = "v_";
		nomeAux[3] = "d_";
		nomeAux[4] = "a_";
		String stringDados ="";
		
		for (int i = 0; i < nomeAux.length; i++) {
			for (int j = 0; j < nomePlanetas.length; j++) {
				stringDados += nomeAux[i] + nomePlanetas[j] + ", ";
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 4; j++) {

				stringDados += nomeAux[i] + "q" + j;

				if (i == 1 && j == 4)
					stringDados += " ";
				else
					stringDados += ", ";
			}
		}
		
		return stringDados;
	}
}
