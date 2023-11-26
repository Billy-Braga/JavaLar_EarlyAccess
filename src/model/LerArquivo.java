package model;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LerArquivo {

	private File arquivo;
	private List<String> instantes;

	private void selecionarArquivo() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivo CSV", "csv");
		fileChooser.setFileFilter(filtro);
		int resultado = fileChooser.showOpenDialog(null);
		if (resultado == fileChooser.APPROVE_OPTION) {
			arquivo = fileChooser.getSelectedFile();
			System.out.println("Arquivo selecionado: " + arquivo.getAbsolutePath());
		} else if (resultado == fileChooser.CANCEL_OPTION) {
			System.out.println("Operação cancelada pleo usuário");
		}
	}

	public void lerArquivo() {
		try {
			selecionarArquivo();
			if(arquivo!=null) {
			instantes = Files.readAllLines(arquivo.toPath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String[]> formatarArquivo() {
	    lerArquivo();
	    if (instantes != null) {
	        instantes.remove(0);
	        ArrayList<String[]> valores = new ArrayList<>();
	        for (String instante : instantes) {
	            String[] valoresInstantes = instante.split(",");
	            valores.add(valoresInstantes);
	        }
	        return valores;
	    } else {
	        // Tratar o caso em que instantes é null
	        return new ArrayList<>(); // Ou lançar uma exceção, dependendo da lógica desejada
	    }
	}
}
