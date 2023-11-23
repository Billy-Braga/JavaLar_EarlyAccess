package model;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;


public class Plano {
	public ArrayList<Célula> listaCélulas;
	public List<Planeta> planetas = new ArrayList<>();
	public List<Bugs> listaBugs = new ArrayList<>();
	public List<Bugs> bugsRemovidos = new ArrayList<>();
	public List<Devs> listaDevs = new ArrayList<>();

	public Plano() {

		Border borda = BorderFactory.createLineBorder(new Color(67, 87, 110));
		listaCélulas = new ArrayList<Célula>();

		for (int i = 1; i <= 15; i++) {
			for (int j = 1; j <= 15; j++) {
				JLabel celulaLabel = new JLabel();
				celulaLabel.setPreferredSize(new Dimension(40, 40));
				celulaLabel.setHorizontalAlignment(JLabel.CENTER);
				celulaLabel.setBorder(borda);

				Célula celula = new Célula(j, i, celulaLabel);
				listaCélulas.add(celula);
			}
		}
		planetas = Planeta.criarPlanetas(this);
		atualizarPlano(planetas, listaCélulas);
	}

	public void atualizarPlano(List<Planeta> planetas, List<Célula> listaCélulas) {
		for (Célula célula : listaCélulas) {
			célula.label.setIcon(null);
		}
		for (Bugs bug : listaBugs) {
			for (Célula célula : listaCélulas) {
				if (bug != null && bug.getPosicaoX() == célula.getPosiçãoX()
						&& bug.getPosicaoY() == célula.getPosiçãoY()) {
					célula.label.setIcon(bug.imagem);

				}
			}
		}
		for (Devs dev : listaDevs) {
			for (Célula célula : listaCélulas) {
				if (dev != null && dev.getPosicaoX() == célula.getPosiçãoX()
						&& dev.getPosicaoY() == célula.getPosiçãoY()) {
					célula.label.setIcon(dev.imagem);
				}
			}
		}
		for (Planeta planeta : planetas) {
			for (Célula célula : listaCélulas) {
				if (planeta.getX()==célula.getPosiçãoX() && planeta.getY()== célula.getPosiçãoY()) {
					célula.label.setIcon(planeta.getImagem());
				}
			}
		}
	}

	public void verificarColisãoBugs(List<Bugs> bugsRemovidos) {
		for (Planeta planeta : planetas) {
			for (Bugs bug : listaBugs) {
				if (planeta.getX() == bug.getPosicaoX() && planeta.getY() == bug.getPosicaoY()) {
					planeta.aumentarMovimento();
					planeta.aumentarBugs();
					System.out.println("O planeta " + planeta.getNome() + " colidiu com um bug na posição " + "("
							+ planeta.getX() + "," + planeta.getY() + ")");
					bugsRemovidos.add(bug);
				}
			}
			listaBugs.removeAll(bugsRemovidos);
		}

	}

	public void verificarColisãoDevs(List<Devs> devsRemovidos) {
		for (Planeta planeta : planetas) {
			for (Devs dev : listaDevs) {
				if (planeta.getX() == dev.getPosicaoX() && planeta.getY() == dev.getPosicaoY()) {
					planeta.aumentarMovimento();
					planeta.aumentarBugs();
					System.out.println("O planeta " + planeta.getNome() + " colidiu com um dev na posição " + "("
							+ planeta.getX() + "," + planeta.getY() + ")");
					devsRemovidos.add(dev);
				}
			}
			listaDevs.removeAll(devsRemovidos);
		}
	}
	
	public void explodirPlanetas() {
		for (Planeta planeta : planetas) {
			if (planeta.getMovimento() == 0) {
				for (Célula célula : listaCélulas) {

				}
			}
		}
	}
}
