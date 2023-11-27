package control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;

import model.Planeta;
import model.Plano;
import view.PainelBotões;
import view.PainelFundo;
import view.PainelJavaLar;

public class JanelaJavaLar extends JFrame {

	static {
		try {
			String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
			UIManager.setLookAndFeel(str);
			UIManager.put("nimbusBase", Color.BLACK);
			UIManager.put("control", Color.BLACK);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private PainelBotões painelBotões;
	private PainelFundo painelFundo;
	private PainelJavaLar painelJavaLar;

	public JanelaJavaLar() {

		Plano plano = new Plano();
		List<Planeta> planetas = Planeta.criarPlanetas();

		this.painelJavaLar = new PainelJavaLar(plano);
		this.painelFundo = new PainelFundo(painelJavaLar);
		this.painelBotões = new PainelBotões(planetas, painelJavaLar);

		this.setTitle("O Grandioso Sistema JavaLar");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(940, 640);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(true);
		this.add(painelBotões, BorderLayout.EAST);
		this.add(painelFundo, BorderLayout.CENTER);
	}
}
