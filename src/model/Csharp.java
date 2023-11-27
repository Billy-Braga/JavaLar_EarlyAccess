package model;

class Csharp extends Planeta {
	private int direcao;

	public Csharp(String nome, int x, int y, int movimento, double rotação, String caminhoImagem) {
		super("Csharp", 8, 3, 1, 4, caminhoImagem);
		direcao = 0;
		anoJavaLar = 0;

	}

	@Override
	public void mover() {
		
		int unidades = getInstantes() * getMovimento();

		for (int i = 0; i < unidades; i++) {
			if (direcao == 0) {
				x--;
				if (x == 3 && y == 3) {
					direcao = 1;
				}
			} else if (direcao == 1) {
				y++;
				if (x == 3 && y == 13) {
					direcao = 2;
				}
			} else if (direcao == 2) {
				x++;
				if (x == 13 && y == 13) {
					direcao = 3;
				}
			} else if (direcao == 3) {
				y--;
				if (x == 13 && y == 3) {
					direcao = 0;
				}
			}
			if (passouPelaCoordenada(8, 3)) {
				aumentarAnoPorRodada();
				aumentarAnosTotais();
			}
		}
	}

	@Override
	public void rotacionar() {
		double tempoDesdeUltimoInstante =   rotação * getInstantes();
		this.tempoDesdeUltimoInstante = tempoDesdeUltimoInstante;
		tempoRodado += tempoDesdeUltimoInstante;
	}
}
