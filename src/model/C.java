package model;

class C extends Planeta {
	private int direcao;

	public C(String nome, int x, int y, int movimento, double rotação, String caminhoImagem) {
		super("C", 8, 1, 10, 0.1, caminhoImagem);
		direcao = 0;
		anoJavaLar = 0;

	}

	@Override
	public void mover() {
		
		int unidades = getInstantes() * getMovimento();

		for (int i = 0; i < unidades; i++) {
			if (direcao == 0) {
				x--;
				if (x == 1 && y == 1) {
					direcao = 1;
				}
			} else if (direcao == 1) {
				y++;
				if (x == 1 && y == 15) {
					direcao = 2;
				}
			} else if (direcao == 2) {
				x++;
				if (x == 15 && y == 15) {
					direcao = 3;
				}
			} else if (direcao == 3) {
				y--;
				if (x == 15 && y == 1) {
					direcao = 0;
				}
			}
			if (passouPelaCoordenada(8, 1)) {
				aumentarAnoPorRodada();
				aumentarAnosTotais();
			}
		}
	}

	@Override
	public void rotacionar() {
		double tempoDesdeUltimoInstante =  rotação * getInstantes();
		this.tempoDesdeUltimoInstante = tempoDesdeUltimoInstante;
		tempoRodado += tempoDesdeUltimoInstante;
	}
}
