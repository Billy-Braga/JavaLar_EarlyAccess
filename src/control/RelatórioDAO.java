package control;

import java.sql.SQLException;
import java.util.ArrayList;
import control.Conexão;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RelatórioDAO {

	private Conexão conexão;

	public RelatórioDAO(ArrayList<String> Dados) {
		for (String string : Dados) {

			String[] saleParts = string.split(",");

			String nome = saleParts[0];
			int matricula = Integer.parseInt(saleParts[1]);
			String nomeAquivo = saleParts[2];
			int bug_python = Integer.parseInt(saleParts[3]);
			int bug_javascript = Integer.parseInt(saleParts[4]);
			int bug_ruby = Integer.parseInt(saleParts[5]);
			int bug_php = Integer.parseInt(saleParts[6]);
			int bug_csharp = Integer.parseInt(saleParts[7]);
			int bug_cmais = Integer.parseInt(saleParts[8]);
			int bug_c = Integer.parseInt(saleParts[9]);
			int dev_python = Integer.parseInt(saleParts[10]);
			int dev_javascript = Integer.parseInt(saleParts[11]);
			int dev_ruby = Integer.parseInt(saleParts[12]);
			int dev_php = Integer.parseInt(saleParts[13]);
			int dev_csharp = Integer.parseInt(saleParts[14]);
			int dev_cmais = Integer.parseInt(saleParts[15]);
			int dev_c = Integer.parseInt(saleParts[16]);
			double v_python = Double.parseDouble(saleParts[17]);
			double v_javascript = Double.parseDouble(saleParts[18]);
			double v_ruby = Double.parseDouble(saleParts[19]);
			double v_php = Double.parseDouble(saleParts[20]);
			double v_csharp = Double.parseDouble(saleParts[21]);
			double v_cmais = Double.parseDouble(saleParts[22]);
			double v_c = Double.parseDouble(saleParts[23]);
			double d_python = Double.parseDouble(saleParts[24]);
			double d_javascript = Double.parseDouble(saleParts[25]);
			double d_ruby = Double.parseDouble(saleParts[26]);
			double d_php = Double.parseDouble(saleParts[27]);
			double d_csharp = Double.parseDouble(saleParts[28]);
			double d_cmais = Double.parseDouble(saleParts[29]);
			double d_c = Double.parseDouble(saleParts[30]);
			double a_python = Double.parseDouble(saleParts[31]);
			double a_javascript = Double.parseDouble(saleParts[32]);
			double a_ruby = Double.parseDouble(saleParts[33]);
			double a_php = Double.parseDouble(saleParts[34]);
			double a_csharp = Double.parseDouble(saleParts[35]);
			double a_cmais = Double.parseDouble(saleParts[36]);
			double a_c = Double.parseDouble(saleParts[37]);
			int bugQ1 = Integer.parseInt(saleParts[38]);
			int bugQ2 = Integer.parseInt(saleParts[39]);
			int bugQ3 = Integer.parseInt(saleParts[40]);
			int bugQ4 = Integer.parseInt(saleParts[41]);
			int devQ1 = Integer.parseInt(saleParts[42]);
			int devQ2 = Integer.parseInt(saleParts[43]);
			int devQ3 = Integer.parseInt(saleParts[44]);
			int devQ4 = Integer.parseInt(saleParts[45]);

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
				insert.setString(1, nome);
				insert.setInt(2, matricula);
				insert.setString(3, nomeAquivo);
				insert.setInt(4, bug_python);
				insert.setInt(5, bug_javascript);
				insert.setInt(6, bug_ruby);
				insert.setInt(7, bug_php);
				insert.setInt(8, bug_csharp);
				insert.setInt(9, bug_cmais);
				insert.setInt(10, bug_c);
				insert.setInt(11, dev_python);
				insert.setInt(12, dev_javascript);
				insert.setInt(13, dev_ruby);
				insert.setInt(14, dev_php);
				insert.setInt(15, dev_csharp);
				insert.setInt(16, dev_cmais);
				insert.setInt(17, dev_c);
				insert.setDouble(18, v_python);
				insert.setDouble(19, v_javascript);
				insert.setDouble(20, v_ruby);
				insert.setDouble(21, v_php);
				insert.setDouble(22, v_csharp);
				insert.setDouble(23, v_cmais);
				insert.setDouble(24, v_c);
				insert.setDouble(25, d_python);
				insert.setDouble(26, d_javascript);
				insert.setDouble(27, d_ruby);
				insert.setDouble(28, d_php);
				insert.setDouble(29, d_csharp);
				insert.setDouble(30, d_cmais);
				insert.setDouble(31, d_c);
				insert.setDouble(32, a_python);
				insert.setDouble(33, a_javascript);
				insert.setDouble(34, a_ruby);
				insert.setDouble(35, a_php);
				insert.setDouble(36, a_csharp);
				insert.setDouble(37, a_cmais);
				insert.setDouble(38, a_c);
				insert.setInt(39, bugQ1);
				insert.setInt(40, bugQ2);
				insert.setInt(41, bugQ3);
				insert.setInt(42, bugQ4);
				insert.setInt(43, devQ1);
				insert.setInt(44, devQ2);
				insert.setInt(45, devQ3);
				insert.setInt(46, devQ4);
				insert.execute();
				conexao.close();
				
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
	}
}
