package view;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import model.Plano;

public class PainelFundo extends JPanel {

	private PainelJavaLar painelJavaLar;

	public PainelFundo(PainelJavaLar painelJavaLar) {
		this.painelJavaLar = painelJavaLar;

		ImageIcon imagem = new ImageIcon("C:\\Users\\enzov\\eclipse-workspace\\ProvaFinal\\src\\icons\\bomdia.gif");
		JLabel imagemLucas = new JLabel(imagem);
		imagemLucas.setAlignmentX(CENTER_ALIGNMENT);

		this.setBackground(Color.BLACK);

		LayoutManager overlay = new OverlayLayout(this);
		this.setLayout(overlay);
		this.add(painelJavaLar);
		this.add(imagemLucas);

	}
}
