package view;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class PainelFundo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PainelJavaLar painelJavaLar;

	public PainelFundo(PainelJavaLar painelJavaLar) {
		this.painelJavaLar = painelJavaLar;

		ImageIcon imagem = new ImageIcon("C:\\Users\\enzov\\eclipse-workspace\\ProvaFinal\\src\\view\\icones\\bomdia.gif");
		JLabel estrelas = new JLabel(imagem);
		estrelas.setAlignmentX(CENTER_ALIGNMENT);

		this.setBackground(Color.BLACK);

		LayoutManager overlay = new OverlayLayout(this);
		this.setLayout(overlay);
		this.add(painelJavaLar);
		this.add(estrelas);

	}
}
