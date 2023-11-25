package model;

import javax.swing.ImageIcon;

class Cplusplus extends Planeta {
	private int direcao;

	public Cplusplus(String nome, int x, int y, int movimento, double rotação, String caminhoImagem) {
		super("Cplusplus", 8, 2, 2, 0.5,caminhoImagem);
		direcao = 0;
		anoJavaLar = 0;

	}

	@Override
	public void mover() {
		
		int unidades = getInstantes() * getMovimento();

		for (int i = 0; i <unidades; i++) {
			if (direcao == 0) {
				x--;
				if (x == 2 && y == 2) {
					direcao = 1;
				}
			} else if (direcao == 1) {
				y++;
				if (x == 2 && y == 14) {
					direcao = 2;
				}
			} else if (direcao == 2) {
				x++;
				if (x == 14 && y == 14) {
					direcao = 3;
				}
			} else if (direcao == 3) {
				y--;
				if (x == 14 && y == 2) {
					direcao = 0;
				}
			}
			if (passouPelaCoordenada(8, 2)) {
				aumentarAnoPorRodada();
				aumentarAnosTotais();
			}
		}
	}

	@Override
	public void rotacionar() {
		double tempoDesdeUltimoInstante =  rotação;
		this.tempoDesdeUltimoInstante = tempoDesdeUltimoInstante;
		tempoRodado += tempoDesdeUltimoInstante;
	}
}
