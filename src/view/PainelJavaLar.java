package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Célula;
import model.Plano;

public class PainelJavaLar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Plano p;

	public PainelJavaLar(Plano plano) {
		
		this.p=plano;
		this.setLayout(new GridLayout(15, 15));
		this.setBackground(new Color(29, 33, 36));
		this.setPreferredSize(new Dimension(675, 675));
		this.setMaximumSize(new Dimension(675, 675));
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setAlignmentY(CENTER_ALIGNMENT);
		this.setBorder(BorderFactory.createLineBorder(new Color(109, 142, 180), 1, true));
		
		criarPlano();
		
	}

	public void criarPlano() {
		for(int i=0; i<p.listaCélulas.size(); i++) {
			this.add(p.listaCélulas.get(i).label);
		}
	}
	
	public Plano getPlano(){
		return p;
	}
	public List<Célula> getListaCélulas() {
        return p.listaCélulas;
    }

	
}