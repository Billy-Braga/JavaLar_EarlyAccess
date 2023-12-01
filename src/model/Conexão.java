package model;

import java.sql.*;

public class Conexão {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	public Conexão() {

		this.host = "da_java.mysql.dbaas.com.br";
		this.banco = "da_java";
		this.usuario = "da_java";
		this.senha = "Tecnicas*2023@";
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
