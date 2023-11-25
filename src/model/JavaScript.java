package model;

import javax.swing.ImageIcon;

public class JavaScript extends Planeta {
	private int direcao;


	public JavaScript(String nome, int x, int y, int movimento, double rotação, String caminhoImagem) {
		super("JavaScript", 8, 6, 3, 10, caminhoImagem);
		direcao = 0;
		anoJavaLar = 0;

	}

	@Override
	public void mover() {
		
		int unidades = getInstantes() * movimento;
		
		for (int i = 0; i < unidades; i++) {
			if (direcao == 0) {
				x--;
				if (x == 6 && y == 6) {
					direcao = 1;
				}
			} else if (direcao == 1) {
				y++;
				if (x == 6 && y == 10) {
					direcao = 2;
				}
			} else if (direcao == 2) {
				x++;
				if (x == 10 && y == 10) {
					direcao = 3;
				}
			} else if (direcao == 3) {
				y--;
				if (x == 10 && y == 6) {
					direcao = 0;
				}
			}
			if (passouPelaCoordenada(8, 6)) {
				aumentarAnoPorRodada();
				aumentarAnosTotais();
			}
		}
	}


	@Override
	public void rotacionar() {
		double tempoDesdeUltimoInstante = rotação * getInstantes();
		this.tempoDesdeUltimoInstante = tempoDesdeUltimoInstante;
		tempoRodado += tempoDesdeUltimoInstante;
	}
}
