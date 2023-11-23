package model;

import javax.swing.ImageIcon;

public class Python extends Planeta {
	private int direcao;

	public Python(String nome, int x, int y, int movimento, double rotação, String caminhoImagem) {
		super("Python", 8, 7, 4, 24,caminhoImagem);
		direcao = 0;

	}
	
	@Override
	public void mover(int movimento) {
	    for (int i = 0; i < movimento; i++) {
	        if (direcao == 0) {
	        	 setX(getX() - 1);
	            if (x == 7 && y == 7) {
	                direcao = 1;
	            }
	        } else if (direcao == 1) {
	        	setY(getY() + 1);
	            if (x == 7 && y == 9) {
	                direcao = 2;
	            }
	        } else if (direcao == 2) {
	        	setX(getX() + 1);
	            if (x == 9 && y == 9) {
	                direcao = 3;
	            }
	        } else if (direcao == 3) {
	        	setY(getY() - 1);
	            if (x == 9 && y == 7) {
	                direcao = 0;
	            }
	        }
	    }

//		if (passouPelaCoordenada(8, 9)) {
//			aumentarAnoPorRodada();
//			aumentarAnosTotais();
//		}
	}

	@Override
	public void rotacionar() {
		double tempoDesdeUltimoInstante = rotação;
		this.tempoDesdeUltimoInstante = tempoDesdeUltimoInstante;
		tempoRodado += tempoDesdeUltimoInstante;
	}

}
