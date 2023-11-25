package model;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class Plano {
	public ArrayList<Célula> listaCélulas;
	public List<Planeta> planetas = new ArrayList<>();
	public ArrayList<Bugs> listaBugs = new ArrayList<>();
	public ArrayList<Devs> listaDevs = new ArrayList<>();
	public ArrayList<Planeta> falecidos= new ArrayList<>();

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
		planetas= Planeta.criarPlanetas();
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
				if (planeta.getX() == célula.getPosiçãoX() && planeta.getY() == célula.getPosiçãoY()) {
					célula.label.setIcon(planeta.getImagem());
				}
			}
		}
	}

	public void verificarColisãoBugs(List <Planeta> planetas, ArrayList<Bugs> bugsRemovidos) {
		for (Planeta planeta : planetas) {
			for (Bugs bug : listaBugs) {
				if (planeta.getX() == bug.getPosicaoX() && planeta.getY() == bug.getPosicaoY()) {
					planeta.diminuirMovimento();
					planeta.aumentarBugs();
					System.out.println("O planeta " + planeta.getNome() + " colidiu com um bug na posição " + "("
							+ planeta.getX() + "," + planeta.getY() + ")");
					bugsRemovidos.add(bug);
				}
			}
			listaBugs.removeAll(bugsRemovidos);
		}
		for (Bugs bugRemovido : bugsRemovidos) {
			System.out.println("Bug removido: " + bugRemovido.getPosicaoX() + ", " + bugRemovido.getPosicaoY());
		}
	}

	public void verificarColisãoDevs(List <Planeta> planetas,ArrayList<Devs> devsRemovidos) {
		for (Planeta planeta : planetas) {
			for (Devs dev : listaDevs) {
				if (planeta.getX() == dev.getPosicaoX() && planeta.getY() == dev.getPosicaoY()) {
					planeta.aumentarMovimento();
					planeta.aumentarDevs();
					System.out.println("O planeta " + planeta.getNome() + " colidiu com um dev na posição " + "("
							+ planeta.getX() + "," + planeta.getY() + ")");
					devsRemovidos.add(dev);
				}
			}
			listaDevs.removeAll(devsRemovidos);
		}

		for (Devs devRemovido : devsRemovidos) {
			System.out.println("Dev removido: " + devRemovido.getPosicaoX() + ", " + devRemovido.getPosicaoY());
		}
	}

	public void explodirPlanetas(List <Planeta> planetas, ArrayList<Planeta> falecidos) {
		for (Planeta planeta : planetas) {
			if (planeta.getMovimento() == 0 && !falecidos.contains(planeta)) {
				JLabel falecimento = new JLabel ("O Planeta " + planeta.getNome() + "Explodiu!");
				falecimento.setForeground(Color.WHITE);
				JOptionPane.showMessageDialog(null, falecimento, "Explosão 💀", JOptionPane.ERROR_MESSAGE);
				falecidos.add(planeta);
			}
		}
		planetas.removeAll(falecidos);
	}
	
	public void analisarQuadrantes() {
		for(Bugs bug : listaBugs) {
			if(bug.posicaoX>9) {
				
			}
		}
	}
}
