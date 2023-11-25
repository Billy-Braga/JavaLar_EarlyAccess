package model;

import javax.swing.ImageIcon;

class RubyonRails extends Planeta {
	private int direcao;

	public RubyonRails(String nome, int x, int y, int movimento, double rotação,  String caminhoImagem) {
		super("RubyOnRails", 8, 5, 2, 48,caminhoImagem);
		direcao = 0;
		anoJavaLar = 0;

	}

	@Override
	public void mover() {
		
		int unidades = getInstantes() * getMovimento();

		for (int i = 0; i < unidades; i++) {
			if (direcao == 0) {
				x--;
				if (x == 5 && y == 5) {
					direcao = 1;
				}
			} else if (direcao == 1) {
				y++;
				if (x == 5 && y == 11) {
					direcao = 2;
				}
			} else if (direcao == 2) {
				x++;
				if (x == 11 && y == 11) {
					direcao = 3;
				}
			} else if (direcao == 3) {
				y--;
				if (x == 11 && y == 5) {
					direcao = 0;
				}
			}
			if (passouPelaCoordenada(8, 5)) {
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
