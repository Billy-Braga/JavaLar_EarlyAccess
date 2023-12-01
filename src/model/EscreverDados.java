package model;

import java.io.FileWriter;

public class EscreverDados {

	public void escreverDados(String file, String mensagem) {
		try {
			FileWriter arquivo = new FileWriter(file, true);
			arquivo.write(mensagem);
			arquivo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
