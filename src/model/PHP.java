package model;

class PHP extends Planeta {
	private int direcao;

	public PHP(String nome, int x, int y, int movimento, double rotação, String caminhoImagem) {
		super("PHP", 8, 4, 2, 60,caminhoImagem);
		direcao = 0;
		anoJavaLar=0;

	}

	@Override
	public void mover() {
		
		int unidades = getInstantes() * getMovimento();
		
		
		for (int i = 0; i < unidades; i++) {
			if (direcao == 0) {
				this.x--;
				if (x == 4 && y == 4) {
					direcao = 1;
				}
			} else if (direcao == 1) {
				this.y++;
				if (x == 4 && y == 12) {
					direcao = 2;
				}
			} else if (direcao == 2) {
				this.x++;
				if (x == 12 && y == 12) {
					direcao = 3;
				}
			} else if (direcao == 3) {
				this.y--;
				if (x == 12 && y == 4) {
					direcao = 0;
				}
			}
			if (passouPelaCoordenada(8, 4)) {
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
