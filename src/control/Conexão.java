package control;

import java.sql.*;

public class Conexão {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	public Conexão() {

		this.host = "da_java.mysql.dbaas.com.br";//"127.0.0.1"; // localhost
		this.banco = "da_java";//"teste_bd";
		this.usuario = "da_java";//"root";
		this.senha = "Tecnicas*2023@";//"";
	}

	public Connection getConexao() {
		String url="jdbc:mysql://" + this.host + "/" + this.banco +"?verifyServerCertificate=false&useSSL=true";
		try {
			return DriverManager.getConnection(url, usuario, senha);
			
		} catch (SQLException ex) {
			System.out.println("Conex�o com MYSQL n�o realizada");
			ex.printStackTrace();
		}
		return null;
	}

}
