package model;

import java.util.Random;

import javax.swing.ImageIcon;

public class Bugs {

	public int posicaoX;
	public int posicaoY;
	public ImageIcon imagem;
	public Plano plano;
	Random random = new Random();

	public Bugs(Plano plano) {

		this.posicaoX = random.nextInt(15) + 1;
		this.posicaoY = random.nextInt(15) + 1;
		this.plano = plano;
		this.imagem = new ImageIcon("C:\\Users\\enzov\\eclipse-workspace\\ProvaFinal\\src\\icons\\bug.png");

		int index = random.nextInt(plano.listaCélulas.size());
		Célula célula = plano.listaCélulas.get(index);

		while (célula.planetas != null || célula.devs != null || célula.bugs != null || (célula.posiçãoX == 8 && célula.posiçãoY == 8)) {
			index = random.nextInt(plano.listaCélulas.size());
			célula = plano.listaCélulas.get(index);
		}
		célula.bugs = this;
		célula.icon = this.imagem;
		célula.label.setIcon(célula.icon);
		
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

}
