package model;

import javax.swing.ImageIcon;

public class Java extends Planeta{
	public Java(String nome, int x, int y, int movimento, double rotação, String caminhoImagem) {
		super("Java", 8, 8, 0, 0,caminhoImagem);
		
	}

	@Override
	public void mover(int movimento) {
	}

	@Override
	public void rotacionar() {
	}
}
