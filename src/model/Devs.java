package model;

import java.util.Random;

import javax.swing.ImageIcon;

public class Devs {

	public int posicaoX;
	public int posicaoY;
	public ImageIcon imagem;
	public Plano plano;
	Random random = new Random();

	public Devs(Plano plano) {

		this.posicaoX = random.nextInt(15) + 1;
		this.posicaoY = random.nextInt(15) + 1;
		this.plano = plano;
		this.imagem = new ImageIcon("C:\\Users\\enzov\\eclipse-workspace\\ProvaFinal\\src\\icons\\dev.png");

		int index = random.nextInt(plano.listaCélulas.size());
		Célula célula = plano.listaCélulas.get(index);

		while (célula.planetas != null || célula.devs != null || célula.bugs != null || (célula.posiçãoX == 8 && célula.posiçãoY == 8)) {
			index = random.nextInt(plano.listaCélulas.size());
			célula = plano.listaCélulas.get(index);
		}
		célula.devs = this;
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
