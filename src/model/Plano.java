package model;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;



public class Plano {
	public ArrayList<Célula> listaCélulas;
	public List<Planeta> planetas = new ArrayList<>();

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
		atualizarPlanetas(planetas,listaCélulas);
	}

	public void atualizarPlanetas(List<Planeta> planetas, List<Célula> listaCélulas) {
		for (Célula célula : listaCélulas) {
	        célula.label.setIcon(null);
	    }
		for (Planeta planeta : planetas) {
			for (int i = 0; i < listaCélulas.size(); i++) {
				 if (listaCélulas.get(i).getPosiçãoX() == planeta.getX()
						&& listaCélulas.get(i).getPosiçãoY() == planeta.getY()) {
					listaCélulas.get(i).label.setIcon(planeta.getImagem());
				}
			}
		}
	}
}
